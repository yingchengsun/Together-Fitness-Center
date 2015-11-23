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

<body background="../SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0072.gif" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">请选择</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
  <form action="yjssxAdmin/AdminStudentInfoManage!confirmToAddCom.action" method="post">
	<table width="100%" border="1" style="border-collapse:collapse" >
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
	      <th><div align="center"><strong>企业名称</strong></div></th>
	      <th><div align="center"><strong>企业电话</strong></div></th>
	      <th><div align="center"><strong>查看详情</strong></div></th>
	    </tr>
	    <s:if test="company.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="company" status="status">
	    <tr>
	      <td align="center" height="24"><s:property value="#status.count" /></td>
	      <td><input type="checkbox" name="companyId" value="${FCompanyNumber }"/></td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FCompanyName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FTelephone }</td>
	      <td align="center"><div align="center">
	      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	      <a href="<%=basePath %>yjssxCommon/CommonOperation!findCompanyInfo.action?comId=${FCompanyNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	   </s:iterator>
	   </s:else>
	   <tr style="background-color:#CCCCCC">
	      <td height="15"></td>
	      <td ></td>
	      <td ></td>
	      <td></td>
	      <td></td>
	    </tr>
	</table>
	<p>	
	<table width="100%" border="1" style="border-collapse:collapse">
	     <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
	      <th><div align="center"><strong>研究生名称</strong></div></th>
	      <th><div align="center"><strong>研究生电话</strong></div></th>
	      <th><div align="center"><strong>查看详情</strong></div></th>
	    </tr>
	    <s:if test="student.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="student" status="status">
	    <tr>
	      <td align="center" height="24"><s:property value="#status.count" /></td>
	      <td><input type="checkbox" name="stuId" value="${FStudentNumber }"/></td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentName }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentTel }</td>
	      <td align="center"><div align="center"><a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${FStudentNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	   </s:iterator>
	   </s:else>
	    <tr style="background-color:#CCCCCC">
	      <td height="15"></td>
	      <td ></td>
	      <td ></td>
	      <td></td>
	      <td></td>
	    </tr>
	</table> 
	<p>
	<div align="center"><input type="submit" value="确认添加" />  
   </div>
   </form>
</div>
</body>
</html>
