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
 * <p>���ܣ�ѧ���γ̹���ģ�飬��Ҫ����Ϊ���鿴�γ̡��鿴֪ͨ���γ̴��ɡ�<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentCourseManageAction extends ActionSupport implements SessionAware{

	/**service����󣬱��ڵ���service�㷽��*/
	private StudentCourseManageManager studentCourseManageManager;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfo;
	/**�γ̴�����Ϣ*/
	private List<JfptTabCourseaskquestion> listCourseaskquestionInfo;
	/**�γ̴���id��*/
	private int FQuestionId;
	/**�γ̴��ɶ�����Ϣ*/
	private JfptTabCourseaskquestion jfptTabCourseaskquestion;
	/**�γ̴��ɻظ���Ϣ*/
	private List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo;
	/**�γ̴��ɻظ�*/
	private JfptTabCoursereplyquestion jfptTabCoursereplyquestion;
	/**����*/
	private String FContents;
	/**ʱ��*/
	private Date FDateTime;
	/**�γ̱��*/
	private String FCourseNumber;
	/**ҳ������*/
	private String contentType;                  //����
	/**�ļ�·��*/
    private String filePath;
    /**�ļ�����*/
	private String fileName;
	/**����id��*/
	private int downId;
	/**�γ�֪ͨ��Ϣ*/
	private List<JfptTabCoursenotice> listCoursenoticeInfo;
	/**֪ͨid��*/
	private int FNoticeId;
	/**�γ�֪ͨ����*/
	private JfptTabCoursenotice jfptTabCoursenotice;
	/**ѧ��ѧ��*/
	private String FStudentNumber;
	/**Map���Ͷ���*/
	private Map<String,Object> session;
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
	 * <p>���ܣ�����ѧ����Ų�ѯ��������صĿγ���Ϣ,�����з�ҳ����<br>
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
	 * <p>���ܣ�ͨ��ѧ��Id�Ų���������صĿγ�����<br>
	 * @return action questionReplyInfo
	 */
	public String questionReplyInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = studentCourseManageManager.findQuestionReplyInfoBySid(FStudentNumber);
	    listCourseInfo = studentCourseManageManager.findCourseInfoBySid(FStudentNumber);
		return "questionReplyInfo";
	}
	
	/**
	 * <p>���ܣ����ݿγ�����Id�Ų�����ص��������飬��������id�Ų�����صĻظ�����<br>
	 * @return action findProblemDetailByID
	 */
	public String findProblemDetailByID(){
		jfptTabCourseaskquestion = studentCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		listCoursereplyquestionInfo = studentCourseManageManager.findCourseReplyInfoByID(FQuestionId);
		return "findProblemDetailByID";
	}
	
	/**
	 * <p>���ܣ���ӻظ�����<br>
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
	 * <p>���ܣ����ݿγ̺ź�ѧ����Ų�����صĿγ����ʣ������з�ҳ����<br>
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
	 * <p>���ܣ���ӿγ̴��ɶ�����������<br>
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
	 * <p>���ܣ���������ǰ����ѧ��ѧ�Ų�����صĿγ���Ϣ<br>
	 * @return action addInfoBeforeAsk
	 */
	public String addInfoBeforeAsk(){
		FStudentNumber = (String)session.get("FUserNumber");
		listCourseInfo = studentCourseManageManager.findCourseInfoBySid(FStudentNumber);
		return "addInfoBeforeAsk";
	}
	
	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile(){      //����      jfpt/Resource/CourseNotice/�γ�֪ͨ.txt
		JfptTabCoursenotice info=studentCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
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
	
	//�鿴�γ�֪ͨ
	/**
	 * <p>���ܣ����ҿγ�֪ͨ��Ϣ�����Խ�����з�ҳ����<br>
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
	 * <p>���ܣ�ɾ��֪ͨ��ѧ��ɾ���������˲�ͬ����ɾ���м�������<br>
	 * @return action deleteNoticeByID
	 */
	public String deleteNoticeByID(){ //FNoticeId
		FStudentNumber = (String)session.get("FUserNumber");
		studentCourseManageManager.deleteCourseNoticetotoInfo(FNoticeId,FStudentNumber);
			
		listCoursenoticeInfo = studentCourseManageManager.findCourseNoticeInfo(FStudentNumber);
		return "deleteNoticeByID";
	}
	//�鿴����
	/**
	 * <p>���ܣ��鿴�γ�֪ͨ����ϸ����<br>
	 * @return action findNoticeDetailByID
	 */
	public String findNoticeDetailByID(){
			jfptTabCoursenotice = studentCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
			return "findNoticeDetailByID";
		}
}
