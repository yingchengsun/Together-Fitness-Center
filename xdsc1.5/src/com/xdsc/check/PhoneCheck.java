package com.xdsc.check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * �绰����У��
 * @author �·�
 *
 */
public class PhoneCheck {
	/**
	 * ���Ե绰����Ϸ���
	 * @param �绰����
	 * @return �Ϸ���
	 */
	public static boolean telphoneCheck(String tel) {
		Pattern p3 = Pattern.compile("0[0-9]{3}-[0-9]{8}");
		Matcher m3 = p3.matcher(tel);
		if (!m3.matches()) {
			new AppException("�绰���벻��ȷ����0574-88888888��");
			return false;
		}
		if (tel.length() > 18 || tel.length() < 7) {
			new AppException("�绰λ������ȷ");
			return false;
		}
		return true;
	}
/**
 * �����ֻ��źϷ���
 * @param �ֻ���
 * @return �Ϸ���
 */
	public static boolean mobilephoneCheck(String mob) {
		Pattern p1 = Pattern.compile("^((\\+{0,1}86){0,1})1[0-9]{10}");
		Matcher m1 = p1.matcher(mob);
		Pattern p2 = Pattern.compile("0[0-9]{11}");
		Matcher m2 = p2.matcher(mob);
		if (!m1.matches() && !m2.matches()) {
			new AppException("�ֻ��Ų���ȷ");
			return false;
		}
		if (mob.length() != 11 && mob.length() != 12) {
			new AppException("�ֻ���Ϊ11λ С��ͨ12λ");
			return false;
		}
		return true;
	}
/**
 * ������ϵ��ʽ�Ϸ���
 * @param ��ϵ��ʽ
 * @return �Ϸ���
 */
	public static boolean phoneCheck(String phone) {
		Pattern pattern = Pattern.compile("[0-9,-]*");
		if (!pattern.matcher(phone).matches()) {
			new AppException("��������ȷ�ĵ绰���룡�绰����ֻ���ɣ�0-9����-�����");
			return false;
		}
		return true;
	}

	
}
