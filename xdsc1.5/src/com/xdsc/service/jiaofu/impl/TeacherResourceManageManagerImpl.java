package com.xdsc.service.jiaofu.impl;

import java.io.File;
import java.util.List;

import com.xdsc.dao.jiaofu.TeacherResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.service.jiaofu.TeacherResourceManageManager;
/**
 * <p>���ܣ�������Դ���ҡ��ϴ���ɾ���Ȳ���<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherResourceManageManagerImpl implements TeacherResourceManageManager{
	/**DAO�����*/
	private TeacherResourceManageDAO teacherResourceManageDAO;

	public void setTeacherResourceManageDAO(TeacherResourceManageDAO teacherResourceManageDAO) {
		this.teacherResourceManageDAO = teacherResourceManageDAO;
	}

	public TeacherResourceManageDAO getTeacherResourceManageDAO() {
		return teacherResourceManageDAO;
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų�����صĿγ���Ϣ<br>
	 * @param FUserNumber ���˱��
	 * @return list ���ؿγ���Ϣ
	 */
	public List<TabCourse> findCourseInfoUpload(String FUserNumber) {
		// TODO Auto-generated method stub
		return teacherResourceManageDAO.findCourseInfoUpload(FUserNumber);
	}

	/**
	 * <p>���ܣ�����ϴ���Դ��Ϣ<br>
	 * @param jfptTabUploadfile ��Դ��Ϣ
	 */
	public void addUploadInfo(JfptTabUploadfile jfptTabUploadfile) {
		// TODO Auto-generated method stub
		teacherResourceManageDAO.addUploadInfo(jfptTabUploadfile);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų�����صĿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse���γ���Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return teacherResourceManageDAO.findCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų���User������Ϣ<br>
	 * @param FUserNumber ���˱��
	 * @return MhqxTabUser User������Ϣ
	 */
	public MhqxTabUser findUserInfoByID(String FUserNumber) {
		// TODO Auto-generated method stub
		return teacherResourceManageDAO.findUserInfoByID(FUserNumber);
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
		teacherResourceManageDAO.savefile(uploadFile, savePath, uploadFileFileName);
	}
	
	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param tid ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findUploadfileInfo(String tid) {
		// TODO Auto-generated method stub
		return teacherResourceManageDAO.findUploadfileInfo(tid);
	}

	/**
	 * <p>���ܣ�������Դ��Ϣid������Դɾ��<br>
	 * @param FNumber ��Դ��Ϣid��
	 */
	public void deleteUpfileInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		teacherResourceManageDAO.deleteUpfileInfoByID(FNumber);
	}

	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return teacherResourceManageDAO.findUploadfileByID(FNumber);
	}
}
