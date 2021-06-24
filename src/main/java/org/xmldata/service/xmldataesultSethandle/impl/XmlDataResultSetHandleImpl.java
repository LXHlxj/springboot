package org.xmldata.service.xmldataesultSethandle.impl;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmldata.mode.TableName;
import org.xmldata.service.XmlData;
import org.xmldata.service.impl.XmlDataImpl;
import org.xmldata.service.xmldataesultSethandle.XmlDataResultSetHandle;
import org.xmldata.util.XmlDataUtil;

import java.beans.beancontext.BeanContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class XmlDataResultSetHandleImpl implements XmlDataResultSetHandle {
    private String file;
    public XmlDataResultSetHandleImpl(String file) {
        this.file = file;
    }
    public static Logger logger= LoggerFactory.getLogger(XmlDataResultSetHandleImpl.class);
    public List<Object> list(String sql,HashMap<String,Map<String,Object>> mapmapper,String tablename) throws SQLException, DocumentException {
        XmlData xmlData = XmlDataUtil.getxmldata(file);
        PreparedStatement preparedStatement= xmlData.getXmlDataPreparedStatement(sql);
        List<Object>list=new ArrayList<Object>();
        ResultSet resultSet= xmlData.getXmlDataPreparedStatementResultSet(preparedStatement,sql);
        logger.debug("PreparedStatement------> {}",sql);
       while(resultSet.next()){
           Map<String,Object> map1=new HashMap<String, Object>();
           Map<String,Object> map2=mapmapper.get(tablename);
           Set<String> strings= map2.keySet();
           Iterator<String>s=strings.iterator();
           while (s.hasNext()){
               String s1=s.next();
               String s2=  resultSet.getString(Integer.valueOf(s1));
               map1.put(s1,s2);
           }
       list.add(map1);
       }
       logger.debug("ResultSet---------> {}",list);
        return list;
    }

    public List<Object> list(String sql, HashMap<String, Map<String, Object>> mapmapper, String tablename, String... par) throws SQLException, DocumentException {

        XmlData xmlData = XmlDataUtil.getxmldata(file);
        if (par.length == 0) {
          return  list(sql, mapmapper, tablename);
        }
        else {
            String[] pars = par;
            PreparedStatement preparedStatement = xmlData.getXmlDataPreparedStatement(sql);
            for (int i = 0; i < pars.length; i++) {
                preparedStatement.setString(i + 1, pars[i]);
                logger.debug("? " + (i + 1) + "={}", pars[i]);
            }
            String st = preparedStatement.toString();
            int ine = st.lastIndexOf(":");
            String s3 = st.substring(ine + 1, st.length());
            List<Object> list = new ArrayList<Object>();
            ResultSet resultSet = xmlData.getXmlDataPreparedStatementResultSet(preparedStatement, s3);
            logger.debug("PreparedStatement------> {}", sql);
            while (resultSet.next()) {
                Map<String, Object> map1 = new HashMap<String, Object>();
                Map<String, Object> map2 = mapmapper.get(tablename);
                Set<String> strings = map2.keySet();
                Iterator<String> s = strings.iterator();
                while (s.hasNext()) {
                    String s1 = s.next();
                    String s2 = resultSet.getString(Integer.valueOf(s1));
                    map1.put(s1, s2);
                }
                list.add(map1);
            }
            logger.debug("ResultSet---------> {}", list);
            return list;
        }
    }
}
