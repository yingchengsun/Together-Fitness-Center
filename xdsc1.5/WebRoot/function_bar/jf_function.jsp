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
					    <div style="height: 30px; width: 218px;" class="NewsTitle3 title1">
						<div style="float: left; padding-top: 5px">
							&nbsp;课&nbsp;程&nbsp;教&nbsp;辅
						</div><div style="float:right"><img src="../images/edit_profile.gif" />
						<a href="" class="LINK21"> 管理菜单</a></div>
				        </div>
					<!--start of PI_main  -->
					<!--end of PI_main  -->
					<div class="PI_main" style="height: 500px">
						<div >
							<div class="fun_list" id="fun_list1" onclick="javasrcipt:showfun(1)" >
								<label > 课 程 管 理 </label>
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
								<label > 教 学 管 理 </label>
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
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 作 业 管 理</label>
							</div>
							<div class="subfun_list" id="subfun_list3" >
							<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能3</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能4</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能5</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame"> 功能6</a>
								</div>
							</div>
							<div class="fun_list" id="fun_list4" onclick="javasrcipt:showfun(4)">
								<label > 资 源 管 理 </label>
							</div>
							<div class="subfun_list" id="subfun_list4" >
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