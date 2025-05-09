package dao;

import java.sql.*;

public class ConnectionFactory {
    private static Connection cnx;
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/bdiwm2024?useSSL=false";

    private ConnectionFactory() {}

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return cnx;
    }
}
