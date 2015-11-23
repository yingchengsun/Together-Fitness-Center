package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;

public class MhqxTabUserFunctionAction extends ActionSupport {

	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**错误提示消息*/
	private String message = new String("");
	
	private int id;
	/**模块ID*/
	private int moduleid;
	/**角色名称*/
	private String rolename;
	/**用户账号*/
	private String usernumber;
	/**功能ID*/
	private int functionid;
	/**用户对象*/
	private MhqxTabUser user;
	/**功能对象*/
	private MhqxTabFunction function;
	
	private List<MhqxTabFunction> functionlist = new ArrayList();
	/**用户功能对象*/
	private MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
	/**功能表操作对象*/
	private MhqxTabFunctionManager functionmanager;
	/**模块表操作对象*/
	private MhqxTabModuleManager modulemanager;
	/**用户表操作对象*/
	private MhqxTabUserManager usermanager;
	/**角色表操作对象*/
	private MhqxTabRoleManager rolemanager;
	/***/
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
	
	private List<MhqxTabRole> rolelist = new ArrayList<MhqxTabRole>();
	
	private List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction> ();
	
	private List<Integer> deletelist = new ArrayList<Integer> ();
	/**用户功能表操作对象*/
	private MhqxTabUserfunctionManager userfunctionmanager;
	
	private List<Integer> chooselist = new ArrayList<Integer> ();
	
	private List<Integer> chooselist2 = new ArrayList<Integer> ();
	
	private List<MhqxTabModuleuser> usermodulelist = new ArrayList<MhqxTabModuleuser>(); 
	
	private MhqxTabModuleuserManager usermodulemanager ;
		
