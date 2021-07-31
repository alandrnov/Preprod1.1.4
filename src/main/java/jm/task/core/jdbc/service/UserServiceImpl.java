package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        try {
        userDao.createUsersTable();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            userDao.dropUsersTable();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> userList = userDao.getAllUsers();
        return userList;
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
