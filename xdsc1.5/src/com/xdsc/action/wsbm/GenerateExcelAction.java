package com.xdsc.action.wsbm;

import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.service.wsbm.WsbmTabRegapplicantService;

/**���ɿ���������ϢExcel���
 * @author ��С��
 *@version 1.2
 */
public class GenerateExcelAction extends ActionSupport
{
	/**
	 * service ���������
	 */
	private WsbmTabRegapplicantService service;

	public WsbmTabRegapplicantService getService()
	{
		return service;
	}

	public void setService(WsbmTabRegapplicantService service)
	{
		this.service = service;
	}
	
	public InputStream getDownloadFile()
	{
		return this.service.getInputStream();
	}
	
	
	/**����Excel�������
	 *@return SUCCESS ����excel���ɹ�
	 */
	public String execute() throws Exception
	{
		return SUCCESS;
	}
}
