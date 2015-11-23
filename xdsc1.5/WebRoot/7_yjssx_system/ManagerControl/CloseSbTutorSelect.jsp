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
	<script type="text/javascript">
	    	function setNull1(){
	    		var objs = document.getElementById("id1");
	    		objs.value="";
	    	}
	    	function setNull2(){
	    		var objs = document.getElementById("id2");
	    		objs.value="";
	    	}
	</script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/clock.png" height="70" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">导师选择功能配置</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" border="0" style="border-collapse:collapse">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>研究生选择功能开通：</strong></div></td>
   	  	<td><div align="center"><strong>关闭研究生选择导师功能：</strong></div></td>
   	  </tr>
      <tr>
        <td height="24">
        	<div align="center">
				<input type="button" value="点击开通此功能" onclick="location.href='<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!TutorSelectOpenToAllStudent.action'" />
			</div>
		</td>
		<td height="24"><div align="center">
			<input type="button" value="点击关闭此功能" onclick="location.href='<%=basePath %>yjssxAdmin/AdminSystemFunctionDeploy!TutorSelectCloseToAllStudent.action'" />
		</div></td>
     </tr>
     <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>为特定研究生开通导师选择功能：</strong></div></td>
   	  	<td><div align="center"><strong>关闭某研究生导师选择功能：</strong></div></td>
   	  </tr>
      <tr>
        <td height="24"><div align="center">
		<form action="yjssxAdmin/AdminSystemFunctionDeploy!StudentSearchByNameForTutorSelect.action" method="post">
			<input type="hidden" name="type" value="open"/>
	  	  	<input name="studentName" id="id1" value="请输入研究生姓名..." onclick="setNull1()"/>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
		<td height="24"><div align="center">
		<form action="yjssxAdmin/AdminSystemFunctionDeploy!StudentSearchByNameForTutorSelect.action" method="post">
			<input type="hidden" name="type" value="close"/>
	  	  	<input name="studentName" id="id2" value="请输入研究生姓名..." onclick="setNull2()"/>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
     </tr>
   </table>
   <hr align="center" width="100%"/>
   <form action="yjssxAdmin/AdminSystemFunctionDeploy!CloseSbTutorSelect.action" method="post">
     <input type="hidden" name="thesisType" value="${thesisType }"/>
	 <table width="100%" border="1" style="border-collapse:collapse">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th ><div align="center"><strong>选择</strong></div></th>
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
	    <s:if test="studentList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="studentList" status="status">
	    <tr>
	      <td align="center" height="24"><s:property value="#status.count" /></td>
	      <td><input type="radio" name="userNumber" value="${FStudentNumber }"/></td>
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
	   <tr style="background-color:#CCCCCC">
	      <td ><div align="center"></div></td>
	      <td ><div align="center"></div></td>
	      <td ><div align="center"><input type="submit" value="关闭此功能" /></div></td>
	      <td></td>
	      <td></td>
	    </tr>
	    </s:else>
	  </table>	  
   </form>
</div>
</body>
</html>
