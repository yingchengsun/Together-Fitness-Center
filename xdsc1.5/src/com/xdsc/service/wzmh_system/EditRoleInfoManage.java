package com.xdsc.service.wzmh_system;
/**
 * �༭��ɫ��Ϣ
 * @author �·�
 *
 */
public interface EditRoleInfoManage {
	/**
	 * �༭��ɫ��Ϣ
	 * @param ��ɫ���ͱ�� ����Ա 0����ʦ����ʦ������Ա 1������4���ҳ� 5����ҵ6��������7���о���8
	 * @param �û��˺�
	 * @param �Ƿ�Ϊ����Ա
	 * @return jsp����
	 */
	public String editRole(int roletype,String id,boolean isAdimin); 
}
