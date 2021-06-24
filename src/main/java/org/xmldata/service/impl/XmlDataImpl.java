package org.xmldata.service.impl;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmldata.mode.XmlDataSource;
import org.xmldata.util.XmlDataUtil;

import java.sql.*;

public class XmlDataImpl extends AbstractXmlData {
    public static Logger logger= LoggerFactory.getLogger(XmlDataImpl.class);
    private String config;
    public XmlDataImpl(String config) {
        this.config = config;
    }

    public PreparedStatement getXmlDataPreparedStatement(String sql) throws DocumentException, SQLException {
        XmlDataSource xmlDataSource = XmlDataUtil.getXmlDataSource(config);
        Connection connection= DriverManager.getConnection(xmlDataSource.getUrl(),xmlDataSource.getUsername(),xmlDataSource.getPassword());
        logger.debug("databases links={}",connection);
        if (!sql.equals("")&&sql!=null){
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
           logger.debug("PreparedStatement={}",preparedStatement);
            return preparedStatement;
        }else
            return null;

    }

    public Statement getXmlDataStatement() throws DocumentException, SQLException {
        XmlDataSource xmlDataSource = XmlDataUtil.getXmlDataSource(config);
        Connection connection= DriverManager.getConnection(xmlDataSource.getUrl(),xmlDataSource.getUsername(),xmlDataSource.getPassword());
        logger.debug("databases links={}",connection);
            Statement statement=connection.createStatement();
        logger.debug(" Statement={}",statement);
            return statement;
    }

    public ResultSet getXmlDataStatemenResultSet(Statement s,String sql) throws SQLException {
        if (s!=null&&sql!=null&&!sql.equals("")){
            ResultSet resultSet=s.executeQuery(sql);
            logger.debug("ResultSet={}",resultSet);
            return resultSet;
        }
        return null;
    }

    public ResultSet getXmlDataPreparedStatementResultSet(PreparedStatement p,String sql) throws SQLException {
        if (p!=null&&sql!=null&&!sql.equals("")){
            ResultSet resultSet=p.executeQuery(sql);
            logger.debug("ResultSet={}",resultSet);
            return resultSet;
        }
        return null;
    }

}
