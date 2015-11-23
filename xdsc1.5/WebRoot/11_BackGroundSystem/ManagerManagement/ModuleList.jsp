<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>子系统模块配置</title>
    <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
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
    </script>
  </head>
  <body>
  <center>
  <br>
  
  <fieldset style="border-color: #ECF5FF">
      <legend>
        子系统管理
      </legend>
  <s:form name="deleteform" action="ModuleAction!multipledelete.action" method="post">
      <table border="1" id="mytable" style="border-collapse:collapse">
        <tr style="background-image: url('<%=basePath %>images/titlebg.gif')">
          <td align="center" width="100">子系统ID</td>
          <td align="center" width="100">子系统名</td>
          <td align="center" width="100">子系统URL</td>
          <td align="center" width="100">修改</td>
          <td align="center" width="100">删除</td>
          <td align="center" width="100">多选删除</td>
        </tr>
        <s:iterator value="modulelist">
        <tr>
          <td align="center"><s:property value="FModuleId"/></td>
          <td align="center"><s:property value="FModuleName"/></td>
          <td align="center"><s:property value="FFilePath"/></td>
          <td align="center"><a href='<s:url action="ModuleAction!modifymodule"><s:param name="id" value="FModuleId"></s:param></s:url>'>修改</a></td>
          <td align="center"><a href='<s:url action="ModuleAction!deletemodule"><s:param name="id" value="FModuleId"></s:param></s:url>'>删除</a></td>          
          <td align="center"><input type="checkbox" name="deletelist" value="${FModuleId }"/></td>
        </tr>
        </s:iterator>
        <tr>
          <td colspan="4" align="center">
              <center>
                <a href='<s:url action="ModuleAction!showpagelist.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
                <a href='<s:url action="ModuleAction!showpagelist.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                <a href='<s:url action="ModuleAction!showpagelist.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                <a href='<s:url action="ModuleAction!showpagelist.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                    第<s:property value="p"/>页/共<s:property value="lastPage"/>页
              </center>
          </td >
          <td colspan="4" align="center">
              <input type="button" value="全选" onclick="selectAll()" />
              <input type="button" value="反选" onclick="unSelectAll()" />
              <input type="submit" value="删除" />          
          </td>
        </tr>
      </table>
    </s:form> 
    </fieldset>
    <br>
    
    <fieldset style="border-color: #ECF5FF">
      <legend>
        添加子系统
      </legend>
    <s:form name="addform" action="ModuleAction!addmodule" method="post">
      <table border="1" style="border-collapse:collapse">
         <tr><s:textfield name="module.FModuleName" label="子系统名称" required="true"/></tr>
         <tr><s:textfield name="module.FFilePath" label="URL"/></tr>
         <tr><s:select name="module.FPriority" list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10','11':'11'}" label="优先级" required="true"></s:select></tr>
         <tr><s:submit value="添加"/></tr>
      </table>
    </s:form>
    </fieldset>
  </center>
  </body>
</html>
