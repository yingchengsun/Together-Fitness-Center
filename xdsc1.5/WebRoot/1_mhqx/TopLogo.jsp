<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	errorPage="/errorPage.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<table width="100%">
	<tr>
		<td align="center" width="100%" bgcolor="lightblue">
			<img src="image/topcut.jpg" height="85" width="100%">
		</td>
	</tr>
	<tr style='background-color: <%=session.getAttribute("color")%>'>
		<td height=auto width="100%" valign="middle" valign=top>
			<table>
				<td>
					<span style="padding-left: 20px"><font color="#ffffff"
						size="2"> ${WelcomeUser} </font> </span>
				</td>
				<td>
					<span style="padding-left: 600px;"><label
							style="color: #ffffff;"
							onclick="addTab('个人主页','NewNotice!getUserNewNotice.action')">
							个人主页
						</label> &nbsp&nbsp| &nbsp&nbsp<a
						href="loginOutAction!loginOut.action" class="LINK21"
						style="color: #ffffff">安全退出</a> </span>
				</td>
				<td valign="top">
				<span style="padding-left: 60px">
				<form action="ChangeCssAction!insertOrUpdateCss.action" method="post">
				<select name="css" >
					<option value="purple">
					背景色
					</option>
					<option value="red5" style="background-color:#FA8072;width:20px"></option>
					<option value="orange" style="background-color:orange;width:20px"></option>
					<option value="purple" style="background-color:#CC99FF;width:20px"></option>
					<option value="blue" style="background-color:lightblue;width:20px"></option>
					<option value="gray" style="background-color:#DCDCDC;width:20px"></option>
					<option value="darkgray" style="background-color:darkgray;width:20px"></option>			
					<option value="black" style="background-color:black;width:20px"></option>
					<option value="olive" style="background-color:#99FF33;width:20px"></option>
				</select>
				<input type="submit" name="submit" value="设置" />
				</form>
			</span>
			</td>
			</table>
		</td>
	</tr>
	<table>