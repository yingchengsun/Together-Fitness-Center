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
 * �๦�ܣ�ϵͳһЩ�������ܵ���ȡ
 * @author ����
 * @version 1.1
 */
public class CommonOperationAction extends ActionSupport {
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private TutorInfoService tutorInfoService;
	
	private CompanyInfoService companyInfoService;
	
	private SystemInfomationService systemInfomationService;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	/**
	 * �����о�����id�ҵ��о�������Ϣ
	 */
	private String stuId;                       
	
	private TabPostgraduate stuInfo;
	
	/**
	 * ���ݵ�ʦ��id�ҵ���ʦ����Ϣ
	 */
	private String tutorId;                    
	
	private TabTeachers teacherInfo;			
	
	/**
	 * ������ҵ��id�ҵ���ҵ����Ϣ
	 */
	private String comId;						
	
	private TabCompany companyInfo;
	
	/**
	 * ����ID����������Ϣ
	 */
	private int infoId;                        
	
	private TabInformation infoDetail;
	
	private String type;                       //Ҫɾ������Ϣ���ͣ�����redirect
	
	/**
	 *  Ҫɾ������ϢID
	 */
	private List<String> delInfoId;    
	
	/**
	 * �ύ�ͷ�������������鿴
	 */	
	private int SubmitThesisId;
	
	private YjssxTabSubmitthesis SubmitThesis;
	
	private int ReturnThesisId;
	
	private YjssxTabReturnthesis ReturnThesis;
	
	/**
	 * �����ύ�����ĵ�ID�����ύ�����ĵ�����
	 * @return �����ύ�����ĵ�����
	 */
	public String findSubmitThesisDetail(){
		SubmitThesis = postgraduateThesisService.findSubmitThesisById(SubmitThesisId);
		return "findSubmitThesisDetail";
	}
	
	/**
	 * ���ݷ��������ĵ�ID���ҷ��������ĵ�����
	 * @return ���ط��������ĵ�����
	 */
	public String findReturnThesisDetail(){
		ReturnThesis = postgraduateThesisService.findReturnThesisById(ReturnThesisId);
		return "findReturnThesisDetail";
	}

	/**
	 * ����student��ID�����о�������Ϣ
	 * @return �����о�������Ϣ
	 */
	public String findStudentInfo(){                //��ʾ�о�������
		stuInfo = postgraduateInfoService.findPostgraduateByStuNumber(stuId);
		return "findStudentInfo";
	}
	
	/**
	 * ���ݵ�ʦ��ID���ҵ�ʦ����Ϣ
	 * @return ���ص�ʦ����Ϣ
	 */
	public String findTutorInfo(){
		teacherInfo = tutorInfoService.findTutorById(tutorId);
		return "findTutorInfo";
	}
	
	/**
	 * ������ҵ��ID������ҵ����Ϣ
	 * @return ������ҵ����Ϣ
	 */
	public String findCompanyInfo(){
		companyInfo = companyInfoService.findCompanyByNum(comId);
		return "findCompanyInfo";
	}
	
	/**
	 * ����information��id������Ϣ
	 * @return ���ز��ҵ���information
	 */
	public String findInfoDetail(){                 //��ʾ������Ϣ
		infoDetail=systemInfomationService.findInfoById(infoId);
		return "findInfoDetail";
	}
	
	/**
	 * ����information��idɾ��information����Ϣ
	 * @return
	 */
	public String deleteInfo(){                      //ɾ��������Ϣ
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
