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

   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/thesis.png" height="70" />
   <table width="100%" border="0"  style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center"><strong>招聘信息</strong></div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%">
   	<tr>
	  	<td scope="col"></td>
	    <td scope="col" align="right"><strong><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!releaseInfo.action?type=${type }"><font color="red">发布${typeName }信息</font></a></strong>
	    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/book.png" height="20"/>
	    </td>
	  </tr>
   </table>
  <form action="<%=basePath %>yjssxCommon/CommonOperation!deleteInfo.action" >
   <table width="100%" border="1" id="mytable" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	    <th>编号</th>
	  	<th scope="col"><div align="center">选择</div></th>
	    <th scope="col"><div align="center">名称</div></th>
	    <th scope="col"><div align="center">发布日期</div></th>
	    <th scope="col"><div align="center">查看详情</div></th>
	    <th scope="col"><div align="center">是否发布</div></th>
	  </tr>
	  <s:if test="infoList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
		<s:else>
		   <s:iterator value="infoList" status="status">
			  <tr>
			    <td align="center" height="24"><s:property value="#status.count" /></td>
			  	<td><div align="center"><input type="checkbox" name="delInfoId" value="${FInfoId }"/></div></td>
			    <td>
			    	<div align="left"><s:property value="FInfoTitle"/></div>
			    </td>
			    <td><div align="center"><fmt:formatDate value="${FInfoStartTime}" type="date" dateStyle="medium"/></div></td>
			    <td><div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			    	<a href="<%=basePath %>yjssxCommon/CommonOperation!findInfoDetail.action?infoId=<s:property value="FInfoId"/>&&type=${type }">查看</a></div></td>
			    <td>
			    	<div align=center><a href="<%=basePath %>yjssxAdmin/AdminManageZhaoPinInfo!releaseInfo.action?infoId=<s:property value="FInfoId"/>&&type=${FBiaoZhi }"><s:property value="FBiaoZhi"/></a></div>
			    </td>
			  </tr>
			</s:iterator>
			  <tr style="background-color:#CCCCCC">
			      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
			      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
			      <td ><div align="center"><input type="submit" value="删除" /></div></td>
			      <td></td>
			      <td><br/></td>
			    </tr>
	    </s:else>
  </table>
 </form>
 <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
 
</div> 
</body>
</html>
