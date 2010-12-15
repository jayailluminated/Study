package jjseo.test.jpa.dao;


import jjseo.test.DataSetsJpa;
import jjseo.test.jpa.AbstractJpaDbUnitELTemplateTestCaseJUnit44;
import jjseo.test.jpa.ELFunctionMapperImpl;
import jjseo.test.jpa.model.User;

import org.junit.Before;
import org.junit.Test;

import static jjseo.test.jpa.EntitiesHelper.assertUser;
import static jjseo.test.jpa.EntitiesHelper.assertUserWithTelephone;
import static jjseo.test.jpa.EntitiesHelper.assertUserWithTelephones;
import static jjseo.test.jpa.EntitiesHelper.newUser;
import static jjseo.test.jpa.EntitiesHelper.newUserWithTelephone;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class UserDaoJpaImplTest extends AbstractJpaDbUnitELTemplateTestCaseJUnit44 {

    UserDaoJpaImpl dao;

    @Before
    public void prepareDao() {
        dao = new UserDaoJpaImpl();
        dao.setEntityManager(em);
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user.xml")
    public void testGetUserById() throws Exception {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class);

        log.debug("selected ID is : "+ id);

        User user = dao.getUserById(id);

        log.debug("selected USER is : "+ user);

        commitTransaction();
        assertUser(user);
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user.xml")
    public void testGetUserByIdUnknowId() throws Exception {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class) * 2;
        User user = dao.getUserById(id);
        commitTransaction();
        assertNull(user);
    }

    @Test
    @DataSetsJpa(assertDataSet = "/jpa/user.xml")
    public void testAddUser() throws Exception {
        beginTransaction();
        User user = newUser();
        dao.addUser(user);
        commitTransaction();
        long id = user.getId();
        assertTrue(id > 0);
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user.xml", assertDataSet = "/jpa/empty.xml")
    public void testDeleteUser() throws Exception {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class);
        dao.deleteUser(id);
        commitTransaction();
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user-with-telephone.xml")
    public void testGetUserByIdWithTelephone() throws Exception {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class);
        User user = dao.getUserById(id);
        // commitTransaction();
        commitTransaction(true);
        assertUserWithTelephone(user);
    }

    @Test
    @DataSetsJpa(assertDataSet = "/jpa/user-with-telephone.xml")
    public void testAddUserWithTelephone() throws Exception {
        beginTransaction();
        User user = newUserWithTelephone();
        dao.addUser(user);
        commitTransaction();
        long id = user.getId();
        assertTrue(id > 0);
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user-with-telephone.xml", assertDataSet = "/jpa/empty.xml")
    public void testDeleteUserWithTelephone() throws Exception {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class);
        dao.deleteUser(id);
        commitTransaction();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullUser() throws Exception {
        dao.addUser(null);
    }

    @Test
    public void testGetUserByIdOnNullDatabase() throws Exception {
        getUserReturnsNullTest(0);
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user.xml")
    public void testGetUserByIdUnknownId() throws Exception {
        getUserReturnsNullTest(666);
    }

    private void getUserReturnsNullTest(int deltaId) {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class) + deltaId;
        User user = dao.getUserById(id);
        commitTransaction(true);
        assertNull(user);
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user-with-telephones.xml")
    public void testGetUserByIdWithTelephones() throws Exception {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class);
        User user = dao.getUserById(id);
        commitTransaction(true);
        assertUserWithTelephones(user);
    }

}
