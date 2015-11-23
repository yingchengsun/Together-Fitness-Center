<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
<style type="text/css">
<!--
.STYLE26 {font-size: 14px}
-->
</style>
<script type="text/javascript" language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery-calendar.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>js/jquery-calendar.css" />
<script type="text/javascript" charset="utf-8">
  $(document).ready(function(){
     $("#date1").date();
  })
 </script>
</head>

<body background="../SubSystemImage/Background.png">
   <div align="center">
      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="75"/>
   <table width="90%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">发送通知</div></td>
      </tr>
   </table>
   <table width="90%"border="1" id="mytable" style="border-collapse:collapse" bordercolor="#999999"
	  background="../SubSystemImage/bg.gif">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
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
	    <s:if test="noticeStuList.size==0">
			<tr>
				<td>对不起系统未找到研究生信息！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="noticeStuList">
	    <tr>
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
	   </s:else>
	  </table>
	  <form action="yjssxTutor/TutorNoticeTuStudent!saveNotice.action"  method="post" enctype="multipart/form-data">
		  <s:iterator value="NoticeStuId" var="id">
		  	<input type="hidden" name="infoToStuId" value="${id}"/><br/>
		  </s:iterator>
	      <table width="90%" height="418" border="1" style="border-collapse:collapse" bordercolor="#999999">
	        <tr>
	          <td width="100" height="55"><div align="left">标题：&nbsp;</div></td>
	          <td ><div align="left">
	              <input type="text" height="25" name="notice.FInfoTitle" />
	          </div></td>
	          <td height="55"><div align="left">发布日期：&nbsp;</div></td>
	          <td ><div align="left">
	              <input readonly="readonly" type="text" name="notice.FInfoStartTime" id="date1" class="calendarFocus"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td height="55"><div align="left">相关资料：&nbsp;</div></td>
	          <td colspan="3"><div align="left">
	              <input type="file" height="25" name="uploadFile" />
	          </div></td>
	        </tr>
	        <tr>
	          <td height="322"><div align="left">内容：</div></td>
	          <td colspan="3"><div align="left">
	              <FCK:editor instanceName="notice.FInfoContet" basePath="/fckeditor" value=" " width="100%" height="500" toolbarSet="mytools1"></FCK:editor>
	          </div></td>
	        </tr>
	        <tr>
	          <td height="31"><div align="left">
	              <input type="submit" name="Submit2" value="发送" />
	          </div></td>
	          <td><div align="left"></div></td>
	        </tr>
	      </table>
     </form>
   </div>
</body>
</html>
