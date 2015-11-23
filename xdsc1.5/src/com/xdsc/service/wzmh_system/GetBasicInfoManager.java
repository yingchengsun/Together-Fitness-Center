package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabRole;

/**
 * 
 *获取用户基本信息 用户名 （联系方式 邮箱地址等）
 * @author 陈丰
 *
 */
public interface GetBasicInfoManager {
public  void getInfo(String id, List<MhqxTabRole> rolelist);
}
