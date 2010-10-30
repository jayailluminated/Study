/*
 *  Copyright 2001-2005 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.time.chrono;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Entry point for all tests in this package.
 * 
 * @version $Revision: 1217 $ $Date: 2007-05-08 03:49:47 +0000 (Tue, 08 May 2007) $
 * 
 * @author Stephen Colebourne
 */
public class TestAll extends TestCase {

    public static boolean FAST = false;

    public TestAll(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        
        suite.addTest(TestBuddhistChronology.suite());
        suite.addTest(TestCopticChronology.suite());
        suite.addTest(TestEthiopicChronology.suite());
        suite.addTest(TestGJChronology.suite());
        suite.addTest(TestGregorianChronology.suite());
        suite.addTest(TestIslamicChronology.suite());
        suite.addTest(TestJulianChronology.suite());
        suite.addTest(TestISOChronology.suite());
        suite.addTest(TestLenientChronology.suite());
        
        return suite;
    }

    public static void main(String args[]) {
        FAST = false;
        TestRunner.run(TestAll.suite());
    }

}