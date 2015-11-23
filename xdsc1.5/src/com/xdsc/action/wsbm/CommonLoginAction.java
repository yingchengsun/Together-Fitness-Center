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


/**��½ϵͳ
 * @author ��С��
 *@version 1.2
 */
public class CommonLoginAction extends ActionSupport implements SessionAware{

	/**
	 * session�������
	 */
	private Map session;
	
	/**
	 * service���������
	 */
	private UserLoginService userLoginService;
	private KsCheckManager ksCheckManager;
	
	/**
	 * ��½��Ҫ�ύ���������
	 */
	private String name;
	private String userName;
	
	private String password;
	
	private String type;
	



	/**ϵͳ�û���½
	 * @return appLogin ������½ϵͳ�ɹ�
	 * @return loginFalse ���������Ϣ��֤ʧ��
	 * @return adLogin ����Ա��½ϵͳ�ɹ�
	 * @return norole ��ɫƥ��ʧ��
	 * @return nouser �޴��û�
	 */
	public String execute(){ 
		System.out.println("start login******************");//�û���½
		MhqxTabUser user=new MhqxTabUser();
		user.setFUserNumber(name);
		//user.setFUserPassword(password);
		System.out.println("check*********************");
		if(userLoginService.UserIsValide(user)){          //���ж��û��Ƿ����
			System.out.println("user valid");
			type="app";
			if(type.equals("app")){               //�ж���ѧ�����Ǹ���Ա���ǹ���Ա
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
	
	/**ת�������ҳ
	 * @return studentPage ת��������ҳ
	 * @return tutorPage ת��������ҳ
	 * @return adminPage ת������Ա��ҳ
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