	public List<Integer> getDeletelist() {
		return deletelist;
	}

	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
	}

	public MhqxTabUserfunction getUserfunction() {
		return userfunction;
	}

	public void setUserfunction(MhqxTabUserfunction userfunction) {
		this.userfunction = userfunction;
	}

	public MhqxTabFunctionManager getFunctionmanager() {
		return functionmanager;
	}

	public void setFunctionmanager(MhqxTabFunctionManager functionmanager) {
		this.functionmanager = functionmanager;
	}

	public MhqxTabUserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(MhqxTabUserManager usermanager) {
		this.usermanager = usermanager;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public int getFunctionid() {
		return functionid;
	}

	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}

	public MhqxTabUser getUser() {
		return user;
	}

	public void setUser(MhqxTabUser user) {
		this.user = user;
	}

	public MhqxTabFunction getFunction() {
		return function;
	}

	public void setFunction(MhqxTabFunction function) {
		this.function = function;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModuleid() {
		return moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public MhqxTabRoleManager getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(MhqxTabRoleManager rolemanager) {
		this.rolemanager = rolemanager;
	}

	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}

	public List<MhqxTabRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<MhqxTabRole> rolelist) {
		this.rolelist = rolelist;
	}

	public List<MhqxTabUserfunction> getUserfunctionlist() {
		return userfunctionlist;
	}

	public void setUserfunctionlist(List<MhqxTabUserfunction> userfunctionlist) {
		this.userfunctionlist = userfunctionlist;
	}

	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}

	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}
	
	
	public List<MhqxTabFunction> getFunctionlist() {
		return functionlist;
	}

	public void setFunctionlist(List<MhqxTabFunction> functionlist) {
		this.functionlist = functionlist;
	}

	
	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}

	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}
	
	public List<Integer> getChooselist() {
		return chooselist;
	}

	public void setChooselist(List<Integer> chooselist) {
		this.chooselist = chooselist;
	}
	
	public List<Integer> getChooselist2() {
		return chooselist2;
	}

	public void setChooselist2(List<Integer> chooselist2) {
		this.chooselist2 = chooselist2;
	}

	public List<MhqxTabModuleuser> getUsermodulelist() {
		return usermodulelist;
	}

	public void setUsermodulelist(List<MhqxTabModuleuser> usermodulelist) {
		this.usermodulelist = usermodulelist;
	}

	public MhqxTabModuleuserManager getUsermodulemanager() {
		return usermodulemanager;
	}

	public void setUsermodulemanager(MhqxTabModuleuserManager usermodulemanager) {
		this.usermodulemanager = usermodulemanager;
	}
	/**
	 * 根据用户账号查找他所拥有的功能
	 * @return action result
	 */
	public String searchUserFunctionRelation()
	{
		this.userfunctionlist = this.userfunctionmanager.findMhqxTabUserfunctionByUserNumber(usernumber);
		return "searchUserFunctionRelation";
	}
	/**
	 * <p>分页显示用户功能列表<br>
	 * @return action result 
	 */
	public String showlist()
	{
		this.userfunctionlist = this.userfunctionmanager.findAll();
		System.out.println("---------");
		int pages = 20;
		int listlength = this.userfunctionlist.size();
		if(listlength==0)
			return "showlist";
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
		this.userfunctionlist = this.userfunctionlist.subList(startIndex, endIndex);
		System.out.println("user--role number:"+this.userfunctionlist.size());
		return "showlist";
	}
	/**
	 * <p>配置用户功能<br>
	 * @return action result 
	 */
	public String saveUserFunctionRelation()
	{
		this.user = this.usermanager.findById(usernumber).iterator().next();
		if(this.user==null)
			return "saveUserFunctionRelation";
		Iterator<Integer> iterator = this.deletelist.iterator();
		int i = 1;
		while(iterator.hasNext())
		{
			int flag = 0;
			this.function = this.functionmanager.findById(iterator.next());
			this.userfunctionlist = this.userfunctionmanager.findAll();
			Iterator<MhqxTabUserfunction> iteratoruserfunction = this.userfunctionlist.iterator();
			
			while(iteratoruserfunction.hasNext())
			{
				this.userfunction = iteratoruserfunction.next();
				
				System.out.println(i+"====in iteratoruserfunction.hasNext()");
				System.out.println(this.userfunction.getMhqxTabFunction().getFFunctionId());
				System.out.println(function.getFFunctionId());
				System.out.println(this.userfunction.getMhqxTabUser().getFUserNumber());
				System.out.println(usernumber);
				if(this.userfunction.getMhqxTabUser().getFUserNumber().equals(usernumber))
				{
					System.out.println("555555555555555");
				}
				
				if(this.userfunction.getMhqxTabFunction().getFFunctionId().equals(this.function.getFFunctionId()))
				{
					System.out.println("4444444444444");
					flag = 1 ;
					break;
				}
			}
			if(flag==0)
			{
				this.userfunction.setMhqxTabFunction(function);
				this.userfunction.setMhqxTabUser(user);
				this.userfunctionmanager.save(userfunction);
			}
			i++;
		}
		
		return "saveUserFunctionRelation";
	}
	/**
	 * <p>删除单个用户功能条目<br>
	 * @return action result 
	 */
	public String deleteUserFunctionRelation()
	{
		this.userfunction = this.userfunctionmanager.findById(id);
		this.userfunctionmanager.delete(userfunction);
		return "deleteUserFunctionRelation";
	}
	/**
	 * <p>多选删除用户功能条目<br>
	 * @return action result 
	 */
	public String multipledelete()
	{
		Iterator<Integer> iterator = deletelist.iterator();
		
		if(!iterator.hasNext())
			return "multipledelete";
		
		while(iterator.hasNext())
		{
			this.userfunction = this.userfunctionmanager.findById(iterator.next());
			this.userfunctionmanager.delete(userfunction);
		}
		return "multipledelete";
	}
	/**
	 * <p>修改用户功能条目<br>
	 * @return action result 
	 */
	public String modifyUserFunctionRelation()
	{
		this.userfunction = this.userfunctionmanager.findById(id);
		this.usernumber = this.userfunction.getMhqxTabUser().getFUserNumber();
		this.functionid = this.userfunction.getMhqxTabFunction().getFFunctionId();
		return "modifyUserFunctionRelation";
	}
	/**
	 * <p>更新用户功能条目<br>
	 * @return action result 
	 */
	public String updateUserFunctionRelation()
	{
		this.userfunction = this.userfunctionmanager.findById(id);
		this.user = this.usermanager.findById(this.usernumber).iterator().next();
		this.function = this.functionmanager.findById(this.functionid);
		this.userfunction.setMhqxTabFunction(this.function);
		this.userfunction.setMhqxTabUser(this.user);
		return "updateUserFunctionRelation";
	}
	/**
	 * <p>配置用户功能<br>
	 * @return action result 
	 */
	public String UserFunctionConfig()
	{
		this.modulelist = this.modulemanager.findAll();
		this.rolelist = this.rolemanager.findAll();
		if(this.rolename==null&&this.moduleid==0)
		{
//			this.functionlist = this.functionmanager.findAll();
			return "UserFunctionConfig";
		}
		else
		{
			List<MhqxTabFunction> functionlist1 = new ArrayList<MhqxTabFunction>();
			List<MhqxTabFunction> functionlist2 = new ArrayList<MhqxTabFunction>();
			List<MhqxTabFunction> functionlist3 = new ArrayList<MhqxTabFunction>();
			functionlist1 = this.functionmanager.findByModuleidandRolename(moduleid, rolename);
			Iterator<MhqxTabFunction> iterator1 = functionlist1.iterator();
			while(iterator1.hasNext())
			{
				MhqxTabFunction function = new MhqxTabFunction();
				function = iterator1.next();
				if(function.getFSuperFunctionId()==0)
					functionlist2.add(function);				
			}
			Iterator<MhqxTabFunction> iterator2 = functionlist2.iterator();
			while(iterator2.hasNext())
			{
				function = iterator2.next();
				functionlist3.add(function);
				List<MhqxTabFunction> functionlist4 = this.functionmanager.findBySuperId(function.getFFunctionId());
				Iterator<MhqxTabFunction> iterator4 = functionlist4.iterator();
				while(iterator4.hasNext())
				{
					functionlist3.add(iterator4.next());
				}
			}
			this.functionlist = functionlist3;
		}
		int pages = 20;
		int listlength = this.functionlist.size();
		if(listlength==0)
		{
			this.modulelist = this.modulemanager.findAll();
			System.out.println("module number :"+modulelist.size());
			return "UserFunctionConfig";
		}
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
		this.functionlist = this.functionlist.subList(startIndex, endIndex);
		this.modulelist = this.modulemanager.findAll();
		System.out.println("module number :"+modulelist.size());
		Iterator<MhqxTabFunction> iterator1 = this.functionlist.iterator();
		Iterator<MhqxTabFunction> iterator2 = this.functionlist.iterator();
		int moduleid;
		MhqxTabModule module = new MhqxTabModule();
		while(iterator1.hasNext())
		{ 
			moduleid = iterator1.next().getMhqxTabModule().getFModuleId();
			module = this.modulemanager.findById(moduleid);
		    iterator2.next().setMhqxTabModule(module);
		}
		return "UserFunctionConfig";
	}
	public String UserFunctionConfig2()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		String usernumber = (String)session.getAttribute("FUserNumber");
		this.user = this.usermanager.findById(usernumber).iterator().next();
