package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
/**
 * 功能操作相关Action
 * @version 1.1
 * @author WenboTse
 */
public class MhqxTabFunctionAction extends ActionSupport {
	/**功能名称*/
	private String functionname;
	/**模块ID*/
	private int moduleid;
	/**角色ID*/
	private int roleid;
	/**角色名称*/
	private String rolename;
	/**功能ID*/
	private int pfunctionid;
	/**功能所属角色*/
	private String functionmark;
	/**功能URL*/
	private String url;
	/**是否为叶子*/
	private String isleaf;
	/**优先级*/
	private int priority;
	/**模块名称*/
	private String modulename;
	
	private MhqxTabFunction function ;
	/**功能操作对象*/
	private MhqxTabFunctionManager functionmanager;
	/**角色操作对象*/
	private MhqxTabRoleManager rolemanager;
	
	private List<MhqxTabRole> rolelist = new ArrayList<MhqxTabRole>();
	/**模块操作对象*/
	private MhqxTabModuleManager modulemanager;
	
	private List<MhqxTabFunction> functionlist = new ArrayList<MhqxTabFunction> ();
	
	private List<Integer> deletelist = new ArrayList<Integer> ();
	
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
	/**分页显示的页码*/
	private int p = 1;
	/**末页数*/
	private int lastPage;
	
	private int id;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getFunctionname() {
		return functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public int getModuleid() {
		return moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public int getPfunctionid() {
		return pfunctionid;
	}

	public void setPfunctionid(int pfunctionid) {
		this.pfunctionid = pfunctionid;
	}

	public String getFunctionmark() {
		return functionmark;
	}

	public void setFunctionmark(String functionmark) {
		this.functionmark = functionmark;
	}

	
	public String getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MhqxTabFunction> getFunctionlist() {
		return functionlist;
	}

	public void setFunctionlist(List<MhqxTabFunction> functionlist) {
		this.functionlist = functionlist;
	}

	public MhqxTabFunctionManager getFunctionmanager() {
		return functionmanager;
	}

	public void setFunctionmanager(MhqxTabFunctionManager functionmanager) {
		this.functionmanager = functionmanager;
	}

	public MhqxTabFunction getFunction() {
		return function;
	}

	public void setFunction(MhqxTabFunction function) {
		this.function = function;
	}
	
	
	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}

	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}

