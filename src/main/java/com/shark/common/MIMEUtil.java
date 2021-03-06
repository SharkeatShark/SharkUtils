package com.shark.common;

import java.util.HashMap;
import java.util.Map;

/**
 * MIME 类型 集合
 */
public class MIMEUtil {
	public static Map<String, String> typesMap = new HashMap<String, String>();

	static {
		typesMap.put("evy", "application/envoy");
		typesMap.put("fif", "application/fractals");
		typesMap.put("spl", "application/futuresplash");
		typesMap.put("hta", "application/hta");
		typesMap.put("acx", "application/internet-property-stream");
		typesMap.put("hqx", "application/mac-binhex40");
		typesMap.put("doc", "application/msword");
		typesMap.put("dot", "application/msword");
		typesMap.put("*", "application/octet-stream");
		typesMap.put("bin", "application/octet-stream");
		typesMap.put("class", "application/octet-stream");
		typesMap.put("dms", "application/octet-stream");
		typesMap.put("exe", "application/octet-stream");
		typesMap.put("lha", "application/octet-stream");
		typesMap.put("lzh", "application/octet-stream");
		typesMap.put("oda", "application/oda");
		typesMap.put("axs", "application/olescript");
		typesMap.put("pdf", "application/pdf");
		typesMap.put("prf", "application/pics-rules");
		typesMap.put("p10", "application/pkcs10");
		typesMap.put("crl", "application/pkix-crl");
		typesMap.put("ai", "application/postscript");
		typesMap.put("eps", "application/postscript");
		typesMap.put("ps", "application/postscript");
		typesMap.put("rtf", "application/rtf");
		typesMap.put("setpay", "application/set-payment-initiation");
		typesMap.put("setreg", "application/set-registration-initiation");
		typesMap.put("xla", "application/vnd.ms-excel");
		typesMap.put("xlc", "application/vnd.ms-excel");
		typesMap.put("xlm", "application/vnd.ms-excel");
		typesMap.put("xls", "application/vnd.ms-excel");
		typesMap.put("xlt", "application/vnd.ms-excel");
		typesMap.put("xlw", "application/vnd.ms-excel");
		typesMap.put("msg", "application/vnd.ms-outlook");
		typesMap.put("sst", "application/vnd.ms-pkicertstore");
		typesMap.put("cat", "application/vnd.ms-pkiseccat");
		typesMap.put("stl", "application/vnd.ms-pkistl");
		typesMap.put("pot", "application/vnd.ms-powerpoint");
		typesMap.put("pps", "application/vnd.ms-powerpoint");
		typesMap.put("ppt", "application/vnd.ms-powerpoint");
		typesMap.put("mpp", "application/vnd.ms-project");
		typesMap.put("wcm", "application/vnd.ms-works");
		typesMap.put("wdb", "application/vnd.ms-works");
		typesMap.put("wks", "application/vnd.ms-works");
		typesMap.put("wps", "application/vnd.ms-works");
		typesMap.put("hlp", "application/winhlp");
		typesMap.put("bcpio", "application/x-bcpio");
		typesMap.put("cdf", "application/x-cdf");
		typesMap.put("z", "application/x-compress");
		typesMap.put("tgz", "application/x-compressed");
		typesMap.put("cpio", "application/x-cpio");
		typesMap.put("csh", "application/x-csh");
		typesMap.put("dcr", "application/x-director");
		typesMap.put("dir", "application/x-director");
		typesMap.put("dxr", "application/x-director");
		typesMap.put("dvi", "application/x-dvi");
		typesMap.put("gtar", "application/x-gtar");
		typesMap.put("gz", "application/x-gzip");
		typesMap.put("hdf", "application/x-hdf");
		typesMap.put("ins", "application/x-internet-signup");
		typesMap.put("isp", "application/x-internet-signup");
		typesMap.put("iii", "application/x-iphone");
		typesMap.put("js", "application/x-javascript");
		typesMap.put("latex", "application/x-latex");
		typesMap.put("mdb", "application/x-msaccess");
		typesMap.put("crd", "application/x-mscardfile");
		typesMap.put("clp", "application/x-msclip");
		typesMap.put("dll", "application/x-msdownload");
		typesMap.put("m13", "application/x-msmediaview");
		typesMap.put("m14", "application/x-msmediaview");
		typesMap.put("mvb", "application/x-msmediaview");
		typesMap.put("wmf", "application/x-msmetafile");
		typesMap.put("mny", "application/x-msmoney");
		typesMap.put("pub", "application/x-mspublisher");
		typesMap.put("scd", "application/x-msschedule");
		typesMap.put("trm", "application/x-msterminal");
		typesMap.put("wri", "application/x-mswrite");
		typesMap.put("cdf", "application/x-netcdf");
		typesMap.put("nc", "application/x-netcdf");
		typesMap.put("pma", "application/x-perfmon");
		typesMap.put("pmc", "application/x-perfmon");
		typesMap.put("pml", "application/x-perfmon");
		typesMap.put("pmr", "application/x-perfmon");
		typesMap.put("pmw", "application/x-perfmon");
		typesMap.put("p12", "application/x-pkcs12");
		typesMap.put("pfx", "application/x-pkcs12");
		typesMap.put("p7b", "application/x-pkcs7-certificates");
		typesMap.put("spc", "application/x-pkcs7-certificates");
		typesMap.put("p7r", "application/x-pkcs7-certreqresp");
		typesMap.put("p7c", "application/x-pkcs7-mime");
		typesMap.put("p7m", "application/x-pkcs7-mime");
		typesMap.put("p7s", "application/x-pkcs7-signature");
		typesMap.put("sh", "application/x-sh");
		typesMap.put("shar", "application/x-shar");
		typesMap.put("swf", "application/x-shockwave-flash");
		typesMap.put("sit", "application/x-stuffit");
		typesMap.put("sv4cpio", "application/x-sv4cpio");
		typesMap.put("sv4crc", "application/x-sv4crc");
		typesMap.put("tar", "application/x-tar");
		typesMap.put("tcl", "application/x-tcl");
		typesMap.put("tex", "application/x-tex");
		typesMap.put("texi", "application/x-texinfo");
		typesMap.put("texinfo", "application/x-texinfo");
		typesMap.put("roff", "application/x-troff");
		typesMap.put("t", "application/x-troff");
		typesMap.put("tr", "application/x-troff");
		typesMap.put("man", "application/x-troff-man");
		typesMap.put("me", "application/x-troff-me");
		typesMap.put("ms", "application/x-troff-ms");
		typesMap.put("ustar", "application/x-ustar");
		typesMap.put("src", "application/x-wais-source");
		typesMap.put("cer", "application/x-x509-ca-cert");
		typesMap.put("crt", "application/x-x509-ca-cert");
		typesMap.put("der", "application/x-x509-ca-cert");
		typesMap.put("pko", "application/ynd.ms-pkipko");
		typesMap.put("zip", "application/zip");
		typesMap.put("au", "audio/basic");
		typesMap.put("snd", "audio/basic");
		typesMap.put("mid", "audio/mid");
		typesMap.put("rmi", "audio/mid");
		typesMap.put("mp3", "audio/mpeg");
		typesMap.put("aif", "audio/x-aiff");
		typesMap.put("aifc", "audio/x-aiff");
		typesMap.put("aiff", "audio/x-aiff");
		typesMap.put("m3u", "audio/x-mpegurl");
		typesMap.put("ra", "audio/x-pn-realaudio");
		typesMap.put("ram", "audio/x-pn-realaudio");
		typesMap.put("wav", "audio/x-wav");
		typesMap.put("bmp", "image/bmp");
		typesMap.put("cod", "image/cis-cod");
		typesMap.put("gif", "image/gif");
		typesMap.put("ief", "image/ief");
		typesMap.put("jpe", "image/jpeg");
		typesMap.put("jpeg", "image/jpeg");
		typesMap.put("jpg", "image/jpeg");
		typesMap.put("jfif", "image/pipeg");
		typesMap.put("svg", "image/svg+xml");
		typesMap.put("tif", "image/tiff");
		typesMap.put("tiff", "image/tiff");
		typesMap.put("ras", "image/x-cmu-raster");
		typesMap.put("cmx", "image/x-cmx");
		typesMap.put("ico", "image/x-icon");
		typesMap.put("pnm", "image/x-portable-anymap");
		typesMap.put("pbm", "image/x-portable-bitmap");
		typesMap.put("pgm", "image/x-portable-graymap");
		typesMap.put("ppm", "image/x-portable-pixmap");
		typesMap.put("rgb", "image/x-rgb");
		typesMap.put("xbm", "image/x-xbitmap");
		typesMap.put("xpm", "image/x-xpixmap");
		typesMap.put("xwd", "image/x-xwindowdump");
		typesMap.put("mht", "message/rfc822");
		typesMap.put("mhtml", "message/rfc822");
		typesMap.put("nws", "message/rfc822");
		typesMap.put("css", "text/css");
		typesMap.put("323", "text/h323");
		typesMap.put("htm", "text/html");
		typesMap.put("html", "text/html");
		typesMap.put("stm", "text/html");
		typesMap.put("uls", "text/iuls");
		typesMap.put("bas", "text/plain");
		typesMap.put("c", "text/plain");
		typesMap.put("h", "text/plain");
		typesMap.put("txt", "text/plain");
		typesMap.put("rtx", "text/richtext");
		typesMap.put("sct", "text/scriptlet");
		typesMap.put("tsv", "text/tab-separated-values");
		typesMap.put("htt", "text/webviewhtml");
		typesMap.put("htc", "text/x-component");
		typesMap.put("etx", "text/x-setext");
		typesMap.put("vcf", "text/x-vcard");
		typesMap.put("mp2", "video/mpeg");
		typesMap.put("mpa", "video/mpeg");
		typesMap.put("mpe", "video/mpeg");
		typesMap.put("mpeg", "video/mpeg");
		typesMap.put("mpg", "video/mpeg");
		typesMap.put("mpv2", "video/mpeg");
		typesMap.put("mov", "video/quicktime");
		typesMap.put("qt", "video/quicktime");
		typesMap.put("lsf", "video/x-la-asf");
		typesMap.put("lsx", "video/x-la-asf");
		typesMap.put("asf", "video/x-ms-asf");
		typesMap.put("asr", "video/x-ms-asf");
		typesMap.put("asx", "video/x-ms-asf");
		typesMap.put("avi", "video/x-msvideo");
		typesMap.put("movie", "video/x-sgi-movie");
		typesMap.put("flr", "x-world/x-vrml");
		typesMap.put("vrml", "x-world/x-vrml");
		typesMap.put("wrl", "x-world/x-vrml");
		typesMap.put("wrz", "x-world/x-vrml");
		typesMap.put("xaf", "x-world/x-vrml");
		typesMap.put("xof", "x-world/x-vrml");
	}
	
	public static String getType(String suffix){
		if(null!=typesMap.get(suffix.toLowerCase())){
			return typesMap.get(suffix.toLowerCase());
		}else{
			return "text/plain";
		}
	}
}
