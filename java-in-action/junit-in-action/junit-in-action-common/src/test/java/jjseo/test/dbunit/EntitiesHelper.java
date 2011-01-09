package jjseo.test.dbunit;

import static org.junit.Assert.*;

public final class EntitiesHelper {
  
  public static final String USER_FIRST_NAME = "Jeffrey";
  public static final String USER_LAST_NAME = "Lebowsky";
  public static final String USER_USERNAME = "ElDuderino";

  private EntitiesHelper() {
    throw new UnsupportedOperationException("this class is a helper");
  }
  
  public static User newUser() {
    User user = new User();
    user.setFirstName(USER_FIRST_NAME);
    user.setLastName(USER_LAST_NAME);
    user.setUsername(USER_USERNAME);
    return user;
  }
  
  public static void assertUser(User user) {
    assertNotNull(user);
    assertEquals(USER_FIRST_NAME, user.getFirstName());
    assertEquals(USER_LAST_NAME, user.getLastName());
    assertEquals(USER_USERNAME, user.getUsername());
  }

}
