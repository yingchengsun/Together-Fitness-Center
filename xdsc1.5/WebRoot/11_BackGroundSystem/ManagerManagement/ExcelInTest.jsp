<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<title>Excel表格内容导入数据库测试页面</title>
	</head>

	<body>
		<form action="excelIn.action" enctype="multipart/form-data" method="post"> 
			请按如下格式排版excel的列字段（以 表1：tab_course 学生表为例）： 
			<br>
			<br> 
			课程编号|	课程名	|学分|	学时 <br>
			<br>
			导入excel文件：
			
			<br>  
			<input type="file" name="file" /><br>
			<input type="submit" value="导入" />

			<br>

		</form>





	</body>
</html>
