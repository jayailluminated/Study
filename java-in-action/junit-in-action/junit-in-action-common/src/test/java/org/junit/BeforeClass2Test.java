package org.junit;

public class BeforeClass2Test extends BeforeClassTest{

    @BeforeClass
    public static void setUp2() {
        test += "2";
    }
}
