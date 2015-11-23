package com.xdsc.action.wsbm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;

import com.xdsc.service.wsbm.KsCheckManager;
import com.xdsc.service.wsbm.UserLoginService;


/**登陆系统
 * @author 苟小龙
 *@version 1.2
 */
public class CommonLoginAction extends ActionSupport implements SessionAware{

	/**
	 * session相关属性
	 */
	private Map session;
	
	/**
	 * service层相关属性
	 */
	private UserLoginService userLoginService;
	private KsCheckManager ksCheckManager;
	
	/**
	 * 登陆需要提交的相关属性
	 */
	private String name;
	private String userName;
	
	private String password;
	
	private String type;
	



	/**系统用户登陆
	 * @return appLogin 考生登陆系统成功
	 * @return loginFalse 考生身份信息验证失败
	 * @return adLogin 管理员登陆系统成功
	 * @return norole 角色匹配失败
	 * @return nouser 无此用户
	 */
	public String execute(){ 
		System.out.println("start login******************");//用户登陆
		MhqxTabUser user=new MhqxTabUser();
		user.setFUserNumber(name);
		//user.setFUserPassword(password);
		System.out.println("check*********************");
		if(userLoginService.UserIsValide(user)){          //先判断用户是否存在
			System.out.println("user valid");
			type="app";
			if(type.equals("app")){               //判断是学生还是辅导员还是管理员
				WsbmTabRegapplicant app = ksCheckManager.findKaoShengInfoByNum(name);
				if(app!=null){
					userName=app.getFAppRegNum();
					
					session.put("userNumber", name);
					System.out.println("app done~~*******************");

					return "appLogin";
				}
				else{
					return "loginFalse";
				}
			}
			
			
			else if(name.equals("wsbmfls")&&password.equals("fan")){
				session.put("userNumber", name);
				System.out.println("admin done~~*******************");

				return "adminLogin";
			}
			
			else{
				System.out.println("no at all~~*******************");
				return "norole";
				}

		}
		return "nouser";
	}
	
	/**转至相关主页
	 * @return studentPage 转至考生主页
	 * @return tutorPage 转至道生主页
	 * @return adminPage 转至管理员主页
	 */
	public String GoToHomePage(){
		if(type.equals("student")){
			return "studentPage";
		}else if(type.equals("tutor")){
			return "tutorPage";
		}
		else{
			return "adminPage";		
		}
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public UserLoginService getUserLoginService() {
		return userLoginService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public KsCheckManager getKsCheckManager() {
		return ksCheckManager;
	}

	public void setKsCheckManager(KsCheckManager ksCheckManager) {
		this.ksCheckManager = ksCheckManager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
