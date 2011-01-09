package jjseo.test.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs {@link UnmanagedFormTester} while managing a Selenium server.
 * 
 * @author <a href="mailto:ggregory@apache.org">Gary Gregory</a>
 * @version $Id$
 */
@RunWith(ManagedSeleniumServerSuite.class)
@SuiteClasses( { UnmanagedFirstTestJUnit3.class, UnmanagedFirstTestJUnit4.class })
public class ManagedExampleSuiteTest {
    // See annotations.
}
