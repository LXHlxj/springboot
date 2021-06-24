package org.xmldata.service.xmldataesultSethandle;

import org.dom4j.DocumentException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface XmlDataResultSetHandle {
    List<Object>list(String sql, HashMap<String,Map<String,Object>>mapmapper,String tablename) throws SQLException, DocumentException;
    List<Object>list(String sql, HashMap<String,Map<String,Object>>mapmapper,String tablename,String...par) throws SQLException, DocumentException;

}
