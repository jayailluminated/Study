package javatest.lang;

import javatest.lang.reflect.ModifierTest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ObjectTest {

    @Test
    public void getSimpleName() {
        assertThat(this.getClass().getSimpleName(), is("ObjectTest"));
        assertThat(new ModifierTest().getClass().getSimpleName(), is("ModifierTest"));
    }
}
