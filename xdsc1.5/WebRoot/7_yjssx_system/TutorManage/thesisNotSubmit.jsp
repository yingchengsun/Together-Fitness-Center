<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>ext/resources/css/ext-all.css" />
<link rel="stylesheet"  href="<%=basePath %>ext/resources/css/ext-patch.css"  type="text/css"  />
<link href="<%=basePath %>css.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="<%=basePath %>js/TableColor.js"></script>
<script type="text/javascript" src="<%=basePath %>ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=basePath %>ext/ext-all.js"></script>
<script type="text/javascript">
 function openWindow(url){
  var window=new Ext.Window({
  	title:"论文详情",
  	frame:true,
  	width:750,
  	height:400,
  	autoScroll:true,
  	minimizable:true,
  	maximizable:true,
  	resizable:true,
  	autoLoad:url
  });
  window.show();
 }
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
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="75"/>
   <table width="80%">
   	<tr>
	  	<td scope="col"></td>
	    <td scope="col" align="right"><strong><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!TutorReturnThesisStatus.action?ThesisType=${ThesisType }"><font color="red">查看反馈论文状态</font></a></strong>
	    <img src="<%=basePath %>7_yjssx_system/SubSystemImage/book.png" height="20"/>
	    </td>
	  </tr>
   </table>
   <fieldset>
       <legend><font size="3">论文提交情况</font></legend>
         <form action="yjssxTutor/TutorReceiveThesis!submitInfomationSearch.action" method="post">
           <input type="hidden" value="${ThesisType }" name="ThesisType" />
	       <table width="100%">
	          <tr>
	            <td><div align="right">年级：</div></td>
				<td><input type="text" name="studentGrade"/></td>
				<td align="right">提交情况：</td>
	          	<td align="left">
					<select name="IsSubmit">
						<option value="">--请选择--</option>
					 	<option value="Y">已提交论文</option>
						<option value="N">未提交论文</option>
					</select>
			    </td>
			    <td width="41%" align="left">
					<input type="submit" value="点击搜索"/>
			    </td>
	          </tr>
	       </table>
	    </form>
   </fieldset>
   
      <fieldset>
       <legend><font size="3">论文反馈情况</font></legend>
         <form action="yjssxTutor/TutorReceiveThesis!ReturnInfomationSearch.action" method="post">
           <input type="hidden" value="${ThesisType }" name="ThesisType" />
	       <table width="100%">
	          <tr>
	            <td><div align="right">年级：</div></td>
				<td><input type="text" name="studentGrade"/></td>
				<td align="right">反馈情况：</td>
	          	<td align="left">
					<select name="isReturned">
						<option value="">--请选择--</option>
					 	<option value="Y">已反馈论文</option>
						<option value="N">未反馈论文</option>
					</select>
			    </td>
			    <td width="41%" align="left">
					<input type="submit" value="点击搜索"/>
			    </td>
	          </tr>
	       </table>
	    </form>
   </fieldset>
   
	<fieldset>
	       <legend><font size="3">提交论文状态</font></legend>
	         <form action="yjssxTutor/TutorReceiveThesis!SubmitThesisSearchByCondition.action" method="post">
		       <input type="hidden" value="${ThesisType }" name="ThesisType" />
		       <table width="100%">
		                <tr>
							<td><div align="right">年级：</div></td>
						    <td><input type="text" name="studentGrade"/></td>
						    <td><div align="right">姓名：</div></td>
						    <td><input type="text" name="studentName"/></td>
							<td><div align="right">审核情况：</div></td>
							<td>
								<select name="ThesisStatus">
									<option value="">--请选择--</option>
								 	<option value="未审核">未审核</option>
									<option value="审核未通过">审核未通过</option>
									<option value="审核已通过">审核已通过</option>
								</select>				  
							</td>
							<td><input type="submit" value="点击搜索" /></td>
						</tr>             
		          </table>
		    </form>
	  </fieldset>
     <form action="yjssxTutor/TutorNoticeTuStudent!NoticeToStudent.action" method="post">
	   <table width="100%" border="1" id="mytable" style="border-collapse:collapse">
		  <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		    <th>编号</th>
		    <th scope="col"><div align="center">选择</div></th>
		    <th><div align="center"><strong>学号</strong></div></th>
	        <th><div align="center"><strong>姓名</strong></div></th>
	        <th><div align="center"><strong>性别</strong></div></th>
	        <th><div align="center"><strong>籍贯</strong></div></th>
	        <th><div align="center"><strong>地址</strong></div></th>
	        <th><div align="center"><strong>本科学校</strong></div></th>
	        <th><div align="center"><strong>班级</strong></div></th>
	        <th><div align="center"><strong>年级</strong></div></th>
	        <th><div align="center"><strong>邮箱</strong></div></th>
	        <th><div align="center"><strong>电话</strong></div></th>
		  </tr>
		<s:if test="stuList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
		<s:else>
		   <s:iterator value="stuList" status="status">
			  <tr>
			    <td align="center" height="24"><s:property value="#status.count" /></td>
			  	<td><input type="checkbox" name="NoticeStuId" value="${FStudentNumber }"/></td>
			    <td align="center">${tabStudents.FStudentNumber }</td>
		      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${tabStudents.FStudentName }</td>
		      <td align="center">${tabStudents.FStudentSex }</td>
		      <td align="center">${tabStudents.FStudentNativeplace }</td>
		      <td align="center">${tabStudents.FStudentAddress }</td>
		      <td align="center">${FStudentExSchool}</td>	 
		      <td align="center">${tabStudents.tabClasses.FClassName }</td>     
		      <td align="center">${tabStudents.tabClasses.tabGrade.FGradeNum }</td>
		      <td align="center">${tabStudents.FStudentEmail }</td>
		      <td align="center">${tabStudents.FStudentTel }</td>
			  </tr>
			</s:iterator>
			<tr style="background-color:#CCCCCC">
		      <td><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
		      <td><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
		      <td><div align="center"><input type="submit" value="发送通知" /></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
		      <td><div align="center"></div></td>
	    </tr>
	   </s:else>
	  </table>
	</form>
	<table width="40%">
  	<tr>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!thesisNotSubmit.action?p=1" >首页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!thesisNotSubmit.action?p=${p-1}" >上一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!thesisNotSubmit.action?p=${p+1}" >下一页</a></div></td>
		<td><div align="center"><a href="<%=basePath %>yjssxTutor/TutorReceiveThesis!thesisNotSubmit.action?p=${lastPage}" >末页</a></div></td>
	</tr>
  </table>
	
</div> 
</body>
</html>
