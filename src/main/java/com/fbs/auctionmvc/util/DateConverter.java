package com.fbs.auctionmvc.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateConverter implements Converter<String, Date>{

	private String[] patterns = {"yyyy-mm-dd HH:mm:ss","yyyy/mm/dd HH:mm:ss","yyyy-mm-dd","yyyy/mm/dd"};
	
	public void setPattern(String[] patterns) {
		this.patterns = patterns;
	}
	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		for(int i=1;i<patterns.length;i++){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patterns[i]);
			try {
				Date date = simpleDateFormat.parse(arg0);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
			}
		}
		return null;
	}

}
