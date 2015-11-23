package com.xdsc.action.jiaofu;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.service.jiaofu.StudentResourceManageManager;

/**
 * <p>���ܣ���Դ��������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentResourceManageAction extends ActionSupport implements SessionAware{

	/**service����󣬱��ڵ���service�㷽��*/
	private StudentResourceManageManager studentResourceManageManager;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfoUpload;
	/**ѧ��ѧ��*/
	private String FUserNumber;
	/**User������Ϣ*/
	private MhqxTabUser mhqxTabUser;
	/**��Դ�ļ�*/
	private JfptTabUploadfile jfptTabUploadfile;
	/**�ļ�����*/
	private String FFileDetail;
	/**�ϴ�ʱ��*/
	private Date FUpTime;
	/**�γ̱��*/
	private String FCourseNumber;
	/**��Դ�ļ�id��*/
	private int FNumber;
	//�����ļ�
	/**�ϴ���Դ*/
	private List<JfptTabUploadfile> listUploadfileInfo; 
	/**�ļ�·��*/
    private String filePath;
    /**�ļ�����*/
	private String fileName;
	/**ҳ������*/
	private String contentType;
	/**Map���Ͷ���*/
	private Map<String,Object> session;
	private String FStudentNumber;
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

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public StudentResourceManageManager getStudentResourceManageManager() {
		return studentResourceManageManager;
	}

	public void setStudentResourceManageManager(
			StudentResourceManageManager studentResourceManageManager) {
		this.studentResourceManageManager = studentResourceManageManager;
	}

	public List<TabCourse> getListCourseInfoUpload() {
		return listCourseInfoUpload;
	}

	public void setListCourseInfoUpload(List<TabCourse> listCourseInfoUpload) {
		this.listCourseInfoUpload = listCourseInfoUpload;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public JfptTabUploadfile getJfptTabUploadfile() {
		return jfptTabUploadfile;
	}

	public void setJfptTabUploadfile(JfptTabUploadfile jfptTabUploadfile) {
		this.jfptTabUploadfile = jfptTabUploadfile;
	}

	public String getFFileDetail() {
		return FFileDetail;
	}

	public void setFFileDetail(String fileDetail) {
		FFileDetail = fileDetail;
	}

	public Date getFUpTime() {
		return FUpTime;
	}

	public void setFUpTime(Date upTime) {
		FUpTime = upTime;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
	}

	public List<JfptTabUploadfile> getListUploadfileInfo() {
		return listUploadfileInfo;
	}

	public void setListUploadfileInfo(List<JfptTabUploadfile> listUploadfileInfo) {
		this.listUploadfileInfo = listUploadfileInfo;
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	/**
	 * <p>���ܣ�������Դ�����з�ҳ����<br>
	 * @return action findResourceInfo
	 */
	public String findResourceInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listUploadfileInfo = studentResourceManageManager.findUploadfileInfoByID(FStudentNumber);
		
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
		jfptTabUploadfile = studentResourceManageManager.findUploadfileByID(FNumber);
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
