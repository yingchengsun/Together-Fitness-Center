package com.xdsc.wzmh_system.util;

/**
 * input��ǩ
 * 
 * @author �·�
 * 
 */
public class Ainput extends Atag {
	/** ������С */
	private Integer size = 0;
	/** �Ƿ�ɱ༭ */
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
