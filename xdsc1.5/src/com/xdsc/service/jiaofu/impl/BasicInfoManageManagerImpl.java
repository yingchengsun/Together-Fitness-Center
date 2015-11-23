package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.BasicInfoManageDAO;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabCoursetype;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.BasicInfoManageManager;
/**
 * <p>���ܣ��漰�̸�������Ϣ�����е���ز��������ѯ�γ���Ϣ����ѯ������Ϣ����ѯ�γ����͡�������Ϣ�ȣ�ͬʱ��һЩ<br>
 * ��Ϣ����ɸѡɾ�������µ�<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class BasicInfoManageManagerImpl implements BasicInfoManageManager{
	/**DAO�����*/
	private BasicInfoManageDAO basicInfoManageDAO;
	
	public BasicInfoManageDAO getBasicInfoManageDAO() {
		return basicInfoManageDAO;
	}

	public void setBasicInfoManageDAO(BasicInfoManageDAO basicInfoManageDAO) {
		this.basicInfoManageDAO = basicInfoManageDAO;
	}

	//----------------------------�γ����------------------------------------
	/**
	 * <p>���ܣ���ѯ�γ̻�����Ϣ<br>
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfo() {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findCourseInfo();
	}

	/**
	 * <p>���ܣ�ɾ���γ���Ϣ<br>
	 * @param tabCourse �γ���Ϣ����
	 */
	public void deleteCourseInfo(TabCourse tabCourse) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.deleteCourseInfo(tabCourse);
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ҵ��Ŀγ���Ϣ����
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>���ܣ���ӿγ���Ϣ<br>
	 * @param tabCourse���γ����Ͷ���
	 */
	public void addTabCourseInfo(TabCourse tabCourse) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.addTabCourseInfo(tabCourse);
	}

	/**
	 * <p>���ܣ����¿γ���Ϣ<br>
	 * @param tabCourse �γ���Ϣ����
	 */
	public void updateCourseInfo(TabCourse tabCourse) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.updateCourseInfo(tabCourse);
	}

	/**
     * <p>���ܣ����ݿγ����Ʋ�����صĿγ���Ϣ<br>
     * @param FCourseNameselect �γ�����
     * @return list ��ѯ�����Ŀγ���Ϣ
     */
	public List<TabCourse> findCourseInfoByName(String FCourseNameselect) {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findCourseInfoByName(FCourseNameselect);
	}

	//----------------------------�������------------------------------------
	/**
	 * <p>���ܣ����ҷ�����Ϣ<br>
	 * @return list ���ҵ���������Ϣ
	 */
	public List<TabDirection> findDirectionInfo() {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findDirectionInfo();
	}

	/**
	 * <p>���ܣ�ɾ��������Ϣ<br>
	 * @param tabDirection �������Ͷ���
	 */
	public void deleteDirectionInfo(TabDirection tabDirection) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.deleteDirectionInfo(tabDirection);
	}

	/**
	 * <p>���ܣ����ݷ���Id�Ų��ҷ�����Ϣ<br>
	 * @param FDirectionId ����Id��
	 * @return TabDirection ���ز��ҵ��ķ�����Ϣ
	 */
	public TabDirection findDirectionByID(int FDirectionId) {
		return basicInfoManageDAO.findDirectionByID(FDirectionId);
	}

	/**
	 * <p>���ܣ���ӷ�����Ϣ<br>
	 * @param tabDirection �������
	 */
	public void addDirectionInfo(TabDirection tabDirection) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.addDirectionInfo(tabDirection);
	}

	//----------------------------���������------------------------------------
	/**
	 * <p>���ܣ����ҿγ�������Ϣ<br>
	 * @return list �γ�������Ϣ
	 */
	public List<TabCoursetype> findCoursetypeInfo() {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findCoursetypeInfo();
	}

	/**
	 * <p>���ܣ���������Id�Ų��ҿγ�������Ϣ<br>
	 * @param FNumber ������ϢID��
	 * @return TabCoursetype ���ز��ҵ��Ķ�����Ϣ
	 */
	public TabCoursetype findCoursetypeInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findCoursetypeInfoByID(FNumber);
	}

	/**
	 * <p>���ܣ�ɾ���γ�������Ϣ<br>
	 * @param tabCoursetype �γ����Ͷ�����Ϣ
	 */
	public void deleteCoursetypeInfo(TabCoursetype tabCoursetype) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.deleteCoursetypeInfo(tabCoursetype);
	}

	/**
	 * <p>���ܣ���ӿγ�������Ϣ<br>
	 * @param tabCoursetype �γ�������Ϣ
	 */
	public void addTabCoursetype(TabCoursetype tabCoursetype) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.addTabCoursetype(tabCoursetype);
	}

	//------------------------��ʦ��غ���------------------------------------------
	/**
	 * <p>���ܣ����ҽ�ʦ��Ϣ<br>
	 * @return list ��ʦ��Ϣ
	 */
	public List<TabTeachers> findTeacherInfo() {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findTeacherInfo();
	}

	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ��Ϣ<br>
	 * @return TabTeachers ���ؽ�ʦ��Ϣ
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findTeacherInfoByID(FTeacherNumber);
	}

	/**
	 * <p>���ܣ�ɾ����ʦ��Ϣ<br>
	 * @param tabTeachers ��ʦ��Ϣ����
	 */
	public void deleteTeacherInfo(TabTeachers tabTeachers) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.deleteTeacherInfo(tabTeachers);
	}

	/**
	 * <p>���ܣ���ӽ�ʦ��Ϣ<br>
	 * @param tabTeachers ��ʦ������Ϣ
	 */
	public void addTeacherInfo(TabTeachers tabTeachers) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.addTeacherInfo(tabTeachers);
	}

	//---------------------------------�������------------------------------------
	/**
	 * <p>���ܣ�����Ժ��������Ϣ<br>
	 * @return list ���ز��ҵ���������Ϣ
	 */
	public List<JfptTabOtherassist> findOtherInfo() {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findOtherInfo();
	}

	/**
	 * <p>���ܣ�ɾ��Ժ��������Ϣ<br>
	 * @param jfptTabOtherassist Ժ��������Ϣ
	 */
	public void deleteOtherInfo(JfptTabOtherassist jfptTabOtherassist) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.deleteOtherInfo(jfptTabOtherassist);
	}

	/**
	 * <p>���ܣ�����Ժ������Id�Ų�������Ϣ<br>
	 * @param FAssistantId ����Id��
	 * @return JfptTabOtherasist ����������Ϣ
	 */
	public JfptTabOtherassist findOtherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return basicInfoManageDAO.findOtherInfoByID(FAssistantId);
	}

	/**
	 * <p>���ܣ����Ժ��������Ϣ<br>
	 * @param jfptTabOtherassist1 ���̶�����Ϣ
	 */
	public void addOtherInfo(JfptTabOtherassist jfptTabOtherassist1) {
		// TODO Auto-generated method stub
		basicInfoManageDAO.addOtherInfo(jfptTabOtherassist1);
	}
}
