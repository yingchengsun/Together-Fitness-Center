package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
/**
 * <p>���ܣ���ѧ������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public interface OwnArrangementManager {

	/**
	 * <p>���ܣ������Լ���Ų�����صİ�����Ϣ<br>
	 * @param number ���˱��
	 * @return list ������Ϣ
	 */
	public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number);
	
	/**
	 * <p>���ܣ����ݰ���id�Ų�����صİ�����Ϣ<br>
	 * @param FId ����id��
	 * @return JfptTabZiwoanpai ���Ŷ�����Ϣ
	 */
	public JfptTabZiwoanpai findZiwoanpaiByID(int FId);
	
	/**
	 * <p>���ܣ�ɾ�����Ŷ�����Ϣ<br>
	 * @param info ���Ŷ�����Ϣ
	 */
	public void deleteZiwoanpai(JfptTabZiwoanpai info);
	
	/**
	 * <p>���ܣ���Ӱ�����Ϣ<br>
	 * @param info ������Ϣ����
	 */
	public void addZiwoanpai(JfptTabZiwoanpai info);
	
	/**
	 * <p>���ܣ����ݸ���id�Ų���User������Ϣ<br>
	 * @param FUserNumber ����id��
	 * @return MhqxTabUser ����User������Ϣ
	 */
	public MhqxTabUser findUserByID(String FUserNumber);
}
