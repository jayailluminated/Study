package jjseo.test.jpa.business;

import jjseo.test.jpa.model.UserDto;

public interface UserFacade {
    UserDto getUserById(long id);
}
