package test;

import database.JDBCUtil;

import java.sql.Connection;

public class TestUtil {
    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);
        JDBCUtil.printInfo(connection);
        JDBCUtil.closeConnection(connection);

    }
}
