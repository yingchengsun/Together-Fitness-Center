
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" errorPage="/errorPage.jsp"%>
<%@ page import="com.xdsc.model.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath %>1_mhqx/admin/css/css.css" rel="stylesheet" type="text/css" />

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
    		 	 if(objs[i].type.toLowerCase()== "checkbox" )            
                    objs[i].checked = false;
    		}
    	}

    	
</script>
<body>
<form action="Navigation_search.action" method="post">
<table width="695" border="1" align="center" style="margin-top:20px">
<tr>
					<th align="center" colspan="7" background="<%=basePath%>1_mhqx/admin/images/newmenubg.gif" height="25">
						<font color="#FFFFFF" size="3">友情链接</font>
					</th>
</tr>
  <tr>
    <th scope="col">
	    <div align="left">查询友情链接名称：
	      <label>
	      <input name="textfield" type="text" value="请输入友情链接名称" size="19" />
	      </label>
	      &nbsp;&nbsp;<input type="submit" name="Submit42" value="提交" />
	      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      <a href="/houtai/1_mhqx/admin/Link/link_add.jsp" >添加友情链接</a>
	      
	      
	      </div>
      </th>
  </tr>
</table>
</form>
<form action="Navigation_delInfo.action" method="POST">
<table width="695" border="1" align="center">

  <tr>
    <th width="37" >序号</th>
    <th width="130" >友情连接名称</th>
    <th width="110" >连接地址</th>
     <th width="60" >优先级</th>
     <th width="50" >编辑</th>
     <th width="50" >删除</th>
     <th width="50" >选择</th>
  </tr>
  <%
  	List<MhqxTabLink> tllist = (List<MhqxTabLink>)request.getAttribute("Tl");
         String bgcolor="3D99A5";
        for(int i=0;i<tllist.size();i++)
        {
        	MhqxTabLink tli = (MhqxTabLink)tllist.get(i);
          if(i%2==0){bgcolor="#CCCCCC";}
          else{bgcolor="#FFFFFF";}
       out.println("<tr>");
       out.println(" <td width='\"'37'\"' bgcolor="+'\"'+bgcolor+'\"'+">"+tli.getFLinkId()+"</td>");
       out.println(" <td width='\"'110'\"' bgcolor="+'\"'+bgcolor+'\"'+">"+tli.getFLinkTitle()+"</td>");
       out.println(" <td width='\"'110'\"' bgcolor="+'\"'+bgcolor+'\"'+">"+tli.getFLinkUrl()+"</td>");
       out.println(" <td width='\"'37'\"' bgcolor="+'\"'+bgcolor+'\"'+">"+tli.getFLinkPriority()+"</td>");
       out.println(" <td width='\"'37'\"' bgcolor="+'\"'+bgcolor+'\"'+"><a href='Link_update.action?id="+tli.getFLinkId()+"'>编辑</td>");
       out.println(" <td width='\"'37'\"' bgcolor="+'\"'+bgcolor+'\"'+">"+"<a href='Link_delete.action?id="+tli.getFLinkId()+"'>删除</td>");
       out.println(" <td width='\"'37'\"' bgcolor="+'\"'+bgcolor+'\"'+">"+"<input type="+'\"'+"checkbox"+'\"'+"></td>");
       out.println("</tr>");
       }
  %>
</table>
<table width="695" border="1" align="center">
  <tr>
    <th scope="col"><div align="left">
      <label>
      <input type="button" value="全选" onclick="selectAll()" />
      </label>
     
      <label>
      <input type="button" value="反选" onclick="unSelectAll()" />
      </label>
      <label>
      <input type="submit" value="删除"  />
      </label>
      
      
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="Navigation_list.action?current_page=1" >首页</a>
    <%
   		int current=Integer.parseInt(request.getAttribute("current_page").toString());
    		if(request.getParameter("current_page")!=null){
        		current=Integer.parseInt(request.getParameter("current_page").toString());
    		}   
     %>
    <a href=
    <%
    if(current==1){
    out.print("\'"+"link.action?current_page="+current+"\'");
    }else{
    out.print("\'"+"link.action?current_page="+(current-1)+"\'");
    }
    %> 
    
    >上一页</a>
     <a href=
    <%
    int list_size=Integer.parseInt(request.getAttribute("list_size").toString());
    
    if(current>=list_size){
    out.print("\'"+"link.action?current_page="+list_size+"\'");
    current=list_size;
    }else{
    out.print("\'"+"link.action?current_page="+(current+1)+"\'");
    }
    %> 
    
    >下一页</a>
     <a href= 
     <%
    out.print("\'"+"link.action?current_page="+list_size+"\'");
    %> 
    >尾页</a>
     </div></th>
  </tr>
</table>
</form>
</body>
  