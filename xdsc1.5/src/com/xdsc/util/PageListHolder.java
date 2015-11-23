package com.xdsc.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PageListHolder implements Serializable {
	
	/**
	 * 
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
	
	//����ҳ���С
	public void setPageSize(int pageSize){
		if(pageSize!=this.pageSize){
			this.pageSize=pageSize;
			if(!this.newPageSet){
				this.page=0;
			}
		}
	}
	
	//ҳ���С
	public int getPageSize(){
		return pageSize;
	}
	
	//���õ�ǰ��ʾҳ��
	public void setPage(int page){
		this.page = page;
		this.newPageSet = true;
		
	}
	
	//��ǰҳ
	public int getPage(){
		this.newPageSet = false;
		if(this.page>=getPageCount()){
			this.page = getPageCount()-1;
		}
		return this.page;
	}
	
	//��ҳ��
	public int getPageCount(){
		float nrOfPages = (float) getSource().size()/getPageSize();
		return (int)((nrOfPages>(int)nrOfPages||nrOfPages == 0.0)?nrOfPages + 1: nrOfPages);
	}
	
	//�Ƿ�����ҳ
	public boolean isFirstPage(){
		return getPage() == 0;
	}
	
	//�Ƿ���βҳ
	public boolean isLastPage(){
		return getPage() == getPageCount() - 1;
	}
	
	//��һҳ
	public void previousPage(){
		if(!isFirstPage()){
			this.page--;
		}
	}
	
	//��һҳ
	public void nextPage(){
		if(!isLastPage()){
			this.page++;
		}
	}
	
	//�ܼ�¼��
	public int getNrOfElements(){
		return getSource().size();
	}
	
	//��ǰҳ�ĵ�һ����¼��
	public int getFirstElementOnPage(){
		return (getPageSize()*getPage());
	}
	
	//��ǰҳ�����һ����¼
	public int getLastElementOnPage(){
		int endIndex = getPageSize()*(getPage()+1);
		return (endIndex>getSource().size()?getSource().size():endIndex)-1;
	}
	
	//��ǰҳ����
	public List getPageList(){
		return getSource().subList(getFirstElementOnPage(), getLastElementOnPage()+1);
	}
}
