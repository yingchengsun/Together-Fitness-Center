package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabUploadfile;
/**
 * <p>���ܣ�������Դ���ҵȲ���<br>
 * @author qianxun
 * @version 1.1
 */
public interface AssistResourceManageManager {

	/**
	 * <p>���ܣ����ݸ��˱����ص���Դ<br>
	 * @param id ���˱��
	 * @return list ������ص���Դ��Ϣ
	 */
	public List<JfptTabUploadfile> findResourceInfoByID(String id);
	
	/**
	 * <p>���ܣ�������Դid�Ų��������Դ��Ϣ<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ��Ϣ����
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber);
}
