<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<script language="javascript" src="5_sjjx_system/JS/PopupCalendar.js"></script>
  </head>
  
  <body>
  <br>
   <h3 align="center">设备详细信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="showallEquip.action"><img src="5_sjjx_system/Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
				<table border="1" width="500">
					<tr>
						<th height="30" colspan="2" align="center" background="5_sjjx_system/Pictures/newmenubg.gif">
							<font color="#FFFFFF">设备详细信息</font>
						</th>
					</tr>
					<tr>
						<td>
							领用单位：
						</td>
						<td>
							<input type="text" name="FDepartmentId" value="${equip.FDepartmentId }" size="60" readonly="readonly"/>
						    <input type="hidden" name="FEquId" value="${equip.FEquId }"/>
						</td>
					</tr>
					<tr>
						<td>
							领用单位：
						</td>
						<td>
							<input type="text" name="FDepartmentName" value="${equip.FDepartmentName }" size="60" readonly="readonly"/>
						    
						</td>
					</tr>
					<tr>
						<td>
							设备编号：
						</td>
						<td>
							<input type="text" name="FEquId" value="${equip.FEquId }"  size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							设备名称：
						</td>
						<td>
							<input type="text" name="FEquName" value="${equip.FEquName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							设备型号：
						</td>
						<td>
							<input type="text" name="FEquPattern" value="${equip.FEquPattern }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							设备规格：
						</td>
						<td>
							<input type="text" name="FEquStandard" value="${equip.FEquStandard }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							设备单价：
						</td>
						<td>
							<input type="text" name="FEquPrice" value="${equip.FEquPrice }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							国别：
						</td>
						<td>
							<input type="text" name="FPersonS" value="${equip.FCountry }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							购买厂家：
						</td>
						<td>
							<input type="text" name="FEquBuyCompany" value="${equip.FEquBuyCompany }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							出厂号：
						</td>
						<td>
							<input type="text" name="FChuChangId" value="${equip.FChuChangId }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							领用人：
						</td>
						<td>
							<input type="text" name="FPersonL" value="${equip.FPersonL }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							经费科目名：
						</td>
						<td>
							<input type="text" name="FFundsName" value="${equip.FFundsName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							使用方向名：
						</td>
						<td>
							<input type="text" name="FUseDirectionName" value="${equip.FUseDirectionName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							科研号：
						</td>
						<td>
							<input type="text" name="FKeYanId" value="${equip.FKeYanId }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							单据号：
						</td>
						<td>
							<input type="text" name="FDanJuId" value="${equip.FDanJuId }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							经手人：
						</td>
						<td>
							<input type="text" name="FPersonJ" value="${equip.FPersonJ }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							入库时间：
						</td>
						<td>
							<input type="text" name="FRuKuTime" value="${equip.FRuKuTime }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							资产类别：
						</td>
						<td>
							<input type="text" name="FZiChanType" value="${equip.FZiChanType }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							国标分类号：
						</td>
						<td>
							<input type="text" name="FGuoBiaoId" value="${equip.FGuoBiaoId }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							记账人：
						</td>
						<td>
							<input type="text" name="FJiZhangRen" value="${equip.FJiZhangRen }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							输入日期：
						</td>
						<td>
							<input type="text" name="FShuRuTime" value="${equip.FShuRuTime }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							设备来源：
						</td>
						<td>
							<input type="text" name="FEquSourseName" value="${equip.FEquSourceName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							折旧方式：
						</td>
						<td>
							<input type="text" name="FZheJiuName" value="${equip.FZheJiuName }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							保修期限：
						</td>
						<td>
							<input type="text" name="FBaoXiuDate" value="${equip.FBaoXiuDate }" size="60" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td>
							备注：
						</td>
						<td>
							<input type="text" name="FRemarks" value="${equip.FRemarks }" size="60" readonly="readonly"/>
						</td>
					</tr>
				</table>
		
		</div> 
		<br>
  </body>
</html>
