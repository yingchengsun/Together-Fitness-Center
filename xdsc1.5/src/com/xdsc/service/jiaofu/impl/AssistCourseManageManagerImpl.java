package com.xdsc.service.jiaofu.impl;

import java.io.File;
import java.util.List;

import com.xdsc.dao.jiaofu.AssistCourseManageDAO;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.AssistCourseManageManager;
/**
 * <p>���ܣ����̿γ̹�����صĲ����������γ���Ϣ��ѯ���γ�֪ͨ����Ӻ�ɾ�����γ̴��ɵĲ��ҡ�ɾ���ͻظ���<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AssistCourseManageManagerImpl implements AssistCourseManageManager{
	/**DAO�����*/
	private AssistCourseManageDAO assistCourseManageDAO;

	public AssistCourseManageDAO getAssistCourseManageDAO() {
		return assistCourseManageDAO;
	}

	public void setAssistCourseManageDAO(AssistCourseManageDAO assistCourseManageDAO) {
		this.assistCourseManageDAO = assistCourseManageDAO;
	}

	/**
	 * <p>���ܣ���������id�Ų�����֮��صĿγ���Ϣ<br>
	 * @param id ����id��
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfoByAid(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseInfoByAid(id);
	}

	/**
	 * <p>���ܣ���ӿγ̴��ɻظ�<br>
	 * @param jfptTabCoursereplyquestion �γ̴��ɻظ�������Ϣ
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.addCoursereplyInfo(jfptTabCoursereplyquestion);
	}

	/**
	 * <p>���ܣ����ݿγ̴��ɶ���idɾ����֮ƥ��Ĵ�����Ϣ<br>
	 * @param id ���ɶ���id��
	 */
	public void deleteAskQuestionByID(int id) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.deleteAskQuestionByID(id);
	}

	/**
	 * <p>���ܣ����ݿγ̴���id�Ų�����صĻظ���Ϣ<br>
	 * @param id �γ̴��ɵ�id��
	 * @return list ��صĻظ���Ϣ
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseReplyInfoByID(id);
	}

	/**
	 * <p>���ܣ�ͨ���γ̴���id�Ų�����֮ƥ��Ķ�����Ϣ<br>
	 * @param id �γ̴���id��
	 * @return JfptTabCourseaskquestion ������صĿγ̴��ɶ�����Ϣ
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseaskquestionInfoByID(id);
	}

	/**
	 * <p>���ܣ���������id�źͿγ̱�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ����id��
	 * @param FCourseNumber �γ̱��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findQuestionReplayInfoByTwo(id, FCourseNumber);
	}

	/**
	 * <p>���ܣ���������id�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ����id��
	 * @return list ���ز��ҵ�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoByAid(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findQuestionReplyInfoByAid(id);
	}

	/**
	 * <p>���ܣ���ӿγ�֪ͨ��Ϣ<br>
	 * @param jfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public void addCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.addCoursenotice(jfptTabCoursenotice);
	}

	/**
	 * <p>���ܣ���ӿγ�֪ͨ�Ķ�Ӧ����������Ϣ<br>
	 * @param jfptTabNoticetoreceive �γ�֪ͨ��Ӧ�Ĺ���������Ϣ
	 */
	public void addCoursenoticetoto(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.addCoursenoticetoto(jfptTabNoticetoreceive);
	}

	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ϣ<br>
	 * @param jfptTabCoursenotice �γ�֪ͨ������Ϣ
	 */
	public void deleteCourseNoticeInfo(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.deleteCourseNoticeInfo(jfptTabCoursenotice);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų�����صĿγ���Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse ������صĿγ̶�����Ϣ
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseInfoByID(id);
	}

	/**
	 * <p>���ܣ�����id�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id ���˱��
	 * @return list �γ�֪ͨ������Ϣ
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseNoticeInfo(id);
	}

	/**
	 * <p>���ܣ����ݿγ�֪ͨid�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id �γ�֪ͨid��
	 * @return JfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findCourseNoticeInfoByID(id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̺Ų�����ص�ѧ����Ϣ<br>
	 * @param id ���˱��
	 * @param Coursenumber �γ̱��
	 * @return list ѧ����Ϣ <br>list3 ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,
			String Coursenumber) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findStudentsInfoByTwo(id, Coursenumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų���User����<br>
	 * @param id�����˱��
	 * @return MhqxTabUser ���ز��ҵ�����User��Ϣ
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findUserByID(id);
	}

	/**
	 * <p>���ܣ������ļ�<br>
	 * @see com.xdsc.util.UpDownFileUtils
	 * @param uploadFile �ϴ��ļ�
	 * @param savePath ����·��
	 * @param uploadFileFileName �ļ�����
	 */
	public void savefile(File uploadFile, String savePath,
			String uploadFileFileName) {
		// TODO Auto-generated method stub
		assistCourseManageDAO.savefile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����صİ༶����Ϣ<br>
	 * @param id ���˱��
	 * @param FCourseNumber �γ̱��
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findClassNumberInfo(java.lang.String, java.lang.String)
	 * @return list �༶����Ϣ
	 */
	public List<String> findClassNumberInfo(String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findClassNumberInfo(id, FCourseNumber);
	}

	/**
	 * <p>���ܣ�����ָ����Χ�ڵ�ѧ���ķ�����Ϣ<br>
	 * @param listStudentsInfo ѧ����Ϣ
	 * @param FCourseNumber �γ̱����Ϣ
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findDirectionInfo(java.util.List, java.lang.String)
	 * @return list ������Ϣ
	 */
	public List<TabDirection> findDirectionInfo(
			List<TabStudents> listStudentsInfo, String FCourseNumber) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findDirectionInfo(listStudentsInfo, FCourseNumber);
	}

	/**
	 * <p>���ܣ����ݰ༶�š��������ָ����Χ�ڵ�ѧ���в������ѧ����Ϣ<br>
	 * @param ClassNumber �༶��
	 * @param DirectionNumber ������
	 * @param listStudentsInfo��ѧ����Ϣ
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findStudentsInfo(java.lang.String, int, java.util.List)
	 * @return listt ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		return assistCourseManageDAO.findStudentsInfo(ClassNumber, DirectionNumber, listStudentsInfo);
	}
}
