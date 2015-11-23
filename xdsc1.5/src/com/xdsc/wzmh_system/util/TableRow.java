package com.xdsc.wzmh_system.util;

import java.util.ArrayList;
import java.util.List;

/**
 * tr标签
 * @author 陈丰
 *
 */
public class TableRow extends Atag {
	/**高度*/
	private String height="";
	/**背景色*/
	private String bgcolor="";
	/**宽度*/
	private String width="";
	/**行列表*/
	public List<TableCol> collist = new ArrayList<TableCol>();
	/**标签列表*/
	public List<Atag> taglist = new ArrayList<Atag>();
	public int getSize(){
		return collist.size();
	}
	/**
	 * 加入多行
	 * @param col
	 * @return 当前对象
	 */
	public TableRow add(TableCol[] col) {
		for (int i = 0; i < col.length; i++)
			collist.add(col[i]);
		return this;
	}

	/**
	 * 加入标签
	 * @param tag
	 * @return 当前对象
	 */
	public TableRow addAtag(Atag tag) {
		taglist.add(tag);
		return this;
	}
	/**
	 * 加入一行
	 * @param col
	 * @return 当前对象
	 */
	public TableRow add(TableCol o) {
		collist.add(o);
		return this;
	}

	public String toString() {
		String colString = "";
		for(Atag tag:taglist)
		{
			collist.add(new TableCol().add(tag));
		}
		for (TableCol col : collist) {
			colString += col;
		}
		return "<tr" +getStyle()+ getWidth()+getTagId()+getBgcolor()+getHeight() + ">" + colString + "</tr>";
	}
	public String getHeight() {
		return height;
	}
	public TableRow setHeight(String height) {
		this.height =" height=\""+ height+"\"";
		return this;
	}
	public String getBgcolor() {
		return bgcolor;
	}
	public TableRow setBgcolor(String bgcolor) {
		this.bgcolor = " bgcolor=\""+bgcolor+"\"";
		return this;
	}
	public String getWidth() {
		return width;
	}
	public TableRow setWidth(String width) {
		this.width =" width="+width;
		return this;
	}
}
