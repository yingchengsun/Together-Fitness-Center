package com.xdsc.service.wzmh_system;

import com.xdsc.model.TabStudents;

/**
 * ѧ������
 * @author �·�
 *
 */
public interface StudentManager {
	public TabStudents findStudentByUserNumber(String id);
	public String getStudentInfoTable(String id);
}
