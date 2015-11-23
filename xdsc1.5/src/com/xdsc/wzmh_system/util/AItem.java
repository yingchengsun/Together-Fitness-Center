package com.xdsc.wzmh_system.util;


/**
 *һ����¼ label��input��label��label
 * @author �·�
 *
 */
public class AItem extends Atag {
	/**��ǩlabel1*/
	private Alabel label;
	/**��ǩlabel2*/
	private Alabel label2;
	/**��ǩ�����*/
	private AInputText inputText;
	/**������Ƿ�ɱ༭*/
	private boolean disabled;
	
	public boolean getDisabled() {
		return disabled;
	}
	public AItem setDisabled(boolean disabled) {
		inputText.setDisable(disabled);
		return this;
	}

	public AItem(String labelValue,String label2Value)
	{
		label= new Alabel(labelValue);
		label2= new Alabel(label2Value);
		label2.setTagId("alabel2");
	}
	
public AItem(String labelValue,String name ,String TextValue,int size)
{
	label= new Alabel(labelValue);
	inputText = new AInputText(name,TextValue,size);
}

public String toString(){
	if(label2!=null){
		return label.toString()+label2.toString();
	}
	//label.setStyle("width:200px");  
	return label.toString()+inputText.toString();
}
}
