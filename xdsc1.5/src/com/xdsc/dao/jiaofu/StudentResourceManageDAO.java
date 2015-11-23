package com.xdsc.dao.jiaofu;

import java.io.File;
import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
/**
 * <p>���ܣ�������Դ���ҵȲ���<br>
 * @author qianxun
 * @version 1.1
 */
public interface StudentResourceManageDAO {

	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param id ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findUploadfileInfoByID(String id);
	
	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}
