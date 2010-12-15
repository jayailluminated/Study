package jjseo.test.jpa.dao;

import jjseo.test.jpa.model.User;

public interface UserDao {

    void addUser(User user);

    User getUserById(long id);

    void deleteUser(long id);

}
