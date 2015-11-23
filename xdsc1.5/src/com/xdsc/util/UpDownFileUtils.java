package com.xdsc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

/**
 * <p>保存文件和删除文件<br>
 * @author qianxun
 * @version 1.1
 */
public class UpDownFileUtils {

	/**
	 * <p>功能：根据文件名称、保存路径、文件对象保存对象<br>
	 * @param file 上传文件
	 * @param savePath 文件保存路径
	 * @param fileName 文件名称
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
	 * <p>功能：根据文件路径和文件名称删除文件<br>
	 * @param savePath 文件保存路径
	 * @param fileName 文件名称
	 * @see org.apache.struts2.ServletActionContext
	 */
	public static void deleteFile(String savePath, String fileName){
		String filePath=ServletActionContext.getServletContext().getRealPath(savePath)+"\\"+fileName;
		File file=new File(filePath);
		file.delete();
	}
}
