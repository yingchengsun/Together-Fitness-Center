<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		

		<title>My JSP 'newRemind.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/8_mail_system/css/css.css">
		
<script type="text/javascript">
		function loadCalendar(field){
       		var rtn = window.showModalDialog("calendar.jsp","","dialogWidth:290px;dialogHeight:250px;status:no;help:no;scrolling=no;scrollbars=no");
			if(rtn!=null)
			field.value=rtn;
			return;
			}
			
			function check(content)
			{
				if(content==null||content.length==0)
				{
					window.alert("请填写活动内容");
					
				}
			}
			
			function checktwice()
			{
				var input = document.getElementById("content").value;
				if(input.length==0)
				{
					window.alert("请填写活动内容");
				}
			}
	</script>

	
	</head>

	<body>
	
	

		<s:form action="addremind.action" method="post" name="remind">
			<table>
				<tr>
					<td>
						活动时间:
					</td>
					<td>
						<input type="text" style="width: 200px" name="remind.RTime"
							onclick="loadCalendar(this)">

					</td>
				</tr>
				<tr>
					<td>
						活动内容:
					</td>
					<td>
						<textarea cols="30" rows="5" name="remind.RTask" onselect="select" id="content" onblur="check(this.value)"></textarea>
						<!-- s:textarea name="remind.RTask" cols="30" rows="5" value="输入事务内容"/-->
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td>
						<textarea cols="30" rows="5" name="remind.RNotes"
							onselect="select"></textarea>
						<!--s:textarea name="remind.RNotes" cols="30" rows="5" value="请输入备注"/-->
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;

					</td>
					<td>
						<input type="submit" value="确定" onmouseover="checktwice()">
						&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
