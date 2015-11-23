package com.xdsc.dao.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabJiangzhuDAO;
import com.xdsc.model.TabStudents;
import com.xdsc.model.XsglTabJiangzhu;

public class XsglTabJiangzhuDAOImpl extends HibernateDaoSupport implements XsglTabJiangzhuDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhuDAO#saveFStudent(com.xdsc.model.xsgl_system.XsglTabJiangzhu)
	 */
	public boolean saveFStudent(XsglTabJiangzhu fstudent){
		this.getHibernateTemplate().save(fstudent);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhuDAO#deleteFStudent(com.xdsc.model.xsgl_system.XsglTabJiangzhu)
	 */
	public boolean deleteFStudent(XsglTabJiangzhu fstudent){
		this.getHibernateTemplate().delete(fstudent);
		return true;
	}
	
	public boolean updateFStudent(XsglTabJiangzhu fstudent){
		this.getHibernateTemplate().update(fstudent);
		return true;
	}
	
	public XsglTabJiangzhu getFStudentByFid(int fid){
		String hql="from XsglTabJiangzhu xtjz where xtjz.FId='"+fid+"'";
		return (XsglTabJiangzhu)this.getHibernateTemplate().find(hql).get(0);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhuDAO#getFStudentList()
	 */
	public List<XsglTabJiangzhu> getFStudentList(){
		String hql="from XsglTabJiangzhu";
		//String sql="select s.FStudentName from TabStudents s where s.tabClasses.FClassNumber="+di+"  and s.FStudentPoliStatus='"+sk+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabJiangzhuDAO#getFStudentListByStuNum(java.lang.String)
	 */
	public List<XsglTabJiangzhu> getFStudentListByStuNum(String stuNum){
		String hql="from XsglTabJiangzhu xtjz where xtjz.tabStudents.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabJiangzhu> getFStudentListByClass(String classnumber) {
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.FClassNumber='"
				+ classnumber + "'";
		return this.getHibernateTemplate().find(hql);
		
	}

	public List<XsglTabJiangzhu> getFStudentListByLoan() {
		String hql = "from XsglTabJiangzhu xtjz where xtjz.FName like '%助学贷款%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getGradeStudentListByLoan(Date startDate, Date endDate){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.FStudentRegData >= :startDate and xtjz.tabStudents.FStudentRegData <= :endDate and xtjz.FName like '%助学贷款%'";
		String[] params={"startDate","endDate"};
		Object[] args={startDate,endDate};
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
	public List<XsglTabJiangzhu> getGradeStuByLoan(int gradeId){
		String hql="from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.tabGrade.FGradeId='"+gradeId+"' and xtjz.FName like '%助学贷款%'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabJiangzhu> getFStudentListByScholarship() {
		String hql = "from XsglTabJiangzhu xtjz where xtjz.FName like '%奖学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getGradeStudentListByScholarship(Date startDate, Date endDate){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.FStudentRegData >= :startDate and xtjz.tabStudents.FStudentRegData <= :endDate and xtjz.FName like '%奖学金%'";
		String[] params={"startDate","endDate"};
		Object[] args={startDate,endDate};
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
	
	public List<XsglTabJiangzhu> getGradeStuBySholarship(int gradeId){
		String hql="from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.tabGrade.FGradeId='"+gradeId+"' and xtjz.FName like '%奖学金%'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabJiangzhu> getFStudentListByStipend() {
		String hql = "from XsglTabJiangzhu xtjz where xtjz.FName like '%助学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getGradeStudentListByStipend(Date startDate, Date endDate){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.FStudentRegData >= :startDate and xtjz.tabStudents.FStudentRegData <= :endDate and xtjz.FName like '%助学金%'";
		String[] params={"startDate","endDate"};
		Object[] args={startDate,endDate};
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
	
	public List<XsglTabJiangzhu> getGradeStuByStipend(int gradeId){
		String hql="from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.tabGrade.FGradeId='"+gradeId+"' and xtjz.FName like '%奖学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getStudentListByNameYearClass(String name,String year,String classid){
		String hql="from XsglTabJiangzhu xtjz where xtjz.FYear='"+year+"' and xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"' and xtjz.FName like'%"+name+"%'";
		return this.getHibernateTemplate().find(hql);
	}

	public List<XsglTabJiangzhu> getFStudentListByOption(String year,
			String classid) {
		String hql="from XsglTabJiangzhu xtjz where xtjz.FYear='"+year+"'and xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"'and xtjz.FName like '%助学贷款%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getFStudentListBySchOption(String year,String classid){
		String hql="from XsglTabJiangzhu xtjz where xtjz.FYear='"+year+"'and xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"'and xtjz.FName like '%奖学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getFStudentListByStiOption(String year,String classid){
		String hql="from XsglTabJiangzhu xtjz where xtjz.FYear='"+year+"'and xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"'and xtjz.FName like '%助学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getClassStudentByLoan(String classid){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"' and xtjz.FName like '%助学贷款%'";
		return this.getHibernateTemplate().find(hql);
	}
	public List<XsglTabJiangzhu> getClassStudentByStipend(String classid){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"' and xtjz.FName like '%助学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	public List<XsglTabJiangzhu> getClassStudentBySholarship(String classid){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.tabClasses.FClassNumber='"+classid+"' and xtjz.FName like '%奖学金%'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabJiangzhu> getFundStuByStuNum(String stuNum){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	public List<XsglTabJiangzhu> getFundStuByStuName(String stuName){
		String hql = "from XsglTabJiangzhu xtjz where xtjz.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
}
