<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>欢迎页面</title>


		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css.css">

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
			<table width="700" border="0">
				<tr>
					<th align="left" width="100">
						<img
							src="<%=request.getContextPath()%>/7_yjssx_system/SubSystemImage/OFFICE_MEN_001.png"
							width="100" height="100" align="middle" />
					</th>
					<th>
						<table width="150" border="0" align="left">
							<tr>
								<th>
									姓名
								</th>
								<th align="left">
									导师
								</th>
							</tr>
							<tr>
								<th>
									性别
								</th>
								<th align="left">
									男
								</th>
							</tr>
							<tr>
								<th>
									职称
								</th>
								<th align="left">
									教授
								</th>
							</tr>
							<tr>
								<th>
									学院
								</th>
								<th align="left">
									软件学院
								</th>
							</tr>
						</table>
					</th>
				</tr>
			</table>
			<hr>
			<br>
			<table>
				<tr>
					<td>
						<fieldset>
							<legend>
								<img src="<%=request.getContextPath()%>/7_yjssx_system/SubSystemImage/23301.png"
									width="30" height="30" align="middle" />
								快速通道
							</legend>
							<table width="700" border="0" height="100">
								<tr>
									<th width="175">
										<a href="<%=request.getContextPath()%>/yjssxTutor/TutorReceiveStudent!findAllDispachedStudent.action">
											<img
												src="<%=request.getContextPath()%>/7_yjssx_system/SubSystemImage/Vista_Glass_Folders_001.png"
												width="50" height="50" align="middle" border="0" onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											报 名 信 息</a>

									</th>
									<th width="175">
										<a href="<%=request.getContextPath()%>/yjssxTutor/TutorReceiveThesis!submitThesis.action">
											<img
												src="<%=request.getContextPath()%>/7_yjssx_system/SubSystemImage/ontained.png"
												width="50" height="50" align="middle" border="0"  onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											查 收 论 文 </a>

									</th>
									<th width="175">
										<a href="<%=request.getContextPath()%>/yjssxTutor/TutorReturnThesis!submitedStudent.action"> <img
												src="<%=request.getContextPath()%>/7_yjssx_system/SubSystemImage/RAR_ZIP.png"
												width="50" height="50" align="middle" border="0"  onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											反 馈 论 文 </a>

									</th>
									<th width="175">
										<a
											href="<%=request.getContextPath()%>/yjssxTutor/TutorStuInfoForNotice!AllStudentInfo.action">
											<img
												src="<%=request.getContextPath()%>/7_yjssx_system/SubSystemImage/bagong_005.png"
												width="50" height="50" align="middle" border="0"  onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											研 究 生 信 息 </a>

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
