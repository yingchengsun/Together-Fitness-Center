package com.xdsc.action.yjssx_system;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;
import com.xdsc.service.yjssx_system.SystemFunctionService;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能:研究生选择导师，权限判断
 * @author Administrator
 *
 */
public class PostgraduatePreSelectTutorAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private SystemFunctionService systemFunctionService;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	private YjssxTabTutorselect tutorSelect;
	
	/**
	 * 选择导师前先判断是否具有权限，是否已经选择，是否已经确定。
	 * @return 各种不同情况转向不同页面
	 */
	public String preSelectTutor(){                      //先判断是否具有此功能的权限
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<MhqxTabUserfunction> functionList=systemFunctionService.findUserFunctionByUserNum(FUserNumber);
		String temp="N";
		for(int i=0;i<functionList.size();i++){
			if(functionList.get(i).getMhqxTabFunction().getFFunctionId()==CommonConstVariable.SYSTEM_TUTOTSELECT_FUNCTION_ID){
				temp= "Y";
			}
		}
		if(temp.equals("N")){
			return "NoPowerToDoThisOption";
		} 
		TabPostgraduate student= postgraduateInfoService.findPostgraduateByStuNumber(FUserNumber);
		if(student.getTabTeachers()!=null){            //在判断导师是否已经确定
			return "TutorHaveConfirmed";
		}
		//在判断导师是否已经选择
		tutorSelect= postgraduateTutorSelectService.tutorSelectInfoByStuNum(FUserNumber);    //判断导师是否已经选择
		if(tutorSelect==null){
			return "tutorNotSelect";
		}
		return "preSelectTutor";
	}

	public PostgraduateTutorSelectService getPostgraduateTutorSelectService() {
		return postgraduateTutorSelectService;
	}

	public void setPostgraduateTutorSelectService(
			PostgraduateTutorSelectService postgraduateTutorSelectService) {
		this.postgraduateTutorSelectService = postgraduateTutorSelectService;
	}

	public YjssxTabTutorselect getTutorSelect() {
		return tutorSelect;
	}

	public void setTutorSelect(YjssxTabTutorselect tutorSelect) {
		this.tutorSelect = tutorSelect;
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
