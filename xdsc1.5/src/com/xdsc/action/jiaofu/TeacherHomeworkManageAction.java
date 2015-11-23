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
import com.xdsc.service.jiaofu.TeacherHomeworkManageManager;
/**
 * <p>功能：作业管理模块，主要进行布置作业、批改作业和平时考核操作。<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherHomeworkManageAction extends ActionSupport implements SessionAware{

	/**service层对象，便于调用service层的方法*/
	private TeacherHomeworkManageManager teacherHomeworkManageManager;
	/**课程信息*/
	private List<TabCourse> listCourseInfo;
	/**平时成绩*/
	private List<JfptTabUsualscore> listUsualscoreInfo;
	/**课程编号*/
	private String FCourseNumber;
	/**平时成绩对象id号*/
	private int FNumber;
	/**平时成绩对象*/
	private JfptTabUsualscore jfptTabUsualscore;
	/**课程对象*/
	private TabCourse tabCourse;
	/**学期*/
	private String FXueQi; 
	/**类型信息*/
	private List<String> listFTypeInfo = new ArrayList<String>();
	/**学生学号*/
	private String FStudentNumber;
	/**类型*/
	private String FType;
	/**得分*/
	private int FScore;
	//*************************布置作业
	/**作业通知*/
	private List<JfptTabHomenotice> listHomenoticeInfo;
	/**作业通知id号*/
	private int FHomeNoticeId;
	/**作业通知对象*/
	private JfptTabHomenotice jfptTabHomenotice;
	/**设置页面类型*/
	private String contentType;                  //下载
	/**文件路径*/
	private String filePath;
	/**文件名称*/
	private String fileName;
	/**下载id号*/
	private int downId;
	/**学生对象信息*/
	private List<TabStudents> listStudentsInfo;
	/**学生学号信息*/
	private List<String> listStudentNumber = new ArrayList<String>();
	/**上传文件*/
	private File uploadFile;
	/**类型*/
	private String uploadFileContentType;
	/**文件名称*/
	private String uploadFileFileName;
	/**保存路径*/
	private String savePath;
	/**标题*/
	private String FTitle;
	/**内容*/
	private String FContent;
	/**时间*/
	private Date FDate;
	/**地址*/
	private String FUrl;
    //*****************************批改作业 
	/**上传作业对象*/
	private List<JfptTabHomeupload> listHomeuploadInfo;
	/**上传作业*/
	private JfptTabHomeupload jfptTabHomeupload;
	/**作业id号*/
	private int FHomeId;
	/**回复*/
	private String FReply;
	/**教师职工号*/
	private String FTeacherNumber;
	/**Map类型对象*/
	private Map<String,Object> session;
	//发送对象分类
	/**班级信息*/
    private List<String> listClassNumberInfo = new ArrayList<String>();
    /**方向信息*/
    private List<TabDirection> listDirectionInfo = new ArrayList<TabDirection>();
    /**班级号*/
    private String ClassNumber;
    /**方向编号*/
    private int DirectionNumber;
    /**页面处理中记录当前页面号*/
    private int p = 1;
    /**页面处理中对查询结果进行分布处理记录总页面数*/
	private int lastPage;
	
	// 图表相关数据
	/**图表相关数据*/
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

	public int getDirectionNumber() {
		return DirectionNumber;
	}

	public void setDirectionNumber(int directionNumber) {
		DirectionNumber = directionNumber;
	}

	public String getFReply() {
		return FReply;
	}

	public void setFReply(String reply) {
		FReply = reply;
	}

	public int getFHomeId() {
		return FHomeId;
	}

	public void setFHomeId(int homeId) {
		FHomeId = homeId;
	}

	public JfptTabHomeupload getJfptTabHomeupload() {
		return jfptTabHomeupload;
	}

	public void setJfptTabHomeupload(JfptTabHomeupload jfptTabHomeupload) {
		this.jfptTabHomeupload = jfptTabHomeupload;
	}

	public List<JfptTabHomeupload> getListHomeuploadInfo() {
		return listHomeuploadInfo;
	}

	public void setListHomeuploadInfo(List<JfptTabHomeupload> listHomeuploadInfo) {
		this.listHomeuploadInfo = listHomeuploadInfo;
	}

	public String getFUrl() {
		return FUrl;
	}

	public void setFUrl(String url) {
		FUrl = url;
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

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
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

	public List<TabStudents> getListStudentsInfo() {
		return listStudentsInfo;
	}

	public void setListStudentsInfo(List<TabStudents> listStudentsInfo) {
		this.listStudentsInfo = listStudentsInfo;
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

	public List<JfptTabHomenotice> getListHomenoticeInfo() {
		return listHomenoticeInfo;
	}

	public void setListHomenoticeInfo(List<JfptTabHomenotice> listHomenoticeInfo) {
		this.listHomenoticeInfo = listHomenoticeInfo;
	}

	public int getFScore() {
		return FScore;
	}

	public void setFScore(int score) {
		FScore = score;
	}

	public String getFType() {
		return FType;
	}

	public void setFType(String type) {
		FType = type;
	}

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
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

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public JfptTabUsualscore getJfptTabUsualscore() {
		return jfptTabUsualscore;
	}

	public void setJfptTabUsualscore(JfptTabUsualscore jfptTabUsualscore) {
		this.jfptTabUsualscore = jfptTabUsualscore;
	}

	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
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

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public List<JfptTabUsualscore> getListUsualscoreInfo() {
		return listUsualscoreInfo;
	}

	public void setListUsualscoreInfo(List<JfptTabUsualscore> listUsualscoreInfo) {
		this.listUsualscoreInfo = listUsualscoreInfo;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public TeacherHomeworkManageManager getTeacherHomeworkManageManager() {
		return teacherHomeworkManageManager;
	}

	public void setTeacherHomeworkManageManager(
			TeacherHomeworkManageManager teacherHomeworkManageManager) {
		this.teacherHomeworkManageManager = teacherHomeworkManageManager;
	}
	
	/**
	 * <p>功能：根据个人编号查找相关的课程信息<br>
	 * @return action findBeforeScoreInfo
	 */
	public String findBeforeScoreInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		return "findBeforeScoreInfo";
	}
	
	/**
	 * <p>功能：根据课程名称和个人编号进行成绩信息的查询，并对结果信息进行分页处理<br>
	 * @return action findUsualSelectInfo
	 */
	public String findUsualSelectInfo(){  //FCourseNumber  Tid
		FTeacherNumber = (String)session.get("FUserNumber");
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfoByTwo(FCourseNumber, FTeacherNumber);
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		
		int pages = 5;
		int listlength = listUsualscoreInfo.size();
		if(listlength==0)
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
	 * <p>功能：根据成绩id号查找成绩对象信息并进行删除<br>
	 * @return action deleteUsualscoreInfoByID
	 */
	public String deleteUsualscoreInfoByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabUsualscore = teacherHomeworkManageManager.findUsualscoreInfoByID(FNumber);
		teacherHomeworkManageManager.deleteUsualscoreInfo(jfptTabUsualscore);
		
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfoByTwo(FCourseNumber, FTeacherNumber);
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		return "deleteUsualscoreInfoByID";
	}
	
	/**
	 * <p>功能：更新成绩信息，对相关成绩信息进行统计和整理，最终将各种成绩信息变成一种：平时成绩汇总<br>
	 * @return action updateStudentsScore
	 */
	public String updateStudentsScore(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfoByTwo(FCourseNumber, FTeacherNumber);
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		teacherHomeworkManageManager.updateStudentsScore(listUsualscoreInfo,listStudentsInfo,tabCourse);
		
		//这时返回的平时成绩就为汇总过的成绩，分别是：平时考核汇总，平时作业汇总，上机作业汇总
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfoByTwo(FCourseNumber, FTeacherNumber);
		return "updateStudentsScore";
	}
	
	/**
	 * <p>功能：为添加平时成绩信息做准备，查询相关的课程信息、学期信息和类型信息<br>
	 * @return action addUsualscoreInfo
	 */
	public String addUsualscoreInfo(){
		listFTypeInfo.clear();
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		Date date = new Date();
		int year = (date.getYear()+1900)%100;
		int month = date.getMonth()+1;
		
		if(month>2 && month<8){
			FXueQi = year+"年上";  // 3 4 5 6 7 
		}else{
			FXueQi = year+"年下";  //8 9 10 11 12 1 2 
		}
		listFTypeInfo.add("平时考勤");
		listFTypeInfo.add("平时作业");
		listFTypeInfo.add("上机作业");
		return "addUsualscoreInfo";
	}
	
	/**
	 * <p>功能：添加平时成绩信息<br>
	 * @return action addNewUsualScoreInfo
	 */
	public String addNewUsualScoreInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		JfptTabUsualscore jfptTabUsualscore1 = new JfptTabUsualscore();
		jfptTabUsualscore1.setFScore(FScore);
		jfptTabUsualscore1.setFType(FType);
		jfptTabUsualscore1.setFXueQi(FXueQi);
		jfptTabUsualscore1.setTabCourse(tabCourse);
		TabStudents tabStudents = new TabStudents();
		tabStudents = teacherHomeworkManageManager.findStudentsInfoByID(FStudentNumber);
		jfptTabUsualscore1.setTabStudents(tabStudents);
		teacherHomeworkManageManager.addUsualScoreInfo(jfptTabUsualscore1);
		
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfoByTwo(tabCourse.getFCourseNumber(), FTeacherNumber);
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		return "addNewUsualScoreInfo";
	}
	
	
	//******************************************布置作业****************************************
	/**
	 * <p>功能：查找相关作业通知信息，并对结果进行分页处理<br>
	 * @return action findHomeNoticeInfo
	 */
	public String findHomeNoticeInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listHomenoticeInfo = teacherHomeworkManageManager.findHomeNoticeInfoByTid(FTeacherNumber);
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		
		int pages = 5;
		int listlength = listHomenoticeInfo.size();
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
		listHomenoticeInfo = listHomenoticeInfo.subList(startIndex, endIndex);
		
		return "findHomeNoticeInfo";
	}
	
	/**
	 * <p>功能：根据作业通知id号查找详细信息<br>
	 * @return action findHomeDetailByID
	 */
	public String findHomeDetailByID(){
		jfptTabHomenotice = teacherHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		return "findHomeDetailByID";
	}
	
	/**
	 * <p>功能：根据作业通知id号查找相关对象信息并进行删除<br>
	 * @return action deleteHomeByID
	 */
	public String deleteHomeByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabHomenotice = teacherHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		teacherHomeworkManageManager.deleteHome(jfptTabHomenotice);
		
		listHomenoticeInfo = teacherHomeworkManageManager.findHomeNoticeInfoByTid(FTeacherNumber);
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		return "deleteHomeByID";
	}
	
	/**
	 * <p>功能：用于文件下载的方法<br>
	 * @return action downFile
	 */
	public String downFile(){      //下载
		JfptTabHomenotice info = teacherHomeworkManageManager.findHomeDetailByID(FHomeNoticeId);
		this.setContentType("application/"+this.getExt(info.getFUrl()));
		String name = info.getFUrl().substring(info.getFUrl().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\HomeNotice\\"+name);
		this.setFileName(name);
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
	
	/**
	 * <p>功能：为发布作业通知作信息准备，查找与个人编号相关的学生信息、班级信息、方向信息。<br>
	 * @return action AddNewHomenoticeBefore
	 */
	public String AddNewHomenoticeBefore(){
		FTeacherNumber = (String)session.get("FUserNumber");
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		
		listClassNumberInfo = teacherHomeworkManageManager.findClassNumberInfo(FTeacherNumber,FCourseNumber);
		listDirectionInfo = teacherHomeworkManageManager.findDirectionInfo(listStudentsInfo,FCourseNumber);
		return "AddNewHomenoticeBefore";
	}
	
	/**
	 * <p>功能：根据班级编号、方向编号进行一步查找学生对象信息<br>
	 * @return action AddNewHomenoticeBefore2
	 */
	public String AddNewHomenoticeBefore2(){
		FTeacherNumber = (String)session.get("FUserNumber");
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfo(ClassNumber,DirectionNumber,listStudentsInfo);
		return "AddNewHomenoticeBefore2";
	}
	
	/**
	 * <p>功能：发布作业通知<br>
	 * @return action addHome
	 */
	public String addHome(){
		FTeacherNumber = (String)session.get("FUserNumber");
		for(String i:listStudentNumber){
			System.out.println(i);
		}
		if(uploadFile != null){
			teacherHomeworkManageManager.savefile(uploadFile, savePath, uploadFileFileName);
			JfptTabHomenotice jfptTabHomenotice1 = new JfptTabHomenotice();
			jfptTabHomenotice1.setFContent(FContent);
			MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
			mhqxTabUser1 = teacherHomeworkManageManager.findUserByID(FTeacherNumber);
			jfptTabHomenotice1.setMhqxTabUser(mhqxTabUser1);
			jfptTabHomenotice1.setFDate(new Date());
			jfptTabHomenotice1.setFTitle(FTitle);
			FUrl = savePath +"/"+ uploadFileFileName;
			jfptTabHomenotice1.setFUrl(FUrl);
			tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
			jfptTabHomenotice1.setTabCourse(tabCourse);
			teacherHomeworkManageManager.addHomenotice(jfptTabHomenotice1);
			//添加相关对应信息到--->对应表
			for(String i: listStudentNumber){
				JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive1 = new JfptTabHomenoticetoreceive();
				jfptTabHomenoticetoreceive1.setFMarkable("N");
				jfptTabHomenoticetoreceive1.setJfptTabHomenotice(jfptTabHomenotice1);
				TabStudents tabStudents = new TabStudents();
				tabStudents = teacherHomeworkManageManager.findStudentsByID(i);
				jfptTabHomenoticetoreceive1.setTabStudents(tabStudents);
				teacherHomeworkManageManager.addHomenoticetoto(jfptTabHomenoticetoreceive1);
			}
			
			listHomenoticeInfo = teacherHomeworkManageManager.findHomeNoticeInfoByTid(FTeacherNumber);
			listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
			return "addHome";
		}
		JfptTabHomenotice jfptTabHomenotice1 = new JfptTabHomenotice();
		jfptTabHomenotice1.setFContent(FContent);
		MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
		mhqxTabUser1 = teacherHomeworkManageManager.findUserByID(FTeacherNumber);
		jfptTabHomenotice1.setMhqxTabUser(mhqxTabUser1);
		jfptTabHomenotice1.setFDate(new Date());
		jfptTabHomenotice1.setFTitle(FTitle);
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		jfptTabHomenotice1.setTabCourse(tabCourse);
		teacherHomeworkManageManager.addHomenotice(jfptTabHomenotice1);
		//添加相关对应信息到--->对应表
		for(String i: listStudentNumber){
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive1 = new JfptTabHomenoticetoreceive();
			jfptTabHomenoticetoreceive1.setFMarkable("N");
			jfptTabHomenoticetoreceive1.setJfptTabHomenotice(jfptTabHomenotice1);
			TabStudents tabStudents = new TabStudents();
			tabStudents = teacherHomeworkManageManager.findStudentsByID(i);
			jfptTabHomenoticetoreceive1.setTabStudents(tabStudents);
			teacherHomeworkManageManager.addHomenoticetoto(jfptTabHomenoticetoreceive1);
		}
		
		listHomenoticeInfo = teacherHomeworkManageManager.findHomeNoticeInfoByTid(FTeacherNumber);
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		return "addHome";
	}
	
	//***********************批改作业功能*****************************************
	/**
	 * <p>功能：查看学生提交的作业<br>
	 * @return action findHomeUploadInfo
	 */
	public String findHomeUploadInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		return "findHomeUploadInfo";
	}
	
	/**
	 * <p>功能：根据个人编号和课程编号查找相关的作业信息，并对结果进行分页处理<br>
	 * @return findSelectHomeworkInfo
	 */
	public String findSelectHomeworkInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		listHomeuploadInfo = teacherHomeworkManageManager.findHomeworkInfoByTwo(FTeacherNumber,FCourseNumber);
		
		int pages = 5;
		int listlength = listHomeuploadInfo.size();
		if(listlength==0)
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
	 * <p>功能：根据作业id号查找作业详细信息<br>
	 * @return action findHomeworkDetailByID
	 */
	public String findHomeworkDetailByID(){
		jfptTabHomeupload = teacherHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		jfptTabHomeupload.setFRead("Y");
		teacherHomeworkManageManager.updateHomeworkInfo(jfptTabHomeupload);
		return "findHomeworkDetailByID";
	}
	
	/**
	 * <p>功能：批改作业，对作业进行回复处理<br>
	 * @return action updateHomeworkInfoByID
	 */
	public String updateHomeworkInfoByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabHomeupload = teacherHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		FReply = FReply + "--"+FTeacherNumber;
		jfptTabHomeupload.setFReply(FReply);
		teacherHomeworkManageManager.updateHomeworkInfo(jfptTabHomeupload);
		
		listCourseInfo = teacherHomeworkManageManager.findCourseInfoByTid(FTeacherNumber);
		listHomeuploadInfo = teacherHomeworkManageManager.findHomeworkInfoByTwo(FTeacherNumber,FCourseNumber);
		return "updateHomeworkInfoByID";
	}
	
	/**
	 * <p>功能：用于文件下载的方法<br>
	 * @return action downFile
	 */
	public String downFile1(){      //下载
		JfptTabHomeupload info = teacherHomeworkManageManager.findHomeworkDetailByID(FHomeId);
		this.setContentType("application/"+this.getExt(info.getFFilePath()));
		String name = info.getFFilePath().substring(info.getFFilePath().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\HomeUpload\\"+name);
		this.setFileName(info.getFFilePath());
		return "downFileSuccess1";
	}
	
	/**
	 * <p>功能：创建文件下载输出流<br>
	 * @return InputStream
	 * @throws Exception
	 */
	public InputStream getDownFile1() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	/**
	 * <p>功能：获得文件后缀名称<br>
	 * @return action webChartBefore
	 */
	public String webChartBefore() {
		String id = (String) session.get("FUserNumber");
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfoByTwo(id, FCourseNumber);

		listClassNumberInfo = teacherHomeworkManageManager.findClassNumberInfo(id, FCourseNumber);
		listDirectionInfo = teacherHomeworkManageManager.findDirectionInfo(listStudentsInfo, FCourseNumber);
		return "webChartBefore";
	}

	/**
	 * <p>功能：根据选择的方向、班级等信息查找相对应的学生成绩信息<br>
	 * @return action webChart
	 */
	public String webChart() {
		String id = (String) session.get("FUserNumber");
		tabCourse = teacherHomeworkManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		// 查找到相关的学生
		listStudentsInfo = teacherHomeworkManageManager.findStudentsInfo(ClassNumber, DirectionNumber, listStudentsInfo);
		// 查找出这门课程学生的成绩
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfoByTwo(FCourseNumber, id);
		listUsualscoreInfo = teacherHomeworkManageManager.findUsualscoreInfo(ClassNumber, DirectionNumber, listStudentsInfo,listUsualscoreInfo);
		// session.put("listUsualscoreInfo", listUsualscoreInfo);
		return "webChart";
	}

	/**
	 * <p>功能：将查找到的学生成绩信息进行统计，并在图中进行显示<br>
	 * @return action webChart1
	 */
	public String webChart1() {

		String title = "学生平时成绩分布图";
		String domain = "学生学号";
		String range = "平时成绩汇总";
//		String title = "Students Usual Score BarChart";
//		String domain = "The Students SchoolNumber(ID)";
//		String range = "The Average Score Of Students Usual Score";

		// listUsualscoreInfo
		// data.addValue(平时成绩汇总, null, 学号);
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

        // 显示每个柱的数值，并修改该数值的字体属性
        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setItemLabelsVisible(true);
        plot.setRenderer(renderer);
		plot.setForegroundAlpha(0.8f);
		
		//设置网格竖线颜色 
		plot.setDomainGridlinePaint(Color.blue); 
		plot.setDomainGridlinesVisible(true); 
		//设置网格横线颜色 
		plot.setRangeGridlinePaint(Color.blue); 
		plot.setRangeGridlinesVisible(true); 

		CategoryLabelPositions position = CategoryLabelPositions.UP_90;
		domainAxis.setCategoryLabelPositions(position);
		plot.setDomainAxis(domainAxis);
		
		//----------------------------------------------------------------------------------
		 //对X轴做操作 
		//对Y轴做操作 
		ValueAxis rAxis = plot.getRangeAxis(); 
		  
		/*----------设置消除字体的锯齿渲染（解决中文问题）--------------*/ 
		 chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF); 
		      
		//设置标题字体 
		TextTitle textTitle = chart.getTitle(); 
		textTitle.setFont(new Font("黑体", Font.PLAIN, 20)); 
		//设置X轴坐标上的文字 
		domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11)); 
		//设置X轴的标题文字 
		domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12)); 
		//设置Y轴坐标上的文字 
		rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12)); 
		//设置Y轴的标题文字 
		rAxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));      
		//底部汉字乱码的问题  
		chart.getLegend().setItemFont(new Font("宋体",Font.PLAIN,12));
		
		return SUCCESS;
	}
}
