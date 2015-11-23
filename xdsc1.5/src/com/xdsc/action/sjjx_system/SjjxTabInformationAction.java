package com.xdsc.action.sjjx_system;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;
import com.xdsc.service.sjjx_system.SjjxTabInformationManager;
import com.xdsc.sjjx_system.util.DateConvert;
import com.xdsc.sjjx_system.util.PageListHolder;



/**对通知公告信息进行相关操作
 * @author 陈雪
 *
 */
public class SjjxTabInformationAction extends ActionSupport{

	/**
	 * 通知公告信息相关属性
	 */
	private Integer FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private Date FInfoStartTime;
	private Date FInfoFinishTime;
	private String FModuleId;
	private String FInfoType;
	private String FInfoZhiDing;
	private String FInfoZuiXin;
	private String FInfoPath;
	private String FBiaoZhi;
    private String read;
	private TabInformation tabInformation;// 封装信息详细信息

	/**
	 * Spring 注入的Service层的接口
	 */
	private SjjxTabInformationManager sjjxTabInformationManager;

	/**
	 * 信息添加所需变量
	 */
	private Map session;
	private File uploadFile;
	private String uploadFileFileName;
	private String savePath;
    

	/**得到本模块发布的所有通知公告列表
	 * @return SUCCESS 得到信息列表
	 */
	public String getTZGGInfoList() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		List list = sjjxTabInformationManager.getSjjxTZGGTabInformations();
		//如果列表为空，则不显示内容
		if(list.isEmpty()){
			request.put("isempty", new String("1"));
		}
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		
		session.put("tzggAll", list_all);
		request.put("tzggList", list_current);
		return SUCCESS;
	}
	
	
	/**分页功能中 响应点击[前一页]的函数
	 * @return SUCCESS 显示前一页列表
	 */
	public String previousI(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("tzggAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("tzggList", list_current);
		
		return SUCCESS;
	}
	
	
	/**分页功能中 响应点击[后一页]的函数
	 * @return SUCCESS 显示后一页列表
	 */
	public String nextI(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("tzggAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("tzggList", list_current);
		
		return SUCCESS;
	}
	
	/**本系统管理员添加通知公告信息
	 * @return SUCCESS 成功添加一条数据到数据库中
	 * @throws Exception
	 */
	public String addTZGGInfo()throws Exception{
		TabInformation info = new TabInformation();

		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType("通知公告");
		info.setFModuleId("5");
		info.setFInfoZhiDing("N");
		info.setFBiaoZhi("已阅");//系统管理员添加信息默认为已通过审核状态
		//系统自动记录发布时间
		Date noticeTime = new Date();
		java.sql.Date sqldate = new java.sql.Date(noticeTime.getTime());
		info.setFInfoStartTime(sqldate);
		//上传附件
		if (uploadFileFileName != null)
			info = sjjxTabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		sjjxTabInformationManager.saveSjjxTabInformation(info);
		
		return SUCCESS;
	}
	
	/** 设备管理人员添加通知公告信息
	 * @return SUCCESS 成功添加一条数据到数据库中
	 * @throws Exception
	 */
	public String addTZGGInfo1()throws Exception{
		TabInformation info = new TabInformation();
		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType("通知公告");
		info.setFModuleId("5");
		info.setFInfoZhiDing("N");
		info.setFBiaoZhi("未阅");//设备管理人员添加信息时默认为未审核状态
		//系统自动记录发布时间
		Date noticeTime = new Date();
		java.sql.Date sqldate = new java.sql.Date(noticeTime.getTime());
		info.setFInfoStartTime(sqldate);
		//上传附件
		if (uploadFileFileName != null)
			info = sjjxTabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		sjjxTabInformationManager.saveSjjxTabInformation(info);
		
		return SUCCESS;
	}
	
	/**通过信息编号查找并显示通知公告详细内容
	 * @return SUCCESS 查找成功
	 */
	public String showTZGGInfoDetail(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer infoId = Integer.parseInt( request.getParameter("infoId"));
		TabInformation info = (TabInformation)sjjxTabInformationManager.getSjjxTabInformationByInfoId(infoId);
		request.setAttribute("info", info);
		if(null!=info.getFInfoPath()&&(!"".equals(info.getFInfoPath()))){
			if(info.getFInfoPath().length()!=0)
			{
				request.setAttribute("attachment", new String("iscontent"));
			}
		}
		return SUCCESS;
	}
	
	/**预更新处理，得到需要的通知公告对象
	 * @return SUCCESS 转至更新页面
	 */
	public String preUpdateTZGGInfo() { 
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer infoId = Integer.parseInt( request.getParameter("infoId"));
		request.setAttribute("info", sjjxTabInformationManager.getSjjxTabInformationByInfoId(infoId));
		return SUCCESS;
	}
	
	/**更新通知公告内容
	 * @return SUCCESS 成功修改信息
	 * @throws Exception
	 */
	public String updateTZGGInfo() throws Exception{
		TabInformation info = sjjxTabInformationManager.getSjjxTabInformationByInfoId(FInfoId);
		
		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType("通知公告");
		info.setFModuleId("5");
		info.setFInfoZuiXin(FInfoZuiXin);
		if(read.equals("0")){
		    info.setFBiaoZhi("未阅");
		}
		else
			info.setFBiaoZhi("已阅");
		if (uploadFileFileName != null)
			info = sjjxTabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		sjjxTabInformationManager.updateSjjxTabInformation(info);

		return SUCCESS;
	}
	
	/**通过信息Id查找到信息并删除
	 * @return SUCCESS 成功从列表中删除一条信息记录
	 */
	public String deleteTZGGInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer infoId = Integer.parseInt(request.getParameter("infoId"));
		sjjxTabInformationManager.deleteSjjxTabInformation(sjjxTabInformationManager.getSjjxTabInformationByInfoId(infoId));
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public Integer getFInfoId() {
		return FInfoId;
	}
	public void setFInfoId(Integer infoId) {
		FInfoId = infoId;
	}
	public String getFInfoTitle() {
		return FInfoTitle;
	}
	public void setFInfoTitle(String infoTitle) {
		FInfoTitle = infoTitle;
	}
	public String getFInfoContet() {
		return FInfoContet;
	}
	public void setFInfoContet(String infoContet) {
		FInfoContet = infoContet;
	}
	public Date getFInfoStartTime() {
		return FInfoStartTime;
	}
	public void setFInfoStartTime(Date infoStartTime) {
		FInfoStartTime = infoStartTime;
	}
	public Date getFInfoFinishTime() {
		return FInfoFinishTime;
	}
	public void setFInfoFinishTime(Date infoFinishTime) {
		FInfoFinishTime = infoFinishTime;
	}
	public String getFModuleId() {
		return FModuleId;
	}
	public void setFModuleId(String moduleId) {
		FModuleId = moduleId;
	}
	public String getFInfoType() {
		return FInfoType;
	}
	public void setFInfoType(String infoType) {
		FInfoType = infoType;
	}

	public String getFInfoZuiXin() {
		return FInfoZuiXin;
	}
	public void setFInfoZuiXin(String infoZuiXin) {
		FInfoZuiXin = infoZuiXin;
	}
	public String getFInfoPath() {
		return FInfoPath;
	}
	public void setFInfoPath(String infoPath) {
		FInfoPath = infoPath;
	}
	
	public String getFBiaoZhi() {
		return FBiaoZhi;
	}
	public void setFBiaoZhi(String biaoZhi) {
		FBiaoZhi = biaoZhi;
	}
	

	public SjjxTabInformationManager getSjjxTabInformationManager() {
		return sjjxTabInformationManager;
	}
	public void setSjjxTabInformationManager(
			SjjxTabInformationManager sjjxTabInformationManager) {
		this.sjjxTabInformationManager = sjjxTabInformationManager;
	}

	
	public TabInformation getTabInformation() {
		return tabInformation;
	}
	public void setTabInformation(TabInformation tabInformation) {
		this.tabInformation = tabInformation;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}


	public String getFInfoZhiDing() {
		return FInfoZhiDing;
	}


	public void setFInfoZhiDing(String infoZhiDing) {
		FInfoZhiDing = infoZhiDing;
	}
	
	
}

