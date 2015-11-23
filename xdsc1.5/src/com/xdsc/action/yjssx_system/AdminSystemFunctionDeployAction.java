package com.xdsc.action.yjssx_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.SystemFunctionService;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能：管理员系统功能配置
 * @author 许鑫
 * @version 1.1
 *
 */
public class AdminSystemFunctionDeployAction extends ActionSupport {

	private SystemFunctionService systemFunctionService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService companyInfoService;
	
	private int thesisType;
	
	/**
	 * 配置功能，是为关闭还是开启搜索
	 */
	private String type; 
	
	/**
	 * 通过研究生姓名搜索研究生
	 */
	private String studentName;
	
	/**
	 * 通过研究生姓名搜索到的研究生信息
	 */
	private List<TabPostgraduate> studentList;
	
	/**
	 * 删除或打开某人的权限
	 */
	private String userNumber;
	
	/**
	 * 根据公司名称搜索公司信息
	 */
	private String companyName; 
	
	/**
	 * 根据公司名称搜索出来的公司信息
	 */
	private List<TabCompany> companyList;
	
	/**
	 * 打开或关闭某公司的发布招聘信息的权限
	 */
	private String companyNumber;

	/**
	 * 导师选择功能配置
	 * @return preTutorSelectDeploy 简单跳转
	 */
	public String preTutorSelectDeploy(){
		return "preTutorSelectDeploy";
	}
	

	
	/**
	 * 导师选择功能给所有研究生开通,即在userFunction表中插入user和function的信息
	 * @return TutorSelectOpenToAllStudent 功能成功开通
	 */
	public String TutorSelectOpenToAllStudent(){	
		List<TabPostgraduate> students=postgraduateInfoService.findAllStudent(); 
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);       //找到导师选择这项功能
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		for(int i=0;i<students.size();i++){
			userFunction.setMhqxTabFunction(function);
			userFunction.setMhqxTabUser(students.get(i).getTabStudents().getMhqxTabUser());
			systemFunctionService.addFunctionToUser(userFunction);
		}
		return "TutorSelectOpenToAllStudent";
	}
	
	/**
	 * 关闭所有研究生的导师选择信息
	 * @return TutorSelectCloseToAllStudent 功能关闭成功
	 */
	public String TutorSelectCloseToAllStudent(){             //删除所有用户选择导师的功能
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "TutorSelectCloseToAllStudent";
	}
	
	/**
	 * 根据研究生的姓名查找研究生的信息，根据type判断关闭该研究生的功能还是开启研究生的功能
	 * @return 分别转向关闭功能页面和开启功能页面
	 */
	public String StudentSearchByNameForTutorSelect(){
		studentList = postgraduateInfoService.findStudentByName(studentName);
		if(type.equals("close")){
			return "CloseSbTutorSelectSearchResult";
		}
		return "OpenSbTutorSelectSearchResult";
	}
	
	/**
	 * 关闭研究生的导师选择功能
	 * @return CloseSbTutorSelect 关闭某人的导师选择功能成功
	 */
	public String CloseSbTutorSelect(){
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByUserNumAndFunctionId(userNumber,CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CloseSbTutorSelect";
	}
	
	/**
	 * 开启某人的导师选择功能
	 * @return OpenSbTutorSelect 开启功能成功
	 */
	public String OpenSbTutorSelect(){
		TabPostgraduate students=postgraduateInfoService.findPostgraduateByStuNumber(userNumber);//找到这个研究生的信息
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);       //找到导师选择这项功能
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		userFunction.setMhqxTabFunction(function);
		userFunction.setMhqxTabUser(students.getTabStudents().getMhqxTabUser());
		systemFunctionService.addFunctionToUser(userFunction);
		return "OpenSbTutorSelect";
	}

	/**
	 * 研究生论文提交功能配置
	 * @return preThesisSubmitDeploy 转向功能配置页面
	 */
	public String preThesisSubmitDeploy(){   
		
		return "preThesisSubmitDeploy";
	}
	
	/**
	 * 根据用户开通还是关闭论文提交某项功能转向不同的页面
	 * @return
	 */
	public String ThesisFunctionDistinguish(){
		if(type.equals("open")){
			return "openThesisFunction";
		}else{
		return "closeThesisFunction";
		}
	}
	
	/**
	 * 给所有研究生开启论文呢提交功能
	 * @return ThesisSubmitDeployToAll 功能开启成功
	 */
	public String ThesisSubmitDeployToAll(){
		int ThesisTypeId;         //设置论文类型
		if(thesisType==1){
			ThesisTypeId = CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;			
		}else if(thesisType==2){
			ThesisTypeId = CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		List<TabPostgraduate> students=postgraduateInfoService.findAllStudent();    //找到所有研究生
		MhqxTabFunction function=systemFunctionService.findFunctionById(ThesisTypeId);       //找到论文提交这项功能
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		for(int i=0;i<students.size();i++){                    //给每一个研究生添加论文提交功能
			userFunction.setMhqxTabFunction(function);
			userFunction.setMhqxTabUser(students.get(i).getTabStudents().getMhqxTabUser());
			systemFunctionService.addFunctionToUser(userFunction);
		}
		return "ThesisSubmitDeployToAll";
	}
	
	/**
	 * 关闭所有研究生的论文提交功能
	 * @return SummitThesisCloseToAllStudent 功能关闭成功
	 */
	public String SummitThesisCloseToAllStudent(){             //删除所有用户论文提交的功能
		int ThesisTypeId;         //设置论文类型
		if(thesisType==1){
			ThesisTypeId = CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;			
		}else if(thesisType==2){
			ThesisTypeId = CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByFunctionId(ThesisTypeId);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "SummitThesisCloseToAllStudent";
	}
	
	/**
	 * 根据研究生姓名查找研究生
	 * @return OpenSbSubmitThesisSearchResult 返回研究生信息
	 */
	public String StudentSearchByNameForSubmitThesis(){
		studentList = postgraduateInfoService.findStudentByName(studentName);
		if(type.equals("close")){
			return "CloseSbSubmitThesisSearchResult";
		}
		return "OpenSbSubmitThesisSearchResult";
	}
	
	/**
	 * 关闭某人的论文提交功能
	 * @return CloseSbSubmitThesis 关闭论文提交功能成功
	 */
	public String CloseSbSubmitThesis(){          //关闭某人的论文提交的权限
		int ThesisTypeId;         //设置论文类型
		if(thesisType==1){
			ThesisTypeId = CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;			
		}else if(thesisType==2){
			ThesisTypeId = CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByUserNumAndFunctionId(userNumber,ThesisTypeId);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CloseSbSubmitThesis";
	}
	
	/**
	 * 打开某人的论文选择功能
	 * @return OpenSbSubmitThesis 打开论文选择功能成功 
	 */
	public String OpenSbSubmitThesis(){           //打开某人的论文提交的权限
		int ThesisTypeId;         //设置论文类型
		if(thesisType==1){
			ThesisTypeId = CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;			
		}else if(thesisType==2){
			ThesisTypeId = CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		TabPostgraduate students=postgraduateInfoService.findPostgraduateByStuNumber(userNumber);//找到这个研究生的信息
		MhqxTabFunction function=systemFunctionService.findFunctionById(ThesisTypeId);       //找到论文提交这项功能
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		userFunction.setMhqxTabFunction(function);
		userFunction.setMhqxTabUser(students.getTabStudents().getMhqxTabUser());
		systemFunctionService.addFunctionToUser(userFunction);
		return "OpenSbSubmitThesis";
	}
	
	/**
	 * 企业招聘功能配置
	 * @return preCompanyReleaseInfoDeploy 简单跳转
	 */
	public String preCompanyReleaseInfoDeploy(){                  //企业招聘管功能配置
		
		return "preCompanyReleaseInfoDeploy";
	}
	
	/**
	 * 给所有企业开通招聘信息发布功能
	 * @return CompanyReleaseInfoDeployToAll 功能开启成功
	 */
	public String CompanyReleaseInfoDeployToAll(){
		List<TabCompany> company= companyInfoService.findAllCompanyInfo();   //找到所有公司
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);       //找到企业招聘管这项功能
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		for(int i=0;i<company.size();i++){                    //给每一个企业添加企业招聘管功能
			userFunction.setMhqxTabFunction(function);
			userFunction.setMhqxTabUser(company.get(i).getMhqxTabUser());
			systemFunctionService.addFunctionToUser(userFunction);
		}
		return "CompanyReleaseInfoDeployToAll";
	}
	
	/**
	 * 关闭所有企业的招聘信息发布功能
	 * @return CompanyReleaseInfoCloseToAll 关闭功能成功
	 */
	public String CompanyReleaseInfoCloseToAll(){             //删除所有用户企业招聘管的功能
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CompanyReleaseInfoCloseToAll";
	}
	
	/**
	 * 根据公司的名称来搜索公司信息
	 * @return OpenSmCompanyReleaseInfoSearchResult 返回公司的信息
	 */
	public String CompanySearchByNameForCompanyReleaseInfo(){
		companyList = companyInfoService.findCompanyByName(companyName);
		if(type.equals("close")){
			return "CloseSmCompanyReleaseInfoSearchResult";
		}
		return "OpenSmCompanyReleaseInfoSearchResult";
	}
	
	/**
	 * 关闭某个公司的招聘信息发布功能
	 * @return CloseSmCompanyReleaseInfo 关闭功能成功
	 */
	public String CloseSmCompanyReleaseInfo(){          //关闭某人的企业招聘管的权限
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByUserNumAndFunctionId(companyNumber, CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CloseSmCompanyReleaseInfo";
	}
	
	/**
	 * 开启某个公司的招聘信息发布功能
	 * @return OpenSmCompanyReleaseInfo 关闭功能成功
	 */
	public String OpenSmCompanyReleaseInfo(){           //打开某企业招聘管的权限
		TabCompany company=companyInfoService.findCompanyByNum(companyNumber);//找到这个企业的信息
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);       //找到企业招聘管这项功能
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		userFunction.setMhqxTabFunction(function);
		userFunction.setMhqxTabUser(company.getMhqxTabUser());
		systemFunctionService.addFunctionToUser(userFunction);
		return "OpenSmCompanyReleaseInfo";
	}

	public SystemFunctionService getSystemFunctionService() {
		return systemFunctionService;
	}

	public void setSystemFunctionService(SystemFunctionService systemFunctionService) {
		this.systemFunctionService = systemFunctionService;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<TabPostgraduate> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<TabPostgraduate> studentList) {
		this.studentList = studentList;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<TabCompany> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<TabCompany> companyList) {
		this.companyList = companyList;
	}
	
	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getThesisType() {
		return thesisType;
	}

	public void setThesisType(int thesisType) {
		this.thesisType = thesisType;
	}
}
