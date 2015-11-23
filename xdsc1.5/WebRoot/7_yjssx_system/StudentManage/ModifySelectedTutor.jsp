<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="../css.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function opendialog(type)
		{	
			var tutorname=window.showModalDialog('<%=basePath %>yjssxStudent/PostgraduateAllTutorInfoForSelect!AllTutorInfo.action','title','scrollbars=no;resizable=no;help=no;status=no;dialogTop=100; dialogLeft=500;dialogHeight=350px;dialogwidth=410px;')
			var SubName="";
			for(var i=0;i<tutorname.indexOf("&");i++)
			{
				SubName=SubName+tutorname.charAt(i);
			}
			var SubId=tutorname.substring(tutorname.indexOf("&")+1);
			//alert(SubName+"--------"+SubId);
			if(tutorname==null&&type==1)
				document.form1.tutorname1.value="请选择";
			else if(tutorname==null&&type==2)
				document.form1.tutorname2.value="请选择";
			else if(tutorname==null&&type==3)
				document.form1.tutorname3.value="请选择";
			else if(tutorname!=null&&type==1){
			  document.form1.tutorname1.value=SubName;
			  document.form1.tutorId1.value=SubId;
			  }
			else if(tutorname!=null&&type==2){
			  document.form1.tutorname2.value=SubName;
			  document.form1.tutorId2.value=SubId;
			  }
			else{
			  document.form1.tutorname3.value=SubName;
			  document.form1.tutorId3.value=SubId;
			  }			
		}
</script>
<style type="text/css">
<!--
.STYLE16 {font-size: 16px}
-->
</style>
</head>

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">

   <table width="90%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="90%" height="26"><div align="center">修改导师选择</div></td>
      </tr>
   </table>
   <hr align="center" width="90%" size="2" color="#990033"/>
  <s:form action="PostgraduateSelectTutor!updateTutorSelect.action" namespace="/yjssxStudent" id="form1" name="form1">
   <table width="90%"  border="1" style="border-collapse:collapse" bordercolor="#999999" background="../SubSystemImage/bg.gif"> 
     <tr>
       <td width="13%" height="57"><div align="left">第一志愿：</div></td>
       <td width="87%"><div align="left">
         <input name="tutorname1" type="text" onclick="opendialog(1)" value="${selectedTutor.tabTeachersByFFirstWish.FTeacherName }"  size="30"/>
         <input name="tutorId1" type="hidden"/>
       </div></td>
     </tr>
     <tr>
       <td height="54"><div align="left">第二志愿：</div></td>
       <td><div align="left">
         <input name="tutorname2" type="text" onclick="opendialog(2)" value="${selectedTutor.tabTeachersByFSecondWish.FTeacherName }"  size="30"/>
         <input name="tutorId2" type="hidden"/>
       </div></td>
	  </tr>
     <tr>
       <td height="59"><div align="left">第三志愿：</div></td>
       <td><div align="left">
         <input name="tutorname3" type="text" onclick="opendialog(3)" value="${ selectedTutor.tabTeachersByFThirdWish.FTeacherName}"  size="30"/>
         <input name="tutorId3" type="hidden"/>
       </div></td>
	  </tr>
     <tr>
       <td height="313"><div align="left">备注：</div></td>
       <td><div align="left">
         <FCK:editor instanceName="comment" basePath="/fckeditor" value=" ${ selectedTutor.tabTeachersByFThirdWish.FTeacherName}" width="100%" height="300" toolbarSet="mytools1"></FCK:editor>
       </div></td>
	  </tr>
	  <tr>
	    <td><div align="left">
	      <input name="提交" type="submit" value="提交"/> 
        </div></td>
	    <td><div align="left"></div></td>
	  </tr>
   </table> 
 </s:form>
  </div>
</body>
</html>