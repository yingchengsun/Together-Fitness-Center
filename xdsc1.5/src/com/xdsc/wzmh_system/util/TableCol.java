package com.xdsc.wzmh_system.util;

import java.util.ArrayList;
import java.util.List;
/**
 * td��ǩ
 * @author �·�
 *
 */
public class TableCol extends Atag{
	/**Ĭ��colspanΪ1*/
private String colSpan="1";
	/**td���*/
private String width="";
/**��ǩ�б�*/
public List<Atag> taglist= new ArrayList<Atag>();
public TableCol(){
	this("1");
}
public TableCol(String colspan){
setColSpan(colSpan);
}

/**
 * ����һ����ǩ
 * @param tag
 * @return ��ǰ����
 */
public TableCol add(Atag tag){	
	taglist.add(tag);
	return this;
}

/**
 * @return ��ǰ��ǩ����
 */
public int getSize()
{
return taglist.size();	
}

public String toString(){
	String tagString="";
	for(Atag tag:taglist)
	{
		tagString+=tag;
	}
	return "<td"+getTagId()+getWidth()+getColSpan()+">"+tagString+"</td>";
}

public String getColSpan() {
	return colSpan;
}

public TableCol setColSpan(String colSpan) {
	this.colSpan = " colspan="+colSpan;
	return this;
}
public String getWidth() {
	return width;
}
public TableCol setWidth(String width) {
	this.width =" width="+width;
	return this;
}

}
