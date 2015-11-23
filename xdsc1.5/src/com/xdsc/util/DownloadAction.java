package com.xdsc.util;

import java.io.InputStream;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;

public class DownloadAction implements Action {
	// 需要下载的文件路径
	private String downloadPath;

	// 因为不需要得到文件的路径所以只需要给出他的setter方法
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	// 对于上边的文件路径，给出他的输入流，对应在配置文件中的InputName属性名
	public InputStream getTargetFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				downloadPath);
	}

	// execute方法只需返回SUCCESS
	public String execute() throws Exception{
		return SUCCESS;
	}
}
