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
 * <p>���ܣ���ѧ������ص�ģ�鹦��<br>
 * @author qianxun
 * @version 1.1
 */
public class TeachingManagerAction extends ActionSupport implements SessionAware{

	//public List<JfptTabZiwoanpai> findZiwoanpaiByUserNumber(String number)
	/**service����󣬱��ڵ���service��ķ���*/
	private OwnArrangementManager ownArrangementManager;
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
	/**��ʦ���*/
	private String FTeacherNumber;
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
	 * <p>���ܣ����ݸ��˱�Ų�����ص����Ұ�����Ϣ,�����з�ҳ����<br>
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
	 * <p>���ܣ����ݰ���id�Ų�����ϸ��Ϣ<br>
	 * @return action findInfoDetailByID
	 */
	public String findInfoDetailByID(){
		jfptTabZiwoanpai = ownArrangementManager.findZiwoanpaiByID(FId);
		return "findAllInfoDetail";
	}
	
	/**
	 * <p>���ܣ�ͨ������id�Ž�����Ϣɾ��<br>
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
	 * <p>���ܣ������صİ�����Ϣ<br>
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
