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
 * 类功能：导师接收论文
 * @author 许鑫
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
	 * 弹出窗口时设置状态还是回复论文
	 */
	private String ret;
	
	/**
	 * 用于页面判断论文是否已经回复
	 */
	private int isReturn;
	
	/**
	 * 论文
	 */
	private List<YjssxTabSubmitthesis> thesisList;
	
	private int DetailId;	
	
	/**
	 * 论文提交情况查询，1表示已经回复，0表示未回复
	 */
	private String IsSubmit;
	
	//-------------------------------根据查询条件查询已提交的论文----------------------------------------------
	
	private String studentGrade;
	
	private String studentName;
	
	private String ThesisStatus;
	
	//-------------------------------根据查询条件查询已提交的论文----------------------------------------------
	
	//-------------------------------导师查看论文，设置论文的状态，回复论文--------------------------------------
	
	private String ReasonTitle;
	
	private String ReasonContent;
	
	private String Status; //设置提交的论文的状态
	
	private int SubmitThesisId;//要恢复的学生提交论文的ID
	
	private String stuId;//要回复的学生的ID
	
	private YjssxTabReturnthesis retThesis;
	
	/**
	 * 回复的论文已经通过管理员审查
	 */
	private boolean RetPassed;
	
	private File uploadFile;               
	
	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;
	
	//-------------------------------导师查看论文，设置论文的状态，回复论文--------------------------------------
	/**
	 * 论文的详情
	 */
	private YjssxTabSubmitthesis detailThesis;
	
	private List<TabPostgraduate> stuList;
	
	//-------------------------------导师查看反馈论文的状态--------------------------------------
	
	private List<YjssxTabReturnthesis> returnedThesisList;
	
	private int returnThesisId;
	
	private String StatusReason;
	
	private int submitThsisId;
	
	//-------------------------------导师查看反馈情况查询--------------------------------------
	
	private String isReturned;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * 导师查看反馈论文的状态
	 * @return
	 */
	public String TutorReturnThesisStatus(){
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<YjssxTabReturnthesis> AllThesis=postgraduateThesisService.findReturnThesisByTutorNumAndType(FUserNumber,ThesisTypeName);
		returnedThesisList = new ArrayList<YjssxTabReturnthesis>();
		for(int i=0;i<AllThesis.size();i++){
			if(AllThesis.get(i).getFThesisIsReturn().equals("是")){
				returnedThesisList.add(AllThesis.get(i));
			}
		}
		return "TutorReturnThesisStatus";
	}
	
	/**
	 * 根据条件搜索论文的反馈情况
	 * @return
	 */
	public String ReturnedThesisStatusSearchByCondition(){
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<YjssxTabReturnthesis> AllThesis = postgraduateThesisService.findReturnThesisByConditionAndType(studentGrade, studentName, ThesisStatus, FUserNumber,ThesisTypeName);
		returnedThesisList = new ArrayList<YjssxTabReturnthesis>();
		for(int i=0;i<AllThesis.size();i++){
			if(AllThesis.get(i).getFThesisIsReturn().equals("是")){
				returnedThesisList.add(AllThesis.get(i));
			}
		}
		return "TutorReturnThesisStatus";
	}
	
	/**
	 * 查看管理员审核原因
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
	 * 查看已反馈和未反馈的论文
	 * @return
	 */
	public String ReturnInfomationSearch(){
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<YjssxTabReturnthesis> retList=postgraduateThesisService.findReturnThesisByConditionAndType(studentGrade,"","", FUserNumber,ThesisTypeName);
		thesisList =new ArrayList<YjssxTabSubmitthesis>();
		YjssxTabSubmitthesis TempReturn = new YjssxTabSubmitthesis();
		if(isReturned.equals("Y")){                     //查找已经反馈的论文
			for(int i=0;i<retList.size();i++){
				if(retList.get(i).getFThesisIsReturn().equals("是")){
					TempReturn = postgraduateThesisService.findSubmitThesisByTutorNumAndStudentNumAndType(retList.get(i).getTabPostgraduate().getFStudentNumber(),
							retList.get(i).getTabTeachers().getFTeacherNumber(),ThesisTypeName).iterator().next();
					thesisList.add(TempReturn);
				}
			}
		}else{			//查找未反馈的论文
			for(int i=0;i<retList.size();i++){
				if(retList.get(i).getFThesisIsReturn().equals("否")){
					TempReturn = postgraduateThesisService.findSubmitThesisByTutorNumAndStudentNumAndType(retList.get(i).getTabPostgraduate().getFStudentNumber(),
							retList.get(i).getTabTeachers().getFTeacherNumber(),ThesisTypeName).iterator().next();
					thesisList.add(TempReturn);
				}
			}
		}
		return "submitThesis";
	}
	
	/**
	 * 已提交的论文
	 * @return 返回已经提交的论文
	 */
	public String submitThesis(){                  //查看已提交论文
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
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
	
	public String submitInfomationSearch(){   //按照论文提交情况查询*******
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
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
			for(int i=0;i<AllList.size();i++){ //根据年级查找未提交的研究生
				if(AllList.get(i).getTabStudents().getTabClasses().getTabGrade().getFGradeNum().equals(studentGrade)&&AllList.get(i).getFThesisIsSubmit().equals("否")){
					stuList.add(AllList.get(i));				
				}
			}
			return "ThesisNotSubmit";
		}	
	}
	
	/**
	 * 根据条件查看已提交的论文
	 * @return 已提交的论文
	 */
	public String SubmitThesisSearchByCondition(){    //根据条件查询已提交的论文
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		thesisList = postgraduateThesisService.findSubmitThesisByConditionAndType(studentGrade, studentName, ThesisStatus,FUserNumber,ThesisTypeName);
		return "SubmitThesisSearchByCondition";
	}
	
	/**
	 * 显示论文的详情
	 * @return 返回论文详情
	 */
	public String showDetailThesis(){             //论文详情
		String ThesisTypeName=new String();         //设置论文类型
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
		if(retThesis.getFThesisIsReturn().equals("是")){
			isReturn =1;//已经回复
		}else{
			isReturn=0;//尚未回复
		}
		if(retThesis.getFStatus().equals(CommonConstVariable.CHECK_HAVE_PASS)){//判断反馈的论文是否已经通过管理员审核
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
	 * 设置提交论文的状态
	 * @return 设置为已通过审核和未通过审核
	 */
	public String SetSubmitStatus(){
		//首先设置论文的提交状态
		String ThesisTypeName=new String();         //设置论文类型
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
			thesis.setFReason(ReasonContent);                      //设置论文状态原因
		}else{
			thesis.setFStatus(CommonConstVariable.CHECK_NOT_PASS);
			thesis.setFReason(ReasonContent);					  //设置论文状态原因
		}
		postgraduateThesisService.updateSubmitThesis(thesis);
		
		TabNotice reason = new TabNotice();                     //在新鲜事中添加原因
		reason.setFModuleId(CommonConstVariable.MODULE_ID);
		reason.setFInfoTitle(ReasonTitle);
		reason.setFInfoContet(ReasonContent);
		Date date = new Date();
		reason.setFInfoStartTime(date);
		reason.setFInfoType(CommonConstVariable.NOTICE_TYPE_TUTORTOSTUDENT);
		systomNoticeService.addNotice(reason);
		
		TabNoticetosb noticeTo=new TabNoticetosb();//添加原因
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
	 * 导师回复论文
	 * @return 
	 */
	public String ReturnThesis(){                   //导师论文回复
		//查看论文是否已经回复过
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		TabPostgraduate student=postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		TabTeachers teacher = tutorInfoService.findTutorById(FUserNumber);
		Date date=new Date();
		List<YjssxTabReturnthesis> retList=postgraduateThesisService.findReturnThesisByStudentNumAndType(stuId,ThesisTypeName);
		if(retList.size()==1){
			if(uploadFile!=null){           //若论文已经反馈只需修改
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
				ret.setFThesisIsReturn("是");
				postgraduateThesisService.updateReturnThesis(ret);
			}else{
				YjssxTabReturnthesis ret=retList.iterator().next();
				ret.setFComment(retThesis.getFComment());
				ret.setFDate(date);
				ret.setFThesisName(retThesis.getFThesisName());
				ret.setFThesisIsReturn("是");
				postgraduateThesisService.updateReturnThesis(ret);
			}		
		}else{  //如果论文没有反馈过，则反馈论文
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			YjssxUtils.saveFile(uploadFile, savePath, saveName);
			retThesis.setFThesisStorePath(saveName);
			retThesis.setFThesisType(ThesisTypeName);
			retThesis.setFDate(date);
			retThesis.setTabPostgraduate(student);
			retThesis.setTabTeachers(teacher);
			retThesis.setFStatus("未审核");
			retThesis.setFThesisIsReturn("是");
			postgraduateThesisService.addReturnThesis(retThesis);
		}	
		return "ReturnThesis";
	}
	
	/**
	 * 论文未提交的研究生delete delete delete delete delete delete delete delete 
	 * @return 返回未提交论文的研究生
	 */
	public String thesisNotSubmit(){              //未提交论文的研究生
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		stuList = new ArrayList<TabPostgraduate>();
		List<TabPostgraduate> AllList=new ArrayList<TabPostgraduate>();
		AllList=postgraduateInfoService.findPostgraduateByTutorNumber(FUserNumber);
		for(int i=0;i<AllList.size();i++){
			if(AllList.get(i).getFThesisIsSubmit().equals("否")){
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
