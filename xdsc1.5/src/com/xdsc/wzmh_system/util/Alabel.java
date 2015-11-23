package com.xdsc.wzmh_system.util;

/**
 * label��ǩ
 * @author �·�
 *
 */
public class Alabel extends Atag {
	/**label��ǩֵ*/
	private String value = "";
	
	public String getValue() {
		return value;
	}
	public Alabel setValue(String value) {
		if(value==null||value=="")
			value="";
		this.value = value;
		return this;
	}

	public Alabel(String value) {
		setTagId("alabel");
		setValue(value);
	}

	public Alabel(String id, String value) {
		setTagId(id);
		setValue(value);
	}

	public Alabel(String id, String tagclass, String value) {
		setTagId(id);
		setTagClass(tagclass);
		setValue(value);
	}

	public String toString() {
		return "<label " + getTagClass() + getTagId() + ">" + getValue()
				+ "</label>";
	}

	
}
