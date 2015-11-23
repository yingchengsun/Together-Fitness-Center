package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.MhqxTabUserService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.service.yjssx_system.SystemFunctionService;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.service.yjssx_system.TutorInfoService;
import com.xdsc.util.CommonConstVariable;
import com.xdsc.util.YjssxUtils;

/**
 * �๦�ܣ���ʦ��������
 * @author ����
 * @version 1.1
 */
public class TutorReceiveThesisAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystemFunctionService systemFunctionService;
	
	private TutorInfoService tutorInfoService;
	
	private SystomNoticeService systomNoticeService;
	
	private MhqxTabUserService mhqxTabUserService;
	
	private int ThesisType;
	/**
	 * ��������ʱ����״̬���ǻظ�����
	 */
	private String ret;
	
	/**
	 * ����ҳ���ж������Ƿ��Ѿ��ظ�
	 */
	private int isReturn;
	
	/**
	 * ����
	 */
	private List<YjssxTabSubmitthesis> thesisList;
	
	private int DetailId;	
	
	/**
	 * �����ύ�����ѯ��1��ʾ�Ѿ��ظ���0��ʾδ�ظ�
	 */
	private String IsSubmit;
	
	//-------------------------------���ݲ�ѯ������ѯ���ύ������----------------------------------------------
	
	private String studentGrade;
	
	private String studentName;
	
	private String ThesisStatus;
	
	//-------------------------------���ݲ�ѯ������ѯ���ύ������----------------------------------------------
	
	//-------------------------------��ʦ�鿴���ģ��������ĵ�״̬���ظ�����--------------------------------------
	
	private String ReasonTitle;
	
	private String ReasonContent;
	
	private String Status; //�����ύ�����ĵ�״̬
	
	private int SubmitThesisId;//Ҫ�ָ���ѧ���ύ���ĵ�ID
	
	private String stuId;//Ҫ�ظ���ѧ����ID
	
	private YjssxTabReturnthesis retThesis;
	
	/**
	 * �ظ��������Ѿ�ͨ������Ա���
	 */
	private boolean RetPassed;
	
	private File uploadFile;               
	
	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;
	
	//-------------------------------��ʦ�鿴���ģ��������ĵ�״̬���ظ�����--------------------------------------
	/**
	 * ���ĵ�����
	 */
	private YjssxTabSubmitthesis detailThesis;
	
	private List<TabPostgraduate> stuList;
	
	//-------------------------------��ʦ�鿴�������ĵ�״̬--------------------------------------
	
	private List<YjssxTabReturnthesis> returnedThesisList;
	
	private int returnThesisId;
	
	private String StatusReason;
	
	private int submitThsisId;
	
	//-------------------------------��ʦ�鿴���������ѯ--------------------------------------
	
	private String isReturned;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * ��ʦ�鿴�������ĵ�״̬
	 * @return
	 */
	public String TutorReturnThesisStatus(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<YjssxTabReturnthesis> AllThesis=postgraduateThesisService.findReturnThesisByTutorNumAndType(FUserNumber,ThesisTypeName);
		returnedThesisList = new ArrayList<YjssxTabReturnthesis>();
		for(int i=0;i<AllThesis.size();i++){
			if(AllThesis.get(i).getFThesisIsReturn().equals("��")){
				returnedThesisList.add(AllThesis.get(i));
			}
		}
		return "TutorReturnThesisStatus";
	}
	
	/**
	 * ���������������ĵķ������
	 * @return
	 */
	public String ReturnedThesisStatusSearchByCondition(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<YjssxTabReturnthesis> AllThesis = postgraduateThesisService.findReturnThesisByConditionAndType(studentGrade, studentName, ThesisStatus, FUserNumber,ThesisTypeName);
		returnedThesisList = new ArrayList<YjssxTabReturnthesis>();
		for(int i=0;i<AllThesis.size();i++){
			if(AllThesis.get(i).getFThesisIsReturn().equals("��")){
				returnedThesisList.add(AllThesis.get(i));
			}
		}
		return "TutorReturnThesisStatus";
	}
	
	/**
	 * �鿴����Ա���ԭ��
	 * @return
	 */
	public String ReturnThesisStatusReason(){
		StatusReason = postgraduateThesisService.findReturnThesisById(returnThesisId).getFReason();
		return "ReturnThesisStatusReason";
	}
	
	public String SubmitThesisStatusReason(){
		StatusReason = postgraduateThesisService.findSubmitThesisById(submitThsisId).getFReason();
		return "ReturnThesisStatusReason";
	}
	
	/**
	 * �鿴�ѷ�����δ����������
	 * @return
	 */
	public String ReturnInfomationSearch(){
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<YjssxTabReturnthesis> retList=postgraduateThesisService.findReturnThesisByConditionAndType(studentGrade,"","", FUserNumber,ThesisTypeName);
		thesisList =new ArrayList<YjssxTabSubmitthesis>();
		YjssxTabSubmitthesis TempReturn = new YjssxTabSubmitthesis();
		if(isReturned.equals("Y")){                     //�����Ѿ�����������
			for(int i=0;i<retList.size();i++){
				if(retList.get(i).getFThesisIsReturn().equals("��")){
					TempReturn = postgraduateThesisService.findSubmitThesisByTutorNumAndStudentNumAndType(retList.get(i).getTabPostgraduate().getFStudentNumber(),
							retList.get(i).getTabTeachers().getFTeacherNumber(),ThesisTypeName).iterator().next();
					thesisList.add(TempReturn);
				}
			}
		}else{			//����δ����������
			for(int i=0;i<retList.size();i++){
				if(retList.get(i).getFThesisIsReturn().equals("��")){
					TempReturn = postgraduateThesisService.findSubmitThesisByTutorNumAndStudentNumAndType(retList.get(i).getTabPostgraduate().getFStudentNumber(),
							retList.get(i).getTabTeachers().getFTeacherNumber(),ThesisTypeName).iterator().next();
					thesisList.add(TempReturn);
				}
			}
		}
		return "submitThesis";
	}
	
	/**
	 * ���ύ������
	 * @return �����Ѿ��ύ������
	 */
	public String submitThesis(){                  //�鿴���ύ����
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		thesisList = postgraduateThesisService.findSubmitThesisByTutorNumAndType(FUserNumber,ThesisTypeName);
		if(thesisList.size()>10){
			int pages = 10;
			int listlength = this.thesisList.size();
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
			this.thesisList = this.thesisList.subList(startIndex, endIndex);
		}
		
		return "submitThesis";
	}
	
	public String submitInfomationSearch(){   //���������ύ�����ѯ*******
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		if(IsSubmit.equals("Y")){
			thesisList = postgraduateThesisService.findSubmitInfoByTutorAndGradeAndType(studentGrade, FUserNumber,ThesisTypeName);
			return "submitThesis";
			
		}else{			
			List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
			if(function.size()<=0){
				return "NotRightTimeToReceiveThesis";
			}
			stuList = new ArrayList<TabPostgraduate>();
			List<TabPostgraduate> AllList=new ArrayList<TabPostgraduate>();
			AllList=postgraduateInfoService.findPostgraduateByTutorNumber(FUserNumber);
			for(int i=0;i<AllList.size();i++){ //�����꼶����δ�ύ���о���
				if(AllList.get(i).getTabStudents().getTabClasses().getTabGrade().getFGradeNum().equals(studentGrade)&&AllList.get(i).getFThesisIsSubmit().equals("��")){
					stuList.add(AllList.get(i));				
				}
			}
			return "ThesisNotSubmit";
		}	
	}
	
	/**
	 * ���������鿴���ύ������
	 * @return ���ύ������
	 */
	public String SubmitThesisSearchByCondition(){    //����������ѯ���ύ������
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		thesisList = postgraduateThesisService.findSubmitThesisByConditionAndType(studentGrade, studentName, ThesisStatus,FUserNumber,ThesisTypeName);
		return "SubmitThesisSearchByCondition";
	}
	
	/**
	 * ��ʾ���ĵ�����
	 * @return ������������
	 */
	public String showDetailThesis(){             //��������
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		detailThesis=postgraduateThesisService.findSubmitThesisById(DetailId);
		retThesis = postgraduateThesisService.findReturnThesisByStudentNumAndType(stuId,ThesisTypeName).iterator().next();
		System.out.println("--------------"+retThesis.getFThesisIsReturn());
		if(retThesis.getFThesisIsReturn().equals("��")){
			isReturn =1;//�Ѿ��ظ�
		}else{
			isReturn=0;//��δ�ظ�
		}
		if(retThesis.getFStatus().equals(CommonConstVariable.CHECK_HAVE_PASS)){//�жϷ����������Ƿ��Ѿ�ͨ������Ա���
			RetPassed=true;
		}else{                          
			RetPassed=false;
		}
		if(ret.equals("Y")){
			return "showDetailThesisForReturn";
		}else{
			return "showDetailThesisForSetStatus";
		}
		
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
		YjssxTabSubmitthesis thesis=postgraduateThesisService.findSubmitThesisById(SubmitThesisId);
		if(Status.equals("Y")){
			thesis.setFStatus(CommonConstVariable.CHECK_HAVE_PASS);
			thesis.setFReason(ReasonContent);                      //��������״̬ԭ��
		}else{
			thesis.setFStatus(CommonConstVariable.CHECK_NOT_PASS);
			thesis.setFReason(ReasonContent);					  //��������״̬ԭ��
		}
		postgraduateThesisService.updateSubmitThesis(thesis);
		
		TabNotice reason = new TabNotice();                     //�������������ԭ��
		reason.setFModuleId(CommonConstVariable.MODULE_ID);
		reason.setFInfoTitle(ReasonTitle);
		reason.setFInfoContet(ReasonContent);
		Date date = new Date();
		reason.setFInfoStartTime(date);
		reason.setFInfoType(CommonConstVariable.NOTICE_TYPE_TUTORTOSTUDENT);
		systomNoticeService.addNotice(reason);
		
		TabNoticetosb noticeTo=new TabNoticetosb();//���ԭ��
		MhqxTabUser Student=new MhqxTabUser();
		Student=mhqxTabUserService.findMhqxTabUserById(stuId);
		TabNotice notice=systomNoticeService.findLastSaveNotice(reason);
		noticeTo.setMhqxTabUser(Student);
		noticeTo.setTabNotice(notice);
		noticeTo.setFAlreadyRead("0");
		systomNoticeService.addNoticeTo(noticeTo);
		return "SetSubmitStatus";
	}
	
	
	/**
	 * ��ʦ�ظ�����
	 * @return 
	 */
	public String ReturnThesis(){                   //��ʦ���Ļظ�
		//�鿴�����Ƿ��Ѿ��ظ���
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		TabPostgraduate student=postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		TabTeachers teacher = tutorInfoService.findTutorById(FUserNumber);
		Date date=new Date();
		List<YjssxTabReturnthesis> retList=postgraduateThesisService.findReturnThesisByStudentNumAndType(stuId,ThesisTypeName);
		if(retList.size()==1){
			if(uploadFile!=null){           //�������Ѿ�����ֻ���޸�
				YjssxUtils.deleteFile(savePath, retList.iterator().next().getFThesisStorePath());
				String saveName=System.currentTimeMillis()+uploadFileFileName;
				YjssxUtils.saveFile(uploadFile, savePath, saveName);
				YjssxTabReturnthesis ret=retList.iterator().next();
				ret.setTabPostgraduate(student);
				ret.setTabTeachers(teacher);
				ret.setFComment(retThesis.getFComment());
				ret.setFDate(date);
				ret.setFThesisName(retThesis.getFThesisName());
				ret.setFThesisStorePath(saveName);
				ret.setFThesisIsReturn("��");
				postgraduateThesisService.updateReturnThesis(ret);
			}else{
				YjssxTabReturnthesis ret=retList.iterator().next();
				ret.setFComment(retThesis.getFComment());
				ret.setFDate(date);
				ret.setFThesisName(retThesis.getFThesisName());
				ret.setFThesisIsReturn("��");
				postgraduateThesisService.updateReturnThesis(ret);
			}		
		}else{  //�������û�з���������������
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			YjssxUtils.saveFile(uploadFile, savePath, saveName);
			retThesis.setFThesisStorePath(saveName);
			retThesis.setFThesisType(ThesisTypeName);
			retThesis.setFDate(date);
			retThesis.setTabPostgraduate(student);
			retThesis.setTabTeachers(teacher);
			retThesis.setFStatus("δ���");
			retThesis.setFThesisIsReturn("��");
			postgraduateThesisService.addReturnThesis(retThesis);
		}	
		return "ReturnThesis";
	}
	
	/**
	 * ����δ�ύ���о���delete delete delete delete delete delete delete delete 
	 * @return ����δ�ύ���ĵ��о���
	 */
	public String thesisNotSubmit(){              //δ�ύ���ĵ��о���
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		stuList = new ArrayList<TabPostgraduate>();
		List<TabPostgraduate> AllList=new ArrayList<TabPostgraduate>();
		AllList=postgraduateInfoService.findPostgraduateByTutorNumber(FUserNumber);
		for(int i=0;i<AllList.size();i++){
			if(AllList.get(i).getFThesisIsSubmit().equals("��")){
				stuList.add(AllList.get(i));				
			}
		}
		if(stuList.size()>10){
			int pages = 10;
			int listlength = this.stuList.size();
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
			this.stuList = this.stuList.subList(startIndex, endIndex);	
		}
		
		return "thesisNotSubmit";
	}

	public PostgraduateThesisService getPostgraduateThesisService() {
		return postgraduateThesisService;
	}

	public void setPostgraduateThesisService(
			PostgraduateThesisService postgraduateThesisService) {
		this.postgraduateThesisService = postgraduateThesisService;
	}

	public List<YjssxTabSubmitthesis> getThesisList() {
		return thesisList;
	}

	public void setThesisList(List<YjssxTabSubmitthesis> thesisList) {
		this.thesisList = thesisList;
	}

	public int getDetailId() {
		return DetailId;
	}

	public void setDetailId(int detailId) {
		DetailId = detailId;
	}

	public YjssxTabSubmitthesis getDetailThesis() {
		return detailThesis;
	}

	public void setDetailThesis(YjssxTabSubmitthesis detailThesis) {
		this.detailThesis = detailThesis;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<TabPostgraduate> getStuList() {
		return stuList;
	}

	public void setStuList(List<TabPostgraduate> stuList) {
		this.stuList = stuList;
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

	public SystemFunctionService getSystemFunctionService() {
		return systemFunctionService;
	}

	public void setSystemFunctionService(SystemFunctionService systemFunctionService) {
		this.systemFunctionService = systemFunctionService;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public String getIsSubmit() {
		return IsSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		IsSubmit = isSubmit;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getThesisStatus() {
		return ThesisStatus;
	}

	public void setThesisStatus(String thesisStatus) {
		ThesisStatus = thesisStatus;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getSubmitThesisId() {
		return SubmitThesisId;
	}

	public void setSubmitThesisId(int submitThesisId) {
		SubmitThesisId = submitThesisId;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public YjssxTabReturnthesis getRetThesis() {
		return retThesis;
	}

	public void setRetThesis(YjssxTabReturnthesis retThesis) {
		this.retThesis = retThesis;
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

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
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

	public int getIsReturn() {
		return isReturn;
	}

	public void setIsReturn(int isReturn) {
		this.isReturn = isReturn;
	}


	public List<YjssxTabReturnthesis> getReturnedThesisList() {
		return returnedThesisList;
	}


	public void setReturnedThesisList(List<YjssxTabReturnthesis> returnedThesisList) {
		this.returnedThesisList = returnedThesisList;
	}

	public int getReturnThesisId() {
		return returnThesisId;
	}

	public void setReturnThesisId(int returnThesisId) {
		this.returnThesisId = returnThesisId;
	}

	public String getStatusReason() {
		return StatusReason;
	}

	public void setStatusReason(String statusReason) {
		StatusReason = statusReason;
	}

	public String getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(String isReturned) {
		this.isReturned = isReturned;
	}

	public boolean isRetPassed() {
		return RetPassed;
	}

	public void setRetPassed(boolean retPassed) {
		RetPassed = retPassed;
	}

	public int getSubmitThsisId() {
		return submitThsisId;
	}

	public void setSubmitThsisId(int submitThsisId) {
		this.submitThsisId = submitThsisId;
	}

	public int getThesisType() {
		return ThesisType;
	}

	public void setThesisType(int thesisType) {
		ThesisType = thesisType;
	}

}
