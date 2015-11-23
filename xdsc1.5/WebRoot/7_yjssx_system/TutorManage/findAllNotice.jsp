<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/yingpin.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">通知</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
  <form action="yjssxTutor/TutorReceiveNotice!deleteNotice.action" method="post">
   <table width="100%" id="mytable" border="1" style="border-collapse:collapse" bordercolor="#999999">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	  	<th>编号</th>
	    <th scope="col"><div align="center">选择</div></th>
	    <th scope="col"><div align="center">名称</div></th>
	    <th scope="col"><div align="center">发布日期</div></th>
	    <th scope="col"><div align="center">查看</div></th>
	  </tr>
	  <s:if test="noticeList.size==0">
			<tr>
				<td  colspan="5" align="left">对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	   <s:iterator value="noticeList" status="status">
		  <tr>
		    <td align="center"><s:property value="#status.count" /></td>
		    <td><input type="checkbox" name="noticeId" value="${FInfoId }"/></td>
		    <td><div align="center"><s:property value="FInfoTitle"/></td>
		    <td><div align="center"><fmt:formatDate value="${FInfoStartTime}" type="date" dateStyle="medium"/></div></td>
		    <td><div align="center">
		    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		    <a href="<%=basePath %>yjssxTutor/TutorReceiveNotice!showNoticeDetail.action?detailId=<s:property value="FInfoId"/>">查看</a></div></td>
		  </tr>
		</s:iterator>
	 <tr>
	      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
	      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
	      <td ><div align="center"><input type="submit" value="删除" /></div></td>
	      <td></td>
	      <td></td>
	    </tr>
	  </s:else>
  </table>
 </form>
 <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveNotice!findAllNotice.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveNotice!findAllNotice.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveNotice!findAllNotice.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveNotice!findAllNotice.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
 
</div> 
</body>
</html>
