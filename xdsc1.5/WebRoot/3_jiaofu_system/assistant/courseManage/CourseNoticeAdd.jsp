<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
	</head>

	<body>
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
		<br>
		<h3 align="center">
			发送课程通知
		</h3>
		<hr>
		<br>
		<s:form action="assist/CourseManage!addNotice.action" method="post" theme="simple" enctype="multipart/form-data">
		<table width="80%" border="0" id="mytable" align="center">
		    <tr>
	                <th align="center" colspan="2" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">发送通知</font>
	                </th>
	            </tr>
		    <tr>
				<td align="center">
					课程编号
				</td>
				<td align="center">
				    <s:property value="tabCourse.FCourseNumber"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					标题
				</td>
				<td align="center">
				    <s:textfield name="FTitle"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					内容
				</td>
				<td align="center">
				    <s:textarea name="FContent" cols="100%" rows="5"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					附件
				</td>
				<td align="center">
				     <s:file name="uploadFile"/>
				</td>
			</tr>
			<tr>
			    <td colspan="2" align="center">
			       	<s:iterator value="listStudentsInfo" status="status">
			       	   学号:<s:property value="FStudentNumber" />&nbsp;姓名:<s:property value="FStudentName"/>&nbsp;
			       	   <input type="checkbox" name="listStudentNumber" checked="checked" value="${FStudentNumber }"/>
			       	   <s:if test="#status.count % 4 ==0">
			       	       <br>
			       	   </s:if>
			        </s:iterator>
			    </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				   <input type="button" value="全选" onclick="selectAll()" />
                    <input type="button" value="反选" onclick="unSelectAll()" />&nbsp;
					<s:submit value="-->发送<--" />
					&nbsp;
					<s:reset value="重置" />
					&nbsp;
					<input type="button" value="返回" onClick="javascript:window.history.go(-1)" />
				</td>
			</tr>
		</table>
		</s:form>
	</body>
</html>