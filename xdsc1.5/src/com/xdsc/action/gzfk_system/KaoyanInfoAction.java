package com.xdsc.action.gzfk_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.GzfkTabKaoyanstudent;
import com.xdsc.model.GzfkTabStudyuniversity;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;
import com.xdsc.service.gzfk_system.KaoyanInfoService;
import com.xdsc.service.gzfk_system.StudentInfoService;
import com.xdsc.service.gzfk_system.UniInfoService;

/**深造学生信息处理
 * @author Administrator
 * @version 1.3
 */
public class KaoyanInfoAction extends ActionSupport{
	
	private Integer FNumber;
	private String FKaoyanMajor;
	private String FEmail;
	private String FStudentDegre;
	private String FWorkAdd;

	private Integer FUniId;
	private String FStudentNumber;
	
	private List<GzfkTabKaoyanstudent> listKaoyanInfo;
	private List<TabStudents> listStudentInfo;
	
	private KaoyanInfoService kaoyanInfoService;
	private StudentInfoService studentInfoService;
	private UniInfoService uniInfoService;
	
	private GzfkTabKaoyanstudent kaoyanStudent = new GzfkTabKaoyanstudent();
	
	private String FKaoyanNameselect;
	
	private int p = 1;
    private int lastPage;
    
	//------------------------
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

	public Integer getFNumber() {
		return FNumber;
	}
	public void setFNumber(Integer number) {
		FNumber = number;
	}


	public String getFKaoyanMajor() {
		return FKaoyanMajor;
	}
	public void setFKaoyanMajor(String kaoyanMajor) {
		FKaoyanMajor = kaoyanMajor;
	}
	public String getFEmail() {
		return FEmail;
	}
	public void setFEmail(String email) {
		FEmail = email;
	}
	public String getFStudentDegre() {
		return FStudentDegre;
	}
	public void setFStudentDegre(String studentDegre) {
		FStudentDegre = studentDegre;
	}
	public String getFWorkAdd() {
		return FWorkAdd;
	}
	public void setFWorkAdd(String workAdd) {
		FWorkAdd = workAdd;
	}

	public Integer getFUniId() {
		return FUniId;
	}
	public void setFUniId(Integer uniId) {
		FUniId = uniId;
	}
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	public List<GzfkTabKaoyanstudent> getListKaoyanInfo() {
		return listKaoyanInfo;
	}
	public void setListKaoyanInfo(List<GzfkTabKaoyanstudent> listKaoyanInfo) {
		this.listKaoyanInfo = listKaoyanInfo;
	}
	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}
	public UniInfoService getUniInfoService() {
		return uniInfoService;
	}
	public void setUniInfoService(UniInfoService uniInfoService) {
		this.uniInfoService = uniInfoService;
	}
	public String getFKaoyanNameselect() {
		return FKaoyanNameselect;
	}
	public void setFKaoyanNameselect(String kaoyanNameselect) {
		FKaoyanNameselect = kaoyanNameselect;
	}
	public KaoyanInfoService getKaoyanInfoService() {
		return kaoyanInfoService;
	}
	public void setKaoyanInfoService(KaoyanInfoService kaoyanInfoService) {
		this.kaoyanInfoService = kaoyanInfoService;
	}
	public GzfkTabKaoyanstudent getKaoyanStudent() {
		return kaoyanStudent;
	}
	public void setKaoyanStudent(GzfkTabKaoyanstudent kaoyanStudent) {
		this.kaoyanStudent = kaoyanStudent;
	}

	//-----------------------
	/**列出所有深造学生信息的响应
	 * @return findAllKaoyanInfo 返回所有记录
	 */
	public String findAllKaoyanInfo(){
		listKaoyanInfo = kaoyanInfoService.findKaoyanInfo();
		if(listKaoyanInfo.size()>10){
			int pages = 10;
			int listlength = this.listKaoyanInfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listKaoyanInfo = this.listKaoyanInfo.subList(startIndex, endIndex);
		}
		return "findAllKaoyanInfo";
	}
	
	/**添加深造学生信息响应
	 * @return addKaoyanInfo 添加成功
	 */
	public String addKaoyanInfo(){
		GzfkTabKaoyanstudent kaoyanStudent = new GzfkTabKaoyanstudent();
		System.out.println("start");
		kaoyanStudent.setFEmail(FEmail);
		kaoyanStudent.setFKaoyanMajor(FKaoyanMajor);
		kaoyanStudent.setFStudentDegre(FStudentDegre);
		kaoyanStudent.setFWorkAdd(FWorkAdd);
		
		TabStudents student=new TabStudents();
		student = studentInfoService.findStudentByNum(FStudentNumber);
		kaoyanStudent.setTabStudents(student);
		
		GzfkTabStudyuniversity uni = new GzfkTabStudyuniversity();
		uni = uniInfoService.findUniByNum(FUniId);
		kaoyanStudent.setGzfkTabStudyuniversity(uni);
		
		kaoyanInfoService.addKaoyanStudent(kaoyanStudent);
		listKaoyanInfo = kaoyanInfoService.findKaoyanInfo();
		
		return "addKaoyanInfo";
		
	}
	
	/**通过深造学生ID找到系那个应记录响应
	 * @return findKaoyanInfoByID 返回记录
	 */
	public String findKaoyanInfoByID(){
		//GzfkTabKaoyanstudent kaoyanStudent = new GzfkTabKaoyanstudent();
		kaoyanStudent = kaoyanInfoService.findKaoyanInfoByID(FNumber);
		return "findKaoyanInfoByID";
	}

	/**通过深造学生姓名找到相应记录
	 * @return findKaoyanInfoByName 返回记录
	 */
	public String findKaoyanInfoByName(){
		listKaoyanInfo = kaoyanInfoService.findKaoyanInfoByName(FKaoyanNameselect);
		return "findKaoyanInfoByName";
	}
	
	/**删除深造学生信息响应
	 * @return deleteKaoyanInfoByID 删除成功
	 */
	public String deleteKaoyanInfoByID(){
		//GzfkTabKaoyanstudent kaoyanStudent = new GzfkTabKaoyanstudent();
		kaoyanStudent = kaoyanInfoService.findKaoyanInfoByID(FNumber);
		kaoyanInfoService.deleteKaoyanInfo(kaoyanStudent);
		
		listKaoyanInfo = kaoyanInfoService.findKaoyanInfo();
		return "deleteKaoyanInfoByID";
	}
	
	/**更新深造学生信息响应
	 * @return updateKaoyanInfo 更新成功
	 */
	public String updateKaoyanInfo(){
		 
		kaoyanStudent.setFEmail(FEmail);
		kaoyanStudent.setFKaoyanMajor(FKaoyanMajor);
		kaoyanStudent.setFStudentDegre(FStudentDegre);
		kaoyanStudent.setFWorkAdd(FWorkAdd);
		kaoyanInfoService.updateKaoyanInfo(kaoyanStudent);
		listKaoyanInfo = kaoyanInfoService.findKaoyanInfo();
		
		return "updateKaoyanInfo";
	}

	
}
