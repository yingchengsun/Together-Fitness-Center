package com.xdsc.wzmh_system.util;

/**
 * input标签
 * 
 * @author 陈丰
 * 
 */
public class Ainput extends Atag {
	/** 输入框大小 */
	private Integer size = 0;
	/** 是否可编辑 */
	private String disabled = "";

	public String getSize() {
		return " size=" + size.toString();
	}

	public Ainput setSize(Integer size) {
		this.size = size;
		return this;
	}

	public String getDisabled() {
		return disabled;
	}

	public Ainput setDisable(boolean dis) {
		this.disabled = dis ? "disabled=\"disabled\"" : "";
		return this;
	}

}
