package com.xdsc.action.jiaofu;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.AssistHomeworkManageManager;

/**
 * <p>���ܣ���ҵ����ģ�飬��Ҫ���в�����ҵ��������ҵ��ƽʱ���˲�����<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistHomeworkManageAction extends ActionSupport implements
		SessionAware {
	/**service����󣬱��ڵ���service��ķ���*/
	private AssistHomeworkManageManager assistHomeworkManageManager;
	/**�γ���Ϣ*/
	private List<TabCourse> listCourseInfo;
	/**ƽʱ�ɼ�*/
	private List<JfptTabUsualscore> listUsualscoreInfo;
	/**�γ̱��*/
	private String FCourseNumber;
	/**ƽʱ�ɼ�����id��*/
	private int FNumber;
	/**ƽʱ�ɼ�����*/
	private JfptTabUsualscore jfptTabUsualscore;
	/**�γ̶���*/
	private TabCourse tabCourse;
	/**ѧ��*/
	private String FXueQi;
	/**������Ϣ*/
	private List<String> listFTypeInfo = new ArrayList<String>();
	/**ѧ��ѧ��*/
	private String FStudentNumber;
	/**����*/
	private String FType;
	/**�÷�*/
	private int FScore;
	// *************************������ҵ
	/**��ҵ֪ͨ*/
	private List<JfptTabHomenotice> listHomenoticeInfo;
	/**��ҵ֪ͨid��*/
	private int FHomeNoticeId;
	/**��ҵ֪ͨ����*/
	private JfptTabHomenotice jfptTabHomenotice;
	/**����ҳ������*/
	private String contentType; // ����
	/**�ļ�·��*/
	private String filePath;
	/**�ļ�����*/
	private String fileName;
	/**����id��*/
	private int downId;
	/**ѧ��������Ϣ*/
	private List<TabStudents> listStudentsInfo;
	/**ѧ��ѧ����Ϣ*/
	private List<String> listStudentNumber = new ArrayList<String>();
	/**�ϴ��ļ�*/
	private File uploadFile;
	/**����*/
	private String uploadFileContentType;
	/**�ļ�����*/
	private String uploadFileFileName;
	/**����·��*/
	private String savePath;
	/**����*/
	private String FTitle;
	/**����*/
	private String FContent;
	/**ʱ��*/
	private Date FDate;
	/**��ַ*/
	private String FUrl;
	// *****************************������ҵ
	/**�ϴ���ҵ����*/
	private JfptTabHomeupload jfptTabHomeupload;
	/**��ҵid��*/
	private int FHomeId;
	/**�ظ�*/
	private String FReply;
	/**�ϴ���ҵ��Ϣ*/
	private List<JfptTabHomeupload> listHomeuploadInfo;
	/**Map���Ͷ���*/
	private Map<String, Object> session;
	/**�÷�*/
	private int score;
	// ���Ͷ������
	/**�༶��Ϣ*/
	private List<String> listClassNumberInfo = new ArrayList<String>();
	/**������Ϣ*/
	private List<TabDirection> listDirectionInfo = new ArrayList<TabDirection>();
	/**�༶��*/
	private String ClassNumber;
	/**������*/
	private int DirectionNumber;
	/**ҳ�洦���м�¼��ǰҳ���*/
	private int p = 1;
	/**ҳ�洦���жԲ�ѯ������зֲ�������¼��ҳ����*/
	private int lastPage;
	// ͼ���������
	/**ͼ���������*/
	private JFreeChart chart;

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public List<JfptTabHomeupload> getListHomeuploadInfo() {
		return listHomeuploadInfo;
	}

	public void setListHomeuploadInfo(List<JfptTabHomeupload> listHomeuploadInfo) {
		this.listHomeuploadInfo = listHomeuploadInfo;
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

	public String getFReply() {
		return FReply;
	}

	public void setFReply(String reply) {
		FReply = reply;
	}

	public AssistHomeworkManageManager getAssistHomeworkManageManager() {
		return assistHomeworkManageManager;
	}

	public void setAssistHomeworkManageManager(
			AssistHomeworkManageManager assistHomeworkManageManager) {
		this.assistHomeworkManageManager = assistHomeworkManageManager;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public List<JfptTabUsualscore> getListUsualscoreInfo() {
		return listUsualscoreInfo;
	}

	public void setListUsualscoreInfo(List<JfptTabUsualscore> listUsualscoreInfo) {
		this.listUsualscoreInfo = listUsualscoreInfo;
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

	public List<JfptTabHomenotice> getListHomenoticeInfo() {
		return listHomenoticeInfo;
	}

	public void setListHomenoticeInfo(List<JfptTabHomenotice> listHomenoticeInfo) {
		this.listHomenoticeInfo = listHomenoticeInfo;
	}

	public int getFHomeNoticeId() {
		return FHomeNoticeId;
	}

	public void setFHomeNoticeId(int homeNoticeId) {
		FHomeNoticeId = homeNoticeId;
	}

	public JfptTabHomenotice getJfptTabHomenotice() {
		return jfptTabHomenotice;
	}

	public void setJfptTabHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		this.jfptTabHomenotice = jfptTabHomenotice;
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

	public String getFTitle() {
		return FTitle;
	}

	public void setFTitle(String title) {
		FTitle = title;
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

	public String getFUrl() {
		return FUrl;
	}

	public void setFUrl(String url) {
		FUrl = url;
	}

	public JfptTabUsualscore getJfptTabUsualscore() {
		return jfptTabUsualscore;
	}

	public void setJfptTabUsualscore(JfptTabUsualscore jfptTabUsualscore) {
		this.jfptTabUsualscore = jfptTabUsualscore;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public String getFXueQi() {
		return FXueQi;
	}

	public void setFXueQi(String xueQi) {
		FXueQi = xueQi;
	}

	public List<String> getListFTypeInfo() {
		return listFTypeInfo;
	}

	public void setListFTypeInfo(List<String> listFTypeInfo) {
		this.listFTypeInfo = listFTypeInfo;
	}

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public String getFType() {
		return FType;
	}

	public void setFType(String type) {
		FType = type;
	}

	public int getFScore() {
		return FScore;
	}

	public void setFScore(int score) {
		FScore = score;
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų�����صĿγ���Ϣ<br>
	 * @return action findBeforeScoreInfo
	 */
	public String findBeforeScoreInfo() {
		String id = (String) session.get("FUserNumber");
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		return "findBeforeScoreInfo";
	}

	/**
	 * <p>���ܣ����ݿγ����ƺ͸��˱�Ž��гɼ���Ϣ�Ĳ�ѯ�����Խ����Ϣ���з�ҳ����<br>
	 * @return action findUsualSelectInfo
	 */
	public String findUsualSelectInfo() { // FCourseNumber Tid
		String id = (String) session.get("FUserNumber");
		listUsualscoreInfo = assistHomeworkManageManager
				.findUsualscoreInfoByTwo(FCourseNumber, id);
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);

		int pages = 5;
		int listlength = listUsualscoreInfo.size();
		if (listlength == 0)
			return "findUsualSelectInfo";
		if (listlength % pages == 0) {
			lastPage = listlength / pages;
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
		listUsualscoreInfo = listUsualscoreInfo.subList(startIndex, endIndex);

		return "findUsualSelectInfo";
	}

	/**
	 * <p>���ܣ����ݳɼ�id�Ų��ҳɼ�������Ϣ������ɾ��<br>
	 * @return action deleteUsualscoreInfoByID
	 */
	public String deleteUsualscoreInfoByID() {
		String id = (String) session.get("FUserNumber");
		jfptTabUsualscore = assistHomeworkManageManager.findUsualscoreInfoByID(FNumber);
		assistHomeworkManageManager.deleteUsualscoreInfo(jfptTabUsualscore);

		listUsualscoreInfo = assistHomeworkManageManager.findUsualscoreInfoByTwo(FCourseNumber, id);
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		return "deleteUsualscoreInfoByID";
	}

	/**
	 * <p>���ܣ����³ɼ���Ϣ������سɼ���Ϣ����ͳ�ƺ����������ս����ֳɼ���Ϣ���һ�֣�ƽʱ�ɼ�����<br>
	 * @return action updateStudentsScore
	 */
	public String updateStudentsScore() {
		String aid = (String) session.get("FUserNumber");
		listUsualscoreInfo = assistHomeworkManageManager
				.findUsualscoreInfoByTwo(FCourseNumber, aid);
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfoByTwo(
				aid, FCourseNumber);
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		assistHomeworkManageManager.updateStudentsScore(listUsualscoreInfo,
				listStudentsInfo, tabCourse);

		// ��ʱ���ص�ƽʱ�ɼ���Ϊ���ܹ��ĳɼ����ֱ��ǣ�ƽʱ���˻��ܣ�ƽʱ��ҵ���ܣ��ϻ���ҵ����-->ƽʱ�ɼ�����
		listUsualscoreInfo = assistHomeworkManageManager
				.findUsualscoreInfoByTwo(FCourseNumber, aid);
		return "updateStudentsScore";
	}

	/**
	 * <p>���ܣ�Ϊ����ƽʱ�ɼ���Ϣ��׼������ѯ��صĿγ���Ϣ��ѧ����Ϣ��������Ϣ<br>
	 * @return action addUsualscoreInfo
	 */
	public String addUsualscoreInfo() {
		listFTypeInfo.clear();
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		Date date = new Date();
		int year = (date.getYear() + 1900) % 100;
		int month = date.getMonth() + 1;

		if (month > 2 && month < 8) {
			FXueQi = year + "����"; // 3 4 5 6 7
		} else {
			FXueQi = year + "����"; // 8 9 10 11 12 1 2
		}
		listFTypeInfo.add("ƽʱ����");
		listFTypeInfo.add("ƽʱ��ҵ");
		listFTypeInfo.add("�ϻ���ҵ");
		return "addUsualscoreInfo";
	}

	/**
	 * <p>���ܣ�����ƽʱ�ɼ���Ϣ<br>
	 * @return action addNewUsualScoreInfo
	 */
	public String addNewUsualScoreInfo() {
		String id = (String) session.get("FUserNumber");
		JfptTabUsualscore jfptTabUsualscore1 = new JfptTabUsualscore();
		jfptTabUsualscore1.setFScore(FScore);
		jfptTabUsualscore1.setFType(FType);
		jfptTabUsualscore1.setFXueQi(FXueQi);
		jfptTabUsualscore1.setTabCourse(tabCourse);
		TabStudents tabStudents = new TabStudents();
		tabStudents = assistHomeworkManageManager.findStudentsInfoByID(FStudentNumber);
		jfptTabUsualscore1.setTabStudents(tabStudents);
		assistHomeworkManageManager.addUsualScoreInfo(jfptTabUsualscore1);

		listUsualscoreInfo = assistHomeworkManageManager
				.findUsualscoreInfoByTwo(tabCourse.getFCourseNumber(), id);
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		return "addNewUsualScoreInfo";
	}

	// ******************************************������ҵ****************************************
	/**
	 * <p>���ܣ����������ҵ֪ͨ��Ϣ�����Խ�����з�ҳ����<br>
	 * @return action findHomeNoticeInfo
	 */
	public String findHomeNoticeInfo() {
		String id = (String) session.get("FUserNumber");
		listHomenoticeInfo = assistHomeworkManageManager.findHomeNoticeInfoByAid(id);
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);

		int pages = 5;
		int listlength = listHomenoticeInfo.size();
		if (listlength == 0)
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
		listHomenoticeInfo = listHomenoticeInfo.subList(startIndex, endIndex);

		return "findHomeNoticeInfo";
	}

	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų�����ϸ��Ϣ<br>
	 * @return action findHomeDetailByID
	 */
	public String findHomeDetailByID() {
		jfptTabHomenotice = assistHomeworkManageManager
				.findHomeDetailByID(FHomeNoticeId);
		return "findHomeDetailByID";
	}

	/**
	 * <p>���ܣ�������ҵ֪ͨid�Ų�����ض�����Ϣ������ɾ��<br>
	 * @return action deleteHomeByID
	 */
	public String deleteHomeByID() {
		String id = (String) session.get("FUserNumber");
		jfptTabHomenotice = assistHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		assistHomeworkManageManager.deleteHome(jfptTabHomenotice);

		listHomenoticeInfo = assistHomeworkManageManager.findHomeNoticeInfoByAid(id);
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		return "deleteHomeByID";
	}

	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile() { // ����
		JfptTabHomenotice info = assistHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		this.setContentType("application/" + this.getExt(info.getFUrl()));
		String name = info.getFUrl().substring(info.getFUrl().lastIndexOf("/") + 1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\HomeNotice\\" + name);
		this.setFileName(name);
		return "downFileSuccess";
	}

	/**
	 * <p>���ܣ������ļ����������<br>
	 * @return InputStream
	 * @throws Exception
	 */
	public InputStream getDownFile() throws Exception { // �ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
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
	 * <p>���ܣ�Ϊ������ҵ֪ͨ����Ϣ׼������������˱����ص�ѧ����Ϣ���༶��Ϣ��������Ϣ��<br>
	 * @return action AddNewHomenoticeBefore
	 */
	public String AddNewHomenoticeBefore() {
		String id = (String) session.get("FUserNumber");
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfoByTwo(
				id, FCourseNumber);

		listClassNumberInfo = assistHomeworkManageManager.findClassNumberInfo(
				id, FCourseNumber);
		listDirectionInfo = assistHomeworkManageManager.findDirectionInfo(
				listStudentsInfo, FCourseNumber);
		return "AddNewHomenoticeBefore";
	}

	/**
	 * <p>���ܣ����ݰ༶��š������Ž���һ������ѧ��������Ϣ<br>
	 * @return action AddNewHomenoticeBefore2
	 */
	public String AddNewHomenoticeBefore2() {
		String id = (String) session.get("FUserNumber");
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfoByTwo(
				id, FCourseNumber);
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfo(
				ClassNumber, DirectionNumber, listStudentsInfo);
		return "AddNewHomenoticeBefore2";
	}

	/**
	 * <p>���ܣ�������ҵ֪ͨ<br>
	 * @return action addHome
	 */
	public String addHome() {
		String id = (String) session.get("FUserNumber");
		for (String i : listStudentNumber) {
			System.out.println(i);
		}
		if (uploadFile != null) {
			assistHomeworkManageManager.savefile(uploadFile, savePath,
					uploadFileFileName);
			JfptTabHomenotice jfptTabHomenotice1 = new JfptTabHomenotice();
			jfptTabHomenotice1.setFContent(FContent);
			MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
			mhqxTabUser1 = assistHomeworkManageManager.findUserByID(id);
			jfptTabHomenotice1.setMhqxTabUser(mhqxTabUser1);
			jfptTabHomenotice1.setFDate(new Date());
			jfptTabHomenotice1.setFTitle(FTitle);
			FUrl = savePath + "/" + uploadFileFileName;
			jfptTabHomenotice1.setFUrl(FUrl);
			tabCourse = assistHomeworkManageManager
					.findCourseInfoByID(FCourseNumber);
			jfptTabHomenotice1.setTabCourse(tabCourse);
			assistHomeworkManageManager.addHomenotice(jfptTabHomenotice1);
			// ������ض�Ӧ��Ϣ��--->��Ӧ��
			for (String i : listStudentNumber) {
				JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive1 = new JfptTabHomenoticetoreceive();
				jfptTabHomenoticetoreceive1.setFMarkable("N");
				jfptTabHomenoticetoreceive1
						.setJfptTabHomenotice(jfptTabHomenotice1);
				TabStudents tabStudents = new TabStudents();
				tabStudents = assistHomeworkManageManager.findStudentsByID(i);
				jfptTabHomenoticetoreceive1.setTabStudents(tabStudents);
				assistHomeworkManageManager
						.addHomenoticetoto(jfptTabHomenoticetoreceive1);
			}

			listHomenoticeInfo = assistHomeworkManageManager
					.findHomeNoticeInfoByAid(id);
			listCourseInfo = assistHomeworkManageManager
					.findCourseInfoByAid(id);
			return "addHome";
		}
		JfptTabHomenotice jfptTabHomenotice1 = new JfptTabHomenotice();
		jfptTabHomenotice1.setFContent(FContent);
		MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
		mhqxTabUser1 = assistHomeworkManageManager.findUserByID(id);
		jfptTabHomenotice1.setMhqxTabUser(mhqxTabUser1);
		jfptTabHomenotice1.setFDate(new Date());
		jfptTabHomenotice1.setFTitle(FTitle);
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		jfptTabHomenotice1.setTabCourse(tabCourse);
		assistHomeworkManageManager.addHomenotice(jfptTabHomenotice1);
		// ������ض�Ӧ��Ϣ��--->��Ӧ��
		for (String i : listStudentNumber) {
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive1 = new JfptTabHomenoticetoreceive();
			jfptTabHomenoticetoreceive1.setFMarkable("N");
			jfptTabHomenoticetoreceive1
					.setJfptTabHomenotice(jfptTabHomenotice1);
			TabStudents tabStudents = new TabStudents();
			tabStudents = assistHomeworkManageManager.findStudentsByID(i);
			jfptTabHomenoticetoreceive1.setTabStudents(tabStudents);
			assistHomeworkManageManager
					.addHomenoticetoto(jfptTabHomenoticetoreceive1);
		}

		listHomenoticeInfo = assistHomeworkManageManager
				.findHomeNoticeInfoByAid(id);
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		return "addHome";
	}

	// ***********************������ҵ����*****************************************
	/**
	 * <p>���ܣ��鿴ѧ���ύ����ҵ<br>
	 * @return action findHomeUploadInfo
	 */
	public String findHomeUploadInfo() {
		String id = (String) session.get("FUserNumber");
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		return "findHomeUploadInfo";
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص���ҵ��Ϣ�����Խ�����з�ҳ����<br>
	 * @return findSelectHomeworkInfo
	 */
	public String findSelectHomeworkInfo() {
		String id = (String) session.get("FUserNumber");
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		listHomeuploadInfo = assistHomeworkManageManager.findHomeworkInfoByTwo(
				id, FCourseNumber);

		int pages = 5;
		int listlength = listHomeuploadInfo.size();
		if (listlength == 0)
			return "findSelectHomeworkInfo";
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

		return "findSelectHomeworkInfo";
	}

	/**
	 * <p>���ܣ�������ҵid�Ų�����ҵ��ϸ��Ϣ<br>
	 * @return action findHomeworkDetailByID
	 */
	public String findHomeworkDetailByID() {
		jfptTabHomeupload = assistHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		jfptTabHomeupload.setFRead("Y");
		assistHomeworkManageManager.updateHomeworkInfo(jfptTabHomeupload);
		return "findHomeworkDetailByID";
	}

	/**
	 * <p>���ܣ�������ҵ������ҵ���лظ�����<br>
	 * @return action updateHomeworkInfoByID
	 */
	public String updateHomeworkInfoByID() {
		String id = (String) session.get("FUserNumber");
		jfptTabHomeupload = assistHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		if(FReply.length()>0){
			FReply = FReply + "--" + id;
			jfptTabHomeupload.setFReply(FReply);
			FReply = "";
		}
		assistHomeworkManageManager.updateHomeworkInfo(jfptTabHomeupload);
		
		listCourseInfo = assistHomeworkManageManager.findCourseInfoByAid(id);
		listHomeuploadInfo = assistHomeworkManageManager.findHomeworkInfoByTwo(id, FCourseNumber);
		return "updateHomeworkInfoByID";
	}

	/**
	 * <p>���ܣ������ļ����صķ���<br>
	 * @return action downFile
	 */
	public String downFile1() { // ����
		JfptTabHomeupload info = assistHomeworkManageManager
				.findHomeworkDetailByID(FHomeId);
		this.setContentType("application/" + this.getExt(info.getFFilePath()));
		String name = info.getFFilePath().substring(
				info.getFFilePath().lastIndexOf("/") + 1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\HomeUpload\\" + name);
		this.setFileName(info.getFFilePath());
		return "downFileSuccess1";
	}

	 /**
	  * <p>���ܣ������ļ����������<br>
	  * @return InputStream
	  * @throws Exception
	  */
	public InputStream getDownFile1() throws Exception { // �ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(
				this.getFilePath());
	}

	/**
	 * <p>���ܣ�����ļ���׺����<br>
	 * @return action webChartBefore
	 */
	public String webChartBefore() {
		String id = (String) session.get("FUserNumber");
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfoByTwo(
				id, FCourseNumber);

		listClassNumberInfo = assistHomeworkManageManager.findClassNumberInfo(
				id, FCourseNumber);
		listDirectionInfo = assistHomeworkManageManager.findDirectionInfo(
				listStudentsInfo, FCourseNumber);
		return "webChartBefore";
	}

	/**
	 * <p>���ܣ�����ѡ��ķ��򡢰༶����Ϣ�������Ӧ��ѧ���ɼ���Ϣ<br>
	 * @return action webChart
	 */
	public String webChart() {
		String id = (String) session.get("FUserNumber");
		tabCourse = assistHomeworkManageManager
				.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfoByTwo(
				id, FCourseNumber);
		// ���ҵ���ص�ѧ��
		listStudentsInfo = assistHomeworkManageManager.findStudentsInfo(
				ClassNumber, DirectionNumber, listStudentsInfo);
		// ���ҳ����ſγ�ѧ���ĳɼ�
		listUsualscoreInfo = assistHomeworkManageManager
				.findUsualscoreInfoByTwo(FCourseNumber, id);
		listUsualscoreInfo = assistHomeworkManageManager.findUsualscoreInfo(
				ClassNumber, DirectionNumber, listStudentsInfo,
				listUsualscoreInfo);
		// session.put("listUsualscoreInfo", listUsualscoreInfo);
		return "webChart";
	}

	/**
	 * <p>���ܣ������ҵ���ѧ���ɼ���Ϣ����ͳ�ƣ�����ͼ�н�����ʾ<br>
	 * @return action webChart1
	 */
	public String webChart1() {

		String title = "ѧ��ƽʱ�ɼ��ֲ�ͼ";
		String domain = "ѧ��ѧ��";
		String range = "ƽʱ�ɼ�����";
//		String title = "Students Usual Score BarChart";
//		String domain = "The Students SchoolNumber(ID)";
//		String range = "The Average Score Of Students Usual Score";

		// listUsualscoreInfo
		// data.addValue(ƽʱ�ɼ�����, null, ѧ��);
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		int m = listUsualscoreInfo.size();
		for (int i = 0; i < m; i++) {
			int score = 0;
			String number = "";
			score = listUsualscoreInfo.get(i).getFScore();
			number = listUsualscoreInfo.get(i).getTabStudents().getFStudentNumber();
			data.addValue(score, "", number);
		}
		
		chart = ChartFactory.createBarChart3D(title, domain, range, data,PlotOrientation.VERTICAL, true, false, false);
		
		CategoryPlot plot  =  chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		
		BarRenderer3D renderer  =   new  BarRenderer3D();
        renderer.setBaseOutlinePaint(Color.BLACK);

        // ��ʾÿ��������ֵ�����޸ĸ���ֵ����������
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);
		plot.setForegroundAlpha(0.8f);
		
		//��������������ɫ 
		plot.setDomainGridlinePaint(Color.blue); 
		plot.setDomainGridlinesVisible(true); 
		//�������������ɫ 
		plot.setRangeGridlinePaint(Color.blue); 
		plot.setRangeGridlinesVisible(true); 

		CategoryLabelPositions position = CategoryLabelPositions.UP_90;
		domainAxis.setCategoryLabelPositions(position);
		plot.setDomainAxis(domainAxis);
		
		//----------------------------------------------------------------------------------
		 //��X�������� 
		//��Y�������� 
		ValueAxis rAxis = plot.getRangeAxis(); 
		  
		/*----------������������ľ����Ⱦ������������⣩--------------*/ 
		 chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF); 
		      
		//���ñ������� 
		TextTitle textTitle = chart.getTitle(); 
		textTitle.setFont(new Font("����", Font.PLAIN, 20)); 
		//����X�������ϵ����� 
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
		//����X��ı������� 
		domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12)); 
		//����Y�������ϵ����� 
		rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12)); 
		//����Y��ı������� 
		rAxis.setLabelFont(new Font("����", Font.PLAIN, 12));      
		//�ײ��������������  
		chart.getLegend().setItemFont(new Font("����",Font.PLAIN,12)); 

		
		return SUCCESS;
	}
}