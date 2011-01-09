package jjseo.test.dbunit;


import jjseo.test.DataSetsDbUnit;

import org.junit.Test;

import static jjseo.test.dbunit.EntitiesHelper.assertUser;
import static jjseo.test.dbunit.EntitiesHelper.newUser;
import static org.junit.Assert.assertTrue;

public class UserDaoImplAnnotationsTest44 extends AbstractDbUnitTemplateTestCaseJUnit44 {

    @Test
    @DataSetsDbUnit(setUpDataSet = "/dbunit/user-token.xml")
    public void testGetUserById() throws Exception {
        User user = dao.getUserById(id);
        assertUser(user);
    }

    @Test
    @DataSetsDbUnit(assertDataSet = "/dbunit/user-token.xml")
    public void testAddUser() throws Exception {
        User user = newUser();
        id = dao.addUser(user);
        assertTrue(id > 0);
    }

}
