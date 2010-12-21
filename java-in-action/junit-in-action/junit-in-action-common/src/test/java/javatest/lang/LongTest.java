package javatest.lang;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LongTest {


    @Test
    public void toHexString() {
        String l = "123";

        assertThat(Long.toHexString(Long.parseLong(l)), is("7b"));
    }


    @Test
    public void toStringHex() {
        String l = "7b";



        assertThat(Long.toString(Long.parseLong("7b", 16)), is("123"));
    }
}
