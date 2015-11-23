package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Remind;

/**�ӿڣ������ݿ⽻������˽�������йصĳ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public interface RemindDaoInterface {
	
	/**�����������������
	 * @param remind ����ʵ��
	 */
	public abstract void addRemind(Remind remind);
	
	/**��������ɾ������
	 * @param remind ����ʵ��
	 */
	public abstract void deleteRemind(Remind remind);
	
	
	/**��������ͨ��ID�ҵ�������Ŀ
	 * @param id ID
	 * @return ������Ŀ
	 */
	public abstract Remind findById(int id);
	
	/**���������ҵ�����������������Ŀ
	 * @param username �û���
	 * @return �����б�
	 */
	public abstract List<Remind> findRemind(String username);

}
