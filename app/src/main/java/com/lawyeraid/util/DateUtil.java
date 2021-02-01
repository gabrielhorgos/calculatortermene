package com.lawyeraid.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * Parses dates with the format : dd.MM.yyy. Returns a LocalDate
	 * representation.
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException 
	 */
	public static Date parseDate(String dateString) throws ParseException {
		Date date;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			throw new ParseException("Your date could not be parsed. Make sure the date format is dd.MM.yyy", 0);
		}

		return date;
	}

	public static Date plusDays(Date date, int nrOfDays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, nrOfDays);

		return calendar.getTime();
	}

	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		return dayOfWeek;
	}
	
}
