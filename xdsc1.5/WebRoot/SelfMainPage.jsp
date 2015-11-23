<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<%=basePath%>js/jquery-1.4.2.js"></script>
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
		<link href="<%=request.getContextPath() %>/css/dialog.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="<%=request.getContextPath() %>/js/jquery-latest.pack.js"></script>
		<script language="javascript" src="<%=request.getContextPath() %>/js/dialog.js"></script>
		
		
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
		<script type="text/javascript" language="javascript">
		function fetch_object(idname)
		{
 			var my_obj = document.getElementById(idname);
 			return my_obj;
		}
		function show_sub(obj)
		{
			var content_detail = fetch_object("detail" + obj);
  			var show_content = fetch_object("text" + obj);
  			if (content_detail.style.display == "block")
  			{
  				 content_detail.style.display="none";
   				 show_content.innerHTML="显示内容";
  			}
  			else
  			{
  				content_detail.style.display="block";
  				show_content.innerHTML="隐藏内容";
 		    }
		}
		
		function conf(){
			confirm("您确定要删除？");
		}
		
		function conf2(){
			alert("修改成功 请重新登录查看效果！");
		}
	</script>

	</head>
<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
<body onload="autoLoad()" 
		>
		<div align="left" style="padding-left:150px;padding-top: 60px">
			
	         	<table width="550px"  id="mytable"
				>
				<tr bgcolor="#cccccc" style="color:royalblue;" align=center>
				<td colspan=1 width=137px><img
					src="<%=basePath%>/images/grzl.png" align="bottom" /><a  href="#" onclick='dialog("个人资料","iframe:showPIAction!showPersonalInfo.action","500px","350px","iframe");' class="LINK21"><font color="royalblue">查看个人资料</font></a></td>
				<td colspan=1 width=137px><img
					src="<%=basePath%>/images/sjx.png" align="bottom" />您有<a href="<%=request.getContextPath() %>/8_mail_system/emailshow.action" class="LINK21" ><font color="royalblue">[${countOfNew }]&nbsp;封未读邮件</font></a></td>
				<td bgcolor=transparent width=177px>
				
				</td>
				<td bgcolor=transparent></td>
				</tr>
				</table>
		
			<table width="550px" border="1" id="mytable"
				style="border-collapse: collapse">
			
				<tr>
					<td valign="bottom" align="center" colspan=4 >
						<span style="color: black; letter-spacing: 1px;"> 新鲜事列表 </span>
					</td>
				</tr>
				
				<tr bgcolor="<%=session.getAttribute("color") %>" style="color:#ffffff">
					<td width=150px>
						类别
					</td>
					<td width=150px>
						时间
					</td>
					<td width=180px>
						标题
					</td>
					<td width=70px>
						删除
					</td>
				</tr>
				<s:iterator value="noticeList" status="sl">
			
					<tr align="left">
						<td>
							<font size="2"><s:property value="FInfoType" />:</font>
						</td>
						<td>
							<fmt:formatDate value="${FInfoStartTime}" type="date"
								dateStyle="long" />
						</td>
						<td>
							<a href="#"
								onclick="javasrcipt:show_sub(<s:property value="FInfoId" />)"
								class="LINK21"> [<s:property value="FInfoTitle"
									escape="false" />] <font color=" #CC99FF" size="1"
								id="text<s:property value="FInfoId" />"> 显示内容</font></a>
						</td>
						<td align=center>
							<a href="NewNotice!deleteNotice.action?FInfoId=<s:property value="FInfoId" />" class="LINK21" onclick="return conf() ">【X】</a>
						</td>
					</tr>
					<tr>
						<td  colspan=4>
							<div id="detail<s:property value="FInfoId" />"
								style="display: none;background-color:wheat;
	filter: alpha(opacity :70);color:black; ">
								<s:property value="FInfoContet" escape="false" />
							</div>
						</td>
					</tr>
				
				</s:iterator>
			</table>
		</div>
	</body>
</html>

