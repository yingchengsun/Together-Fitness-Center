package com.xdsc.action.sjjx_system;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**�������صĹ�����
 * @author ��ѩ
 * @version1.1
 */
public class SjjxFileDownLoadAction extends ActionSupport {

	/**
	 * �ļ�������
	 * ��װ���ļ��ϴ��ķ���
	 */
	private String fileName;

	
	public void setFileName() {
		String fname = ServletActionContext.getRequest().getParameter("name");

         
        //��fname��������UTF-8����,ע��:ʵ�ʽ���UTF-8����ʱ��ʹ�ñ��ر��룬����ΪGBK�� 
        //����ʹ��request.setCharacterEncoding������Ч. 
        //ֻ�н�����,getInputStream()��������������Ŀ¼����ȷ�ҵ�������ļ� 
		
		  try {
			fname = new String(fname.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		this.fileName=fname;
		System.out.println("In FileDownloadAction.java :"+fileName);

	}
	

     
     
	/**�˷�����Ӧ����struts.xml�ļ��еģ�
	 * <param name="contentDisposition">attachment;filename="${fileName}"</param> 
	 * @return �ļ���
	 * @throws UnsupportedEncodingException
	 */
	public String getFileName() throws UnsupportedEncodingException { 
		   
		//������ISO-8859-1���н���
        fileName=new String(fileName.getBytes(),"ISO-8859-1"); 
 
        return fileName; 
    } 
	
	
	  /**inputStream���Ե�getter������StreamResult�������ʹ�ø���������ȡ�����ļ�������
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream() throws Exception
	  {
		  System.out.println("In InputStream's getInputStream method");
		  String path = ServletActionContext.getServletContext().getRealPath("/newsFile/uploadFile/");
		  this.setFileName();
		  System.out.println("InputStream..."+ServletActionContext.getServletContext().getResourceAsStream(
                "/newsFile/uploadFile/" + this.fileName));
		  return ServletActionContext.getServletContext().getResourceAsStream(
                "/newsFile/uploadFile/" + this.fileName);
	  }
	  
	  @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
