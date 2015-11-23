package com.xdsc.action.yjssx_system;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabResume;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.service.yjssx_system.SystemFunctionService;
import com.xdsc.util.CommonConstVariable;
import com.xdsc.util.YjssxUtils;

/**
 * �๦�ܣ��о����ύ����
 * @author ����
 * @version 1.1
 */
public class PostgraduateSubmitThesisAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystemFunctionService systemFunctionService;
	
	private int ThesisType;
	
	/**
	 * �о����ύ��������Ϣ
	 */
	private Date date;        
	
	private String title;        
	
	private String comment;          
	
	/**
	 * �ύ�����ĵ��ļ�
	 */
	private File uploadFile;
	
	private String uploadFileContentType;

	private String uploadFileFileName;
	
	/**
	 * ��ʾ�ύ�˵����ĵ�����
	 */
	private YjssxTabSubmitthesis detailThesis;     
	
	private YjssxTabReturnthesis returnThesis;
	
	private String savePath;                   //���ĵı���·��
	
	/**
	 * ��Ҫ�޸ĵ�����
	 */
	private YjssxTabSubmitthesis updateThesis;                   //��Ҫ�޸ĵ�����
	
	private File updateFile;                                 //��Ҫ�޸ĵ�����
	
	private String updateFileContentType;

	private String updateFileFileName;
	
    private String contentType;                  //����
	
	private String filePath;
	
	private String fileName;
	
	private int downId;
	
	
	/**
	 * �о����ύ���ģ��ж��Ƿ����Ȩ�ޣ��Ƿ��Ѿ��ύ
	 * @return �����жϵĲ�ͬ���ת��ͬ��ҳ��
	 */
	public String preSubmitThesis(){ 
		String ThesisTypeName=new String();                           //������������
		int ThesisFunctionId;
		if(ThesisType==1){
			ThesisTypeName = CommonConstVariable.OPEN_THESIS;
			ThesisFunctionId=CommonConstVariable.SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID;
			
		}else if(ThesisType==2){
			ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
			ThesisFunctionId= CommonConstVariable.SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID;
		}else{
			ThesisTypeName = CommonConstVariable.FINAL_THESIS;
			ThesisFunctionId = CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<MhqxTabUserfunction> functionList=systemFunctionService.findUserFunctionByUserNum(FUserNumber);
		String temp="N";
		for(int i=0;i<functionList.size();i++){
			if(functionList.get(i).getMhqxTabFunction().getFFunctionId()==ThesisFunctionId){
				temp= "Y";
			}
		}
		if(temp.equals("N")){
			return "NoPowerToDoThisOption";
		}
		TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);        //���жϵ�ʦ�Ƿ��Ѿ�ȷ��
		if(stu.getTabTeachers()==null){
			return "tutorNotConfirm";                           //��ʦ��δѡ��
		}
		List<YjssxTabSubmitthesis> Thesis = postgraduateThesisService.findSubmitThesisByStudentNumAndType(FUserNumber,ThesisTypeName);        //����ж������Ƿ��Ѿ��ύ
		if(Thesis.size()==1){                         //�ж������Ƿ��Ѿ��ύ
		    //��������Ѿ��ύ���ж���������״̬
			detailThesis = Thesis.iterator().next();          //��ʾ�ύ���ĵ�����
			returnThesis=postgraduateThesisService.findReturnThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
			//��ʾ����������
			return "ThesisStuts";
		}
		return "preSubmitThesis";                            //�������������������ύ����
	}

	/**
	 * �ϴ����ģ���������
	 * @return �ύ���ĳɹ�
	 */
	public String uploadThesis(){             //�ϴ�����
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		YjssxTabSubmitthesis SubThesis = new YjssxTabSubmitthesis();
		String saveName=System.currentTimeMillis()+uploadFileFileName;
		YjssxUtils.saveFile(uploadFile, savePath, saveName);                    //���ù����ౣ���ļ�
		TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		stu.setFThesisIsSubmit("��");
		postgraduateInfoService.updatePostgraduateStuInfo(stu);
		TabTeachers tutor=stu.getTabTeachers();
		SubThesis.setFThesisName(title);
		SubThesis.setFDate(date);
		SubThesis.setFComment(comment);
		SubThesis.setFThesisStorePath(saveName);
		SubThesis.setTabPostgraduate(stu);
		SubThesis.setTabTeachers(tutor);
		SubThesis.setFThesisType(ThesisTypeName);
		SubThesis.setFStatus(CommonConstVariable.NOT_CHECK);
		postgraduateThesisService.addSubmitThesis(SubThesis);                  //�����ύ��������Ϣ
		
		YjssxTabReturnthesis ret= new YjssxTabReturnthesis();
		ret.setTabPostgraduate(stu);
		ret.setTabTeachers(tutor);
		ret.setFThesisIsReturn("��");
		ret.setFThesisType(ThesisTypeName);
		ret.setFStatus(CommonConstVariable.NOT_CHECK);
		postgraduateThesisService.addReturnThesis(ret);                     //���淴��������Ϣ��״̬Ϊδ����
		return "submitThesis";
	}
	
	/**
	 * ��ʾ���ĵ���ϸ��Ϣ
	 * @return ������������
	 */
	public String showDetailThesis(){    //��ʾ��Ϣ������
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		detailThesis = postgraduateThesisService.findSubmitThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
		return "showDetailSubmitThesis";
	}
	
	/**
	 * �޸�����֮ǰ�Ȳ��ҵ����ύ�����ĵ�����
	 * @return ���ύ�����ĵ�����
	 */
	public String preUpdateThesis(){    //��ʾ��Ϣ������
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		detailThesis = postgraduateThesisService.findSubmitThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
		return "preUpdateThesis";
	}
	
	/**
	 * �޸��Ѿ��ύ������
	 * @return �޸����ĳɹ�
	 */
	public String updateSubmitThesis(){                //�޸��ύ������
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		YjssxTabSubmitthesis SubThesis = postgraduateThesisService.findSubmitThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
		SubThesis.setFThesisName(updateThesis.getFThesisName());
		SubThesis.setFComment(updateThesis.getFComment());
		if(updateFile!=null){                         //����޸����ļ��Ļ���ɾ��ԭ�ļ��ϴ����ļ����������ļ���
			YjssxUtils.deleteFile(savePath, updateThesis.getFThesisStorePath());
			String saveName=System.currentTimeMillis()+updateFileFileName;
			YjssxUtils.saveFile(updateFile, savePath,saveName );
			SubThesis.setFThesisStorePath(saveName);
		}
		postgraduateThesisService.updateSubmitThesis(SubThesis);
		return "updateSubmitThesis";
	}

	public PostgraduateThesisService getPostgraduateThesisService() {
		return postgraduateThesisService;
	}

	public void setPostgraduateThesisService(
			PostgraduateThesisService postgraduateThesisService) {
		this.postgraduateThesisService = postgraduateThesisService;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public YjssxTabSubmitthesis getDetailThesis() {
		return detailThesis;
	}

	public void setDetailThesis(YjssxTabSubmitthesis detailThesis) {
		this.detailThesis = detailThesis;
	}

	public YjssxTabSubmitthesis getUpdateThesis() {
		return updateThesis;
	}

	public void setUpdateThesis(YjssxTabSubmitthesis updateThesis) {
		this.updateThesis = updateThesis;
	}

	public File getUpdateFile() {
		return updateFile;
	}

	public void setUpdateFile(File updateFile) {
		this.updateFile = updateFile;
	}

	public String getUpdateFileContentType() {
		return updateFileContentType;
	}

	public void setUpdateFileContentType(String updateFileContentType) {
		this.updateFileContentType = updateFileContentType;
	}

	public String getUpdateFileFileName() {
		return updateFileFileName;
	}

	public void setUpdateFileFileName(String updateFileFileName) {
		this.updateFileFileName = updateFileFileName;
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

	public YjssxTabReturnthesis getReturnThesis() {
		return returnThesis;
	}

	public void setReturnThesis(YjssxTabReturnthesis returnThesis) {
		this.returnThesis = returnThesis;
	}

	public int getThesisType() {
		return ThesisType;
	}

	public void setThesisType(int thesisType) {
		ThesisType = thesisType;
	}

}
