package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.service.jiaofu.AdminStudentScoreManager;

/**
 * <p>���ܣ�����Ա��ѧ��ƽʱ�ɼ����й�����Ҫ�ǽ�����Ϣɾ��<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminStudentScoreAction extends ActionSupport{

	/**service��Ķ��󣬱��ڵ���service��ķ���*/
	private AdminStudentScoreManager adminStudentScoreManager;
	/**ѧ��ƽʱ�ɼ���Ϣ����*/
	private List<JfptTabUsualscore> listUsualscoreInfo;
	/**ѧ��*/
	private String FXueQi;
	/**�γ�����*/
	private String FCourseName;
	/**�ɼ�����������*/
	private int FNumber;
	/**�����ɼ�*/
	private int FBuKaoScore;
	/**��ĩ�ɼ�*/
	private int FQiMoScore;
	/**���гɼ�*/
	private int FQiZhongScore;
	/**�ܷ�*/
	private int FTotalScore;
	/**ƽʱ�ɼ�����*/
	private int FTotalUsually;
	/**��ҳ�����м�¼��ǰҳ���*/
	private int p = 1;
	/**��ҳ�����м�¼��ѯ���������ҳ��*/
	private int lastPage;
	/**��¼jspҳ����ѡ�е���ϢId��*/
	private List<Integer> deletelist1;
	/**��¼jspҳ����ѡ�е���ϢId��*/
	private List<Integer> deletelist2;

	public List<Integer> getDeletelist2() {
		return deletelist2;
	}

	public void setDeletelist2(List<Integer> deletelist2) {
		this.deletelist2 = deletelist2;
	}

	public List<Integer> getDeletelist1() {
		return deletelist1;
	}

	public void setDeletelist1(List<Integer> deletelist1) {
		this.deletelist1 = deletelist1;
	}

	public AdminStudentScoreManager getAdminStudentScoreManager() {
		return adminStudentScoreManager;
	}

	public void setAdminStudentScoreManager(
			AdminStudentScoreManager adminStudentScoreManager) {
		this.adminStudentScoreManager = adminStudentScoreManager;
	}

	public String getFXueQi() {
		return FXueQi;
	}

	public void setFXueQi(String xueQi) {
		FXueQi = xueQi;
	}

	public String getFCourseName() {
		return FCourseName;
	}

	public void setFCourseName(String courseName) {
		FCourseName = courseName;
	}

	public int getFNumber() {
		return FNumber;
	}

	public void setFNumber(int number) {
		FNumber = number;
	}

	public int getFBuKaoScore() {
		return FBuKaoScore;
	}

	public void setFBuKaoScore(int buKaoScore) {
		FBuKaoScore = buKaoScore;
	}

	public int getFQiMoScore() {
		return FQiMoScore;
	}

	public void setFQiMoScore(int qiMoScore) {
		FQiMoScore = qiMoScore;
	}

	public int getFQiZhongScore() {
		return FQiZhongScore;
	}

	public void setFQiZhongScore(int qiZhongScore) {
		FQiZhongScore = qiZhongScore;
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

	public int getFTotalScore() {
		return FTotalScore;
	}

	public void setFTotalScore(int totalScore) {
		FTotalScore = totalScore;
	}

	public List<JfptTabUsualscore> getListUsualscoreInfo() {
		return listUsualscoreInfo;
	}

	public void setListUsualscoreInfo(List<JfptTabUsualscore> listUsualscoreInfo) {
		this.listUsualscoreInfo = listUsualscoreInfo;
	}

	public int getFTotalUsually() {
		return FTotalUsually;
	}

	public void setFTotalUsually(int totalUsually) {
		FTotalUsually = totalUsually;
	}

	/**
	 * <p>���ܣ���ѯ���ɼ���Ϣ��������ؽ�������з�ҳ����<br>
	 * @return action findUsualScore
	 */
	public String findUsualScore(){
		listUsualscoreInfo = adminStudentScoreManager.findUsualScore();
		
		int pages = 5;
		int listlength = listUsualscoreInfo.size();
		if(listlength==0)
			return "findUsualScore";
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
		listUsualscoreInfo = listUsualscoreInfo.subList(startIndex, endIndex);
		
		return "findUsualScore";
	}
	
	/**
	 * <p>���ܣ����ݿγ����ƽ��гɼ�ѡȡ�����Խ�����з�ҳ����<br>
	 * @return action findUsualSelectInfo
	 */
    public String findUsualSelectInfo(){
    	listUsualscoreInfo = adminStudentScoreManager.findUsualSelectInfoBy(FCourseName);
    	
    	int pages = 5;
		int listlength = listUsualscoreInfo.size();
		if(listlength==0)
			return "findUsualScore";
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
		listUsualscoreInfo = listUsualscoreInfo.subList(startIndex, endIndex);
		
    	return "findUsualSelectInfo";
    }
    
    /**
     * <p>���ܣ�ɾ����¼�ĳɼ���Ϣ<br>
     */
    public String deletelist1(){
    	for(int i:deletelist1){
    		JfptTabUsualscore haha = adminStudentScoreManager.findUsualScoreInfoByID(i);
    		adminStudentScoreManager.deleteUsualScoreInfo(haha);
    	}
    	return "deletelist1";
    }
    
    
    /**
     * <p>���ܣ�ɾ����¼�ĳɼ���Ϣ<br>
     */
    public String deletelist2(){
    	for(int i:deletelist2){
    		JfptTabUsualscore haha = adminStudentScoreManager.findUsualScoreInfoByID(i);
    		adminStudentScoreManager.deleteUsualScoreInfo(haha);
    	}
    	return "deletelist2";
    }
}
