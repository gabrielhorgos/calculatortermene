package com.lawyeraid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;

import com.lawyeraid.service.TermService;
import com.lawyeraid.util.DateUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TermService termService = new TermService();
		System.out.println("Calculator termene");
		System.out.println("Introduceti data (format DD-MM-YYYY) :");
		String dateString = br.readLine();

		System.out.println("Introduceti nr zile : ");
		String nrOfDaysString = br.readLine();
		int nrOfDays = Integer.parseInt(nrOfDaysString);

		Date startDate;
		try {
			startDate = DateUtil.parseDate(dateString);
			Date termDate = termService.computeTermin(startDate, nrOfDays);
			System.out.println("Termenul se implineste la data : " + termDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Something went wrong!");
		}

	}
}
