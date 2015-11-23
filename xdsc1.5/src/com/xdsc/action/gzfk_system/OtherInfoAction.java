package com.xdsc.action.gzfk_system;

import java.util.List;

import com.xdsc.model.GzfkTabOtherstudent;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabStudents;
import com.xdsc.service.gzfk_system.OtherInfoService;
import com.xdsc.service.gzfk_system.StudentInfoService;
import com.xdsc.service.gzfk_system.UserLoginService;

/**����ȥ��ѧ����Ϣ����
 * @author ����ٻ
 * @version 1.3
 */
public class OtherInfoAction {
	private Integer FOtherId;
	private TabStudents tabStudents;
	private String FEmail;
	private String FWorkAdd;
	private String FRecord;
	
	private String FStudentNumber;
	
	private List<GzfkTabOtherstudent> listOtherInfo;
	
	private OtherInfoService otherInfoService;
	private StudentInfoService studentInfoService;
	private UserLoginService userLoginService;
	
	private GzfkTabOtherstudent otherStudent = new GzfkTabOtherstudent();
	private TabStudents student=new TabStudents();
	private MhqxTabUser user= new MhqxTabUser();
	
	private String FOtherNameSelect;

	private int p = 1;
    private int lastPage;
    //-----------------
	public Integer getFOtherId() {
		return FOtherId;
	}
	public void setFOtherId(Integer otherId) {
		FOtherId = otherId;
	}
	public TabStudents getTabStudents() {
		return tabStudents;
	}
	public void setTabStudents(TabStudents tabStudents) {
		this.tabStudents = tabStudents;
	}
	public String getFEmail() {
		return FEmail;
	}
	public void setFEmail(String email) {
		FEmail = email;
	}
	public String getFWorkAdd() {
		return FWorkAdd;
	}
	public void setFWorkAdd(String workAdd) {
		FWorkAdd = workAdd;
	}
	public String getFRecord() {
		return FRecord;
	}
	public void setFRecord(String record) {
		FRecord = record;
	}
	public String getFStudentNumber() {
		return FStudentNumber;
	}
	public void setFStudentNumber(String studentNumber) {
		FStudentNumber = studentNumber;
	}
	public List<GzfkTabOtherstudent> getListOtherInfo() {
		return listOtherInfo;
	}
	public void setListOtherInfo(List<GzfkTabOtherstudent> listOtherInfo) {
		this.listOtherInfo = listOtherInfo;
	}
	public OtherInfoService getOtherInfoService() {
		return otherInfoService;
	}
	public void setOtherInfoService(OtherInfoService otherInfoService) {
		this.otherInfoService = otherInfoService;
	}
	public StudentInfoService getStudentInfoService() {
		return studentInfoService;
	}
	public void setStudentInfoService(StudentInfoService studentInfoService) {
		this.studentInfoService = studentInfoService;
	}
	public GzfkTabOtherstudent getOtherStudent() {
		return otherStudent;
	}
	public void setOtherStudent(GzfkTabOtherstudent otherStudent) {
		this.otherStudent = otherStudent;
	}
	public String getFOtherNameSelect() {
		return FOtherNameSelect;
	}
	public void setFOtherNameSelect(String otherNameSelect) {
		FOtherNameSelect = otherNameSelect;
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
    //-------------------
	
	/**�г�����������ҵȥ��ѧ����Ϣ��Ӧ
	 * @return findAllOtherInfo �������м�¼
	 */
	public String findAllOtherInfo(){
		listOtherInfo = otherInfoService.findOtherInfo();
		if(listOtherInfo.size()>10){
			int pages = 10;
			int listlength = this.listOtherInfo.size();
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
			this.listOtherInfo = this.listOtherInfo.subList(startIndex, endIndex);
		}
		return "findAllOtherInfo";
	}
	
	/**�������ȥ��ѧ����Ϣ��Ӧ
	 * @return addOtherInfo ��ӳɹ�
	 */
	public String addOtherInfo(){
		otherStudent.setFEmail(FEmail);
		otherStudent.setFOtherId(FOtherId);
		otherStudent.setFRecord(FRecord);
		otherStudent.setFWorkAdd(FWorkAdd);
		
		TabStudents student=new TabStudents();
		student = studentInfoService.findStudentByNum(FStudentNumber);
		otherStudent.setTabStudents(student);
		
		otherInfoService.addOtherStudent(otherStudent);
		listOtherInfo = otherInfoService.findOtherInfo();
		
		return "addOtherInfo";
			
	}
	
	/**ͨ��ѧ��ID�ҵ���Ӧ��¼��Ϣ
	 * @return findOtherInfoByID ������Ӧ��Ϣ
	 */
	public String findOtherInfoByID(){
		otherStudent = otherInfoService.findOtherInfoByID(FOtherId);
		return "findOtherInfoByID";
	}
	
	/**ͨ�������ҵ���Ӧ��¼
	 * @return findOtherInfoByName ������Ӧ��¼
	 */
	public String findOtherInfoByName(){
		listOtherInfo = otherInfoService.findOtherInfoByName(FOtherNameSelect);
		return "findOtherInfoByName";
	}
	
	/**ͨ��IDɾ������ȥ��ѧ��
	 * @return deleteOtherInfoByID ɾ���ɹ�
	 */
	public String deleteOtherInfoByID(){
		otherStudent = otherInfoService.findOtherInfoByID(FOtherId);
		otherInfoService.deleteOtherInfo(otherStudent);
		listOtherInfo = otherInfoService.findOtherInfo();

		return "deleteOtherInfoByID";
	}
	
	/**��������ѧ����Ϣ��Ӧ
	 * @return updateOtherInfo���³ɹ�
	 */
	public String updateOtherInfo(){
		otherStudent.setFEmail(FEmail);
		otherStudent.setFRecord(FRecord);
		otherStudent.setFWorkAdd(FWorkAdd);
		otherInfoService.updateOtherInfo(otherStudent);
		listOtherInfo = otherInfoService.findOtherInfo();

		return "updateOtherInfo";
	}
	public TabStudents getStudent() {
		return student;
	}
	public void setStudent(TabStudents student) {
		this.student = student;
	}
	public MhqxTabUser getUser() {
		return user;
	}
	public void setUser(MhqxTabUser user) {
		this.user = user;
	}
	public UserLoginService getUserLoginService() {
		return userLoginService;
	}
	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
}
	
	
