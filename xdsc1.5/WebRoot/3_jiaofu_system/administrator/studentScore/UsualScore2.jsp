<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<style type="text/css">
<!--
body {
	background-image: url(images/Background.png)
}
-->
</style>
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

	<body>
		<br>
		<h3 align="center">
			平时成绩
		</h3>
		<hr>
		<s:form action="administrator/ScoreInfo!findUsualSelectInfo.action" method="post" theme="simple">
		<table width="80%" border="0" align="center">
			<tr>
				<td align="left">
					根据课程名称查询平时各种成绩信息:
					<s:textfield name="FCourseName"/>&nbsp;
					<s:submit value="提交"/>
				</td>
			</tr>
		</table>
		</s:form>
		<s:form action="administrator/ScoreInfo!deletelist2.action" method="post" theme="simple">
		<table width="80%" border="0" id="mytable" align="center">
			<tr>
	                <th align="center" colspan="9" background="<%=basePath%>3_jiaofu_system/pictures/jft.gif" height="30">
			           <font color="#FFFFFF">平时成绩信息</font>
	                </th>
	            </tr>
			<tr>
				<th width=""  align="center">
					序号
				</th>
				<th width=""  align="center">
					课程编号
				</th>
				<th width=""  align="center">
					课程名称
				</th>
				<th width=""  align="center">
					学生学号
				</th>
				<th width=""  align="center">
					学生姓名
				</th>
				<th width=""  align="center">
					成绩得分
				</th>
				<th width=""  align="center">
					学期
				</th>
				<th width=""  align="center">
				          成绩类型
				</th>
				<th width=""  align="center">
				         标记
				</th>
			</tr>
			<s:iterator value="listUsualscoreInfo" status="status">
				<tr>
					<td align="center">
						<s:property value="#status.count" />
					</td>
					<td align="center">
						<s:property value="tabCourse.FCourseNumber"/>
					</td>
					<td align="center">
						<s:property value="tabCourse.FCourseName"/>
					</td>
					<td align="center">
						<s:property value="tabStudents.FStudentNumber"/>
					</td>
					<td align="center">
						<s:property value="tabStudents.FStudentName"/>
					</td>
					<td align="center">
						<s:property value="FScore"/>
					</td>
					<td align="center">
						<s:property value="FXueQi"/>
					</td>
					<td align="center">
						<s:property value="FType"/>
					</td>
					<td align="center">
					    <input type="checkbox" name="deletelist2" value="${FNumber}"/>
					</td>
				</tr>
			</s:iterator>
			<s:if test="listUsualscoreInfo.size > 0">
			  <tr align="right">
			    <td colspan="9">
			        <input type="button" value="全选" onclick="selectAll()" />
                    <input type="button" value="反选" onclick="unSelectAll()" />
                    <input type="submit" value="删除" />
			    </td>
			  </tr>
			  <tr align="center">
			    <td colspan="9">
			      <a href='<s:url action="administrator/ScoreInfo!findUsualSelectInfo.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
			      <a href='<s:url action="administrator/ScoreInfo!findUsualSelectInfo.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
                  <a href='<s:url action="administrator/ScoreInfo!findUsualSelectInfo.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
                  <a href='<s:url action="administrator/ScoreInfo!findUsualSelectInfo.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
                                                共<s:property value="lastPage"/>页,当前第<s:property value="p"/>页
			    </td>
			 </tr>
		   </s:if>
		</table>
		</s:form>
	</body>
</html>