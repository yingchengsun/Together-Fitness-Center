<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>          7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">高级搜索</div></td>
      </tr>
  </table>
   <fieldset  style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/login_bg.gif')">
       <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="50"/></legend>
       <form action="yjssxAdmin/AdminReleaseNotice!adminNoticeToSbSearch.action" method="post">
         <input type="hidden" name="type" value="企业"/>
         <table width="100%">
                <tr>
					<td width="5%"><div align="right">名称：</div></td>
				    <td width="11%">
						<select name="companyName">
		  	      				<option value="">----请选择-----</option>
		  	     				 <s:iterator value="companyList">
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
  <form action="yjssxAdmin/AdminReleaseNotice!noticeTo.action" method="post">
     <input type="hidden" name="type" value="${type }"/>
	 <table width="100%" border="1" style="border-collapse:collapse">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
	      <th><div align="center"><strong>企业名称</strong></div></th>
	      <th><div align="center"><strong>地址</strong></div></th>
	      <th><div align="center"><strong>注册时间</strong></div></th>
	      <th><div align="center"><strong>邮箱</strong></div></th>
	      <th><div align="center"><strong>电话</strong></div></th>
	      <th><div align="center"><strong>联系人</strong></div></th>
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
	      <td align="center"><input type="checkbox" name="noticeId" value="${FCompanyNumber }"/></td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FCompanyName }</td>
	      <td align="center">${FAddress }</td>
	      <td align="center"><fmt:formatDate value="${FRegisterTime}" type="date" dateStyle="medium"/></td>
	      <td align="center">${FEmailAddress }</td>
	      <td align="center">${FTelephone }</td>
	      <td align="center">${FConnectPerson }</td>
	      <td align="center"><div align="center">
	      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	      <a href="<%=basePath %>yjssxCommon/CommonOperation!findCompanyInfo.action?comId=${FCompanyNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
	    </tr>
	   </s:iterator>
	   <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
	      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
	      <td ><div align="center"><input type="submit" value=发送通知" /></div></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	    </tr>
	    </s:else>
	  </table>	  
   </form>
</div>
</body>
</html>
