package jjseo.test.module;

import jjseo.test.module.runners.InterceptorRunner;
import jjseo.test.module.runners.InterceptorRunner.InterceptorClasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * A test-case to test our custom InterceptorRunner.
 *
 * @version $Id: TestCustomRunnerWithLoggingInterceptor.java 201 2009-02-15
 *          19:18:09Z paranoid12 $
 */
@RunWith(InterceptorRunner.class)
@InterceptorClasses(value = { SampleLoggingInterceptor.class })
public class TestCustomRunnerWithLoggingInterceptor {
    @Before
    public void setUp() {
        System.out.println("Real before");
    }

    @Test
    public void testDummy() {
        assertTrue(true);
        System.out.println("Some text for test purpose");

    }

    @After
    public void tearDown() {
        System.out.println("Real after");
    }
}
