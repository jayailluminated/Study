/**
 * Copyright (c) 2004 Domain Language, Inc. (http://domainlanguage.com) This
 * free software is distributed under the "MIT" licence. See file licence.txt.
 * For more information, see http://timeandmoney.sourceforge.net.
 */

package com.domainlanguage.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.domainlanguage.base.RatioTest;
import com.domainlanguage.money.MoneyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	RatioTest.class,
	MoneyTest.class
})
public class AllTestsByAnnotation {
	// the class remains completely empty,
	// being used only as a holder for the above annotations
}
