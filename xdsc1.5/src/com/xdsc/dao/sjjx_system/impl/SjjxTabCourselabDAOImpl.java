package com.xdsc.dao.sjjx_system.impl;


import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabCourselabDAO;
import com.xdsc.model.SjjxTabCourselab;



/**��ʵ�鰲�Ž�����ز���
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabCourselabDAOImpl extends HibernateDaoSupport implements SjjxTabCourselabDAO {
	

	/**���һ��ʵ�鰲����Ϣ��¼�����ݿ���
	 * @param courseLab
	 */
	public boolean saveCourseLab(SjjxTabCourselab courseLab) {
		this.getHibernateTemplate().save(courseLab);
		return true;
	}


	/**ɾ�����ݿ�һ��ʵ�鰲����Ϣ��¼
	 * @param courseLab
	 */
	public boolean deleteCourseLab(SjjxTabCourselab courseLab) {
		this.getHibernateTemplate().delete(courseLab);
		return true;
	}


	/**���ҵ����ݿ������е�ʵ�鰲�ż�¼
	 * @return ���ز鵽�ļ�¼
	 */
	public List<SjjxTabCourselab> getCourseLabList() {
		String hql = "from SjjxTabCourselab order by FDate";
		return this.getHibernateTemplate().find(hql);
	}
	

	/**����������id������鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param id
	 * @return ���ز��ҵ��ļ�¼ 
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


	/**����ʵ�������Ʋ鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param labName
	 * @return ���ز��ҵ��ļ�¼ 
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
	
	/**����ʵ���ұ�Ų鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param labId
	 * @return ���ز��ҵ��ļ�¼
	 */
	public List<SjjxTabCourselab> getCourseLabByLabId(int labId){
		String hql = "from SjjxTabCourselab cl where cl.sjjxTabLab.FLabId="+labId+"order by FDate";
		return this.getHibernateTemplate().find(hql);
	}

	
	/**���ݽ�ʦ�����鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼ 
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
	/**���ݽ�ʦ��¼ID�鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼ 
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

	/**����һ��ʵ�鰲�ż�¼
	 * @param courseLab
	 */
	public void updateCourseLab(SjjxTabCourselab courseLab) {
		this.getHibernateTemplate().update(courseLab);
	}

}
