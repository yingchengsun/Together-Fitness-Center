package com.xdsc.util;

import java.util.List;

import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;



public class ToJosnUtil {

	public static String ModuleToJosn(List<MhqxTabModule> moduleList){  //将读取出来的module准化成josn数据类型
		String retString=new String();
		for(int i=0;i<moduleList.size();i++){           
			String temp;
			if(i==0&&moduleList.size()==1){                           //第一个加左括号
				temp="[{id:"+moduleList.get(i).getFModuleId()+",iconCls:'"+moduleList.get(i).getFFilePath()+"',text:'"+moduleList.get(i).getFModuleName()+"'},]";		//当list中只有一个数据时，第一条数据加右括号
			}else if(i==0&&moduleList.size()!=1){
				temp="[{id:"+moduleList.get(i).getFModuleId()+",iconCls:'"+moduleList.get(i).getFFilePath()+"',text:'"+moduleList.get(i).getFModuleName()+"'},";      //当list中大于一个数据时，第一条数据不加右括号
			}else if(i==(moduleList.size()-1)){        //最后一个加右括号
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
					//是叶子节点
					if(i==0&&FunctionList.size()==1){                           //第一个加左括号
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},]";	//当list中只有一个数据时，第一条数据加右括号	
					}else if(i==0&&FunctionList.size()!=1){
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";   //当list中大于一个数据时，第一条数据不加右括号
					}else if(i==(FunctionList.size()-1)){        //最后一个加右括号
						temp="{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'}]";
					}else{
						temp="{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:true"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";
					}
				}else{    
					System.out.println(i+" IsNotLeaf."+FunctionList.get(i).getFFunctionName());
					System.out.println(i+" IsNotLeaf."+FunctionList.size());
					
					//不是叶子节点
					if(i==0&&FunctionList.size()==1){                           //第一个加左括号
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:false"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},]";	//当list中只有一个数据时，第一条数据加右括号	
					}else if(i==0&&FunctionList.size()!=1){
						temp="[{id:"+FunctionList.get(i).getFFunctionId()+",text:'"+FunctionList.get(i).getFFunctionName()+"'"+",leaf:false"+",iconCls:'map-icon'"+",href:'"+FunctionList.get(i).getFFilePath()+"'},";   //当list中大于一个数据时，第一条数据不加右括号
					}else if(i==(FunctionList.size()-1)){        //最后一个加右括号
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
