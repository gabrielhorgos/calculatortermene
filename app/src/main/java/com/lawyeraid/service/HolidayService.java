package com.lawyeraid.service;

import com.lawyeraid.model.HolidayContainer;
import com.lawyeraid.util.Util;

import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class HolidayService {

	private static JAXBContext jaxbCtx;
	
	private static HashMap<String, HolidayContainer> holidaysMap = new HashMap<>();
	
	public static JAXBContext getJaxbCtx() throws JAXBException {
		if (jaxbCtx == null) {
			jaxbCtx = JAXBContext.newInstance(HolidayContainer.class);
			
			return getJaxbCtx();
		}
		
		return jaxbCtx;
	}
	
	public static HolidayContainer loadContainer(String key) throws Exception {
		try {
			JAXBContext jc = getJaxbCtx();
			Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
			InputStream resourceInputStream = Util.getResourceAsInputStream("/holiday-containers/" + key + ".xml");
			HolidayContainer holidayContainer = (HolidayContainer) jaxbUnmarshaller.unmarshal(new FileReader(
					"/holiday-containers/" + key + ".xml"));

			return holidayContainer;
		} catch (Exception e) {
			//TODO add log error could not load resource file!!
			throw e;
		}
	}

	public static HolidayContainer getHolidayContainer(int currYear) throws Exception {
		String key = String.valueOf(currYear);
		
		HolidayContainer holidayContainer = holidaysMap.get(key);
		
		if (holidayContainer == null) {
			holidayContainer = loadContainer(key);
			
			holidaysMap.put(key, holidayContainer);
		}
		
		return holidayContainer;
	}
}
