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
 * ��ɫ���ϲ�ѯ   
 * @author �·�
 *
 */
public interface EntityDAO {
    /**
     * �����ʺŲ�ѯѧ��
	 * @param �ʺ�
	 * @return ѧ��ʵ��
     */
    public TabStudents findStudentByID(String id);
	/**
	 *�����ʺŲ�ѯ��ʦ
	 * @param �ʺ�
	 * @return ��ʦʵ��
	 */
	public TabTeachers findTeacherByID(String id);
	/**
	 *�����ʺŲ�ѯ������
	 * @param �ʺ�
	 * @return ������ʵ��
	 */
	public TabUndergraduate findUndergraduateByID(String id);
	/**
	 * �����ʺŲ�ѯ�о���
	 * @param �ʺ�
	 * @return �о���ʵ��
	 */
	public TabPostgraduate findPostgraduateByID(String id);
	/**
	 * �����ʺŲ�ѯ�ҳ�
	 * @param �ʺ�
	 * @return �ҳ�ʵ��
	 */
	public XsglTabParents findParentsByID(String id);
	/**
	 * �����ʺŲ�ѯ��ҵ
	 * @param �ʺ�
	 * @return ��ҵʵ��
	 */
	public TabCompany findCompanyByID(String id);
	/**
	 * �����ʺŲ�ѯ����
	 * @param �ʺ�
	 * @return ����ʵ��
	 */
	public JfptTabOtherassist findOtherassistByID(String id);
	/**
	 * �����ʺŲ�ѯ����Ա
	 * @param �ʺ�
	 * @return ����Աʵ��
	 */
	public TabAdministrator findAdministratorByID(String id);
}
