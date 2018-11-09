package com.agilecrm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String toDate(String dateString) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return (sdf.format(new Date(System.currentTimeMillis())));
	}

	public static String toDateTime(String dateString) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (sdf.format(new Date(System.currentTimeMillis())));
	}

}
