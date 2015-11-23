package com.xdsc.dao.jiaofu.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AssistResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;

/**
 * <p>功能：进行资源查找等操作<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistResourceManageDAOImpl extends HibernateDaoSupport implements AssistResourceManageDAO{

	/**
	 * <p>功能：根据个人编号相关的资源<br>
	 * @param aid 个人编号
	 * @return list 返回相关的资源信息
	 */
	public List<JfptTabUploadfile> findResourceInfoByID(String aid) {
		List<JfptTabUploadfile> list = new ArrayList<JfptTabUploadfile>();
		String sql = "select j from JfptTabUploadfile j, JfptTabAssistantapply a where j.tabCourse.FCourseNumber = a.tabCourse.FCourseNumber " 
                                                             +"and j.mhqxTabUser.FUserNumber = a.tabTeachers.FTeacherNumber "
                                                             +"and a.FAssistantId='"+aid+"'"
                                                             +" and a.FShenQing='N'";
	    list = this.getHibernateTemplate().find(sql);
	    return list;
	}

	/**
	 * <p>功能：根据资源id号查找相关资源信息<br>
	 * @param FNumber 资源编号
	 * @return JfptTabUploadfile 资源信息对象
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
	}
}
