package com.xdsc.wzmh_system.util;

/**
 * FCK ��ǰ�汾��ʹ��
 * @author �·�
 *
 */
public class Fckeditor extends Atag {
	
	private String instanceName;
	public String getInstanceName() {
		return instanceName;
	}
	public Fckeditor setInstanceName(String instanceName) {
		this.instanceName = "instanceName=\""+instanceName+"\"";
		return this;
	}

	public Fckeditor (String name,String value)
	{
		setInstanceName(name);
		setValue(value);
	}

	public String toString(){
		return "<FCK:editor "+instanceName+" basePath=\"/fckeditor\""+getValue()+ "width=\"100%\" height=\"500\" toolbarSet=\"mytools1\"></FCK:editor>";
	}
	// <FCK:editor instanceName="notice.FInfoContet" basePath="/fckeditor" value=" " width="100%" height="500" toolbarSet="mytools1"></FCK:editor>
}
