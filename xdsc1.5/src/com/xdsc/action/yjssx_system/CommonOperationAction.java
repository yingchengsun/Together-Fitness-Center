package com.xdsc.action.yjssx_system;

import java.util.List;

import javassist.compiler.Parser;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.CompanyInfoService;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.service.yjssx_system.SystemInfomationService;
import com.xdsc.service.yjssx_system.TutorInfoService;

/**
 * 类功能：系统一些公共功能的提取
 * @author 许鑫
 * @version 1.1
 */
public class CommonOperationAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private TutorInfoService tutorInfoService;
	
	private CompanyInfoService companyInfoService;
	
	private SystemInfomationService systemInfomationService;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	/**
	 * 根据研究生的id找到研究生的信息
	 */
	private String stuId;                       
	
	private TabPostgraduate stuInfo;
	
	/**
	 * 根据导师的id找到导师的信息
	 */
	private String tutorId;                    
	
	private TabTeachers teacherInfo;			
	
	/**
	 * 根据企业的id找到企业的信息
	 */
	private String comId;						
	
	private TabCompany companyInfo;
	
	/**
	 * 根据ID查找新闻信息
	 */
	private int infoId;                        
	
	private TabInformation infoDetail;
	
	private String type;                       //要删除的信息类型，用于redirect
	
	/**
	 *  要删除的信息ID
	 */
	private List<String> delInfoId;    
	
	/**
	 * 提交和反馈的论文详情查看
	 */	
	private int SubmitThesisId;
	
	private YjssxTabSubmitthesis SubmitThesis;
	
	private int ReturnThesisId;
	
	private YjssxTabReturnthesis ReturnThesis;
	
	/**
	 * 根据提交的论文的ID查找提交的论文的详情
	 * @return 返回提交的论文的详情
	 */
	public String findSubmitThesisDetail(){
		SubmitThesis = postgraduateThesisService.findSubmitThesisById(SubmitThesisId);
		return "findSubmitThesisDetail";
	}
	
	/**
	 * 根据反馈的论文的ID查找反馈的论文的详情
	 * @return 返回反馈的论文的详情
	 */
	public String findReturnThesisDetail(){
		ReturnThesis = postgraduateThesisService.findReturnThesisById(ReturnThesisId);
		return "findReturnThesisDetail";
	}

	/**
	 * 根据student的ID查找研究生的信息
	 * @return 返回研究生的信息
	 */
	public String findStudentInfo(){                //显示研究生详情
		stuInfo = postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		return "findStudentInfo";
	}
	
	/**
	 * 根据导师的ID查找导师的信息
	 * @return 返回导师的信息
	 */
	public String findTutorInfo(){
		teacherInfo = tutorInfoService.findTutorById(tutorId);
		return "findTutorInfo";
	}
	
	/**
	 * 根据企业的ID查找企业的信息
	 * @return 返回企业的信息
	 */
	public String findCompanyInfo(){
		companyInfo = companyInfoService.findCompanyByNum(comId);
		return "findCompanyInfo";
	}
	
	/**
	 * 根据information的id查找信息
	 * @return 返回查找到的information
	 */
	public String findInfoDetail(){                 //显示新闻信息
		infoDetail=systemInfomationService.findInfoById(infoId);
		return "findInfoDetail";
	}
	
	/**
	 * 根据information的id删除information的信息
	 * @return
	 */
	public String deleteInfo(){                      //删除新闻信息
		for(int i=0;i<delInfoId.size();i++){
			TabInformation temp= systemInfomationService.findInfoById(Integer.parseInt((delInfoId.get(i))));
			systemInfomationService.deleteInfo(temp);
		}
		return "deleteInfo";
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public TabPostgraduate getStuInfo() {
		return stuInfo;
	}

	public void setStuInfo(TabPostgraduate stuInfo) {
		this.stuInfo = stuInfo;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public SystemInfomationService getSystemInfomationService() {
		return systemInfomationService;
	}

	public void setSystemInfomationService(
			SystemInfomationService systemInfomationService) {
		this.systemInfomationService = systemInfomationService;
	}

	public TabInformation getInfoDetail() {
		return infoDetail;
	}

	public void setInfoDetail(TabInformation infoDetail) {
		this.infoDetail = infoDetail;
	}
	

	public List<String> getDelInfoId() {
		return delInfoId;
	}

	public void setDelInfoId(List<String> delInfoId) {
		this.delInfoId = delInfoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TutorInfoService getTutorInfoService() {
		return tutorInfoService;
	}

	public void setTutorInfoService(TutorInfoService tutorInfoService) {
		this.tutorInfoService = tutorInfoService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public String getTutorId() {
		return tutorId;
	}

	public void setTutorId(String tutorId) {
		this.tutorId = tutorId;
	}

	public TabTeachers getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(TabTeachers teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public TabCompany getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(TabCompany companyInfo) {
		this.companyInfo = companyInfo;
	}

	public int getSubmitThesisId() {
		return SubmitThesisId;
	}

	public void setSubmitThesisId(int submitThesisId) {
		SubmitThesisId = submitThesisId;
	}

	public int getReturnThesisId() {
		return ReturnThesisId;
	}

	public void setReturnThesisId(int returnThesisId) {
		ReturnThesisId = returnThesisId;
	}

	public PostgraduateThesisService getPostgraduateThesisService() {
		return postgraduateThesisService;
	}

	public void setPostgraduateThesisService(
			PostgraduateThesisService postgraduateThesisService) {
		this.postgraduateThesisService = postgraduateThesisService;
	}

	public YjssxTabSubmitthesis getSubmitThesis() {
		return SubmitThesis;
	}

	public void setSubmitThesis(YjssxTabSubmitthesis submitThesis) {
		SubmitThesis = submitThesis;
	}

	public YjssxTabReturnthesis getReturnThesis() {
		return ReturnThesis;
	}

	public void setReturnThesis(YjssxTabReturnthesis returnThesis) {
		ReturnThesis = returnThesis;
	}


}
