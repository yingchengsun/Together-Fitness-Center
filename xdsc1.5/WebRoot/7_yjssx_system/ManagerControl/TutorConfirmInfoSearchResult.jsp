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

<body background="../SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">研究生导师选择</div></td>
      </tr>
   </table>
   <hr align="center" width="100%" size="2" color="#990033"/>
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
   <table width="100%"id="mytable" border="1" style="border-collapse:collapse" bordercolor="#999999"
	background="../SubSystemImage/bg.gif">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>学号</strong></div></th>
	      <th><div align="center"><strong>姓名</strong></div></th>
	      <th><div align="center"><strong>性别</strong></div></th>
	      <th><div align="center"><strong>籍贯</strong></div></th>
	      <th><div align="center"><strong>地址</strong></div></th>
	      <th><div align="center"><strong>本科学校</strong></div></th>
	      <th><div align="center"><strong>班级</strong></div></th>
          <th><div align="center"><strong>年级</strong></div></th>
	      <th><div align="center"><strong>邮箱</strong></div></th>
	      <th><div align="center"><strong>电话</strong></div></th>
	      <th><div align="center"><strong>导师姓名</strong></div></th>
	      <th><div align="center"><strong>志愿详情</strong></div></th>
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
	      <td align="center">${tabStudents.FStudentNumber }</td>
	      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentName }</td>
	      <td align="center">${tabStudents.FStudentSex }</td>
	      <td align="center">${tabStudents.FStudentNativeplace }</td>
	      <td align="center">${tabStudents.FStudentAddress }</td>
	      <td align="center">${FStudentExSchool}</td>	 
	      <td align="center">${tabStudents.tabClasses.FClassName }</td>     
	      <td align="center">${tabStudents.tabClasses.tabGrade.FGradeNum }</td>
	      <td align="center">${tabStudents.FStudentEmail }</td>
	      <td align="center">${tabStudents.FStudentTel }</td>
	     <s:if test="tabTeachers==null">
	      <td><div align="center">导师未确定</div></td>
	     </s:if>
	     <s:else>
	      <td><div align="center">${tabTeachers.FTeacherName }</div></td>
	     </s:else>
	     <s:if test="yjssxTabTutorselects.size==0">
	     	<td><div align="center">尚未选择导师</div></td>
	     </s:if>
	     <s:else>
          <td align="center">
	         <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	         <a href="<%=basePath %>yjssxStudent/PostgraduateSelectTutor!StudentSelectTutorInfo.action?StudenNum=${FStudentNumber}" class="STYLE5">志愿详情</a>
         </td>   
	    </s:else>
	    </tr>
	   </s:iterator>
	   </s:else>
	  </table>	
	<table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!TutorConfirmInfoSearch.action?confirmInfo=${confirmInfo }&&p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!TutorConfirmInfoSearch.action?confirmInfo=${confirmInfo }&&p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!TutorConfirmInfoSearch.action?confirmInfo=${confirmInfo }&&p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!TutorConfirmInfoSearch.action?confirmInfo=${confirmInfo }&&p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
	  
</div>
</body>
</html>
