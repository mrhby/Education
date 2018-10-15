package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.PreparedStatement;

public class getConnection {

    private static DataSource dataSource;

    static {
        System.setProperty("com.mchange.v2.c3p0.cfg.xml","classloader:/com/resource/c3p0-config.xml");
        dataSource = new ComboPooledDataSource("mysql");
    }

    public static Connection buildConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql, Object...obj){
        PreparedStatement preparedStatement = null;
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                for(int i=0;i<obj.length;i++){
                    preparedStatement.setObject(i+1,obj[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return preparedStatement;
    }

    public static ResultSet getResult(PreparedStatement preparedStatement){
        ResultSet resultSet= null;
        try {
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }  //查询

    public static int execute(PreparedStatement preparedStatement){
        int i=0;
        try {
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }  //非查询

    public static void close(Connection connection){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
