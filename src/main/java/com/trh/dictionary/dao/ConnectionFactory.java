package com.trh.dictionary.dao;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 * 数据库连接工厂类
 *
 * @author
 * @create 2019-08-28 16:28
 */
public class ConnectionFactory {

    public static Connection getConnection(String url,String userName,String passWord){
        Connection connection = null;
        //创建驱动
        try {
            Class.forName("org.gjt.mm.mysql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //创建连接
        try {
            connection = DriverManager.getConnection(url, userName, passWord);
            if (connection.isClosed()) {
                System.out.println("-------------------the connect is closed--------------");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 释放资源
     * @param connection 连接
     * @param preparedStatement
     * @param resultSet 结果集
     */
    public static void releaseResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,Statement statement){
        if(null != resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != statement){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != preparedStatement){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
