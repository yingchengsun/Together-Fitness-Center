<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

body {
	font-family: arial, 宋体, serif;
	font-size:12px;
	background-image:url("../Pictures/newbackground.png");
}

.fun_list {
	FONT-WEIGHT: bold;
	background-image: url('../Pictures/newnavagate.JPG');
	background-repeat: no-repeat;
	padding-left: 29px;
	padding-top: 4px;
}

.fun_list label {
	color: white;
	font-size: 15px;
	font-style:normal;
	padding-left: 20px;
}

*{margin:0;padding:0;border:0;}

#nav {
	width:180px;
    line-height: 24px; 
	list-style-type: none;
	text-align:left;
    /*定义整个ul菜单的行高和背景色*/
}
#nav a {
	width: 125px; 
	display: block;
	padding-left:60px;
	/*Width(一定要)，否则下面的Li会变形*/
}

#nav li {
background:white; 
background-image:url("../Pictures/new_login_bg.gif");
border-bottom:#FFF 1px solid; /*下面的一条白边*/
float:left;
	/*float：left,本不应该设置，但由于在Firefox不能正常显示
	继承Nav的width,限制宽度，li自动向下延伸*/
}

#nav li a:hover{
	background:#c4e1ff;	/*一级目录onMouseOver显示的背景色*/
	text-decoration:none;font-weight:bold;
}
#nav li a:link  {
	color:#666; text-decoration:none;
}
#nav li a:visited  {
	color:#666;text-decoration:none;
}

#PARENT{
	width:180px;
	left:20px;
	
	border: 1px solid gray;
	
}
</style>
</head>
<body>

				
				<div>
					<div class="PI_main" style="height: 500px">
						<div style="position: relative;top: 5%;">
						<div class="fun_list" id="fun_list1" >
								<label> 学 生 信 息 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="GradeList.jsp/getGradeList.action" target="right">年级学生信息</a></li>
									<li><a href="ClassList.jsp/getClassList.action" target="right">班级学生信息</a></li>
									<li><a href="Undergraduate.jsp/getUndergraduateList.action" target="right">本科生信息</a></li>
									<li><a href="Poatgraduate.jsp/getPostgraduateList.action" target="right">研究生信息</a></li>
									<li><a href="Poatgraduate.jsp/getParentList.action" target="right">学生家长信息</a></li>
								</ul>
							</div>
							
							<div style="
								width:160px;
								height: 3px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list1" >
								<label> 班 级 工 作 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
								<li><a href="Party.jsp/showPartyList.action" target="right">学生党建</a></li>
									<li><a href="Attendance.jsp/showTotalAttendanceList.action" target="right">学生考勤</a></li>
									<li><a href="Fee.jsp/getMStudentList.action" target="right">缴费情况</a></li>
									<li><a href="Fund.jsp/getFundList.action" target="right">资助及奖学金</a></li>
								</ul>
							</div>
							<div style="
								width:160px;
								height: 3px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list2" >
								<label> 学 生 组 织 </label>
							</div>
							<div id="PARENT">
								<ul id="nav">
								<li><a href="Orgnization.jsp/getDepartmentList.action" target="right"> 学生组织</a></li>
									
								</ul>
							</div>
							<div style="
								width:160px;
								height: 5px;
								background: white;
							"></div>
							<div class="fun_list" id="fun_list3" onclick="javasrcipt:showfun(3)">
								<label > 校 友 追 踪</label>
							</div>
							<div id="PARENT">
								<ul id="nav">
									<li><a href="SchFellow.jsp/getMXStudentList.action"  target="right"> 校友信息</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			
			
</body>
</html>