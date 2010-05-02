package com.domainlanguage.base;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class TextFormatFactory {
	private final static String[] DEFAULT_REMAIN_TIME_FORMAT = {"%dd", "%dh", "%dm", "%ds"};
	private final static String[] JAPAN_REMAIN_TIME_FORMAT = {"%d日", "%d時間", "%d分", "%d秒"};
	private final static String[] KOREAN_REMAIN_TIME_FORMAT = {"%d일", "%d시간", "%d분", "%d초"};

	private static final Currency USD = Currency.getInstance("USD");
	private static final Currency KRW = Currency.getInstance("KRW");
	private static final Currency JPY = Currency.getInstance("JPY");
	private static final Currency EUR = Currency.getInstance("EUR");

	public static String[] getRemainTimeFormat(Locale locale) {
		if (locale.equals(Locale.KOREA)) {
			return KOREAN_REMAIN_TIME_FORMAT;
		} else if (locale.equals(Locale.JAPAN)) {
			return JAPAN_REMAIN_TIME_FORMAT;
		} else {
			return DEFAULT_REMAIN_TIME_FORMAT;
		}
	}

	public static NumberFormat getCurrencyFormat(Currency currency) {
		if(currency.equals(USD)) {
			return NumberFormat.getCurrencyInstance(Locale.US);
		} else if (currency.equals(JPY)) {
			return NumberFormat.getCurrencyInstance(Locale.JAPAN);
		} else if (currency.equals(KRW)) {
			return NumberFormat.getCurrencyInstance(Locale.KOREA);
		} else if (currency.equals(EUR)) {
			return NumberFormat.getCurrencyInstance(Locale.UK);
		} else {
			return null;
		}

	}
}
