package com.lawyeraid.util;

import java.io.InputStream;

public class Util {

	public static InputStream getResourceAsInputStream(String path) {
		InputStream in = Util.class.getResourceAsStream(path);
		
		return in;
	}
	
}
