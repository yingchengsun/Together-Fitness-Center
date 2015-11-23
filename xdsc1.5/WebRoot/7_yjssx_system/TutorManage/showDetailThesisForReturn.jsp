<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />

</head>
  
<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
  <div align="center">
 
  <table width="100%" border="0">
      <tr>
        <td width="100%"><div align="center"><s:property value="detailThesis.FThesisName"/></div></td>
      </tr>
   </table>
   <fieldset>
     <legend><font size="3">详情</font></legend>
	    <table width="100%" height="97" border="0" style="border-collapse:collapse" bordercolor="#999999"
			   background="../SubSystemImage/bg.gif">
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
    
    <s:if test="(isReturn==1)&&RetPassed">
	    <fieldset>
	     <legend><font size="3">已回复，已通过审核</font></legend>
	     	<table width="100%" height="97" border="0" style="border-collapse:collapse">
	      <tr style="background-color:#CCCCCC">
	        <td align="right"><fmt:formatDate value="${retThesis.FDate}" type="date" dateStyle="medium"/></td>
	      </tr>
	      <tr>
	        <td><s:property value="retThesis.FComment" escape="false"/></td>
	      </tr>
	      <tr>
	        <td align="center"><a href="<%=basePath %>files/7yjssx_system/infoFile/Thesis/${retThesis.FThesisStorePath }">论文下载</a></td>
	    </tr>
	    </table>
	    </fieldset>
   </s:if>
   <s:elseif test="(isReturn)==1&&!RetPassed">
   		<fieldset>
	     <legend><font size="3">已回复，未通过审核</font></legend>
	     	<table width="100%" height="97" border="0" style="border-collapse:collapse">
	      <tr style="background-color:#CCCCCC">
	        <td align="right"><fmt:formatDate value="${retThesis.FDate}" type="date" dateStyle="medium"/></td>
	      </tr>
	      <tr>
	        <td><s:property value="retThesis.FComment" escape="false"/></td>
	      </tr>
	      <tr>
	        <td align="center"><a href="<%=basePath %>files/7yjssx_system/infoFile/Thesis/${retThesis.FThesisStorePath }">论文下载</a></td>
	    </tr>
	    </table>
	    </fieldset>
	    <fieldset>
     <legend><font size="3">回复修改</font></legend>
	  <form action="yjssxTutor/TutorReceiveThesis!ReturnThesis.action" method="post" enctype="multipart/form-data">
	  	  <input type="hidden" name="stuId" value="${detailThesis.tabPostgraduate.FStudentNumber }"/>
	  	  <input type="hidden" value="${ThesisType }" name="ThesisType" />
	      <table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999">
	        <tr>
	          <td height="43"><div align="left">标题：&nbsp;</div></td>
	          <td ><div align="left">
	              <input type="text" height="25" name="retThesis.FThesisName" />
	          </div></td>
	          <td height="41"><div align="left">上传回复文档：&nbsp;</div></td>
	          <td><div align="left">
	              <input type="file" name="uploadFile"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td height="66" ><div align="left">备注：</div></td>
	          <td colspan="3"><div align="left">
	              <textarea rows="3" cols="80%" name="retThesis.FComment"></textarea>
	          </div></td>
	        </tr>
	        <tr>
	          <td><div align="left">
	              <input type="submit" value="发送" />
	          </div></td>
	          <td colspan="3"><div align="left"></div></td>
	        </tr>
	      </table>
	    </form>
    </fieldset>
   </s:elseif>
   <s:else>
   	<fieldset>
     <legend><font size="3">您尚未回复,请回复</font></legend>
	  <form action="yjssxTutor/TutorReceiveThesis!ReturnThesis.action" method="post" enctype="multipart/form-data">
	  	  <input type="hidden" name="stuId" value="${detailThesis.tabPostgraduate.FStudentNumber }"/>
	  	  <input type="hidden" value="${ThesisType }" name="ThesisType" />
	      <table width="100%" border="1" style="border-collapse:collapse" bordercolor="#999999">
	        <tr>
	          <td height="43"><div align="left">标题：&nbsp;</div></td>
	          <td ><div align="left">
	              <input type="text" height="25" name="retThesis.FThesisName"/>
	          </div></td>
	          <td height="41"><div align="left">上传回复文档：&nbsp;</div></td>
	          <td><div align="left">
	              <input type="file" name="uploadFile"/>
	          </div></td>
	        </tr>
	        <tr>
	          <td height="66" ><div align="left">备注：</div></td>
	          <td colspan="3"><div align="left">
	              <textarea rows="3" cols="80%" name="retThesis.FComment"></textarea>
	          </div></td>
	        </tr>
	        <tr>
	          <td><div align="left">
	              <input type="submit" value="发送" />
	          </div></td>
	          <td  colspan="3"><div align="left"></div></td>
	        </tr>
	      </table>
	    </form>
    </fieldset>
   </s:else>
  </div>
</body>
</html>
