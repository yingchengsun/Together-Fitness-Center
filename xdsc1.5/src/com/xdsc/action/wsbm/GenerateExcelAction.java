package com.xdsc.action.wsbm;

import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.service.wsbm.WsbmTabRegapplicantService;

/**生成考生基本信息Excel表格
 * @author 苟小龙
 *@version 1.2
 */
public class GenerateExcelAction extends ActionSupport
{
	/**
	 * service 层相关属性
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
	
	
	/**生成Excel表格并下载
	 *@return SUCCESS 生成excel表格成功
	 */
	public String execute() throws Exception
	{
		return SUCCESS;
	}
}
