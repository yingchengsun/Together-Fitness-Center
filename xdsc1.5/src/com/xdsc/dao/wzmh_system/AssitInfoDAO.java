package com.xdsc.dao.wzmh_system;

import com.xdsc.model.JfptTabOtherassist;

/**
 * ������Ϣά��
 * @author �·�
 *
 */

public interface AssitInfoDAO {

	/**
	 * ����������Ϣ
	 * @param ����ʵ��
	 */
	public void updateAssitInfo(JfptTabOtherassist Assit);
	
	
	/**
	 * ��������
	 * @param Assit
	 */
	public void insertAssitInfo(JfptTabOtherassist Assit);
	
	/**
	 * �����ʺŲ�ѯ����
	 * @param �ʺ�
	 * @return ����ʵ��
	 */
	public JfptTabOtherassist findAssitByNum(String num);
}
