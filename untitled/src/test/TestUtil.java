package test;

import database.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUtil {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        JDBCUtil.printInfo(connection);
        JDBCUtil.closeConnection(connection);

    }
    public static  Connection connection = JDBCUtil.getConnection();
    public static ResultSet getAll(){
        try {
            Statement st = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
