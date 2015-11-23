package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.MhqxTabUserService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.service.yjssx_system.TutorInfoService;
import com.xdsc.util.CommonConstVariable;

/**
 * �๦��:����Ա���о��������ύ�Լ���ʦ���ķ����Ĺ���
 * @author ����
 * @version 1.1
 */
public class AdminThesisManageAction extends ActionSupport {

	public PostgraduateInfoService postgraduateInfoService;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	private TutorInfoService tutorInfoService;
	
	private SystomNoticeService systomNoticeService;
	
	private MhqxTabUserService mhqxTabUserService;
	
	private int ThesisType;

	/**
	 * ���ҳ��������е�ʦ����Ϣ��������select��ѡ������ʾ
	 */
	private List<TabTeachers> teacherList;
	
	/**
	 * ���ҳ������о�������Ϣ
	 */
	private List<TabPostgraduate>  studentList;
	
	/**
	 * �����о�����Id�����о����ύ����������
	 */
	private String stuId;
	
	/**
	 * �о�������������
	 */
	private YjssxTabSubmitthesis detailThesis;
	
	/**
	 * �����о�����������ѯ
	 */
	private String stuName;
	
	/**
	 * ���о��������ύ��������ѯ��submit=all/Y/N�ֱ��ʾȫ�������ύ����δ�ύ������
	 */
	private String submit;
	
	private List<YjssxTabReturnthesis> returnList;
	
	/**
	 * �����ķ��������ѯ��returned=all/Y/N�ֱ��ʾȫ������������ѷ�����δ����
	 */
	private String returned;
	
	/**
	 * �鿴���������ĵ�����
	 */
	private int RetId;
	
	private YjssxTabReturnthesis detailInfo;
	
	private int p = 1;

	private int lastPage;
	
//--------------------------------------������ѯ����----------------------------------------------------------
	
	private String studentName;
	
	private String tutorName;
	
	private String className;
	
	private String gradeName;
	
	private String studentType;
	
//--------------------------------------�����ύ�����ѯ����----------------------------------------------------------
	private String IsSubmit;
	
	private List<YjssxTabSubmitthesis> submitThesisList;//���ύ������
	
	private List<TabPostgraduate> StudentNotSubmitList;

//--------------------------------------���ķ��������ѯ����----------------------------------------------------------
	
	private String isReturned;
	
	private List<YjssxTabReturnthesis> returnThesisList;
	
//--------------------------------------���ķ���״̬��ѯ����----------------------------------------------------------
	
	private String ThesisStatus;
	
	private int DetailId;			//�������ĵ�״̬
	
	private YjssxTabReturnthesis detailReturnThesis;
	
	private String TutorId;
	
	private int RetThesisId;
	
	private String Status;
	
	private String ReasonTitle;
	
	private String ReasonContent;
//--------------------------------����-------------------------------------------------------------------------------
	
	public String ThesisPreManage(){
		teacherList = tutorInfoService.findAllTutors();
		return "ThesisPreManage";
	}
	
	/**
	 * �о��������ύ�����ѯ
	 * @return
	 */
	public String ThesisSubmitInformationSearch(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		teacherList = tutorInfoService.findAllTutors();
		StudentNotSubmitList = new ArrayList<TabPostgraduate>();
		if(IsSubmit.equals("Y")){
			submitThesisList= postgraduateThesisService.findAllThesisSubmitInformationByConditionAndType(studentName, tutorName, className, gradeName, studentType,ThesisTypeName);
			return "ThesisHaveSumbit";
		}else{
			//����������ѯ�����������о���
			List<TabPostgraduate> stuList = postgraduateInfoService.findPostgraduateByCondition(studentName, "", tutorName, "", className, gradeName, studentType, "", "", "");
			for(int i=0;i<stuList.size();i++){
				if(stuList.get(i).getFOpenThesisIsSubmit().equals("��")){
					StudentNotSubmitList.add(stuList.get(i));
				}			
			}
			return "ThesisNotSubmit";
		}
	}
	
	/**
	 * ��ѯ���ķ������
	 * @return
	 */
	public String ThesisReturnInformationSearch(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		teacherList = tutorInfoService.findAllTutors();
		returnThesisList = postgraduateThesisService.findAllThesisReturnInformationByConditionAndType(studentName, tutorName, className, gradeName, studentType, isReturned, "",ThesisTypeName);
		return "ThesisReturnInformationSearch";
	}
	
	/**
	 * �鿴����״̬,����ֻ�鿴�ѻظ������ĵ�״̬
	 * @return
	 */
	public String ReturnThesisStatusSearch(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		teacherList = tutorInfoService.findAllTutors();
		returnThesisList = postgraduateThesisService.findAllThesisReturnInformationByConditionAndType(studentName, tutorName, className, gradeName, studentType, "��",ThesisStatus,ThesisTypeName);
		return "ReturnThesisStatusSearch";
	}
	
	/**
	 * ��ʾ��������
	 * @return
	 */
	public String showDetailThesis(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		detailReturnThesis = postgraduateThesisService.findReturnThesisById(DetailId);
		return "showDetailThesis";
	}
	
	/**
	 * �����ύ���ĵ�״̬
	 * @return ����Ϊ��ͨ����˺�δͨ�����
	 */
	public String SetSubmitStatus(){
		//�����������ĵ��ύ״̬
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}

