package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabRole;

/**
 * 
 *��ȡ�û�������Ϣ �û��� ����ϵ��ʽ �����ַ�ȣ�
 * @author �·�
 *
 */
public interface GetBasicInfoManager {
public  void getInfo(String id, List<MhqxTabRole> rolelist);
}
