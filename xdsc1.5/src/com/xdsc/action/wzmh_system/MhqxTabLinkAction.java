package com.xdsc.action.wzmh_system;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabLink;

import com.xdsc.service.wzmh_system.MhqxTabLinkManager;
import com.xdsc.util.MultiPage;

/**
 * @author ����
 * 
 */
public class MhqxTabLinkAction extends ActionSupport {

	private Integer FLinkId;
	private String FLinkTitle;
	private String FLinkUrl;
	private Integer FLinkPriority;

	private List<String> check;
	
	public List<String> getCheck() {
		return check;
	}
	public void setCheck(List<String> check) {
		this.check = check;
	}

	private MhqxTabLink l;
	private List<MhqxTabLink> linkList;// ��������
	private MhqxTabLinkManager mhqxTabLinkManager;
	
	/** ��ҳ�������ı��� */
	private int p = 1;
	private int lastPage;
	
	/**
	 * ���캯��
	 */
	public MhqxTabLinkAction() {
	}
	/**
	 * ����һ��link��¼
	 * @return addSUCCESS
	 * @throws Exception
	 */
	public String add() throws Exception {
		mhqxTabLinkManager.add(l);
		return "addSUCCESS";
	}
	/**
	 * ɾ��һ��link��¼
	 * @return deleteSUCCESS
	 * @throws Exception
	 */
	public String delete() throws Exception {
		mhqxTabLinkManager.delete(mhqxTabLinkManager.getMhqxTabLinkByID(FLinkId));
		return "deleteSUCCESS";
	}
	
	/**
	 * ɾ������link��¼
	 * @return deleteSUCCESS
	 * @throws Exception
	 */
	public String deleteAll() throws Exception {
		for(String s:check){
			int id=Integer.parseInt(s);
		mhqxTabLinkManager.delete(mhqxTabLinkManager.getMhqxTabLinkByID(id));
		}
		return "deleteSUCCESS";
	}
	
	/**
	 * ����Ҫ���µ�link��¼�����ݶ�ȡ������ʾ��ҳ����
	 * @return preUpdateSUCCESS
	 */
	public String preUpdate() {
		l = mhqxTabLinkManager.getMhqxTabLinkByID(FLinkId);
		  return "preUpdateSUCCESS";
	}
	
	/**
	 * ����һ��link��¼
	 * @return updateSUCCESS
	 * @throws Exception
	 */
	public String update() throws Exception{
		MhqxTabLink m = mhqxTabLinkManager.getMhqxTabLinkByID(FLinkId);
		m.setFLinkId(FLinkId);
		m.setFLinkPriority(FLinkPriority);
		m.setFLinkTitle(FLinkTitle);
		m.setFLinkUrl(FLinkUrl);
		 mhqxTabLinkManager.update(m);
	
          return "updateSUCCESS";
	}

   /**
    * ������ݿ������е�link��¼
    * ��ҳ���
    * @return listAllSUCCESS
    * @throws Exception
   */
	public String listAll() throws Exception {
		linkList = mhqxTabLinkManager.findAllMhqxTabLink();
		if (linkList!=null&&linkList.size()>10) {
			int pages = 10;
			int listlength = linkList.size();
			if (listlength % pages == 0) {
				lastPage = listlength / pages;
			} else {
				lastPage = listlength / pages + 1;
			}
			if (p < 1)
				p = 1;
			if (p > lastPage)
				p = lastPage;
			int startIndex = (p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			linkList = linkList.subList(startIndex, endIndex);
		}
		return "listAllSUCCESS";
	}
	/**
	 * ������ݿ��������봫��Titleֵƥ���link��¼
	 * @return listByTitleSUCCESS
	 * @throws Exception
	 */
	public String listByTitle() throws Exception {
		linkList = mhqxTabLinkManager.findMhqxTabLinkByTitle(FLinkTitle);
		return "listByTitleSUCCESS";
	
	}

	public Integer getFLinkId() {
		return FLinkId;
	}


	public void setFLinkId(Integer linkId) {
		FLinkId = linkId;
	}


	public String getFLinkTitle() {
		return FLinkTitle;
	}


	public void setFLinkTitle(String linkTitle) {
		FLinkTitle = linkTitle;
	}


	public String getFLinkUrl() {
		return FLinkUrl;
	}


	public void setFLinkUrl(String linkUrl) {
		FLinkUrl = linkUrl;
	}


	public Integer getFLinkPriority() {
		return FLinkPriority;
	}


	public void setFLinkPriority(Integer linkPriority) {
		FLinkPriority = linkPriority;
	}


	public List<MhqxTabLink> getLinkList() {
		return linkList;
	}


	public void setLinkList(List<MhqxTabLink> linkList) {
		this.linkList = linkList;
	}


	public MhqxTabLink getL() {
		return l;
	}
	public void setL(MhqxTabLink l) {
		this.l = l;
	}
	
	public MhqxTabLinkManager getMhqxTabLinkManager() {
		return mhqxTabLinkManager;
	}

	public void setMhqxTabLinkManager(MhqxTabLinkManager mhqxTabLinkManager) {
		this.mhqxTabLinkManager = mhqxTabLinkManager;
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

	

}
