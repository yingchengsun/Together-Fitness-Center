<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	        <base href="<%=basePath%>"> 
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
				<style type="text/css">
		body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("<%=basePath%>Pictures/newbackground.png");
}
		.STYLE5 {
			font-family: "华文行楷";
			font-size: 14mm;
			color: #000000;
		}

		.STYLE6 {
			font-family: "隶书";
			font-size: 12mm;
			color: #000000;
			font-style: italic;
		}
		.STYLE7 {
			font-family: "隶书";
			font-size: 7mm;
			color: #000000;
		}
</style>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
		<script language="javascript" src="<%=basePath %>js/PopupCalendar.js"></script>
		<script>
			var oCalendarEn = new PopupCalendar("oCalendarEn");
			oCalendarEn.Init();
		
			var oCalendarChs = new PopupCalendar("oCalendarChs");
			oCalendarChs.weekDaySting = new Array("日", "一", "二", "三", "四", "五", "六");
			oCalendarChs.monthSting = new Array("一月", "二月", "三月", "四月", "五月", "六月",
					"七月", "八月", "九月", "十月", "十一月", "十二月");
			oCalendarChs.oBtnTodayTitle = "今天";
			oCalendarChs.oBtnCancelTitle = "取消";
			oCalendarChs.Init();
		</script>
	</head>

	<body>
	
		<br>
		<br>
		<h3 align="center">
			<img src="<%=basePath%>Pictures/Aluminum_001.png" align="top" border="0" width="50" height="50"/>学生基本信息编辑
		</h3>
		<hr>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>admin/ClassInfo!findAllClassInfo.action"  ><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<s:form action="admin/StudentInfo!findStudentbyName.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left">
							<img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>按学生姓名查询:
							<s:textfield name="FNameselect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
					</tr>
				</table>
			</s:form>
			
			<s:form action="admin/StudentInfo!searchStudentByNum.action" method="post" theme="simple">
				<table width="40%" border="0" align="center">
					<tr>
						<td align="left">
							<img src="<%=basePath%>Pictures/search.gif" align="top" border="0"/>按学生学号查询:
							<s:textfield name="FStudentNumSelect" />
							&nbsp;
							<s:submit value="提交" />
						</td>
						
					</tr>
				</table>
			</s:form>
			
	<table width="80%" border="0" align="center">
					<tr>
				<th align="right"><a href="9_genzongfankui_system/Admin/addStudent.jsp"  ><img src="<%=basePath%>Pictures/edit.gif" align="top" border="0"/>添加学生信息</a></th>
			</tr>
					
				</table>
		<hr>
		<div align="center">
			<table border="0" width="700" id="mytable" method="post">
				<tr>
					<th colspan="14" background="<%=basePath%>Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">学生基本信息</font>
					</th>
				</tr>
				<tr>
				<th>
						序号

					</th>
					<th>
						学号
					</th>
					<th>
						姓名
					</th>
					<th>
						班级
					</th>
					<th>
						专业
					</th>
					<th>
						性别
					</th>
					<th>
						出生年月
					</th>
					
					<th>
						民族
					</th>
					<th>
						政治面貌
					</th>
					<th>
						毕业去向
					</th>
					<th>
						奖惩记录
					</th>
					<th>
						修改
					</th>
					<th>
						删除
					</th>
				</tr>
				<s:iterator value="listStudentInfo" status="status">
				   <tr>
				   <td align="center"><s:property value="#status.count"/></td>
				     <td align="center"><s:property value="FStudentNumber"/></td>
				     <td align="center"><s:property value="FStudentName"/></td>
				     <td align="center"><s:property value="TabClasses.FClassNumber"/></td>
				     <td align="center"><s:property value="FStudentMajor"/></td>
				     <td align="center"><s:property value="FStudentSex"/></td>
				     <td align="center"><s:property value="FStudentBirthday"/></td> 
				     
				     <td align="center"><s:property value="FStudentNation"/></td>
				     <td align="center"><s:property value="FStudentPoliStatus"/></td>
				     <td align="center"><s:property value="FQuXiang"/></td>
				     <td align="center"><s:property value="FRewardPunish"/></td>

				     <td align="center">
				        <a href="admin/StudentInfo!findStudentbyNum.action?FStudentNumber=<s:property value="FStudentNumber"/>">
				                          <img src="<%=basePath%>Pictures/edit_profile.gif" align="middle" border="0">
				        </a>
				     </td>
				     <td align="center">
				        <a href="admin/StudentInfo!delStudentByNum.action?FStudentNumber=<s:property value="FStudentNumber"/>">
				                          <img src="<%=basePath%>Pictures/Del1.png" align="middle" border="0">
				        </a>
				     </td>
				   </tr>
			</s:iterator>
			</table>
		</div>
		<br>
		<table width="40%" align="center">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>admin/StudentInfo!findAllStudentInfo.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/StudentInfo!findAllStudentInfo.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/StudentInfo!findAllStudentInfo.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>admin/StudentInfo!findAllStudentInfo.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
		<br>
		<br>
	</body>
</html>
