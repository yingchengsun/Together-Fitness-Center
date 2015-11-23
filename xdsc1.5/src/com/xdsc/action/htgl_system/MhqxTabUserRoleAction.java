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
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.XsglTabParents;
import com.xdsc.service.htgl_system.MhqxTabModuleuserManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleModuleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
import com.xdsc.service.htgl_system.MhqxTabUserManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
import com.xdsc.service.htgl_system.TabStudentsManager;
import com.xdsc.service.htgl_system.TabTeachersManager;
import com.xdsc.service.mail_system.MailServer;
import com.xdsc.service.xsgl_system.XsglTabParentsManager;

public class MhqxTabUserRoleAction extends ActionSupport {

	private int id;
	
	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**错误提示消息*/
	private String message = new String("");
	
	private List<MhqxTabRoleuser> userrolelist = new ArrayList<MhqxTabRoleuser>();

	private List<Integer> deletelist = new ArrayList<Integer>();
	
	private List<String> userselectlist = new ArrayList<String>();
	/**用户角色表操作对象*/
	private MhqxTabRoleUserManager userrolemanager;
	/**角色表操作对象*/
	private MhqxTabRoleManager rolemanager;
	/**用户表操作对象*/
	private MhqxTabUserManager usermanager;

	private List<MhqxTabRole> rolelist = new ArrayList<MhqxTabRole>();
	
	private List<MhqxTabUser> userlist = new ArrayList<MhqxTabUser>();

	private List<MhqxTabRolefunction> rolefunctionlist = new ArrayList<MhqxTabRolefunction>();
	
	private List<MhqxTabRolemodule> rolemodulelist = new ArrayList<MhqxTabRolemodule>();
	/**角色模块表操作对象*/
	private MhqxTabRoleModuleManager rolemodulemanager;
	/**角色功能表操作对象*/
	private MhqxTabRolefunctionManager rolefunctionmanager;
	/**用户功能表操作对象*/
	private MhqxTabUserfunctionManager userfunctionmanager;
	/**用户模块表操作对象*/
	private MhqxTabModuleuserManager usermodulemanager;
	/**角色名称*/
	private String rolename;
	/**用户账号*/
	private String usernumber;
	/**用户角色对象*/
	private MhqxTabRoleuser roleuser = new MhqxTabRoleuser();
	/**角色对象*/
	private MhqxTabRole role;
	/**用户对象*/
	private MhqxTabUser user;
	/**用于查询的角色ID*/
	private int roleusermhqxTabRoleFRoleId;
	/**用于查询用户账号*/
	private String roleusermhqxTabUserFUserNumber;
	
	private TabStudents student;  
	
	private TabTeachers teacher;
	
	private TabStudentsManager studentmanager;
	
	private TabTeachersManager teachermanager;
	
	
	private XsglTabParentsManager parentsmanager;
	
	public XsglTabParentsManager getParentsmanager() {
		return parentsmanager;
	}

	public void setParentsmanager(XsglTabParentsManager parentsmanager) {
		this.parentsmanager = parentsmanager;
	}

	public List<String> getUserselectlist() {
		return userselectlist;
	}

	public void setUserselectlist(List<String> userselectlist) {
		this.userselectlist = userselectlist;
	}

