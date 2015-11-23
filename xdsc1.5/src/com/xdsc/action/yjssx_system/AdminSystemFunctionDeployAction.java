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
 * �๦�ܣ�����Աϵͳ��������
 * @author ����
 * @version 1.1
 *
 */
public class AdminSystemFunctionDeployAction extends ActionSupport {

	private SystemFunctionService systemFunctionService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private CompanyInfoService companyInfoService;
	
	private int thesisType;
	
	/**
	 * ���ù��ܣ���Ϊ�رջ��ǿ�������
	 */
	private String type; 
	
	/**
	 * ͨ���о������������о���
	 */
	private String studentName;
	
	/**
	 * ͨ���о����������������о�����Ϣ
	 */
	private List<TabPostgraduate> studentList;
	
	/**
	 * ɾ�����ĳ�˵�Ȩ��
	 */
	private String userNumber;
	
	/**
	 * ���ݹ�˾����������˾��Ϣ
	 */
	private String companyName; 
	
	/**
	 * ���ݹ�˾�������������Ĺ�˾��Ϣ
	 */
	private List<TabCompany> companyList;
	
	/**
	 * �򿪻�ر�ĳ��˾�ķ�����Ƹ��Ϣ��Ȩ��
	 */
	private String companyNumber;

	/**
	 * ��ʦѡ��������
	 * @return preTutorSelectDeploy ����ת
	 */
	public String preTutorSelectDeploy(){
		return "preTutorSelectDeploy";
	}
	

	
	/**
	 * ��ʦѡ���ܸ������о�����ͨ,����userFunction���в���user��function����Ϣ
	 * @return TutorSelectOpenToAllStudent ���ܳɹ���ͨ
	 */
	public String TutorSelectOpenToAllStudent(){	
		List<TabPostgraduate> students=postgraduateInfoService.findAllStudent(); 
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);       //�ҵ���ʦѡ�������
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		for(int i=0;i<students.size();i++){
			userFunction.setMhqxTabFunction(function);
			userFunction.setMhqxTabUser(students.get(i).getTabStudents().getMhqxTabUser());
			systemFunctionService.addFunctionToUser(userFunction);
		}
		return "TutorSelectOpenToAllStudent";
	}
	
	/**
	 * �ر������о����ĵ�ʦѡ����Ϣ
	 * @return TutorSelectCloseToAllStudent ���ܹرճɹ�
	 */
	public String TutorSelectCloseToAllStudent(){             //ɾ�������û�ѡ��ʦ�Ĺ���
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "TutorSelectCloseToAllStudent";
	}
	
	/**
	 * �����о��������������о�������Ϣ������type�жϹرո��о����Ĺ��ܻ��ǿ����о����Ĺ���
	 * @return �ֱ�ת��رչ���ҳ��Ϳ�������ҳ��
	 */
	public String StudentSearchByNameForTutorSelect(){
		studentList = postgraduateInfoService.findStudentByName(studentName);
		if(type.equals("close")){
			return "CloseSbTutorSelectSearchResult";
		}
		return "OpenSbTutorSelectSearchResult";
	}
	
	/**
	 * �ر��о����ĵ�ʦѡ����
	 * @return CloseSbTutorSelect �ر�ĳ�˵ĵ�ʦѡ���ܳɹ�
	 */
	public String CloseSbTutorSelect(){
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByUserNumAndFunctionId(userNumber,CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CloseSbTutorSelect";
	}
	
	/**
	 * ����ĳ�˵ĵ�ʦѡ����
	 * @return OpenSbTutorSelect �������ܳɹ�
	 */
	public String OpenSbTutorSelect(){
		TabPostgraduate students=postgraduateInfoService.findPostgraduateByStuNumber(userNumber);//�ҵ�����о�������Ϣ
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID);       //�ҵ���ʦѡ�������
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		userFunction.setMhqxTabFunction(function);
		userFunction.setMhqxTabUser(students.getTabStudents().getMhqxTabUser());
		systemFunctionService.addFunctionToUser(userFunction);
		return "OpenSbTutorSelect";
	}

	/**
	 * �о��������ύ��������
	 * @return preThesisSubmitDeploy ת��������ҳ��
	 */
	public String preThesisSubmitDeploy(){   
		
		return "preThesisSubmitDeploy";
	}
	
	/**
	 * �����û���ͨ���ǹر������ύĳ���ת��ͬ��ҳ��
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
	 * �������о��������������ύ����
	 * @return ThesisSubmitDeployToAll ���ܿ����ɹ�
	 */
	public String ThesisSubmitDeployToAll(){
		int ThesisTypeId;         //������������
		if(thesisType==1){
			ThesisTypeId = CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;			
		}else if(thesisType==2){
			ThesisTypeId = CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		List<TabPostgraduate> students=postgraduateInfoService.findAllStudent();    //�ҵ������о���
		MhqxTabFunction function=systemFunctionService.findFunctionById(ThesisTypeId);       //�ҵ������ύ�����
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		for(int i=0;i<students.size();i++){                    //��ÿһ���о�����������ύ����
			userFunction.setMhqxTabFunction(function);
			userFunction.setMhqxTabUser(students.get(i).getTabStudents().getMhqxTabUser());
			systemFunctionService.addFunctionToUser(userFunction);
		}
		return "ThesisSubmitDeployToAll";
	}
	
	/**
	 * �ر������о����������ύ����
	 * @return SummitThesisCloseToAllStudent ���ܹرճɹ�
	 */
	public String SummitThesisCloseToAllStudent(){             //ɾ�������û������ύ�Ĺ���
		int ThesisTypeId;         //������������
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
	 * �����о������������о���
	 * @return OpenSbSubmitThesisSearchResult �����о�����Ϣ
	 */
	public String StudentSearchByNameForSubmitThesis(){
		studentList = postgraduateInfoService.findStudentByName(studentName);
		if(type.equals("close")){
			return "CloseSbSubmitThesisSearchResult";
		}
		return "OpenSbSubmitThesisSearchResult";
	}
	
	/**
	 * �ر�ĳ�˵������ύ����
	 * @return CloseSbSubmitThesis �ر������ύ���ܳɹ�
	 */
	public String CloseSbSubmitThesis(){          //�ر�ĳ�˵������ύ��Ȩ��
		int ThesisTypeId;         //������������
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
	 * ��ĳ�˵�����ѡ����
	 * @return OpenSbSubmitThesis ������ѡ���ܳɹ� 
	 */
	public String OpenSbSubmitThesis(){           //��ĳ�˵������ύ��Ȩ��
		int ThesisTypeId;         //������������
		if(thesisType==1){
			ThesisTypeId = CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;			
		}else if(thesisType==2){
			ThesisTypeId = CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		TabPostgraduate students=postgraduateInfoService.findPostgraduateByStuNumber(userNumber);//�ҵ�����о�������Ϣ
		MhqxTabFunction function=systemFunctionService.findFunctionById(ThesisTypeId);       //�ҵ������ύ�����
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		userFunction.setMhqxTabFunction(function);
		userFunction.setMhqxTabUser(students.getTabStudents().getMhqxTabUser());
		systemFunctionService.addFunctionToUser(userFunction);
		return "OpenSbSubmitThesis";
	}
	
	/**
	 * ��ҵ��Ƹ��������
	 * @return preCompanyReleaseInfoDeploy ����ת
	 */
	public String preCompanyReleaseInfoDeploy(){                  //��ҵ��Ƹ�ܹ�������
		
		return "preCompanyReleaseInfoDeploy";
	}
	
	/**
	 * ��������ҵ��ͨ��Ƹ��Ϣ��������
	 * @return CompanyReleaseInfoDeployToAll ���ܿ����ɹ�
	 */
	public String CompanyReleaseInfoDeployToAll(){
		List<TabCompany> company= companyInfoService.findAllCompanyInfo();   //�ҵ����й�˾
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);       //�ҵ���ҵ��Ƹ�������
		MhqxTabUserfunction userFunction=new MhqxTabUserfunction();
		for(int i=0;i<company.size();i++){                    //��ÿһ����ҵ�����ҵ��Ƹ�ܹ���
			userFunction.setMhqxTabFunction(function);
			userFunction.setMhqxTabUser(company.get(i).getMhqxTabUser());
			systemFunctionService.addFunctionToUser(userFunction);
		}
		return "CompanyReleaseInfoDeployToAll";
	}
	
	/**
	 * �ر�������ҵ����Ƹ��Ϣ��������
	 * @return CompanyReleaseInfoCloseToAll �رչ��ܳɹ�
	 */
	public String CompanyReleaseInfoCloseToAll(){             //ɾ�������û���ҵ��Ƹ�ܵĹ���
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CompanyReleaseInfoCloseToAll";
	}
	
	/**
	 * ���ݹ�˾��������������˾��Ϣ
	 * @return OpenSmCompanyReleaseInfoSearchResult ���ع�˾����Ϣ
	 */
	public String CompanySearchByNameForCompanyReleaseInfo(){
		companyList = companyInfoService.findCompanyByName(companyName);
		if(type.equals("close")){
			return "CloseSmCompanyReleaseInfoSearchResult";
		}
		return "OpenSmCompanyReleaseInfoSearchResult";
	}
	
	/**
	 * �ر�ĳ����˾����Ƹ��Ϣ��������
	 * @return CloseSmCompanyReleaseInfo �رչ��ܳɹ�
	 */
	public String CloseSmCompanyReleaseInfo(){          //�ر�ĳ�˵���ҵ��Ƹ�ܵ�Ȩ��
		List<MhqxTabUserfunction> userFunctionList=systemFunctionService.findUserFunctionByUserNumAndFunctionId(companyNumber, CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);
		for(int i=0;i<userFunctionList.size();i++){
			systemFunctionService.deleteUserFunction(userFunctionList.get(i));
		}
		return "CloseSmCompanyReleaseInfo";
	}
	
	/**
	 * ����ĳ����˾����Ƹ��Ϣ��������
	 * @return OpenSmCompanyReleaseInfo �رչ��ܳɹ�
	 */
	public String OpenSmCompanyReleaseInfo(){           //��ĳ��ҵ��Ƹ�ܵ�Ȩ��
		TabCompany company=companyInfoService.findCompanyByNum(companyNumber);//�ҵ������ҵ����Ϣ
		MhqxTabFunction function=systemFunctionService.findFunctionById(CommonConstVariable.SYSTEM_ZHAOPINREALEASE_FUNCTION_ID);       //�ҵ���ҵ��Ƹ�������
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
