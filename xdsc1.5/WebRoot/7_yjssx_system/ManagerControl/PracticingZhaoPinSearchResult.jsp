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

<body background="../SubSystemImage/Background.png">
<div align="center">
<img src="<%=basePath %>7_yjssx_system/SubSystemImage/manage3.png" height="72" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">企业实习管理</div></td>
      </tr>
   </table>
   <fieldset  style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/login_bg.gif')">
   <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="50"/></legend>
   <table width="100%" border="0" height="70">
   	  <tr>
   	  	<td><div align="center"><strong>实习企业确定情况查询：</strong></div></td>
   	  	<td><div align="center"><strong>输入企业名称：</strong></div></td>
   	  </tr>
      <tr>
        <td><div align="center">
			<form action="yjssxAdmin/AdminPractingZhaoPinManage!CompanyConfirmedSearch.action" method="post">
		  	 <select name="confirmInfo" >
		  	 	  <option >-----------请选择-----------</option>
			      <option value="Y">已确定实习企业的研究生</option>
			      <option value="N">未确定实习企业的研究生</option>
		      </select>
		      	<input type="submit" value="搜索"/>
	  		</form>
		</div></td>
		<td><div align="center">
			<form action="yjssxAdmin/AdminPractingZhaoPinManage!searchByCompanyName.action" method="post">
		  	     <select name="ComName">
		  	      <option value="">----请选择-----</option>
		  	      <s:iterator value="companyList">
			      <option value="${FCompanyNumber }">${FCompanyName }</option>
			      </s:iterator>
		      </select>
		      	<input type="submit" value="搜索"/>
	  		</form>
		</div></td>
     </tr>	
   </table>  
  </fieldset>
  <form action="yjssxAdmin/AdminReleaseNotice!noticeTo.action" method="post">
     <input type="hidden" name="type" value="研究生"/>
	   <table width="100%" id="mytable" border="1" style="border-collapse:collapse" bordercolor="#999999"
		background="../SubSystemImage/bg.gif">
		    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		      <th>编号</th>
		      <th><div align="center"><strong>选择</strong></div></th>
		      <th><div align="center"><strong>学号</strong></div></th>
		      <th><div align="center"><strong>姓名</strong></div></th>
		      <th><div align="center"><strong>性别</strong></div></th>
		      <th><div align="center"><strong>籍贯</strong></div></th>
		      <th><div align="center"><strong>地址</strong></div></th>
		      <th><div align="center"><strong>本科学校</strong></div></th>
		      <th><div align="center"><strong>邮箱</strong></div></th>
		      <th><div align="center"><strong>班级</strong></div></th>
		      <th><div align="center"><strong>年级</strong></div></th>
		      <th><div align="center"><strong>电话</strong></div></th>
		      <th><div align="center"><strong>企业名称</strong></div></th>
		    </tr>
		    <s:if test="studentList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		   </s:if>
	       <s:else>
		    <s:iterator value="studentList" status="status">
		    <tr>
		      <td align="center" height="24"><s:property value="#status.count" /></td>
		      <td align="center" height="24"><input type="checkbox" name="noticeId" value="${FStudentNumber }"/></td>
		      <td align="center">${tabStudents.FStudentNumber }</td>
		      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentName }</td>
		      <td align="center">${tabStudents.FStudentSex }</td>
		      <td align="center">${tabStudents.FStudentNativeplace }</td>
		      <td align="center">${tabStudents.FStudentAddress }</td>
		      <td align="center">${FStudentExSchool}</td>	 
		      <td align="center">${tabStudents.FStudentEmail }</td>
		      <td align="center">${tabStudents.tabClasses.FClassName }</td>     
		      <td align="center">${tabStudents.tabClasses.tabGrade.FGradeNum }</td>
		      <td align="center">${tabStudents.FStudentTel }</td>
		        <s:if test="tabCompany == null">
		        	<td align="center">企业未选定</td>
		        </s:if>
		        <s:else>
		        	<td align="center">${tabCompany.FCompanyName }</td>
		        </s:else>
		    </tr>
		   </s:iterator>
		  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <td><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
	      <td><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
	      <td><div align="center"><input type="submit" value=发送通知" /></div></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	      <td></td>
	    </tr>
	    </s:else>
	  </table>	  
   </form>	  
	 <table width="40%">
	  	<tr>
			<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!StudentSelectInfo.action?selectInfo=Y&&p=1" >首页</a></div></td>
			<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!StudentSelectInfo.action?selectInfo=Y&&p=${p-1}" >上一页</a></div></td>
			<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!StudentSelectInfo.action?selectInfo=Y&&p=${p+1}" >下一页</a></div></td>
			<td><div align="center"><a href="<%=basePath %>yjssxAdmin/AdminTutorSelectManage!StudentSelectInfo.action?selectInfo=Y&&p=${lastPage}" >末页</a></div></td>
		</tr>
	  </table>	  
</body>
</html>
