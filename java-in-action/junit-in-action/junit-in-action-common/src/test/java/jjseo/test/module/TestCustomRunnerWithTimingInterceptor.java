package jjseo.test.module;

import jjseo.test.module.runners.InterceptorRunner;
import jjseo.test.module.runners.InterceptorRunner.InterceptorClasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * A sample test-case to demonstrate the timing interceptor.
 *
 * @version $Id: TestCustomRunnerWithTimingInterceptor.java 201 2009-02-15
 *          19:18:09Z paranoid12 $
 */
@RunWith(InterceptorRunner.class)
@InterceptorClasses(SampleTimingInterceptor.class)
public class TestCustomRunnerWithTimingInterceptor {
    @Before
    public void longSetUp() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    public void testDummy() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @After
    public void longTearDown() throws InterruptedException {
        Thread.sleep(1000);
    }
}
