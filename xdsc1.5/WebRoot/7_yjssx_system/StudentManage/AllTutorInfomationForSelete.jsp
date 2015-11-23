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
<link href="<%=basePath %>7_yjssx_system/dialog.css" rel="stylesheet" type="text/css"></link>
<script language="javascript" src="<%=basePath %>7_yjssx_system/jquery-latest.pack.js"></script>
<script language="javascript" src="<%=basePath %>7_yjssx_system/dialog.js"></script>
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  <div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/info3.png" height="80"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">导师信息表</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" id="mytable" border="1" style="border-collapse:collapse">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	  	<th>编号</th>
	    <th scope="col"><div align="center">姓名</div></th>
	    <th scope="col"><div align="center">性别</div></th>
	    <th scope="col"><div align="center">职位</div></th>
	    <th scope="col"><div align="center">职称</div></th>
	    <th scope="col"><div align="center">研究方向</div></th>
	    <th scope="col"><div align="center">办公地址</div></th>
	    <th scope="col"><div align="center">办公电话</div></th>
	    <th scope="col"><div align="center">导师详情</div></th>
	  </tr>
	  <s:if test="allTutorInfo.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	   <s:iterator value="allTutorInfo" status="status">
		  <tr>
		  	<td align="center">
	          <s:property value="#status.count" />
			</td>
		    <td><div align="center"><s:property value="FTeacherName"/></td>
		    <td><div align="center"><s:property value="FTeacherSex"/></div></td>
		    <td><div align="center"><s:property value="FTeacherPosition"/></div></td>
		    <td><div align="center"><s:property value="FTeacherZhiCheng"/></div></td>
		    <td><div align="center"><s:property value="FTeacherResearch" escape="false"/></div></td>
		    <td><div align="center"><s:property value="FTeacherWorkPlace"/></div></td>
		    <td><div align="center"><s:property value="FTeacherPhone"/></div></td>
		     <td ><div align="center">
		     <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		     <font color="#ff0000"><a class="LINK21" href="#" onclick='dialog(&quot;导师信息&quot;,&quot;url:get?<%=basePath %>yjssxStudent/PostgraduateAllTutorInfoForSelect!findTutorDetailInfo.action?DetailNum=<s:property value="FTeacherNumber"/>&quot;,&quot;720px&quot;,&quot;auto&quot;,&quot;id&quot;); '>查看导师信息</a></font></div></td>
		  </tr>
		</s:iterator>
	   </s:else>
  </table>
</div> 
</body>
</html>
