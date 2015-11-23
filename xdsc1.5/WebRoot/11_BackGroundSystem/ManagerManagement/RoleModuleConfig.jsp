<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>角色模块配置</title>
        <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
    	function selectAll(){
    		 var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		var objs = document.getElementsByTagName("input");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
    	function next(){
    	    window.location.href="UserRoleAction!showroleanduser.action";
    	}
    	function finish(){
    	    window.location.href="<%=basePath %>11_BackGroundSystem/welcome_page.jsp";
    	}
    </script>
	</head>

	<body>
	<center>
	    <br>
		
		<br><br>
		
		<!-- 
		    <s:label value="角色模块配置"/>
			<s:form action="RoleModuleAction!saveRoleModuleRelation.action">
				<s:textfield name="roleid" label="角色ID" />
				<s:textfield name="moduleid" label="模块ID" />
				<s:submit value="添加" />
			</s:form>
	    -->
			<fieldset style="border-color: #ECF5FF">
				<legend>
					<font size="2">用户权限如下：</font>
				</legend>
				<s:form name="RoleModuleConfig"
					action="RoleModuleAction!saveRoleModuleRelation.action"
					method="post">
					<table border="1" id="mytable" style="border-collapse: collapse">
						<tr
							style="background-image: url('<%=basePath%>images/titlebg.gif')">
							<td align="center" width="100">
								子系统ID
							</td>
							<td align="center" width="100">
								子系统名
							</td>
							<td align="center" width="100">
								子系统URL
							</td>
							<td align="center" width="100">
								多选
							</td>
						</tr>
						<s:iterator value="modulelist">
							<tr>
								<td align="center">
									<s:property value="FModuleId" />
								</td>
								<td align="center">
									<s:property value="FModuleName" />
								</td>
								<td align="center">
									<s:property value="FFilePath" />
								</td>
								<td align="center">
									<input type="checkbox" name="deletelist" value="${FModuleId }" />
								</td>
							</tr>
						</s:iterator>
						<tr>
							<td colspan="2" align="center">
								<center>
									<a
										href='<s:url action="ModuleAction!configrolemodulelist.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
									<a
										href='<s:url action="ModuleAction!configrolemodulelist.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
									<a
										href='<s:url action="ModuleAction!configrolemodulelist.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
									<a
										href='<s:url action="ModuleAction!configrolemodulelist.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
									第
									<s:property value="p" />
									页/共
									<s:property value="lastPage" />
									页

								</center>
							</td>
							<td colspan="2" align="center">
								<input type="button" value="全选" onclick="selectAll()" />
								<input type="button" value="反选" onclick="unSelectAll()" />
							</td>
						</tr>
					</table>
					<table>
						<tr>
							<td>
								<s:select name="roleid" list="rolelist" listKey="FRoleId"
									listValue="FRoleName" label="角色"></s:select>
							</td>
							<td>
								<s:submit value="确定" />
							</td>
						</tr>
					</table>
				</s:form>
				</fieldset>
		</center>
	</body>
</html>
