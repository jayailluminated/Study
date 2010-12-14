package jjseo.test.jpa.business;

import jjseo.test.jpa.dao.UserDao;
import jjseo.test.jpa.model.User;
import jjseo.test.jpa.model.UserDto;

import org.junit.Before;
import org.junit.Test;

import static jjseo.test.jpa.EntitiesHelper.assertUser;
import static jjseo.test.jpa.EntitiesHelper.newUserWithTelephones;
import static junit.framework.Assert.assertNull;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;


public class UserFacadeImplTest {

    private UserFacadeImpl facade;
    private UserDao dao;

    @Before
    public void setFixtures() {
        facade = new UserFacadeImpl();
        dao = createMock(UserDao.class);
        facade.setUserDao(dao);
    }

    @Test
    public void testGetUserByIdUnkownId() {
        int id = 666;
        expect(dao.getUserById(id)).andReturn(null);
        replay(dao);

        UserDto dto = facade.getUserById(id);
        assertNull(dto);
        // verify(dao); // not necessary
    }

    @Test
    public void testGetUserById() {
        int id = 666;
        User user = newUserWithTelephones();
        expect(dao.getUserById(id)).andReturn(user);
        replay(dao);

        UserDto dto = facade.getUserById(id);
        assertUser(dto);
        // verify(dao); // not necessary
    }

}
