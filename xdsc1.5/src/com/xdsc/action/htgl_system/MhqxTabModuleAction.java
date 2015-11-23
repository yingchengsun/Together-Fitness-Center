package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabRolefunction;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
/**
 * <p>ģ�������ص�Action<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabModuleAction extends ActionSupport {
	/**ģ���������*/
    private MhqxTabModuleManager modulemanager;
    /**ģ�����*/
    private MhqxTabModule module;
    /**��ɫ��������*/
    private MhqxTabRoleManager rolemanager;
    
    private List<MhqxTabRole> rolelist = new ArrayList<MhqxTabRole>();
    
    private List<String> modulenamelist = new ArrayList<String> ();
    
	private List<Integer> deletelist = new ArrayList<Integer>(); 
	/**�û����ܲ�������*/
	private MhqxTabUserfunctionManager userfunctionmanager;
	
	private List<MhqxTabUserfunction> userfunctionlist = new ArrayList<MhqxTabUserfunction> ();
	/**��ɫ���ܲ�������*/
	private MhqxTabRolefunctionManager rolefunctionmanager;
	
	private List<MhqxTabRolefunction> rolefunctionlist = new ArrayList<MhqxTabRolefunction>();
    
	/**��ҳ��ʾ��ҳ��*/
	private int p = 1;
	/**ĩҳ��*/
	private int lastPage;
	
	private int id;
	
	private List<MhqxTabModule> modulelist;
	
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

	public List<Integer> getDeletelist() {
		return deletelist;
	}

	public void setDeletelist(List<Integer> deletelist) {
		this.deletelist = deletelist;
	}

	public List<String> getModulenamelist() {
		return modulenamelist;
	}

	public void setModulenamelist(List<String> modulenamelist) {
		this.modulenamelist = modulenamelist;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}

	public MhqxTabModuleManager getModulemanager() {
		return modulemanager;
	}

	public void setModulemanager(MhqxTabModuleManager modulemanager) {
		this.modulemanager = modulemanager;
	}

	public MhqxTabModule getModule() {
		return module;
	}

	public void setModule(MhqxTabModule module) {
		this.module = module;
	}
	
	
    public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}

	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}

	public List<MhqxTabUserfunction> getUserfunctionlist() {
		return userfunctionlist;
	}

	public void setUserfunctionlist(List<MhqxTabUserfunction> userfunctionlist) {
		this.userfunctionlist = userfunctionlist;
	}

	public MhqxTabRolefunctionManager getRolefunctionmanager() {
		return rolefunctionmanager;
	}

	public void setRolefunctionmanager(
			MhqxTabRolefunctionManager rolefunctionmanager) {
		this.rolefunctionmanager = rolefunctionmanager;
	}

	public List<MhqxTabRolefunction> getRolefunctionlist() {
		return rolefunctionlist;
	}

	public void setRolefunctionlist(List<MhqxTabRolefunction> rolefunctionlist) {
		this.rolefunctionlist = rolefunctionlist;
	}

	/**
     * <p>��ѡɾ��ģ��<br>
     * @return action result
     */
	public String multipledelete()
	{
//		System.out.println("multipledelete" + deletelist.size());
		MhqxTabModule module = new MhqxTabModule();
		if (this.deletelist.size()==0)
			return "multipledelete";
		Iterator<Integer> iterator = this.deletelist.iterator();
		while(iterator.hasNext())
		{
			module = this.modulemanager.findById(iterator.next());
			this.modulemanager.delete(module);
			
	    	this.userfunctionlist = this.userfunctionmanager.findAll();
	    	Iterator<MhqxTabUserfunction> iterator3 = this.userfunctionlist.iterator();
	    	MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
	    	while(iterator3.hasNext())
	    	{
	    		userfunction = iterator3.next();
	    		if(userfunction.getMhqxTabFunction().getMhqxTabModule().getFModuleId().equals(module.getFModuleId()))
	    		{
	    			this.userfunctionmanager.delete(userfunction);
	    		}
	    	}
	    	
	        this.rolefunctionlist = this.rolefunctionmanager.findAll();
	        Iterator<MhqxTabRolefunction> iterator2 = this.rolefunctionlist.iterator();
	        MhqxTabRolefunction rolefunction = new MhqxTabRolefunction();
	        while(iterator2.hasNext())
	        {
	        	rolefunction = iterator2.next();
	        	if(rolefunction.getMhqxTabFunction().getMhqxTabModule().getFModuleId().equals(module.getFModuleId()))
	        	{
	        		this.rolefunctionmanager.delete(rolefunction);
	        	}
	        }
			
		}
		return "multipledelete";
	}
	/**
	 * <p>���ģ��<br>
	 */
    public String addmodule()
    {
    	this.modulemanager.save(module);
    	return "addmodule";
    }
    public void validateAddmodule()
    {
    	if(module.getFModuleName().equals("")||module.getFModuleName()==null)
    	{
    		addFieldError("module.FModuleName","����Ϊ��");
    	}

    }
    /**
     * <p>ɾ��ģ��<br>
     * @return actin result
     */
    public String deletemodule()
    {
    	MhqxTabModule module = this.modulemanager.findById(id);
    	this.modulemanager.delete(module);
    	this.userfunctionlist = this.userfunctionmanager.findAll();
    	Iterator<MhqxTabUserfunction> iterator = this.userfunctionlist.iterator();
    	MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
    	while(iterator.hasNext())
    	{
    		userfunction = iterator.next();
    		if(userfunction.getMhqxTabFunction().getMhqxTabModule().getFModuleId().equals(module.getFModuleId()))
    		{
    			this.userfunctionmanager.delete(userfunction);
    		}
    	}
    	
        this.rolefunctionlist = this.rolefunctionmanager.findAll();
        Iterator<MhqxTabRolefunction> iterator2 = this.rolefunctionlist.iterator();
        MhqxTabRolefunction rolefunction = new MhqxTabRolefunction();
        while(iterator2.hasNext())
        {
        	rolefunction = iterator2.next();
        	if(rolefunction.getMhqxTabFunction().getMhqxTabModule().getFModuleId().equals(module.getFModuleId()))
        	{
        		this.rolefunctionmanager.delete(rolefunction);
        	}
        }
    	return "deletemodule";
    }
    /**
     * <p>�޸�ģ��<br>
     * @return action result
     */
    public String modifymodule()
    {
    	this.module = this.modulemanager.findById(id);
    	return "modify";
    }
    /**
     * <p>����ģ��<br>
     */
    public String updatemodule()
    {
    	this.modulemanager.update(module);
    	return "updatemodule";
    }
    /**
     * <p>ת������ҳ��<br>
     * @return action result
     */
    public String configmodulelist()
    {
    	showpagelist();
    	return "configmodulelist";
    }
    /**
     * <p>�õ�ģ���б�<br>
     */
    public String modulelist()
    {
    	this.modulenamelist.clear();
    	
    	this.modulelist = this.modulemanager.findAll();
    	
    	Iterator<MhqxTabModule> iterator = this.modulelist.iterator();
    	
    	while(iterator.hasNext())
    	{
    		this.modulenamelist.add(iterator.next().getFModuleName());
    	}
    	
    	return "modulelist";
    }
    /**
     * <p>��ҳ��ʾģ���б�<br>
     * @return actin result
     */
    public String showpagelist()
    {
		this.modulelist = modulemanager.findAll();
		int pages = 10;
		int listlength = this.modulelist.size();
		if(listlength==0)
			return "showpagelist";
		
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
		this.modulelist = this.modulelist.subList(startIndex, endIndex);
		
    	return "showpagelist";
    }
    /**
     * <p>ת������ҳ��<br>
     * @return action result
     */
    public String configrolemodulelist()
    {
    	showpagelist();
    	this.rolelist.clear();
    	this.rolelist = this.rolemanager.findAll();
    	return "configrolemodulelist";
    }
}
