package com.xdsc.action.htgl_system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabRole;
import com.xdsc.model.MhqxTabRolefunction;
import com.xdsc.model.MhqxTabRoleuser;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
import com.xdsc.service.htgl_system.MhqxTabModuleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleManager;
import com.xdsc.service.htgl_system.MhqxTabRoleUserManager;
import com.xdsc.service.htgl_system.MhqxTabRolefunctionManager;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
/**
 * <p>角色功能表相关操作的Action<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabRolefunctionAction extends ActionSupport {

	/**分页的页码*/
	private int p = 1;
	/**分页显示的最后一页*/
	private int lastPage;
	/**错误提示消息*/
	private String message = new String("");
	private int id;
	/**角色名称*/
	private String rolename;
	/**功能名称*/
	private String functionname;
	/**功能ID*/
	private int functionid;
	/**角色ID*/
	private int roleid;
	/**角色功能对象*/
	private MhqxTabRolefunction rolefunction = new MhqxTabRolefunction();
	/**角色对象*/
	private MhqxTabRole role;
	/**功能对象*/
	private MhqxTabFunction function;
	/**用户功能对象*/
	private MhqxTabUserfunction userfunction = new MhqxTabUserfunction();
	
	private List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
	/**功能表操作对象*/
	private MhqxTabFunctionManager functionmanager;
	/**角色功能操作对象*/
	private MhqxTabRolefunctionManager rolefunctionmanager;
	/**模块ID*/
	private int moduleid;
	/**模块表操作对象*/
	private MhqxTabModuleManager modulemanager;
	/**角色表操作对象*/
	private MhqxTabRoleManager rolemanager;
	/**角色ID*/
	private int rolefunctionmhqxTabRoleFRoleId;
	/**功能ID*/
	private int rolefunctionmhqxTabFunctionFFunctionId;
	/**用户功能表操作对象*/
	private MhqxTabUserfunctionManager userfunctionmanager;
	/**用户角色表操作对象*/
	private MhqxTabRoleUserManager userrolemanager;

	private List<Integer> deletelist = new ArrayList<Integer>();
	
	private List<MhqxTabRole> rolelist = new ArrayList<MhqxTabRole>();
	
	private List<MhqxTabFunction> functionlist = new ArrayList<MhqxTabFunction>();
	
	private List<MhqxTabRolefunction> rolefunctionlist = new ArrayList<MhqxTabRolefunction>();

	public List<MhqxTabModule> getModulelist() {
		return modulelist;
	}

	public void setModulelist(List<MhqxTabModule> modulelist) {
		this.modulelist = modulelist;
	}

	public int getModuleid() {
		return moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public MhqxTabRoleUserManager getUserrolemanager() {
		return userrolemanager;
	}

	public void setUserrolemanager(MhqxTabRoleUserManager userrolemanager) {
		this.userrolemanager = userrolemanager;
	}

	public MhqxTabUserfunction getUserfunction() {
		return userfunction;
	}

	public void setUserfunction(MhqxTabUserfunction userfunction) {
		this.userfunction = userfunction;
	}

	public MhqxTabUserfunctionManager getUserfunctionmanager() {
		return userfunctionmanager;
	}

	public void setUserfunctionmanager(
			MhqxTabUserfunctionManager userfunctionmanager) {
		this.userfunctionmanager = userfunctionmanager;
	}

	public int getRolefunctionmhqxTabRoleFRoleId() {
		return rolefunctionmhqxTabRoleFRoleId;
	}

	public void setRolefunctionmhqxTabRoleFRoleId(
			int rolefunctionmhqxTabRoleFRoleId) {
		this.rolefunctionmhqxTabRoleFRoleId = rolefunctionmhqxTabRoleFRoleId;
	}

	public int getRolefunctionmhqxTabFunctionFFunctionId() {
		return rolefunctionmhqxTabFunctionFFunctionId;
	}

	public void setRolefunctionmhqxTabFunctionFFunctionId(
			int rolefunctionmhqxTabFunctionFFunctionId) {
		this.rolefunctionmhqxTabFunctionFFunctionId = rolefunctionmhqxTabFunctionFFunctionId;
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

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public int getFunctionid() {
		return functionid;
	}

	public void setFunctionid(int functionid) {
		this.functionid = functionid;
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

	public List<MhqxTabRole> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<MhqxTabRole> rolelist) {
		this.rolelist = rolelist;
	}

	public MhqxTabRoleManager getRolemanager() {
		return rolemanager;
	}

	public void setRolemanager(MhqxTabRoleManager rolemanager) {
		this.rolemanager = rolemanager;
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

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getFunctionname() {
		return functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public MhqxTabRolefunction getRolefunction() {
		return rolefunction;
	}

	public void setRolefunction(MhqxTabRolefunction rolefunction) {
		this.rolefunction = rolefunction;
	}

	public MhqxTabRole getRole() {
		return role;
	}

	public void setRole(MhqxTabRole role) {
		this.role = role;
	}

	public MhqxTabFunction getFunction() {
		return function;
	}

	public void setFunction(MhqxTabFunction function) {
		this.function = function;
	}

	public MhqxTabFunctionManager getFunctionmanager() {
		return functionmanager;
	}

	public void setFunctionmanager(MhqxTabFunctionManager functionmanager) {
		this.functionmanager = functionmanager;
	}

	public List<MhqxTabFunction> getFunctionlist() {
		return functionlist;
	}

	public void setFunctionlist(List<MhqxTabFunction> functionlist) {
		this.functionlist = functionlist;
	}
	/**
	 * <p>按照模块，子系统分类显示功能<br>
	 * @return action result 
	 */
	public String getrolelist() {
		this.rolelist.clear();
		this.modulelist.clear();
		this.rolelist = this.rolemanager.findAll();
		this.modulelist = this.modulemanager.findAll();
		
//		if (this.rolename == null && this.moduleid == 0) {
////			this.functionlist = this.functionmanager.findAll();
//			return "getrolelist";
//		} else {
//			this.rolename = this.rolemanager.findById(this.roleid).getFRoleName();
//			// 按角色子系统分类查询
//			List<MhqxTabFunction> functionlist1 = new ArrayList<MhqxTabFunction>();
//			List<MhqxTabFunction> functionlist2 = new ArrayList<MhqxTabFunction>();
//			List<MhqxTabFunction> functionlist3 = new ArrayList<MhqxTabFunction>();
//			functionlist1 = this.functionmanager.findByModuleidandRolename(
//					moduleid, rolename);
//			// functionlist2 = this.functionmanager.findBySuperId(0);
//
//			Iterator<MhqxTabFunction> iterator1 = functionlist1.iterator();
//			while (iterator1.hasNext()) {
//				MhqxTabFunction function = new MhqxTabFunction();
//				function = iterator1.next();
//				if (function.getFSuperFunctionId() == 0)
//					functionlist2.add(function);
//			}
//
//			Iterator<MhqxTabFunction> iterator2 = functionlist2.iterator();
//			while (iterator2.hasNext()) {
//				function = iterator2.next();
//				functionlist3.add(function);
//				List<MhqxTabFunction> functionlist4 = this.functionmanager
//						.findBySuperId(function.getFFunctionId());
//				Iterator<MhqxTabFunction> iterator4 = functionlist4.iterator();
//				while (iterator4.hasNext()) {
//					functionlist3.add(iterator4.next());
//				}
//			}
//			this.functionlist = functionlist3;
//		}
//        
//		int pages = 20;
//		int listlength = this.functionlist.size();
//		if (listlength == 0) {
//			this.modulelist = this.modulemanager.findAll();
//			System.out.println("module number :" + modulelist.size());
//			return "getrolelist";
//		}
//
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
//		this.functionlist = this.functionlist.subList(startIndex, endIndex);
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("rolelist", rolelist);
//		System.out.println("===="+this.rolelist.size());
		return "getrolelist";
	}
	/**
	 * 按角色查找功能
	 */
	public String getrolelistbysearch()
	{
		this.rolefunctionlist = this.rolefunctionmanager.findByRoleId(roleid);
		return "getrolelistbysearch";
	}
	/**
	 * <p>删除单个角色功能<br>
	 * @return action result 
	 */
	public String deleteRoleFunctionRelation() {
		MhqxTabUser user = new MhqxTabUser();

		this.rolefunction = this.rolefunctionmanager.findById(id);
		this.rolefunctionmanager.delete(rolefunction);
		roleid = this.rolefunction.getMhqxTabRole().getFRoleId();
		this.function = this.rolefunction.getMhqxTabFunction();
		Iterator<MhqxTabRoleuser> roleuseriterator = this.userrolemanager
				.findByRoleId(roleid).iterator();
		while (roleuseriterator.hasNext()) {
			user = roleuseriterator.next().getMhqxTabUser();
			Iterator<MhqxTabUserfunction> userfunctioniterator = this.userfunctionmanager
					.findMhqxTabUserfunctionByUserNumber(user.getFUserNumber())
					.iterator();
			while (userfunctioniterator.hasNext()) {
				this.userfunction = userfunctioniterator.next();
				if (this.userfunction.getMhqxTabFunction().getFFunctionName()
						.equals(
								this.rolefunction.getMhqxTabFunction()
										.getFFunctionName())) {
					this.userfunctionmanager.delete(this.userfunction);
				}
			}
		}

		return "deleteRoleFunction";
	}
	/**
	 * <p>多选删除角色功能<br>
	 * @return action result 
	 */
	public String multipledelete() {
		MhqxTabUser user = new MhqxTabUser();
		if (deletelist.size() == 0) {
			return "multipledelete";
		}
		Iterator<Integer> iterator = this.deletelist.iterator();
		int roleid = 0;
		while (iterator.hasNext()) {
			this.rolefunction = this.rolefunctionmanager.findById(iterator
					.next());
			this.rolefunctionmanager.delete(this.rolefunction);
			roleid = this.rolefunction.getMhqxTabRole().getFRoleId();
			this.function = this.rolefunction.getMhqxTabFunction();
			Iterator<MhqxTabRoleuser> roleuseriterator = this.userrolemanager
					.findByRoleId(roleid).iterator();
			while (roleuseriterator.hasNext()) {
				user = roleuseriterator.next().getMhqxTabUser();
				Iterator<MhqxTabUserfunction> userfunctioniterator = this.userfunctionmanager
						.findMhqxTabUserfunctionByUserNumber(
								user.getFUserNumber()).iterator();
				while (userfunctioniterator.hasNext()) {
					this.userfunction = userfunctioniterator.next();
					if (this.userfunction.getMhqxTabFunction()
							.getFFunctionName().equals(
									this.rolefunction.getMhqxTabFunction()
											.getFFunctionName())) {
						this.userfunctionmanager.delete(this.userfunction);
					}
				}
			}
		}
		return "multipledelete";
	}
	/**
	 * <p>修改角色功能关系条目<br>
	 * @return action result
	 */
	public String modifyRoleFunctionRelation() {
		this.rolefunction = this.rolefunctionmanager.findById(id);
		this.rolefunctionmhqxTabFunctionFFunctionId = this.rolefunction
				.getMhqxTabFunction().getFFunctionId();
		this.rolefunctionmhqxTabRoleFRoleId = this.rolefunction
				.getMhqxTabRole().getFRoleId();

		return "modifyRoleFunctionRelation";
	}
	/**
	 * <p>更新角色功能关系条目<br>
	 * @return action result
	 */
	public String updateRoleFunctionRelation() {
		this.role = this.rolemanager.findById(rolefunctionmhqxTabRoleFRoleId);
		this.function = this.functionmanager
				.findById(rolefunctionmhqxTabFunctionFFunctionId);
		if (this.role != null && this.function != null) {
			this.rolefunction.setMhqxTabFunction(this.function);
			this.rolefunction.setMhqxTabRole(this.role);
			this.rolefunctionmanager.update(rolefunction);
		}
		return "updateUserRoleRelation";
	}
	/**
	 * <p>添加角色功能关系条目<br>
	 * @return action result
	 */
	public String addrolefunction() {
		this.role = this.rolemanager.findById(roleid);
		this.function = this.functionmanager.findById(functionid);
		System.out.println("functionid:" + functionid);
		System.out.println("functionname:" + this.function.getFFunctionName());
		System.out.println("rolename:" + this.role.getFRoleName());

		this.functionmanager.save(function);
		this.rolefunction.setMhqxTabFunction(function);
		this.rolefunction.setMhqxTabRole(role);

		this.rolefunctionmanager.save(rolefunction);

		return "addrolefunction";
	}

	/**
	 * <p>多项配置角色功能表<br>
	 * @return action result
	 */
	public String multipleconfig() {
		MhqxTabUser user = new MhqxTabUser();
		Iterator<Integer> iterator = this.deletelist.iterator();
//		this.role = this.rolemanager.findById(roleid);
		System.out.println(rolename);
		this.role = this.rolemanager.findByName(this.rolename).iterator().next();
		MhqxTabRolefunction rolefunction = new MhqxTabRolefunction();
		int flag = 0;
		while (iterator.hasNext()) {
			flag = 0;
			this.function = this.functionmanager.findById(iterator.next());
			Iterator<MhqxTabRolefunction> iterator2 = this.rolefunctionmanager
					.findByRoleId(roleid).iterator();
			while (iterator2.hasNext()) {
				rolefunction = iterator2.next();
				if (rolefunction.getMhqxTabFunction().getFFunctionId().equals(
						this.function.getFFunctionId())) {
					flag = 1;
					break;
				}

			}
			if (flag == 1)
				continue;
			this.rolefunction.setMhqxTabFunction(this.function);
			this.rolefunction.setMhqxTabRole(this.role);
			this.rolefunctionmanager.save(this.rolefunction);
//			System.out.println(this.rolefunction.getMhqxTabRole().getFRoleName()+"--"+this.rolefunction.getMhqxTabFunction().getFFunctionName());
			Iterator<MhqxTabRoleuser> roleuseriterator = this.userrolemanager
					.findByRoleId(roleid).iterator();
			while (roleuseriterator.hasNext()) {
				user = roleuseriterator.next().getMhqxTabUser();
				this.userfunction.setMhqxTabFunction(this.function);
				this.userfunction.setMhqxTabUser(user);
				this.userfunctionmanager.save(this.userfunction);
			}
		}
		return "multipleconfig";
	}
	/**
	 * <p>分页显示角色功能表<br>
	 * @return action result
	 */
	public String showpagelist() {
		this.rolefunctionlist = this.rolefunctionmanager.findAll();
		int pages = 20;
		int listlength = this.rolefunctionlist.size();
		if (listlength == 0)
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
		this.rolefunctionlist = this.rolefunctionlist.subList(startIndex,
				endIndex);

		return "showpagelist";
	}
}
