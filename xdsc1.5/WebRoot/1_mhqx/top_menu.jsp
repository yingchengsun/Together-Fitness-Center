<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="/errorPage.jsp"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<style type="text/css">
#navBar {
	background-color: #0948F7;
	margin: 0px;
	height: 37px;
}

#navBar ul li {
	list-style-type: none;
	display: block;
	float: left;
}

#navBar ul li a:hover {
	color: bd6d6d6;
	text-decoration: none;
}

#menuAbout {
	padding-top: 11px;
}

/* Dropdowns */
#nav,#nav ul {
	padding: 0;
	margin: 0;
	list-style: none;
}

#nav a {
	display: block;
}

#nav li ul {
	position: absolute;
	left: -999em;
}

#nav li:hover ul,#nav li.sfhover ul {
	left: auto;
}

#nav li ul li a {
	background-color: SKYBLUE;
	filter: alpha(opacity :     70);
	color: #000FFF;
	font-size: 12px;
	padding: 5px 0 2px 7px;
	padding-top: 12px;
	border-top: 1px solid #fff;
}

#nav li ul li a:hover {
	background-color: hotpink;
	filter: alpha(opacity :     100);
	color: #00FFFF;
	font-size: 12px;
	padding: 5px 0 2px 7px;
	padding-top: 12px;
	border-top: 1px solid #fff;
}

/*#nav ul li a.last { border-bottom: none; }*/
#subMenuAbout,#subMenuAbout li a,#subMenuAbout li a:hover {
	width: 60px;
}

#subMenuServices,#subMenuServices li a,#subMenuServices li a:hover {
	width: 60px;
}

#subMenuPortfolio,#subMenuPortfolio li a,#subMenuPortfolio li a:hover {
	width: 60px;
}

#subMenuResources,#subMenuResources li a,#subMenuResources li a:hover {
	width: 60px;
}

#subMenuNews,#subMenuNews li a,#subMenuNews li a:hover {
	width: 60px;
}
</style>

<script language="javascript" type="text/javascript">
<!--//-->&lt;![CDATA[//><!--

sfHover = function() {
var sfEls = document.getElementById("nav").getElementsByTagName("LI");
for (var i=0; i<sfEls.length; i++) {
sfEls[i].onmouseover=function() {
this.className+=" sfhover";
}
sfEls[i].onmouseout=function() {
this.className=this.className.replace(new RegExp(" sfhover\\b"), "");
}
}
}

if (window.attachEvent) window.attachEvent("onload", sfHover);

//-->
</script>
<table id="daohang" cellspacing="0" cellpadding="0" width="850"
	align="center" border="0" class="daohang">
	<tr>
		<td>
			<embed src="images/top.swf" align="middle" width="849" height="161">
			</embed>
		</td>
	</tr>
	<tbody>
		<tr>
			<td width="850" align="left" valign="middle">
				<div id="navBar">
					<ul id="nav">
						<li id="menuAbout">
							<a href="index.jsp" class="a_write"> &nbsp;&nbsp;首页|</a>
						</li>
							<s:iterator value="firstList" status="st">
								<li id="menuAbout">
									<a class="a_write"
										href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>&pid=-1">
										<s:property value="FMenuName" />|&nbsp</a>
									<ul id="subMenuAbout">
											<s:iterator value="subList[#st.index]">
												<li>
													<a
														href="information!showMenuDetail.action?FMenuId=<s:property value="FMenuId"/>&pid=-1">
														<s:property value="FMenuName" /> </a>
												</li>
											</s:iterator>
									</ul>
								</li>
							</s:iterator>
					</ul>
				</div>
			</td>
		</tr>
	</tbody>
</table>
