<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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

<body background="<%=basePath %>7_yjssx_system/SubSystemImage/Background.png">
<div align="center">
   <table border="0" cellpadding="1" cellspacing="0" width="801" align="center" style="border-collapse:collapse" >
    <tr>
      <td height="166" colspan="2">
        <embed src="<%=basePath%>7_yjssx_system/SubSystemImage/top.swf" width="799" height="164"></embed>
        <table width="800" height="25" border="0" background="<%=basePath%>7_yjssx_system/SubSystemImage/navigate.gif">
          <tr>
            <td height="21" align="left" valign="middle" width="794"
					background="<%=basePath%>7_yjssx_system/SubSystemImage/navigate.gif" class="text_write"> <div align="left"> &nbsp;&nbsp;&nbsp; <a href="<%=basePath%>yjssxCommon/YjssxFirstPage!showFirstPageInfo.action"><strong><font color="#ffffff">首 页</font></strong> </a> 
              <!--顶部链接-->            
            </div></td>
          </tr>
         </table>
      </td>
     </tr>
    </table>
    <table width="801" border="0" style="margin-top: 10px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
      <tr>
        <td width="100%" height="26"><div align="center">${infoTypeName}</div></td>
      </tr>
   </table>
   <table width="801" border="1" id="mytable" style="border-collapse:collapse">
	   <s:if test="moreInfo.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
		<s:else>
		   <s:iterator value="moreInfo" status="status">
			  <tr>
			    <td align="center" height="24"><s:property value="#status.count" /></td>
			    <td>
			    	<div align="left"><s:property value="FInfoTitle"/>
			    	<s:if test="FInfoZuiXin.equals('Y')">
			    		<img src="SubSystemImage/gif-0249.gif" width="28" height="14" />
			    	</s:if>
			    	</div>
			    </td>
			    <td><div align="center">2010.4.25<s:property value="FInfoStartTime"/></div></td>
			    <td><div align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			    	<a href="<%=basePath %>yjssxCommon/YjssxFirstPage!showInfoDetail.action?infoId=${FInfoId }">查看</a></div></td>
			  </tr>
			</s:iterator>
	    </s:else>
  </table>
 <table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminReleaseFirstPageInfo!showInfo.action?type=${type }&&p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
 
</div> 
</body>
</html>
