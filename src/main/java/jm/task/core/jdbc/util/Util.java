package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {


    private static final String URL = "jdbc:mysql://localhost:3306/mydbs";
    private  static final String USER = "root";
    private static final String PASSWORD = "javajava";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Соединение с БД не установлено");
            e.printStackTrace();
        }
        return connection;
    }
}
