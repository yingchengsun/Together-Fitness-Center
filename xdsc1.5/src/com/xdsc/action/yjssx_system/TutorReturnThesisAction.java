package com.xdsc.action.yjssx_system;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.service.yjssx_system.SystemFunctionService;
import com.xdsc.util.CommonConstVariable;
import com.xdsc.util.YjssxUtils;

/**
 * �๦�ܣ���ʦ���Ļظ�
 * @author ����
 * @version 1.1
 */
public class TutorReturnThesisAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystemFunctionService systemFunctionService;
	
	/**
	 * �ظ�������
	 */
	private List<YjssxTabReturnthesis> thesisList;                  
	 
	private List<YjssxTabReturnthesis> retList;                   
	
	private File uploadFile;               
	
	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;
	
	private YjssxTabReturnthesis retThesis;
	
	/**
	 * ��ʾ���������ĵ�����
	 */
	private int DetailId;
	
	private YjssxTabReturnthesis detailInfo;
	
	/**
	 * ���ĸ�ͬѧ�ظ����ģ��о���ID
	 */
	private String stuId;                                        
	
    private int downId;     //�����ļ���Id
	
    private String contentType;
	
	private String filePath;
	
	private String fileName;
	
	private int p = 1;

	private int lastPage;


	public String returnInfomation(){
		
		return "returnInfomation";
	}
	
	/**
	 * ���ύ���ĵ��о�������
	 * @return �����Ѿ��ύ����������
	 */
	public String submitedStudent(){           //�ж��Ƿ��������ύʱ��
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<MhqxTabUserfunction> function1=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function1.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		List<YjssxTabReturnthesis> list=new ArrayList<YjssxTabReturnthesis>();
		list= postgraduateThesisService.findReturnThesisByTutorNumAndType(FUserNumber,"");
		thesisList = new ArrayList<YjssxTabReturnthesis>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFThesisIsReturn().equals("��"))
				thesisList.add(list.get(i));
		}
		if(list.size()==0){               //��ʾ�˵�ʦ��δ���ܵ��κ������ύ
			return "NoStudentHaveSubmit";
		}
		if(thesisList.size()==0){         //����δ�ظ�������----------------------
			return "allThesisHavaReturn";
		}
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
		
		return "submitedStudent";
	}
	
	/**
	 * ��ת�����Ļظ�ҳ��
	 * @return returnThesis
	 */
	public String returnThesis(){		
		return "returnThesis";
	}
	
	/**
	 * �ύ�ظ�����
	 * @return ���Ļظ��ɹ�
	 */
	public String uploadThesis(){                         //�ϴ��ظ�������
		List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		String saveName=System.currentTimeMillis()+uploadFileFileName;
		YjssxUtils.saveFile(uploadFile, savePath, saveName);                    //���ù����ౣ���ļ�
		YjssxTabReturnthesis ret= postgraduateThesisService.findReturnThesisByStudentNumAndType(stuId,"").iterator().next();
		System.out.println("-----------------------------"+ret.getFThesisIsReturn());
		ret.setFThesisName(retThesis.getFThesisName());
		ret.setFDate(retThesis.getFDate());
		ret.setFComment(retThesis.getFComment());
		ret.setFThesisIsReturn("��");
		ret.setFThesisStorePath(saveName);
		postgraduateThesisService.updateReturnThesis(ret);                     //���淴��������Ϣ��״̬Ϊ�Ѿ�����
		return "uploadThesis";
	}
	
	/**
	 * �鿴�Ѿ��ظ����ĵ��о���
	 * @return ���ػظ��������б�
	 */
	public String thesisHaveReturned(){ //��ʾ�ѻظ����о�������
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<MhqxTabUserfunction> function1=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function1.size()<=0){//�ж��Ƿ��������ύʱ��
			return "NotRightTimeToReceiveThesis";
		}
		List<MhqxTabUserfunction> function=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function.size()<=0){
			return "NotRightTimeToReceiveThesis";
		}
		retList = new ArrayList<YjssxTabReturnthesis>();
		List<YjssxTabReturnthesis> list=new ArrayList<YjssxTabReturnthesis>();
		list= postgraduateThesisService.findReturnThesisByTutorNumAndType(FUserNumber,"");
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFThesisIsReturn().equals("��"))
				retList.add(list.get(i));
		}
		if(retList.size()>10){
			int pages = 10;
			int listlength = this.retList.size();
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
			this.retList = this.retList.subList(startIndex, endIndex);
		}
			
		return "thesisHaveReturned";
	}
	
	/**
	 * ��ʾ�ظ������ĵ�����
	 * @return �ظ������ĵ�����
	 */
	public String showDetailThesis(){
		detailInfo = postgraduateThesisService.findReturnThesisById(DetailId);
		return "showDetailThesis";
	}
	
	/**
	 * δ�ظ������ĵ��о���
	 * @return ����δ�ظ����ĵ��о����б�
	 */
	public String thesisNotReturned(){ //��ʾδ�ظ����о�������
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<MhqxTabUserfunction> function1=systemFunctionService.findUserFunctionByFunctionId(CommonConstVariable.SYSTEM_THESISSUBMIT_FUNCTION_ID);
		if(function1.size()<=0){//�ж��Ƿ��������ύʱ��
			return "NotRightTimeToReceiveThesis";
		}
		retList = new ArrayList<YjssxTabReturnthesis>();
		List<YjssxTabReturnthesis> list=new ArrayList<YjssxTabReturnthesis>();
		list= postgraduateThesisService.findReturnThesisByTutorNumAndType(FUserNumber,"");
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFThesisIsReturn().equals("��"))
				retList.add(list.get(i));
		}
		if(list.size()==0){               //��ʾ�˵�ʦ��δ���ܵ��κ������ύ
			return "NoStudentHaveSubmit";
		}
		if(retList.size()==0){             //��ʾ�ύ������ȫ���Ѿ��ظ�
			return "allThesisHavaReturn";
		}
		if(retList.size()>10){
			int pages = 10;
			int listlength = this.retList.size();
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
			this.retList = this.retList.subList(startIndex, endIndex);
		}
		
		return "thesisNotReturned";
	}
	
	public String downFile(){      //��������
		YjssxTabReturnthesis info=postgraduateThesisService.findReturnThesisById(downId);
		this.setContentType("application/"+this.getExt(info.getFThesisStorePath()));
		this.setFilePath(CommonConstVariable.THESIS_FILE_PATH+info.getFThesisStorePath());
		this.setFileName(info.getFThesisStorePath());
		return "downFileSuccess";
	}
	
	public InputStream getDownFile() throws Exception{        //�ļ����������
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	public String getExt(String str){               //����ļ��ĺ�׺��
		String subStr=str.substring(str.indexOf("."));
		return subStr;
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

	public YjssxTabReturnthesis getRetThesis() {
		return retThesis;
	}

	public void setRetThesis(YjssxTabReturnthesis retThesis) {
		this.retThesis = retThesis;
	}

	public List<YjssxTabReturnthesis> getThesisList() {
		return thesisList;
	}

	public void setThesisList(List<YjssxTabReturnthesis> thesisList) {
		this.thesisList = thesisList;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public List<YjssxTabReturnthesis> getRetList() {
		return retList;
	}

	public void setRetList(List<YjssxTabReturnthesis> retList) {
		this.retList = retList;
	}

	public int getDetailId() {
		return DetailId;
	}

	public void setDetailId(int detailId) {
		DetailId = detailId;
	}

	public YjssxTabReturnthesis getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(YjssxTabReturnthesis detailInfo) {
		this.detailInfo = detailInfo;
	}

	public int getDownId() {
		return downId;
	}

	public void setDownId(int downId) {
		this.downId = downId;
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

}
