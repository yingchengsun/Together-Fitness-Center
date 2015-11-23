package com.xdsc.action.mail_system;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**封装的文件上传的工具类
 * @author 郑灿双 2010-04-10
 * @version 1.1
 */
public class FileDownloadAction extends ActionSupport {

	/**
	 * 文件名属性
	 * 封装的文件上传的方法
	 */
	private String fileName;

	
	public void setFileName() {
		String fname = ServletActionContext.getRequest().getParameter("name");

         
        //对fname参数进行UTF-8解码,注意:实际进行UTF-8解码时会使用本地编码，本机为GBK。 
        //这里使用request.setCharacterEncoding解码无效. 
        //只有解码了,getInputStream()方法才能在下载目录下正确找到请求的文件 
		
		  try {
			fname = new String(fname.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		this.fileName=fname;
		System.out.println("In FileDownloadAction.java :"+fileName);

	}
	

     
     
	/**此方法对应的是struts.xml文件中的：
	 * <param name="contentDisposition">attachment;filename="${fileName}"</param> 
	 * @return 文件名
	 * @throws UnsupportedEncodingException
	 */
	public String getFileName() throws UnsupportedEncodingException { 
		   
		//必须以ISO-8859-1进行解码
        fileName=new String(fileName.getBytes(),"ISO-8859-1"); 
 
        return fileName; 
    } 
	
	
	  /**inputStream属性的getter方法，StreamResult结果类型使用该属性来读取下载文件的内容
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream() throws Exception
	  {
		  System.out.println("In InputStream's getInputStream method");
		  String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload/");
		  this.setFileName();
		  System.out.println("InputStream..."+ServletActionContext.getServletContext().getResourceAsStream(
                  "/WEB-INF/upload/" + this.fileName));
		  return ServletActionContext.getServletContext().getResourceAsStream(
                  "/WEB-INF/upload/" + this.fileName);
	  }
	  
	  @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
