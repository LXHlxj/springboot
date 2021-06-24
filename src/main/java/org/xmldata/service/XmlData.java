package org.xmldata.service;

import org.dom4j.DocumentException;

import java.sql.*;

public interface XmlData {
    PreparedStatement getXmlDataPreparedStatement(String sql) throws DocumentException, SQLException;
    Statement getXmlDataStatement() throws DocumentException, SQLException;
    ResultSet getXmlDataStatemenResultSet(Statement s,String sql) throws SQLException;
    ResultSet getXmlDataPreparedStatementResultSet(PreparedStatement p,String sql) throws SQLException;
}
