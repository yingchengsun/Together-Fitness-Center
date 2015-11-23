<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 			+ request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
	<title>jQuery treeView</title>
	
	<link rel="stylesheet" href="<%=basePath %>/11_BackGroundSystem/jquery.treeview.css" />
    <link rel="stylesheet" href="<%=basePath %>/11_BackGroundSystem/red-treeview.css" />
	<link rel="stylesheet" href="<%=basePath %>/11_BackGroundSystem/screen.css" />
	<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath %>/11_BackGroundSystem/jquery.js" type="text/javascript"></script>
	<script src="<%=basePath %>/11_BackGroundSystem/jquery.cookie.js" type="text/javascript"></script>
	<script src="<%=basePath %>/11_BackGroundSystem/jquery.treeview.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#browser").treeview({
			toggle: function() {
				console.log("%s was toggled.", $(this).find(">span").text());
			}
		});
	});
	function selectAll(){
    		 var objs = document.getElementsByName("chooselist");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll(){
    		
    		var objs = document.getElementsByName("chooselist");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
        function selectAll2(){
    		 var objs = document.getElementsByName("chooselist2");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type.toLowerCase() == "checkbox" )            
                    objs[i].checked = true;
    		 }
    		 
    	}
    	
    	function unSelectAll2(){
    		
    		var objs = document.getElementsByName("chooselist2");
    		 for(var i=0;i<objs.length;i++){
    		 	 if(objs[i].type .toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}
	</script>
	<style type="text/css">
	body{
		margin-left:200px;
		
		}
	</style>
	</head>
	<body>
	<br /><br /> 
	<fieldset style="">
	<legend>
	   <font size="2">用户权限如下：</font>
	</legend>
	<font size="2">账号为：<%=session.getAttribute("FUserNumber") %>&nbsp;的用户所拥有的权限如下 ：</font>
	<br />
    <div id="main">
			<s:form action="UserFunctionAction!UserFunctionConfig2.action" method="post" theme="simple">
				<ul id="browser" class="filetree treeview-famfamfam">
					<s:iterator value="roleuserlist" status="r">
						<li class="closed">
							<span class="folder">${mhqxTabRole.FRoleName }</span>
							<a href='<s:url action="UserRoleAction!deleteUserRoleRelation2"><s:param name="id" value="FId"></s:param></s:url>'>&nbsp;删除用户此角色</a>
							<ul>
								<s:iterator value="ownfunctionlist[#r.index]" status="of">
									<li>
										<span class="file">${FFunctionId }${FFunctionName }<input
												type="checkbox" name="chooselist" value="${FFunctionId }"
												checked="checked" />
										</span>
									</li>
								</s:iterator>
								<s:iterator value="functionlist[#r.index]" status="f">
									<li>
										<span class="file">${FFunctionId }${FFunctionName }<input
												type="checkbox" name="chooselist" value="${FFunctionId }" />
										</span>
									</li>
								</s:iterator>
							</ul>
						</li>
					</s:iterator>
				</ul>
				<input type="button" value="全选" onclick="selectAll()" />
				<input type="button" value="反选" onclick="unSelectAll()" />

		</div>
		</fieldset>
		<fieldset style="">
	    <legend>
	        <font size="2">用户子系统权限如下：</font>
	    </legend>
		<font size="2">账号为：<%=session.getAttribute("FUserNumber") %>&nbsp;的用户所能访问子系统情况如下 ：</font>
		 <table>
		     <s:iterator value="usermodulelist">
		       <tr><td>${mhqxTabModule.FModuleName }</td><td><input type="checkbox" name="chooselist2" value="${mhqxTabModule.FModuleId }" checked="checked"/></td></tr>
		     </s:iterator>
		     <s:iterator value="unownmodulelist">
		       <tr><td>${FModuleName }</td><td><input type="checkbox" name="chooselist2" value="${FModuleId }" /></td></tr>
		     </s:iterator>
		     
		 </table>
		 <input type="button" value="全选" onclick="selectAll2()" />
		 <input type="button" value="反选" onclick="unSelectAll2()" />
		 <s:submit value="确认"/>
		</s:form>
		</fieldset>
   
   
</body>
</html>