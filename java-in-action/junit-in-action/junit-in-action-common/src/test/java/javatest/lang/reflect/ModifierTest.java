package javatest.lang.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ModifierTest {

    private Method staticMethod;
    private Method abtractMethod;

    @Before
    public void setUp() throws SecurityException, NoSuchMethodException {
        staticMethod = T.class.getMethod("staticMethod");
    }

    @Test
    public void isStatic() {
        int modifiers = staticMethod.getModifiers();
        assertTrue(Modifier.isStatic(modifiers));
    }


    @Test
    public void isPublic() {
        int modifiers = A.class.getModifiers();
        assertTrue(Modifier.isAbstract(modifiers));
    }


    static class T {
        public static String staticMethod() {
            return "";
        }
    }

    abstract class A {
        abstract String abstractMethod();
    }


}
