<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>    
<title>Introduction</title>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
	
    <style type="text/css">
    </style>
</head>
<body>
<br><br><br><br>
		<br>
		<center>
			<table border="1">
				<tr>
					<td>
						基本使用说明：
						<br>
						1.先进行模块配置，即整个系统都有哪些子系统。
						<br>
						2.再进行功能添加，指定功能是属于哪个模块等功能属性。
						<br>
						3.进行角色添加，加入可以存在的角色。
						<br>
						4.进行角色功能配置。
						<br>
						5.进行角色模块配置。
						<br>
						6.进行用户录入。
						<br>
						7.进行用户角色的分配。
						<br>
                        <br>
                        <br>
                        注意：<br>
						1. 删除用户时，删除用户功能表中的相关内容
						<br>
						2. 删除用户时，删除用户模块表中的相关内容
						<br>
						3. 删除模块时，删除用户模块表中的相关内容
						<br>
						4. 删除模块时，删除功能表中的相关内容
						<br>
						5. 删除模块时，删除角色模块表中的相关内容
						<br>
						6. 删除模块时，删除角色功能表中的相关内容
						<br>
						7. 删除模块时，删除功能表中相关的内容，同时删除用户功能表中相就的内容
						<br>
						8. 删除功能时，删除用户功能表中的相关内容
						<br>
						9. 删除功能时，删除角色功能表中的相关内容
						<br>
						10. 删除角色时，删除用户角色表中的相关内容
						<br>
						11. 删除角色时，删除角色模块表中的相关内容
						<br>
						12. 删除角色时，删除角色功能表中的相关内容
						<br>
						13. 配置角色模块时，更新相应的用户模块表
						<br>
						14. 配置角色功能时，更新相应的用户功能
						<br>
						15. 删除角色功能时,删除拥有此角色的用户功能表中相关条目
						<br>
						16. 删除角色模块时,删除拥有此角色的用户模块表中的相关条目
						<br>
						17. 配置用户角色时，更新用户功能，用户模块
						<br>
						18. 修改功能的时候，相应的用户功能表也会改变
						<br>
						19. 修改模块的时候，相应的用户模块表也会改变
						<br>
						20. 删除用户模块时，删除用户在该模块下所拥有的功能（删除用户功能表中的内容）
						<br>
						
						
						21. 删除子系统时，删除用户功能表，角色功能表中相关的内容
						<br>
						22. 删除角色时，删除用户功能表，用户模块表
					</td>
				</tr>
			</table>
		</center>
	</body>
</html>