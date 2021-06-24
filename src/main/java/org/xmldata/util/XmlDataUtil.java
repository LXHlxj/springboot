package org.xmldata.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmldata.mode.XmlDataSource;
import org.xmldata.service.XmlData;
import org.xmldata.service.impl.XmlDataImpl;

import java.util.*;

public class XmlDataUtil {
  private XmlDataUtil(){

    }
    public static Logger logger= LoggerFactory.getLogger(XmlDataUtil.class);
    public static Map<String,Map<String,Object>> getXmltable(String xmlconfig) throws DocumentException {
        if (xmlconfig!=null&&!xmlconfig.equals("")){
            Map<String,Map<String,Object>>map=new LinkedHashMap<String, Map<String,Object>>();
            SAXReader saxReader=new SAXReader();
            Document readDocument = saxReader.read(XmlDataUtil.class.getResource("/").getFile() + "/"+xmlconfig);
            Element element= readDocument.getRootElement();
            List<Element> elements= element.elements("tablename");
            for (int i = 0; i <elements.size() ;i++) {
                if (elements.get(i).attribute("name").getValue()!=null&&!elements.get(i).attribute("name").getValue().equals("")) {
                    List<Element> lina = elements.get(i).elements("line");
                    Map<String,Object>map1=new LinkedHashMap<String, Object>();
                    for (int j=0; j < lina.size(); j++) {
                        map1.put(lina.get(j).attribute("name").getValue(),lina.get(j).getStringValue());
                    }
                    map.put(elements.get(i).attribute("name").getValue(),map1);
                }
            }
            return map;
        }
        return null;
    }
   public static XmlDataSource getXmlDataSource(String xmlconfigname) throws DocumentException {
       logger.debug("init datasource config!");
       SAXReader saxReader = new SAXReader();
       Document readDocument = saxReader.read(XmlDataUtil.class.getResource("/").getFile() + "/"+xmlconfigname);
       if (readDocument != null) {
           Element element = readDocument.getRootElement();
           XmlDataSource xmlDataSource = new XmlDataSource();
           logger.debug("create xmlDataSource={}", xmlDataSource);
           xmlDataSource.setDtattype(element.attribute("name").getValue());
           logger.debug("xmlDataSource.getDtattype={}", xmlDataSource.getDtattype());
          Element element1=  element.element("xmldata");
          List<Element>list= element1.elements();
          xmlDataSource.setUrl( list.get(0).getText());
          xmlDataSource.setUsername( list.get(1).getStringValue());
          xmlDataSource.setDriverClassName( list.get(2).getStringValue());
          xmlDataSource.setPassword( list.get(3).getStringValue());
          logger.debug("XmlDataSource={}",xmlDataSource);
           return xmlDataSource;
       }
       else {
           return null;
       }

   }
   public static XmlData getxmldata(String xmlconfig) throws DocumentException {
       if (xmlconfig!=null&&!xmlconfig.equals("")) {
           getXmlDataSource(xmlconfig);
           XmlData xmlData=new XmlDataImpl(xmlconfig);
           return xmlData;
       }
       else {
           return null;
       }
   }
}
