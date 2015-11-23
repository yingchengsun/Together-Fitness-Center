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
 * 类功能：研究生提交论文
 * @author 许鑫
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
	 * 研究身提交的论文信息
	 */
	private Date date;        
	
	private String title;        
	
	private String comment;          
	
	/**
	 * 提交的论文的文件
	 */
	private File uploadFile;
	
	private String uploadFileContentType;

	private String uploadFileFileName;
	
	/**
	 * 显示提交了的论文的详情
	 */
	private YjssxTabSubmitthesis detailThesis;     
	
	private YjssxTabReturnthesis returnThesis;
	
	private String savePath;                   //论文的保存路径
	
	/**
	 * 需要修改的论文
	 */
	private YjssxTabSubmitthesis updateThesis;                   //需要修改的论文
	
	private File updateFile;                                 //需要修改的论文
	
	private String updateFileContentType;

	private String updateFileFileName;
	
    private String contentType;                  //下载
	
	private String filePath;
	
	private String fileName;
	
	private int downId;
	
	
	/**
	 * 研究生提交论文，判断是否具有权限，是否已经提交
	 * @return 根据判断的不同结果转向不同的页面
	 */
	public String preSubmitThesis(){ 
		String ThesisTypeName=new String();                           //设置论文类型
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
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
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
		TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);        //再判断导师是否已经确定
		if(stu.getTabTeachers()==null){
			return "tutorNotConfirm";                           //导师尚未选择
		}
		List<YjssxTabSubmitthesis> Thesis = postgraduateThesisService.findSubmitThesisByStudentNumAndType(FUserNumber,ThesisTypeName);        //最后判断论文是否已经提交
		if(Thesis.size()==1){                         //判断论文是否已经提交
		    //如果论文已经提交则判断论文论文状态
			detailThesis = Thesis.iterator().next();          //显示提交论文的详情
			returnThesis=postgraduateThesisService.findReturnThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
			//显示反馈的论文
			return "ThesisStuts";
		}
		return "preSubmitThesis";                            //以上条件都不成立则提交论文
	}

	/**
	 * 上传论文，保存论文
	 * @return 提交论文成功
	 */
	public String uploadThesis(){             //上传论文
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		YjssxTabSubmitthesis SubThesis = new YjssxTabSubmitthesis();
		String saveName=System.currentTimeMillis()+uploadFileFileName;
		YjssxUtils.saveFile(uploadFile, savePath, saveName);                    //调用工具类保存文件
		TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		stu.setFThesisIsSubmit("是");
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
		postgraduateThesisService.addSubmitThesis(SubThesis);                  //保存提交的论文信息
		
		YjssxTabReturnthesis ret= new YjssxTabReturnthesis();
		ret.setTabPostgraduate(stu);
		ret.setTabTeachers(tutor);
		ret.setFThesisIsReturn("否");
		ret.setFThesisType(ThesisTypeName);
		ret.setFStatus(CommonConstVariable.NOT_CHECK);
		postgraduateThesisService.addReturnThesis(ret);                     //保存反馈论文信息，状态为未反馈
		return "submitThesis";
	}
	
	/**
	 * 显示论文的详细信息
	 * @return 返回论文详情
	 */
	public String showDetailThesis(){    //显示信息的详情
		String ThesisTypeName=new String();         //设置论文类型
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		detailThesis = postgraduateThesisService.findSubmitThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
		return "showDetailSubmitThesis";
	}
	
	/**
	 * 修改论文之前先查找到已提交的论文的详情
	 * @return 已提交的论文的详情
	 */
	public String preUpdateThesis(){    //显示信息的详情
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		String ThesisTypeName=new String();         //设置论文类型
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
	 * 修改已经提交的论文
	 * @return 修改论文成功
	 */
	public String updateSubmitThesis(){                //修改提交的论文
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		String ThesisTypeName=new String();         //设置论文类型
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
		if(updateFile!=null){                         //如果修改了文件的话则删除原文件上传新文件并保存新文件名
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
