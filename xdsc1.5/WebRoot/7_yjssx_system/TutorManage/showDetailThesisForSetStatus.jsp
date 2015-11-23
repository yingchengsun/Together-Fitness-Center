<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()

+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

</head>
  
<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  <div align="center">
 
  <table width="100%" border="0">
      <tr>
        <td width="100%"><div align="center"><s:property 

value="detailThesis.FThesisName"/></div></td>
      </tr>
   </table>
   <fieldset>
     <legend><font size="3">详情</font></legend>
	    <table width="100%" height="97" border="0" style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif">
	      <tr style="background-color:#CCCCCC">
	        <td align="right"><fmt:formatDate value="${detailThesis.FDate}" type="date" dateStyle="medium"/></td>
	      </tr>
	      <tr>
	        <td><s:property value="detailThesis.FComment" escape="false"/></td>
	      </tr>
	      <tr>
	        <td><s:property value="detailThesis.FStatus"/></td>
	      </tr>
	      <tr>
	        <td align="center"><a href="<%=basePath %>files/7yjssx_system/infoFile/Thesis/${detailThesis.FThesisStorePath }">论文下载</a></td>
	    </tr>
	    </table>
    </fieldset>
    <p>
    <fieldset style="margin-top: 40px">
     <legend><font size="3">设置审核状态</font></legend>
	      <form action="yjssxTutor/TutorReceiveThesis!SetSubmitStatus.action" method="post">
	      <input type="hidden" value="${ThesisType }" name="ThesisType" />
           <input type="hidden" name="SubmitThesisId" value="${detailThesis.FNumber }"/>
           <input type="hidden" name="stuId" value="${detailThesis.tabPostgraduate.FStudentNumber }"/>
	       <table width="100%" height="165"  border="1" style="border-collapse:collapse" bordercolor="#999999">
	                <tr>
	                    <td height="34" align="right">状态:</td>
						<td align="left">
							<select name="Status">
								<option value="">--请选择--</option>
							 	<option value="Y">审核通过</option>
								<option value="N">审核未通过</option>
							</select>
					    </td>
					   <td height="29" align="right">原因:</td>
					   <td align="left"><input type="text" name="ReasonTitle"/></td>
					</tr>    
					<tr>
						<td height="65" align="right">备注:</td>
						<td align="left" colspan="3"><textarea rows="3" cols="80%" name="ReasonContent"></textarea></td>
					</tr> 
					<tr>
						<td align="right"><input type="submit" value="提交"/></td>
						<td align="left" colspan="3"></td>
					</tr>            
            </table>
		  </form>
    </fieldset>
    
  </div>
</body>
</html>
