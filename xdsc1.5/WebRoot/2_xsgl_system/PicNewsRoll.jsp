

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>图片新闻</title>
	</head>
	<body>
		<form name="form1" method="post" action="PicNewsRoll.aspx" id="form1">
			<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
				value="/wEPDwULLTEzNzA5MzMyMTdkZPdyPdpeWg19PsOMMlhAhoJCha3P" />

			<script type="text/javascript">
var imgNews = [{ url : './images/news11.jpg', text : '田径场', link : 'ShowNews.aspx?newsid=463' }, { url : './images/news12.jpg', text : '操场一角', link : 'ShowNews.aspx?newsid=381' }, { url : './images/news7.jpg', text : 'XX塔', link : 'ShowNews.aspx?newsid=368' }, { url : './images/news6.jpg', text : '篮球场', link : 'ShowNews.aspx?newsid=372' }, { url : './images/news10.jpg', text : '“青春万岁”歌赛', link : 'ShowNews.aspx?newsid=370' } ]; </script>

			<div>

				<style type="text/css">
td {
	font-size: 12px;
}

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
<!--#     田径场所有用new创建的对象在没有被持久化之前，称作<br>临时对象，不被任何session关联  -->
				<div id="divPic" style="width: 445px; height: 345px;background-color:red"></div>

				<script type="text/javascript">
function loadFlash()
{
     var divPic = document.getElementById('divPic');
 var focus_width=445;
 var focus_height=330;
 var text_height=15;
 var swf_height = focus_height+text_height;
 
 var pics = '', links = '', texts = '';
 if(imgNews)
 {
     for(var i=0; i < imgNews.length; i++)
     {
        var imgNewsObj = imgNews[i];
        pics += imgNewsObj.url;
        links += imgNewsObj.link;
        texts += imgNewsObj.text;
        
        if(i != imgNews.length - 1)
        {
            pics += "|";
            links += "|";
            texts += "|";
        }
     }
     var tp = '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ focus_width +'" height="'+ swf_height +'">';
      tp=tp+'<param name="allowScriptAccess" value="sameDomain"><param name="movie" value="images/focus2.swf"><param name="quality" value="high"><param name="bgcolor" value="#F0F0F0">';
      tp=tp+'<param name="menu" value="false"><param name=wmode value="opaque">';
      tp=tp+' <embed src="images/focus2.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" bgcolor="#FFFFFF" quality="high" width="'+ focus_width +'" height="'+ swf_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />';
     tp=tp+'<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">';
     tp=tp+'</object>';
     
     if(divPic)
     {
        divPic.innerHTML = tp;
     }
 }
}

window.onload = loadFlash;
</script>

			</div>
		</form>
	</body>
</html>
