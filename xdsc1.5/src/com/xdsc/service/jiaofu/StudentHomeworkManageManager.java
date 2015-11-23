package com.xdsc.service.jiaofu;

import java.io.File;
import java.util.List;

import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
/**
 * <p>���ܣ��й���ҵ�������漰���ķ�����������ҵ֪ͨ����ҵ���ġ��ɼ������<br>
 * @author qianxun
 * @version 1.1
 */
public interface StudentHomeworkManageManager {

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų������Ӧ����ҵ������Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return list ���ض�Ӧ��Ϣ
	 */
	public List<JfptTabHomenoticetoreceive> findHomeNoticetotoInfoBySid(String sid);
	
	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų��������ϸ��Ϣ<br>
	 * @param FHomeNoticeId ��ҵ֪ͨid��
	 * @return JfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public JfptTabHomenotice findHomeDetailByID(int FHomeNoticeId);
	
	/**
	 * <p>���ܣ�������ҵ���ö�Ӧ��Ϣid�Ų��������Ϣ<br>
	 * @param FNumber ������Ϣid��
	 * @return JfptTabHomenoticetireceive ��ҵ���ö�Ӧ��Ϣ
	 */
	public JfptTabHomenoticetoreceive findHomeNoticetotoInfoByID(int FNumber);
	
	/**
	 * <p>���ܣ�ɾ����ҵ��Ӧ������Ϣ<br>
	 * @param jfptTabHomenoticetoreceive ��ҵ���ö�Ӧ��Ϣ
	 */
	public void deleteHomeNoticetoto(JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive);
	
	/**
	 * <p>���ܣ�������ҵ������Ϣ<br>
	 * @param jfptTabHomenoticetoreceive ��ҵ������Ϣ
	 */
	public void updateHomenoticetoto(JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive);
	
	/**
	 * <p>���ܣ������Լ��ύ����ҵ��Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return list ��ҵ�ύ��Ϣ
	 */
	public List<JfptTabHomeupload> findHomeUploadInfoBySid(String sid);
	
	/**
	 * <p>���ܣ������ϴ���ҵ��Ϣid�Ų��������ϸ��Ϣ<br>
	 * @param FHomeId �ϴ���ҵ��Ϣid��
	 * @return JfptTabHomeupload �ϴ���ҵ������Ϣ
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int FHomeId);
	
	/**
	 * <p>���ܣ�������ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ����
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload);
	
	/**
	 * <p>���ܣ�ɾ����ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ�ϴ���Ϣ
	 */
	public void deleteHomeworkInfo(JfptTabHomeupload jfptTabHomeupload);
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�����صĿγ���Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findCourseInfoBySid(String sid);
	
	/**
	 * <p>���ܣ����ݿγ̺Ų��ҿγ���ϸ��Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse �γ������Ϣ
	 */
	public TabCourse findCourseInfoByID(String id);
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param sid ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsInfoBySid(String sid);
	
	/**
	 * <p>���ܣ������ļ�<br>
	 * @param uploadFile �ϴ��ļ�
	 * @param savePath ����·��
	 * @param uploadFileFileName �ļ�����
	 */
	public void savefile(File uploadFile,String savePath,String uploadFileFileName);
	
	/**
	 * <p>���ܣ��ύ��ҵ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ
	 */
	public void addHomeworkInfo(JfptTabHomeupload jfptTabHomeupload);
}
