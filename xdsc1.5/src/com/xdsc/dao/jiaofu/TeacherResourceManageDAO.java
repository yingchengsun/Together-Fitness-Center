package com.xdsc.dao.jiaofu;

import java.io.File;
import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
/**
 * <p>���ܣ�������Դ���ҡ��ϴ���ɾ���Ȳ���<br>
 * @author qianxun
 * @version 1.1
 */
public interface TeacherResourceManageDAO {

	/**
	 * <p>���ܣ����ݸ��˱�Ų�����صĿγ���Ϣ<br>
	 * @param FUserNumber ���˱��
	 * @return list ���ؿγ���Ϣ
	 */
	public List<TabCourse> findCourseInfoUpload(String FUserNumber);
	
	/**
	 * <p>���ܣ�����ϴ���Դ��Ϣ<br>
	 * @param jfptTabUploadfile ��Դ��Ϣ
	 */
	public void addUploadInfo(JfptTabUploadfile jfptTabUploadfile);
	
	/**
	 * <p>���ܣ����ݿγ̱�Ų�����صĿγ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse���γ���Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber);
	
	/**
	 * <p>���ܣ����ݸ��˱�Ų���User������Ϣ<br>
	 * @param FUserNumber ���˱��
	 * @return MhqxTabUser User������Ϣ
	 */
	public MhqxTabUser findUserInfoByID(String FUserNumber);
	
	/**
	 * <p>���ܣ������ļ�<br>
	 * @param uploadFile �ϴ��ļ�
	 * @param savePath ����·��
	 * @param uploadFileFileName �ļ�����
	 */
	public void savefile(File uploadFile,String savePath,String uploadFileFileName);
	
	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param tid ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findUploadfileInfo(String tid);
	
	/**
	 * <p>���ܣ�������Դ��Ϣid������Դɾ��<br>
	 * @param FNumber ��Դ��Ϣid��
	 */
	public void deleteUpfileInfoByID(int FNumber);
	
	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}
