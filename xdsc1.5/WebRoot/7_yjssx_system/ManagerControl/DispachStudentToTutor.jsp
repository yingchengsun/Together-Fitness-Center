<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
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
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage1.png" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">研究生导师选择</div></td>
      </tr>
   </table>
   <hr align="center" width="100%"/>
   <table width="100%" border="0">
   	  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
   	  	<td><div align="center"><strong>请输入导师姓名：</strong></div></td>
   	  </tr>
      <tr>
        <td width="100%"><div align="center">
		<form action="yjssxAdmin/AdminTutorSelectDispach!dispachSearchByTutorName.action" method="post">
	  	    输入导师姓名：
            <select name="tutorName">
	  	      <option value="">----请选择-----</option>
	  	      <s:iterator value="teacherList">
		      <option value="${FTeacherNumber }">${FTeacherName }</option>
		      </s:iterator>
	        </select>
	      	<input type="submit" value="搜索"/>
  		</form>
		</div></td>
     </tr>
   </table>
   <hr align="center" width="100%"/>
	 <form action="yjssxAdmin/AdminTutorSelectDispach!disDispachStudent.action" method="post">
	 	   <input type="hidden" name="tutorId" value="${tutor.FTeacherNumber }"/>
		   <div align="center"> 
		   			<font size="4">第一志愿报考的学生</font> 
		   </div>
		   <table width="100%" border="1" style="border-collapse:collapse">
			    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
			      <th>编号</th>
			      <th><div align="center"><strong>选择</strong></div></th>
			      <th><div align="center"><strong>研究生名称</strong></div></th>
			      <th><div align="center"><strong>研究生电话</strong></div></th>
			      <th><div align="center"><strong>研究生邮箱</strong></div></th>
			      <th><div align="center"><strong>研究生详情</strong></div></th>
			      <th><div align="center"><strong>志愿详情</strong></div></th>
			    </tr>
			    <s:if test="firstWish.size==0">
				    <tr>
					 <td>对不起暂无数据！！！</td>
					</tr>
			    </s:if>
		        <s:else>
			    <s:iterator value="firstWish" status="status">
			    <tr>
			      <td align="center" height="24"><s:property value="#status.count" /></td>
			      <td><input type="checkbox" name="StuId" value="${tabPostgraduate.FStudentNumber }"/></td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentName }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentTel }</td>
			      <td>${tabPostgraduate.tabStudents.FStudentEmail }</td>
			      <td align="center"><div align="center">
			      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			      <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${tabPostgraduate.FStudentNumber}" class="STYLE5">研究生详情</a></div></td> 
			       <td align="center"><div align="center">
			       <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			       <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${tabPostgraduate.FStudentNumber}" class="STYLE5">志愿详情</a></div></td>   
			    </tr>
			   </s:iterator>
			   </s:else>
			  </table><br/>
			  <div align="center"> 
		   			<font size="4">第二志愿报考的学生</font> 
		   </div>
		   <table width="100%" border="1" style="border-collapse:collapse">
			    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
			      <th>编号</th>
			      <th><div align="center"><strong>选择</strong></div></th>
			      <th><div align="center"><strong>研究生名称</strong></div></th>
			      <th><div align="center"><strong>研究生电话</strong></div></th>
			      <th><div align="center"><strong>研究生邮箱</strong></div></th>
			      <th><div align="center"><strong>研究生详情</strong></div></th>
			      <th><div align="center"><strong>志愿详情</strong></div></th>
			    </tr>
			    <s:if test="secondWish.size==0">
				    <tr>
					 <td>对不起暂无数据！！！</td>
					</tr>
			    </s:if>
		        <s:else>
			    <s:iterator value="secondWish" status="status">
			    <tr>
			      <td align="center" height="24"><s:property value="#status.count" /></td>
			      <td><input type="checkbox" name="StuId" value="${tabPostgraduate.FStudentNumber }"/></td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentName }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentTel }</td>
			      <td>${tabPostgraduate.tabStudents.FStudentEmail }</td>
			      <td align="center"><div align="center">
			        <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			        <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${tabPostgraduate.FStudentNumber}" class="STYLE5">研究生详情</a></div></td> 
			       <td align="center"><div align="center">
			         <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			         <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${tabPostgraduate.FStudentNumber}" class="STYLE5">志愿详情</a></div></td>   
			    </tr>
			   </s:iterator>
			   </s:else>
			  </table><br/>
			  <div align="center"> 
		   			<font size="4">第三志愿报考的学生</font> 
		   </div>
		   <table width="100%" border="1" style="border-collapse:collapse">
			    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
			      <th>编号</th>
			      <th><div align="center"><strong>选择</strong></div></th>
			      <th><div align="center"><strong>研究生名称</strong></div></th>
			      <th><div align="center"><strong>研究生电话</strong></div></th>
			      <th><div align="center"><strong>研究生邮箱</strong></div></th>
			      <th><div align="center"><strong>研究生详情</strong></div></th>
			      <th><div align="center"><strong>志愿详情</strong></div></th>
			    </tr>
			    <s:if test="thirdWish.size==0">
				    <tr>
					 <td>对不起暂无数据！！！</td>
					</tr>
			    </s:if>
		        <s:else>
			    <s:iterator value="thirdWish" status="status">
			    <tr>
			      <td align="center" height="24"><s:property value="#status.count" /></td>
			      <td><input type="checkbox" name="StuId" value="${tabPostgraduate.FStudentNumber }"/></td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentName }</td>
			      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabPostgraduate.tabStudents.FStudentTel }</td>
			      <td>${tabPostgraduate.tabStudents.FStudentEmail }</td>
			      <td align="center"><div align="center">
			        <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			        <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${tabPostgraduate.FStudentNumber}" class="STYLE5">研究生详情</a></div></td> 
			       <td align="center"><div align="center">
			      	 <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
			       	 <a href="<%=basePath %>yjssxCommon/CommonOperation!findStudentInfo.action?stuId=${tabPostgraduate.FStudentNumber}" class="STYLE5">志愿详情</a></div></td>   
			    </tr>
			   </s:iterator>
			   </s:else>
			  </table>		  
			  <table width="100%">
			  	<tr style="background-color:#CCCCCC">
			      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
			      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
			      <td ><div align="center"><input type="submit" value="确认分配" /></div></td>
			      <td></td>
			      <td></td>
			      <td></td>
			    </tr>
			  </table>	
	  </form>  
</div>
</body>
</html>
