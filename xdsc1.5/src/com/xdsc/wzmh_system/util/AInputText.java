package com.xdsc.wzmh_system.util;

/**
 * input type="text"±êÇ©
 * @author ³Â·á
 *
 */
public class AInputText extends Ainput {

	public AInputText(String value) {
		setValue(value);
	}

	public AInputText(String name, String value) {
		setName(name);
		setValue(value);
	}

	public AInputText(String name, String value, Integer size) {
		setName(name);
		setValue(value);
		setSize(size);
	}

	public AInputText(String id, String name, String value) {
		setTagId(id);
		setName(name);
		setValue(value);
	}
	public AInputText(String id, String name, String value,Integer size) {
		setTagId(id);
		setName(name);
		setValue(value);
		setSize(size);
	}

	public String toString() {
		return "<input type=\"text\" " + getTagId() + getTagClass() + getName()
				+ getValue() + getDisabled() + getSize() + "  />";
	}

}
