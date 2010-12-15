package org.junit;

public class BeforeClassTest {

    protected static String test;


    @BeforeClass
    public static void setUp() {
        test = "1";

    }
}
