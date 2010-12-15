package org.junit;

import static org.junit.Assert.assertEquals;

public class BeforeClass3Test extends BeforeClass2Test{

    @BeforeClass
    public static void setUp3() {
        test += "3";
    }


    @Test
    public void testBforeClassOverride() {
        assertEquals("123", test);
    }

}
