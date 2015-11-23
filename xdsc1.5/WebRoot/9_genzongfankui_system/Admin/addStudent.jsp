
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	    <base href="<%=basePath%>">
		<title>添加学生基本信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="<%=basePath%>css.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>mycss.css">
		<script language="javascript" src="<%=basePath%>js/TableColor.js"></script>
		<script language="javascript" src="<%=basePath %>js/PopupCalendar.js"></script>
		<script>
			var oCalendarEn = new PopupCalendar("oCalendarEn");
			oCalendarEn.Init();
		
			var oCalendarChs = new PopupCalendar("oCalendarChs");
			oCalendarChs.weekDaySting = new Array("日", "一", "二", "三", "四", "五", "六");
			oCalendarChs.monthSting = new Array("一月", "二月", "三月", "四月", "五月", "六月",
					"七月", "八月", "九月", "十月", "十一月", "十二月");
			oCalendarChs.oBtnTodayTitle = "今天";
			oCalendarChs.oBtnCancelTitle = "取消";
			oCalendarChs.Init();
		</script>
	</head>

	<body>
		<br>
		<h3 align="center"><img src="<%=basePath%>Pictures/submittutorial_001.png" align="top" border="0" width="50" height="50"/>添加学生基本信息</h3>
		<table align="center" width="700">
			<tr>
				<th align="left"><a href="<%=basePath%>admin/StudentInfo!findAllStudentInfo.action"><img src="<%=basePath%>Pictures/return.gif" align="top" border="0"/>返回</a></th>
			</tr>
		</table> 
		<hr>
		<div align="center">
			<form action="admin/StudentInfo!addStudentInfo.action" method="post">
				<table border="1" width="700">
					<tr>
						<th height="30" colspan="2" align="center" background="<%=basePath%>Pictures/newmenubg.gif">
							<font color="#FFFFFF">添&nbsp;加&nbsp;信&nbsp;息</font>
						</th>
					</tr>
					<tr>
						<td>
							学号：
						</td>
						<td><div align="left">
							<input type="text" name="FUserNumber"/>
						</div>
						</td>
					</tr>
					
					<tr>
						<td>
							姓名：
						</td>
						<td><div align="left">
							<input type="text" name="FStudentName"  />
						</div></td>
					</tr>
					<tr>
						<td>
							班级：
						</td>
						<td><div align="left">
							<input type="text" name="FClassNumber"  />
						</div></td>
					</tr>
					<tr>
						<td>
							专业:
						</td>
						<td><div align="left">
							<input type="text" name="FStudentMajor"  />
						</div></td>
					</tr>
					<tr>
						<td>
							性别：
						</td>
						<td>
							<div align="left">
                  <select name="FStudentSex">
                    <option value=""></option>
                      <option value="男">男</option>
                      <option value="女">女</option>
                  </select>
              </div>
						</td>
					</tr>
					<tr>
						<td>
						出生年月：
						</td>
						<td>
							<div align="left">
		         <input readonly="readonly" type="text" name="FStudentBirthday"
								onclick="getDateString(this,oCalendarChs)" />
								
						</div></td>
					</tr>
					<tr>
						<td>
						籍贯：
						</td>
						<td>
			<div align="left">
			<select name="FStudentNativeplace">
			  <option value=""></option>
			  <option value="北京市">北京市</option>
                <option value="天津市">天津市</option>
                <option value="河北省">河北省</option>
                <option value="山西省">山西省</option>
                <option value="内蒙古区">内蒙古区</option>
                <option value="辽宁省">辽宁省</option>
                <option value="吉林省">吉林省</option>
                <option value="黑龙江省">黑龙江省</option>
                <option value="上海市">上海市</option>
                <option value="江苏省">江苏省</option>
                <option value="浙江省">浙江省</option>
                <option value="安徽省">安徽省</option>
                <option value="福建省">福建省</option>
                <option value="江西省">江西省</option>
                <option value="山东省">山东省</option>
                <option value="河南省">河南省</option>
			  
                <option value="湖北省">湖北省</option>
                <option value="湖南省">湖南省</option>
                <option value="广东省">广东省</option>
                <option value="广西区">广西区</option>
                <option value="海南省">海南省</option>
                <option value="重庆市">重庆市</option>
                <option value="四川省">四川省</option>
                <option value="贵州省">贵州省</option>
                <option value="云南省">云南省</option>
                <option value="西藏区">西藏区</option>
                <option value="陕西省">陕西省</option>
                <option value="甘肃省">甘肃省</option>
                <option value="青海省">青海省</option>
                <option value="宁夏区">宁夏区</option>
                <option value="新疆区">新疆区</option>
                <option value="台湾省">台湾省</option>
                <option value="香港特别行政区">香港特别行政区</option>
                <option value="澳门特别行政区">澳门特别行政区</option>
			  </select>     
		        </div>
						</td>
					</tr>
					<tr>
						<td>
						民族：
						</td>
						<td><div align="left">
					<select name="FStudentNation">
			        <option value=""></option>
			          <option value="汉族">汉族</option>
			          <option value="回族">回族</option>
			          <option value="蒙古族">蒙古族</option>
			          <option value="藏族">藏族</option>
			          <option value="维吾尔族">维吾尔族</option>
			          <option value="苗族">苗族</option>
			          <option value="彝族">彝族</option>
			          <option value="壮族">壮族</option>
			          <option value="布依族">布依族</option>
			          <option value="朝鲜族">朝鲜族</option>
			          <option value="满族">满族</option>
			          <option value="侗族">侗族</option>
			          <option value="瑶族">瑶族</option>
			          <option value="白族">白族</option>
			          <option value="土家族">土家族</option>
			          <option value="哈尼族">哈尼族</option>
			          <option value="哈萨克族">哈萨克族</option>
			          <option value="傣族">傣族</option>
			          <option value="黎族">黎族</option>
			          <option value="傈僳族">傈僳族</option>
			          <option value="佤族">佤族</option>
			          <option value="畲族">畲族</option>
			          <option value="高山族">高山族</option>
			          <option value="拉祜族">拉祜族</option>
			          <option value="水族">水族</option>
			          <option value="东乡族">东乡族</option>
			          <option value="纳西族">纳西族</option>
			          <option value="景颇族">景颇族</option>
			          <option value="柯尔克孜">柯尔克孜</option>
			          <option value="土族">土族</option>
			          <option value="达斡尔族">达斡尔族</option>
			          <option value="仫佬族">仫佬族</option>
			          <option value="羌族">羌族</option>
			          <option value="布朗族">布朗族</option>
			          <option value="撒拉族">撒拉族</option>
			          <option value="毛难族">毛难族</option>
			          <option value="仡佬族">仡佬族</option>
			          <option value="锡伯族">锡伯族</option>
			          <option value="阿昌族">阿昌族</option>
			          <option value="普米族">普米族</option>
			          <option value="塔吉克族">塔吉克族</option>
			          <option value="怒族">怒族</option>
			          <option value="乌孜别克">乌孜别克</option>
			          <option value="俄罗斯族">俄罗斯族</option>
			          <option value="鄂温克族">鄂温克族</option>
			          <option value="崩龙族">崩龙族</option>
			          <option value="保安族">保安族</option>
			          <option value="裕固族">裕固族</option>
			          <option value="京族">京族</option>
			          <option value="塔塔尔族">塔塔尔族</option>
			          <option value="独龙族">独龙族</option>
			          <option value="鄂伦春族">鄂伦春族</option>
			          <option value="赫哲族">赫哲族</option>
			          <option value="门巴族">门巴族</option>
			          <option value="珞巴族">珞巴族</option>
			          <option value="基诺族">基诺族</option>
			          <option value="外国血统">外国血统</option>
		          </select>
		        
						</div></td>
					</tr>
					<tr>
						<td>
						政治面貌：
						</td>
						<td>
							<div align="left">
		          <select name="FStudentPoliStatus">
		            <option value="" selected="selected"></option>
		              <option value="党员">党员</option>
		              <option value="群众">群众</option>
		              <option value="团员">团员</option>
	              </select>
                </div>
						</td>
					</tr>
					<tr>
						<td>
						毕业去向：
						</td>
						<td><div align="left">
							<select name="FQuXiang">
		            <option value="" selected="selected"></option>
		              <option value="工作">工作</option>
		              <option value="深造">深造</option>
		              <option value="出国">出国</option>
		              <option value="其他">其他</option>
	              </select>
						</div></td>
					</tr>
					<tr>
						<td>
						奖惩记录：
						</td>
						<td><div align="left">
							<input type="text" name="FRewardPunish" />
						</div></td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input type="submit" value="添加" />
							<input type="reset" value="重置" />
						</td>
					</tr>
				</table>
			</form>
			<br>
		
		</div>
		<br>
		<br>
	</body>
</html>
