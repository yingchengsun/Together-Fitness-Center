<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>导入</title>

		<link rel="stylesheet" type="text/css" href="../../css.css">
		<link rel="stylesheet" type="text/css" href="../../mycss.css">
		<script language="javascript" src="../../js/TableColor.js"></script>
	</head>

	<body>
		<br>
		<h3 align="center">
			信息上传
		</h3>
		<hr>
		<table align="center" width="700">
			<tr>
				<th align="right">
					<a href="SubjectImportOne.jsp"><img
								src="../../Pictures/return.gif" align="top" border="0" />手动添加
					</a>
				</th>
			</tr>
		</table>
		<div align="center">
			<form action="SubjectManagement.jsp">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="../../Pictures/newmenubg.gif">
							<img src="../../Pictures/excel.bmp" border="0" align="top" />
							<font color="#FFFFFF">导入Excel文件</font>
						</th>
					</tr>
					<tr>
						<td>
							选择文件:
						</td>
						<td>
							<input type="file" size="40">
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		
		<hr>



	</body>
</html>
