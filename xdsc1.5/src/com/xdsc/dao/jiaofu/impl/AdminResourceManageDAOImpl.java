package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AdminResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.util.UpDownFileUtils;


/**
 * <p>功能：包含资源管理中相关的一系列方法，如查找、删除等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AdminResourceManageDAOImpl extends HibernateDaoSupport implements AdminResourceManageDAO{

	/**
	 * <p>功能：根据资源编号进行资源删除<br>
	 * @param FNumber 资源编号
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
	 * <p>功能：根据资源编号进行资源查找<br>
	 * @param FNumber 资源编号
	 * @return JfptTabUploadfile 资源对象
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
	}

	/**
	 * <p>功能：查找出教辅系统中所有的课件资源<br>
	 * @return list 查找出来的信息列表
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUploadfile> findUploadfileInfo() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabUploadfile";
		List<JfptTabUploadfile> list = this.getHibernateTemplate().find(sql);
		return list;
	}

}
