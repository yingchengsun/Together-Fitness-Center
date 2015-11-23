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
	public static final int DEFAULT_PAGE_SIZE = 5;//默认的页面大小
	private List source;
	private Date refreshDate;
	private int pageSize = DEFAULT_PAGE_SIZE;
	private int page=0;
	private boolean newPageSet;//是否有新页面
	
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
	
	//设置页面大小
	public void setPageSize(int pageSize){
		if(pageSize!=this.pageSize){
			this.pageSize=pageSize;
			if(!this.newPageSet){
				this.page=0;
			}
		}
	}
	
	//页面大小
	public int getPageSize(){
		return pageSize;
	}
	
	//设置当前显示页面
	public void setPage(int page){
		this.page = page;
		this.newPageSet = true;
		
	}
	
	//当前页
	public int getPage(){
		this.newPageSet = false;
		if(this.page>=getPageCount()){
			this.page = getPageCount()-1;
		}
		return this.page;
	}
	
	//总页数
	public int getPageCount(){
		float nrOfPages = (float) getSource().size()/getPageSize();
		return (int)((nrOfPages>(int)nrOfPages||nrOfPages == 0.0)?nrOfPages + 1: nrOfPages);
	}
	
	//是否是首页
	public boolean isFirstPage(){
		return getPage() == 0;
	}
	
	//是否是尾页
	public boolean isLastPage(){
		return getPage() == getPageCount() - 1;
	}
	
	//上一页
	public void previousPage(){
		if(!isFirstPage()){
			this.page--;
		}
	}
	
	//下一页
	public void nextPage(){
		if(!isLastPage()){
			this.page++;
		}
	}
	
	//总记录数
	public int getNrOfElements(){
		return getSource().size();
	}
	
	//当前页的第一个记录数
	public int getFirstElementOnPage(){
		return (getPageSize()*getPage());
	}
	
	//当前页的最后一个记录
	public int getLastElementOnPage(){
		int endIndex = getPageSize()*(getPage()+1);
		return (endIndex>getSource().size()?getSource().size():endIndex)-1;
	}
	
	//当前页数据
	public List getPageList(){
		return getSource().subList(getFirstElementOnPage(), getLastElementOnPage()+1);
	}
}
