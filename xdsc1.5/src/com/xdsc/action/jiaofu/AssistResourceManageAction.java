package com.xdsc.action.jiaofu;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.service.jiaofu.AssistResourceManageManager;

/**
 * <p>���ܣ���Դ��������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistResourceManageAction extends ActionSupport implements SessionAware{

	/**service����󣬱��ڵ���service�㷽��*/
	private AssistResourceManageManager assistResourceManageManager;
	/**�ϴ���Դ*/
	private List<JfptTabUploadfile> listUploadfileInfo;
	/**����id��*/
	private String FAssistantId;
	/**ҳ������*/
	private String contentType;                  //����
	/**�ļ�·��*/
	private String filePath;
	/**�ļ�����*/
	private String fileName;
	/**����id*/
	private int downId;
	/**��Դ�ļ�*/
	private JfptTabUploadfile jfptTabUploadfile;
	/**��Դ�ļ�id��*/
	private int FNumber;
	/**Map���Ͷ���*/
	private Map<String,Object> session;
	/**��ҳ�����м�¼��ǰҳ���*/
	private int p = 1;
	/**��ҳ�����м�¼�������ҳ����*/
	private int lastPage;

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public AssistResourceManageManager getAssistResourceManageManager() {
		return assistResourceManageManager;
	}

	public void setAssistResourceManageManager(
			AssistResourceManageManager assistResourceManageManager) {
		this.assistResourceManageManager = assistResourceManageManager;
	}
	
	public String getFAssistantId() {
		return FAssistantId;
	}

	public void setFAssistantId(String assistantId) {
		FAssistantId = assistantId;
	}

	public List<JfptTabUploadfile> getListUploadfileInfo() {
		return listUploadfileInfo;
	}

	public void setListUploadfileInfo(List<JfptTabUploadfile> listUploadfileInfo) {
		this.listUploadfileInfo = listUploadfileInfo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getDownId() {
		return downId;
	}

	public void setDownId(int downId) {
		this.downId = downId;
	}

	public JfptTabUploadfile getJfptTabUploadfile() {
		return jfptTabUploadfile;
	}

	public void setJfptTabUploadfile(JfptTabUploadfile jfptTabUploadfile) {
		this.jfptTabUploadfile = jfptTabUploadfile;
	}

	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
	}

	/**
	 * <p>���ܣ�������Դ�����з�ҳ����<br>
	 * @return action findResourceInfo
	 */
	public String findResourceInfo(){
		String Aaid = (String)session.get("FUserNumber");
		listUploadfileInfo = assistResourceManageManager.findResourceInfoByID(Aaid);
		
		int pages = 5;
		int listlength = listUploadfileInfo.size();
		if(listlength==0)
			return "findResourceInfo";
		if (listlength % pages == 0) {
			this.lastPage = listlength / pages;
		} else {
			this.lastPage = listlength / pages + 1;
		}
		if (this.p < 1)
			this.p = 1;
		if (this.p > this.lastPage)
			this.p = this.lastPage;
		int startIndex = (this.p - 1) * pages;
		int endIndex = startIndex + pages;
		if (endIndex >= listlength)
			endIndex = listlength;
		listUploadfileInfo = listUploadfileInfo.subList(startIndex, endIndex);	
		
		return "findResourceInfo";
	}
	
	/**
	  * <p>���ܣ������ļ����صķ���<br>
	  * @return action downFile
	  */
	public String downFile(){      //����
		jfptTabUploadfile = assistResourceManageManager.findUploadfileByID(FNumber);
		this.setContentType("application/"+this.getExt(jfptTabUploadfile.getFFileName()));
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseAbout\\"+jfptTabUploadfile.getFFileName());
		System.out.println(this.getExt(jfptTabUploadfile.getFFileName()));
		this.setFileName(jfptTabUploadfile.getFFileName());
		return "downFileSuccess";
	}
	
	/**
	  * <p>���ܣ������ļ����������<br>
	  * @return InputStream
	  * @throws Exception
	  */
	public InputStream getDownFile() throws Exception{        //�ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	/**
	  * <p>���ܣ�����ļ���׺����<br>
	  * @param str �ļ�����
	  * @return subStr �ļ���׺��
	  */
	public String getExt(String str){               //����ļ��ĺ�׺��
		String subStr=str.substring(str.lastIndexOf(".")+1);
		return subStr;
	}
}
