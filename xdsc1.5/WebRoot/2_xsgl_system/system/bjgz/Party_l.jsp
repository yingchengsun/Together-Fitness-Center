<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
	</head>

	<body>
	
		<br>
		<h3 align="center">
			学生党建信息
		</h3>
		<hr>
		<div align="center">
		<form action="selectPartyByNameYearClass.action">
				<table>
					<tr>
						<th>
							快速查找：
						</th>
						<td>
						 年份：
						</td>
						<td>
							<select name="year">
								<option value="2009">
									2009
								</option>
								<option value="2008">
									2008
								</option>
								<option value="2007">
									2007
								</option>
								<option value="2006">
									2006
								</option>
							</select>
						</td>
						<td>
							班级：
						</td>
						<td>
							<select name="classid">
								<c:forEach items="${classList }" var="class">
									<option value="${class.FClassNumber }">
										${class.FClassNumber }
									</option>
								</c:forEach>
							</select>
						</td>
						
						<td>
							类别：
						</td>
						<td>
							<select name="status">
								<option value="0">
									党员
								</option>
								<option value="1">
									预备党员
								</option>
								<option value="2">
									党员发展对象
								</option>
								<option value="3">
									入党积极分子
								</option>
							</select>
						</td>
						<td>
							<input type="submit" value="查询">
						</td>
					</tr>
				</table>
			</form>
			
		</div>
		<hr>
		<div align="center">
		<form action="getPartyList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="7" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院学生党建信息</font>
					</th>
				</tr>
				<tr>
				<th>
						班级
					</th>
					<th>
						类别
					</th>
					<th>
						总人数
					</th>
					<th>
						男生人数
					</th>
					<th>
						女生人数
					</th>
					<th>
						年份
					</th>
					<th>
						详细信息
					</th>
				</tr>
				<c:forEach items="${partyList }" var="pstudent">
				<tr>
					<td>
						${pstudent.tabClasses.FClassNumber }
					</td>
					<td>
						${pstudent.FName }
					</td>
					<td>
						${pstudent.FTotalNum }
					</td>
					<td>
						${pstudent.FMaleNum }
					</td>
					<td>
						${pstudent.FFemaleNum }
					</td>
					<td>
						${pstudent.FYear }
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/getPartyMemberListByClassAndName.action?id=${pstudent.FId }">浏览</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="parStuPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="parStuFeeNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${partytAll.pageCount }页，当前第${partytAll.page+1 }页
					</td>
				</tr>
			</table>
			</form>
		</div>
	</body>
</html>
