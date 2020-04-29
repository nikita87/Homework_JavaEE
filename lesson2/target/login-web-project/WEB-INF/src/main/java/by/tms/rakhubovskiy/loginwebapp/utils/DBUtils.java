package by.tms.rakhubovskiy.loginwebapp.utils;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;

public class DBUtils {

    public static final String url = "jdbc:mysql://localhost:3306/login_db?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
    public static final String user = "nikita";
    public static final String password = "1916";

    private final static ArrayBlockingQueue<Connection> connections = new ArrayBlockingQueue<>(5);

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 5; i++) {
                try {
                    connections.add(getConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection connection() {
        return connections.peek();
    }

    public static void returnConnection(Connection connect) {
        connections.offer(connect);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}






