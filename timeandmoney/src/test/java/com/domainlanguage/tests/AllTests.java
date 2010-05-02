/**
 * Copyright (c) 2004 Domain Language, Inc. (http://domainlanguage.com) This
 * free software is distributed under the "MIT" licence. See file licence.txt.
 * For more information, see http://timeandmoney.sourceforge.net.
 */

package com.domainlanguage.tests;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestSuite;
import junitx.util.DirectorySuiteBuilder;
import junitx.util.SimpleTestFilter;



public class AllTests extends TestSuite{
	public static Test suite() throws Exception {
		DirectorySuiteBuilder builder = new DirectorySuiteBuilder(new SimpleTestFilter());
		return builder.suite(new File("target/test-classes"));
	}

}
