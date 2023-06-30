package com.ninja.utilities;

import java.util.Date;

public class Ninja_Utils {
	
	public String generateEmailWithTimeStamp() {
		Date date = new Date();
		String emailWithTimeStamp = date.toString().replace("", "_").replace(",", "_");
		return "chowdhurygs" +emailWithTimeStamp+ "@gmail.com";
	}
	public String generatePasswordWithTimeStamp() {
		Date date = new Date();
		String passwordWithTimeStamp = date.toString().replace("", "_").replace(",", "_");
		return "Shajlee" +passwordWithTimeStamp+ "1234";
	}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_WAIT_TIME = 10;
	public static final int SCRIPTLOAD_WAIT_TIME = 100;
	}


