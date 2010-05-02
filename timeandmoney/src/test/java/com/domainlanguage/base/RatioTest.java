/**
 * Copyright (c) 2004 Domain Language, Inc. (http://domainlanguage.com) This
 * free software is distributed under the "MIT" licence. See file licence.txt.
 * For more information, see http://timeandmoney.sourceforge.net.
 */

package com.domainlanguage.base;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;



public class RatioTest {

	@Test
    public void testBigDecimalRatio() {
        Ratio r3over2 = Ratio.of(new BigDecimal(3), new BigDecimal(2));
        BigDecimal result = r3over2.decimalValue(1, RoundingMode.UNNECESSARY);
        assertEquals(new BigDecimal("1.5"), result);

        Ratio r10over3 = Ratio.of(new BigDecimal(10), new BigDecimal(3));
        result = r10over3.decimalValue(3, RoundingMode.DOWN);
        assertEquals(new BigDecimal("3.333"), result);

        result = r10over3.decimalValue(3, RoundingMode.UP);
        assertEquals(new BigDecimal("3.334"), result);

        Ratio rManyDigits = Ratio.of(new BigDecimal("9.001"), new BigDecimal(3));
        result = rManyDigits.decimalValue(6, RoundingMode.UP);
        assertEquals(new BigDecimal("3.000334"), result);

        result = rManyDigits.decimalValue(7, RoundingMode.UP);
        assertEquals(new BigDecimal("3.0003334"), result);

        result = rManyDigits.decimalValue(7, RoundingMode.HALF_UP);
        assertEquals(new BigDecimal("3.0003333"), result);
    }

	@Test
    public void testLongRatio() {
        Ratio rManyDigits = Ratio.of(9001l, 3000l);
        BigDecimal result = rManyDigits.decimalValue(6, RoundingMode.UP);
        assertEquals(new BigDecimal("3.000334"), result);
    }

	@Test
    public void testEquals() {
        assertTrue(Ratio.of(100, 200).equals(Ratio.of(100, 200)));
        assertEquals(Ratio.of(100, 200), Ratio.of(100, 200));
        assertEquals(Ratio.of(100, 200), Ratio.of(new BigDecimal("100"), new BigDecimal("200")));
    }

	@Test
    public void testMultiplyNumerator() {
        Ratio rManyDigits = Ratio.of(9001, 3000);
        Ratio product = rManyDigits.times(new BigDecimal("1.1"));
        assertEquals(Ratio.of(new BigDecimal("9901.1"), new BigDecimal(3000)), product);
    }

	@Test
    public void testMultiplyByRatio() {
        Ratio r1 = Ratio.of(9001, 3000);
        Ratio r2 = Ratio.of(3, 2);
        Ratio expectedProduct = Ratio.of(27003, 6000);
        assertEquals(expectedProduct, r1.times(r2));
    }
}