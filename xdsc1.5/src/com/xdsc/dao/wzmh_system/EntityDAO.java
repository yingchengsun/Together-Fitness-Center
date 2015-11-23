package com.xdsc.dao.wzmh_system;

import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabAdministrator;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.model.XsglTabParents;
/**
 * 角色资料查询   
 * @author 陈丰
 *
 */
public interface EntityDAO {
    /**
     * 根据帐号查询学生
	 * @param 帐号
	 * @return 学生实例
     */
    public TabStudents findStudentByID(String id);
	/**
	 *根据帐号查询教师
	 * @param 帐号
	 * @return 教师实例
	 */
	public TabTeachers findTeacherByID(String id);
	/**
	 *根据帐号查询本科生
	 * @param 帐号
	 * @return 本科生实例
	 */
	public TabUndergraduate findUndergraduateByID(String id);
	/**
	 * 根据帐号查询研究生
	 * @param 帐号
	 * @return 研究生实例
	 */
	public TabPostgraduate findPostgraduateByID(String id);
	/**
	 * 根据帐号查询家长
	 * @param 帐号
	 * @return 家长实例
	 */
	public XsglTabParents findParentsByID(String id);
	/**
	 * 根据帐号查询企业
	 * @param 帐号
	 * @return 企业实例
	 */
	public TabCompany findCompanyByID(String id);
	/**
	 * 根据帐号查询助教
	 * @param 帐号
	 * @return 助教实例
	 */
	public JfptTabOtherassist findOtherassistByID(String id);
	/**
	 * 根据帐号查询管理员
	 * @param 帐号
	 * @return 管理员实例
	 */
	public TabAdministrator findAdministratorByID(String id);
}
