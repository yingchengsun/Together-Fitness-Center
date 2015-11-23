package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
/**
 * <p>与模块用户相关的action<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleuserAction extends ActionSupport {
	private List<MhqxTabModuleuser> moduleuserlist = new ArrayList<MhqxTabModuleuser> ();
	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**错误提示*/
	private String message = new String("");
	/**模块ID*/
	private int id;
	
	private List<Integer> deletelist = new ArrayList<Integer> ();
	/**模块名称*/
	private String modulename;
	/**用户账号*/
	private String usernumber;
	/**模块对象*/
	private MhqxTabModule module;
	/**用户对象*/
	private MhqxTabUser user;
	/**模块用户对象*/
	private MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();

	private List<String> modulenamelist = new ArrayList<String> ();
	
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule> ();
	/**用户模块表操作对象*/
	private MhqxTabModuleuserManager moduleusermanager;
	/**用户功能表操作对象*/
	private MhqxTabUserfunctionManager userfunctionmanager;
	/**模块表操作对象*/
	private MhqxTabModuleManager modulemanager;
	/**用户表操作对象*/
	private MhqxTabUserManager usermanager;

	private String moduleusermhqxTabUserFUserNumber;
	
	
	
	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}
	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}
	public String getModuleusermhqxTabUserFUserNumber() {
		return moduleusermhqxTabUserFUserNumber;
	}
	public void setModuleusermhqxTabUserFUserNumber(
			String moduleusermhqxTabUserFUserNumber) {
		this.moduleusermhqxTabUserFUserNumber = moduleusermhqxTabUserFUserNumber;
	}
	public List<Integer> getDeletelist() {
		return deletelist;
	}
	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
	}
	public List<MhqxTabModuleuser> getModuleuserlist() {
		return moduleuserlist;
	}
	public void setModuleuserlist(List<MhqxTabModuleuser> moduleuserlist) {
		this.moduleuserlist = moduleuserlist;
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
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public MhqxTabModule getModule() {
		return module;
	}
	public void setModule(MhqxTabModule module) {
		this.module = module;
	}
	public MhqxTabUser getUser() {
		return user;
	}
	public void setUser(MhqxTabUser user) {
		this.user = user;
	}
	public MhqxTabModuleuser getModuleuser() {
		return moduleuser;
	}
	public void setModuleuser(MhqxTabModuleuser moduleuser) {
		this.moduleuser = moduleuser;
	}
	public MhqxTabModuleuserManager getModuleusermanager() {
		return moduleusermanager;
	}
	public void setModuleusermanager(MhqxTabModuleuserManager moduleusermanager) {
		this.moduleusermanager = moduleusermanager;
	}
	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}
	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}
	public List<String> getModulenamelist() {
		return modulenamelist;
	}
	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}
	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}
	public void setModulenamelist(List<String> modulenamelist) {
		this.modulenamelist = modulenamelist;
	}
	public MhqxTabUserManager getUsermanager() {
		return usermanager;
	}
	public void setUsermanager(MhqxTabUserManager usermanager) {
		this.usermanager = usermanager;
	}
	/**
	 * <p>多选删除模块用户表的条目<br>
	 * @return action result
	 */
	public String multipledelete()
	{
		MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
		Iterator<Integer> iterator = this.deletelist.iterator();
		if(!iterator.hasNext())
		{
			return "multipledelete";
		}
		
		while(iterator.hasNext())
		{
			moduleuser = this.moduleusermanager.findById(iterator.next());
			this.moduleusermanager.delete(moduleuser);
			List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction>();
			userfunctionlist = this.userfunctionmanager.findAll();
			Iterator<MhqxTabUserfunction> iterator2 = userfunctionlist.iterator();
			while(iterator2.hasNext())
			{
				MhqxTabUserfunction userfunction = iterator2.next();
			   	if(userfunction.getMhqxTabFunction().getFFunctionId().equals(this.moduleuser.getMhqxTabModule().getFModuleId())
			   			&&userfunction.getMhqxTabUser().getFUserNumber().equals(this.moduleuser.getMhqxTabUser().getFUserNumber()))
			   	{
			   		this.userfunctionmanager.delete(userfunction);
			   	}
			}
		}
		return "multipledelete";
	}
	/**
	 * <p>删除单个用户模块条目<br>
	 * @return action result
	 */
	public String deleteModuleUserRelation()
	{
		this.moduleuser = this.moduleusermanager.findById(id);
		this.moduleusermanager.delete(moduleuser);
		List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction>();
		userfunctionlist = this.userfunctionmanager.findAll();
		Iterator<MhqxTabUserfunction> iterator = userfunctionlist.iterator();
		while(iterator.hasNext())
		{
			MhqxTabUserfunction userfunction = iterator.next();
		   	if(userfunction.getMhqxTabFunction().getFFunctionId().equals(this.moduleuser.getMhqxTabModule().getFModuleId())
		   			&&userfunction.getMhqxTabUser().getFUserNumber().equals(this.moduleuser.getMhqxTabUser().getFUserNumber()))
		   	{
		   		this.userfunctionmanager.delete(userfunction);
		   	}
		}
		return "deleteModuleUserRelation";
	}
	/**
	 * <p>查询用户模块关系条目<br>
	 * @return action result
	 */
	public String searchModuleUserRelation()
	{
		this.moduleuserlist.clear();
		this.moduleuserlist = this.moduleusermanager.findMhqxTabModuleuserByUserNumber(usernumber);
		this.usernumber = null;
		return "searchModuleUserRelation";
	}
	/**
	 * <p>修改用户模块关系条目<br>
	 * @return action result
	 */
	public String modifyModuleUserRelation()
	{
		this.modulelist = this.modulemanager.findAll();
		this.moduleuser = this.moduleusermanager.findById(id);
		this.moduleusermhqxTabUserFUserNumber = this.moduleuser.getMhqxTabUser().getFUserNumber();
		this.modulenamelist.clear();
    	this.modulelist = this.modulemanager.findAll();
    	Iterator<MhqxTabModule> iterator = this.modulelist.iterator();
    	while(iterator.hasNext())
    	{
    		this.modulenamelist.add(iterator.next().getFModuleName());
    	}
		return "modifyModuleUserRelation";
	}
	/**
	 * <p>更新用户模块关系条目<br>
	 * @return action result
	 */
	public String updateModuleUserRelation()
	{
		System.out.println("calling the updatemoduleuserrelation !----");
		if(modulename.equals("-1"))
		{
			return this.ERROR;
		}
		this.user = this.usermanager.findById(moduleusermhqxTabUserFUserNumber).iterator().next();
		this.module = this.modulemanager.findByName(modulename).iterator().next();
		if(user!=null&&module!=null)
		{	
		   this.moduleuser.setMhqxTabModule(this.module);
		   this.moduleuser.setMhqxTabUser(this.user);
		   this.moduleusermanager.update(this.moduleuser);
		}
		return "updateModuleUserRelation";
	}
	/**
	 * <p>配置用户模块对应关系<br>
	 * @return action result
	 */
	public String saveModuleUserRelation()
	{
		List<MhqxTabModule> modulelist = this.modulemanager.findByName(modulename);
		List<MhqxTabUser> userlist = this.usermanager.findById(usernumber);
		if(userlist.size()!=0&&modulelist.size()!=0)
		{
			this.module = modulelist.iterator().next();
			this.user = userlist.iterator().next();
			this.moduleuser = new MhqxTabModuleuser();
			this.moduleuser.setMhqxTabModule(module);
			this.moduleuser.setMhqxTabUser(user);
			this.moduleusermanager.save(moduleuser);
			return this.SUCCESS;
		}
	    this.message = "些账号不存在!";
		return this.ERROR;
	}
	/**
	 * <p>多选配置用户模块对应关系<br>
	 * @return action result
	 */
	public String multipleconfig()
	{
		System.out.println("usermodule multipleconfig");
		System.out.println("list size: "+deletelist.size());
		Iterator<Integer> iterator = this.deletelist.iterator();
		this.moduleuserlist = this.moduleusermanager.findAll();
		Iterator<MhqxTabModuleuser> iteratormoduleuser = this.moduleuserlist.iterator();
		int tag = 0;
		if( this.usermanager.findById(usernumber).iterator().hasNext())
		{
			this.user = this.usermanager.findById(usernumber).iterator().next();
			System.out.println("password: "+this.user.getFUserPassword());
			while(iterator.hasNext())
			{
				tag = 0;
				this.moduleuserlist = this.moduleusermanager.findAll();
				iteratormoduleuser = this.moduleuserlist.iterator();
				this.module = this.modulemanager.findById(iterator.next());
				while(iteratormoduleuser.hasNext())
				{
					this.moduleuser = iteratormoduleuser.next();
					if(this.moduleuser.getMhqxTabModule().getFModuleId().equals(this.module.getFModuleId())
							&&this.moduleuser.getMhqxTabUser().getFUserNumber().equals(this.user.getFUserNumber()))
					{
						tag = 1;
						break;
					}
				}
				if(tag == 1)
				{
					continue;
				}
				this.moduleuser.setMhqxTabModule(module);
				this.moduleuser.setMhqxTabUser(user);
				this.moduleusermanager.save(moduleuser);
			}
		}
		return "multipleconfig";
	}
	/**
	 * <p>分页显示用户模块对应关系表<br>
	 * @return action result
	 */
	public String showpagelist()
	{
		this.moduleuserlist = this.moduleusermanager.findAll();
		int pages = 10;
		int listlength = this.moduleuserlist.size();
		if(listlength==0)
			return "moduleuserlist";
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
		this.moduleuserlist = this.moduleuserlist.subList(startIndex, endIndex);
		return "moduleuserlist";
	}
	
	
}
