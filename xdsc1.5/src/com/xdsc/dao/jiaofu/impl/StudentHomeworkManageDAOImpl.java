package com.xdsc.dao.jiaofu.impl;

import java.io.File;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.StudentHomeworkManageDAO;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.util.UpDownFileUtils;

/**
 * <p>���ܣ��й���ҵ�������漰���ķ�����������ҵ֪ͨ����ҵ���ġ��ɼ������<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentHomeworkManageDAOImpl extends HibernateDaoSupport implements StudentHomeworkManageDAO{

	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų��������ϸ��Ϣ<br>
	 * @param FHomeNoticeId ��ҵ֪ͨid��
	 * @return JfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public JfptTabHomenotice findHomeDetailByID(int FHomeNoticeId) {
		// TODO Auto-generated method stub
		return (JfptTabHomenotice)this.getHibernateTemplate().get(JfptTabHomenotice.class, FHomeNoticeId);
	}

	/**
	 * <p>���ܣ�������ҵ���ö�Ӧ��Ϣid�Ų��������Ϣ<br>
	 * @param FNumber ������Ϣid��
	 * @return JfptTabHomenoticetireceive ��ҵ���ö�Ӧ��Ϣ
	 */
	public JfptTabHomenoticetoreceive findHomeNoticetotoInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabHomenoticetoreceive)this.getHibernateTemplate().get(JfptTabHomenoticetoreceive.class, FNumber);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų������Ӧ����ҵ������Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return list ���ض�Ӧ��Ϣ
	 */
	public List<JfptTabHomenoticetoreceive> findHomeNoticetotoInfoBySid(String sid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabHomenoticetoreceive t where t.tabStudents.FStudentNumber='"+sid+"'";
		List<JfptTabHomenoticetoreceive> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�ɾ����ҵ��Ӧ������Ϣ<br>
	 * @param jfptTabHomenoticetoreceive ��ҵ���ö�Ӧ��Ϣ
	 */
	public void deleteHomeNoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabHomenoticetoreceive);
	}

	/**
	 * <p>���ܣ�������ҵ������Ϣ<br>
	 * @param jfptTabHomenoticetoreceive ��ҵ������Ϣ
	 */
	public void updateHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jfptTabHomenoticetoreceive);
	}

	//**************************************************************************
	/**
	 * <p>���ܣ������Լ��ύ����ҵ��Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return list ��ҵ�ύ��Ϣ
	 */
	public List<JfptTabHomeupload> findHomeUploadInfoBySid(String sid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabHomeupload h where h.tabStudents.FStudentNumber='"+sid+"'";
		List<JfptTabHomeupload> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ������ϴ���ҵ��Ϣid�Ų��������ϸ��Ϣ<br>
	 * @param FHomeId �ϴ���ҵ��Ϣid��
	 * @return JfptTabHomeupload �ϴ���ҵ������Ϣ
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int FHomeId) {
		// TODO Auto-generated method stub
		System.out.println("findHomeworkDetailByID--------------student-----------DAOImpl");
		return (JfptTabHomeupload)this.getHibernateTemplate().get(JfptTabHomeupload.class, FHomeId);
	}

	/**
	 * <p>���ܣ�������ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ����
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jfptTabHomeupload);
	}

	/**
	 * <p>���ܣ�ɾ����ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ�ϴ���Ϣ
	 */
	public void deleteHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		if(jfptTabHomeupload.getFFilePath()!=null){
			String name = jfptTabHomeupload.getFFilePath().substring(jfptTabHomeupload.getFFilePath().lastIndexOf("/")+1);
			UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\HomeUpload\\", name);
		}
		this.getHibernateTemplate().delete(jfptTabHomeupload);
	}
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�����صĿγ���Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfoBySid(String id) {
		// TODO Auto-generated method stub
		String sql1 = "from TabCourse t where t.FCourseNumber in (" +
				"select j.id.FCourseNumber from JfptTabStudentteacher j where" +
				" j.id.FStudentNumber='"+id+"')";
		String sql = "from TabCourse t where t.FCourseNumber in (" +
				"select c.tabCourse.FCourseNumber from JfptTabChooseassociate c" +
				" where c.tabStudents.FStudentNumber='"+id+"')";
		List<TabCourse> list1 = this.getHibernateTemplate().find(sql1);
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		for(TabCourse i: list1){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>���ܣ����ݿγ̺Ų��ҿγ���ϸ��Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse �γ������Ϣ
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, id);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsInfoBySid(String sid) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, sid);
	}

	/**
	 * <p>���ܣ������ļ�<br>
	 * @param uploadFile �ϴ��ļ�
	 * @param savePath ����·��
	 * @param uploadFileFileName �ļ�����
	 */
	public void savefile(File uploadFile, String savePath,
			String uploadFileFileName) {
		// TODO Auto-generated method stub
		UpDownFileUtils.saveFile(uploadFile, savePath, uploadFileFileName);		
	}

	/**
	 * <p>���ܣ��ύ��ҵ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ
	 */
	public void addHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabHomeupload);
	}

}
