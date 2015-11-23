<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>   
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'index.jsp' starting page</title>
        <link href="<%=basePath%>css.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="<%=basePath%>js/TableColor.js"></script>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script src="<%=basePath %>11_BackGroundSystem/ManagerManagement/jquery-1[1].2.1.pack.js"></script>
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

//$.ajax()方式 
$(document).ready(function (){ 
//1号下拉框事件
$('#select1').change(function (){ 
$.ajax({ 
url:'<%=basePath %>11_BackGroundSystem/ManagerManagement/cssrain.jsp', 
type:'post', //数据发送方式 
dataType:'xml', //接受数据格式 
data:'id=1&text='+$("select[@id='select1'] option[@selected]").text()+'&date='+new Date(),  //要传递的数据 
error:function(json){
    alert( "not lived!");
  },
  success: function(xml){
      $("#select2").html('');//清空2号下拉框   
  $(xml).find("name").each(function(){ 
  var id=$(this).attr("id"); //获取返回的ID 
  var name=$(this).text(); //获取返回的NAME
    $('<option value='+name+'>'+name+'</option>').appendTo('#select2'); //添加下拉框
    $("#select2").attr('disabled','') //2号下拉框可用
        });
  }
}); 
});


 

}); 


 
</script>

	</head>

	<body>
	   <br /><br /><br />
		<center>
		<fieldset style="border-color: #ECF5FF">
		<legend>
		  <font size="2" >角色功能配置</font>
		</legend>
		<s:form name="showbysystem" action="FunctionAction!rolefunctionconfiglist.action" method="post" theme="simple">
            <table>
				<tr>
					<td>
						子系统：
						<select id="select1" name="modulename" style="width:150px">
							<option value="0">
								====请选择====
							</option>
							<option value="网站门户">
								网站门户
							</option>
							<option value="学生管理">
								学生管理
							</option>
							<option value="教铺平台">
								教铺平台
							</option>
							<option value="工硕报名">
								工硕报名
							</option>
							<option value="实践教学">
								实践教学
							</option>
							<option value="毕业设计">
								毕业设计
							</option>
							<option value="研究生实习">
								研究生实习
							</option>
							<option value="我的邮箱">
								我的邮箱
							</option>
							<option value="跟踪反馈">
								跟踪反馈
							</option>
							<option value="总后台管理">
								总后台管理
							</option>
						</select>
					</td>
					<td>
						角色：
						<select id="select2" name="rolename" disabled="disabled" style="width:150px"></select>
					</td>
					<td>
						<s:submit value="提交" />
					</td>

				</tr>
			</table>
		</s:form>
		<br>
		<s:form name="configform" action="RoleFunctionAction!multipleconfig.action" method="post">
			    <input type="hidden" name="rolename" value="<s:property value="rolename"/>"/>
				<table border="1" id="mytable" style="border-collapse: collapse">
					<tr
						style="background-image: url('<%=basePath%>images/titlebg.gif')">
						<td align="center" width="100">
							功能ID
						</td>
						<td align="center" width="100">
							功能名称
						</td>
						<td align="center" width="100">
							父功能ID
						</td>
						<td align="center" width="100">
							子系统名称
						</td>
						<td align="center" width="150">
							功能标识(是否常用)
						</td>
						<td align="center" width="100">
							URL
						</td>
						<td align="center" width="100">
							多选
						</td>
					</tr>
					<s:iterator value="functionlist">
						<tr>
							<td align="center">
								<s:property value="FFunctionId" />
							</td>
							<td align="center">
								<s:property value="FFunctionName" />
							</td>
							<td align="center">
								<s:property value="FSuperFunctionId" />
							</td>
							<td align="center">
								<s:property value="mhqxTabModule.FModuleName" />
							</td>
							<td align="center">
								<s:property value="FFunctionMark" />
							</td>
							<td align="center">
								<s:property value="FFilePath" />
							</td>
							<td align="center">
								<input type="checkbox" name="deletelist" value="${FFunctionId }" checked="checked"/>
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td colspan="5" align="center">
							<center>
								<a
									href='<s:url action="FunctionAction!rolefunctionconfiglist.action"> <s:param name="p" value="1"></s:param></s:url>'>首页</a>
								<a
									href='<s:url action="FunctionAction!rolefunctionconfiglist.action"> <s:param name="p" value="%{p-1}"></s:param></s:url>'>上一页</a>
								<a
									href='<s:url action="FunctionAction!rolefunctionconfiglist.action"> <s:param name="p" value="%{p+1}"></s:param></s:url>'>下一页</a>
								<a
									href='<s:url action="FunctionAction!rolefunctionconfiglist.action"> <s:param name="p" value="lastPage"></s:param></s:url>'>最后</a>
							    第<s:property value="p"/>页/共<s:property value="lastPage"/>页
							</center>
						</td>
						<td colspan="2">
							<input type="button" value="全选" onclick="selectAll()" />
							<input type="button" value="反选" onclick="unSelectAll()" />
						</td>
					</tr>
				</table>
				<table>

					<tr>
						<td>
						  <input type="submit"  value="确定" />
                        </td>					
				    </tr>
				</table>
			</s:form>
   </fieldset>
   </center> 
	</body>
</html>
