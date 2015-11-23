package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AdminResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.util.UpDownFileUtils;


/**
 * <p>���ܣ�������Դ��������ص�һϵ�з���������ҡ�ɾ����<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AdminResourceManageDAOImpl extends HibernateDaoSupport implements AdminResourceManageDAO{

	/**
	 * <p>���ܣ�������Դ��Ž�����Դɾ��<br>
	 * @param FNumber ��Դ���
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUpfileInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		JfptTabUploadfile jfptTabUploadfile = new JfptTabUploadfile();
		jfptTabUploadfile = (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
		UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\CourseAbout\\", jfptTabUploadfile.getFFileName());
		this.getHibernateTemplate().delete(jfptTabUploadfile);
	}

	/**
	 * <p>���ܣ�������Դ��Ž�����Դ����<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ����
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
	}

	/**
	 * <p>���ܣ����ҳ��̸�ϵͳ�����еĿμ���Դ<br>
	 * @return list ���ҳ�������Ϣ�б�
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUploadfile> findUploadfileInfo() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabUploadfile";
		List<JfptTabUploadfile> list = this.getHibernateTemplate().find(sql);
		return list;
	}

}
