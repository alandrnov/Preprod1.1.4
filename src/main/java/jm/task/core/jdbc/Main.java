package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbs";
    private  static final String USERNAME = "root";
    private static final String PASSWORD = "javajava";

    public static void main(String[] args) {



        UserService u1 = new UserServiceImpl();

        u1.createUsersTable();

        u1.saveUser("Leo", "Tolstoy", (byte) 82);
        u1.saveUser("Kto", "Pros", (byte) 20);
        u1.saveUser("Antonio", "Band", (byte) 55);
        u1.saveUser("Luc", "Ivanov", (byte) 45);

        System.out.println(u1.getAllUsers());

        u1.cleanUsersTable();

        u1.dropUsersTable();

    }
}
