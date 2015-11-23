<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String id=request.getParameter("id");
String text=request.getParameter("text");


response.setContentType("text/xml");//注意，由于你是以xml形式传递过来的，所以这里必须写。
System.out.println(text);
if(text.equals("网站门户"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"网站门户管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("学生管理"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"学生"+"</name>");
   out.print("<name id='"+"2"+"'>"+"老师"+"</name>");
   out.print("<name id='"+"3"+"'>"+"辅导员"+"</name>");
   out.print("<name id='"+"4"+"'>"+"家长"+"</name>");
   out.print("<name id='"+"5"+"'>"+"领导"+"</name>");
   out.print("<name id='"+"6"+"'>"+"学生管理系统管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("教铺平台"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"学生"+"</name>");
   out.print("<name id='"+"2"+"'>"+"教师"+"</name>");
   out.print("<name id='"+"3"+"'>"+"助教"+"</name>");
   out.print("<name id='"+"4"+"'>"+"教辅平台管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("工硕报名"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"考生"+"</name>");
   out.print("<name id='"+"2"+"'>"+"工硕报名管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("实践教学"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"教师"+"</name>");
   out.print("<name id='"+"2"+"'>"+"设备管理员"+"</name>");
   out.print("<name id='"+"3"+"'>"+"实践教学管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("毕业设计"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"本科生"+"</name>");
   out.print("<name id='"+"2"+"'>"+"导师"+"</name>");
   out.print("<name id='"+"3"+"'>"+"毕设系统管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("研究生实习"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"研究生"+"</name>");
   out.print("<name id='"+"2"+"'>"+"导师"+"</name>");
   out.print("<name id='"+"3"+"'>"+"企业"+"</name>");
   out.print("<name id='"+"4"+"'>"+"研究生实习管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("我的邮箱"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"用户"+"</name>");
   out.print("<name id='"+"2"+"'>"+"邮件系统管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("跟踪反馈"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"本科生"+"</name>");
   out.print("<name id='"+"2"+"'>"+"研究生"+"</name>");
   out.print("<name id='"+"3"+"'>"+"辅导员"+"</name>");
   out.print("<name id='"+"4"+"'>"+"跟踪反馈管理员"+"</name>");
   out.print("</student>");
}
else if(text.equals("总后台管理"))
{
   out.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
   out.print("<student>");
   out.print("<name id='"+"1"+"'>"+"总后台管理员"+"</name>");
   out.print("</student>");
}
//这里可以做后台操作。
 %>

