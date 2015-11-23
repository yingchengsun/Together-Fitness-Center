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

<body background="../SubSystemImage/Background.png">
<div align="center">
   <img src="<%=basePath %>7_yjssx_system/SubSystemImage/selectTutor.png" height="75" />
   <table width="100%" border="0" style="margin-top: 20px;background-image: url('<%=basePath %>          7_yjssx_system/SubSystemImage/ddown01[1].gif')">
      <tr>
        <td width="100%" height="26"><div align="center">高级搜索</div></td>
      </tr>
  </table>
   <fieldset  style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/login_bg.gif')">
       <legend><img src="<%=basePath %>7_yjssx_system/SubSystemImage/search.png" height="50"/></legend>
       <form action="yjssxAdmin/AdminReleaseNotice!adminNoticeToSbSearch.action" method="post">
         <input type="hidden" name="type" value="导师"/>
         <table width="100%">
                <tr>
				    <td width="50%" align="right">
				    		名称：
							<select name="tutorName">
								<option>--请选择--</option>
							 	<s:iterator value="teacherList">
		      						<option value="${FTeacherName }">${FTeacherName }</option>
		      					</s:iterator>
							</select>
							&nbsp;&nbsp;&nbsp;
				  </td>
				  <td width="50%" align="left">
				  	&nbsp;&nbsp;&nbsp;<input type="submit" value="点击搜索" />
				  </td>
				</tr>           
        </table>
	   </form>
   </fieldset>
  <form action="yjssxAdmin/AdminReleaseNotice!noticeTo.action" method="post">
     <input type="hidden" name="type" value="${type }"/>
	 <table width="100%" border="1" style="border-collapse:collapse">
	    <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
	      <th>编号</th>
	      <th><div align="center"><strong>选择</strong></div></th>
	      <th><div align="center"><strong>姓名</strong></div></th>
	      <th><div align="center"><strong>姓别</strong></div></th>
	      <th><div align="center"><strong>籍贯</strong></div></th>
	      <th><div align="center"><strong>地址</strong></div></th>
	      <th><div align="center"><strong>职称</strong></div></th>
	      <th><div align="center"><strong>职位</strong></div></th>
	      <th><div align="center"><strong>研究方向</strong></div></th>
	      <th><div align="center"><strong>电话</strong></div></th>
	      <th><div align="center"><strong>手机</strong></div></th>
	      <th><div align="center"><strong>邮箱</strong></div></th>
	      <th><div align="center"><strong>查看详情</strong></div></th>
	    </tr>
	    <s:if test="thesisList.size==0">
			<tr>
				<td>对不起暂无数据！！！</td>
			</tr>
		</s:if>
	    <s:else>
		    <s:iterator value="teacher" status="status">
		    <tr>
		      <td align="center" height="24"><s:property value="#status.count" /></td>
		      <td align="center"><input type="checkbox" name="noticeId" value="${FTeacherNumber }"/></td>
		      <td align="center"><img src="<%=basePath %>7_yjssx_system/SubSystemImage/xuesheng.gif" />&nbsp;${FTeacherName }</td>
		      <td align="center">${FTeacherSex }</td>
		      <td align="center">${FTeacherNativeplace }</td>
		      <td align="center">${FTeacherAddress }</td>
		      <td align="center">${FTeacherZhiCheng }</td>
		      <td align="center">${FTeacherPosition }</td>
		      <td align="center">${FTeacherResearch }</td>
		      <td align="center">${FTeacherTel }</td>
		      <td align="center">${FTeacherPhone }</td>
		      <td align="center">${FTeacherEmail }</td>
		      <td align="center"><div align="center">
		      <img src="<%=basePath %>7_yjssx_system/SubSystemImage/edit_profile.gif" height="15"/>
		      <a href="<%=basePath %>yjssxCommon/CommonOperation!findTutorInfo.action?tutorId=${FTeacherNumber}" class="STYLE5">点击查看基本信息</a></div></td>    
		    </tr>
		   </s:iterator>
		   <tr style="background-image: url('<%=basePath %>7_yjssx_system/SubSystemImage/titlebg.gif')">
		      <td ><div align="center"><input type="button" value="全选" onclick="selectAll()" /></div></td>
		      <td ><div align="center"><input type="button" value="反选" onclick="unSelectAll()" /></div></td>
		      <td ><div align="center"><input type="submit" value=发送通知" /></div></td>
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
</div>
</body>
</html>
