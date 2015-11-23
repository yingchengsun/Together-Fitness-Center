<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>申请实习</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
</head>

<body  background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">

        <table width="100%" border="0" style="margin-top: 100px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
		      <tr>
		        <td width="100%" height="26"><div align="center">${comInfo.FCompanyName }</div></td>
		      </tr>
        </table>
         <hr align="center" width="100%"/>
          <table width="100%" >
             <tr>
               <td height="44"><div align="center">期待您的到来</div></td>
            </tr>
            <tr>
            	<td height="57"><div align="center"><a href="<%=basePath %>files/7yjssx_system/infoFile/information/${infoPath }">下载简历模板</a>
                <img src="<%=basePath %>7_yjssx_system/SubSystemImage/gif-0145.gif" /></div></td>
            </tr>
            <tr>
              <td height="57">
              	<div align="center">上传简历 
                   <s:form action="PostgraduateUploadResume!uploadResume.action" namespace="/yjssxStudent" enctype="multipart/form-data">  
                    
                     <input type="hidden" name="companyId" value="${comInfo.FCompanyNumber }" /><p> 	 
                   <div align="center">  
                     <input type="file" name="uploadFile" size="30" /><p> 
                     <input type="submit" value="提交简历" /> 
                    </div>
                   </s:form> 
              </td>
           </tr>
       </table>
        <hr align="center" width="100%"/>
   </div>
</body>
</html>
