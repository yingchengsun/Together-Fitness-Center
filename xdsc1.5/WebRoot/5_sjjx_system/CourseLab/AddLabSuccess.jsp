<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="css.css">
	<link rel="stylesheet" type="text/css" href="5_sjjx_system/mycss.css">
    <script type="text/javascript">
			function check(number){
				if(isNaN(number))
				{
					window.alert("输入有误，请重新填写");
				}
			}
		</script>

  </head>
  
  <body>
  <br><c:choose>
		<c:when test="${exist=='1'}">
			<h3 align="center">
			  该实验室已经存在，请重新填写信息
			</h3>
		   <table align="center" width="700">
			  <tr>
				<th align="left"><a href="showLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			  </tr>
		    </table> 
		<hr>
		<div align="center">
			<form action="addLabInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">重新添加实验室</font>
						</th>
					</tr>
					<tr>
						<td>
							实验室名称：
						</td>
						<td>
							<input type="text" name="FLabName" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							所在校区：
						</td>
						<td>
						   <input type="radio" name="XiaoQu" value="0" checked="checked">
							北校区
							<input type="radio" name="XiaoQu" value="1">
							南校区
						</td>
					</tr>
					<tr>
						<td>
							房间编号：
						</td>
						<td>
							<input type="text" name="FRoomNumber"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							座位数：
						</td>
						<td>
							<input onkeyup="check(this.value)" type="text" name="FSeatNumber"  size="60"/>
								
						</td>
					</tr>
					<tr>
						<td>
							
							<input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		</c:when>
		<c:when test="${exist=='2'}">
			<h3 align="center">
			  此房间编号已经存在，请重新填写信息
			</h3>
		   <table align="center" width="700">
			   <tr>
				   <th align="left"><a href="showLab.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			   </tr>
		   </table> 
		   <hr>
		   <div align="center">
			<form action="addLabInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">重新添加实验室</font>
						</th>
					</tr>
					<tr>
						<td>
							实验室名称：
						</td>
						<td>
							<input type="text" name="FLabName" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							所在校区：
						</td>
						<td>
						   <input type="radio" name="XiaoQu" value="0" checked="checked">
							北校区
							<input type="radio" name="XiaoQu" value="1">
							南校区
						</td>
					</tr>
					<tr>
						<td>
							房间编号：
						</td>
						<td>
							<input type="text" name="FRoomNumber"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							座位数：
						</td>
						<td>
							<input onkeyup="check(this.value)" type="text" name="FSeatNumber"  size="60"/>
								
						</td>
					</tr>
					<tr>
						<td>
							
							<input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		</c:when>
		<c:otherwise>
			<h3 align="center">
			成功添加实验室信息
		    </h3>
		    <table align="center" width="700">
			   <tr>
				<th align="center"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/><a href="showLab.action">返回查看</a></th>
			   </tr>
		    </table>
		   <hr>
		   <div align="center">
			<form action="addLabInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">继续添加新实验室</font>
						</th>
					</tr>
					<tr>
						<td>
							实验室名称：
						</td>
						<td>
							<input type="text" name="FLabName" size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							所在校区：
						</td>
						<td>
						   <input type="radio" name="XiaoQu" value="0" checked="checked">
							北校区
							<input type="radio" name="XiaoQu" value="1">
							南校区
						</td>
					</tr>
					<tr>
						<td>
							房间编号：
						</td>
						<td>
							<input type="text" name="FRoomNumber"  size="60"/>
						</td>
					</tr>
					<tr>
						<td>
							座位数：
						</td>
						<td>
							<input onkeyup="check(this.value)" type="text" name="FSeatNumber"  size="60"/>
								
						</td>
					</tr>
					<tr>
						<td>
							
							<input type="reset" value="重置" />
						</td>
						<td>
							<input type="submit" value="提交" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		</c:otherwise>
		</c:choose>
		
  </body>
</html>
