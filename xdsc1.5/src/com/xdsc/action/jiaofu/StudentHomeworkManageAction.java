package com.xdsc.action.jiaofu;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.StudentHomeworkManageManager;

/**
 * <p>���ܣ���ҵ����ģ�飬��Ҫ���в鿴��ҵ���ύ��ҵ��<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentHomeworkManageAction extends ActionSupport implements SessionAware{

	/**service����󣬱��ڵ���service��ķ���*/
	private StudentHomeworkManageManager studentHomeworkManageManager;
	/**��ҵ��Ӧ������Ϣ*/
	private List<JfptTabHomenoticetoreceive> listHomenoticetoreceiveInfo;
	/**��ҵ��Ӧ������Ϣ����*/
	private JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive;
	/**��ҵ֪ͨid��*/
    private int FHomeNoticeId;
    /**��ҵ֪ͨ����*/
	private JfptTabHomenotice jfptTabHomenotice;
	/**����ҳ������*/
	private String contentType;                  //����
	/**�ļ�·��*/
	private String filePath;
	/**�ļ�����*/
	private String fileName;
	/**��ҵ��Ӧ������Ϣid��*/
	private int FNumber;
	//******************************
	/**�ϴ���ҵ����*/
	private List<JfptTabHomeupload> listHomeuploadInfo;
	/**��ҵid��*/
	private int FHomeId;
	/**�ϴ���ҵ��Ϣ*/
	private JfptTabHomeupload jfptTabHomeupload;
	/**�γ̶�����Ϣ*/
	private List<TabCourse> listCourseInfo;
	/**�γ̱��*/
	private String FCourseNumber;
	/**�γ̶���*/
	private TabCourse tabCourse;
	/**ѧ������*/
	private TabStudents tabStudents;
	//*******************************
	/**�ϴ��ļ�*/
	private File uploadFile;                    //�ϴ�
	/**����*/
	private String uploadFileContentType;
	/**�ļ�����*/
	private String uploadFileFileName;
	/**����·��*/
	private String savePath;
    //*********************************�ύ��ҵ
	/**����·��*/
	private String FFilePath;
	/**��ҵ�ύʱ��*/
    private Date FHomeTime;
    /**��ҵ����*/
    private String FHomeTitle;
    /**��ҵ����*/
    private String FHomeContet;
    /**Map���Ͷ���*/
    private Map<String,Object> session;
    /**ѧ��ѧ��*/
    private String FStudentNumber;
    /**ҳ�洦���м�¼��ǰҳ���*/
    private int p = 1;
    /**ҳ�洦���жԲ�ѯ������зֲ������¼��ҳ����*/
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

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFHomeContet() {
		return FHomeContet;
	}

	public void setFHomeContet(String homeContet) {
		FHomeContet = homeContet;
	}

	public TabStudents getTabStudents() {
		return tabStudents;
	}

	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
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

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public JfptTabHomeupload getJfptTabHomeupload() {
		return jfptTabHomeupload;
	}

	public void setJfptTabHomeupload(JfptTabHomeupload jfptTabHomeupload) {
		this.jfptTabHomeupload = jfptTabHomeupload;
	}

	public int getFHomeId() {
		return FHomeId;
	}

	public void setFHomeId(int homeId) {
		FHomeId = homeId;
	}

	public String getFFilePath() {
		return FFilePath;
	}

	public void setFFilePath(String filePath) {
		FFilePath = filePath;
	}

	public Date getFHomeTime() {
		return FHomeTime;
	}

	public void setFHomeTime(Date homeTime) {
		FHomeTime = homeTime;
	}

	public String getFHomeTitle() {
		return FHomeTitle;
	}

	public void setFHomeTitle(String homeTitle) {
		FHomeTitle = homeTitle;
	}

	public List<JfptTabHomeupload> getListHomeuploadInfo() {
		return listHomeuploadInfo;
	}

	public void setListHomeuploadInfo(List<JfptTabHomeupload> listHomeuploadInfo) {
		this.listHomeuploadInfo = listHomeuploadInfo;
	}

	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
	}

	public JfptTabHomenotice getJfptTabHomenotice() {
		return jfptTabHomenotice;
	}

	public void setJfptTabHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		this.jfptTabHomenotice = jfptTabHomenotice;
	}

	public int getFHomeNoticeId() {
		return FHomeNoticeId;
	}

	public void setFHomeNoticeId(int homeNoticeId) {
		FHomeNoticeId = homeNoticeId;
	}

	public List<JfptTabHomenoticetoreceive> getListHomenoticetoreceiveInfo() {
		return listHomenoticetoreceiveInfo;
	}

	public void setListHomenoticetoreceiveInfo(
			List<JfptTabHomenoticetoreceive> listHomenoticetoreceiveInfo) {
		this.listHomenoticetoreceiveInfo = listHomenoticetoreceiveInfo;
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

	public JfptTabHomenoticetoreceive getJfptTabHomenoticetoreceive() {
		return jfptTabHomenoticetoreceive;
	}

	public void setJfptTabHomenoticetoreceive(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		this.jfptTabHomenoticetoreceive = jfptTabHomenoticetoreceive;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public StudentHomeworkManageManager getStudentHomeworkManageManager() {
		return studentHomeworkManageManager;
	}

	public void setStudentHomeworkManageManager(
			StudentHomeworkManageManager studentHomeworkManageManager) {
		this.studentHomeworkManageManager = studentHomeworkManageManager;
	}
	
	/**
	 * <p>���ܣ����������ҵ֪ͨ��Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findHomeNoticeInfo
	 */
	public String findHomeNoticeInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listHomenoticetoreceiveInfo = studentHomeworkManageManager.findHomeNoticetotoInfoBySid(FStudentNumber);
		
		int pages = 5;
		int listlength = listHomenoticetoreceiveInfo.size();
		if(listlength==0)
			return "findHomeNoticeInfo";
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
		listHomenoticetoreceiveInfo = listHomenoticetoreceiveInfo.subList(startIndex, endIndex);
		
		return "findHomeNoticeInfo";
	}
	
	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų�����ϸ��Ϣ<br>
	 * @return action findHomeDetailByID
	 */
	public String findHomeDetailByID(){
		FStudentNumber = (String)session.get("FUserNumber");
		jfptTabHomenotice = studentHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		jfptTabHomenoticetoreceive = studentHomeworkManageManager.findHomeNoticetotoInfoByID(FNumber);
		jfptTabHomenoticetoreceive.setFMarkable("Y");
		studentHomeworkManageManager.updateHomenoticetoto(jfptTabHomenoticetoreceive);
		System.out.println(jfptTabHomenoticetoreceive.getFMarkable());
		listHomenoticetoreceiveInfo = studentHomeworkManageManager.findHomeNoticetotoInfoBySid(FStudentNumber);
		return "findHomeDetailByID";
	}
	
	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų�����ض�����Ϣ������ɾ��<br>
	 * @return action deleteHomeByID
	 */
	public String deleteHomeByID(){
		FStudentNumber = (String)session.get("FUserNumber");
		JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive1 = new JfptTabHomenoticetoreceive();
		jfptTabHomenoticetoreceive1 = studentHomeworkManageManager.findHomeNoticetotoInfoByID(FNumber);
		studentHomeworkManageManager.deleteHomeNoticetoto(jfptTabHomenoticetoreceive1);
		
		listHomenoticetoreceiveInfo = studentHomeworkManageManager.findHomeNoticetotoInfoBySid(FStudentNumber);
		return "deleteHomeByID";
	}
	
	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile(){      //����
		JfptTabHomenotice info = studentHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		this.setContentType("application/"+this.getExt(info.getFUrl()));
		String name = info.getFUrl().substring(info.getFUrl().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\HomeNotice\\"+name);
		this.setFileName(name);
		return "downFileSuccess";
	}
	
	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile1(){      //����
		JfptTabHomeupload info =  studentHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		System.out.println(info.getFFilePath());
		this.setContentType("application/"+this.getExt(info.getFFilePath()));
		String name = info.getFFilePath().substring(info.getFFilePath().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\HomeUpload\\"+name);
		this.setFileName(name);
		return "downFileSuccess1";
	}
	
	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public InputStream getDownFile() throws Exception{        //�ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public InputStream getDownFile1() throws Exception{        //�ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	/**
	  * <p>���ܣ�����ļ���׺����<br>
	  * @param str �ļ�����
	  * @return subStr �ļ���׺��
	  */
	public String getExt(String str){               //����ļ��ĺ�׺��
		String subStr=str.substring(str.lastIndexOf("."));
		return subStr;
	}
	
	//**********************************************************************************
	/**
	 * <p>���ܣ��鿴�Լ��ύ����ҵ<br>
	 * @return action findHomeUploadInfo
	 */
	public String findHomeUploadInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listHomeuploadInfo = studentHomeworkManageManager.findHomeUploadInfoBySid(FStudentNumber);
		listCourseInfo = studentHomeworkManageManager.findCourseInfoBySid(FStudentNumber);
		
		int pages = 5;
		int listlength = listHomeuploadInfo.size();
		if(listlength==0)
			return "findHomeUploadInfo";
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
		listHomeuploadInfo = listHomeuploadInfo.subList(startIndex, endIndex);			
		
		return "findHomeUploadInfo";
	}
	
	/**
	 * <p>���ܣ�������ҵid�Ų�����ҵ��ϸ��Ϣ<br>
	 * @return action findHomeworkDetailByID
	 */
	public String findHomeworkDetailByID(){
		System.out.println("findHomeworkDettailByID-----------------------student");
		jfptTabHomeupload = studentHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		if(jfptTabHomeupload.getFReply()==null || jfptTabHomeupload.getFReply().trim().equals("")){
			
		}else{
			jfptTabHomeupload.setFReplyRead("Y");
			studentHomeworkManageManager.updateHomeworkInfo(jfptTabHomeupload);
		}
		return "findHomeworkDetailByID";
	}
	
	/**
	 * <p>���ܣ�������ҵ���ɾ����ҵ��Ϣ<br>
	 * @return action deleteHomeworkInfoByID
	 */
	public String deleteHomeworkInfoByID(){
//		JfptTabHomeupload jfptTabHomeupload2 = new JfptTabHomeupload();
		FStudentNumber = (String)session.get("FUserNumber");
		jfptTabHomeupload = studentHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		studentHomeworkManageManager.deleteHomeworkInfo(jfptTabHomeupload);
		
		listCourseInfo = studentHomeworkManageManager.findCourseInfoBySid(FStudentNumber);
		listHomeuploadInfo = studentHomeworkManageManager.findHomeUploadInfoBySid(FStudentNumber);
		return "deleteHomeworkInfoByID";
	}
	
	/**
	 * <p>���ܣ����ҿγ���Ϣ��ѧ����Ϣ<br>
	 * @return action addHomeworkInfoBefore
	 */
	public String addHomeworkInfoBefore(){
		FStudentNumber = (String)session.get("FUserNumber");
		tabCourse = studentHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		tabStudents = studentHomeworkManageManager.findStudentsInfoBySid(FStudentNumber);
		return "addHomeworkInfoBefore";
	}
	
	/**
	 * <p>���ܣ��ύ��ҵ<br>
	 * @return action addHomeworkInfo
	 */
	public String addHomeworkInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		JfptTabHomeupload jfptTabHomeupload2 = new JfptTabHomeupload();
		if(uploadFile != null){
			studentHomeworkManageManager.savefile(uploadFile, savePath, uploadFileFileName);
			FFilePath = savePath+"/"+uploadFileFileName;
			jfptTabHomeupload2.setFFilePath(FFilePath);
			jfptTabHomeupload2.setFHomeContet(FHomeContet);
			jfptTabHomeupload2.setFHomeTime(new Date());
			jfptTabHomeupload2.setFHomeTitle(FHomeTitle);
			jfptTabHomeupload2.setFRead("N");
			jfptTabHomeupload2.setFReplyRead("N");
			jfptTabHomeupload2.setTabCourse(tabCourse);
			jfptTabHomeupload2.setTabStudents(tabStudents);
			
			studentHomeworkManageManager.addHomeworkInfo(jfptTabHomeupload2);
			listCourseInfo = studentHomeworkManageManager.findCourseInfoBySid(FStudentNumber);
			listHomeuploadInfo = studentHomeworkManageManager.findHomeUploadInfoBySid(FStudentNumber);
			return "addHomeworkInfo";
		}
		jfptTabHomeupload2.setFHomeContet(FHomeContet);
		jfptTabHomeupload2.setFHomeTime(new Date());
		jfptTabHomeupload2.setFHomeTitle(FHomeTitle);
		jfptTabHomeupload2.setFRead("N");
		jfptTabHomeupload2.setFReplyRead("N");
		jfptTabHomeupload2.setTabCourse(tabCourse);
		jfptTabHomeupload2.setTabStudents(tabStudents);
		
		studentHomeworkManageManager.addHomeworkInfo(jfptTabHomeupload2);
		listCourseInfo = studentHomeworkManageManager.findCourseInfoBySid(FStudentNumber);
		listHomeuploadInfo = studentHomeworkManageManager.findHomeUploadInfoBySid(FStudentNumber);
		return "addHomeworkInfo";
	}
}