//		System.out.println("++++++++++++++ :    "+this.chooselist.size());
		Iterator<Integer> iterator = this.chooselist.iterator();
		this.userfunctionlist = this.userfunctionmanager.findMhqxTabUserfunctionByUserNumber(usernumber);
		for(int i = 0; i<this.userfunctionlist.size(); i++)
		{
//			System.out.println(this.userfunctionlist.get(i).getFId());
			this.userfunctionmanager.delete(this.userfunctionlist.get(i));
		}
		while(iterator.hasNext())
		{
			this.userfunction.setMhqxTabUser(user);
			int funid = iterator.next();
//			System.out.println("==========");
//			System.out.println(funid);
			this.function = this.functionmanager.findById(funid);
			this.userfunction.setMhqxTabFunction(this.function);
			this.userfunctionmanager.save(this.userfunction);
		}
		this.usermodulelist = this.usermodulemanager.findMhqxTabModuleuserByUserNumber(usernumber);
		for(int j = 0;j<this.usermodulelist.size();j++)
		{
			this.usermodulemanager.delete(this.usermodulelist.get(j));
		}
		MhqxTabModule module = new MhqxTabModule();
		MhqxTabModuleuser usermodule = new MhqxTabModuleuser();
		for(int k = 0;k<this.chooselist2.size();k++)
		{
			System.out.println(this.chooselist2.get(k));
			module = this.modulemanager.findById(this.chooselist2.get(k));
			usermodule.setMhqxTabUser(this.user);
			usermodule.setMhqxTabModule(module);
			this.usermodulemanager.save(usermodule);
		}
		this.chooselist.clear();
		this.chooselist2.clear();
		this.usernumber = null;
		return "UserFunctionConfig2";
	}
}
