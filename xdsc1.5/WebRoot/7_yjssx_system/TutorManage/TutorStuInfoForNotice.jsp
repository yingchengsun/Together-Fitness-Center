<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">发送通知</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
     <form action="yjssxTutor/TutorNoticeTuStudent!NoticeToStudent.action" method="post">
	   <table width="100%" id="mytable" border="1" style="border-collapse:collapse" bordercolor="#999999">
		  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		    <th>编号</th>
		    <th scope="col"><div align="center">选择</div></th>
		    <th><div align="center"><strong>学号</strong></div></th>
	        <th><div align="center"><strong>姓名</strong></div></th>
	        <th><div align="center"><strong>性别</strong></div></th>
	        <th><div align="center"><strong>籍贯</strong></div></th>
	        <th><div align="center"><strong>地址</strong></div></th>
	        <th><div align="center"><strong>本科学校</strong></div></th>
	        <th><div align="center"><strong>班级</strong></div></th>
	        <th><div align="center"><strong>年级</strong></div></th>
	        <th><div align="center"><strong>邮箱</strong></div></th>
	        <th><div align="center"><strong>电话</strong></div></th>
		  </tr>
		  <s:if test="stuList.size==0">
			<tr>
				<td colspan="10" align="left">对不起暂无数据！！！</td>
			</tr>
		  </s:if>
	      <s:else>
		   <s:iterator value="stuList" status="status">
			  <tr>
			    <td align="center" height="24"><s:property value="#status.count" /></td>
			  	<td><div align="center"><input type="checkbox" name="NoticeStuId" value="${FStudentNumber }"/></div></td>
			    <td align="center">${tabStudents.FStudentNumber }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentName }</td>
			      <td align="center">${tabStudents.FStudentSex }</td>
			      <td align="center">${tabStudents.FStudentNativeplace }</td>
			      <td align="center">${tabStudents.FStudentAddress }</td>
			      <td align="center">${FStudentExSchool}</td>	 
			      <td align="center">${tabStudents.tabClasses.FClassName }</td>     
			      <td align="center">${tabStudents.tabClasses.tabGrade.FGradeNum }</td>
			      <td align="center">${tabStudents.FStudentEmail }</td>
			      <td align="center">${tabStudents.FStudentTel }</td>
			  </tr>
			</s:iterator>
			<tr >
		      <td><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
		      <td><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
		      <td><div align="center"><input type="submit" value="发送通知" /></div></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
			  <td></td>
		    </tr>
		    </s:else>
	  </table>
	</form>
	<table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorStuInfoForNotice!TutorsStuInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorStuInfoForNotice!TutorsStuInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorStuInfoForNotice!TutorsStuInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorStuInfoForNotice!TutorsStuInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
	
</div> 
</body>
</html>
