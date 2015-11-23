package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabCoursetype;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabTeachers;
/**
 * <p>���ܣ��漰�̸�������Ϣ�����е���ز��������ѯ�γ���Ϣ����ѯ������Ϣ����ѯ�γ����͡�������Ϣ�ȣ�ͬʱ��һЩ<br>
 * ��Ϣ����ɸѡɾ�������µ�<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface BasicInfoManageManager {

	//--------------------�γ����----------------------
	/**
	 * <p>���ܣ���ѯ�γ̻�����Ϣ<br>
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfo();
	
	/**
	 * <p>���ܣ�ɾ���γ���Ϣ<br>
	 * @param tabCourse �γ���Ϣ����
	 */
	public void deleteCourseInfo(TabCourse tabCourse);
	
	/**
	 * <p>���ܣ����ݿγ̱�Ų��ҿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse ���ҵ��Ŀγ���Ϣ����
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber);
	
	/**
	 * <p>���ܣ���ӿγ���Ϣ<br>
	 * @param tabCourse���γ����Ͷ���
	 */
	public void addTabCourseInfo(TabCourse tabCourse);
	
	/**
	 * <p>���ܣ����¿γ���Ϣ<br>
	 * @param tabCourse �γ���Ϣ����
	 */
	public void updateCourseInfo(TabCourse tabCourse);
	
	/**
     * <p>���ܣ����ݿγ����Ʋ�����صĿγ���Ϣ<br>
     * @param FCourseNameselect �γ�����
     * @return list ��ѯ�����Ŀγ���Ϣ
     */
	public List<TabCourse> findCourseInfoByName(String FCourseNameselect);
	
	//--------------------�������----------------------
	/**
	 * <p>���ܣ����ҷ�����Ϣ<br>
	 * @return list ���ҵ���������Ϣ
	 */
	public List<TabDirection> findDirectionInfo();
	
	/**
	 * <p>���ܣ�ɾ��������Ϣ<br>
	 * @param tabDirection �������Ͷ���
	 */
	public void deleteDirectionInfo(TabDirection tabDirection);
	
	/**
	 * <p>���ܣ����ݷ���Id�Ų��ҷ�����Ϣ<br>
	 * @param FDirectionId ����Id��
	 * @return TabDirection ���ز��ҵ��ķ�����Ϣ
	 */
	public TabDirection findDirectionByID(int FDirectionId);
	
	/**
	 * <p>���ܣ���ӷ�����Ϣ<br>
	 * @param tabDirection �������
	 */
	public void addDirectionInfo(TabDirection tabDirection);
	
	//--------------------�������----------------------
	/**
	 * <p>���ܣ����ҿγ�������Ϣ<br>
	 * @return list �γ�������Ϣ
	 */
	public List<TabCoursetype> findCoursetypeInfo();
	
	/**
	 * <p>���ܣ���������Id�Ų��ҿγ�������Ϣ<br>
	 * @param FNumber ������ϢID��
	 * @return TabCoursetype ���ز��ҵ��Ķ�����Ϣ
	 */
	public TabCoursetype findCoursetypeInfoByID(int FNumber);
	
	/**
	 * <p>���ܣ�ɾ���γ�������Ϣ<br>
	 * @param tabCoursetype �γ����Ͷ�����Ϣ
	 */
	public void deleteCoursetypeInfo(TabCoursetype tabCoursetype);
	
	/**
	 * <p>���ܣ���ӿγ�������Ϣ<br>
	 * @param tabCoursetype �γ�������Ϣ
	 */
	public void addTabCoursetype(TabCoursetype tabCoursetype);
	
	//------------------------��ʦ���------------------------------------------
	/**
	 * <p>���ܣ����ҽ�ʦ��Ϣ<br>
	 * @return list ��ʦ��Ϣ
	 */
	public List<TabTeachers> findTeacherInfo();
	
	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų��ҽ�ʦ��Ϣ<br>
	 * @return TabTeachers ���ؽ�ʦ��Ϣ
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber);
	
	/**
	 * <p>���ܣ�ɾ����ʦ��Ϣ<br>
	 * @param tabTeachers ��ʦ��Ϣ����
	 */
	public void deleteTeacherInfo(TabTeachers tabTeachers);
	
	/**
	 * <p>���ܣ���ӽ�ʦ��Ϣ<br>
	 * @param tabTeachers ��ʦ������Ϣ
	 */
	public void addTeacherInfo(TabTeachers tabTeachers);
	
	//---------------------------------�������------------------------------------
	/**
	 * <p>���ܣ�����Ժ��������Ϣ<br>
	 * @return list ���ز��ҵ���������Ϣ
	 */
	public List<JfptTabOtherassist> findOtherInfo();
	
	/**
	 * <p>���ܣ�ɾ��Ժ��������Ϣ<br>
	 * @param jfptTabOtherassist Ժ��������Ϣ
	 */
	public void deleteOtherInfo(JfptTabOtherassist jfptTabOtherassist);
	
	/**
	 * <p>���ܣ�����Ժ������Id�Ų�������Ϣ<br>
	 * @param FAssistantId ����Id��
	 * @return JfptTabOtherasist ����������Ϣ
	 */
	public JfptTabOtherassist findOtherInfoByID(String FAssistantId);
	
	/**
	 * <p>���ܣ����Ժ��������Ϣ<br>
	 * @param jfptTabOtherassist1 ���̶�����Ϣ
	 */
	public void addOtherInfo(JfptTabOtherassist jfptTabOtherassist1);
}
