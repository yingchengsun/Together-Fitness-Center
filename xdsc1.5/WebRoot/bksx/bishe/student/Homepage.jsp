<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>欢迎页面</title>


		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bksx/css/mycss.css" />

		<script type="text/javascript">
 function zoom(o){
  var _z=o.style.zoom;
  if(_z!=1.3){
   o.style.zoom=1.3;
  }else{
   o.style.zoom=1;
  }
 }
</script>
	</head>

	<body>
		<br>
		<br>
		<div align="center">
			<table width="90%" border="0">
				<tr>
					<th align="left" width="100">
						<img
							src="<%=request.getContextPath()%>/bksx/pictures/Scrap_Icons_001.png"
							width="100" height="100" align="middle" />
					</th>
					<th>
						<table width="300" border="0" align="left">
							<tr>
								<th>
									学号
								</th>
								<th align="left">
									${student.FStudentNumber }
								</th>
							</tr>
							<tr>
								<th>
									姓名
								</th>
								<th align="left">
									${student.FStudentName }
								</th>
							</tr>
							<tr>
								<th>
									性别
								</th>
								<th align="left">
									${student.FStudentSex }
								</th>
							</tr>
							<tr>
								<th>
									邮件
								</th>
								<th align="left">
									${student.FStudentEmail }
								</th>
							</tr>
						</table>
					</th>
				</tr>
			</table>
			<hr>
			<br>
			<c:if test="${showAvaliable=='Y' }">
				<div align="center">
					<table border="1" cellspacing="0"  width="90%">
						<tr>
							<td>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								敬告: 目前系统不存在你的选题信息，请点击左侧的
								<font color="green">在线选题</font>
								<br>
								或联系管理员了解详情
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>
			</c:if>
			<table>
				<tr>
					<td>
						<fieldset>
							<legend>
								<img src="<%=request.getContextPath()%>/bksx/pictures/23301.png"
									width="30" height="30" align="middle" />
								快速通道
							</legend>
							<table width="90%" border="0" height="100">
								<tr>
									<th width="175">
										<a
											href="<%=request.getContextPath()%>/getSubjectByStuNum.action">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/MBA.png"
												width="50" height="50" align="middle" border="0"
												onmouseover="zoom(this)" onmouseout="zoom(this)" /> <br>
											课题信息 </a>

									</th>
									<th width="175">
										<a href="<%=request.getContextPath()%>/showDiary.action">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/Antique_Icon_update_001.png"
												width="50" height="50" align="middle" border="0"
												onmouseover="zoom(this)" onmouseout="zoom(this)" /> <br>
											工作日志 </a>

									</th>
									<th width="175">
										<a
											href="<%=request.getContextPath()%>/bksx/bishe/student/fileUpload.jsp">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/RAR_ZIP.png"
												width="50" height="50" align="middle" border="0"
												onmouseover="zoom(this)" onmouseout="zoom(this)" /> <br>
											文档提交 </a>

									</th>
									<th width="175">
										<a
											href="<%=request.getContextPath()%>/showChecklistNotice.action">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/bagong_005.png"
												width="50" height="50" align="middle" border="0"
												onmouseover="zoom(this)" onmouseout="zoom(this)" /> <br>
											通知公告 </a>
									</th>
								</tr>
							</table>
							<br>
						</fieldset>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>


