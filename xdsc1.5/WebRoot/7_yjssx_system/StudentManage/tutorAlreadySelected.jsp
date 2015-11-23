<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tutorAlreadySelected.jsp' starting page</title>

  </head>
  
  <body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
	  <div align="center">
	    <font color="#000000" ><font size="6"> 
	    	您的导师已经选择！</font>
	    </font><p> 	     
	     <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/><a href="<%=basePath %>yjssxStudent/PostgraduateSelectTutor!SelectedTutorInfo.action">查看已选导师信息</a>
	     <p>
	     <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/><a href="<%=basePath %>yjssxStudent/PostgraduateSelectTutor!preUpdateTutorInfo.action">修改导师选择</a>
	  </div>
  </body>
</html>
