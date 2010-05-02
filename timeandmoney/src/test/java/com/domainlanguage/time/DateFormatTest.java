package com.domainlanguage.time;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final SimpleDateFormat KOREA_FORMAT = new SimpleDateFormat("yyyy년 MM월 dd일  HH시 mm분 ss초", Locale.KOREA);
	private static final SimpleDateFormat KOREA_FORMAT_REMAIN_TIME = new SimpleDateFormat("dd일 HH시간 mm분 ss초", Locale.KOREA);

	@Ignore
	public void testSimpleDateFormat() {
		Date dd = new Date();
		dd.setTime(10);
		assertEquals("1970년 01월 01일  09시 00분 00초", KOREA_FORMAT.format(dd));

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DATE, 2);

		long diff = c2.getTimeInMillis() - c1.getTimeInMillis();
		Date d = new Date();
		d.setTime(diff);
		assertEquals("1970년 01월 01일  09시 00분 00초", KOREA_FORMAT_REMAIN_TIME.format(d));
	}

	@Test
	public void testTimeUnit() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.DATE, 5);
		c2.add(Calendar.HOUR, 4);
		c2.add(Calendar.MINUTE, 3);
		c2.add(Calendar.SECOND, 2);
		long diff = c2.getTimeInMillis() - c1.getTimeInMillis();

		assertEquals(446582000, diff);

		long days = TimeUnit.MILLISECONDS.toDays(diff);
		long hours = TimeUnit.MILLISECONDS.toHours(diff - TimeUnit.DAYS.toMillis(days));
		long minute = TimeUnit.MILLISECONDS.toMinutes(diff - TimeUnit.DAYS.toMillis(days) - TimeUnit.HOURS.toMillis(hours));
		assertEquals(5, days);
		assertEquals(4, hours);
		assertEquals(3, minute);
	}

	@Test
	public void testStringFormat() {

		Calendar c = Calendar.getInstance();
		String s1 = String.format("Duke's Birthday: %1$tm %1$te,%1$tY", c);
//		String s2 = String.format("Duke's Birthday: %1$tm %<$te,%<$tY", c);
		logger.debug(s1);
//		logger.debug(s2);

		Object[] args = new Object[4];
		args[0] = 10;
		args[1] = 12;
		args[2] = 13;
		args[3] = 20;
		String s3 = String.format("%d, %d, %d", args);
		logger.debug(s3);
	}
}
