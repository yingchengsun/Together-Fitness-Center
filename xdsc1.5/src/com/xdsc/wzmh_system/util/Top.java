package com.xdsc.wzmh_system.util;



import java.util.ArrayList;
import java.util.List;

/**
 * 顶部功能条
 * @author 陈丰
 *
 */
public class Top extends Atag {
	/**标题*/
	private String tittle;
	/**功能超链接列表*/
	private List<ALink> linklist = new ArrayList<ALink>();

	public List<ALink> getLinklist() {
		return linklist;
	}

	public void setLinklist(List<ALink> linklist) {
		this.linklist = linklist;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Top(String tittle) {
		this.tittle = tittle;
	}

	/**
	 * 加入一条链接
	 * @param link
	 * @return 当前对象
	 */
	public Top addLink(ALink link) {
		linklist.add(link);
		return this;
	}

	public String toString() {
		TableRow tr = new TableRow();
		tr.setWidth("100%");
		tr.add(new TableCol().add(new Alabel("tittle", tittle)).setWidth("70%"));
		if(linklist.size()>0)
		{
			for(ALink link:linklist)
			tr.add(new TableCol().add(link));
		}
		else{		
			tr.add(new TableCol()).add(new TableCol());
		}
		
		TableRow tr2 = new TableRow();
		TableRow tr4 = new TableRow();
		
		
		//style #6666FF
		tr2.setBgcolor("red");
		tr4.setBgcolor("orange");
		//tr.setBgcolor("#7fffd4");
		tr4.setHeight("1px");
		tr4.add(new TableCol());
		tr4.add(new TableCol());
		tr4.add(new TableCol());
		tr4.setTagId("blank");
		
		tr2.setHeight("1px");
		tr2.add(new TableCol());
		tr2.add(new TableCol());
		tr2.add(new TableCol());
		tr2.setTagId("blank");		
		TableRow tr3 = new TableRow();
		tr3.setHeight("15px");
		TableRow tr0 = new TableRow();
		tr0.setHeight("5px");
		return tr0.toString()+tr.toString() +tr2.toString()+tr3.toString();
	}
	
}
