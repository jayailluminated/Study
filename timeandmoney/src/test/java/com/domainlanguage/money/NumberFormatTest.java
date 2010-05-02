package com.domainlanguage.money;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class NumberFormatTest {
	private static Currency USD = Currency.getInstance("USD");
	private static Currency JPY = Currency.getInstance("JPY");
	private static Currency KRW = Currency.getInstance("KRW");
	private static Currency EUR = Currency.getInstance("EUR");

	private Money d15;
	private Money d2_51;
	private Money y50;
	private Money k50;
	private Money e2_51;
	private Money d100;

	@Before
	public void setUp() {
		d15 = Money.valueOf(new BigDecimal("15.0"), USD);
		d2_51 = Money.valueOf(new BigDecimal("2.51"), USD);
		e2_51 = Money.valueOf(new BigDecimal("2.51"), EUR);
		y50 = Money.valueOf(new BigDecimal("50"), JPY);
		k50 = Money.valueOf(new BigDecimal("50"), KRW);
		d100 = Money.valueOf(new BigDecimal("100.0"), USD);
	}

	@Test
	public void testCurrencySymbol() {
		NumberFormat uk_mf = NumberFormat.getCurrencyInstance(Locale.UK);
		assertEquals("£100.00", uk_mf.format(100));

		NumberFormat us_mf = NumberFormat.getCurrencyInstance(Locale.US);
		assertEquals("$100.00", us_mf.format(100));

		NumberFormat mf = NumberFormat.getCurrencyInstance(Locale.KOREA);
		assertEquals("￦100", mf.format(100));

		NumberFormat mf2 = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		assertEquals("￥100", mf2.format(100));
	}

	@Test
	public void testGetLocaleFromCurrency() {
		String usdCode = USD.getCurrencyCode();
		String country = Locale.US.getCountry();
		assertEquals("USD", usdCode);
		assertEquals("US", country);
	}


}