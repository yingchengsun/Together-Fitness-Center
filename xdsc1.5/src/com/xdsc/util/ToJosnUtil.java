package com.xdsc.util;

import java.util.List;

import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;



public class ToJosnUtil {

	public static String ModuleToJosn(List<MhqxTabModule> moduleList){  //����ȡ������module׼����josn��������
		String retString=new String();
		for(int i=0;i<moduleList.size();i++){           
			String temp;
			if(i==0&&moduleList.size()==1){                           //��һ����������
				temp="[{id:"+moduleList.get(i).getFModuleId()+",iconCls:'"+moduleList.get(i).getFFilePath()+"',text:'"+moduleList.get(i).getFModuleName()+"'},]";		//��list��ֻ��һ������ʱ����һ�����ݼ�������
			}else if(i==0&&moduleList.size()!=1){
				temp="[{id:"+moduleList.get(i).getFModuleId()+",iconCls:'"+moduleList.get(i).getFFilePath()+"',text:'"+moduleList.get(i).getFModuleName()+"'},";      //��list�д���һ������ʱ����һ�����ݲ���������
			}else if(i==(moduleList.size()-1)){        //���һ����������
				temp="{id:"+moduleList.get(i).getFModuleId()+",iconCls:'"+moduleList.get(i).getFFilePath()+"',text:'"+moduleList.get(i).getFModuleName()+"'}]";
			}else{
				temp="{id:"+moduleList.get(i).getFModuleId()+",iconCls:'"+moduleList.get(i).getFFilePath()+"',text:'"+moduleList.get(i).getFModuleName()+"'},";
			}
			retString=retString+temp;
		}
		return retString;
	}
	
	
	public static String FunctionToJoson(List<MhqxTabFunction> FunctionList){
		    String retString=new String();
			for(int i=0;i<FunctionList.size();i++){
				String temp;
				if(FunctionList.get(i).getFIsLeaf().equals("1")){  
					System.out.println(i+" IsLeaf."+FunctionList.get(i).getFFunctionName());
					System.out.println(i+" IsLeaf."+FunctionList.size());
					//��Ҷ�ӽڵ�
					if(i==0&&FunctionList.size()==1){                           //��һ����������
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},]";	//��list��ֻ��һ������ʱ����һ�����ݼ�������	
					}else if(i==0&&FunctionList.size()!=1){
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";   //��list�д���һ������ʱ����һ�����ݲ���������
					}else if(i==(FunctionList.size()-1)){        //���һ����������
						temp="{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'}]";
					}else{
						temp="{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";
					}
				}else{    
					System.out.println(i+" IsNotLeaf."+FunctionList.get(i).getFFunctionName());
					System.out.println(i+" IsNotLeaf."+FunctionList.size());
					
					//����Ҷ�ӽڵ�
					if(i==0&&FunctionList.size()==1){                           //��һ����������
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:false"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},]";	//��list��ֻ��һ������ʱ����һ�����ݼ�������	
					}else if(i==0&&FunctionList.size()!=1){
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:false"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";   //��list�д���һ������ʱ����һ�����ݲ���������
					}else if(i==(FunctionList.size()-1)){        //���һ����������
						temp="{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:false"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'}]";
					}else{
						temp="{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:false"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";
					}
				}
				
				
				retString=retString+temp;
			}
		
		
		return retString;
	}
	
	
	
}
