package com.xdsc.action.jiaofu;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.service.jiaofu.AdminStudentScoreManager;

/**
 * <p>功能：管理员对学生平时成绩进行管理，主要是进行信息删除<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminStudentScoreAction extends ActionSupport{

	/**service层的对象，便于调用service层的方法*/
	private AdminStudentScoreManager adminStudentScoreManager;
	/**学生平时成绩信息对象集*/
	private List<JfptTabUsualscore> listUsualscoreInfo;
	/**学期*/
	private String FXueQi;
	/**课程名称*/
	private String FCourseName;
	/**成绩对象主键号*/
	private int FNumber;
	/**补考成绩*/
	private int FBuKaoScore;
	/**期末成绩*/
	private int FQiMoScore;
	/**期中成绩*/
	private int FQiZhongScore;
	/**总分*/
	private int FTotalScore;
	/**平时成绩汇总*/
	private int FTotalUsually;
	/**分页处理中记录当前页面号*/
	private int p = 1;
	/**分页处理中记录查询结果集的总页数*/
	private int lastPage;
	/**记录jsp页面中选中的信息Id号*/
	private List<Integer> deletelist1;
	/**记录jsp页面中选中的信息Id号*/
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
	 * <p>功能：查询出成绩信息，并对相关结果集进行分页处理<br>
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
	 * <p>功能：根据课程名称进行成绩选取，并对结果进行分页处理<br>
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
     * <p>功能：删除记录的成绩信息<br>
     */
    public String deletelist1(){
    	for(int i:deletelist1){
    		JfptTabUsualscore haha = adminStudentScoreManager.findUsualScoreInfoByID(i);
    		adminStudentScoreManager.deleteUsualScoreInfo(haha);
    	}
    	return "deletelist1";
    }
    
    
    /**
     * <p>功能：删除记录的成绩信息<br>
     */
    public String deletelist2(){
    	for(int i:deletelist2){
    		JfptTabUsualscore haha = adminStudentScoreManager.findUsualScoreInfoByID(i);
    		adminStudentScoreManager.deleteUsualScoreInfo(haha);
    	}
    	return "deletelist2";
    }
}
