package com.lawyeraid.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.lawyeraid.model.Holiday;
import com.lawyeraid.model.HolidayContainer;
import com.lawyeraid.model.TermModel;
import com.lawyeraid.util.DateUtil;

public class TermService {
	
	public static final int CUSTOM_TERM = 0;

	public Date computeTermin(Date startDate, int nrOfDays) throws Exception {
		Date termDate = DateUtil.plusDays(startDate, nrOfDays + 1);

		while (isFreeDay(termDate)) {
			termDate = DateUtil.plusDays(termDate, 1);
		}

		return termDate;
	}

	private boolean isFreeDay(Date date) throws Exception {
		boolean isFreeDay = isWeekend(date) || isNationalHoliday(date);

		return isFreeDay;
	}

	private boolean isNationalHoliday(Date date) throws Exception {
		Calendar currDateCal = Calendar.getInstance();
		currDateCal.setTime(date);
		
		int currYear = currDateCal.get(Calendar.YEAR);
		int currDate = currDateCal.get(Calendar.DAY_OF_YEAR);
		
		HolidayContainer holidayContainer = HolidayService.getHolidayContainer(currYear);

		for (Holiday holiday : holidayContainer.getHolidays()) {
			Date holidayDate = holiday.getDate();
			
			Calendar hC = Calendar.getInstance();
			hC.setTime(holidayDate);

			if (currYear == hC.get(Calendar.YEAR) && currDate == hC.get(Calendar.DAY_OF_YEAR)) {
				return true;
			}
		}

		return false;
	}

	private boolean isWeekend(Date date) {
		int currentDay = DateUtil.getDayOfWeek(date);

		boolean isWeekend = currentDay == Calendar.SATURDAY || currentDay == Calendar.SUNDAY;

		return isWeekend;
	}

	public String getTermDate(Date startDate , int nrOfDays) throws Exception {
		Date termDate = computeTermin(startDate, nrOfDays);

		String termDateString = DateUtil.dateFormat.format(termDate);

		return termDateString;
	}

	public  ArrayList<TermModel> getTermTypes() {
		ArrayList<TermModel> terms = new ArrayList<TermModel>();

		terms.add(new TermModel("Regularizare", 10));
		terms.add(new TermModel("Intampinare", 25));
		terms.add(new TermModel("Raspuns intampinare", 10));
		terms.add(new TermModel("Apel", 30));
		terms.add(new TermModel("Intampinare apel", 15));
		terms.add(new TermModel("Raspuns intampinare apel", 10));
		terms.add(new TermModel("Recurs", 30));
		terms.add(new TermModel("Intampinare recurs", 30));
		terms.add(new TermModel("Raspuns intampinare recurs", 10));
		terms.add(new TermModel("Altele", CUSTOM_TERM));
		
		return terms;
	}

}
