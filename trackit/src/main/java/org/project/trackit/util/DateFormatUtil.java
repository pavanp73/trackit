package org.project.trackit.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	private static final String FORMAT = "dd-MM-yyyy HH:mm"; 
	
	private static SimpleDateFormat sd = new SimpleDateFormat(FORMAT);
	
	public static String convert(Date date) {
		
		return sd.format(date);	
	}
	
	public static Date read(String date) {
		
		try {
			return sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
			
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(convert(new Date()));
		System.out.println(read("21-02-2018 20:45"));
		
	}
	
}
