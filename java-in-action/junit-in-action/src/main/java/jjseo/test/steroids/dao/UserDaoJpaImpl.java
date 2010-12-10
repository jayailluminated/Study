package jjseo.test.steroids.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jjseo.test.steroids.model.User;

public class UserDaoJpaImpl implements UserDao {

    private EntityManager entityManager;


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("user cannot be null");
        }
        entityManager.persist(user);
    }

    @Override
    public User getUserById(long id) {
        //if (false) {
            // option below does not fetch eagerly telephone
            return entityManager.find(User.class, id);
        //}
//        else {
//            String jql;
//            if (false) {
//                // option below creates more then one user when it has more than
//                // one telephone
//                jql = "select user from User user left join fetch user.telephones where id = ?";
//            } else {
//                jql = "select distinct(user) from User user left join fetch user.telephones where id = ?";
//            }
//            Query query = entityManager.createQuery(jql);
//            query.setParameter(1, id);
//            if (false) {
//                // option below makes negative tests to fail
//                return (User) query.getSingleResult();
//            } else {
//                @SuppressWarnings("unchecked")
//                List<User> users = query.getResultList();
//                assert users.size() <= 1 : "returned " + users.size()
//                        + " users"; // sanity check
//                return users.isEmpty() ? null : (User) users.get(0);
//            }
//        }
    }

    @Override
    public void deleteUser(long id) {
        // option below would not cascade-delete telephones
        //if (false) {
            String jql = "delete User where id = ?";
            Query query = entityManager.createQuery(jql);
            query.setParameter(1, id);
            query.executeUpdate();
        //}
//        else {
//            User user = entityManager.find(User.class, id);
//            entityManager.remove(user);
//        }
    }

}