	public List<MhqxTabRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<MhqxTabRole> rolelist) {
		this.rolelist = rolelist;
	}

	public List<MhqxTabUser> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<MhqxTabUser> userlist) {
		this.userlist = userlist;
	}

	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}

	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}

	public MhqxTabModuleuserManager getUsermodulemanager() {
		return usermodulemanager;
	}

	public void setUsermodulemanager(MhqxTabModuleuserManager usermodulemanager) {
		this.usermodulemanager = usermodulemanager;
	}

	public int getRoleusermhqxTabRoleFRoleId() {
		return roleusermhqxTabRoleFRoleId;
	}

	public void setRoleusermhqxTabRoleFRoleId(int roleusermhqxTabRoleFRoleId) {
		this.roleusermhqxTabRoleFRoleId = roleusermhqxTabRoleFRoleId;
	}

	public String getRoleusermhqxTabUserFUserNumber() {
		return roleusermhqxTabUserFUserNumber;
	}

	public void setRoleusermhqxTabUserFUserNumber(
			String roleusermhqxTabUserFUserNumber) {
		this.roleusermhqxTabUserFUserNumber = roleusermhqxTabUserFUserNumber;
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

	public List<MhqxTabRoleuser> getUserrolelist() {
		return userrolelist;
	}

	public void setUserrolelist(List<MhqxTabRoleuser> userrolelist) {
		this.userrolelist = userrolelist;
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

	public MhqxTabRole getRole() {
		return role;
	}

	public void setRole(MhqxTabRole role) {
		this.role = role;
	}

	public MhqxTabUser getUser() {
		return user;
	}

	public void setUser(MhqxTabUser user) {
		this.user = user;
	}

	public MhqxTabRoleManager getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(MhqxTabRoleManager rolemanager) {
		this.rolemanager = rolemanager;
	}

	public MhqxTabUserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(MhqxTabUserManager usermanager) {
		this.usermanager = usermanager;
	}

	public MhqxTabRoleuser getRoleuser() {
		return roleuser;
	}

	public void setRoleuser(MhqxTabRoleuser roleuser) {
		this.roleuser = roleuser;
	}

	public MhqxTabRoleUserManager getUserrolemanager() {
		return userrolemanager;
	}

	public void setUserrolemanager(MhqxTabRoleUserManager userrolemanager) {
		this.userrolemanager = userrolemanager;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}

	public List<MhqxTabRolefunction> getRolefunctionlist() {
		return rolefunctionlist;
	}

	public void setRolefunctionlist(List<MhqxTabRolefunction> rolefunctionlist) {
		this.rolefunctionlist = rolefunctionlist;
	}

	public List<MhqxTabRolemodule> getRolemodulelist() {
		return rolemodulelist;
	}

	public void setRolemodulelist(List<MhqxTabRolemodule> rolemodulelist) {
		this.rolemodulelist = rolemodulelist;
	}

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
	
	public TabStudents getStudent() {
		return student;
	}

	public void setStudent(TabStudents student) {
		this.student = student;
	}

	public TabTeachers getTeacher() {
		return teacher;
	}

	public void setTeacher(TabTeachers teacher) {
		this.teacher = teacher;
	}

	public TabStudentsManager getStudentmanager() {
		return studentmanager;
	}

	public void setStudentmanager(TabStudentsManager studentmanager) {
		this.studentmanager = studentmanager;
	}

	public TabTeachersManager getTeachermanager() {
		return teachermanager;
	}

	public void setTeachermanager(TabTeachersManager teachermanager) {
		this.teachermanager = teachermanager;
	}

	/**
	 * <p>批量配置用户角色<br>
	 * @return action result
	 */
	public String multipleconfig() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String usernumber = (String)session.getAttribute("UserNumber");
		MailServer mailServer = new MailServer();
	    MhqxTabUser parent = new MhqxTabUser();
	    XsglTabParents prt = new XsglTabParents();
	    MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
		MhqxTabModuleuser usermodule = new MhqxTabModuleuser();
		MhqxTabFunction function = new MhqxTabFunction();
		MhqxTabModule module = new MhqxTabModule();
		MhqxTabRole role2 = new MhqxTabRole();
		role2 = this.rolemanager.findByName("家长").get(0);
		List<MhqxTabRolemodule> rolemodulelistparent = new ArrayList<MhqxTabRolemodule>();
		List<MhqxTabRolefunction> rolefunctionlistparent = new ArrayList<MhqxTabRolefunction>();
		MhqxTabRoleuser userrole2 = new MhqxTabRoleuser();
		userrole2.setMhqxTabRole(role2);
		rolemodulelistparent = this.rolemodulemanager.findByRoleId(role2.getFRoleId());
		rolefunctionlistparent = this.rolefunctionmanager.findByRoleId(role2.getFRoleId());
		System.out.println("================");
		System.out.println(rolemodulelistparent.size());
		System.out.println(rolefunctionlistparent.size());
		System.out.println("================");
		if(usernumber==null&&(this.usernumber==null||this.usernumber.equals("")))
			return "multipleconfig";
		if(usernumber==null)
			usernumber = this.usernumber;
		if(usernumber!=null) {
			System.out.println("after multipleconfig usernumber: "+usernumber);
			this.user = this.usermanager.findById(usernumber)
					.iterator().next();
			Iterator<Integer> iterator = this.deletelist.iterator();
			List<MhqxTabRoleuser> roleuserlist = new ArrayList<MhqxTabRoleuser>();
			roleuserlist = this.userrolemanager.findAll();
			Iterator<MhqxTabRoleuser> roleuseriterator = roleuserlist
					.iterator();
			// tag是用来标记是否在userrole list 中已经有该种用户角色对应关系
			int tag = 0;
			// iterator 是 rolelist 的iterator
			
			
			
			while (iterator.hasNext()) {
				tag = 0;
				// 对于每一个role在userrolerelation里都要从头遍历，所以要让iterator每次指向userrolelist的第一个
				roleuserlist = this.userrolemanager.findAll();
				roleuseriterator = roleuserlist.iterator();
				role = this.rolemanager.findById(iterator.next());
				while (roleuseriterator.hasNext()) {
//					System.out.println("while -----2");
					roleuser = roleuseriterator.next();
					// 字符串相等用equals()
					if (roleuser.getMhqxTabRole().getFRoleId().equals(
							role.getFRoleId())
							&& roleuser.getMhqxTabUser().getFUserNumber()
									.equals(user.getFUserNumber())) {
						System.out.println("用户："+user.getFUserNumber()+"已经拥有"+role.getFRoleName()+"角色");
						tag = 1;
						break;
					}
				}
				if (tag == 1) {
					// 若userrole list中已经有相关的用户角色关系则不用再次添加，返回外层的while去判断下一个
					// role user对应是不是在关系表中。
//					System.out.println("tag : " + tag);
					continue;
				}
				this.roleuser.setMhqxTabRole(this.role);
				this.roleuser.setMhqxTabUser(this.user);
				this.userrolemanager.save(this.roleuser);
				
				if(this.role.getFRoleName().equals("导师"))
				{
				   this.teacher = new TabTeachers();
				   this.teacher.setFTeacherNumber(usernumber);
				   this.teachermanager.saveTeacher(teacher);
			 	}
				else if(this.role.getFRoleName().equals("本科生"))
				{
				   this.student = new TabStudents();
				   this.student.setFStudentNumber(usernumber);
				   this.studentmanager.saveStudent(student);
				   
				   parent.setFUserNumber(usernumber.substring(2));
					parent.setFUserPassword(usernumber.substring(2));
					this.usermanager.save(parent);
					mailServer.addUser(usernumber.substring(2), usernumber
							.substring(2));
					userfunction.setMhqxTabUser(parent);
					usermodule.setMhqxTabUser(parent);
					for (int i = 0; i < rolefunctionlistparent.size(); i++) {
						userfunction.setMhqxTabFunction(rolefunctionlistparent
								.get(i).getMhqxTabFunction());
						this.userfunctionmanager.save(userfunction);
					}
					for (int i = 0; i < rolemodulelistparent.size(); i++) {
						usermodule.setMhqxTabModule(rolemodulelistparent.get(i)
								.getMhqxTabModule());
						this.usermodulemanager.save(usermodule);
					}
					userrole2.setMhqxTabUser(parent);
					this.userrolemanager.save(userrole2);
					
					prt.setFParentId(parent.getFUserNumber());
					
					prt.setTabStudents(student);
					
					this.parentsmanager.saveParent(prt);
				    
				}
				else if(this.role.getFRoleName().equals("研究生"))
				{
				   this.student = new TabStudents();
				   this.student.setFStudentNumber(usernumber);
				   this.studentmanager.saveStudent(student);
				   
				    parent.setFUserNumber(usernumber.substring(2));
					parent.setFUserPassword(usernumber.substring(2));
					this.usermanager.save(parent);
					mailServer.addUser(usernumber.substring(2), usernumber
							.substring(2));
					userfunction.setMhqxTabUser(parent);
					usermodule.setMhqxTabUser(parent);
					for (int i = 0; i < rolefunctionlistparent.size(); i++) {
						userfunction.setMhqxTabFunction(rolefunctionlistparent
								.get(i).getMhqxTabFunction());
						this.userfunctionmanager.save(userfunction);
					}
					for (int i = 0; i < rolemodulelistparent.size(); i++) {
						usermodule.setMhqxTabModule(rolemodulelistparent.get(i)
								.getMhqxTabModule());
						this.usermodulemanager.save(usermodule);
					}
					userrole2.setMhqxTabUser(parent);
					this.userrolemanager.save(userrole2);
					
					prt.setFParentId(parent.getFUserNumber());
					
					prt.setTabStudents(student);
					
					this.parentsmanager.saveParent(prt);
				}
				
				
				this.rolefunctionlist = this.rolefunctionmanager
						.findByRoleId(this.role.getFRoleId());
				this.rolemodulelist = this.rolemodulemanager
						.findByRoleId(this.role.getFRoleId());
				Iterator<MhqxTabRolefunction> rfiterator = rolefunctionlist
						.iterator();
				Iterator<MhqxTabRolemodule> rmiterator = rolemodulelist
						.iterator();
				
				while (rfiterator.hasNext()) {
					userfunction.setMhqxTabUser(user);
					function = rfiterator.next().getMhqxTabFunction();
					userfunction.setMhqxTabFunction(function);
					if(this.userfunctionmanager.CheckUserFunction(userfunction))
					{
						continue;
					}
					else
					{
						this.userfunctionmanager.save(userfunction);
					}
//					this.userfunctionmanager.save(userfunction);
//					System.out.println(userfunction.getMhqxTabUser().getFUserNumber()+"-----"+userfunction.getMhqxTabFunction().getFFunctionName());
				}
				while (rmiterator.hasNext()) {
					usermodule.setMhqxTabUser(user);
					module = rmiterator.next().getMhqxTabModule();
					usermodule.setMhqxTabModule(module);
					if(this.usermodulemanager.CheckModuleUser(usermodule))
					{
						continue;
					}
					else{
						this.usermodulemanager.save(usermodule);
					}
//					this.usermodulemanager.save(usermodule);
//					System.out.println(usermodule.getMhqxTabUser().getFUserNumber()+"-----"+usermodule.getMhqxTabModule().getFModuleName());
				}
			}
		}
		this.usernumber = usernumber;
        session.removeAttribute("UserNumber");
		return "multipleconfig";
	}
	
	
	public String multipleconfig2() {
		if(this.usernumber==null||this.usernumber.equals(""))
		{
			addFieldError("usernumber", "不能为空");
			return "input";
		}
		else
		{
			if (this.usermanager.findById(usernumber).size() == 0) {
				addFieldError("usernumber", "不能为空");
				return "input";
			}
		}
		String usernumber = this.usernumber;
		if(usernumber!=null) {
			System.out.println("after multipleconfig usernumber: "+usernumber);
			this.user = this.usermanager.findById(usernumber)
					.iterator().next();
			Iterator<Integer> iterator = this.deletelist.iterator();
			List<MhqxTabRoleuser> roleuserlist = new ArrayList<MhqxTabRoleuser>();
			roleuserlist = this.userrolemanager.findAll();
			Iterator<MhqxTabRoleuser> roleuseriterator = roleuserlist
					.iterator();
			// tag是用来标记是否在userrole list 中已经有该种用户角色对应关系
			int tag = 0;
			// iterator 是 rolelist 的iterator
			while (iterator.hasNext()) {
				tag = 0;
				// 对于每一个role在userrolerelation里都要从头遍历，所以要让iterator每次指向userrolelist的第一个
				roleuserlist = this.userrolemanager.findAll();
				roleuseriterator = roleuserlist.iterator();
				role = this.rolemanager.findById(iterator.next());
				while (roleuseriterator.hasNext()) {
//					System.out.println("while -----2");
					roleuser = roleuseriterator.next();
					// 字符串相等用equals()
					if (roleuser.getMhqxTabRole().getFRoleId().equals(
							role.getFRoleId())
							&& roleuser.getMhqxTabUser().getFUserNumber()
									.equals(user.getFUserNumber())) {
						System.out.println("用户："+user.getFUserNumber()+"已经拥有"+role.getFRoleName()+"角色");
						tag = 1;
						break;
					}
				}
				if (tag == 1) {
					// 若userrole list中已经有相关的用户角色关系则不用再次添加，返回外层的while去判断下一个
					// role user对应是不是在关系表中。
//					System.out.println("tag : " + tag);
					continue;
				}
				this.roleuser.setMhqxTabRole(this.role);
				this.roleuser.setMhqxTabUser(this.user);
//				System.out.println("before save relation !");
				this.userrolemanager.save(this.roleuser);
				
				System.out.println("multipleconfig2 :"+this.role.getFRoleName());
				if(this.role.getFRoleName().equals("导师"))
				{
				   this.teacher = new TabTeachers();
				   this.teacher.setFTeacherNumber(usernumber);
				   if(this.teachermanager.getTeacherById(usernumber)==null)
				   {
					   this.teachermanager.saveTeacher(teacher);
				   }
			 	}
				else if(this.role.getFRoleName().equals("本科生"))
				{
				   this.student = new TabStudents();
				   this.student.setFStudentNumber(usernumber);
				   if(this.studentmanager.getStudentById(usernumber)==null)
				   {
					   this.studentmanager.saveStudent(student);
				   }
				}
				
				
//				System.out.println(roleuser.getMhqxTabUser().getFUserNumber()+"-----"+roleuser.getMhqxTabRole().getFRoleName());
				this.rolefunctionlist = this.rolefunctionmanager
						.findByRoleId(this.role.getFRoleId());
				this.rolemodulelist = this.rolemodulemanager
						.findByRoleId(this.role.getFRoleId());
				Iterator<MhqxTabRolefunction> rfiterator = rolefunctionlist
						.iterator();
				Iterator<MhqxTabRolemodule> rmiterator = rolemodulelist
						.iterator();
				MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
				MhqxTabModuleuser usermodule = new MhqxTabModuleuser();
				MhqxTabFunction function = new MhqxTabFunction();
				MhqxTabModule module = new MhqxTabModule();
				while (rfiterator.hasNext()) {
					userfunction.setMhqxTabUser(user);
					function = rfiterator.next().getMhqxTabFunction();
					userfunction.setMhqxTabFunction(function);
					if(this.userfunctionmanager.CheckUserFunction(userfunction))
					{
						continue;
					}
					else
					{
						this.userfunctionmanager.save(userfunction);
					}
//					this.userfunctionmanager.save(userfunction);
//					System.out.println(userfunction.getMhqxTabUser().getFUserNumber()+"-----"+userfunction.getMhqxTabFunction().getFFunctionName());
				}
				while (rmiterator.hasNext()) {
					usermodule.setMhqxTabUser(user);
					module = rmiterator.next().getMhqxTabModule();
					usermodule.setMhqxTabModule(module);
					if(this.usermodulemanager.CheckModuleUser(usermodule))
					{
						continue;
					}
					else{
						this.usermodulemanager.save(usermodule);
					}
//					this.usermodulemanager.save(usermodule);
//					System.out.println(usermodule.getMhqxTabUser().getFUserNumber()+"-----"+usermodule.getMhqxTabModule().getFModuleName());
				}
			}
		}
		this.usernumber = usernumber;
        
		return "multipleconfig";
	}
	
	
	/**
	 * <p>查询用户角色对应关系<br>
	 * @return action result
	 */
	public String searchuserrolerelation() {
		this.userrolelist = this.userrolemanager.findByUserNumber(usernumber);
		return "searchuserrolerelation";
	}
	/**
	 * <p>分页用户角色对应关系<br>
	 * @return action result
	 */
	public String showlist() {
		this.userrolelist = this.userrolemanager.findAll();
		int pages = 10;
		int listlength = this.userrolelist.size();
		if (listlength == 0)
			return "roleuserlist";
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
		this.userrolelist = this.userrolelist.subList(startIndex, endIndex);
		System.out.println("user--role number:" + this.userrolelist.size());
		return "roleuserlist";
	}
	/**
	 * <p>修改用户角色对应关系<br>
	 * @return action result 
	 */
	public String modifyUserRoleRelation() {
		this.roleuser = this.userrolemanager.findById(id);
		this.roleusermhqxTabRoleFRoleId = this.roleuser.getMhqxTabRole()
				.getFRoleId();
		this.roleusermhqxTabUserFUserNumber = this.roleuser.getMhqxTabUser()
				.getFUserNumber();
		return "modifyuserrolerelation";
	}

	/**
	 * <p>删除用户角色对应关系<br>
	 * @return action result 
	 */
	public String deleteUserRoleRelation() {

		this.roleuser = this.userrolemanager.findById(id);
    	this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(this.roleuser.getMhqxTabRole().getFRoleId());
    	this.rolemodulelist = this.rolemodulemanager.findByRoleId(this.roleuser.getMhqxTabRole().getFRoleId());
		this.userrolemanager.delete(roleuser);
		Iterator<MhqxTabModuleuser> moduleuseriterator = this.usermodulemanager
		       .findMhqxTabModuleuserByUserNumber(this.roleuser.getMhqxTabUser().getFUserNumber()).iterator();
		while (moduleuseriterator.hasNext()) {
			for(int i = 0;i<this.rolemodulelist.size();i++)
			{
				MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
				moduleuser = moduleuseriterator.next();
				if(this.rolemodulelist.get(i).getMhqxTabModule().getFModuleId()
						.equals(moduleuser.getMhqxTabModule().getFModuleId()))
				{
					this.usermodulemanager.delete(moduleuser);
				}
			}

		}
		Iterator<MhqxTabUserfunction> userfunctioniterator = this.userfunctionmanager
				.findMhqxTabUserfunctionByUserNumber(this.roleuser.getMhqxTabUser().getFUserNumber()).iterator();
		while (userfunctioniterator.hasNext()) {
			for(int j = 0;j<this.rolefunctionlist.size();j++)
			{
				MhqxTabUserfunction userfunction  = new MhqxTabUserfunction();
				userfunction = userfunctioniterator.next();
				if(this.rolefunctionlist.get(j).getMhqxTabFunction().getFFunctionId()
						.equals(userfunction.getMhqxTabFunction().getFFunctionId()))
				{
					this.userfunctionmanager.delete(userfunction);
				}
			}
			
		}
		return "deleteuserrolerelation";
	}
	public String deleteUserRoleRelation2() {
		
		this.roleuser = this.userrolemanager.findById(id);
		this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(
				this.roleuser.getMhqxTabRole().getFRoleId());
		this.rolemodulelist = this.rolemodulemanager.findByRoleId(this.roleuser.getMhqxTabRole().getFRoleId());
		List<MhqxTabUserfunction> userfunctionlist = this.userfunctionmanager
		                  .findMhqxTabUserfunctionByUserNumber(this.roleuser.getMhqxTabUser().getFUserNumber());
		Iterator<MhqxTabUserfunction> userfunctioniterator = userfunctionlist.iterator();
		this.userrolemanager.delete(this.roleuser);
//		System.out.println("rolefunction size:"+this.rolefunctionlist.size());
//		System.out.println("userfunction size:"+userfunctionlist.size());
		while (userfunctioniterator.hasNext()) {
			MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
			userfunction = userfunctioniterator.next();
			for (int j = 0; j < this.rolefunctionlist.size(); j++) {
				if (this.rolefunctionlist.get(j).getMhqxTabFunction().getFFunctionId()
						.equals(userfunction.getMhqxTabFunction().getFFunctionId())) 
				{
					this.userfunctionmanager.delete(userfunction);
				}
			}
		}
		
		
		Iterator<MhqxTabModuleuser> moduleuseriterator = this.usermodulemanager
	       .findMhqxTabModuleuserByUserNumber(this.roleuser.getMhqxTabUser().getFUserNumber()).iterator();
	    while (moduleuseriterator.hasNext()) {
		for(int i = 0;i<this.rolemodulelist.size();i++)
		{
			MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
			moduleuser = moduleuseriterator.next();
			if(this.rolemodulelist.get(i).getMhqxTabModule().getFModuleId()
					.equals(moduleuser.getMhqxTabModule().getFModuleId()))
			{
				this.usermodulemanager.delete(moduleuser);
			}
		}

	}
		
		
		return "deleteUserRoleRelation2";
	}
	/**
	 * <p>多选删除用户角色对应关系<br>
	 * @return action result 
	 */
	public String multipledelete() {
		MhqxTabRoleuser roleuser = new MhqxTabRoleuser();
		if (this.deletelist.size() == 0)
			return "multipledelete";
		Iterator<Integer> iterator = this.deletelist.iterator();
		while (iterator.hasNext()) {
			this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(id);
	    	this.rolemodulelist = this.rolemodulemanager.findByRoleId(id);
			this.roleuser = this.userrolemanager.findById(iterator.next());
			this.userrolemanager.delete(roleuser);
			Iterator<MhqxTabModuleuser> moduleuseriterator = this.usermodulemanager
			       .findMhqxTabModuleuserByUserNumber(this.roleuser.getMhqxTabUser().getFUserNumber()).iterator();
			while (moduleuseriterator.hasNext()) {
				for(int i = 0;i<this.rolemodulelist.size();i++)
				{
					MhqxTabModuleuser moduleuser = new MhqxTabModuleuser();
					moduleuser = moduleuseriterator.next();
					if(this.rolemodulelist.get(i).getMhqxTabModule().getFModuleId()
							.equals(moduleuser.getMhqxTabModule().getFModuleId()))
					{
						this.usermodulemanager.delete(moduleuser);
					}
				}

			}
			Iterator<MhqxTabUserfunction> userfunctioniterator = this.userfunctionmanager
					.findMhqxTabUserfunctionByUserNumber(this.roleuser.getMhqxTabUser().getFUserNumber()).iterator();
			while (userfunctioniterator.hasNext()) {
				for(int j = 0;j<this.rolefunctionlist.size();j++)
				{
					MhqxTabUserfunction userfunction  = new MhqxTabUserfunction();
					userfunction = userfunctioniterator.next();
					if(this.rolefunctionlist.get(j).getMhqxTabFunction().getFFunctionId()
							.equals(userfunction.getMhqxTabFunction().getFFunctionId()))
					{
						this.userfunctionmanager.delete(userfunction);
					}
				}
				
			}
		}
		return "multipledelete";
	}
	/**
	 * <p>更新用户角色对应关系<br>
	 * @return action result 
	 */
	public String updateUserRoleRelation() {
		System.out.println(roleusermhqxTabRoleFRoleId);
		System.out.println(roleusermhqxTabUserFUserNumber);
		this.role = this.rolemanager.findById(roleusermhqxTabRoleFRoleId);
		this.user = this.usermanager.findById(roleusermhqxTabUserFUserNumber)
				.iterator().next();
		if (role != null & user != null) {
			this.roleuser.setMhqxTabRole(role);
			this.roleuser.setMhqxTabUser(user);
			this.userrolemanager.update(roleuser);
		}
		return "updateuserrolerelation";
	}
	/**
	 * <p>配置单个用户角色对应关系<br>
	 * @return action result 
	 */
	public String saveUserRoleRelation() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("FRegistUserNumber",usernumber);
		if(usernumber==null)
			return "saveUserRoleRelation";
		List<MhqxTabRole> rolelist = this.rolemanager.findByName("考生");
		List<MhqxTabUser> userlist = this.usermanager.findById(usernumber);
		if (userlist.size() != 0 && rolelist.size() != 0) {
			this.role = rolelist.iterator().next();
			this.user = userlist.iterator().next();
			this.roleuser.setMhqxTabRole(role);
			this.roleuser.setMhqxTabUser(user);
			this.userrolemanager.save(roleuser);
			System.out.println(roleuser.getMhqxTabUser().getFUserNumber()+"-----"+roleuser.getMhqxTabRole().getFRoleName());
			this.rolefunctionlist = this.rolefunctionmanager
					.findByRoleId(this.role.getFRoleId());
			this.rolemodulelist = this.rolemodulemanager.findByRoleId(this.role
					.getFRoleId());
			Iterator<MhqxTabRolefunction> rfiterator = rolefunctionlist
					.iterator();
			Iterator<MhqxTabRolemodule> rmiterator = rolemodulelist.iterator();
			MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
			MhqxTabModuleuser usermodule = new MhqxTabModuleuser();
			MhqxTabFunction function = new MhqxTabFunction();
			MhqxTabModule module = new MhqxTabModule();
			while (rfiterator.hasNext()) {
				userfunction.setMhqxTabUser(user);
				function = rfiterator.next().getMhqxTabFunction();
				userfunction.setMhqxTabFunction(function);
				this.userfunctionmanager.save(userfunction);
				System.out.println(userfunction.getMhqxTabUser().getFUserNumber()+"-----"+userfunction.getMhqxTabFunction().getFFunctionName());
			}
			while (rmiterator.hasNext()) {
				usermodule.setMhqxTabUser(user);
				module = rmiterator.next().getMhqxTabModule();
				usermodule.setMhqxTabModule(module);
				this.usermodulemanager.save(usermodule);
				System.out.println(usermodule.getMhqxTabUser().getFUserNumber()+"-----"+usermodule.getMhqxTabModule().getFModuleName());
			}
			return this.SUCCESS;
		}
		this.message = "此账号不存在!";
		return this.ERROR;
	}
	/**
	 * <p>得到用户列表和角色列表<br>
	 * @return action result 
	 */
	public String showroleanduser() {
		this.rolelist = this.rolemanager.findAll();
//		this.userlist = this.usermanager.findAll();
//		int pages = 10;
//		int listlength = this.userlist.size();
//		if (listlength == 0)
//			return this.SUCCESS;
//		if (listlength % pages == 0) {
//			this.lastPage = listlength / pages;
//		} else {
//			this.lastPage = listlength / pages + 1;
//		}
//		if (this.p < 1)
//			this.p = 1;
//		if (this.p > this.lastPage)
//			this.p = this.lastPage;
//		int startIndex = (this.p - 1) * pages;
//		int endIndex = startIndex + pages;
//		if (endIndex >= listlength)
//			endIndex = listlength;
//		this.userlist = this.userlist.subList(startIndex, endIndex);
		this.deletelist.clear();
		return "showroleanduser";
	}
	
	public String showroleanduser2() {
		this.rolelist = this.rolemanager.findAll();
		this.usernumber = null;
		return "showroleanduser2";
	}
	public String pStudentRoleConfig()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<String> usernumberlist = new ArrayList();
		usernumberlist = (List<String>)session.getAttribute("usernumberlist"); 
		
		//*****2010-0520
		//批量注册用户到邮件服务器
		MailServer mailServer = new MailServer();
	    MhqxTabUser user = new MhqxTabUser();
		for(int i =0;i<usernumberlist.size();i++){
			user = this.usermanager.findById(usernumberlist.get(i)).get(0);	
			mailServer.addUser(user.getFUserNumber(),user.getFUserPassword());
		}
		//************
		
		MhqxTabRole role = this.rolemanager.findByName("本科生").iterator().next(); 
		MhqxTabRole role2 = this.rolemanager.findByName("家长").iterator().next();
		MhqxTabRole role3 = this.rolemanager.findByName("用户").iterator().next();
		
		List<MhqxTabRolefunction> rolefunctionlist2 = new ArrayList<MhqxTabRolefunction>();
		List<MhqxTabRolefunction> rolefunctionlist3 = new ArrayList<MhqxTabRolefunction>();
		
		this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(role.getFRoleId());
		rolefunctionlist2 = this.rolefunctionmanager.findByRoleId(role2.getFRoleId());
		rolefunctionlist3 = this.rolefunctionmanager.findByRoleId(role3.getFRoleId());
		
		MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
		MhqxTabModuleuser usermodule = new MhqxTabModuleuser();
		
        MhqxTabRoleuser userrole = new MhqxTabRoleuser();
        MhqxTabRoleuser userrole2 = new MhqxTabRoleuser();
        MhqxTabRoleuser userrole3 = new MhqxTabRoleuser();

        userrole.setMhqxTabRole(role);
		userrole2.setMhqxTabRole(role2);
		userrole3.setMhqxTabRole(role3);
		
		this.student = new TabStudents();
		MhqxTabUser parent = new MhqxTabUser();
		XsglTabParents prt = new XsglTabParents();

		List<MhqxTabRolemodule> rolemodulelist2 = new ArrayList<MhqxTabRolemodule>();
		List<MhqxTabRolemodule> rolemodulelist3 = new ArrayList<MhqxTabRolemodule>();
		
		this.rolemodulelist = this.rolemodulemanager.findByRoleId(role.getFRoleId());
		rolemodulelist2 = this.rolemodulemanager.findByRoleId(role2.getFRoleId());
		rolemodulelist3 = this.rolemodulemanager.findByRoleId(role3.getFRoleId());
		
		
		for(int i = 0;i<usernumberlist.size();i++)
		{
			this.user = this.usermanager.findById(usernumberlist.get(i)).get(0);
			
			this.student.setFStudentNumber(this.user.getFUserNumber());
			this.studentmanager.saveStudent(student);
            
			userrole.setMhqxTabUser(this.user);
			this.userrolemanager.save(userrole);
			//parent
			parent.setFUserNumber(usernumberlist.get(i).substring(2));
			parent.setFUserPassword(usernumberlist.get(i).substring(2));
			this.usermanager.save(parent);
			
			userrole2.setMhqxTabUser(parent);
			this.userrolemanager.save(userrole2);
			
			userrole3.setMhqxTabUser(this.user);
			this.userrolemanager.save(userrole3);
			
			mailServer.addUser(parent.getFUserNumber(),parent.getFUserPassword());
			
			
			
			prt.setFParentId(parent.getFUserNumber());
			
			prt.setTabStudents(student);
			
			this.parentsmanager.saveParent(prt);
			
			//家长
			for(int j =0;j<rolefunctionlist2.size();j++)
			{
				userfunction.setMhqxTabUser(parent);
				userfunction.setMhqxTabFunction(rolefunctionlist2.get(j).getMhqxTabFunction());
				this.userfunctionmanager.save(userfunction);
			}
			for(int j = 0;j<rolemodulelist2.size();j++)
			{
				usermodule.setMhqxTabUser(parent);
				usermodule.setMhqxTabModule(rolemodulelist2.get(j).getMhqxTabModule());
				this.usermodulemanager.save(usermodule);
			}
			//本科生
			for(int j =0;j<this.rolefunctionlist.size();j++)
			{
				userfunction.setMhqxTabUser(this.user);
				userfunction.setMhqxTabFunction(this.rolefunctionlist.get(j).getMhqxTabFunction());
				this.userfunctionmanager.save(userfunction);
			}
			for(int j = 0;j<this.rolemodulelist.size();j++)
			{
				usermodule.setMhqxTabUser(this.user);
				usermodule.setMhqxTabModule(this.rolemodulelist.get(j).getMhqxTabModule());
				this.usermodulemanager.save(usermodule);
			}
			//用户
			for(int j =0;j<rolefunctionlist3.size();j++)
			{
				userfunction.setMhqxTabUser(this.user);
				userfunction.setMhqxTabFunction(rolefunctionlist3.get(j).getMhqxTabFunction());
				this.userfunctionmanager.save(userfunction);
			}
			for(int j = 0;j<rolemodulelist3.size();j++)
			{
				usermodule.setMhqxTabUser(this.user);
				usermodule.setMhqxTabModule(rolemodulelist3.get(j).getMhqxTabModule());
				this.usermodulemanager.save(usermodule);
			}
		}
		session.removeAttribute("usernumberlist");
		return "pStudentRoleConfig" ;
	}
	public String gStudentRoleConfig()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<String> usernumberlist = new ArrayList();
		usernumberlist = (List<String>)session.getAttribute("usernumberlist"); 
		
		//*****2010-0520
		//批量注册用户到邮件服务器
		MailServer mailServer = new MailServer();
	    MhqxTabUser user = new MhqxTabUser();
		for(int i =0;i<usernumberlist.size();i++){
			user = this.usermanager.findById(usernumberlist.get(i)).get(0);	
			mailServer.addUser(user.getFUserNumber(),user.getFUserPassword());
		}
		//************
		
		MhqxTabRole role = this.rolemanager.findByName("研究生").iterator().next(); 
		MhqxTabRole role2 = this.rolemanager.findByName("家长").iterator().next();
		MhqxTabRole role3 = this.rolemanager.findByName("用户").iterator().next();
		
		MhqxTabRoleuser userrole = new MhqxTabRoleuser();
		MhqxTabRoleuser userrole2 = new MhqxTabRoleuser();
		MhqxTabRoleuser userrole3 = new MhqxTabRoleuser();
		
		List<MhqxTabRolefunction> rolefunctionlist2 = new ArrayList<MhqxTabRolefunction>();
		List<MhqxTabRolefunction> rolefunctionlist3 = new ArrayList<MhqxTabRolefunction>();
		
		this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(role.getFRoleId());
		rolefunctionlist2 = this.rolefunctionmanager.findByRoleId(role2.getFRoleId());
		rolefunctionlist3 = this.rolefunctionmanager.findByRoleId(role3.getFRoleId());
		
		userrole.setMhqxTabRole(role);
		userrole2.setMhqxTabRole(role2);
		userrole3.setMhqxTabRole(role3);
		
		List<MhqxTabRolemodule> rolemodulelist2 = new ArrayList<MhqxTabRolemodule>();
		List<MhqxTabRolemodule> rolemodulelist3 = new ArrayList<MhqxTabRolemodule>();
		
		MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
		MhqxTabModuleuser usermodule = new MhqxTabModuleuser();
		
		this.rolemodulelist = this.rolemodulemanager.findByRoleId(role.getFRoleId());
		rolemodulelist2 = this.rolemodulemanager.findByRoleId(role2.getFRoleId());
		rolemodulelist3 = this.rolemodulemanager.findByRoleId(role3.getFRoleId());
		
		MhqxTabUser parent = new MhqxTabUser();
		XsglTabParents prt = new XsglTabParents();
		this.student = new TabStudents();
		
		for(int i = 0;i<usernumberlist.size();i++)
		{
			this.user = this.usermanager.findById(usernumberlist.get(i)).get(0);
            this.student.setFStudentNumber(this.user.getFUserNumber());
			this.studentmanager.saveStudent(student);
			
			userrole.setMhqxTabUser(this.user);
			this.userrolemanager.save(userrole);
			
			//parent
			parent.setFUserNumber(usernumberlist.get(i).substring(2));
			parent.setFUserPassword(usernumberlist.get(i).substring(2));
			this.usermanager.save(parent);
			
			userrole2.setMhqxTabUser(parent);
			this.userrolemanager.save(userrole2);
			
			userrole3.setMhqxTabUser(this.user);
			this.userrolemanager.save(userrole3);
			
			mailServer.addUser(parent.getFUserNumber(),parent.getFUserPassword());
			
			prt.setFParentId(parent.getFUserNumber());
			
			prt.setTabStudents(student);
			
			this.parentsmanager.saveParent(prt);
			
			for(int j =0;j<rolefunctionlist2.size();j++)
			{
				userfunction.setMhqxTabUser(parent);
				userfunction.setMhqxTabFunction(rolefunctionlist2.get(j).getMhqxTabFunction());
				this.userfunctionmanager.save(userfunction);
			}
			for(int j = 0;j<rolemodulelist2.size();j++)
			{
				usermodule.setMhqxTabUser(parent);
				usermodule.setMhqxTabModule(rolemodulelist2.get(j).getMhqxTabModule());
				this.usermodulemanager.save(usermodule);
			}
			
			for(int j =0;j<this.rolefunctionlist.size();j++)
			{
				userfunction.setMhqxTabUser(this.user);
				userfunction.setMhqxTabFunction(this.rolefunctionlist.get(j).getMhqxTabFunction());
				this.userfunctionmanager.save(userfunction);
			}
			for(int j = 0;j<this.rolemodulelist.size();j++)
			{
				usermodule.setMhqxTabUser(this.user);
				usermodule.setMhqxTabModule(this.rolemodulelist.get(j).getMhqxTabModule());
				this.usermodulemanager.save(usermodule);
			}
			
			for(int j =0;j<rolefunctionlist3.size();j++)
			{
				userfunction.setMhqxTabUser(this.user);
				userfunction.setMhqxTabFunction(rolefunctionlist3.get(j).getMhqxTabFunction());
				this.userfunctionmanager.save(userfunction);
			}
			for(int j = 0;j<rolemodulelist3.size();j++)
			{
				usermodule.setMhqxTabUser(this.user);
				usermodule.setMhqxTabModule(rolemodulelist3.get(j).getMhqxTabModule());
				this.usermodulemanager.save(usermodule);
			}
		}
		session.removeAttribute("usernumberlist");
		return "gStudentRoleConfig" ;
	}
}
