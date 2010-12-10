package jjseo.test.steroids.dao;

import jjseo.test.steroids.model.User;

public interface UserDao {

    void addUser(User user);

    User getUserById(long id);

    void deleteUser(long id);

}
