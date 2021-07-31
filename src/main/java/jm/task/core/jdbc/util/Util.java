package jm.task.core.jdbc.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.hibernate.cfg.Environment;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import jm.task.core.jdbc.model.User;
import org.hibernate.service.*;



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

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydbs");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS,"javajava");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                if (sessionFactory != null) {
                    System.out.println("Сессия открыта " + sessionFactory.isOpen());
                }
            } catch (Exception e) {
                System.out.println("Нет подключения");
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
