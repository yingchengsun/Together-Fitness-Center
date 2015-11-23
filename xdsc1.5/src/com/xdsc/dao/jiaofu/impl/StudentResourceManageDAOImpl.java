package com.xdsc.dao.jiaofu.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.StudentResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;

/**
 * <p>功能：进行资源查找等操作<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentResourceManageDAOImpl extends HibernateDaoSupport implements StudentResourceManageDAO{

	/**
	 * <p>功能：根据资源id号查找相关资源信息<br>
	 * @param FNumber 资源编号
	 * @return JfptTabUploadfile 资源信息对象
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
	}

	/**
	 * <p>功能：根据个人编号相关的资源<br>
	 * @param sid 个人编号
	 * @return list 返回相关的资源信息
	 */
	public List<JfptTabUploadfile> findUploadfileInfoByID(String sid) {
		// TODO Auto-generated method stub
		
		List<JfptTabUploadfile> list = new ArrayList<JfptTabUploadfile>();
		List<JfptTabUploadfile> list1 = new ArrayList<JfptTabUploadfile>();
		
		String sql1 = "select j from JfptTabUploadfile j, JfptTabStudentteacher s where j.mhqxTabUser.FUserNumber = s.id.FTeacherNumber "
                                                                                  +"and j.tabCourse.FCourseNumber = s.id.FCourseNumber "
                                                                                  +"and s.id.FStudentNumber='"+sid+"'";
		String sql2 = "select j from JfptTabUploadfile j, JfptTabChooseassociate c where j.mhqxTabUser.FUserNumber = c.tabTeachers.FTeacherNumber "
                                                                                  +"and j.tabCourse.FCourseNumber = c.tabCourse.FCourseNumber "
                                                                                  +"and c.tabStudents.FStudentNumber='"+sid+"'";
		list = this.getHibernateTemplate().find(sql1);
		list1 = this.getHibernateTemplate().find(sql2);
		if(list1.size() <= 0){
			return list;
		}
		else{
			for(JfptTabUploadfile i: list1)
				list.add(i);
		}
		return list;
	}

}
