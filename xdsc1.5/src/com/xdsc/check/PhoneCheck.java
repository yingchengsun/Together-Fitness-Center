package com.xdsc.check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 电话号码校验
 * @author 陈丰
 *
 */
public class PhoneCheck {
	/**
	 * 测试电话号码合法性
	 * @param 电话号码
	 * @return 合法性
	 */
	public static boolean telphoneCheck(String tel) {
		Pattern p3 = Pattern.compile("0[0-9]{3}-[0-9]{8}");
		Matcher m3 = p3.matcher(tel);
		if (!m3.matches()) {
			new AppException("电话号码不正确！如0574-88888888！");
			return false;
		}
		if (tel.length() > 18 || tel.length() < 7) {
			new AppException("电话位数不正确");
			return false;
		}
		return true;
	}
/**
 * 测试手机号合法性
 * @param 手机号
 * @return 合法性
 */
	public static boolean mobilephoneCheck(String mob) {
		Pattern p1 = Pattern.compile("^((\\+{0,1}86){0,1})1[0-9]{10}");
		Matcher m1 = p1.matcher(mob);
		Pattern p2 = Pattern.compile("0[0-9]{11}");
		Matcher m2 = p2.matcher(mob);
		if (!m1.matches() && !m2.matches()) {
			new AppException("手机号不正确");
			return false;
		}
		if (mob.length() != 11 && mob.length() != 12) {
			new AppException("手机号为11位 小灵通12位");
			return false;
		}
		return true;
	}
/**
 * 测试联系方式合法性
 * @param 联系方式
 * @return 合法性
 */
	public static boolean phoneCheck(String phone) {
		Pattern pattern = Pattern.compile("[0-9,-]*");
		if (!pattern.matcher(phone).matches()) {
			new AppException("请输入正确的电话号码！电话号码只能由（0-9）或‘-’组成");
			return false;
		}
		return true;
	}

	
}
