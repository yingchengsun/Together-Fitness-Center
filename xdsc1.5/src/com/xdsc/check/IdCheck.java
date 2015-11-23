package com.xdsc.check;

import java.util.Date;
/**
 * 身份证校验
 * @author 陈丰
 *
 */
public class IdCheck {
	// 身份证
	private String aae135;
	// 身份证校验辅助数组
	private final int[] VERIFY_ARRAY = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9,
			10, 5, 8, 4, 2 };
	// 男
	private final String MAN = "1";
	// 女
	private final String WOMAN = "2";
	// 身份证重复的提示信息
	private final String IS_EXISTS = "系统中已存在相同的身份证！";

	public IdCheck() {
	}

	public IdCheck(String aae135) {
		this.aae135 = aae135;
	}

	public String getAae135() {
		return aae135;
	}

	public void setAae135(String aae135) {
		this.aae135 = aae135;
	}

	/**
	 * 身份证综合有效性校验，如果15位则返回转换成18位后的身份证
	 * 
	 * @return 18位的身份证
	 * @throws AppException
	 */
	public String checkValid()  {
		checkLength();
		checkNumber();
		checkVerify();
		return upAae135();
	}

	/**
	 * 检查身份证的长度是否符合要求
	 * 
	 * @throws AppException
	 */
	public void checkLength()  {
		if (aae135.length() != 18 && aae135.length() != 15) {
			//throw new AppException("身份证长度出错，必须为18或15位！现长度：" + aae135.length());
		}
	}

	/**
	 * 检查身份证是否有无效字符
	 *  
	 * @throws AppException
	 */
	public void checkNumber()  {
		int index = 0;
		int length = 0;
		if (aae135.length() == 15) {
			length = aae135.length();
		} else if (aae135.length() == 18) {
			length = aae135.length() - 1;
		}
		try {
			for (int i = 0; i < length; i++) {
				index = i + 1;
				Integer.parseInt(aae135.substring(i, i + 1));
			}
		} catch (Exception e) {
			//throw new AppException("身份证第" + index + "位("
			//		+ aae135.substring(index - 1, index) + ")为非数字！");
		}
	}

	/**
	 * 15位转成18位、18位转成修改校验位后的18位
	 * 
	 * @return 转换后的18位身份证
	 * @throws AppException
	 */
	public String upAae135() {
		checkLength();
		checkNumber();
		if (aae135.length() == 18) {
			aae135 = aae135.substring(0, 17);
		} else if (aae135.length() == 15) {
			aae135 = aae135.substring(0, 6) + "19" + aae135.substring(6);
		}
		aae135 = aae135 + getVerify();
		return aae135;
	}

	/**
	 * 取得校验位
	 * 
	 * @return 校验位
	 * @throws AppException
	 */
	public String getVerify()  {
		int verify = 0;
		int sum = 0;
		String verifyAae135="";
		if (aae135.length() == 18) {
			verifyAae135 = aae135.substring(0, 17);
		} else if (aae135.length() == 15) {
			verifyAae135 = aae135.substring(0, 6) + "19" + aae135.substring(6);
		} else if (aae135.length() == 17) {
			verifyAae135 = aae135;
		} else {
			//throw new AppException("输入的身份证长度出错！必须为18或15位！输入的身份证长度："
			//		+ aae135.length());
		}

		for (int i = 0; i < 17; i++) {
			String k = verifyAae135.substring(i, i + 1);
			sum = sum + VERIFY_ARRAY[i] * Integer.parseInt(k);
		}
		verify = sum % 11;
		verify = (12 - verify) % 11;
		return verify == 10 ? "X" : String.valueOf(verify);
	}

	/**
	 * 校验身份证末位校验位
	 * 
	 * @throws AppException
	 */
	public void checkVerify() {
		if (aae135.length() == 18) {
			String verify = getVerify();
			if (!aae135.substring(aae135.length() - 1).toUpperCase().equals(verify)) {
			//	throw new AppException("身份证末位检验位校验出错，按校验规则计算得到的应该为：" + verify);
			}
		}
	}

	/**
	 * 取得8位字符的出生日期
	 * 
	 * @return 8位字符的出生日期
	 * @throws AppException
	 */
	public String getBirthdayString() {
		if (aae135.length() == 15) {
			aae135 = upAae135();
		}else if(aae135.length() !=18){
			//throw new AppException("身份证位数不合法");
		}
		return aae135.substring(6, 14);
	}

	/**
	 * 取得日期型的出生日期
	 * 
	 * @return 日期型的出生日期
	 * @throws AppException
//	 */
//	public Date getBirthday()  {
//		String birthday = getBirthdayString();
//		try {
//			//return DateUtil.toDate(birthday);
//		} catch (AppException e) {
//			//throw new AppException("该公民身份号码中6-14位(" + birthday + ")是无效的出生日期！",
//			//		e);
//		}
//	}

	/**
	 * 根据身份证取得姓名
	 * 
	 * @return
	 * @throws AppException
	 */
	public String getSex() {
		checkLength();
		if (aae135.length() == 15) {
			aae135 = upAae135();
		}
		if (Integer.parseInt(aae135.substring(16, 17)) % 2 == 1) {
			// 男
			return MAN;
		} else {
			// 女
			return WOMAN;
		}
	}


	

	
	
	

	/**
	 * 身份证综合有效性校验，如果15位则返回转换成18位后的身份证
	 * 不校验最后一位
	 * @return 18位的身份证
	 * @throws AppException
	 */
	public String checkAae135Valid() {
		checkNumber();
		return newupAae135();
	}
	/**
	 * 15位转成18位
	 * 
	 * @return 转换后的18位身份证
	 * @throws AppException
	 */
	public String newupAae135() {
		if (aae135.length() == 15) {
			aae135 = aae135.substring(0, 6) + "19" + aae135.substring(6);
			aae135 = aae135 + getVerify();
		}
		
		return aae135;
	}
	/**
	 * @param args
	 * @throws AppException
	 */
	public void main(String[] args){
		aae135 = "330219197803010114";
		checkValid();

	}
	
	
	
	/**
	 * 输入15位身份证转换成18位，不校验最后一位
	 * @throws AppException 
	 */
	public String checkAae135() {
		String tmp=aae135;
//		if(!ObjectUtil.equals(tmp,"")&& tmp.length()==15){
//			tmp =String.valueOf(checkAae135Valid());
//		}
		return tmp;
	}
	

	
}
