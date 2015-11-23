package com.xdsc.wzmh_system.util;

import java.util.ArrayList;
import java.util.List;

/**
 * tr��ǩ
 * @author �·�
 *
 */
public class TableRow extends Atag {
	/**�߶�*/
	private String height="";
	/**����ɫ*/
	private String bgcolor="";
	/**���*/
	private String width="";
	/**���б�*/
	public List<TableCol> collist = new ArrayList<TableCol>();
	/**��ǩ�б�*/
	public List<Atag> taglist = new ArrayList<Atag>();
	public int getSize(){
		return collist.size();
	}
	/**
	 * �������
	 * @param col
	 * @return ��ǰ����
	 */
	public TableRow add(TableCol[] col) {
		for (int i = 0; i < col.length; i++)
			collist.add(col[i]);
		return this;
	}

	/**
	 * �����ǩ
	 * @param tag
	 * @return ��ǰ����
	 */
	public TableRow addAtag(Atag tag) {
		taglist.add(tag);
		return this;
	}
	/**
	 * ����һ��
	 * @param col
	 * @return ��ǰ����
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
