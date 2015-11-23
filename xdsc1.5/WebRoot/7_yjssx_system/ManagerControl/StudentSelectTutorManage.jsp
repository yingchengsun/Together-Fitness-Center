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
	<img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">研究生导师选择</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" border="0">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>研究生选择情况查询：</strong></div></td>
   	  	<td><div align="center"><strong>导师确定情况查询：</strong></div></td>
   	  </tr>
      <tr>
        <td><div align="center">
		<form action="yjssxAdmin/AdminTutorSelectManage!StudentSelectInfo.action" method="post">
	  	 <select name="selectInfo" >
	  	 	  <option >--------请选择--------</option>
		      <option value="Y">已选择导师的研究生</option>
		      <option value="N">未选择导师的研究生</option>
	      </select>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
		<td><div align="center">
		<form action="yjssxAdmin/AdminTutorSelectManage!TutorConfirmInfoSearch.action" method="post">
	  	  <select name="confirmInfo" >
		    <option >--------请选择--------</option>
		    <option value="Y">已确定导师的研究生</option>
			<option value="N">未确定导师的研究生</option>
          </select>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
     </tr>
   </table>
   <table width="100%" border="0">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>按报考志愿查询：</strong></div></td>
   	  </tr>
      <tr>
        <td width="100%"><div align="center">
			<form action="yjssxAdmin/AdminTutorSelectManage!SelectInfoWishSearch.action" method="post">
				<input type="radio" name="wish" value="first"/>第一志愿
				<input type="radio" name="wish" value="second"/>第二志愿
				<input type="radio" name="wish" value="third"/>第三志愿
				 导师姓名： 
				 <select name="tutorName">
			  	      <option value="">----请选择-----</option>
			  	      <s:iterator value="teacherList">
				      <option value="${FTeacherName }">${FTeacherName }</option>
		               </s:iterator>
	               </select>
				<input  type="submit" value="搜索"/>
			</form>
		</div></td>
     </tr>
   </table>
   <table width="100%" border="0">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>按导师姓名查询：</strong></div></td>
   	  </tr>
      <tr>
        <td><div align="center">
		<form action="yjssxAdmin/AdminTutorSelectManage!tutorSelectSearchByTutorName.action" method="post">
	  	    输入导师姓名：
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
</div>
</body>
</html>
