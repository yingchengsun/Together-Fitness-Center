package com.xdsc.action.wzmh_system;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabPicture;
import com.xdsc.model.TabInformation;
import com.xdsc.service.wzmh_system.MhqxTabPictureManager;

/**
 * @author 高雅
 * 
 */
public class MhqxTabPictureAction extends ActionSupport {

	
	/** 图片新闻相关属性 */
	private Integer FId;
	private Integer FInfoId;
	private String FPicTitle;
	private String FPicContent;
	private String FZuiXin;
	 
	private List<MhqxTabPicture> picList;
	private MhqxTabPicture pict;
	
	private TabInformation tabInformation;
	private MhqxTabPictureManager mhqxTabPictureManager;
	
	/** 图片添加所需的变量 */
	private File uploadFile;
	private String uploadFileFileName;
	private String savePath;
	
	/**
	 * 构造函数
	 */
	public MhqxTabPictureAction() {
	}
	
	/**
	 * 增加一条图片记录
	 * @return addSUCCESS
	 * @throws Exception
	 */
	public String add() throws Exception {
	//	System.out.println("action+"+uploadFile+" "+savePath+" "+uploadFileFileName);
		pict = mhqxTabPictureManager.savefile(uploadFile, pict, savePath,
				uploadFileFileName);
		mhqxTabPictureManager.add(pict);
		return "addSUCCESS";
	}
	/**
	 * 将需要更新的图片新闻的内容读取出来显示在页面上
	 * @return preUpdateSUCCESS
	 */
	public String preUpdate() {
		pict = mhqxTabPictureManager.getMhqxTabPictureByID(FId);
		  return "preUpdateSUCCESS";
	}
	/**
	 *更新一条图片记录
	 * @return updateSUCCESS
	 * @throws Exception
	 */
	public String update() throws Exception{
	   pict = mhqxTabPictureManager.getMhqxTabPictureByID(FId);
	   pict = mhqxTabPictureManager.savefile(uploadFile, pict, savePath,
				uploadFileFileName);
	   pict.setFId(FId);
	   pict.setFPicTitle(FPicTitle);
	   pict.setFZuiXin(FZuiXin);
	   pict.setTabInformation(tabInformation);
		mhqxTabPictureManager.update(pict);
		return "updateSUCCESS";
	}
	/**
	 * 通过外键FInfoId查找出与其绑定的图片新闻纪录
	 * @return updateSUCCESS
	 * @throws getByInfoIdSUCCESS
	 */
	public String getByInfoId() throws Exception {
		picList = mhqxTabPictureManager.findByInfoId(FInfoId);
		return "getByInfoIdSUCCESS";}
	
	public Integer getFId() {
		return FId;
	}

	public void setFId(Integer id) {
		FId = id;
	}

	public Integer getFInfoId() {
		return FInfoId;
	}

	public void setFInfoId(Integer infoId) {
		FInfoId = infoId;
	}

	public String getFPicTitle() {
		return FPicTitle;
	}

	public void setFPicTitle(String picTitle) {
		FPicTitle = picTitle;
	}

	public String getFPicContent() {
		return FPicContent;
	}

	public void setFPicContent(String picContent) {
		FPicContent = picContent;
	}

	

	public String getFZuiXin() {
		return FZuiXin;
	}

	public void setFZuiXin(String zuiXin) {
		FZuiXin = zuiXin;
	}

	public List<MhqxTabPicture> getPicList() {
		return picList;
	}

	public void setPicList(List<MhqxTabPicture> picList) {
		this.picList = picList;
	}

	public MhqxTabPicture getPict() {
		return pict;
	}

	public void setPict(MhqxTabPicture pict) {
		this.pict = pict;
	}

	public TabInformation getTabInformation() {
		return tabInformation;
	}

	public void setTabInformation(TabInformation tabInformation) {
		this.tabInformation = tabInformation;
	}

	public MhqxTabPictureManager getMhqxTabPictureManager() {
		return mhqxTabPictureManager;
	}

	public void setMhqxTabPictureManager(MhqxTabPictureManager mhqxTabPictureManager) {
		this.mhqxTabPictureManager = mhqxTabPictureManager;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	
	
}