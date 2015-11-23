<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FunctionList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
        <!--  
        <s:iterator value="functionlist">
             <a href="${FFilePath }">${FFunctionName }</a><br>
        </s:iterator>
        --> 
        <s:iterator id="module" value="modulelist">
                    <li> ${FModuleName }</li>
			<s:iterator id="first" value="firstList" status="st">
			     <s:if test="#module.FModuleId==#first.mhqxTabModule.FModuleId">
				   <li>
					 ${FFunctionName }
				   </li>
				  <s:iterator id="sub" value="sublist[#st.index]">
				   <li>
					<a href="${mhqxTabFunction.FFilePath }">${mhqxTabFunction.FFunctionName}</a>
					<br>
				   </li>
		          </s:iterator>
		        </s:if>
		    </s:iterator>
	    </s:iterator>
	</body>
</html>
