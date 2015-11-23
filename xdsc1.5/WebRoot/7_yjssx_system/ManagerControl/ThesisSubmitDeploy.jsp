<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		    	function setNull1(){
		    		var objs = document.getElementById("id1");
		    		objs.value="";
		    	}
		    	function setNull2(){
		    		var objs = document.getElementById("id2");
		    		objs.value="";
		    	}
		</script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/clock.png" height="70" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">论文提交功能配置</div></td>
      </tr>
   </table>

   <hr align="center" width="100%"/>
  <form action="yjssxAdmin/AdminSystemFunctionDeploy!ThesisFunctionDistinguish.action" method="post">
   <table width="100%" border="0" style="border-collapse:collapse">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>论文报告类型：</strong></div></td>
   	  	<td><div align="center"><strong>开通或关闭：</strong></div></td>
   	  	<td><div align="center"><strong></strong></div></td>
   	  </tr>
      <tr>
        <td height="26">
        	<div align="center">
				<select name="thesisType">
					<option value="1">开题报告</option>
					<option value="2">中期检查</option>
					<option value="3">终审论文</option>
				</select>
			</div>
		</td>
		<td height="26"><div align="center">
			<select name="type">
					<option value="open">开通功能</option>
					<option value="close">关闭功能</option>
		    </select>
		</div>
		</td>
		<td><div align="left"><input type="submit" value="提交"/></div></td>
     </tr>
   </table>
  </form>
   <table width="100%" border="0" style="border-collapse:collapse"> 
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>开通特定研究生论文提交功能：</strong></div></td>
   	  	<td><div align="center"><strong>关闭特定研究生论文提交功能：</strong></div></td>
   	  </tr>
      <tr>
        <td height="26"><div align="center">
		<form action="yjssxAdmin/AdminSystemFunctionDeploy!StudentSearchByNameForSubmitThesis.action" method="post">
			<input type="hidden" name="type" value="open"/>
			开题报告<input type="radio" name=thesisType value="1" checked="checked"/>
			中期检查<input type="radio" name="thesisType" value="2"/>
			终审论文<input type="radio" name="thesisType" value="3"/><br/>
	  	  	<input name="studentName" id="id1" value="请输入研究生姓名..." onclick="setNull1()"/>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
		<td height="26"><div align="center">
		<form action="yjssxAdmin/AdminSystemFunctionDeploy!StudentSearchByNameForSubmitThesis.action" method="post">
			<input type="hidden" name="type" value="close"/>
			开题报告<input type="radio" name="thesisType" value="1" checked="checked"/>
			中期检查<input type="radio" name="thesisType" value="2"/>
			终审论文<input type="radio" name="thesisType" value="3"/><br/>
	  	  	<input name="studentName" id="id2" value="请输入研究生姓名..." onclick="setNull2()"/>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
     </tr>
   </table>
   <hr align="center" width="100%"/>
</div>
</body>
</html>
