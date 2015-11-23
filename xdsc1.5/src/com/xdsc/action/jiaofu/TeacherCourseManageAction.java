package com.xdsc.action.jiaofu;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.TeacherCourseManageManager;
/**
 * <p>���ܣ���ʦ�γ̹���ģ�飬��Ҫ����Ϊ���鿴�γ̡�����֪ͨ���γ̴��ɡ�<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseManageAction extends ActionSupport implements SessionAware{
	/**service����󣬱��ڵ���service��ķ���*/
	private TeacherCourseManageManager teacherCourseManageManager;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfo;
	/**�γ�����*/
	private List<JfptTabCourseaskquestion> listCourseaskquestionInfo;
	/**����Id��*/
	private int FQuestionId;
	/**�γ����ʶ���*/
	private JfptTabCourseaskquestion jfptTabCourseaskquestion;
	/**����ظ���Ϣ*/
	private List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo;
	/**����*/
	private String FContents;
	/**ʱ��*/
	private Date FDateTime;
	/**�γ̱��*/
	private String FCourseNumber;
	/**�γ�֪ͨ��Ϣ*/
	private List<JfptTabCoursenotice> listCoursenoticeInfo;
	/**֪ͨID��*/
	private int FNoticeId;
	/**֪ͨ���Ͷ���*/
    private JfptTabCoursenotice jfptTabCoursenotice;
    /**����ҳ����������*/
    private String contentType;                  //����
    /**�ļ�·��*/
	private String filePath;
	/**�ļ�����*/
	private String fileName;
	/**����Id��*/
	private int downId;
	/**�γ����Ͷ���*/
	private TabCourse tabCourse;
	/**ѧ����Ϣ*/
	private List<TabStudents> listStudentsInfo;
	/**ѧ��ѧ����Ϣ*/
	private List<String> listStudentNumber;
	/**�ϴ��ļ�*/
	private File uploadFile;  //�ϴ�
	/**ҳ������*/
	private String uploadFileContentType;
	/**�ļ�����*/
	private String uploadFileFileName;
	/**����·��*/
	private String savePath;
	/**����*/
	private String FContent;
	/**ʱ��*/
	private Date FDate;
	/**����*/
	private String FTitle;
	/**�ļ���ַ*/
	private String FUrl;
	/**֪ͨ���ն�Ӧ��Ϣ*/
    private JfptTabNoticetoreceive jfptTabNoticetoreceive;
    //��Session�����û�ID
    /**��ʦ���*/
    private String FTeacherNumber;
    /**Map ���ͱ���*/
    private Map<String,Object> session;
    //���Ͷ������
    /**�༶����Ϣ*/
    private List<String> listClassNumberInfo = new ArrayList<String>();
    /**������Ϣ*/
    private List<TabDirection> listDirectionInfo = new ArrayList<TabDirection>();
    /**�༶���*/
    private String ClassNumber;
    /**������*/
    private int DirectionNumber;
    /**��ҳ�����м�¼��ǰҳ����*/
    private int p = 1;
    /**��ҳ�����м�¼��ѯ���������ҳ����*/
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

	public String getClassNumber() {
		return ClassNumber;
	}

	public void setClassNumber(String classNumber) {
		ClassNumber = classNumber;
	}

	public int getDirectionNumber() {
		return DirectionNumber;
	}

	public void setDirectionNumber(int directionNumber) {
		DirectionNumber = directionNumber;
	}

	public List<TabDirection> getListDirectionInfo() {
		return listDirectionInfo;
	}

	public void setListDirectionInfo(List<TabDirection> listDirectionInfo) {
		this.listDirectionInfo = listDirectionInfo;
	}

	public List<String> getListClassNumberInfo() {
		return listClassNumberInfo;
	}

	public void setListClassNumberInfo(List<String> listClassNumberInfo) {
		this.listClassNumberInfo = listClassNumberInfo;
	}

	public JfptTabNoticetoreceive getJfptTabNoticetoreceive() {
		return jfptTabNoticetoreceive;
	}

	public void setJfptTabNoticetoreceive(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		this.jfptTabNoticetoreceive = jfptTabNoticetoreceive;
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

	public List<String> getListStudentNumber() {
		return listStudentNumber;
	}

	public void setListStudentNumber(List<String> listStudentNumber) {
		this.listStudentNumber = listStudentNumber;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public TeacherCourseManageManager getTeacherCourseManageManager() {
		return teacherCourseManageManager;
	}

	public void setTeacherCourseManageManager(
			TeacherCourseManageManager teacherCourseManageManager) {
		this.teacherCourseManageManager = teacherCourseManageManager;
	}
	
	public int getFQuestionId() {
		return FQuestionId;
	}

	public void setFQuestionId(int questionId) {
		FQuestionId = questionId;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public List<JfptTabCourseaskquestion> getListCourseaskquestionInfo() {
		return listCourseaskquestionInfo;
	}

	public void setListCourseaskquestionInfo(
			List<JfptTabCourseaskquestion> listCourseaskquestionInfo) {
		this.listCourseaskquestionInfo = listCourseaskquestionInfo;
	}

	public JfptTabCourseaskquestion getJfptTabCourseaskquestion() {
		return jfptTabCourseaskquestion;
	}

	public void setJfptTabCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		this.jfptTabCourseaskquestion = jfptTabCourseaskquestion;
	}

	public List<JfptTabCoursereplyquestion> getListCoursereplyquestionInfo() {
		return listCoursereplyquestionInfo;
	}

	public void setListCoursereplyquestionInfo(
			List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo) {
		this.listCoursereplyquestionInfo = listCoursereplyquestionInfo;
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

	public String getFContents() {
		return FContents;
	}

	public void setFContents(String contents) {
		FContents = contents;
	}

	public String getFContent() {
		return FContent;
	}

	public void setFContent(String content) {
		FContent = content;
	}

	public Date getFDate() {
		return FDate;
	}

	public void setFDate(Date date) {
		FDate = date;
	}

	public String getFTitle() {
		return FTitle;
	}

	public void setFTitle(String title) {
		FTitle = title;
	}

	public String getFUrl() {
		return FUrl;
	}

	public void setFUrl(String url) {
		FUrl = url;
	}

	public Date getFDateTime() {
		return FDateTime;
	}

	public void setFDateTime(Date dateTime) {
		FDateTime = dateTime;
	}

	public List<JfptTabCoursenotice> getListCoursenoticeInfo() {
		return listCoursenoticeInfo;
	}

	public void setListCoursenoticeInfo(
			List<JfptTabCoursenotice> listCoursenoticeInfo) {
		this.listCoursenoticeInfo = listCoursenoticeInfo;
	}

	/**
	 * <p>���ܣ����ݽ�ʦ��Ų�ѯ��������صĿγ���Ϣ,�����з�ҳ����<br>
	 * @return action findCourseInfo
	 */
	public String findCourseInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		
		int pages = 5;
		int listlength = listCourseInfo.size();
		if(listlength==0)
			return "findCourseInfo";
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
		listCourseInfo = listCourseInfo.subList(startIndex, endIndex);	
		
		return "findCourseInfo";
	}

	/**
	 * <p>���ܣ�ͨ����ʦId�Ų���������صĿγ�����<br>
	 * @return action questionReplyInfo
	 */
	public String questionReplyInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
	    listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplyInfoByTid(FTeacherNumber);
	    listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
	    
	    int pages = 5;
		int listlength = listCourseaskquestionInfo.size();
		if(listlength==0)
			return "questionReplyInfo";
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
		listCourseaskquestionInfo = listCourseaskquestionInfo.subList(startIndex, endIndex);	
	    
		return "questionReplyInfo";
	}
	
	/**
	 * <p>���ܣ����ݿγ̺ź����̱�Ų�����صĿγ����ʣ������з�ҳ����<br>
	 * @return action selectQuestionReplyInfo
	 */
	public String selectQuestionReplyInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplayInfoByTwo(FTeacherNumber,FCourseNumber);
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		
		if(listCourseaskquestionInfo.size() <= 0)
			return "selectQuestionReplyInfo";
		
		int pages = 5;
		int listlength = listCourseaskquestionInfo.size();
		if(listlength==0)
			return "questionReplyInfo";
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
		listCourseaskquestionInfo = listCourseaskquestionInfo.subList(startIndex, endIndex);
		return "selectQuestionReplyInfo";
	}
	
	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<TabStudents> getListStudentsInfo() {
		return listStudentsInfo;
	}

	public void setListStudentsInfo(List<TabStudents> listStudentsInfo) {
		this.listStudentsInfo = listStudentsInfo;
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

	public JfptTabCoursenotice getJfptTabCoursenotice() {
		return jfptTabCoursenotice;
	}

	public void setJfptTabCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
	}

	public int getFNoticeId() {
		return FNoticeId;
	}

	public void setFNoticeId(int noticeId) {
		FNoticeId = noticeId;
	}

	/**
	 * <p>���ܣ����ݿγ�����Id�Ų�����ص��������飬��������id�Ų�����صĻظ�����<br>
	 * @return action findProblemDetailByID
	 */
	public String findProblemDetailByID(){		
		jfptTabCourseaskquestion = teacherCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		listCoursereplyquestionInfo = teacherCourseManageManager.findCourseReplyInfoByID(FQuestionId);
		return "findProblemDetailByID";
	}
	
	/**
	 * <p>���ܣ���ӻظ�����<br>
	 * @return action addReplyInfoByID
	 */
	public String addReplyInfoByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		JfptTabCoursereplyquestion jfptTabCoursereplyquestion1 = new JfptTabCoursereplyquestion();
		jfptTabCoursereplyquestion1.setFContents(FContents);
		jfptTabCoursereplyquestion1.setFDateTime(new Date());
		jfptTabCoursereplyquestion1.setFReplyUserId(FTeacherNumber);
		JfptTabCourseaskquestion jfptTabCourseaskquestion1 = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion1 = teacherCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		jfptTabCoursereplyquestion1.setJfptTabCourseaskquestion(jfptTabCourseaskquestion1);
		teacherCourseManageManager.addCoursereplyInfo(jfptTabCoursereplyquestion1);
		
		listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplyInfoByTid(FTeacherNumber);
		return "addReplyInfoByID";
	}
	
	/**
	 * <p>���ܣ�ɾ���γ����ʣ�����ɾ����صĻظ���Ϣ<br>
	 * @return action deleteAskQuestionByID
	 */
	public String deleteAskQuestionByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		teacherCourseManageManager.deleteAskQuestionByID(FQuestionId);
		
		listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplyInfoByTid(FTeacherNumber);
	    listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		return "deleteAskQuestionByID";
	}
	
	/**
	 * <p>���ܣ����ҿγ�֪ͨ��Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findCourseNoticeInfo
	 */
	public String findCourseNoticeInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		
		int pages = 5;
		int listlength = listCoursenoticeInfo.size();
		if(listlength==0)
			return "findCourseNoticeInfo";
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
		listCoursenoticeInfo = listCoursenoticeInfo.subList(startIndex, endIndex);
		
		return "findCourseNoticeInfo";
	}
	
	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ϣ<br>
	 * @return action deleteNoticeByID
	 */
	public String deleteNoticeByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabCoursenotice = teacherCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		teacherCourseManageManager.deleteCourseNoticeInfo(jfptTabCoursenotice);
		
		listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
		return "deleteNoticeByID";
	}
	
	/**
	 * <p>���ܣ��鿴�γ�֪ͨ����ϸ����<br>
	 * @return action findNoticeDetailByID
	 */
	public String findNoticeDetailByID(){
		jfptTabCoursenotice = teacherCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		return "findNoticeDetailByID";
	}
	
	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile(){      //����      jfpt/Resource/CourseNotice/�γ�֪ͨ.txt
		JfptTabCoursenotice info=teacherCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		this.setContentType("application/"+this.getExt(info.getFUrl()));
		String nametofile = info.getFUrl().substring(info.getFUrl().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseNotice\\"+nametofile);
		this.setFileName(nametofile);
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
		String subStr=str.substring(str.lastIndexOf("."));
		return subStr;
	}

	/**
	 * <p>���ܣ���ӿγ�֪ͨǰ��׼��������������������صĿγ���Ϣ��ѧ����Ϣ���༶��Ϣ��������Ϣ<br>
	 * @return action AddNewNoticeBefore
	 */
	public String AddNewNoticeBefore(){
		FTeacherNumber = (String)session.get("FUserNumber");
		tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherCourseManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		
		listClassNumberInfo = teacherCourseManageManager.findClassNumberInfo(FTeacherNumber,FCourseNumber);
		listDirectionInfo = teacherCourseManageManager.findDirectionInfo(listStudentsInfo,FCourseNumber);
		
		return "AddNewNoticeBefore";
	}
	
	/**
	 * <p>���ܣ�������صĿγ���Ϣ���ҿγ���Ϣ��������֮��ص�ѧ����Ϣ���ڴ˻�����ͨ�������༶����������ѧ��������Ϣ<br>
	 * @return action AddNewNoticeBefore2
	 */
	public String AddNewNoticeBefore2(){
		FTeacherNumber = (String)session.get("FUserNumber");
		tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherCourseManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		listStudentsInfo = teacherCourseManageManager.findStudentsInfo(ClassNumber,DirectionNumber,listStudentsInfo);
		return "AddNewNoticeBefore2";
	}
	
	/**
	 * <p>���ܣ����֪ͨ<br>
	 * @return action addNotice
	 */
	public String addNotice(){                         //���֪ͨ
		FTeacherNumber = (String)session.get("FUserNumber");
		for(String i:listStudentNumber){
			System.out.println(i);
		}
		if(uploadFile != null){
			teacherCourseManageManager.savefile(uploadFile, savePath, uploadFileFileName);
			JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
			jfptTabCoursenotice1.setFContent(FContent);
			MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
			mhqxTabUser1 = teacherCourseManageManager.findUserByID(FTeacherNumber);
			jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
			jfptTabCoursenotice1.setFDate(new Date());
			jfptTabCoursenotice1.setFTitle(FTitle);
			FUrl = savePath +"/"+ uploadFileFileName;
			jfptTabCoursenotice1.setFUrl(FUrl);
			tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
			jfptTabCoursenotice1.setTabCourse(tabCourse);
			teacherCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
			//�����ض�Ӧ��Ϣ��--->��Ӧ��
			for(String i: listStudentNumber){
				JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
				jfptTabNoticetoreceive1.setFMarkable("N");
				jfptTabNoticetoreceive1.setJfptTabCoursenotice(jfptTabCoursenotice1);
				MhqxTabUser mhqxTabUser = new MhqxTabUser();
				mhqxTabUser = teacherCourseManageManager.findUserByID(i);
				jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
				teacherCourseManageManager.addCoursenoticetoto(jfptTabNoticetoreceive1);
			}
			
			listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
			listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
			return "addNotice";
		}
		JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
		jfptTabCoursenotice1.setFContent(FContent);
		jfptTabCoursenotice1.setFDate(new Date());
		jfptTabCoursenotice1.setFTitle(FTitle);
		MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
		mhqxTabUser1 = teacherCourseManageManager.findUserByID(FTeacherNumber);
		jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
		tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
		jfptTabCoursenotice1.setTabCourse(tabCourse);
		teacherCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
		//�����ض�Ӧ��Ϣ��--->��Ӧ��
		for(String i: listStudentNumber){
			JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
			jfptTabNoticetoreceive1.setFMarkable("N");
			jfptTabNoticetoreceive1.setJfptTabCoursenotice(jfptTabCoursenotice1);
			MhqxTabUser mhqxTabUser = new MhqxTabUser();
			mhqxTabUser = teacherCourseManageManager.findUserByID(i);
			jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
			teacherCourseManageManager.addCoursenoticetoto(jfptTabNoticetoreceive1);
		}
		
		listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		return "addNotice";
	}
	
	/**
	 * <p>���ܣ����Ҷ�Ӧ�γ̵İ༶�ͷ�����Ϣ<br>
	 * @return action seeCourseDetail
	 */
	public String seeCourseDetail(){
		FTeacherNumber = (String)session.get("FUserNumber");
		System.out.println(FTeacherNumber+"-------------------FTeacherNumber---"+FCourseNumber+"--------FCourseNumber");
		listClassNumberInfo = teacherCourseManageManager.findClassNumberInfo(FTeacherNumber, FCourseNumber); //List<String>
		listStudentsInfo = teacherCourseManageManager.findStudentsInfoByTwo(FTeacherNumber, FCourseNumber);
		listDirectionInfo = teacherCourseManageManager.findDirectionInfo(listStudentsInfo, FCourseNumber);  //List<TabDirection>
		return "seeCourseDetail";
	}
}
