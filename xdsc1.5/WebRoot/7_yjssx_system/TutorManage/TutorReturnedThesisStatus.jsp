<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>7_yjssx_system/dialog.css" rel="stylesheet" type="text/css"></link>
<script language="javascript" src="<%=basePath %>7_yjssx_system/jquery-latest.pack.js"></script>
<script language="javascript" src="<%=basePath %>7_yjssx_system/dialog.js"></script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="75"/>
   <table width="80%">
   	<tr>
	  	<td scope="col"></td>
	    <td scope="col" align="center"><strong>查看反馈状态</strong>
	    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/book.png" height="20"/>
	    </td>
	  </tr>
   </table>
   
	<fieldset>
	       <legend><font size="3">反馈状态</font></legend>
	         <form action="yjssxTutor/TutorReceiveThesis!ReturnedThesisStatusSearchByCondition.action" method="post">
		       <input type="hidden" value="${ThesisType }" name="ThesisType" />
		       <table width="100%" height="70">
		                <tr>
							<td><div align="right">年级：</div></td>
						    <td><input type="text" name="studentGrade"/></td>
						    <td><div align="right">姓名：</div></td>
						    <td><input type="text" name="studentName"/></td>
							<td><div align="right">审核情况：</div></td>
							<td>
								<select name="ThesisStatus">
									<option value="">--请选择--</option>
								 	<option value="未审核">未审核</option>
									<option value="审核未通过">审核未通过</option>
									<option value="审核已通过">审核已通过</option>
								</select>				  
							</td>
							<td><input type="submit" value="点击搜索" /></td>
						</tr>             
		          </table>
		    </form>
	  </fieldset>
   <table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
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
	    <th scope="col"><div align="center">名称</div></th>
	    <th scope="col"><div align="center">状态</div></th>
	    <th scope="col"><div align="center">原因</div></th>
	  </tr>
	  <s:if test="returnedThesisList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
	   <s:iterator value="returnedThesisList" status="status">
		  <tr>
		    <td align="center" height="24"><s:property value="#status.count" /></td>
		      <td align="center">${tabPostgraduate.tabStudents.FStudentNumber }</td>
		      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentName }</td>
		      <td align="center">${tabPostgraduate.tabStudents.FStudentSex }</td>
		      <td align="center">${tabPostgraduate.tabStudents.FStudentNativeplace }</td>
		      <td align="center">${tabPostgraduate.tabStudents.FStudentAddress }</td>
		      <td align="center">${tabPostgraduate.FStudentExSchool}</td>	 
		      <td align="center">${tabPostgraduate.tabStudents.tabClasses.FClassName }</td>     
		      <td align="center">${tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum }</td>
		      <td align="center">${tabPostgraduate.tabStudents.FStudentEmail }</td>
		      <td align="center">${tabPostgraduate.tabStudents.FStudentTel }</td>
		    <td><div align="center"><s:property value="FThesisName"/></div></td>
		    <td><div align="center">
		    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>${FStatus }</div></td>
		    <td><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		     <font color="#ff0000"><a class="LINK21" href="#" onclick='dialog(&quot;具体原因&quot;,&quot;url:get?<%=basePath %>yjssxTutor/TutorReceiveThesis!ReturnThesisStatusReason.action?returnThesisId=${FNumber }&quot;,&quot;720px&quot;,&quot;auto&quot;,&quot;id&quot;); '>具体原因</a></font></td>
		  </tr>
		</s:iterator>
	  </s:else>
  </table>
  <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!submitThesis.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!submitThesis.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!submitThesis.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!submitThesis.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
  
</div> 
</body>
</html>
