package com.xdsc.action.jiaofu;

import java.io.File;
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
import com.xdsc.service.jiaofu.TeacherResourceManageManager;

/**
 * <p>功能：资源管理中相关的操作<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherResourceManageAction extends ActionSupport implements
		SessionAware {

	/**service层对象，便于调用service层方法*/
	private TeacherResourceManageManager teacherResourceManageManager;
	/**课程信息*/
	private List<TabCourse> listCourseInfoUpload;
	/**User的id信息 */
	private String FUserNumber;
	/**User对象*/
	private MhqxTabUser mhqxTabUser;
	/**上传资源*/
	private JfptTabUploadfile jfptTabUploadfile;
	/**文件详情*/
	private String FFileDetail;
	/**上传时间*/
	private Date FUpTime;
	/**课程编号*/
	private String FCourseNumber;
	/**下载id*/
	private int FNumber;
	// 文件上传
	/**上传文件*/
	private File uploadFile;
	/**文件类型*/
	private String uploadFileContentType;
	/**文件名称*/
	private String uploadFileFileName;
	/**保存路径*/
	private String savePath;
	// 下载文件
	/**资源文件*/
	private List<JfptTabUploadfile> listUploadfileInfo;
	/**文件路径*/
	private String filePath;
	/**文件名称*/
	private String fileName;
	/**页面类型*/
	private String contentType;
	/**教师编号*/
	private String FTeacherNumber;
	/**Map类型对象*/
	private Map<String, Object> session;
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

	public JfptTabUploadfile getJfptTabUploadfile() {
		return jfptTabUploadfile;
	}

	public void setJfptTabUploadfile(JfptTabUploadfile jfptTabUploadfile) {
		this.jfptTabUploadfile = jfptTabUploadfile;
	}

	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public TeacherResourceManageManager getTeacherResourceManageManager() {
		return teacherResourceManageManager;
	}

	public void setTeacherResourceManageManager(
			TeacherResourceManageManager teacherResourceManageManager) {
		this.teacherResourceManageManager = teacherResourceManageManager;
	}

	public List<TabCourse> getListCourseInfoUpload() {
		return listCourseInfoUpload;
	}

	public void setListCourseInfoUpload(List<TabCourse> listCourseInfoUpload) {
		this.listCourseInfoUpload = listCourseInfoUpload;
	}

	public String getFFileDetail() {
		return FFileDetail;
	}

	public void setFFileDetail(String fileDetail) {
		FFileDetail = fileDetail;
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

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public Date getFUpTime() {
		return FUpTime;
	}

	public void setFUpTime(Date upTime) {
		FUpTime = upTime;
	}

	/**
	 * <p>功能：查找相关的课程信息<br>
	 * @return action addInfoBeforeUpload
	 */
	public String addInfoBeforeUpload() {
		FTeacherNumber = (String) session.get("FUserNumber");
		listCourseInfoUpload = teacherResourceManageManager
				.findCourseInfoUpload(FTeacherNumber);
		return "addInfoBeforeUpload";
	}

	/**
	 * <p>功能：上传资源操作<br>
	 * @return action addFileIntoUpload
	 */
	public String addFileIntoUpload() {

		FUserNumber = (String) session.get("FUserNumber");

		MhqxTabUser mhqxTabUser = new MhqxTabUser();
		mhqxTabUser = teacherResourceManageManager.findUserInfoByID(FUserNumber);
		TabCourse tabCourse = new TabCourse();
		tabCourse = teacherResourceManageManager.findCourseInfoByID(FCourseNumber);
		String path = savePath + "/" + uploadFileFileName;
		teacherResourceManageManager.savefile(uploadFile, savePath,uploadFileFileName);
		JfptTabUploadfile jfptTabUploadfile1 = new JfptTabUploadfile(tabCourse,mhqxTabUser, new Date(), uploadFileFileName, FFileDetail, path);
		teacherResourceManageManager.addUploadInfo(jfptTabUploadfile1);
		return "addFileIntoUpload";
	}

	/**
	 * <p>功能：查找资源并进行分页处理<br>
	 * @return action findResourceInfo
	 */
	public String findResourceInfo() {
		FUserNumber = (String) session.get("FUserNumber");
		listUploadfileInfo = teacherResourceManageManager
				.findUploadfileInfo(FUserNumber);

		int pages = 5;
		int listlength = listUploadfileInfo.size();
		if (listlength == 0)
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
	 * <p>功能：根据资源id号删除资源信息<br>
	 * @return action deleteUpfileInfoByID
	 */
	public String deleteUpfileInfoByID() {
		FUserNumber = (String) session.get("FUserNumber");
		teacherResourceManageManager.deleteUpfileInfoByID(FNumber);

		listUploadfileInfo = teacherResourceManageManager
				.findUploadfileInfo(FUserNumber);
		return "deleteUpfileInfoByID";
	}

	/**
	  * <p>功能：用于文件下载的方法<br>
	  * @return action downFile
	  */
	public String downFile() { // 下载
		jfptTabUploadfile = teacherResourceManageManager
				.findUploadfileByID(FNumber);
		this.setContentType("application/"
				+ this.getExt(jfptTabUploadfile.getFFileName()));
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseAbout\\"
				+ jfptTabUploadfile.getFFileName());
		System.out.println(this.getExt(jfptTabUploadfile.getFFileName()));
		this.setFileName(jfptTabUploadfile.getFFileName());
		return "downFileSuccess";
	}

	/**
	  * <p>功能：创建文件下载输出流<br>
	  * @return InputStream
	  * @throws Exception
	  */
	public InputStream getDownFile() throws Exception { // 文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(
				this.getFilePath());
	}

	/**
	  * <p>功能：获得文件后缀名称<br>
	  * @param str 文件名称
	  * @return subStr 文件后缀名
	  */
	public String getExt(String str) { // 获得文件的后缀名
		String subStr = str.substring(str.lastIndexOf(".") + 1);
		return subStr;
	}
}
