<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>BookManage.jsp</title>


  </head>
  
  <body>
    <%
    	Date date = new Date();
    	int month = date.getMonth()+1;
    	if(month==2||month==7){
    	%>
    	
    	<script type="text/javascript">
    		window.alert('不在预定机房的时间之内');
    		window.location.href="<%=request.getContextPath()%>/5_sjjx_system/teacher/Homepage.jsp";
    	</script>
    	
    	<%
    	}else{
    	%>
    	
    	<script type="text/javascript">
    		window.alert('欢迎使用预定机房功能');
    		window.location.href="<%=request.getContextPath()%>/search.action";
    	</script>
    	<%
    	}
     %>
  </body>
</html>
