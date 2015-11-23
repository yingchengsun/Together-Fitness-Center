<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css.css" rel="stylesheet" type="text/css" />
</head>
<script language="javascript">
function fetch_object(idname)
{
 var my_obj = document.getElementById(idname);
 return my_obj;
}
function showfun(i)
{
var subfun_list = fetch_object("subfun_list"+i)
var funlist = fetch_object("fun_list"+i);
if(subfun_list.style.display == "none")
	{
	subfun_list.style.display = "block";
	funlist.style.background="url(../images/funlist_bar2.gif)";
	}
	else
	{
	subfun_list.style.display = "none";
	funlist.style.background="url(../images/funlist_bar1.gif)";
	}
}
</script>
<body style="background:#ffffff">

				<!--start of function_Part  -->
				<div>
				        <!--start of PIpart  -->
				<div>
				        <div style="height: 30px; width: 218px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;个&nbsp;人&nbsp;信&nbsp;息
						</div><div style="float:right"><img src="../images/edit_profile.gif" />
						<a href="" class="LINK21"> 编辑资料</a></div>
				        </div>
					<div >
						<div style="padding-top: 0px; padding-left: 20px; height: 120px; width: 215px;background-image:url(./images/bg.gif)">
							<div>
								姓名：
								<label>
									<a href="" class="LINK21">林若雪</a> 
								</label>
							</div>
							<div style="height: 20px; padding-top: 6px;">
								性别：
								<label>
									女
								</label>
							</div>
							<div style="height: 20px; padding-top: 6px;">
								家乡：
								<label>
									<a href="" class="LINK21">浙江</a> 省&nbsp
									<a href="" class="LINK21">台州</a> 市
								</label>
							</div>
							<div style="height: 20px; padding-top: 6px;">
								年级：
								 <label>
										<a href="" class="LINK21">大一</a>
									</label> 
							</div>
							<div style="height: 20px; padding-top: 6px;">
								角色：
								<a href="" class="LINK21">. 班干部</a>
								<a href="" class="LINK21">. 助教</a>
							</div>
						</div>
					</div>
				</div>
				<!--end of PIpart  -->
				 <div style="height: 30px; width: 218px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;角&nbsp;色&nbsp;职&nbsp;能
						</div><div style="float:right"><img src="../images/edit_profile.gif" />
						<a href="" class="LINK21"> 管理菜单</a></div>
				        </div>
					<div class="PI_main" style="height: 500px">
						<div >
							<div class="fun_list" id="fun_list1" onclick="javasrcipt:showfun(1)" >
								<label > 班 干 部 </label>
							</div>
							<div class="subfun_list" id="subfun_list1" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能1</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能2</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能3</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能4</a>
								</div>
							</div>
							<div class="fun_list" id="fun_list2" onclick="javasrcipt:showfun(2)" >
								<label >&nbsp;&nbsp; 助 教 </label>
							</div>
							<div class="subfun_list" id="subfun_list2" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能1</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能2</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能3</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能4</a>
								</div>
							</div>
							
							
							
							
						</div>
					</div>
				</div>
				<!--end of function_Part  -->
</body>
</html>