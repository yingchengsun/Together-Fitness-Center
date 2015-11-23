package com.xdsc.dao.jiaofu.impl;

import java.io.File;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.TeacherResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.util.UpDownFileUtils;
/**
 * <p>���ܣ�������Դ���ҡ��ϴ���ɾ���Ȳ���<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherResourceManageDAOImpl extends HibernateDaoSupport implements TeacherResourceManageDAO{
	
	/**
	 * <p>���ܣ����ݸ��˱�Ų�����صĿγ���Ϣ<br>
	 * @param FUserNumber ���˱��
	 * @return list ���ؿγ���Ϣ
	 */
	public List<TabCourse> findCourseInfoUpload(String FUserNumber) {
		// TODO Auto-generated method stub
		
		String sql = "select distinct j.tabCourse from JfptTabTeacherassociate j where j.tabTeachers.FTeacherNumber='"+FUserNumber+"'";
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		String sql2 = "select distinct j.tabCourse from JfptTabChooseassociate j where j.tabTeachers.FTeacherNumber='"+FUserNumber+"'";
		List<TabCourse> list2 = this.getHibernateTemplate().find(sql2);
		if(list2.size()<=0){
			return list;
		}
		for(TabCourse i: list2){
			list.add(i);
		}
		return list;
	}

	/**
	 * <p>���ܣ�����ϴ���Դ��Ϣ<br>
	 * @param jfptTabUploadfile ��Դ��Ϣ
	 */
	public void addUploadInfo(JfptTabUploadfile jfptTabUploadfile) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabUploadfile);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų�����صĿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse���γ���Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų���User������Ϣ<br>
	 * @param FUserNumber ���˱��
	 * @return MhqxTabUser User������Ϣ
	 */
	public MhqxTabUser findUserInfoByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber);
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
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param tid ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findUploadfileInfo(String tid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabUploadfile j where j.mhqxTabUser.FUserNumber='"+tid+"'";
		List<JfptTabUploadfile> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�������Դ��Ϣid������Դɾ��<br>
	 * @param FNumber ��Դ��Ϣid��
	 */
	public void deleteUpfileInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		JfptTabUploadfile jfptTabUploadfile = new JfptTabUploadfile();
		jfptTabUploadfile = (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
		UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\CourseAbout\\", jfptTabUploadfile.getFFileName());
		this.getHibernateTemplate().delete(jfptTabUploadfile);
	}

	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUploadfile)this.getHibernateTemplate().get(JfptTabUploadfile.class, FNumber);
	}

}
