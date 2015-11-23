package com.xdsc.action.yjssx_system;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.YjssxTabReturnthesis;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateThesisService;
import com.xdsc.util.CommonConstVariable;

/**
 * �๦�ܣ��о������յ�ʦ����������
 * @author ����
 * @version 1.1
 */
public class PostgraduateReceiveThesisAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private int ThesisType;
	
	private PostgraduateThesisService postgraduateThesisService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private YjssxTabReturnthesis detailInfo;

	/**
	 * ���ҵ�ʦ�������������ж��Ƿ��ύ�����ж��Ƿ������ٲ��ҵ���������
	 * @return ���ĵ�����
	 */
	public String findReturnThesis(){                //��������ʵ���ж������Ƿ��Ѿ��ύ
		String ThesisTypeName=new String();         //������������
		if(ThesisType==1){
		    ThesisTypeName = CommonConstVariable.OPEN_THESIS;			
		}else if(ThesisType==2){
		    ThesisTypeName = CommonConstVariable.MIDDLE_THESIS;
		}else{
		   ThesisTypeName = CommonConstVariable.FINAL_THESIS;
		}
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		if(postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber).getFThesisIsSubmit().equals("��")){
			return "thesisNotSubmit";
		}
		detailInfo= postgraduateThesisService.findReturnThesisByStudentNumAndType(FUserNumber,ThesisTypeName).iterator().next();
		if(detailInfo.getFThesisIsReturn().equals("��")){
			return "theisNotReturn";
		}
		return "findReturnThesis";
	}
	
	
	public PostgraduateThesisService getPostgraduateThesisService() {
		return postgraduateThesisService;
	}

	public void setPostgraduateThesisService(
			PostgraduateThesisService postgraduateThesisService) {
		this.postgraduateThesisService = postgraduateThesisService;
	}

	public YjssxTabReturnthesis getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(YjssxTabReturnthesis detailInfo) {
		this.detailInfo = detailInfo;
	}


	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}


	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
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


	public int getThesisType() {
		return ThesisType;
	}


	public void setThesisType(int thesisType) {
		ThesisType = thesisType;
	}

}
