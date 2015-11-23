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
import com.xdsc.service.jiaofu.AssistCourseManageManager;

/**
 * <p>���ܣ����̿γ̹���ģ�飬��Ҫ����Ϊ���鿴�γ̡�����֪ͨ���γ̴��ɡ�<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistCourseManageAction extends ActionSupport implements SessionAware {
	/**service����󣬱��ڵ���service��ķ���*/
	private AssistCourseManageManager assistCourseManageManager;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfo;
	/**�γ�����*/
	private List<JfptTabCourseaskquestion> listCourseaskquestionInfo;
	/**�γ̱��*/
	private String FCourseNumber;
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
	/**�γ�֪ͨ��Ϣ*/
	private List<JfptTabCoursenotice> listCoursenoticeInfo;
	/**֪ͨID��*/
	private int FNoticeId;
	/**֪ͨ���Ͷ���*/
	private JfptTabCoursenotice jfptTabCoursenotice;
	/**����ҳ����������*/
	private String contentType; // ����
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
	private File uploadFile; // �ϴ�
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
	/**Map ���ͱ���*/
	private Map<String, Object> session;
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

	public List<String> getListClassNumberInfo() {
		return listClassNumberInfo;
	}

	public void setListClassNumberInfo(List<String> listClassNumberInfo) {
		this.listClassNumberInfo = listClassNumberInfo;
	}

	public List<TabDirection> getListDirectionInfo() {
		return listDirectionInfo;
	}

	public void setListDirectionInfo(List<TabDirection> listDirectionInfo) {
		this.listDirectionInfo = listDirectionInfo;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public AssistCourseManageManager getAssistCourseManageManager() {
		return assistCourseManageManager;
	}

	public void setAssistCourseManageManager(
			AssistCourseManageManager assistCourseManageManager) {
		this.assistCourseManageManager = assistCourseManageManager;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public List<JfptTabCourseaskquestion> getListCourseaskquestionInfo() {
		return listCourseaskquestionInfo;
	}

	public void setListCourseaskquestionInfo(
			List<JfptTabCourseaskquestion> listCourseaskquestionInfo) {
		this.listCourseaskquestionInfo = listCourseaskquestionInfo;
	}

	public int getFQuestionId() {
		return FQuestionId;
	}

	public void setFQuestionId(int questionId) {
		FQuestionId = questionId;
	}

	public List<JfptTabCoursenotice> getListCoursenoticeInfo() {
		return listCoursenoticeInfo;
	}

	public void setListCoursenoticeInfo(
			List<JfptTabCoursenotice> listCoursenoticeInfo) {
		this.listCoursenoticeInfo = listCoursenoticeInfo;
	}

	public int getFNoticeId() {
		return FNoticeId;
	}

	public void setFNoticeId(int noticeId) {
		FNoticeId = noticeId;
	}

	public JfptTabCoursenotice getJfptTabCoursenotice() {
		return jfptTabCoursenotice;
	}

	public void setJfptTabCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
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

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public List<TabStudents> getListStudentsInfo() {
		return listStudentsInfo;
	}

	public void setListStudentsInfo(List<TabStudents> listStudentsInfo) {
		this.listStudentsInfo = listStudentsInfo;
	}

	public List<String> getListStudentNumber() {
		return listStudentNumber;
	}

	public void setListStudentNumber(List<String> listStudentNumber) {
		this.listStudentNumber = listStudentNumber;
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

	public JfptTabNoticetoreceive getJfptTabNoticetoreceive() {
		return jfptTabNoticetoreceive;
	}

	public void setJfptTabNoticetoreceive(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		this.jfptTabNoticetoreceive = jfptTabNoticetoreceive;
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

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	/**
	 * <p>���ܣ��������̱�Ų�ѯ��������صĿγ���Ϣ,�����з�ҳ����<br>
	 * @return action findCourseInfo
	 */
	public String findCourseInfo() {
		String id = (String)session.get("FUserNumber");
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		
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
	 * <p>���ܣ�ͨ������Id�Ų���������صĿγ�����<br>
	 * @return action questionReplyInfo
	 */
	public String questionReplyInfo() {
		String id = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = assistCourseManageManager.findQuestionReplyInfoByAid(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		return "questionReplyInfo";
	}

	/**
	 * <p>���ܣ����ݿγ̺ź����̱�Ų�����صĿγ����ʣ������з�ҳ����<br>
	 * @return action selectQuestionReplyInfo
	 */
	public String selectQuestionReplyInfo() {
		String id = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = assistCourseManageManager.findQuestionReplayInfoByTwo(id, FCourseNumber);
		
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
	 * <p>���ܣ����ݿγ�����Id�Ų�����ص��������飬��������id�Ų�����صĻظ�����<br>
	 * @return action findProblemDetailByID
	 */
	public String findProblemDetailByID() {
		jfptTabCourseaskquestion = assistCourseManageManager
				.findCourseaskquestionInfoByID(FQuestionId);
		listCoursereplyquestionInfo = assistCourseManageManager
				.findCourseReplyInfoByID(FQuestionId);
		return "findProblemDetailByID";
	}

	/**
	 * <p>���ܣ���ӻظ�����<br>
	 * @return action addReplyInfoByID
	 */
	public String addReplyInfoByID() {
		String id = (String)session.get("FUserNumber");
		JfptTabCoursereplyquestion jfptTabCoursereplyquestion1 = new JfptTabCoursereplyquestion();
		jfptTabCoursereplyquestion1.setFContents(FContents);
		jfptTabCoursereplyquestion1.setFDateTime(new Date());
		jfptTabCoursereplyquestion1.setFReplyUserId(id);
		JfptTabCourseaskquestion jfptTabCourseaskquestion1 = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion1 = assistCourseManageManager
				.findCourseaskquestionInfoByID(FQuestionId);
		jfptTabCoursereplyquestion1
				.setJfptTabCourseaskquestion(jfptTabCourseaskquestion1);
		assistCourseManageManager
				.addCoursereplyInfo(jfptTabCoursereplyquestion1);

		listCourseaskquestionInfo = assistCourseManageManager
				.findQuestionReplyInfoByAid(id);
		return "addReplyInfoByID";
	}

	/**
	 * <p>���ܣ�ɾ���γ����ʣ�����ɾ����صĻظ���Ϣ<br>
	 * @return action deleteAskQuestionByID
	 */
	public String deleteAskQuestionByID() {
		String id = (String)session.get("FUserNumber");
		assistCourseManageManager.deleteAskQuestionByID(FQuestionId);

		listCourseaskquestionInfo = assistCourseManageManager.findQuestionReplyInfoByAid(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		return "deleteAskQuestionByID";
	}

	// �鿴�γ�֪ͨ
	/**
	 * <p>���ܣ����ҿγ�֪ͨ��Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findCourseNoticeInfo
	 */
	public String findCourseNoticeInfo() {
		String id = (String)session.get("FUserNumber");
		listCoursenoticeInfo = assistCourseManageManager.findCourseNoticeInfo(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		
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

	// ɾ��֪ͨ
	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ϣ<br>
	 * @return action deleteNoticeByID
	 */
	public String deleteNoticeByID() {
		String id = (String)session.get("FUserNumber");
		jfptTabCoursenotice = assistCourseManageManager
				.findCourseNoticeInfoByID(FNoticeId);
		assistCourseManageManager.deleteCourseNoticeInfo(jfptTabCoursenotice);

		listCoursenoticeInfo = assistCourseManageManager
				.findCourseNoticeInfo(id);
		return "deleteNoticeByID";
	}

	// �鿴����
	/**
	 * <p>���ܣ��鿴�γ�֪ͨ����ϸ����<br>
	 * @return action findNoticeDetailByID
	 */
	public String findNoticeDetailByID() {
		jfptTabCoursenotice = assistCourseManageManager
				.findCourseNoticeInfoByID(FNoticeId);
		return "findNoticeDetailByID";
	}

	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile() { // ���� jfpt/Resource/CourseNotice/�γ�֪ͨ.txt
		JfptTabCoursenotice info = assistCourseManageManager
				.findCourseNoticeInfoByID(FNoticeId);
		this.setContentType("application/" + this.getExt(info.getFUrl()));
		String nametofile = info.getFUrl().substring(
				info.getFUrl().lastIndexOf("/") + 1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseNotice\\"
				+ nametofile);
		this.setFileName(nametofile);
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
		String subStr = str.substring(str.lastIndexOf("."));
		return subStr;
	}

	/**
	 * <p>���ܣ���ӿγ�֪ͨǰ��׼��������������������صĿγ���Ϣ��ѧ����Ϣ���༶��Ϣ��������Ϣ<br>
	 * @return action AddNewNoticeBefore
	 */
	public String AddNewNoticeBefore() {
		String id = (String)session.get("FUserNumber");
		tabCourse = assistCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistCourseManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		
		listClassNumberInfo = assistCourseManageManager.findClassNumberInfo(id,FCourseNumber);
		listDirectionInfo = assistCourseManageManager.findDirectionInfo(listStudentsInfo,FCourseNumber);
		return "AddNewNoticeBefore";
	}
	
	/**
	 * <p>���ܣ�������صĿγ���Ϣ���ҿγ���Ϣ��������֮��ص�ѧ����Ϣ���ڴ˻�����ͨ�������༶����������ѧ��������Ϣ<br>
	 * @return action AddNewNoticeBefore2
	 */
	public String AddNewNoticeBefore2() {
		String id = (String)session.get("FUserNumber");
		tabCourse = assistCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistCourseManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		
		listStudentsInfo = assistCourseManageManager.findStudentsInfo(ClassNumber,DirectionNumber,listStudentsInfo);
		return "AddNewNoticeBefore2";
	}

	/**
	 * <p>���ܣ����֪ͨ<br>
	 * @return action addNotice
	 */
	public String addNotice() { // ���֪ͨ
		String id = (String)session.get("FUserNumber");
		for (String i : listStudentNumber) {
			System.out.println(i);
		}
		if (uploadFile != null) {
			assistCourseManageManager.savefile(uploadFile, savePath,
					uploadFileFileName);
			JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
			jfptTabCoursenotice1.setFContent(FContent);
			MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
			mhqxTabUser1 = assistCourseManageManager.findUserByID(id);
			jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
			jfptTabCoursenotice1.setFDate(new Date());
			jfptTabCoursenotice1.setFTitle(FTitle);
			FUrl = savePath + "/" + uploadFileFileName;
			jfptTabCoursenotice1.setFUrl(FUrl);
			tabCourse = assistCourseManageManager
					.findCourseInfoByID(FCourseNumber);
			jfptTabCoursenotice1.setTabCourse(tabCourse);
			assistCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
			// �����ض�Ӧ��Ϣ��--->��Ӧ��
			for (String i : listStudentNumber) {
				JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
				jfptTabNoticetoreceive1.setFMarkable("N");
				jfptTabNoticetoreceive1
						.setJfptTabCoursenotice(jfptTabCoursenotice1);
				MhqxTabUser mhqxTabUser = new MhqxTabUser();
				mhqxTabUser = assistCourseManageManager.findUserByID(i);
				jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
				assistCourseManageManager
						.addCoursenoticetoto(jfptTabNoticetoreceive1);
			}

			listCoursenoticeInfo = assistCourseManageManager
					.findCourseNoticeInfo(id);
			listCourseInfo = assistCourseManageManager
					.findCourseInfoByAid(id);
			return "addNotice";
		}
		JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
		jfptTabCoursenotice1.setFContent(FContent);
		jfptTabCoursenotice1.setFDate(new Date());
		jfptTabCoursenotice1.setFTitle(FTitle);
		MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
		mhqxTabUser1 = assistCourseManageManager.findUserByID(id);
		jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
		tabCourse = assistCourseManageManager.findCourseInfoByID(FCourseNumber);
		jfptTabCoursenotice1.setTabCourse(tabCourse);
		assistCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
		// �����ض�Ӧ��Ϣ��--->��Ӧ��
		for (String i : listStudentNumber) {
			JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
			jfptTabNoticetoreceive1.setFMarkable("N");
			jfptTabNoticetoreceive1
					.setJfptTabCoursenotice(jfptTabCoursenotice1);
			MhqxTabUser mhqxTabUser = new MhqxTabUser();
			mhqxTabUser = assistCourseManageManager.findUserByID(i);
			jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
			assistCourseManageManager
					.addCoursenoticetoto(jfptTabNoticetoreceive1);
		}

		listCoursenoticeInfo = assistCourseManageManager
				.findCourseNoticeInfo(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		return "addNotice";
	}
	
	/**
	 * <p>���ܣ����Ҷ�Ӧ�γ̵İ༶�ͷ�����Ϣ<br>
	 * @return action seeCourseDetail
	 */
	public String seeCourseDetail(){
		String id = (String)session.get("FUserNumber");
		System.out.println("seeCourseDetail-------------begin---------------Assist");
		listClassNumberInfo = assistCourseManageManager.findClassNumberInfo(id, FCourseNumber); //List<String>
		listStudentsInfo = assistCourseManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		listDirectionInfo = assistCourseManageManager.findDirectionInfo(listStudentsInfo, FCourseNumber);  //List<TabDirection>
		System.out.println("seeCourseDetail---------------end-------------Assist");
		return "seeCourseDetail";
	}
}
