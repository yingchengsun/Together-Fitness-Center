<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
</head>

<body background="../SubSystemImage/Background.png">
<div align="center" >
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/info2.png" height="75"/>
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">ӦƸ��Ϣ</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
  <table width="100%"border="1" id="mytable" style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif">
    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
      <th>���</th>
      <th>��˾����</th>
      <th>��������</th>
      <th>�鿴</th>
    </tr>
    <s:if test="noticeList.size==0">
			<tr>
				<td>�Բ����������ݣ�����</td>
			</tr>
		</s:if>
	    <s:else>
    <s:iterator value="noticeList" status="status">
    <tr>
      <td align="center">
		<s:property value="#status.count" />
	  </td>
      <td height="24">
      <div align="left"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/sucaiwcom0566000jty.gif" width="19" height="17" /><a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!showDetail.action?noticeId=${FInfoId }">${FInfoTitle }</a> </div></td>
        <td>
      <div align="center"><span><fmt:formatDate value="${FInfoStartTime}" type="date" dateStyle="medium"/></span> </div></td >
      <td><div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
         <a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!showDetail.action?noticeId=${FInfoId }">�鿴����</a> </div></td>
    </tr>
    </s:iterator>
   </s:else>
  </table>
  <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!ShowNotice.action?p=1" >��ҳ</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!ShowNotice.action?p=${p-1}" >��һҳ</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!ShowNotice.action?p=${p+1}" >��һҳ</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxStudent/PostgraduateYingPinInfo!ShowNotice.action?p=${lastPage}" >ĩҳ</a></div></td>
	</tr>
  </table>
  
</div>
</body>
</html>
