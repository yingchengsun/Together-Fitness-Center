<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
#senfe {
 width: 300px;
 border-top: #000 1px solid;
 border-left: #000 1px solid;
}
#senfe td {
 border-right: #000 1px solid;
 border-bottom: #000 1px solid;
}
</style>
<script language="javascript">
function senfe(o,a,b,c,d){
 var t=document.getElementById(o).getElementsByTagName("tr");
 for(var i=0;i<t.length;i++){
  t[i].style.backgroundColor=(t[i].sectionRowIndex%2==0)?a:b;
  t[i].onclick=function(){
   if(this.x!="1"){
    this.x="1";//本来打算直接用背景色判断，FF获取到的背景是RGB值，不好判断
    this.style.backgroundColor=d;
   }else{
    this.x="0";
    this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
   }
  }
  t[i].onmouseover=function(){
   if(this.x!="1")this.style.backgroundColor=c;
  }
  t[i].onmouseout=function(){
   if(this.x!="1")this.style.backgroundColor=(this.sectionRowIndex%2==0)?a:b;
  }
 }
}
</script>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" id="senfe">
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
<tr><td>　</td><td>　</td><td>　</td><td>　</td></tr>
</table>
<script language="javascript"><!--
//senfe("表格名称","奇数行背景","偶数行背景","鼠标经过背景","点击后背景");
senfe("senfe","#fff","#ccc","#cfc","#f00");
--></script>
</body>
</html>