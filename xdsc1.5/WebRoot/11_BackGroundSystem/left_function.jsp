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


					<!--start of PI_main  -->
					<!--end of PI_main  -->
					<div class="PI_main" style="height: auto">
						<div >
						
						
							<div class="fun_list" id="fun_list1" onClick="javasrcipt:showfun(1)" >
								<label > 门 户 管 理 </label>
							</div>
							<div class="subfun_list" id="subfun_list1" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="NewsManagement.jsp" class="LINK21" target="mainFrame"> 新闻管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="BulletinManagement.jsp" class="LINK21" target="mainFrame">公告管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="NoticeManagement.jsp" class="LINK21" target="mainFrame"> 通知管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="LinkManagement.jsp" class="LINK21" target="mainFrame">友情链接管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="NavigationManagement.jsp" class="LINK21" target="mainFrame">导航管理</a>
								</div>
							</div>
							
							
							<div class="fun_list" id="fun_list2" onClick="javasrcipt:showfun(2)" >
								<label >学 生 管 理</label>
							</div>
							<div class="subfun_list" id="subfun_list2" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../SutdentManagement/StudentinfoManagement.jsp" class="LINK21" 
									         target="mainFrame">学生信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../SutdentManagement/ActivityManagement.jsp" class="LINK21" 
									         target="mainFrame">学生活动记录</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../SutdentManagement/PrincipleManagement.jsp" class="LINK21" 
									         target="mainFrame"> 规章制度管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../SutdentManagement/PartyinfoManagement.jsp" class="LINK21" 
									    target="mainFrame"> 党建工作信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../SutdentManagement/ShowstudentManagement.jsp" class="LINK21" 
									target="mainFrame"> 学生风采</a>
								</div>	
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../SutdentManagement/StudenttrackManagement.jsp" class="LINK21"
									target="mainFrame"> 校友追踪</a>
								</div>																
							</div>
							
							
							<div class="fun_list" id="fun_list3" onClick="javasrcipt:showfun(3)">
								<label > 本科生实习管理</label>
							</div>
							<div class="subfun_list" id="subfun_list3" >
							<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../PostGraduateStudentAppliment/TitleManagement.jsp" class="LINK21"
									 target="mainFrame"> 毕设题目管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../PostGraduateStudentAppliment/ArtitleManagement.jsp" class="LINK21"
									 target="mainFrame"> 毕设论文管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../PostGraduateStudentAppliment/DesignmarksManagement.jsp" class="LINK21" 
									target="mainFrame"> 毕设成绩管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../PostGraduateStudentAppliment/ShixuninfoManagement.jsp" class="LINK21" 
									target="mainFrame"> 实训信息管理</a>
								</div>
								
							</div>
							
							
							<div class="fun_list" id="fun_list4" onClick="javasrcipt:showfun(4)">
								<label > 研究生实习管理 </label>
							</div>
							<div class="subfun_list" id="subfun_list4" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateStudentAppliment/SchoolTTeacher.jsp" class="LINK21" 
									target="mainFrame"> 校内导师信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateStudentAppliment/CompanyTTeacher.jsp" class="LINK21" target=
									"mainFrame"> 企业导师信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateStudentAppliment/CompanyIInfo.jsp" class="LINK21" 
									target="mainFrame"> 企业信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateStudentAppliment/ArticleManagement.jsp" class="LINK21"
									 target="mainFrame"> 毕设管理</a>
								</div>
								
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateStudentAppliment/TTSRalation.jsp" class="LINK21"
									 target="mainFrame"> 学生导师对应信息管理</a>
								</div>
								
							</div>
							
							
							<div class="fun_list" id="fun_list5" onClick="javasrcipt:showfun(5)" >
								<label > 教 辅 管 理 </label>
							</div>
							<div class="subfun_list" id="subfun_list5" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../TeachingAsistant/ConfigureCourse.jsp" class="LINK21" 
									target="mainFrame"> 配置教师课程</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame">助教管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../index.jsp" class="LINK21" target="mainFrame">学生分配</a>
								</div>
							</div>
							
							<div class="fun_list" id="fun_list6" onClick="javasrcipt:showfun(6)" >
								<label >工程硕士报名管理 </label>
							</div>
							<div class="subfun_list" id="subfun_list6" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateSignup/ReleaseInfo.jsp" class="LINK21" 
									target="mainFrame"> 招生信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateSignup/StudentInfo.jsp" class="LINK21" 
									target="mainFrame">考生信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../GraduateSignup/MessageManagment.jsp" class="LINK21" 
									target="mainFrame">留言管理</a>
								</div>
							</div>
							
							<div class="fun_list" id="fun_list7" onClick="javasrcipt:showfun(7)" >
								<label >实践教学管理 </label>
							</div>
							<div class="subfun_list" id="subfun_list7" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ExperimentTeaching/ExperimentManagement.jsp" class="LINK21" 
									target="mainFrame"> 实验安排</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ExperimentTeaching/CheckAttend.jsp" class="LINK21" target="mainFrame"> 查看出勤</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ExperimentTeaching/CheckPCBookCondition.jsp" class="LINK21" target="mainFrame"> 预定机位</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ExperimentTeaching/EquipmentManagement.jsp" class="LINK21" target="mainFrame"> 设备管理</a>
								</div>
							</div>
							
							<div class="fun_list" id="fun_list8" onClick="javasrcipt:showfun(8)" >
								<label >论坛管理 </label>
							</div>
							<div class="subfun_list" id="subfun_list8" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ForumManagement/UserManagement.jsp" class="LINK21" target="mainFrame"> 生成论坛</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ForumManagement/TieManagement.jsp" class="LINK21" target="mainFrame"> 管理贴子</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ForumManagement/CommentManagement.jsp" class="LINK21" target="mainFrame"> 管理评论</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ForumManagement/UserManagement.jsp" class="LINK21" 
									target="mainFrame"> 管理账号</a>
								</div>
							</div>
							<div class="fun_list" id="fun_list9" onClick="javasrcipt:showfun(9)" >
								<label >信息反馈管理 </label>
							</div>
							<div class="subfun_list" id="subfun_list9" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../StudentInfoCollection/PostGraduateStudentInfoCollection.jsp" class="LINK21" target="mainFrame">本科生反馈信息管理</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../StudentInfoCollection/GraduateStudentInfoCollection.jsp" class="LINK21" target="mainFrame"> 研究生反馈信息管理</a>
								</div>
							</div>	
							
								
							<div class="fun_list" id="fun_list10" onClick="javasrcipt:showfun(10)" >
								<label >权限管理 </label>
							</div>
							<div class="subfun_list" id="subfun_list10" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ManagerManagement/ManagerConfig.jsp" class="LINK21" 
									target="mainFrame">人员权限配置</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ManagerManagement/fuctionedit.jsp" class="LINK21" 
									target="mainFrame">子系统功能配置</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ManagerManagement/AccessManagement.jsp" class="LINK21" 
									target="mainFrame">数据库访问权限的配置</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
									<a href="../ManagerManagement/UserAssignmentToSubsystem.jsp" class="LINK21" 
									target="mainFrame">子系统访问数据库权限的配置</a>
								</div>
								
							</div>		
							
							
							<div class="fun_list" id="fun_list11" onClick="javasrcipt:showfun(11)" >
								<label >系统管理维护</label>
							</div>
							<div class="subfun_list" id="subfun_list11" >
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
								<a href="../SystemSupport/DataBackup.jsp" class="LINK21" target="mainFrame">历史数据备份导出</a>
								</div>
								<div style="background-Image: url(../images/funlist_bar3.gif);height:22px">
								<a href="../SystemSupport/DataBackup.jsp" class="LINK21" target="mainFrame">历史数据导入</a>
								</div>

							</div>				
						</div>
					</div>
				   
				<!--end of function_Part  -->
</body>
</html>