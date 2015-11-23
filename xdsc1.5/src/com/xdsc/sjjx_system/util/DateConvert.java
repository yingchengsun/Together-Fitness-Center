package com.xdsc.sjjx_system.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvert {
	
	public Date dateConvert(String date_str) throws ParseException{
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date_util = dateFormat.parse(date_str);
		Date date_sql = new Date(date_util.getTime());
		return date_sql;
	}

}
