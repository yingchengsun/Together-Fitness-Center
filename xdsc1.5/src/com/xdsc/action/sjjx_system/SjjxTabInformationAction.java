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



/**��֪ͨ������Ϣ������ز���
 * @author ��ѩ
 *
 */
public class SjjxTabInformationAction extends ActionSupport{

	/**
	 * ֪ͨ������Ϣ�������
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
	private TabInformation tabInformation;// ��װ��Ϣ��ϸ��Ϣ

	/**
	 * Spring ע���Service��Ľӿ�
	 */
	private SjjxTabInformationManager sjjxTabInformationManager;

	/**
	 * ��Ϣ����������
	 */
	private Map session;
	private File uploadFile;
	private String uploadFileFileName;
	private String savePath;
    

	/**�õ���ģ�鷢��������֪ͨ�����б�
	 * @return SUCCESS �õ���Ϣ�б�
	 */
	public String getTZGGInfoList() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		List list = sjjxTabInformationManager.getSjjxTZGGTabInformations();
		//����б�Ϊ�գ�����ʾ����
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
	
	
	/**��ҳ������ ��Ӧ���[ǰһҳ]�ĺ���
	 * @return SUCCESS ��ʾǰһҳ�б�
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
	
	
	/**��ҳ������ ��Ӧ���[��һҳ]�ĺ���
	 * @return SUCCESS ��ʾ��һҳ�б�
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
	
	/**��ϵͳ����Ա���֪ͨ������Ϣ
	 * @return SUCCESS �ɹ����һ�����ݵ����ݿ���
	 * @throws Exception
	 */
	public String addTZGGInfo()throws Exception{
		TabInformation info = new TabInformation();

		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType("֪ͨ����");
		info.setFModuleId("5");
		info.setFInfoZhiDing("N");
		info.setFBiaoZhi("����");//ϵͳ����Ա�����ϢĬ��Ϊ��ͨ�����״̬
		//ϵͳ�Զ���¼����ʱ��
		Date noticeTime = new Date();
		java.sql.Date sqldate = new java.sql.Date(noticeTime.getTime());
		info.setFInfoStartTime(sqldate);
		//�ϴ�����
		if (uploadFileFileName != null)
			info = sjjxTabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		sjjxTabInformationManager.saveSjjxTabInformation(info);
		
		return SUCCESS;
	}
	
	/** �豸������Ա���֪ͨ������Ϣ
	 * @return SUCCESS �ɹ����һ�����ݵ����ݿ���
	 * @throws Exception
	 */
	public String addTZGGInfo1()throws Exception{
		TabInformation info = new TabInformation();
		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType("֪ͨ����");
		info.setFModuleId("5");
		info.setFInfoZhiDing("N");
		info.setFBiaoZhi("δ��");//�豸������Ա�����ϢʱĬ��Ϊδ���״̬
		//ϵͳ�Զ���¼����ʱ��
		Date noticeTime = new Date();
		java.sql.Date sqldate = new java.sql.Date(noticeTime.getTime());
		info.setFInfoStartTime(sqldate);
		//�ϴ�����
		if (uploadFileFileName != null)
			info = sjjxTabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		sjjxTabInformationManager.saveSjjxTabInformation(info);
		
		return SUCCESS;
	}
	
	/**ͨ����Ϣ��Ų��Ҳ���ʾ֪ͨ������ϸ����
	 * @return SUCCESS ���ҳɹ�
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
	
	/**Ԥ���´����õ���Ҫ��֪ͨ�������
	 * @return SUCCESS ת������ҳ��
	 */
	public String preUpdateTZGGInfo() { 
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer infoId = Integer.parseInt( request.getParameter("infoId"));
		request.setAttribute("info", sjjxTabInformationManager.getSjjxTabInformationByInfoId(infoId));
		return SUCCESS;
	}
	
	/**����֪ͨ��������
	 * @return SUCCESS �ɹ��޸���Ϣ
	 * @throws Exception
	 */
	public String updateTZGGInfo() throws Exception{
		TabInformation info = sjjxTabInformationManager.getSjjxTabInformationByInfoId(FInfoId);
		
		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType("֪ͨ����");
		info.setFModuleId("5");
		info.setFInfoZuiXin(FInfoZuiXin);
		if(read.equals("0")){
		    info.setFBiaoZhi("δ��");
		}
		else
			info.setFBiaoZhi("����");
		if (uploadFileFileName != null)
			info = sjjxTabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		sjjxTabInformationManager.updateSjjxTabInformation(info);

		return SUCCESS;
	}
	
	/**ͨ����ϢId���ҵ���Ϣ��ɾ��
	 * @return SUCCESS �ɹ����б���ɾ��һ����Ϣ��¼
	 */
	public String deleteTZGGInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer infoId = Integer.parseInt(request.getParameter("infoId"));
		sjjxTabInformationManager.deleteSjjxTabInformation(sjjxTabInformationManager.getSjjxTabInformationByInfoId(infoId));
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
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

