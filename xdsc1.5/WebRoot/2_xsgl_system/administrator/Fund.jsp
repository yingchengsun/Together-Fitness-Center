<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css.css">
		<script language="javascript" src="<%=request.getContextPath() %>/2_xsgl_system/JS/TableColor.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/2_xsgl_system/mycss.css">
	</head>

	<body>
	
		<br>
		<h3 align="center">
			资助及奖学金信息
		</h3>
		<hr>
		<div align="center">
		<form action="selectFundByNameClassYear.action">
				<table>
					<tr>
						<th>
							按班级查找：
						</th>
						<td>
						年份：
						</td>
						<td>
						<select name="year">
							<option value="2010">
								2010
							</option>
							<option value="2009">
								2009
							</option>
							<option value="2008">
								2008
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
						<select name="name">
							<option value="0">
								助学贷款
							</option>
							<option value="1">
								助学金
							</option>
							<option value="2">
								奖学金
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
				<th align="right"><a href="<%=request.getContextPath() %>/2_xsgl_system/administrator/AddFund.jsp">
				<img src="<%=request.getContextPath() %>/2_xsgl_system/Pictures/return.gif" align="top" border="0"/>添加</a></th>
			</tr>
		</table>
		<div align="center">
		<form action="getFundList.action">
			<table border="0" width="700" id="mytable">
				<tr>
					<th colspan="8" background="<%=request.getContextPath() %>/2_xsgl_system/Pictures/newmenubg.gif" height="30">
						<font color="#FFFFFF">软件学院资助及奖学金信息列表</font>
					</th>
				</tr>
				<tr>
					<th>
						班级
					</th>
					<th>
						类别名称
					</th>
					<th>
						总人数
					</th>
					
					<th>
						总金额
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
				<c:forEach items="${JiangzhuList }" var="fund">
				<tr>
					<td>
						${fund.tabClasses.FClassNumber }
					</td>
					<td>${fund.FName }
					</td>
					<td>${fund.FTotalNum }
					</td>				
					<td> 
						${fund.FAmount } 
					</td>
					<td> 
						${fund.FYear } 
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/getStudentByNYC.action?id=${fund.FId }">浏览</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/preUpdateFund.action?id=${fund.FId }">更新</a>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/deleteFund.action?id=${fund.FId }">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		
			<table width="40%">
				<tr>
					<td>
						<div align="center">
							<a href="fundPrevious.action">上一页</a>
						</div>
					</td>
					<td>
						<div align="center">
							<a href="fundNext.action">下一页</a>
						</div>
					</td>
					<td>
						共${JiangzhuAll.pageCount }页，当前第${JiangzhuAll.page+1 }页
					</td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<div align="center">
				<form action="excelInFund.action" enctype="multipart/form-data" method="post">
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
