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
<img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0072.gif" height="75" />
   <fieldset style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/login_bg.gif')">
       <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="50"/></legend>
         <form action="yjssxAdmin/AdminStudentInfoManage!studentSearch.action" method="post">
	       <table width="100%" height="97">
	                <tr>
						<td width="5%"><div align="right">姓名：</div></td>
					    <td width="17%"><input type="text" name="studentName"/></td>
						<td width="6%"><div align="right">性别：</div></td>
						<td width="11%">
							<select name="studentSex">
								<option value="">--请选择--</option>
							 	<option value="男">男</option>
								<option value="女">女</option>
							</select>
					    </td>
						<td width="9%"><div align="right">导师：</div></td>
						<td width="10%">
							<select name="tutorNumber">
								<option value="">--请选择--</option>
							 	<s:iterator value="teacherList">
		      						<option value="${FTeacherName }">${FTeacherName }</option>
		      					</s:iterator>
							</select>
					   </td>
						<td width="10%"><div align="right">企业：</div></td>
						<td width="10%" >
							<select name="companyNumber">
		  	      				<option value="">----请选择-----</option>
		  	     				 <s:iterator value="companyList">
			      				 <option value="${FCompanyName }">${FCompanyName }</option>
			    			     </s:iterator>
		      				</select>				  
		      			</td>
					</tr>
					<tr>
					   <td width="5%"><div align="right">班级号：</div></td>
					   <td width="17%"><input type="text" name="className"/></td>
						<td width="5%" height="49"><div align="right">年级号：</div></td>
					    <td width="17%"><input type="text" name="gradeName"/></td>
						<td width="6%"><div align="right">类别：</div></td>
						<td width="11%">
							<select name="studentType">
								<option value="">--请选择--</option>
							 	<option value="单证">单证</option>
								<option value="双证">双证</option>
							</select>				  
						</td>
						<td></td>
						<td><input type="submit" value="点击搜索" /></td>
					</tr>             
	          </table>
		  </form>
  </fieldset>
   <hr align="center" width="100%"/>
  <form action="yjssxAdmin/AdminStudentInfoManage!deleteStudent.action" method="post">
	 <table width="100%" id="mytable" border="1" style="border-collapse:collapse">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
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
	    </tr>
	    <s:if test="studentList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	    <s:iterator value="studentList" status="status">
	    <tr>
	     	  <td align="center" height="24"><s:property value="#status.count" /></td>
	          <td><input type="checkbox" name="delStuId" value="${FStudentNumber }"/></td>
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
	    </tr>
	   </s:iterator>
	   <tr style="background-color:#CCCCCC">
	      <td><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
	      <td><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
	      <td><div align="center"><input type="submit" value="删除" /></div></td>
	      <td></td>
	      <td></td>
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
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!showAllPostgraudte.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!showAllPostgraudte.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!showAllPostgraudte.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminStudentInfoManage!showAllPostgraudte.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
   
</div>
</body>
</html>
