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
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
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

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
   <div align="center">
	<img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0072.gif" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">企业信息表</div></td>
      </tr>
   </table>
   <fieldset style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/login_bg.gif')">
       <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="50"/></legend>
       <form action="yjssxAdmin/AdminCompanyInfoManage!searchCompany.action" method="post">
         <input type="hidden" name="type" value="企业"/>
         <table width="100%">
                <tr>
					<td width="5%"><div align="right">名称：</div></td>
				    <td width="11%">
						<select name="companyName">
		  	      				<option value="">----请选择-----</option>
		  	     				 <s:iterator value="company">
			      				 <option value="${FCompanyName }">${FCompanyName }</option>
			    			     </s:iterator>
		      				</select>
				    </td>
					<td width="6%"><div align="right">地址：</div></td>
					<td width="17%"><input type="text" name="companyAddress"/></td>
					<td width="10%"><div align="right">邮箱：</div></td>
					<td width="17%"><input type="text" name="companyEmail"/></td>
				  <td width="5%"><div align="right">联系人：</div></td>
				  <td width="17%"><input type="text" name="ConnectPerson"/></td>
				</tr>           
        </table>
	    <table>
	   		<tr>
				<td><input type="submit" value="点击搜索" /></td>
			</tr>
	    </table>
	   </form>
   </fieldset>
   <hr align="center" width="100%"/>
  <form action="yjssxAdmin/AdminCompanyInfoManage!deleteCompany.action" method="post">
   <table width="100%" id="mytable" border="1" style="border-collapse:collapse">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	    <th>编号</th>
	  	<th scope="col"><div align="center">选择</div></th>
	    <th scope="col"><div align="center">名称</div></th>
	    <th scope="col"><div align="center">电话</div></th>
	    <th scope="col"><div align="center">邮箱</div></th>
	    <th scope="col"><div align="center">地址</div></th>
	    <th scope="col"><div align="center">联系人</div></th>
	    <th scope="col"><div align="center">详情</div></th>
	  </tr>
	  <s:if test="companyList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	  <s:else>
	   <s:iterator value="companyList" status="status">
		  <tr>
		    <td align="center" height="24"><s:property value="#status.count" /></td>
		  	<td><input type="checkbox" name="delId" value="${FCompanyNumber }"/></td>
		    <td><div align="center"><s:property value="FCompanyName"/></td>
		    <td><div align="center"><s:property value="FTelephone"/></div></td>
		    <td><div align="center"><s:property value="FEmailAddress"/></div></td>
		    <td><div align="center"><s:property value="FAddress"/></div></td>
		    <td><div align="center">联系人</div></td>
		    <td> <div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			<a href="<%=basePath %>yjssxCommon/CommonOperation!findCompanyInfo.action?comId=${FCompanyNumber}">查看详情</a></div></td>
		  </tr>
		</s:iterator>
		<tr style="background-color:#CCCCCC">
		      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
		      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
		      <td ><div align="center"><input type="submit" value="删除" /></div></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
		      <td></td>
	    </tr>
	   </s:else>
  </table>
 </form>
 <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminCompanyInfoManage!findAllCompany.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminCompanyInfoManage!findAllCompany.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminCompanyInfoManage!findAllCompany.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminCompanyInfoManage!findAllCompany.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
 
</div> 
</body>
</html>
