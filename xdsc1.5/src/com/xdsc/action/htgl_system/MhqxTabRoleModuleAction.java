package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabRolemodule;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleModuleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
/***
 * <p>角色模块表操作相关的action<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRoleModuleAction extends ActionSupport {
	
	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**错误提示消息*/
	private String message = new String("");
	
	private int id;
	/**角色ID*/
	private int roleid;
	/**模块ID*/
	private int moduleid;
	/**角色对象*/
	private MhqxTabRole role;
	/**模块对象*/
	private MhqxTabModule module;
	/**角色模块对象*/
	private MhqxTabRolemodule rolemodule = new MhqxTabRolemodule();
	/**模块表操作对象*/
	private MhqxTabModuleManager modulemanager;
	/**角色表操作对象*/
	private MhqxTabRoleManager rolemanager;
	/**角色模块表操作对象*/
	private MhqxTabRoleModuleManager rolemodulemanager;
	/**用户模块表操作对象*/
	private MhqxTabModuleuserManager moduleusermanager;
	/**用户角色表操作对象*/
	private MhqxTabRoleUserManager userrolemanager;

	private List<MhqxTabRolemodule> rolemodulelist = new ArrayList<MhqxTabRolemodule>();
	
	private List<MhqxTabRole> rolelist = new ArrayList<MhqxTabRole>();
	
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
	
	private List<Integer> deletelist = new ArrayList<Integer> ();
	
	

	public MhqxTabModuleuserManager getModuleusermanager() {
		return moduleusermanager;
	}

	public void setModuleusermanager(MhqxTabModuleuserManager moduleusermanager) {
		this.moduleusermanager = moduleusermanager;
	}

	public MhqxTabRoleUserManager getUserrolemanager() {
		return userrolemanager;
	}

	public void setUserrolemanager(MhqxTabRoleUserManager userrolemanager) {
		this.userrolemanager = userrolemanager;
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

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getModuleid() {
		return moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public MhqxTabRole getRole() {
		return role;
	}

	public void setRole(MhqxTabRole role) {
		this.role = role;
	}

	public MhqxTabModule getModule() {
		return module;
	}

	public void setModule(MhqxTabModule module) {
		this.module = module;
	}

	public MhqxTabRolemodule getRolemodule() {
		return rolemodule;
	}

	public void setRolemodule(MhqxTabRolemodule rolemodule) {
		this.rolemodule = rolemodule;
	}

	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}

	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}

	public MhqxTabRoleManager getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(MhqxTabRoleManager rolemanager) {
		this.rolemanager = rolemanager;
	}

	public MhqxTabRoleModuleManager getRolemodulemanager() {
		return rolemodulemanager;
	}

	public void setRolemodulemanager(MhqxTabRoleModuleManager rolemodulemanager) {
		this.rolemodulemanager = rolemodulemanager;
	}

	public List<MhqxTabRolemodule> getRolemodulelist() {
		return rolemodulelist;
	}

	public void setRolemodulelist(List<MhqxTabRolemodule> rolemodulelist) {
		this.rolemodulelist = rolemodulelist;
	}

	public List<Integer> getDeletelist() {
		return deletelist;
	}

	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
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
	 * <p>分页显示角色模块表<br>
	 * @return action result
	 */
	public String showlist()
	{
		System.out.println("in the showlist .....");
		this.rolelist = this.rolemanager.findAll();
		int pages = 10;
		int listlength = this.rolemodulelist.size();
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
		this.rolemodulelist = this.rolemodulelist.subList(startIndex, endIndex);
		System.out.println("user--role number:"+this.rolemodulelist.size());
		return "showlist";
	}
	public String getrolemodulebysearch()
	{
		System.out.println("==============");
		this.rolemodulelist = this.rolemodulemanager.findByRoleId(roleid);
		return "getrolemodulebysearch";
	}
	/**
	 * <p>配置角色模块<br>
	 * @return action result
	 */
	public String saveRoleModuleRelation()
	{
		MhqxTabUser user = new MhqxTabUser();
		MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
		MhqxTabRolemodule rolemodule = new MhqxTabRolemodule();
		this.role = this.rolemanager.findById(roleid);
		Iterator<Integer> iterator = deletelist.iterator();
		int flag = 0;
		while(iterator.hasNext())
		{
			    flag = 0;
			    this.module = this.modulemanager.findById(iterator.next());
			    Iterator<MhqxTabRolemodule> iterator2 = this.rolemodulemanager.findByRoleId(roleid).iterator();
				while(iterator2.hasNext())
				{
					    rolemodule = iterator2.next();
						if(rolemodule.getMhqxTabModule().getFModuleName().equals(this.module.getFModuleName())
								&&rolemodule.getMhqxTabRole().getFRoleName().equals(this.role.getFRoleName()))
						{
							System.out.println("same role module continue");
							flag = 1;
							break;
						}
				}
			    if(flag==1)continue;
				this.rolemodule.setMhqxTabRole(this.role);
				this.rolemodule.setMhqxTabModule(this.module);	
			    this.rolemodulemanager.save(this.rolemodule);
				Iterator<MhqxTabRoleuser> roleuseriterator = this.userrolemanager.findByRoleId(roleid).iterator();
				while(roleuseriterator.hasNext())
				{
					user = roleuseriterator.next().getMhqxTabUser();
					moduleuser.setMhqxTabModule(this.module);
					moduleuser.setMhqxTabUser(user);						
					this.moduleusermanager.save(moduleuser);
				}
		}
		return "saveRoleModuleRelation";
	}
	/**
	 * <p>删除单个角色模块条目<br>
	 * @return action result
	 */
	public String deleteRoleModuleRelation()
	{
		this.rolemodule = this.rolemodulemanager.findById(id);
		this.rolemodulemanager.delete(this.rolemodule);
		MhqxTabUser user = new MhqxTabUser();
		MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
		Iterator<MhqxTabRoleuser> roleuseriterator = this.userrolemanager.findByRoleId(roleid).iterator();
		while(roleuseriterator.hasNext())
		{
			user = roleuseriterator.next().getMhqxTabUser();
			Iterator<MhqxTabModuleuser> moduleuseriterator = this.moduleusermanager.findMhqxTabModuleuserByUserNumber(user.getFUserNumber()).iterator();
			while(moduleuseriterator.hasNext())
			{
				moduleuser = moduleuseriterator.next();
				if(moduleuser.getMhqxTabModule().getFModuleName().equals(this.module.getFModuleName()))
				{
					this.moduleusermanager.delete(moduleuser);
				}
			}
		}
		
		return "deleteRoleModuleRelation";
	}
	/**
	 * <p>多选删除角色模块条目<br>
	 * @return action result
	 */
	public String multipledelete()
	{
		if (this.deletelist.size()==0)
			return "multipledelete";
		MhqxTabUser user = new MhqxTabUser();
		MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
		Iterator<Integer> iterator = deletelist.iterator();
		while(iterator.hasNext())
		{
			this.rolemodule = this.rolemodulemanager.findById(iterator.next());
			this.rolemodulemanager.delete(rolemodule);
			this.roleid = this.rolemodule.getMhqxTabRole().getFRoleId();
			this.module = this.rolemodule.getMhqxTabModule();
			Iterator<MhqxTabRoleuser> roleuseriterator = this.userrolemanager.findByRoleId(roleid).iterator();
			while(roleuseriterator.hasNext())
			{
				user = roleuseriterator.next().getMhqxTabUser();
				Iterator<MhqxTabModuleuser> moduleuseriterator = this.moduleusermanager.findMhqxTabModuleuserByUserNumber(user.getFUserNumber()).iterator();
				while(moduleuseriterator.hasNext())
				{
					moduleuser = moduleuseriterator.next();
					if(moduleuser.getMhqxTabModule().getFModuleName().equals(this.module.getFModuleName()))
					{
						this.moduleusermanager.delete(moduleuser);
					}
				}
			}
		}
		return "multipledelete";
	}
	/**
	 * <p>修改角色模块条目<br>
	 * @return action result
	 */
	public String modifyRoleModuleRelation()
	{
		this.rolemodule = this.rolemodulemanager.findById(id);
		this.roleid = this.rolemodule.getMhqxTabRole().getFRoleId();
		this.moduleid = this.rolemodule.getMhqxTabModule().getFModuleId();
		return "modifyRoleModuleRelation";
	}
	/**
	 * <p>更新角色模块条目<br>
	 * @return action result
	 */
	public String updateRoleModuleRelation()
	{
		this.role = this.rolemanager.findById(roleid);
		this.module = this.modulemanager.findById(moduleid);
	    if(role!=null&&module!=null)
	    {
	    	this.rolemodule.setMhqxTabModule(module);
			this.rolemodule.setMhqxTabRole(role);
			this.rolemodulemanager.update(rolemodule);
	    }
		return "updateRoleModuleRelation";
	}
	/**
	 * <p>转到角色模块配置页面<br>
	 * @return action result
	 */
	public String RoleModuleConfig()
	{
		this.rolelist = this.rolemanager.findAll();
		this.modulelist = this.modulemanager.findAll();
		return "RoleModuleConfig";
	}
}
