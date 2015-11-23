package com.xdsc.dao.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
/**
 * <p>���ܣ�����Ա�Խ̸�ϵͳ�е��ϴ��μ���Դ���й������а�������ѯ��Դ��ɾ����Դ��<br>
 * @author qianxun
 * @version 1.1
 */
public interface AdminResourceManageDAO {

	/**
	 * <p>���ܣ����ҳ��̸�ϵͳ�����еĿμ���Դ<br>
	 * @return list ���ҳ�������Ϣ�б�
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUploadfile> findUploadfileInfo();
	/**
	 * <p>���ܣ�������Դ��Ž�����Դɾ��<br>
	 * @param FNumber ��Դ���
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUpfileInfoByID(int FNumber);
	/**
	 * <p>���ܣ�������Դ��Ž�����Դ����<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ����
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}
