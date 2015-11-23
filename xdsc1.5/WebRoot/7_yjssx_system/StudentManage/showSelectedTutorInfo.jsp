<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
 
   <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">已选导师</div></td>
      </tr>
   </table>
   <hr align="center" width="100%" size="2" color="#990033"/>
   <table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
	  <tr>
	    <th scope="col"><div align="center">姓名</div></th>
	    <th scope="col"><div align="center">性别</div></th>
	    <th scope="col"><div align="center">职位</div></th>
	    <th scope="col"><div align="center">职称</div></th>
	    <th scope="col"><div align="center">研究方向</div></th>
	    <th scope="col"><div align="center">办公地址</div></th>
	    <th scope="col"><div align="center">办公电话</div></th>
	    <th scope="col"><div align="center">查看详情</div></th>
	  </tr>
	  <tr>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherName"/></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherSex"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherPosition"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherZhiCheng"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherResearch"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherWorkPlace"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherTel"/></div></td>
	    <td> <div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		<a class="LINK21" href="#" onclick='dialog("导师详情","url:get?<%=basePath %>yjssxStudent/PostgraduateAllTutorInfoForSelect!findTutorDetailInfo.action?DetailNum=<s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherNumber"/>","720px","auto","id"); '>点击查看详情</a> </div></td>
	 	  </tr>
	  	  
	  <tr>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherName"/></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherSex"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherPosition"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherZhiCheng"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherResearch"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherWorkPlace"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFSecondWish.FTeacherTel"/></div></td>
	     <td> <div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		<a class="LINK21" href="#" onclick='dialog("导师详情","url:get?<%=basePath %>yjssxStudent/PostgraduateAllTutorInfoForSelect!findTutorDetailInfo.action?DetailNum=<s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherNumber"/>","720px","auto","id"); '>点击查看详情</a> </div></td>
	  </tr>
	  	  <tr>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherName"/></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherSex"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherPosition"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherZhiCheng"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherResearch"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherWorkPlace"/></div></td>
	    <td><div align="center"><s:property value="selectedTutor.tabTeachersByFThirdWish.FTeacherTel"/></div></td>
	     <td> <div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		<a class="LINK21" href="#" onclick='dialog("导师详情","url:get?<%=basePath %>yjssxStudent/PostgraduateAllTutorInfoForSelect!findTutorDetailInfo.action?DetailNum=<s:property value="selectedTutor.tabTeachersByFFirstWish.FTeacherNumber"/>","720px","auto","id"); '>点击查看详情</a> </div></td>
	  </tr>
  </table>
</div> 
</body>
</html>
