package org.xmldata;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmldata.mode.TableName;
import org.xmldata.mode.XmlDataSource;
import org.xmldata.service.XmlData;
import org.xmldata.service.impl.XmlDataImpl;
import org.xmldata.service.xmldataesultSethandle.XmlDataResultSetHandle;
import org.xmldata.service.xmldataesultSethandle.impl.XmlDataResultSetHandleImpl;

import java.io.File;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.locks.*;

import org.xmldata.util.XmlDataUtil;
public class Boot {
    static int anInt=0;
   static List<String>list=new ArrayList<String>();
  public static Integer integer=0;
  public static Logger logger= LoggerFactory.getLogger(Boot.class);
 static Lock lock=new ReentrantLock();
 static  Condition condition=lock.newCondition();
    static Condition condition1=lock.newCondition();
    public static void main(String[] args) throws DocumentException, SQLException {
    Map<String,Map<String,Object>>map= XmlDataUtil.getXmltable("xmldata.xml");
    XmlDataResultSetHandle xml=new XmlDataResultSetHandleImpl("xmldata.xml");
    xml.list("",
     (HashMap<String, Map<String, Object>>) map,"李");
    lock.lock();
    }
  public static void deletallepng(File f){
        //list.add(f.getPath());
    if(f!=null){
      File[]fl= f.listFiles();
      if(fl!=null&&fl.length>0){
        for(int i=0;i<fl.length;i++){
          if(fl[i].isFile()){
            //System.out.println(fl[i].getPath());
              list.add(f.getPath());
          }
          else{
            deletallepng(fl[i]);
          }
        }
      }

    }


  }
  public static void paglist(List<?> list,Integer number,Integer size){
      List<?>list1=list;
    for (int i =(integer=number); i <size ; i++) {
      System.out.println(list1.get(i));
    }
    integer=integer+number;
  }
}
