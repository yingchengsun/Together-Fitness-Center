package com.xdsc.wzmh_system.util;
/**
 * ³¬Á´½Ó
 * @author ³Â·á
 *
 */
public class ALink extends Atag {
	/** Á´½ÓµØÖ·*/
private String href="";
/** target*/
private String target="";
/**border*/
private Integer border=0;
/** value*/
private String value;

public String getValue() {
	return value;
}
public Atag setValue(String value) {
	this.value = value;
	return this;
}
public ALink (String href,String value)
{
	this("alink",href,value);
}
public ALink (String linkclass,String href,String value)
{
setTagClass(linkclass);
setHref(href);
setValue(value);
}
public ALink (String linkclass,String href,String value,Integer border)
{
setTagClass(linkclass);
setHref(href);
setValue(value);
setBorder(border);
}
public ALink (String linkclass,String href,String value,String target)
{
setTagClass(linkclass);
setHref(href);
setValue(value);
setTarget(target);
}
public ALink (String linkclass,String href,String value,String target,Integer border)
{
setTagClass(linkclass);
setHref(href);
setValue(value);
setTarget(target);
setBorder(border);
}


public String getHref() {
	return href;
}
public ALink setHref(String href) {
	this.href = " href=\""+href+"\"";
	return this;
}
public String getTarget() {
	return target;
}
public ALink setTarget(String target) {
	this.target = " target=\""+target+"\"";
	return this;
}
public String getBorder() {
	return " border="+ border;
}
public ALink setBorder(Integer border) {
	this.border =border;
	return this;
}

public String toString(){
	return "<a "+getHref()+getBorder()+getTagId()+getTagClass()+" >"+getValue()+"</a>";
}
}
