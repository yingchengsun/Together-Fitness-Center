<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>7_yjssx_system/dialog.css" rel="stylesheet" type="text/css"></link>
	<script language="javascript" src="<%=basePath %>7_yjssx_system/jquery-latest.pack.js"></script>
	<script language="javascript" src="<%=basePath %>7_yjssx_system/dialog.js"></script>
    <title>My JSP 'noNoticeRightNow.jsp' starting page</title>

  </head>
  
  <body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  	<div align="center">
	    <table width="80%" style="margin-top: 40px">
	   		<tr>
		  		<td scope="col"></td>
		   	    <td scope="col" align="right"><strong><a href="<%=basePath %>yjssxStudent/PostgraduateReceiveThesis!findReturnThesis.action?ThesisType=${ThesisType }"><font color="red">查看反馈的论文</font></a></strong>
		  	    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/book.png" height="20"/>
		        </td>
		  	</tr>
	   </table>
	    <s:if test="detailThesis.FStatus.equals('未审核')">
			<font size="3">${detailThesis.FStatus }，请耐心等候...</font><p>
			<table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
			  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
			    
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
			    <th scope="col"><div align="center">详情</div></th>
			  </tr>
			  <tr>
			    
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentNumber }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${detailThesis.tabPostgraduate.tabStudents.FStudentName }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentSex }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentNativeplace }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentAddress }</td>
			      <td align="center">${detailThesis.tabPostgraduate.FStudentExSchool}</td>	 
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.tabClasses.FClassName }</td>     
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentEmail }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentTel }</td>
			      <td><div align="center"><s:property value="detailThesis.FThesisName"/></div></td>
			      <td><div align="center">${detailThesis.FStatus }</div></td>
			      <td align="center"><font size="3"><a href="<%=basePath %>yjssxCommon/CommonOperation!findSubmitThesisDetail.action?SubmitThesisId=${detailThesis.FNumber }">查看详情</a></font></td>
			  </tr>
  		</table>
	    		
	    </s:if>
	    <s:elseif test="detailThesis.FStatus.equals('审核已通过')">
	    	<font size="3">恭喜您，${detailThesis.FStatus }</font><p>
	    	<table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
			  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
			    
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
			    <th scope="col"><div align="center">详情</div></th>
			  </tr>
			  <tr>
			    
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentNumber }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${detailThesis.tabPostgraduate.tabStudents.FStudentName }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentSex }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentNativeplace }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentAddress }</td>
			      <td align="center">${detailThesis.tabPostgraduate.FStudentExSchool}</td>	 
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.tabClasses.FClassName }</td>     
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentEmail }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentTel }</td>
			      <td><div align="center"><s:property value="detailThesis.FThesisName"/></div></td>
			      <td><div align="center">${detailThesis.FStatus }</div></td>
			      <td align="center"><font size="3"><a href="<%=basePath %>yjssxCommon/CommonOperation!findSubmitThesisDetail.action?SubmitThesisId=${detailThesis.FNumber }">查看详情</a></font></td>
			  </tr>
  		</table>
	    </s:elseif>
	    <s:else>
	    	<font size="4">${detailThesis.FStatus },敬请查看通知</font><p>
	    	<table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
			  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
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
			    <th scope="col"><div align="center">详情</div></th>
			    <th scope="col"><div align="center">具体原因</div></th>
			    <th scope="col"><div align="center">点击修改</div></th>
			  </tr>
			  <tr>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentNumber }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${detailThesis.tabPostgraduate.tabStudents.FStudentName }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentSex }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentNativeplace }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentAddress }</td>
			      <td align="center">${detailThesis.tabPostgraduate.FStudentExSchool}</td>	 
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.tabClasses.FClassName }</td>     
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.tabClasses.tabGrade.FGradeNum }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentEmail }</td>
			      <td align="center">${detailThesis.tabPostgraduate.tabStudents.FStudentTel }</td>
			      <td><div align="center"><s:property value="detailThesis.FThesisName"/></div></td>
			      <td><div align="center">${detailThesis.FStatus }</div></td>
			      <td align="center"><font size="3"><a href="<%=basePath %>yjssxCommon/CommonOperation!findSubmitThesisDetail.action?SubmitThesisId=${detailThesis.FNumber }">查看详情</a></font></td>
			      <td><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
	     <font color="#ff0000"><a class="LINK21" href="#" onclick='dialog(&quot;具体原因&quot;,&quot;url:get?<%=basePath %>yjssxTutor/TutorReceiveThesis!SubmitThesisStatusReason.action?submitThsisId=${detailThesis.FNumber }&quot;,&quot;720px&quot;,&quot;auto&quot;,&quot;id&quot;); '>具体原因</a></font></td>
			  	  <td  align="center"><font size="4"><a href="<%=basePath %>/yjssxStudent/PostgraduateSubmitThesis!preUpdateThesis.action?ThesisType=${ThesisType }">点击修改</a></font></td>
			  </tr>
  		</table>
	    </s:else>
  </div>
  </body>
</html>
