<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>欢迎页面</title>


		<link rel="stylesheet" type="text/css" href="../../css/css.css">
		<link rel="stylesheet" type="text/css" href="../../css/mycss.css" />

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
							src="<%=request.getContextPath()%>/bksx/pictures/OFFICE_MEN_001.png"
							width="100" height="100" align="middle" />
					</th>
					<th>
						<table width="150" border="0" align="left">
							<tr>
								<th>
									姓名
								</th>
								<th align="left">
									管理员
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
								<img src="<%=request.getContextPath()%>/bksx/pictures/23301.png"
									width="30" height="30" align="middle" />
								快速通道
							</legend>
							<table width="90%" border="0" height="100">
								<tr>
									<th width="175">
										<a href="<%=request.getContextPath()%>/showSubstugui.action">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/Vista_Glass_Folders_001.png"
												width="50" height="50" align="middle" border="0" onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											毕设选题 </a>

									</th>
									<th width="175">
										<a href="<%=request.getContextPath()%>/showAllProject.action">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/ontained.png"
												width="50" height="50" align="middle" border="0"  onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											项目课题 </a>

									</th>
									<th width="175">
										<a href="filePreDownload.jsp"> <img
												src="<%=request.getContextPath()%>/bksx/pictures/RAR_ZIP.png"
												width="50" height="50" align="middle" border="0"  onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											文档查收 </a>

									</th>
									<th width="175">
										<a
											href="<%=request.getContextPath()%>/showChecklistNotice.action">
											<img
												src="<%=request.getContextPath()%>/bksx/pictures/bagong_005.png"
												width="50" height="50" align="middle" border="0"  onmouseover="zoom(this)" onmouseout="zoom(this)"/> <br>
											答辩安排 </a>

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
