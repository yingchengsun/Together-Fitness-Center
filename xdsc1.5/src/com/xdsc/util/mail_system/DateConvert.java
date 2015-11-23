package com.xdsc.util.mail_system;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

/** װ��ʱ��Ĺ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class DateConvert {
	
	/**ת��ʱ���
	 * @param dateString  �̶���ʽ���ַ�����ʽ������
	 * @return Date���͵�ʱ��
	 * @throws ParseException ת���쳣
	 */
	public Date convertDate(String dateString) throws ParseException{
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		date = dateFormat.parse(dateString);
		Date sqlDate = new Date(date.getTime());
		System.out.println(sqlDate.toString());
		return sqlDate;
	}
	
//	public static void main(String[] args){
//		String dateString = new String("2010-03-15");
//		try {
//			convertDate(dateString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
