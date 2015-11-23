package com.xdsc.wzmh_system.util;

/**
 * ±êÇ©
 * @author ³Â·á
 *
 */
public class Atag {
	/**id*/
private String tagId="";
/**class*/
private String tagClass="";
/**name*/
private String name="";
/**value*/
private String value="";
/**style*/
private String style="";


public String getTagId() {
	return tagId;
}
public Atag setTagId(String tagId) {
	this.tagId = " id=\""+tagId+"\"";
	return this;
}
public String getTagClass() {
	return tagClass;
}
public Atag setTagClass(String tagClass) {
	this.tagClass =" class=\"" +tagClass+"\"";
	return this;
}
public String getName() {
	return name;
}
public Atag setName(String name) {
	this.name = " name=\""+name+"\"";
	return this;
}
public String getValue() {
	return value;
}
public Atag setValue(String value) {
	if(value!=null)
	this.value =" value=\""+ value+"\"";
	return this;
}

public String getStyle() {
	return style;
}
public Atag setStyle(String style) {
	if(style!=null)
	this.style =" style=\""+ style+"\"";
	return this;
}
}
