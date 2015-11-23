<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>选题查询</title>

		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/css.css">
		<link rel="stylesheet" type="text/css"
			href="<%=request.getContextPath()%>/bksx/css/mycss.css">
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/TableColor.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/jquery-1.4.2.js"></script>
		<script language="javascript"
			src="<%=request.getContextPath()%>/bksx/js/FormValid.js"></script>
		<script language="javascript" type="text/javascript">
		function ale()
    {
         alert("已选择，请等待结果！");
    }  
	
	 $(document).ready(function(){
	
	$(".accordion2 h5").eq(2).addClass("active");
	$(".accordion2 p").eq(2).show();
	$(".accordion2 h5").click(function(){
		$(this).next("p").slideToggle("slow")
		.siblings("p:visible").slideUp("slow");
		$(this).toggleClass("active");
		$(this).siblings("h5").removeClass("active");
	});

   });
	</script>
	</head>

	<body>
		<br>
		<br>
		<h3 align="center">
			<img src="<%=request.getContextPath()%>/bksx/pictures/56461.png"
				width="50" height="50" align="middle" />
			在线选题
		</h3>

		<hr>
		<c:choose>
			<c:when test="${showAvaliable=='Y' }">
				<div align="center">
					<ul>
						<li>
							<form
								action="<%=request.getContextPath()%>/showAvalibleSubjectByAttribute.action"
								method="post" onsubmit="return validator(this)">
								<font size="2">精确查找</font>
								<select name="attributeType">
									<option value="FSubjectName">
										-------课题名称------
									</option>
									<option value="FTeacherName">
										-------导师姓名------
									</option>
									<option value="FLevel">
										---难度等级(A/B/C)---
									</option>
								</select>
								<input type="text" name="attribute" valid="required"
									errmsg="请输入查询条件！" />
								<input type="submit" value="搜索">
							</form>
						</li>
						<li>
							<form
								action="<%=request.getContextPath()%>/showAvalibleSubjectByCategory.action"
								method="post">
								<font size="2">快速查找</font>
								<select name="substuguiCategory">
									<option value="FIsResearch" selected="selected">
										------科研------------
									</option>
									<option value="FIsSimulation">
										------模拟------------
									</option>
									<option value="FIsLab">
										------实验室建设-----
									</option>
									<option value="FIsOthers">
										------其他------------
									</option>
								</select>
								<input type="submit" value="     快速搜索信息    " />
							</form>
						</li>
					</ul>
				</div>
				<hr>
				<c:if test="${not empty subjectList }">
					<div align="center" class="accordion2">
						<table border="1" cellspacing="0" id="mytable" width="98%">
							<tr>
								<th colspan="18"
									background="<%=request.getContextPath()%>/bksx/pictures/bluebar.gif"
									height="30">
									毕业设计选题信息
								</th>
							</tr>
							<tr>
								<th>
									序号
								</th>
								<th>
									课题名称
								</th>
								<th>
									课题性质
								</th>
								<th>
									课题来源
								</th>
								<th>
									难度等级
								</th>
								<th>
									题目作者
								</th>
								<th>
									作者职称
								</th>
								<th>
									工作地点
								</th>
								<th>
									选题
								</th>
							</tr>
							<c:forEach items="${subjectList }" var="substugui">
								<tr>
									<td>
										${substugui.FSubStuGuiId }
									</td>
									<td>
										${substugui.FSubjectName }
									</td>
									<td>
										<c:if test="${substugui.FIsSoftware=='Y' }">软件项目</c:if>
										<c:if test="${substugui.FIsHardware=='Y' }">硬件项目</c:if>
										<c:if test="${substugui.FIsSoftHard=='Y' }">软硬结合</c:if>
										<c:if test="${substugui.FIsDocument=='Y' }">文献综述</c:if>
									</td>
									<td>
										<c:if test="${substugui.FIsResearch=='Y' }">科研项目</c:if>
										<c:if test="${substugui.FIsSimulation=='Y' }">模拟项目</c:if>
										<c:if test="${substugui.FIsLab=='Y' }">实验室建设</c:if>
										<c:if test="${substugui.FIsOthers=='Y' }">其他类别</c:if>
									</td>
									<td>
										${substugui.FLevel }
									</td>
									<td>
										${substugui.FTeacherName }
									</td>
									<td>
										${substugui.FTeacherDegreen }
									</td>
									<td>
										${substugui.FWorkPlace }
									</td>
									<td>
										<a
											href="<%=request.getContextPath()%>/chooseSubject.action?id=${substugui.FSubStuGuiId }"
											onclick="ale()"><img
												src="<%=request.getContextPath()%>/bksx/pictures/edit.gif"
												border="0" width="15" height="15" /> </a>
									</td>
								</tr>
								<tr>
									<td colspan="9">
										<h5>
											<img src="<%=request.getContextPath()%>/bksx/pictures/1.gif"
												align="top" />
											打开/关闭详细信息
										</h5>
										<p>
											${substugui.FSubjectDescription }
										</p>
									</td>
								</tr>
							</c:forEach>
						</table>
						<c:if test="${all=='Y' }">
							<table width="40%">
								<tr>
									<td>
										<div align="center">
											<a
												href="<%=request.getContextPath()%>/getAvilableSubject.action?p=1">首页</a>
										</div>
									</td>
									<td>
										<div align="center">
											<a
												href="<%=request.getContextPath()%>/getAvilableSubject.action?p=${p-1}">上一页</a>
										</div>
									</td>
									<td>
										<div align="center">
											<a
												href="<%=request.getContextPath()%>/getAvilableSubject.action?p=${p+1}">下一页</a>
										</div>
									</td>
									<td>
										<div align="center">
											<a
												href="<%=request.getContextPath()%>/getAvilableSubject.action?p=${lastPage}">末页</a>
										</div>
									</td>
								</tr>
							</table>
						</c:if>
					</div>
				</c:if>
				<c:if test="${empty subjectList }">
					<div align="center">
						<table border="1" cellspacing="0" width="98%">
							<tr>
								<td>
									<br>
									<br>
									<img
										src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
									<br>
									没有符合查询条件的课题信息!
									<br>
									<br>
									<br>
								</td>
							</tr>
						</table>
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<div align="center">
					<table border="1" cellspacing="0" width="98%">
						<tr>
							<td>
								<br>
								<br>
								<img
									src="<%=request.getContextPath()%>/bksx/pictures/MinIcons_001.png" />
								<br>
								敬告: 目前已存在你的选题信息，请勿重复选题
								<br>
								<br>
								<br>
							</td>
						</tr>
					</table>
				</div>

			</c:otherwise>
		</c:choose>
		<br>
		<br>

	</body>
</html>
