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
		<form action="selectPartyByYearClass.action">
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
		<table align="center" width="700">
			<tr>
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddParty.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table> 
		<div align="center">
		<form action="showPartyList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="9" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
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
					<th>
					    修改
					</th>
					<th>
						删除
					</th>
				</tr>
				<c:forEach items="${partyList }" var="party">
				<tr>
					<td>
						${party.tabClasses.FClassNumber }
					</td>
					<td>
						${party.FName }
					</td>
					<td>
						${party.FTotalNum }
					</td>
					<td>
						${party.FMaleNum }
					</td>
					<td>
						${party.FFemaleNum }
					</td>
					<td>
						${party.FYear }
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/getPartyMemberListByClassAndName.action?id=${party.FId }">浏览</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateParty.action?id=${party.FId }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteParty.action?id=${party.FId }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="partyPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="partyFeeNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${partytAll.pageCount }页，当前第${partytAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInParty.action" enctype="multipart/form-data" method="post">
					<table border="1" width="700">
						<tr>
							<th height="30" colspan="2" align="center"
								background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif">
								<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/excel.bmp" border="0" align="top" />
								<font color="#FFFFFF">导入Excel文件</font>
							</th>
						</tr>
						<tr>
							<td>
								选择文件:
							</td>
							<td>
								<input type="file" name="file" size="40">
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
	</body>
</html>
