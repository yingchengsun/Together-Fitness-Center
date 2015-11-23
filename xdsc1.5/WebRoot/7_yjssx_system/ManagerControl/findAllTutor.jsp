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

<body >
<div align="center">
<img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0072.gif" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">导师信息表</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" border="0">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center">输入导师姓名：</div></td>
   	  </tr>
      <tr>
        <td width="100%"><div align="center">
		<form action="yjssxAdmin/AdminTutorInfoManage!searchTutor.action" method="post">
	  	    <select name="tutorName">
	  	      <option value="">----请选择-----</option>
	  	      <s:iterator value="teacherList">
		      <option value="${FTeacherName }">${FTeacherName }</option>
		      </s:iterator>
	      </select>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
     </tr>
   </table>
   <hr align="center" width="100%"/>
  <form action="yjssxAdmin/AdminTutorInfoManage!deleteTutor.action" method="post">
   <table width="100%" id="mytable" border="1" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	    <th>编号</th>
	  	<th scope="col"><div align="center">选择</div></th>
	    <th scope="col"><div align="center">姓名</div></th>
	    <th scope="col"><div align="center">性别</div></th>
	    <th scope="col"><div align="center">职位</div></th>
	    <th scope="col"><div align="center">职称</div></th>
	    <th scope="col"><div align="center">研究方向</div></th>
	    <th scope="col"><div align="center">办公地址</div></th>
	    <th scope="col"><div align="center">办公电话</div></th>
	    <th scope="col"><div align="center">导师详情</div></th>
	  </tr>
	  <s:if test="thesisList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	  <s:else>
	   <s:iterator value="tutorList" status="status">
		  <tr>
		    <td align="center" height="24"><s:property value="#status.count" /></td>
		  	<td><input type="checkbox" name="delId" value="${FTeacherNumber }"/></td>
		    <td><div align="center"><s:property value="FTeacherName"/></td>
		    <td><div align="center"><s:property value="FTeacherSex"/></div></td>
		    <td><div align="center"><s:property value="FTeacherPosition"/></div></td>
		    <td><div align="center"><s:property value="FTeacherZhiCheng"/></div></td>
		    <td><div align="center"><s:property value="FTeacherResearch"/></div></td>
		    <td><div align="center"><s:property value="FTeacherWorkPlace"/></div></td>
		    <td><div align="center"><s:property value="FTeacherPhone"/></div></td>
		    <td> <div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			<a href="<%=basePath %>yjssxCommon/CommonOperation!findTutorInfo.action?tutorId=${FTeacherNumber}">查看详情</a></div></td>
		  </tr>
		</s:iterator>
		<tr >
		      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
		      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
		      <td ><div align="center"><input type="submit" value="删除" /></div></td>
		      <td></td>
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
 <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!findAllTutor.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!findAllTutor.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!findAllTutor.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorInfoManage!findAllTutor.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
 
</div> 
</body>
</html>
