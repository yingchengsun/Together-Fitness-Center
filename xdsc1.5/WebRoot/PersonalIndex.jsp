<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>

<head>
    <title>软件学院信息化平台</title>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="ext/resources/css/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="ext/resources/css/xtheme-purple.css"> 
	<link rel="stylesheet"  href="ext/resources/css/ext-patch.css"  type="text/css"  />
 	<script type="text/javascript" src="ext/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="ext/ext-all.js"></script>
    <script type="text/javascript" src="ext/ext-lang-zh_CN.js"></script>
    
	<script type="text/javascript" src="index.js"></script>

	
	<link rel="stylesheet" type="text/css" href="ext/resources/css/xtheme-<%=session.getAttribute("css")%>.css"> 
	
    <link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
  
    .wangzhanmenhu {
        background-image:url(image/accreditation.gif);
    }
    .xueshengguanli {
        background-image:url(image/calculate.gif);
    }
	.jiaofupingtai {
        background-image:url(image/Chart.gif);
    }
	.gongshuobaoming {
        background-image:url(image/closered2.gif);
    }
	.shijianjiaoxue {
        background-image:url(image/defultsetting.gif);
    }
	.biyesheji {
        background-image:url(image/design.gif);
    }
	.yanjiushengshixi {
        background-image:url(image/drop price draw.gif);
    }
    .wodeyouxiang {
        background-image:url(image/mail.gif);
    }
    .genzongfankui {
        background-image:url(image/edit_profile.gif);
    }
    .zonghoutaiguanli {
        background-image:url(image/Line maintenance.gif);
    }
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body  >
<div></div>
 </body>
</html>
