<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>7_yjssx_system/dialog.css" rel="stylesheet" type="text/css"></link>

<script language="javascript" src="<%=basePath %>7_yjssx_system/jquery-latest.pack.js"></script>
<script language="javascript" src="<%=basePath %>7_yjssx_system/dialog.js"></script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
 <div align="center">
	<img src="<%=basePath %>7_yjssx_system/SubSystemImage/selfInfo.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">个人信息</div></td>
      </tr>
   </table>
	<hr align="center" width="100%"/>
      <table width="100%" height="174" style="border-collapse:collapse">
          <tr >
            <td width="17%" height="24" align="left"><div align="center"><strong>姓名：</strong></div></td>
		    <td width="31%" align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentName"/></td>
		    <td width="14%" align="left"><div align="center"><strong>出生日期：</strong></div></td>
		    <td width="17%" align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentBirthday"/></td>
	      </tr>
          <tr style="background-color:#CCCCCC">
            <td height="24" align="left"><div align="center"><strong>性别：</strong></div></td>
	        <td align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentSex"/></td>
	        <td align="left"><div align="center"><strong>民族：</strong></div></td>
	        <td width="21%" align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentNation"/></td>
      </tr>
          <tr>
            <td height="29" align="left"><div align="center"><strong>籍贯：</strong></div></td>
            <td align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentNativeplace"/></td>
            <td align="left"><div align="center"><strong>本科学校：</strong></div></td>
            <td align="left"><s:property value="postgraduateSelfInfo.FStudentExSchool"/></td>
        </tr>
          <tr style="background-color:#CCCCCC">
            <td height="30" align="left"><div align="center"><strong>入校时间：</strong></div></td>
            <td align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentRegData"/></td>
            <td align="left"><div align="center"><strong>硕士类型：</strong></div></td>
            <td align="left"><s:property value="postgraduateSelfInfo.FType"/></td>
        </tr>
          <tr>
            <td height="31" align="left"><div align="center"><strong>联系电话：</strong></div></td>
            <td align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentTel"/></td>
            <td align="left"><div align="center"><strong>邮箱：</strong></div></td>
            <td align="left"><s:property value="postgraduateSelfInfo.tabStudents.FStudentEmail"/></td>
        </tr>
   </table>

   <table width="80%" border="0" >
      <tr>
        <td width="80%" height="26"><div align="center">若有变更请您及时<font color="#ff0000"><a href="#" class="LINK21" onclick='dialog(&quot;修改信息&quot;,&quot;url:get?<%=basePath %>yjssxStudent/PostgraudateSelfInfo!preModifySelfInfo.action&quot;,&quot;720px&quot;,&quot;auto&quot;,&quot;id&quot;); '><strong>修改</strong></a></font></div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
</div>
</body>
</html>
