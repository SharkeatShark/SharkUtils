package com.shark.net;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 网络工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-03-28-16:24
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class NetUtil {

    public static final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
    public static final String REGX_IPB = REGX_IP + "\\-" + REGX_IP;

    /**
     * ip api网址
     */
    private static String URL = "net://apicloud.mob.com/ip/query?key=17de816376edc&ip=";
    /**
     * 获取真实 IP 地址
     * @param request   HttpServletRequest
     * @return  String
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * IP v4 转换为 容量为4的byte数组
     * @param ip    String ip
     * @return  byte[]
     */
    public static byte[] getIpByteArray(String ip) {
        byte[] ret = new byte[4];
        String[] st = ip.split("\\.");
        try {
            ret[0] = (byte)(Integer.parseInt(st[0]) & 0xFF);
            ret[1] = (byte)(Integer.parseInt(st[1]) & 0xFF);
            ret[2] = (byte)(Integer.parseInt(st[2]) & 0xFF);
            ret[3] = (byte)(Integer.parseInt(st[3]) & 0xFF);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * IP v4 数组 转为 字符串
     * @param ip byte[] ip
     * @return  String
     */
    public static String getIpString(byte[] ip) {
        StringBuffer sb = new StringBuffer();
        sb.append(ip[0] & 0xFF);
        sb.append('.');
        sb.append(ip[1] & 0xFF);
        sb.append('.');
        sb.append(ip[2] & 0xFF);
        sb.append('.');
        sb.append(ip[3] & 0xFF);
        return sb.toString();
    }

    /**
     * 判断IP是否在指定范围
     * @param ipSection ip段 例：192.168.1.1-192.168.1.10
     * @param ip    ip  例：192.168.3.54
     * @return  boolean ip是否在ip段中
     */
    public static boolean ipIsValid(String ipSection, String ip) {
        if (ipSection == null)
            throw new NullPointerException("IP段不能为空！");
        if (ip == null)
            throw new NullPointerException("IP不能为空！");
        ipSection = ipSection.trim();
        ip = ip.trim();
        if (!ipSection.matches(REGX_IPB) || !ip.matches(REGX_IP))
            return false;
        int idx = ipSection.indexOf('-');
        String[] sips = ipSection.substring(0, idx).split("\\.");
        String[] sipe = ipSection.substring(idx + 1).split("\\.");
        String[] sipt = ip.split("\\.");
        long ips = 0L, ipe = 0L, ipt = 0L;
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(sips[i]);
            ipe = ipe << 8 | Integer.parseInt(sipe[i]);
            ipt = ipt << 8 | Integer.parseInt(sipt[i]);
        }
        if (ips > ipe) {
            long t = ips;
            ips = ipe;
            ipe = t;
        }
        return ips <= ipt && ipt <= ipe;
    }

    /**
     * 获得 本机IP
     * @return  String
     */
    private static String getNativeIp() {
        String ipAddrStr = "";
        try {
            ipAddrStr = InetAddress.getLocalHost().getHostAddress();
            System.out.println(ipAddrStr);
        } catch (Exception e) {
            System.out.println("获取本地ip失败:{}" + e.toString());
        }
        return ipAddrStr;
    }

    /**
     * 获取 本机IP 多个硬件获取IP可以返回一个list
     * @return  Map<String,String>
     */
    public static Map<String,String> getLocalIpAddr() {
        Map map = new HashMap<String,String>();
        Enumeration<NetworkInterface> networks = null;
        try {
            //获取所有网卡设备
            networks = NetworkInterface.getNetworkInterfaces();
            if (networks == null) {
                //没有网卡设备 打印日志  返回null结束
                return null;
            }
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }
        InetAddress ip;
        Enumeration<InetAddress> addrs;
        // 遍历网卡设备
        while (networks.hasMoreElements()) {
            NetworkInterface ni = networks.nextElement();
            try {
                //过滤掉 loopback设备、虚拟网卡
                if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) {
                    continue;
                }
            } catch (SocketException e) {
                System.out.println(e.toString());
            }
            addrs = ni.getInetAddresses();
            if (addrs == null) {
                continue;
            }
            // 遍历InetAddress信息
            while (addrs.hasMoreElements()) {
                ip = addrs.nextElement();
                if (!ip.isLoopbackAddress() && ip.isSiteLocalAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    try {
                        Map mapTemp = new HashMap(3);
                        //Check if it's ipv6 address and reserved address
                        if (ip instanceof Inet6Address ) {
                            mapTemp.put("IPv6", ip.toString().split("/")[1]);
                        }else if (ip instanceof Inet4Address ){
                            mapTemp.put("IPv4", ip.toString().split("/")[1]);
                        }
                        mapTemp.put("Display", ni.getDisplayName());
                        mapTemp.put("HostName", ip.getHostName());
                        map.put(ni.getDisplayName(),mapTemp);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(e.toString());
                    }
                }
            }
        }
        map.forEach((k,v) -> System.out.println(k.toString() + "-------" + v.toString()));
        return map;
    }

    /**
     * 查询ip对应的 国家地址
     * @param ip
     * @param type city:城市 country：国家 province：省份
     * @return  {"msg":"success","result":{"country":"中国","province":"河南","city":"郑州","ip":"171.15.125.123"},"retCode":"200"}
     */
    public static String query(String ip,String type){
        JSONObject json = query(ip);
        json = JSONObject.parseObject(json.getString("result"));
        return json.getString(type);
    }

    /**
     * ip 所在地API
     * @param ip    ip
     * @return  JSONObject
     */
    private static JSONObject query(String ip){
        try {
            URL url = new URL(URL+ip);
            BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
            StringBuffer str = new StringBuffer();
            String buf = "";
            buf = read.readLine();
            while (buf != null && !buf.equals("")) {
                str.append(buf);
                buf = read.readLine();
            }
            return JSONObject.parseObject(str.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 传入需要连接的IP，返回是否连接成功
     * @param ip    ip
     * @return  boolean
     */
    public static boolean onLineCheckIp(String ip) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(ip);
            reachable = address.isReachable(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }

    /**
     * 网址是否通
     * @param httpUrl   网址
     * @return  boolean
     */
    public static boolean onLineCheckUrl(String httpUrl) {
        URL url = null;
        InputStream in = null;
        try {
            url = new URL(httpUrl);
            in = url.openStream();
            return true;
        } catch (IOException e) {
            return false;
        } finally{
            try {
                if(in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String ip = "171.15.125.123";
        byte[] ipByteArray = getIpByteArray(ip);
        String ipString = getIpString(ipByteArray);
        System.out.println(ipString);
        Long a = System.currentTimeMillis();
        System.out.println(NetUtil.query("171.15.125.123","city"));
        Long b = System.currentTimeMillis();
        
        System.out.println(b-a);
        System.out.println(onLineCheckIp("128.0.1.1"));
        System.out.println(onLineCheckUrl("http://www.baidu.com"));
    }

}
