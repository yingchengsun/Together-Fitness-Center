<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
   <script type="text/javascript">
    	function selectAll(){
    		 var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
    </script>
</head>

<body background="../SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">研究生导师选择</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" border="0">
   	  <tr  style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center">研究生调剂</div></td>
   	  </tr>
      <tr>
        <td width="100%" height="26"><div align="center">
		<form action="yjssxAdmin/AdminTutorSelectDispach!confirmAddStudentToTutor.action" method="post">
	  	    输入导师姓名：
	  	    <select name="TutorName">
	  	      <option value="">----请选择-----</option>
	  	      <s:iterator value="teacherList">
		      <option value="${FTeacherName }">${FTeacherName }</option>
		      </s:iterator>
	        </select>
	  	    输入研究生姓名：<input type="text" name="studentName" /><p>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
     </tr>
   </table>
   <hr align="center" width="100%"/>
   <form action="yjssxAdmin/AdminTutorSelectDispach!saveConfirmInfo.action" method="post">

	 <table width="100%" border="1" id="mytable" style="border-collapse:collapse">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
	      <th><div align="center"><strong>导师姓名</strong></div></th>
	      <th><div align="center"><strong>导师电话</strong></div></th>
	      <th><div align="center"><strong>查看详情</strong></div></th>
	    </tr>
	    <s:if test="tutorList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="tutorList" status="status">
	    <tr>
	      <td align="center" height="24"><s:property value="#status.count" /></td>
	      <td><input type="checkbox" name="TId" value="${FTeacherNumber }"/></td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FTeacherName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FTeacherTel }</td>
	      <td align="center"><div align="center">
	      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	      <a href="<%=basePath %>yjssxCommon/CommonOperation!findTutorInfo.action?tutorId=${FTeacherNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	   </s:iterator>
	   </s:else>
	  </table>	
	  <p></p>
	  <table width="100%" id="mytable1" border="1" style="border-collapse:collapse" bordercolor="#999999"
	    background="../SubSystemImage/bg.gif">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
	      <th><div align="center"><strong>研究生名称</strong></div></th>
	      <th><div align="center"><strong>研究生电话</strong></div></th>
	      <th><div align="center"><strong>查看详情</strong></div></th>
	    </tr>
	    <s:if test="studentList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="studentList" status="status">
	    <tr>
	      <td align="center" height="24"><s:property value="#status.count" /></td>
	      <td><input type="checkbox" name="SId" value="${FStudentNumber }"/></td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentTel }</td>
	      <td align="center"><div align="center"><a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${FStudentNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	   </s:iterator>
	   <tr style="background-color:#CCCCCC">
	      <td><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
	      <td><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
	      <td><div align="center"><input type="submit" value=确定调剂" /></div></td>
	      <td></td>
	      <td></td>
	    </tr>
	    </s:else>
	  </table>  
   </form>
</div>
</body>
</html>