		YjssxTabReturnthesis thesis=postgraduateThesisService.findReturnThesisById(RetThesisId);
		if(Status.equals("Y")){
			thesis.setFStatus(CommonConstVariable.CHECK_HAVE_PASS);
			thesis.setFReason(ReasonContent);                      //��������״̬ԭ��
		}else{
			thesis.setFStatus(CommonConstVariable.CHECK_NOT_PASS);
			thesis.setFReason(ReasonContent);					  //��������״̬ԭ��
		}
		postgraduateThesisService.updateReturnThesis(thesis);
		
		TabNotice reason = new TabNotice();                     //�������������ԭ��
		reason.setFModuleId(CommonConstVariable.MODULE_ID);
		reason.setFInfoTitle(ReasonTitle);
		reason.setFInfoContet(ReasonContent);
		Date date = new Date();
		reason.setFInfoStartTime(date);
		reason.setFInfoType(CommonConstVariable.NOTICE_TYPE_ADMINTOTUTOR);
		systomNoticeService.addNotice(reason);
		
		TabNoticetosb noticeTo=new TabNoticetosb();//���ԭ��
		MhqxTabUser Student=new MhqxTabUser();
		Student=mhqxTabUserService.findMhqxTabUserById(TutorId);
		TabNotice notice=systomNoticeService.findLastSaveNotice(reason);
		noticeTo.setMhqxTabUser(Student);
		noticeTo.setTabNotice(notice);
		noticeTo.setFAlreadyRead("0");
		systomNoticeService.addNoticeTo(noticeTo);
		return "SetSubmitStatus";
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public YjssxTabSubmitthesis getDetailThesis() {
		return detailThesis;
	}

	public void setDetailThesis(YjssxTabSubmitthesis detailThesis) {
		this.detailThesis = detailThesis;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public PostgraduateThesisService getPostgraduateThesisService() {
		return postgraduateThesisService;
	}

	public void setPostgraduateThesisService(
			PostgraduateThesisService postgraduateThesisService) {
		this.postgraduateThesisService = postgraduateThesisService;
	}

	
	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public List<YjssxTabReturnthesis> getReturnList() {
		return returnList;
	}

	public void setReturnList(List<YjssxTabReturnthesis> returnList) {
		this.returnList = returnList;
	}

	public String getReturned() {
		return returned;
	}

	public void setReturned(String returned) {
		this.returned = returned;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public int getRetId() {
		return RetId;
	}

	public void setRetId(int retId) {
		RetId = retId;
	}

	public YjssxTabReturnthesis getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(YjssxTabReturnthesis detailInfo) {
		this.detailInfo = detailInfo;
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

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public List<TabTeachers> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<TabTeachers> teacherList) {
		this.teacherList = teacherList;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	public String getIsSubmit() {
		return IsSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		IsSubmit = isSubmit;
	}

	public String getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(String isReturned) {
		this.isReturned = isReturned;
	}

	public String getThesisStatus() {
		return ThesisStatus;
	}

	public void setThesisStatus(String thesisStatus) {
		ThesisStatus = thesisStatus;
	}


	public List<YjssxTabSubmitthesis> getSubmitThesisList() {
		return submitThesisList;
	}


	public void setSubmitThesisList(List<YjssxTabSubmitthesis> submitThesisList) {
		this.submitThesisList = submitThesisList;
	}


	public List<TabPostgraduate> getStudentNotSubmitList() {
		return StudentNotSubmitList;
	}


	public void setStudentNotSubmitList(List<TabPostgraduate> studentNotSubmitList) {
		StudentNotSubmitList = studentNotSubmitList;
	}

	public List<YjssxTabReturnthesis> getReturnThesisList() {
		return returnThesisList;
	}

	public void setReturnThesisList(List<YjssxTabReturnthesis> returnThesisList) {
		this.returnThesisList = returnThesisList;
	}

	public int getDetailId() {
		return DetailId;
	}

	public void setDetailId(int detailId) {
		DetailId = detailId;
	}

	public YjssxTabReturnthesis getDetailReturnThesis() {
		return detailReturnThesis;
	}

	public void setDetailReturnThesis(YjssxTabReturnthesis detailReturnThesis) {
		this.detailReturnThesis = detailReturnThesis;
	}

	public int getRetThesisId() {
		return RetThesisId;
	}

	public void setRetThesisId(int retThesisId) {
		RetThesisId = retThesisId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getReasonTitle() {
		return ReasonTitle;
	}

	public void setReasonTitle(String reasonTitle) {
		ReasonTitle = reasonTitle;
	}

	public String getReasonContent() {
		return ReasonContent;
	}

	public void setReasonContent(String reasonContent) {
		ReasonContent = reasonContent;
	}

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public MhqxTabUserService getMhqxTabUserService() {
		return mhqxTabUserService;
	}

	public void setMhqxTabUserService(MhqxTabUserService mhqxTabUserService) {
		this.mhqxTabUserService = mhqxTabUserService;
	}

	public String getTutorId() {
		return TutorId;
	}

	public void setTutorId(String tutorId) {
		TutorId = tutorId;
	}

	public int getThesisType() {
		return ThesisType;
	}

	public void setThesisType(int thesisType) {
		ThesisType = thesisType;
	}


}
