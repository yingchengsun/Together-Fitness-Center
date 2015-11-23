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
 * <p>功能：资源管理中相关的操作<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentResourceManageAction extends ActionSupport implements SessionAware{

	/**service层对象，便于调用service层方法*/
	private StudentResourceManageManager studentResourceManageManager;
	/**课程信息*/
	private List<TabCourse> listCourseInfoUpload;
	/**学生学号*/
	private String FUserNumber;
	/**User对象信息*/
	private MhqxTabUser mhqxTabUser;
	/**资源文件*/
	private JfptTabUploadfile jfptTabUploadfile;
	/**文件详情*/
	private String FFileDetail;
	/**上传时间*/
	private Date FUpTime;
	/**课程编号*/
	private String FCourseNumber;
	/**资源文件id号*/
	private int FNumber;
	//下载文件
	/**上传资源*/
	private List<JfptTabUploadfile> listUploadfileInfo; 
	/**文件路径*/
    private String filePath;
    /**文件名称*/
	private String fileName;
	/**页面类型*/
	private String contentType;
	/**Map类型对象*/
	private Map<String,Object> session;
	private String FStudentNumber;
	/**分页处理中记录当前页面号*/
	private int p = 1;
	/**分页处理中记录结果集总页面数*/
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
	 * <p>功能：查找资源并进行分页处理<br>
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
	  * <p>功能：用于文件下载的方法<br>
	  * @return action downFile
	  */
	public String downFile(){      //下载
		jfptTabUploadfile = studentResourceManageManager.findUploadfileByID(FNumber);
		this.setContentType("application/"+this.getExt(jfptTabUploadfile.getFFileName()));
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseAbout\\"+jfptTabUploadfile.getFFileName());
		System.out.println(this.getExt(jfptTabUploadfile.getFFileName()));
		this.setFileName(jfptTabUploadfile.getFFileName());
		return "downFileSuccess";
	}
	
	/**
	  * <p>功能：创建文件下载输出流<br>
	  * @return InputStream
	  * @throws Exception
	  */
	public InputStream getDownFile() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	/**
	  * <p>功能：获得文件后缀名称<br>
	  * @param str 文件名称
	  * @return subStr 文件后缀名
	  */
	public String getExt(String str){               //获得文件的后缀名
		String subStr=str.substring(str.lastIndexOf(".")+1);
		return subStr;
	}
}
