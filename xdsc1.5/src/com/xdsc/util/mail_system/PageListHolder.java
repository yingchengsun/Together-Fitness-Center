package com.xdsc.util.mail_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** ����ʵ�ַ�ҳ���ܵĹ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class PageListHolder implements Serializable {
	
	/**
	 * ʵ�ַ�ҳ���ܵĹ�����
	 * �����������ڵ���ҳ����
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_PAGE_SIZE = 5;//Ĭ�ϵ�ҳ���С
	private List source;
	private Date refreshDate;
	private int pageSize = DEFAULT_PAGE_SIZE;
	private int page=0;
	private boolean newPageSet;//�Ƿ�����ҳ��
	
	public PageListHolder(){
		this(new ArrayList(0));
	}

	public PageListHolder(List source) {
		// TODO Auto-generated constructor stub
		setSource(source);
	}
	
	public void setSource(List source){
		this.source=source;
		this.refreshDate = new Date();
	}
	
	public List getSource(){
		return source;
	}
	
	public Date getRefreshDate(){
		return refreshDate;
	}
	
	
	/**����ҳ���С
	 * @param pageSize ÿҳ��ʾ�ߴ�
	 */
	public void setPageSize(int pageSize){
		if(pageSize!=this.pageSize){
			this.pageSize=pageSize;
			if(!this.newPageSet){
				this.page=0;
			}
		}
	}
	
	//ҳ���С
	/** �õ�ҳ���С
	 * @return ÿҳ��ʾ����
	 */
	public int getPageSize(){
		return pageSize;
	}
	
	//���õ�ǰ��ʾҳ��
	/** ���õ�ǰ��ʾҳ��
	 * @param page 
	 */
	public void setPage(int page){
		this.page = page;
		this.newPageSet = true;
		
	}
	
	//��ǰҳ
	/** ��ǰҳ
	 * @return
	 */
	public int getPage(){
		this.newPageSet = false;
		if(this.page>=getPageCount()){
			this.page = getPageCount()-1;
		}
		return this.page;
	}
	
	//��ҳ��
	/** ����ҳ��ߴ� ͳ����ҳ��
	 * @return ��ҳ��
	 */
	public int getPageCount(){
		float nrOfPages = (float) getSource().size()/getPageSize();
		return (int)((nrOfPages>(int)nrOfPages||nrOfPages == 0.0)?nrOfPages + 1: nrOfPages);
	}
	
	//�Ƿ�����ҳ
	/** �Ƿ�����ҳ
	 * @return
	 */
	public boolean isFirstPage(){
		return getPage() == 0;
	}
	
	//�Ƿ���βҳ
	/**�ж��Ƿ���βҳ
	 * @return
	 */
	public boolean isLastPage(){
		return getPage() == getPageCount() - 1;
	}
	
	//��һҳ
	/**
	 * ��һҳ
	 */
	public void previousPage(){
		if(!isFirstPage()){
			this.page--;
		}
	}
	
	//��һҳ
	/**
	 * ��һҳ
	 */
	public void nextPage(){
		if(!isLastPage()){
			this.page++;
		}
	}
	
	//�ܼ�¼��
	/**
	 * @return �ܼ�¼��
	 */
	public int getNrOfElements(){
		return getSource().size();
	}
	
	//��ǰҳ�ĵ�һ����¼��
	/**
	 * @return ��ǰҳ��ĵ�һ����¼��
	 */
	public int getFirstElementOnPage(){
		return (getPageSize()*getPage());
	}
	
	//��ǰҳ�����һ����¼
	/**
	 * @return ��ǰҳ������һ����¼
	 */
	public int getLastElementOnPage(){
		int endIndex = getPageSize()*(getPage()+1);
		return (endIndex>getSource().size()?getSource().size():endIndex)-1;
	}
	
	//��ǰҳ����
	/**
	 * @return ��ǰҳ������
	 */
	public List getPageList(){
		return getSource().subList(getFirstElementOnPage(), getLastElementOnPage()+1);
	}
}
