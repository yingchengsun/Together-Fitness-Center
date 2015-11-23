<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	    <br>
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					教师个人详细信息:
				</td>
			</tr>
		</table>
		<hr>
		<br>
		<table width="40%" border="1" id="mytable" align="center">
			<tr>
				<td align="center">教师职工号</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherNumber"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">姓名</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherName"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">账号状态</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FIsLocked"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">性别</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherSex"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">生日</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherBirthday"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">身份证号</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherIdCard"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">民族</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherNation"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">注册时间</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherRegData"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">办公电话</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherTel"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">手机号码</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherPhone"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">电子邮箱</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherEmail"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">邮政编码</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherPostcode"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">籍贯</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherNativeplace"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">家庭地址</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherAddress"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">政治面貌</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherPoliStatus"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">学历</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherXueLi"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">办公地址</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherWorkPlace"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">研究方向</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherResearch"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">研究成果</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherAchieve"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">工作职位</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherPosition"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">职称</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherZhiCheng"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">工作历史</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherHistory"/>"disabled="disabled"></td>
			</tr>
			<tr>
				<td align="center">所属学院</td>
				<td align="center"><input type="text" value="<s:property value="tabTeachers.FTeacherXueYuan"/>"disabled="disabled"></td>
			</tr>
			<tr>
               <td colspan="2" align="center">
                 <input type="button" value="返回" onClick="javascript:window.history.go(-1)"/>
               </td>
             </tr>
		</table>
	</body>
</html>