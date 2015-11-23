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
<link rel="stylesheet" type="text/css" href="<%=basePath %>ext/resources/css/ext-all.css" />
<link rel="stylesheet"  href="<%=basePath %>ext/resources/css/ext-patch.css"  type="text/css"  />
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=basePath %>ext/ext-all.js"></script>
<script type="text/javascript">
 function openWindow(url){
  var window=new Ext.Window({
  	title:"论文详情",
  	frame:true,
  	width:750,
  	height:400,
  	autoScroll:true,
  	minimizable:true,
  	maximizable:true,
  	resizable:true,
  	autoLoad:url
  });
  window.show();
 }
</script>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="75"/>
   <table width="80%">
   	<tr>
	  	<td scope="col"></td>
	    <td scope="col" align="right"><strong><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!TutorReturnThesisStatus.action?ThesisType=${ThesisType }"><font color="red">查看反馈论文状态</font></a></strong>
	    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/book.png" height="20"/>
	    </td>
	  </tr>
   </table>
   <fieldset>
       <legend><font size="2">提交情况</font></legend>
         <form action="yjssxTutor/TutorReceiveThesis!submitInfomationSearch.action" method="post">
           <input type="hidden" value="${ThesisType }" name="ThesisType" />
	       <table width="100%">
	          <tr>
	            <td><div align="right">年级：</div></td>
				<td><input type="text" name="studentGrade"/></td>
				<td align="right">提交情况：</td>
	          	<td align="left">
					<select name="IsSubmit">
						<option value="">--请选择--</option>
					 	<option value="Y">已提交论文</option>
						<option value="N">未提交论文</option>
					</select>
			    </td>
			    <td width="41%" align="left">
					<input type="submit" value="点击搜索"/>
			    </td>
	          </tr>
	       </table>
	    </form>
   </fieldset>
   
      <fieldset>
       <legend><font size="2">反馈情况</font></legend>
         <form action="yjssxTutor/TutorReceiveThesis!ReturnInfomationSearch.action" method="post">
           <input type="hidden" value="${ThesisType }" name="ThesisType" />
	       <table width="100%">
	          <tr>
	            <td><div align="right">年级：</div></td>
				<td><input type="text" name="studentGrade"/></td>
				<td align="right">反馈情况：</td>
	          	<td align="left">
					<select name="isReturned">
						<option value="">--请选择--</option>
					 	<option value="Y">已反馈论文</option>
						<option value="N">未反馈论文</option>
					</select>
			    </td>
			    <td width="41%" align="left">
					<input type="submit" value="点击搜索"/>
			    </td>
	          </tr>
	       </table>
	    </form>
   </fieldset>
   
	<fieldset>
	       <legend><font size="2">提交状态</font></legend>
	         <form action="yjssxTutor/TutorReceiveThesis!SubmitThesisSearchByCondition.action" method="post">
		       <input type="hidden" value="${ThesisType }" name="ThesisType" />
		       <table width="100%">
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
   <table width="100%" border="1" id="mytable" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
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
	    <th scope="col"><div align="center">论文名称</div></th>
	    <th scope="col"><div align="center">论文状态</div></th>
	    <th scope="col"><div align="center">论文反馈</div></th>
	  </tr>
	  <s:if test="thesisList.size==0">
			<tr>
				<td colspan="10" align="left">对不起暂无数据！！！</td>
			</tr>
		</s:if>
	  <s:else>
	   <s:iterator value="thesisList" status="status">
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
		    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		      <a href="#" onclick="openWindow('yjssxTutor/TutorReceiveThesis!showDetailThesis.action?ThesisType=${ThesisType }&&DetailId=${FNumber }&&Ret=N')">${FStatus }</a></div></td>
		    <td><div align="center">
		    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		      <a href="#" onclick="openWindow('yjssxTutor/TutorReceiveThesis!showDetailThesis.action?ThesisType=${ThesisType }&&stuId=${tabPostgraduate.tabStudents.FStudentNumber }&&DetailId=${FNumber }&&Ret=Y')">回复</a></div></td> 
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
