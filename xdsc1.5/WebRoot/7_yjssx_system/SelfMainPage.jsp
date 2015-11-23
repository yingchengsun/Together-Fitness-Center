<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>研究生实习系统</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath %>js/jquery-1.4.2.js"></script>
<style type="text/css">
.accordion2 {
	width: 480px;
	border-bottom: solid 1px #c4c4c4;
}
.accordion2 h5 {
	background: #e9e7e7 url(<%=basePath %>7_yjssx_system/SubSystemImage/arrow-square.gif) no-repeat right -51px;
	padding: 7px 15px;
	margin: 0;
	font: bold 120%/100% Arial, Helvetica, sans-serif;
	border: solid 1px #c4c4c4;
	border-bottom: none;
	cursor: pointer;
}
</style>
<script type="text/javascript">
   $(document).ready(function(){
	
	$(".accordion2 h5").eq(2).addClass("active");
	$(".accordion2 p").eq(2).show();

	$(".accordion2 h5").click(function(){
		$(this).next("p").slideToggle("slow")
		.siblings("p:visible").slideUp("slow");
		$(this).toggleClass("active");
		$(this).siblings("h5").removeClass("active");
	});

   });
   

	</script>
</head>

<body>
<div align="left">
  <table border="0" cellpadding="1" cellspacing="0" width="801" align="center" style="border-collapse:collapse" >
    <tr>
      <td height="166" colspan="2"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="799" height="164">
        <param name="movie" value="<%=basePath %>7_yjssx_system/SubSystemImage/top.swf" />
        <param name="quality" value="high" />
        <embed src="<%=basePath %>7_yjssx_system/SubSystemImage/top.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="799" height="164"></embed>
      </object>
        <table width="800" height="25" border="0" style="background-image:url(SubSystemImage/navigate.gif)">
          <tr style="background-color: #0948F7">
            <td height="21" align="left" valign="middle" width="794"
					background="/images/mune02.gif" class="text_write"> <div align="left"> | <a href="<%=basePath %>7_yjssx_system/PracticingFirstPage.jsp" class="a_write STYLE30">首 页 </a> 
              <!--顶部链接-->            
            </div></td>
          </tr>
      </table></td>
    <tr valign="top">
      <td width="210" valign="top" bordercolor="#02abfe"  style="width: 192px">
	 <table width="210" height="88" border="0" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif">
	    <tr>
	      <td width="50%" height="30" align="right" >姓名： </td>
	      <td align="center">
	           ${userName }
		  </td>
	    </tr>
	    <tr>
	      <td height="22" align="right">电话：</td>
	      <td align="center">
	        ${phone}
		   </td>
	    </tr>
	    <tr>
	      <td height="28" align="right">
	      	地址：	      </td>
	      <td align="center">
		     ${place }
		  </td>
	  </tr>
	  <tr>
	      <td height="28" align="right">
	      	个人主页：	      </td>
	      <td align="center">
		     <a href="<%=basePath %>yjssxCommon/CommonLogin!GoToHomePage.action?type=${type }">主页</a>
		  </td>
	  </tr>
    </table>
    <table width="210">
    	<tr style="background-image: url('<%=basePath %>images/rP01.jpg')">
	      <td height="650" align="right" >
	      </td>
	  </tr>
    </table>
    <td width="587" align="left" valign="top">
      <div class="accordion2">
	    <table width="589" height="525" cellpadding="0" cellspacing="0" background="<%=basePath %>7_yjssx_system/SubSystemImage/bg.gif"class="rightKuang">
          <tr >
             <td width="587" height="50" align="center">
			       新鲜事列表
             </td>
          </tr>
          
			  <s:iterator value="noticeList" status="status">
				  <tr>
				    <td>
					    	<h5>
					    		<img src="<%=basePath %>7_yjssx_system/SubSystemImage/sucaiwcom0566000jty.gif" width="19" height="17" />
					    		<s:property value="FInfoTitle" escape="false"/>
					        </h5>
					    	<p><s:property value="FInfoContet" escape="false"/></p>
					    	<hr width="100%"/>
				    </td>
				  </tr>
		     </s:iterator>
	     
		  <tr valign="top" height="72%">
             <td align="center" >
             </td>
          </tr>
        </table>   
      </div> 
 </table>
</div>
</body>
</html>

