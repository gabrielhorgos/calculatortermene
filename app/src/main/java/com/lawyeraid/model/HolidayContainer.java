package com.lawyeraid.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HolidayContainer {

	private String year;
	
	@XmlElementWrapper(name = "holidays")
	@XmlElement(name = "holiday")
	private List<Holiday> holidays;

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> container) {
		this.holidays = container;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
