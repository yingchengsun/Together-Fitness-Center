package com.xdsc.wzmh_system.util;

import java.util.ArrayList;
import java.util.List;
/**
 * td标签
 * @author 陈丰
 *
 */
public class TableCol extends Atag{
	/**默认colspan为1*/
private String colSpan="1";
	/**td宽度*/
private String width="";
/**标签列表*/
public List<Atag> taglist= new ArrayList<Atag>();
public TableCol(){
	this("1");
}
public TableCol(String colspan){
setColSpan(colSpan);
}

/**
 * 加入一个标签
 * @param tag
 * @return 当前对象
 */
public TableCol add(Atag tag){	
	taglist.add(tag);
	return this;
}

/**
 * @return 当前标签容量
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
