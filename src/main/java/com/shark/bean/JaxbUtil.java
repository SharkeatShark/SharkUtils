package com.shark.bean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Bean与xml 转换工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-25-17:41
 * @projectName SharkUtils
 * @packageName com.shark.bean
 */
public class JaxbUtil {
    /**
     * Bean转换成xml
     * 默认编码UTF-8
     * @param obj   转换类
     * @return  String
     */
    public static String beanToXml(Object obj) {
        return beanToXml(obj, "UTF-8");
    }

    /**
     * Bean转换成xml
     * @param obj   转换类
     * @param encoding  字符编码
     * @return  String
     */
    public static String beanToXml(Object obj, String encoding) {
        String result = null;
        try (StringWriter writer = new StringWriter()){
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * xml转换成Bean
     *  @param xml 字符
     *  @param c   转换类
     *  @return <T> T
     * 例：
     *  @XmlAccessorType(XmlAccessType.FIELD)
     *  @XmlRootElement(name = "ContractRoot") // xml中的元素
     *  public class ContractRoot {
     *      @XmlElement(name="TcpCont") private TcpCont tcpCont;
     *      @XmlElement(name="SvcCont") private SvcCont svcCont;
     *      public TcpCont getTcpCont() {
     *      return tcpCont;
     *      }
     *      public void setTcpCont(TcpCont tcpCont) {
     *      this.tcpCont = tcpCont;
     *      }
     *      public SvcCont getSvcCont() {
     *      return svcCont;
     *      }
     *      public void setSvcCont(SvcCont svcCont) {
     *      this.svcCont = svcCont;
     *      }
     * }
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, Class<T> c) {
        T t = null;
        try (StringReader stringReader = new StringReader(xml)) {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(stringReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
