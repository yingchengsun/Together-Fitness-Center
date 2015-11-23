package com.xdsc.service.mail_system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Decoder;



/** 用户显示邮件内容的servlet
 * @author 郑灿双 2010-04-30
 * @version 1.1 
 *
 */
public class DisplayContent extends HttpServlet {
	

	/**
	 * @param request 用户请求
	 * @param response 服务器相应
	 * @param msgnum 邮件编号
	 * @throws IOException 
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response,int msgnum) throws IOException{
		response.setContentType("text/html;charset=gb2312");
		HttpSession session = request.getSession();
		//ServletOutputStream sos = response.getOutputStream();
		PrintWriter sos = response.getWriter();
		
		sos.print("<link rel='stylesheet' type='text/css' href='/xdsc1.5/8_mail_system/css/css.css'>");
		sos.print("<style type='text/css'>");
		sos.print("body {");
		sos.print("background-image: url('/xdsc1.5/8_mail_system/pictures/newbackground.png')");
		sos.print("}");
		sos.print("</style>");
		sos.print("<body>");
		sos.print("<div style='position: absolute;top: 1%;left: 25%;width: 380px; height: 280px;font-size:12px;'>");
		sos.print("<fieldset style='height:250px;'><legend style='font-size: 13px;'>邮件正文</legend>");
		
		//response.setContentType("message/rfc822");
		
		
//		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		String username =(String)session.getAttribute("username");
		Folder folder = (Folder)session.getAttribute("folder");
		
		try {
			Message msg = folder.getMessage(msgnum);
		
			
//			//BASE64编码后 需要解码...
//			BASE64Decoder decoder = new BASE64Decoder();
//			
//			
//			byte[]b = decoder.decodeBuffer(msg.getContent().toString());
//			String content = new String(b);
//			System.out.println("In DisplayContent..."+content);
//			
			//涉及到邮件管理的相关方法
			//这一步是将一封已读的邮件的相关标志位放到数据库的表中
			
			
			//当邮件类型不是mixed的时候，就是没有附件，那么直接输出邮件内容
			if(!msg.isMimeType("multipart/mixed"))
			{
			
				//msg.writeTo(sos);
				sos.print(msg.getContent().toString());
				
				
			}
			else{
				Multipart mp = (Multipart)msg.getContent();
				int bodynum = mp.getCount();
				for(int i = 0;i<bodynum;i++){
					BodyPart bp = mp.getBodyPart(i);
					
					//MIME消息头中不包含disposition字段，并且
					//不是mixed时，表示当前获得的是邮件正文
					if(!bp.isMimeType("multipart/mixed")&&bp.getDisposition()==null){
//						response.setContentType("message/rfc822");
//						bp.writeTo(sos);
						sos.print(bp.getContent().toString());
					}
				}
			}
			sos.print("</body>");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
