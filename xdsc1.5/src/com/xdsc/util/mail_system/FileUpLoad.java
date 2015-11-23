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

/** 文件上传的工具类
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class FileUpLoad {
	
	/**文件上传的方法
	 * @param uploads 待上传的文件集合
	 * @param fileNames 文件名集合
	 * @param uploadContentTypes 文件类型
	 * @return 服务器上文件名集合
	 * @throws Exception
	 */
	public List<String> fileUpLoad(List<File> uploads,
			                       List<String> fileNames,
			                       List<String> uploadContentTypes) throws Exception{
		String uploadDir = "/WEB-INF/upload/";
		
		//用于临时存储多个附件文件名的变量
		List<String> tempFileNameContainer = new ArrayList<String>(0);
		String tempFileName = null;
		String newfileName = null;

		long nowtime = new Date().getTime();

		// 得到uploadDir的realpath
		String path = ServletActionContext.getServletContext().getRealPath(
				uploadDir);
		
		System.out.println("In FileUpLoad.java to show the uploadDir..."+path);

		File dir = new File(path);
		if (!dir.exists())
			dir.mkdir();
		for (int i = 0; i < uploads.size(); i++) {

			// 判断是否带有文件扩展名
			int index = fileNames.get(i).lastIndexOf(".");
			if (index != -1)
				newfileName = nowtime + fileNames.get(i).substring(index);
			else
				newfileName = Long.toString(nowtime);
			
			//将上传到服务器上的附件文件路径加入到container中
			tempFileName = path+"/"+newfileName;
			tempFileNameContainer.add(tempFileName);
			
			BufferedOutputStream bos = null;
			BufferedInputStream bis = null;
			// 读取保存在临时目录下的上传文件，写入到新的文件中。
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
