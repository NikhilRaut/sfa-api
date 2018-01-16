package com.nikhil.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getFormattedFromDateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getFormattedToDateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date convertDD_MM_YYYY_To_YYYY_MM_DD(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
			System.out.println(newstring); // 2011-01-1
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date convertYYYY_MM_DD_To_DD_MM_YYYY(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
			System.out.println(newstring);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String convertDD_MM_YYYY_To_YYYY_MM_DDString(String strDate) {
		Date date = null;
		String newstring = "";
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
			newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
			System.out.println(newstring); // 2011-01-1
			return newstring;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newstring;
	}

	public static String convertYYYY_MM_DD_To_DD_MM_YYYYString(String strDate) {
		Date date = null;
		String newstring = "";
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
			newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
			System.out.println(newstring);
			return newstring;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newstring;
	}
}
