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
 * <p>���ܣ���Դ��������صĲ���<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherResourceManageAction extends ActionSupport implements
		SessionAware {

	/**service����󣬱��ڵ���service�㷽��*/
	private TeacherResourceManageManager teacherResourceManageManager;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfoUpload;
	/**User��id��Ϣ */
	private String FUserNumber;
	/**User����*/
	private MhqxTabUser mhqxTabUser;
	/**�ϴ���Դ*/
	private JfptTabUploadfile jfptTabUploadfile;
	/**�ļ�����*/
	private String FFileDetail;
	/**�ϴ�ʱ��*/
	private Date FUpTime;
	/**�γ̱��*/
	private String FCourseNumber;
	/**����id*/
	private int FNumber;
	// �ļ��ϴ�
	/**�ϴ��ļ�*/
	private File uploadFile;
	/**�ļ�����*/
	private String uploadFileContentType;
	/**�ļ�����*/
	private String uploadFileFileName;
	/**����·��*/
	private String savePath;
	// �����ļ�
	/**��Դ�ļ�*/
	private List<JfptTabUploadfile> listUploadfileInfo;
	/**�ļ�·��*/
	private String filePath;
	/**�ļ�����*/
	private String fileName;
	/**ҳ������*/
	private String contentType;
	/**��ʦ���*/
	private String FTeacherNumber;
	/**Map���Ͷ���*/
	private Map<String, Object> session;
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
	 * <p>���ܣ�������صĿγ���Ϣ<br>
	 * @return action addInfoBeforeUpload
	 */
	public String addInfoBeforeUpload() {
		FTeacherNumber = (String) session.get("FUserNumber");
		listCourseInfoUpload = teacherResourceManageManager
				.findCourseInfoUpload(FTeacherNumber);
		return "addInfoBeforeUpload";
	}

	/**
	 * <p>���ܣ��ϴ���Դ����<br>
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
	 * <p>���ܣ�������Դ�����з�ҳ����<br>
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
	 * <p>���ܣ�������Դid��ɾ����Դ��Ϣ<br>
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
	  * <p>���ܣ������ļ����صķ���<br>
	  * @return action downFile
	  */
	public String downFile() { // ����
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
	  * <p>���ܣ������ļ����������<br>
	  * @return InputStream
	  * @throws Exception
	  */
	public InputStream getDownFile() throws Exception { // �ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(
				this.getFilePath());
	}

	/**
	  * <p>���ܣ�����ļ���׺����<br>
	  * @param str �ļ�����
	  * @return subStr �ļ���׺��
	  */
	public String getExt(String str) { // ����ļ��ĺ�׺��
		String subStr = str.substring(str.lastIndexOf(".") + 1);
		return subStr;
	}
}
