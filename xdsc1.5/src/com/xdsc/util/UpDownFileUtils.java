package com.xdsc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

/**
 * <p>�����ļ���ɾ���ļ�<br>
 * @author qianxun
 * @version 1.1
 */
public class UpDownFileUtils {

	/**
	 * <p>���ܣ������ļ����ơ�����·�����ļ����󱣴����<br>
	 * @param file �ϴ��ļ�
	 * @param savePath �ļ�����·��
	 * @param fileName �ļ�����
	 * @throws FileNotFoundException <br>IOException
	 * @see org.apache.struts2.ServletActionContext
	 */
	public static void saveFile(File file, String savePath, String fileName){
		
		FileOutputStream fos=null;
		String imagePath=ServletActionContext.getServletContext().getRealPath(savePath)+"\\"+fileName;
		byte[] buffer=new byte[1024];
		try {
			fos=new FileOutputStream(imagePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int len=0;
		try {
			while((len=fis.read(buffer))>0){
				fos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>���ܣ������ļ�·�����ļ�����ɾ���ļ�<br>
	 * @param savePath �ļ�����·��
	 * @param fileName �ļ�����
	 * @see org.apache.struts2.ServletActionContext
	 */
	public static void deleteFile(String savePath, String fileName){
		String filePath=ServletActionContext.getServletContext().getRealPath(savePath)+"\\"+fileName;
		File file=new File(filePath);
		file.delete();
	}
}
