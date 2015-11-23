<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>本科实习管理系统</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bksx/css/css.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bksx/css/mycss.css" />
	</head>

	<body>
		<%
			session.invalidate();
		%>
		<div align="left">
			<table width="800" align="center" style="border-collapse: collapse">
				<tr>
					<th height="160" colspan="2" width="100%">
						<img src="<%=request.getContextPath() %>/bksx/pictures/top.jpg" height="100%" />
					</th>
				</tr>
				<tr>
					<th colspan="2">
						<table width="100%" height="30" align="center">
							<tr>
								<td height="30" align="center" valign="middle" width="100%"
									background="<%=request.getContextPath() %>/bksx/pictures/bluebar.gif">
									<span class="STYLE35">| <a href="index.jsp"><font
											color="#ECECFF">首 页</font> </a> |&nbsp; <a
										href="<%=request.getContextPath() %>/admin/welcome.jsp"><font color="#ECECFF">毕业设计管理系统</font>
									</a> |&nbsp; <a href="index.jsp"><font color="#ECECFF">本科实训管理系统</font>
									</a> |&nbsp;<a href="index.jsp"> <font color="#ECECFF">退出</font>
									</a> </span>
									<!--顶部链接-->
								</td>
							</tr>
						</table>
					</th>
				</tr>
				<tr valign="top">
					<td width="25%">
						<!-- 登陆-->
						<form action="<%=request.getContextPath()%>/userLogin.action"
							method="post">
							<table width="100%" height="130"
								background="<%=request.getContextPath() %>/bksx/pictures/loginbg.gif">
								<tr>
									<td colspan="2">
										<img src="<%=request.getContextPath() %>/bksx/pictures/loginbar.gif" width="100%" />
									<td>
								</tr>
								<tr>
									<td>
										<div align="center">
											用户名：
											<br />
										</div>
									</td>
									<td>
										<div align="center">
											<input type="text" name="username" size="15" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div align="center">
											密&nbsp;&nbsp;&nbsp;码：
										</div>
									</td>
									<td>
										<div align="center">
											<input type="password" name="password" size="15" />
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="radio" name="role" value="student"
											checked="checked" />
										学生
										<input type="radio" name="role" value="teacher" />
										教师
										<input type="radio" name="role" value="manager" />
										管理员
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="登陆">
									</td>
								</tr>
							</table>
						</form>
						<!-- 实习相关-->
						<table width="100%" height="130"
							background="<%=request.getContextPath() %>/bksx/pictures/loginbg.gif">
							<tr>
								<td>
									<img src="<%=request.getContextPath() %>/bksx/<%=request.getContextPath() %>/bksx/pictures/shixi.gif" width="100%" />
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<img src="<%=request.getContextPath() %>/bksx/pictures/lamp.gif" />
										<a href="detail.php?id=2907"> 实习相关政策 </a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<img src="<%=request.getContextPath() %>/bksx/pictures/lamp.gif" />
										<a href="detail.php?id=2907"> 实习资料下载 </a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<img src="<%=request.getContextPath() %>/bksx/pictures/lamp.gif" />
										<a href="detail.php?id=2907"> 实习管理制度</a>
									</div>
								</td>
							</tr>
						</table>
						<!-- 走进企业-->
						<table width="100%" height="130"
							background="<%=request.getContextPath() %>/bksx/pictures/loginbg.gif">
							<tr>
								<td>
									<img src="<%=request.getContextPath() %>/bksx/pictures/gotocom.gif" width="100%" />
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<img src="<%=request.getContextPath() %>/bksx/pictures/people.gif" />
										<a
											href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">企业生活</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<img src="<%=request.getContextPath() %>/bksx/pictures/people.gif" />
										<a
											href="javascript:__doPostBack('DisplayInformation1$btnSeeMore3','')">企业文化</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center">
										<img src="<%=request.getContextPath() %>/bksx/pictures/people.gif" />
										<a href="DisplayDetails.aspx?id=581">人才培养</a>
									</div>
								</td>
							</tr>
						</table>
						<!-- 友情链接-->
						<table width="100%" height="130"
							background="<%=request.getContextPath() %>/bksx/pictures/loginbg.gif">
							<tr>
								<td>
									<img src="<%=request.getContextPath() %>/bksx/pictures/friendly.gif" width="100%" />
								</td>
							</tr>
							<tr>
								<td>
									<div align="center" class="STYLE29">
										<img src="<%=request.getContextPath() %>/bksx/pictures/redpoint.gif" />
										<a href="detail.php?id=2907" class="a_blue"> 友情链接一 </a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center" class="STYLE29">
										<img src="<%=request.getContextPath() %>/bksx/pictures/yellowpoint.gif" />
										<a href="detail.php?id=2907" class="a_blue"> 友情链接二 </a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center" class="STYLE29">
										<img src="<%=request.getContextPath() %>/bksx/pictures/greenpoint.gif" width="10" height="12" />
										<a href="detail.php?id=2907" class="a_blue"> 友情链接三 </a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align="center" class="STYLE29">
										<img src="<%=request.getContextPath() %>/bksx/pictures/redpoint.gif" />
										<a href="detail.php?id=2907" class="a_blue"> 友情链接四 </a>
									</div>
								</td>
							</tr>
						</table>
					</td>
					<td width="559" align="center" valign="top">
						<table cellpadding="0" cellspacing="0" width="525"
							background="<%=request.getContextPath() %>/bksx/pictures/bg.gif">
							<tr valign="top">
								<td width="523" valign="top">
									<table width="610" bordercolor="#0033CC"
										style="border-collapse: collapse;">
										<tr valign=top>
											<td width="507" valign=top>
												<div id="DisplayInformation1_Panel2" class="dctNoBorder"
													style="font-size: 16px;">
													<fieldset>
														<legend bordercolor="#0033CC">
															<img src="<%=request.getContextPath() %>/bksx/pictures/shixun.gif" />
														</legend>
														<table width="610" height="157">
															<tr bgcolor="#FFFFFF">
																<td width=500>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/bubble.gif" width="17"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=581">北京无限缘信息科技有限公司招聘</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td width="110">
																	<div align="left">
																		<span id="DisplayInformation1_rbt1__ctl0_lblNewsDate1">2009-6-10</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/bubble.gif" width="17"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=581"></a><a
																			href="DisplayDetails.aspx?id=561">科派特信息技术（北京）有限公司招聘实习生</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt1__ctl1_lblNewsDate1">2009-6-18</span>
																	</div>
																</td>
															</tr>
															<tr bgcolor="#FFFFFF">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/bubble.gif" width="17"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=581"></a><a
																			href="DisplayDetails.aspx?id=521">亚信集团股份有限公司</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt1__ctl2_lblNewsDate1">2009-4-16</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/bubble.gif" width="17"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=581"></a><a
																			href="DisplayDetails.aspx?id=462">Platform技术支持工程师岗位</a>
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt1__ctl3_lblNewsDate1">2009-3-19</span>
																	</div>
																</td>
															</tr>
															<tr bgcolor="#FFFFFF">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/bubble.gif" width="17"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=581"></a><a
																			href="DisplayDetails.aspx?id=401">神州数码金程（北京）科技有限公司</a>
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt1__ctl4_lblNewsDate1">2008-12-03</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td colspan="2">
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/more.gif" width="57" height="15" />
																		<a
																			href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a>
																	</div>
																</td>
															</tr>
														</table>
													</fieldset>
												</div>
											</td>
										</tr>
										<tr>
											<td valign=top>
												<div id="DisplayInformation1_Panel1" class="dctNoBorder"
													style="font-size: 16px;">
													<fieldset>
														<legend>
															<img src="<%=request.getContextPath() %>/bksx/pictures/shixizixun.gif" />
														</legend>
														<table width="610">
															<tr bgcolor="#FFFFFF">
																<td width=500>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/voice.gif" width="15"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=601">2008级研究生实习手续办理通知</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td width=110>
																	<div align="left">
																		<span id="DisplayInformation1_rbt2__ctl0_lblNewsDate2">2009-7-10</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/voice.gif" width="15"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=601"></a><a
																			href="DisplayDetails.aspx?id=541">西电软件学院研究生实习办理流程</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt2__ctl1_lblNewsDate2">2009-5-21</span>
																	</div>
																</td>
															</tr>
															<tr bgcolor="#FFFFFF">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/voice.gif" width="15"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=601"></a><a
																			href="DisplayDetails.aspx?id=461">西电软件学院研究生实习办理流程</a>
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt2__ctl2_lblNewsDate2">2009-3-19</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/voice.gif" width="15"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=601"></a><a
																			href="DisplayDetails.aspx?id=463">&ldquo;如何把握金融危机下的海外留学机遇&rdquo;专场咨询</a>
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt2__ctl3_lblNewsDate2">2009-3-19</span>
																	</div>
																</td>
															</tr>
															<tr bgcolor="#FFFFFF">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/voice.gif" width="15"
																			height="15" />
																		<a href="DisplayDetails.aspx?id=601"></a><a
																			href="DisplayDetails.aspx?id=441">2009年中关村软件行业校园招聘会</a>
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt2__ctl4_lblNewsDate2">2009-3-11</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/more.gif" width="57" height="15" />
																		<a
																			href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a><a
																			href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a>
																	</div>
																</td>
																<td>
																	<div align="left"></div>
																</td>
															</tr>
														</table>
													</fieldset>
												</div>
											</td>
										</tr>
										<tr>
											<td height="171" valign=top>
												<div id="DisplayInformation1_Panel4" class="dctNoBorder"
													style="font-size: 16px;">
													<fieldset>
														<legend>
															<img src="<%=request.getContextPath() %>/bksx/pictures/biyesheji.gif" />
														</legend>
														<table width="610">
															<tr bgcolor="#FFFFFF">
																<td width=500>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/mail.gif" width="16" height="16" />
																		<a href="StudentManage/YaXinCompanyZhaoPin.jsp">亚信集团股份有限公司</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td width=110>
																	<div align="left">
																		<span id="DisplayInformation1_rbt4__ctl0_lblNewsDate4">2009-10-13</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/mail.gif" width="16" height="16" />
																		<a href="StudentManage/YaXinCompanyZhaoPin.jsp"></a><a
																			href="DisplayDetails.aspx?id=561">科派特信息技术有限公司招聘实习生</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt4__ctl1_lblNewsDate4">2009-6-25</span>
																	</div>
																</td>
															</tr>
															<tr bgcolor="#FFFFFF">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/mail.gif" width="16" height="16" />
																		<a href="StudentManage/YaXinCompanyZhaoPin.jsp"></a><a
																			href="DisplayDetails.aspx?id=581">北京无限缘信息科技有限公司招聘</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt4__ctl2_lblNewsDate4">2009-6-10</span>
																	</div>
																</td>
															</tr>
															<tr class="SubMenu">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/mail.gif" width="16" height="16" />
																		<a href="StudentManage/YaXinCompanyZhaoPin.jsp"></a><a
																			href="DisplayDetails.aspx?id=462">Platform技术支持工程师岗位</a>
																		<img src="<%=request.getContextPath() %>/bksx/pictures/new.gif" width="28" height="14" />
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt4__ctl3_lblNewsDate4">2009-4-22</span>
																	</div>
																</td>
															</tr>
															<tr bgcolor="#FFFFFF">
																<td>
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/mail.gif" width="16" height="16" />
																		<a href="StudentManage/YaXinCompanyZhaoPin.jsp"></a><a
																			href="DisplayDetails.aspx?id=401">神州数码金程科技有限公司</a>
																	</div>
																</td>
																<td>
																	<div align="left">
																		<span id="DisplayInformation1_rbt4__ctl4_lblNewsDate4">2009-3-23</span>
																	</div>
																</td>
															</tr>
															<tr>
																<td height="21" colspan="2">
																	<div align="left">
																		<img src="<%=request.getContextPath() %>/bksx/pictures/more.gif" width="57" height="15" />
																		<a
																			href="javascript:__doPostBack('DisplayInformation1$btnSeeMore1','')"></a><a
																			href="javascript:__doPostBack('DisplayInformation1$btnSeeMore4','')"></a>
																	</div>
																</td>
															</tr>
														</table>
													</fieldset>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>

