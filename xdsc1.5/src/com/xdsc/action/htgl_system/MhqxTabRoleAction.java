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
import com.xdsc.model.MhqxTabRolefunction;
import com.xdsc.model.MhqxTabRolemodule;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleModuleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;

public class MhqxTabRoleAction extends ActionSupport{
	private int id;
	/**角色ID*/
	private int roleid;
	
	private List<MhqxTabRole> rolelist =new ArrayList<MhqxTabRole>();
	
	private List<String> rolenamelist = new ArrayList<String>();
	/**角色操作表对象*/
	private MhqxTabRoleManager rolemanager;
	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**角色对象*/
	private MhqxTabRole role;
	/**角色名称*/
	private String Rolename;
	
	private List<Integer> choosefunctionlist = new ArrayList<Integer>();
	
	private List<Integer> choosemodulelist = new ArrayList<Integer>();
	
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
	
	private List<MhqxTabFunction> functionlist = new ArrayList<MhqxTabFunction>();
	
	private List<Integer> deletelist = new ArrayList<Integer> ();
	
	private MhqxTabFunctionManager functionmanager;
	
	private MhqxTabModuleManager modulemanager;
	/**角色模块操作对象*/
	private MhqxTabRoleModuleManager rolemodulemanager;
	/**角色功能操作对象*/
	private MhqxTabRolefunctionManager rolefunctionmanager;
	/**用户角色表操作对象*/
	private MhqxTabRoleUserManager userrolemanager;
	/**用户功能表操作对象*/
	private MhqxTabUserfunctionManager userfunctionmanager;
	/**用户模块表操作对象*/
	private MhqxTabModuleuserManager moduleusermanager;
	
	private List<MhqxTabRolemodule> rolemodulelist = new ArrayList<MhqxTabRolemodule>();
	
	private List<MhqxTabRolemodule> unownrolemodulelist = new ArrayList<MhqxTabRolemodule>();
	
	private List<MhqxTabRolefunction> rolefunctionlist = new ArrayList<MhqxTabRolefunction>();
	
	private List<MhqxTabRolefunction> unownrolefunctionlist = new ArrayList<MhqxTabRolefunction>();
	
