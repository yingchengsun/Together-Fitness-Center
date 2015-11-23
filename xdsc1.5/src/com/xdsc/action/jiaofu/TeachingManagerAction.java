package com.xdsc.action.jiaofu;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.OwnArrangementManager;

/**
 * <p>功能：教学管理相关的模块功能<br>
 * @author qianxun
 * @version 1.1
 */
public class TeachingManagerAction extends ActionSupport implements SessionAware{

	//public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number)
	/**service层对象，便于调用service层的方法*/
	private OwnArrangementManager ownArrangementManager;
	/**自我安排信息*/
	private List<JfptTabZiwoanpai> listInfo;
	/**自我安排*/
	private JfptTabZiwoanpai jfptTabZiwoanpai;
	/**安排id号*/
	private int FId;
	/**备注*/
	private String FBeiZhu;
	/**标题*/
	private String FTitle;
	/**User对象*/
	private MhqxTabUser mhqxTabUser;
	/**User编号*/
	private String FUserNumber;
	/**时间*/
	private Date FDataTime;
	/**教师编号*/
	private String FTeacherNumber;
	/**Map类型对象*/
	private Map<String,Object> session;
	/**分页处理中记录当前页面号*/
	private int p = 1;
	/**分页处理中记录结果集总页面数*/
	private int lastPage;
	
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

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Date getFDataTime() {
		return FDataTime;
	}

	public void setFDataTime(Date dataTime) {
		FDataTime = dataTime;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}

	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}

	public String getFBeiZhu() {
		return FBeiZhu;
	}

	public void setFBeiZhu(String beiZhu) {
		FBeiZhu = beiZhu;
	}

	public String getFTitle() {
		return FTitle;
	}

	public void setFTitle(String title) {
		FTitle = title;
	}

	public JfptTabZiwoanpai getJfptTabZiwoanpai() {
		return jfptTabZiwoanpai;
	}

	public void setJfptTabZiwoanpai(JfptTabZiwoanpai jfptTabZiwoanpai) {
		this.jfptTabZiwoanpai = jfptTabZiwoanpai;
	}

	public int getFId() {
		return FId;
	}

	public void setFId(int id) {
		FId = id;
	}

	public OwnArrangementManager getOwnArrangementManager() {
		return ownArrangementManager;
	}

	public void setOwnArrangementManager(OwnArrangementManager ownArrangementManager) {
		this.ownArrangementManager = ownArrangementManager;
	}

	public List<JfptTabZiwoanpai> getListInfo() {
		return listInfo;
	}

	public void setListInfo(List<JfptTabZiwoanpai> listInfo) {
		this.listInfo = listInfo;
	}

	/**
	 * <p>功能：根据个人编号查找相关的自我安排信息,并进行分页处理<br>
	 * @return action findAllInfo
	 */
	public String findAllInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listInfo = ownArrangementManager.findZiwoanpaiByUserNumber(FTeacherNumber);
		
		int pages = 5;
		int listlength = listInfo.size();
		if(listlength==0)
			return "findAllInfo";
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
		listInfo = listInfo.subList(startIndex, endIndex);
		
		return "findAllInfo";
	}
	
	/**
	 * <p>功能：根据安排id号查找详细信息<br>
	 * @return action findInfoDetailByID
	 */
	public String findInfoDetailByID(){
		jfptTabZiwoanpai = ownArrangementManager.findZiwoanpaiByID(FId);
		return "findAllInfoDetail";
	}
	
	/**
	 * <p>功能：通过安排id号进行信息删除<br>
	 * @return actin deleteInfoByID
	 */
	public String deleteInfoByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabZiwoanpai = ownArrangementManager.findZiwoanpaiByID(FId);
		ownArrangementManager.deleteZiwoanpai(jfptTabZiwoanpai);
		listInfo = ownArrangementManager.findZiwoanpaiByUserNumber(FTeacherNumber);
		return "deleteInfoByID";
	}
	
	/**
	 * <p>功能：添加相关的安排信息<br>
	 * @return action addInfo
	 */
	public String addInfo(){//FBeiZhu  FUserNumber FTitle FDataTime
		FTeacherNumber = (String)session.get("FUserNumber");
		JfptTabZiwoanpai jfptTabZiwoanpai1 = new JfptTabZiwoanpai() ;
		jfptTabZiwoanpai1.setFBeiZhu(FBeiZhu);
		jfptTabZiwoanpai1.setFTitle(FTitle);
		jfptTabZiwoanpai1.setFDataTime(new Date());
		
		mhqxTabUser = ownArrangementManager.findUserByID(FTeacherNumber);
		jfptTabZiwoanpai1.setMhqxTabUser(mhqxTabUser);
		
		ownArrangementManager.addZiwoanpai(jfptTabZiwoanpai1);
		listInfo = ownArrangementManager.findZiwoanpaiByUserNumber(FTeacherNumber);
		return "addInfo";
	}
}