	public List<Integer> getDeletelist() {
		return deletelist;
	}

	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
	}
	
	public MhqxTabRoleManager getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(MhqxTabRoleManager rolemanager) {
		this.rolemanager = rolemanager;
	}

	public List<MhqxTabRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<MhqxTabRole> rolelist) {
		this.rolelist = rolelist;
	}

	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}

	/**
	 * <p>添加功能 <br>
	 * @return action result
	 */
	public String addfunction()
	{		
		this.function.setMhqxTabModule(this.modulemanager.findById(this.function.getMhqxTabModule().getFModuleId()));
		this.function.setFFunctionMark(this.rolename);
		this.functionmanager.save(function);
		return "addfunction";
	}
	/**
	 * 功能添加验证
	 */
	public void validateAddfunction()
	{
		this.clearFieldErrors();
		if(this.function.getFFunctionId()==null||this.function.getFFunctionId()==0)
		{
			System.out.println(this.function.getFFunctionId());
			addFieldError("function.FFunctionId","不能为空");
		}
		if(this.function.getFFunctionName()==null||this.function.getFFunctionName().equals(""))
		{
			addFieldError("function.FFunctionName","不能为空");
		}
		if(this.function.getFSuperFunctionId()==null||this.function.getFSuperFunctionId().equals(""))
		{
			addFieldError("function.FSuperFunctionId","不能为空");
		}
		if(this.function.getFFunctionName()==null||this.function.getFFunctionName().equals(""))
		{
			addFieldError("function.FFilePath","不能为空");
		}
	}
	/**
	 * 多选删除功能
	 * @return action result
	 */
	public String multipledelete()
	{
		System.out.println("FunctionMutipleDelete");
		MhqxTabFunction function = new MhqxTabFunction();
		Iterator<Integer> iterator = this.deletelist.iterator();
		if(!iterator.hasNext())
			return "multipledelete";
		while(iterator.hasNext())
		{
			function = this.functionmanager.findById(iterator.next());
			this.functionmanager.delete(function);
		}
		return "multipledelete";
	}
	/**
	 * 删除单个功能
	 * @return action result
	 */
	public String deletefunction()
	{
		System.out.println("deletefunction");
		this.function = this.functionmanager.findById(id);
		this.functionmanager.delete(function);
		return "deletefunction";
	}
	/**
	 * <p>修改功能<br>
	 * @return action result
	 */
	public String modifyfunction()
	{
		this.function = this.functionmanager.findById(id);
		
		this.functionname = this.function.getFFunctionName();
		this.pfunctionid = this.function.getFSuperFunctionId();
		this.url = this.function.getFFilePath();
		this.functionmark = this.function.getFFunctionMark();
		this.moduleid = this.function.getMhqxTabModule().getFModuleId();
		System.out.println(this.functionname);
		System.out.println(this.url);
		
		return "modifyfunction";
	}
	/**
	 * 更新功能
	 * @return action result
	 */
	public String updatefunction()
	{
		this.function.setFFilePath(url);
		this.function.setFFunctionName(functionname);
		this.function.setFFunctionMark(rolename);
		this.function.setFSuperFunctionId(pfunctionid);
		this.function.setMhqxTabModule(this.modulemanager.findById(moduleid));
		this.functionmanager.update(function);
		return "updatefunction";
	}
	/**
	 * <p>按照角色子-系统分类显示功能列表<br>
	 * @return action result
	 */
	public String showfunctionlist()
	{
		
		
		this.modulelist = this.modulemanager.findAll();
		this.rolelist = this.rolemanager.findAll();
		if(this.roleid==0&&this.moduleid==0)
		{
//			this.functionlist = this.functionmanager.findAll();
		}
		else
		{
			//按角色子系统分类查询
			List<MhqxTabFunction> functionlist1 = new ArrayList<MhqxTabFunction>();
			/*
			 * functionlist2 store the functions that superId is 0
			 * functionlist3 store the functions that super-function after with its sub-function
			 */
			List<MhqxTabFunction> functionlist2 = new ArrayList<MhqxTabFunction>();
			List<MhqxTabFunction> functionlist3 = new ArrayList<MhqxTabFunction>();
			functionlist1 = this.functionmanager.findByModuleidandRolename(moduleid, rolename);
			System.out.println("================"+moduleid+"===="+rolename+"===="+functionlist1.size());
			//functionlist2 = this.functionmanager.findBySuperId(0);
			
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
//			System.out.println("module number :"+modulelist.size());
			return "functionlist";
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
		System.out.println(this.functionlist.size());
		return "functionlist";
	}	
	/**
	 * <p>用于跳转到配置页面<br>
	 * @return action result
	 */
	public String configfunctionlist()
	{
		showfunctionlist();
		return "configfunctionlist";
	}
	/**
	 * <p>得到角色列表<br>
	 *    得到功能列表<br>
	 * @return action result
	 */
	public String rolefunctionconfiglist()
	{
		
		System.out.println("rolefunctionconfiglist======"+this.rolename+"========"+this.modulename);
		this.modulelist = this.modulemanager.findAll();
		this.rolelist = this.rolemanager.findAll();
		if(this.modulemanager.findByName(this.modulename).size()!=0)
		{
			this.moduleid = this.modulemanager.findByName(this.modulename).iterator().next().getFModuleId();
		}
		
		if(this.roleid==0&&this.moduleid==0)
		{
//			this.functionlist = this.functionmanager.findAll();
		}
		else
		{
			//按角色子系统分类查询
			List<MhqxTabFunction> functionlist1 = new ArrayList<MhqxTabFunction>();
			/*
			 * functionlist2 store the functions that superId is 0
			 * functionlist3 store the functions that super-function after with its sub-function
			 */
			List<MhqxTabFunction> functionlist2 = new ArrayList<MhqxTabFunction>();
			List<MhqxTabFunction> functionlist3 = new ArrayList<MhqxTabFunction>();
			functionlist1 = this.functionmanager.findByModuleidandRolename(moduleid, rolename);
			//functionlist2 = this.functionmanager.findBySuperId(0);
			
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
					this.function = iterator4.next();
					System.out.println(this.function.getFFunctionName()+"--"+this.function.getFFunctionMark()+"--"+this.function.getMhqxTabModule().getFModuleName());
					functionlist3.add(this.function);
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
			return "rolefunctionconfiglist";
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
		System.out.println(this.functionlist.size());
		
		return "rolefunctionconfiglist";
	}
	public String showbysystermrole()
	{
		return "showbysystermrole";
	}
	public String insertfunction()
	{
		this.modulelist = this.modulemanager.findAll();
		this.rolelist = this.rolemanager.findAll();
		return "insertfunction";
	}
	public String showfunctionlist2()
	{
		
		System.out.println("showfunctionlist2======"+this.rolename+"========"+this.modulename);
		this.modulelist = this.modulemanager.findAll();
		this.rolelist = this.rolemanager.findAll();
		MhqxTabModule module = new MhqxTabModule();
		this.moduleid = this.modulemanager.findByName(this.modulename).iterator().next().getFModuleId();
		if(this.roleid==0&&this.moduleid==0)
		{
//			this.functionlist = this.functionmanager.findAll();
		}
		else
		{
			//按角色子系统分类查询
			List<MhqxTabFunction> functionlist1 = new ArrayList<MhqxTabFunction>();
			/*
			 * functionlist2 store the functions that superId is 0
			 * functionlist3 store the functions that super-function after with its sub-function
			 */
			List<MhqxTabFunction> functionlist2 = new ArrayList<MhqxTabFunction>();
			List<MhqxTabFunction> functionlist3 = new ArrayList<MhqxTabFunction>();
			functionlist1 = this.functionmanager.findByModuleidandRolename(moduleid, rolename);
			//functionlist2 = this.functionmanager.findBySuperId(0);
			
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
			return "functionlist";
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
		return "functionlist";
	}	
}
