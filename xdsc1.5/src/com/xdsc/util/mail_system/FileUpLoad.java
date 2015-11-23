package com.xdsc.util.mail_system;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

/** �ļ��ϴ��Ĺ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class FileUpLoad {
	
	/**�ļ��ϴ��ķ���
	 * @param uploads ���ϴ����ļ�����
	 * @param fileNames �ļ�������
	 * @param uploadContentTypes �ļ�����
	 * @return ���������ļ�������
	 * @throws Exception
	 */
	public List<String> fileUpLoad(List<File> uploads,
			                       List<String> fileNames,
			                       List<String> uploadContentTypes) throws Exception{
		String uploadDir = "/WEB-INF/upload/";
		
		//������ʱ�洢��������ļ����ı���
		List<String> tempFileNameContainer = new ArrayList<String>(0);
		String tempFileName = null;
		String newfileName = null;

		long nowtime = new Date().getTime();

		// �õ�uploadDir��realpath
		String path = ServletActionContext.getServletContext().getRealPath(
				uploadDir);
		
		System.out.println("In FileUpLoad.java to show the uploadDir..."+path);

		File dir = new File(path);
		if (!dir.exists())
			dir.mkdir();
		for (int i = 0; i < uploads.size(); i++) {

			// �ж��Ƿ�����ļ���չ��
			int index = fileNames.get(i).lastIndexOf(".");
			if (index != -1)
				newfileName = nowtime + fileNames.get(i).substring(index);
			else
				newfileName = Long.toString(nowtime);
			
			//���ϴ����������ϵĸ����ļ�·�����뵽container��
			tempFileName = path+"/"+newfileName;
			tempFileNameContainer.add(tempFileName);
			
			BufferedOutputStream bos = null;
			BufferedInputStream bis = null;
			// ��ȡ��������ʱĿ¼�µ��ϴ��ļ���д�뵽�µ��ļ��С�
			try {
				bis = new BufferedInputStream(new FileInputStream(uploads.get(i)));
				bos = new BufferedOutputStream(new FileOutputStream(new File(
						dir, newfileName)));

				byte[] buf = new byte[4096];
				int len = -1;
				while ((len = bis.read(buf)) != -1) {
					bos.write(buf, 0, len);
				}
			} finally {
				try {
					if (null != bis)
						bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					if (null != bos)
						bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return tempFileNameContainer;
	}

}