	public MhqxTabRoleModuleManager getRolemodulemanager() {
		return rolemodulemanager;
	}
	public void setRolemodulemanager(MhqxTabRoleModuleManager rolemodulemanager) {
		this.rolemodulemanager = rolemodulemanager;
	}
	public MhqxTabRolefunctionManager getRolefunctionmanager() {
		return rolefunctionmanager;
	}
	public void setRolefunctionmanager(
			MhqxTabRolefunctionManager rolefunctionmanager) {
		this.rolefunctionmanager = rolefunctionmanager;
	}
	public MhqxTabRoleUserManager getUserrolemanager() {
		return userrolemanager;
	}
	public void setUserrolemanager(MhqxTabRoleUserManager userrolemanager) {
		this.userrolemanager = userrolemanager;
	}
	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}
	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}
	public MhqxTabModuleuserManager getModuleusermanager() {
		return moduleusermanager;
	}
	public void setModuleusermanager(MhqxTabModuleuserManager moduleusermanager) {
		this.moduleusermanager = moduleusermanager;
	}
	public List<Integer> getDeletelist() {
		return deletelist;
	}
	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public MhqxTabRoleManager getRolemanager() {
		return rolemanager;
	}
	public void setRolemanager(MhqxTabRoleManager rolemanager) {
		this.rolemanager = rolemanager;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return Rolename;
	}
	public void setRolename(String rolename) {
		Rolename = rolename;
	}
	public List<MhqxTabRole> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<MhqxTabRole> rolelist) {
		this.rolelist = rolelist;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public MhqxTabRole getRole() {
		return role;
	}
	public void setRole(MhqxTabRole role) {
		this.role = role;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
    public List<String> getRolenamelist() {
		return rolenamelist;
	}
	public void setRolenamelist(List<String> rolenamelist) {
		this.rolenamelist = rolenamelist;
	}
	public List<MhqxTabRolemodule> getRolemodulelist() {
		return rolemodulelist;
	}
	public void setRolemodulelist(List<MhqxTabRolemodule> rolemodulelist) {
		this.rolemodulelist = rolemodulelist;
	}
	public List<MhqxTabRolefunction> getRolefunctionlist() {
		return rolefunctionlist;
	}
	public void setRolefunctionlist(List<MhqxTabRolefunction> rolefunctionlist) {
		this.rolefunctionlist = rolefunctionlist;
	}
	public List<MhqxTabRolemodule> getUnownrolemodulelist() {
		return unownrolemodulelist;
	}
	public void setUnownrolemodulelist(List<MhqxTabRolemodule> unownrolemodulelist) {
		this.unownrolemodulelist = unownrolemodulelist;
	}
	public List<MhqxTabRolefunction> getUnownrolefunctionlist() {
		return unownrolefunctionlist;
	}
	public void setUnownrolefunctionlist(
			List<MhqxTabRolefunction> unownrolefunctionlist) {
		this.unownrolefunctionlist = unownrolefunctionlist;
	}
	
	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}
	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
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
	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}
	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}
	
	public List<Integer> getChoosefunctionlist() {
		return choosefunctionlist;
	}
	public void setChoosefunctionlist(List<Integer> choosefunctionlist) {
		this.choosefunctionlist = choosefunctionlist;
	}
	public List<Integer> getChoosemodulelist() {
		return choosemodulelist;
	}
	public void setChoosemodulelist(List<Integer> choosemodulelist) {
		this.choosemodulelist = choosemodulelist;
	}
	/**
	 * <p>分页显示角色表<br>
	 * @return
	 */
	public String ShowRoleList()
    {    	
		this.rolelist = rolemanager.findAll();
		int pages = 10;
		int listlength = this.rolelist.size();
		if(listlength==0)
			return this.SUCCESS;
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
		this.rolelist = this.rolelist.subList(startIndex, endIndex);		
		return this.SUCCESS;
    }
	/**
	 * <p>转到用户角色配置页面<br>
	 * @return action result 
	 */
	public String configshowlist()
	{
		ShowRoleList();
		return "configshowlist";
	}
	/**
	 * <p>返回角色列表<br>
	 * @return action result 
	 */
    public String allrolelist()
    {
    	this.rolenamelist.clear();
    	this.rolelist = rolemanager.findAll();
    	Iterator<MhqxTabRole> prole = rolelist.iterator();
    	while(prole.hasNext())
    	{
    		this.rolenamelist.add(prole.next().getFRoleName());
    	}
    	return "allrole";
    }
    /**
	 * <p>删除单个角色，同时删除与角色有级联关系的相关条目<br>
	 * @return action result 
	 */
    public String deleterole()
    {
    	List<MhqxTabRolefunction> rolefunctionlist = new ArrayList<MhqxTabRolefunction>();
    	List<MhqxTabRolemodule> rolemodulelist = new ArrayList<MhqxTabRolemodule>();
    	List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction> ();
    	List<MhqxTabModuleuser> moduleuserlist = new ArrayList<MhqxTabModuleuser> ();
    	rolefunctionlist = this.rolefunctionmanager.findByRoleId(id);
    	rolemodulelist = this.rolemodulemanager.findByRoleId(id);
    	userfunctionlist = this.userfunctionmanager.findAll();
    	moduleuserlist = this.moduleusermanager.findAll();
    	Iterator<MhqxTabRolefunction> rolefunctioniterator = rolefunctionlist.iterator();
    	Iterator<MhqxTabRolemodule> rolemoduleiterator = rolemodulelist.iterator();
    	Iterator<MhqxTabUserfunction> userfunctioniterator = userfunctionlist.iterator();
    	Iterator<MhqxTabModuleuser> moduleuseriterator = moduleuserlist.iterator();
    	for(int i = 0;i<rolefunctionlist.size();i++)
    	{
    		for(int j=0;j<userfunctionlist.size();j++)
    		{
    			if(rolefunctionlist.get(i).getMhqxTabFunction().getFFunctionId()
    					.equals(userfunctionlist.get(j).getMhqxTabFunction().getFFunctionId()))
    			{
    				this.userfunctionmanager.delete(userfunctionlist.get(j));
    			}
    		}
    	}
    	
    	for(int m = 0;m<rolemodulelist.size();m++)
    	{
    		for(int n = 0;n<moduleuserlist.size();n++)
    		{
    			if(rolemodulelist.get(m).getMhqxTabModule().getFModuleId()
    					.equals(moduleuserlist.get(n).getMhqxTabModule().getFModuleId()))
    			{
    				this.moduleusermanager.delete(moduleuserlist.get(n));
    			}
    		}
    	}

    	MhqxTabRole role = (MhqxTabRole)this.rolemanager.findById(id);	
    	this.rolemanager.delete(role);
    	
    	return this.SUCCESS;
    }
    /**
	 * <p>多选删除角色，同时删除与角色有级联关系的相关条目<br>
	 * @return action result 
	 */
    public String multipledelete()
    {
    	MhqxTabRole role = new MhqxTabRole();
		if (this.deletelist.size()==0)
			return "multipledelete";
    	Iterator<Integer> iterator = this.deletelist.iterator();
    	int roleid = 0;
    	while(iterator.hasNext())
    	{
    		roleid = iterator.next();
        	List<MhqxTabRolefunction> rolefunctionlist = new ArrayList<MhqxTabRolefunction>();
        	List<MhqxTabRolemodule> rolemodulelist = new ArrayList<MhqxTabRolemodule>();
        	List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction> ();
        	List<MhqxTabModuleuser> moduleuserlist = new ArrayList<MhqxTabModuleuser> ();
        	rolefunctionlist = this.rolefunctionmanager.findByRoleId(roleid);
        	rolemodulelist = this.rolemodulemanager.findByRoleId(roleid);
        	userfunctionlist = this.userfunctionmanager.findAll();
        	moduleuserlist = this.moduleusermanager.findAll();
        	Iterator<MhqxTabRolefunction> rolefunctioniterator = rolefunctionlist.iterator();
        	Iterator<MhqxTabRolemodule> rolemoduleiterator = rolemodulelist.iterator();
        	Iterator<MhqxTabUserfunction> userfunctioniterator = userfunctionlist.iterator();
        	Iterator<MhqxTabModuleuser> moduleuseriterator = moduleuserlist.iterator();
        	for(int i = 0;i<rolefunctionlist.size();i++)
        	{
        		for(int j=0;j<userfunctionlist.size();j++)
        		{
        			if(rolefunctionlist.get(i).getMhqxTabFunction().getFFunctionId()
        					.equals(userfunctionlist.get(j).getMhqxTabFunction().getFFunctionId()))
        			{
        				this.userfunctionmanager.delete(userfunctionlist.get(j));
        			}
        		}
        	}
        	
        	for(int m = 0;m<rolemodulelist.size();m++)
        	{
        		for(int n = 0;n<moduleuserlist.size();n++)
        		{
        			if(rolemodulelist.get(m).getMhqxTabModule().getFModuleId()
        					.equals(moduleuserlist.get(n).getMhqxTabModule().getFModuleId()))
        			{
        				this.moduleusermanager.delete(moduleuserlist.get(n));
        			}
        		}
        	}
    		role=this.rolemanager.findById(roleid);
    		this.rolemanager.delete(role);
    	}
    	return "multipledelete";
    }
    /**
	 * <p>添加角色<br>
	 * @return action result 
	 */
    public String addrole()
    {
    	List<MhqxTabRole> rolelist = this.rolemanager.findByName(Rolename);
    	if(rolelist.size()==0){
    	MhqxTabRole role = new MhqxTabRole();
    	role.setFRoleName(Rolename);
    	this.rolemanager.save(role);
       	}
    	return this.SUCCESS;
    }
    /**
     * 角色输入项的验证
     */
    public void validateAddrole()
    {
    	if(this.Rolename.equals("")||this.Rolename==null)
    	{
    		addFieldError("Rolename","不能为空");
    	}
    }
    /**
	 * <p>修改角色<br>
	 * @return action result 
	 */
    public String modrole()
    {
    	this.role = this.rolemanager.findById(id);
    	return this.SUCCESS;
    }
    /**
	 * <p>更新角色<br>
	 * @return action result 
	 */
    public String updaterole()
    {
    	this.rolemanager.update(role);
    	return this.SUCCESS;
    }
    /**
     * 查看角色权限
     */
    public String showroledetail()
    {
//    	System.out.println(roleid);
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
    	this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(roleid);
    	this.rolemodulelist = this.rolemodulemanager.findByRoleId(roleid);
    	String rolename = this.rolemanager.findById(roleid).getFRoleName();
    	session.setAttribute("rolename", rolename);
    	this.modulelist = this.modulemanager.findAll();
    	this.functionlist = this.functionmanager.findByRoleName(rolename);
    	for(int i = 0;i<this.rolefunctionlist.size();i++)
    	{
    		for(int j = 0;j<this.functionlist.size();j++)
    		{
    			if(this.rolefunctionlist.get(i).getMhqxTabFunction().getFFunctionId()
    				.equals(this.functionlist.get(j).getFFunctionId()))
    			{
    				this.functionlist.remove(j);
    				break;
    			}
    		}
    	}
    	for(int m = 0;m<this.rolemodulelist.size();m++)
    	{
    		for(int n=0;n<this.modulelist.size();n++)
    		{
    			if(this.modulelist.get(n).getFModuleId()
    					.equals(this.rolemodulelist.get(m).getMhqxTabModule().getFModuleId()))
    			{
    				this.modulelist.remove(n);
    			}
    		}
    	}
    	return "showroledetail";
    }
    public String updateroledetail()
    {
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	this.role = this.rolemanager.findByName((String)session.getAttribute("rolename")).iterator().next();
    	MhqxTabRolefunction rolefunction = new MhqxTabRolefunction();
    	MhqxTabRolemodule rolemodule = new MhqxTabRolemodule();
    	MhqxTabModule module = new MhqxTabModule();
    	MhqxTabFunction function = new MhqxTabFunction();
    	this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(this.role.getFRoleId());
    	this.rolemodulelist = this.rolemodulemanager.findByRoleId(this.role.getFRoleId());
    	for(int i = 0;i<this.rolefunctionlist.size();i++)
    	{
    		this.rolefunctionmanager.delete(this.rolefunctionlist.get(i));
    	}
    	for(int i = 0;i<this.rolemodulelist.size();i++)
    	{
    		this.rolemodulemanager.delete(this.rolemodulelist.get(i));
    	}
    	
    	for(int i = 0;i<this.choosefunctionlist.size();i++)
    	{
    		
    		function = this.functionmanager.findById(this.choosefunctionlist.get(i));
    		rolefunction.setMhqxTabFunction(function);
    		rolefunction.setMhqxTabRole(role);
    		this.rolefunctionmanager.save(rolefunction);
    	}
    	System.out.println("this.choosefunctionlist.size()"+this.choosefunctionlist.size());
    	System.out.println("this.choosemodulelist.size()"+this.choosemodulelist.size());
    	for(int i = 0;i<this.choosemodulelist.size();i++)
    	{
    		
    		module = this.modulemanager.findById(this.choosemodulelist.get(i));
    		rolemodule.setMhqxTabRole(role);
    		rolemodule.setMhqxTabModule(module);
    		this.rolemodulemanager.save(rolemodule);
    	}
    	return "updateroledetail";
    }
}
