package com.xdsc.action.jiaofu;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.StudentCourseManageManager;

/**
 * <p>功能：学生课程管理模块，主要功能为：查看课程、查看通知、课程答疑。<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentCourseManageAction extends ActionSupport implements SessionAware{

	/**service层对象，便于调用service层方法*/
	private StudentCourseManageManager studentCourseManageManager;
	/**课程信息*/
	private List<TabCourse> listCourseInfo;
	/**课程答疑信息*/
	private List<JfptTabCourseaskquestion> listCourseaskquestionInfo;
	/**课程答疑id号*/
	private int FQuestionId;
	/**课程答疑对象信息*/
	private JfptTabCourseaskquestion jfptTabCourseaskquestion;
	/**课程答疑回复信息*/
	private List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo;
	/**课程答疑回复*/
	private JfptTabCoursereplyquestion jfptTabCoursereplyquestion;
	/**内容*/
	private String FContents;
	/**时间*/
	private Date FDateTime;
	/**课程编号*/
	private String FCourseNumber;
	/**页面类型*/
	private String contentType;                  //下载
	/**文件路径*/
    private String filePath;
    /**文件名称*/
	private String fileName;
	/**下载id号*/
	private int downId;
	/**课程通知信息*/
	private List<JfptTabCoursenotice> listCoursenoticeInfo;
	/**通知id号*/
	private int FNoticeId;
	/**课程通知对象*/
	private JfptTabCoursenotice jfptTabCoursenotice;
	/**学生学号*/
	private String FStudentNumber;
	/**Map类型对象*/
	private Map<String,Object> session;
	/**分页处理中记录当前页面编号*/
	private int p = 1;
	/**分页处理中记录查询结果集的总页面数*/
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

	public int getFNoticeId() {
		return FNoticeId;
	}

	public void setFNoticeId(int noticeId) {
		FNoticeId = noticeId;
	}

	public StudentCourseManageManager getStudentCourseManageManager() {
		return studentCourseManageManager;
	}

	public void setStudentCourseManageManager(
			StudentCourseManageManager studentCourseManageManager) {
		this.studentCourseManageManager = studentCourseManageManager;
	}

	public int getFQuestionId() {
		return FQuestionId;
	}

	public void setFQuestionId(int questionId) {
		FQuestionId = questionId;
	}

	public JfptTabCourseaskquestion getJfptTabCourseaskquestion() {
		return jfptTabCourseaskquestion;
	}

	public void setJfptTabCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		this.jfptTabCourseaskquestion = jfptTabCourseaskquestion;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public List<JfptTabCoursenotice> getListCoursenoticeInfo() {
		return listCoursenoticeInfo;
	}

	public void setListCoursenoticeInfo(
			List<JfptTabCoursenotice> listCoursenoticeInfo) {
		this.listCoursenoticeInfo = listCoursenoticeInfo;
	}

	public JfptTabCoursenotice getJfptTabCoursenotice() {
		return jfptTabCoursenotice;
	}

	public void setJfptTabCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public List<JfptTabCoursereplyquestion> getListCoursereplyquestionInfo() {
		return listCoursereplyquestionInfo;
	}

	public void setListCoursereplyquestionInfo(
			List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo) {
		this.listCoursereplyquestionInfo = listCoursereplyquestionInfo;
	}

	public JfptTabCoursereplyquestion getJfptTabCoursereplyquestion() {
		return jfptTabCoursereplyquestion;
	}

	public void setJfptTabCoursereplyquestion(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		this.jfptTabCoursereplyquestion = jfptTabCoursereplyquestion;
	}

	public List<JfptTabCourseaskquestion> getListCourseaskquestionInfo() {
		return listCourseaskquestionInfo;
	}

	public void setListCourseaskquestionInfo(
			List<JfptTabCourseaskquestion> listCourseaskquestionInfo) {
		this.listCourseaskquestionInfo = listCourseaskquestionInfo;
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

	public String getFContents() {
		return FContents;
	}

	public void setFContents(String contents) {
		FContents = contents;
	}

	public Date getFDateTime() {
		return FDateTime;
	}

	public void setFDateTime(Date dateTime) {
		FDateTime = dateTime;
	}

	/**
	 * <p>功能：根据学生编号查询出与其相关的课程信息,并进行分页处理<br>
	 * @return action findCourseInfo
	 */
	public String findCourseInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCourseInfo = studentCourseManageManager.findCourseInfoBySid(FStudentNumber);
		
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
	 * <p>功能：通过学生Id号查找与其相关的课程疑问<br>
	 * @return action questionReplyInfo
	 */
	public String questionReplyInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = studentCourseManageManager.findQuestionReplyInfoBySid(FStudentNumber);
	    listCourseInfo = studentCourseManageManager.findCourseInfoBySid(FStudentNumber);
		return "questionReplyInfo";
	}
	
	/**
	 * <p>功能：根据课程疑问Id号查找相关的疑问详情，并根据其id号查找相关的回复内容<br>
	 * @return action findProblemDetailByID
	 */
	public String findProblemDetailByID(){
		jfptTabCourseaskquestion = studentCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		listCoursereplyquestionInfo = studentCourseManageManager.findCourseReplyInfoByID(FQuestionId);
		return "findProblemDetailByID";
	}
	
	/**
	 * <p>功能：添加回复内容<br>
	 * @return action addReplyInfoByID
	 */
	public String addReplyInfoByID(){
		FStudentNumber = (String)session.get("FUserNumber");
		JfptTabCoursereplyquestion jfptTabCoursereplyquestion1 = new JfptTabCoursereplyquestion();
		jfptTabCoursereplyquestion1.setFContents(FContents);
		jfptTabCoursereplyquestion1.setFDateTime(new Date());
		jfptTabCoursereplyquestion1.setFReplyUserId(FStudentNumber);
		JfptTabCourseaskquestion jfptTabCourseaskquestion1 = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion1 = studentCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		jfptTabCoursereplyquestion1.setJfptTabCourseaskquestion(jfptTabCourseaskquestion1);
		studentCourseManageManager.addCoursereplyInfo(jfptTabCoursereplyquestion1);
		
		listCourseaskquestionInfo = studentCourseManageManager.findQuestionReplyInfoBySid(FStudentNumber);
		return "addReplyInfoByID";
	}
	
	/**
	 * <p>功能：根据课程号和学生编号查找相关的课程疑问，并进行分页处理<br>
	 * @return action selectQuestionReplyInfo
	 */
	public String selectQuestionReplyInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = studentCourseManageManager.findQuestionReplayInfoByTwo(FStudentNumber,FCourseNumber);
		
		int pages = 5;
		int listlength = listCourseaskquestionInfo.size();
		if(listlength==0)
			return "selectQuestionReplyInfo";
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
	
	/**
	 * <p>功能：添加课程答疑对象，用于提问<br>
	 * @return action addAskInfo
	 */
	public String addAskInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		JfptTabCourseaskquestion jfptTabCourseaskquestion1 = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion1.setFContents(FContents);
		jfptTabCourseaskquestion1.setFDateTime(new Date());
		TabCourse tabCourse = new TabCourse();
		tabCourse = studentCourseManageManager.findCourseByID(FCourseNumber);
		jfptTabCourseaskquestion1.setTabCourse(tabCourse);
		TabStudents tabStudents = new TabStudents();
		tabStudents = studentCourseManageManager.findStudentByID(FStudentNumber);
		jfptTabCourseaskquestion1.setTabStudents(tabStudents);
		
		studentCourseManageManager.addCourseaskquestion(jfptTabCourseaskquestion1);
		listCourseaskquestionInfo = studentCourseManageManager.findQuestionReplyInfoBySid(FStudentNumber);
	    listCourseInfo = studentCourseManageManager.findCourseInfoBySid(FStudentNumber);
		return "addAskInfo";
	}
	
	/**
	 * <p>功能：进行提问前根据学生学号查找相关的课程信息<br>
	 * @return action addInfoBeforeAsk
	 */
	public String addInfoBeforeAsk(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCourseInfo = studentCourseManageManager.findCourseInfoBySid(FStudentNumber);
		return "addInfoBeforeAsk";
	}
	
	/**
	 * <p>功能：用于文件下载的方法<br>
	 * @return action downFile
	 */
	public String downFile(){      //下载      jfpt/Resource/CourseNotice/课程通知.txt
		JfptTabCoursenotice info=studentCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		this.setContentType("application/"+this.getExt(info.getFUrl()));
		String nametofile = info.getFUrl().substring(info.getFUrl().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseNotice\\"+nametofile);
		this.setFileName(nametofile);
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
		String subStr=str.substring(str.lastIndexOf("."));
		return subStr;
	}
	
	//查看课程通知
	/**
	 * <p>功能：查找课程通知信息，并对结果进行分页处理<br>
	 * @return action findCourseNoticeInfo
	 */
	public String findCourseNoticeInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCoursenoticeInfo = studentCourseManageManager.findCourseNoticeInfo(FStudentNumber);
		
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
	 * <p>功能：删除通知，学生删除和其它人不同，是删除中间表的内容<br>
	 * @return action deleteNoticeByID
	 */
	public String deleteNoticeByID(){ //FNoticeId
		FStudentNumber = (String)session.get("FUserNumber");
		studentCourseManageManager.deleteCourseNoticetotoInfo(FNoticeId,FStudentNumber);
			
		listCoursenoticeInfo = studentCourseManageManager.findCourseNoticeInfo(FStudentNumber);
		return "deleteNoticeByID";
	}
	//查看详情
	/**
	 * <p>功能：查看课程通知的详细内容<br>
	 * @return action findNoticeDetailByID
	 */
	public String findNoticeDetailByID(){
			jfptTabCoursenotice = studentCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
			return "findNoticeDetailByID";
		}
}
