package com.xdsc.dao.sjjx_system.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabCourselabDAO;
import com.xdsc.model.SjjxTabCourselab;



/**对实验安排进行相关操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabCourselabDAOImpl extends HibernateDaoSupport implements SjjxTabCourselabDAO {
	

	/**添加一条实验安排信息记录到数据库中
	 * @param courseLab
	 */
	public boolean saveCourseLab(SjjxTabCourselab courseLab) {
		this.getHibernateTemplate().save(courseLab);
		return true;
	}


	/**删除数据库一条实验安排信息记录
	 * @param courseLab
	 */
	public boolean deleteCourseLab(SjjxTabCourselab courseLab) {
		this.getHibernateTemplate().delete(courseLab);
		return true;
	}


	/**查找到数据库中所有的实验安排记录
	 * @return 返回查到的记录
	 */
	public List<SjjxTabCourselab> getCourseLabList() {
		String hql = "from SjjxTabCourselab order by FDate";
		return this.getHibernateTemplate().find(hql);
	}
	

	/**根据自增的id数据项查到到对应的实验安排记录
	 * @param id
	 * @return 返回查找到的记录 
	 */
	public SjjxTabCourselab getCourseLabById(Integer id) {
		String hql = "from SjjxTabCourselab cl where cl.FNumber="+id;
		if (this.getHibernateTemplate().find(hql).isEmpty()){
			return null;
		}
		else{

			return (SjjxTabCourselab) this.getHibernateTemplate().find(hql).get(0);
		}
	}


	/**根据实验室名称查到到对应的实验安排记录
	 * @param labName
	 * @return 返回查找到的记录 
	 */
	public List<SjjxTabCourselab> getCourseLabByLabName(String labName){
		String hql = null;
		if(null==labName||"".equals(labName)){
			hql = "from SjjxTabCourselab";
		}
		else{
			hql = "from SjjxTabCourselab cl where cl.sjjxTabLab.FLabName='" + labName
		             +"' order by FDate";
		}
		
	    	return  this.getHibernateTemplate().find(hql);
	}
	
	/**根据实验室编号查到到对应的实验安排记录
	 * @param labId
	 * @return 返回查找到的记录
	 */
	public List<SjjxTabCourselab> getCourseLabByLabId(int labId){
		String hql = "from SjjxTabCourselab cl where cl.sjjxTabLab.FLabId="+labId+"order by FDate";
		return this.getHibernateTemplate().find(hql);
	}

	
	/**根据教师姓名查到到对应的实验安排记录
	 * @param teacherName
	 * @return 返回查找到的记录 
	 */
	public List<SjjxTabCourselab> getCourseLabByTeacherName(String teacherName){
		
		String hql = null;
		if(null==teacherName||"".equals(teacherName)){
			hql = "from SjjxTabCourselab";
		}
		else{
			hql = "from SjjxTabCourselab cl where cl. tabTeachers.FTeacherName='"+ teacherName
		             +"' order by FDate";
			
		}
	    	return  this.getHibernateTemplate().find(hql);
	}
	/**根据教师登录ID查到到对应的实验安排记录
	 * @param teacherName
	 * @return 返回查找到的记录 
	 */
	public List<SjjxTabCourselab> getCourseLabByTeacherNum(String teacherNum){
		
		String hql = null;
		if(null==teacherNum||"".equals(teacherNum)){
			hql = "from SjjxTabCourselab";
		}
		else{
			hql = "from SjjxTabCourselab cl where cl. tabTeachers.FTeacherNumber='"+ teacherNum
		             +"' order by FDate";
			
		}
	    	return  this.getHibernateTemplate().find(hql);
	}

	/**更新一条实验安排记录
	 * @param courseLab
	 */
	public void updateCourseLab(SjjxTabCourselab courseLab) {
		this.getHibernateTemplate().update(courseLab);
	}

}
