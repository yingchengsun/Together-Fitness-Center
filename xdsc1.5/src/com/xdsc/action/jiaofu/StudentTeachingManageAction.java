package com.xdsc.action.jiaofu;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabZiwoanpai;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.service.jiaofu.StudentTeachingManageManager;

/**
 * <p>���ܣ���ѧ������ص�ģ�鹦��<br>
 * @author qianxun
 * @version 1.1
 */
public class StudentTeachingManageAction extends ActionSupport implements SessionAware{

	/**service����󣬱��ڵ���service��ķ���*/
    private StudentTeachingManageManager studentTeachingManageManager;
    /**���Ұ�����Ϣ*/
	private List<JfptTabZiwoanpai> listInfo;
	/**���Ұ���*/
	private JfptTabZiwoanpai jfptTabZiwoanpai;
	/**����id��*/
	private int FId;
	/**��ע*/
	private String FBeiZhu;
	/**����*/
	private String FTitle;
	/**User����*/
	private MhqxTabUser mhqxTabUser;
	/**User���*/
	private String FUserNumber;
	/**ʱ��*/
	private Date FDataTime;
	/**ѧ��ѧ��*/
	private String FStudentNumber;
	/**Map���Ͷ���*/
	private Map<String,Object> session;
	/**��ҳ�����м�¼��ǰҳ���*/
	private int p = 1;
	/**��ҳ�����м�¼�������ҳ����*/
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFStudentNumber() {
		return FStudentNumber;
	}

	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}

	public StudentTeachingManageManager getStudentTeachingManageManager() {
		return studentTeachingManageManager;
	}

	public void setStudentTeachingManageManager(
			StudentTeachingManageManager studentTeachingManageManager) {
		this.studentTeachingManageManager = studentTeachingManageManager;
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

	public List<JfptTabZiwoanpai> getListInfo() {
		return listInfo;
	}

	public void setListInfo(List<JfptTabZiwoanpai> listInfo) {
		this.listInfo = listInfo;
	}

	/**
	 * <p>���ܣ����ݸ��˱�Ų�����ص����Ұ�����Ϣ,�����з�ҳ����<br>
	 * @return action findAllInfo
	 */
	public String findAllInfo(){
		FStudentNumber = (String)session.get("FUserNumber");
		listInfo = studentTeachingManageManager.findZiwoanpaiByUserNumber(FStudentNumber);
		
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
	 * <p>���ܣ����ݰ���id�Ų�����ϸ��Ϣ<br>
	 * @return action findInfoDetailByID
	 */
	public String findInfoDetailByID(){
		jfptTabZiwoanpai = studentTeachingManageManager.findZiwoanpaiByID(FId);
		return "findAllInfoDetail";
	}
	
	/**
	 * <p>���ܣ�ͨ������id�Ž�����Ϣɾ��<br>
	 * @return actin deleteInfoByID
	 */
	public String deleteInfoByID(){
		FStudentNumber = (String)session.get("FUserNumber");
		jfptTabZiwoanpai = studentTeachingManageManager.findZiwoanpaiByID(FId);
		studentTeachingManageManager.deleteZiwoanpai(jfptTabZiwoanpai);
		listInfo = studentTeachingManageManager.findZiwoanpaiByUserNumber(FStudentNumber);
		return "deleteInfoByID";
	}
	
	/**
	 * <p>���ܣ������صİ�����Ϣ<br>
	 * @return action addInfo
	 */
	public String addInfo(){//FBeiZhu  FUserNumber FTitle FDataTime
		FStudentNumber = (String)session.get("FUserNumber");
		JfptTabZiwoanpai jfptTabZiwoanpai1 = new JfptTabZiwoanpai() ;
		jfptTabZiwoanpai1.setFBeiZhu(FBeiZhu);
		jfptTabZiwoanpai1.setFTitle(FTitle);
		jfptTabZiwoanpai1.setFDataTime(new Date());
		
		mhqxTabUser = studentTeachingManageManager.findUserByID(FStudentNumber);
		jfptTabZiwoanpai1.setMhqxTabUser(mhqxTabUser);
		
		studentTeachingManageManager.addZiwoanpai(jfptTabZiwoanpai1);
		listInfo = studentTeachingManageManager.findZiwoanpaiByUserNumber(FStudentNumber);
		return "addInfo";
	}
}
