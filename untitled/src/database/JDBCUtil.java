package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;
        try {
            // Đăng ký Mysql  Driver với DriverManagement (Register Mysql JDBC driver with DriverManager)
            com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
//            Class.forName("com.jdbc.mysql.Driver");
            // Đường link server
            // String url = "jdbc:mySQL://<server>:<port>/<database>?<props>";
            String url = "jdbc:mySQL://localhost:3306/furama_query";
            // user name
            String username = "root";
            // password
            String password = "pemosepemose123!@#";
            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductVersion());
                System.out.println(mtdt.getDatabaseProductName());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
