package com.xdsc.service.mail_system;

import java.io.IOException;
import java.io.InputStream;

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

/** 用于处理邮件附件的servlet
 * @author 郑灿双 2010-04-30
 * @version1.1
 */
public class HandleAttach extends HttpServlet{
	
	//这个类中的方法是用来处理附件的...
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		ServletOutputStream out = response.getOutputStream();
		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		int bodynum = Integer.parseInt(request.getParameter("bodynum"));
		String filename = request.getParameter("filename");
		Folder folder = (Folder)session.getAttribute("folder");
		try {
			Message msg = folder.getMessage(msgnum);
			response.setHeader("Content-Disposion", "attachment;filename="+filename);
			Multipart multi = (Multipart)msg.getContent();
			BodyPart bodyPart = multi.getBodyPart(bodynum);
			InputStream is = bodyPart.getInputStream();
//			byte[] content = new byte[255];
//	        while ((in.read(content)) != -1) {
//	            writer.write(content);
//	        }
			int c = 0;
			while((c=is.read())!=-1){
				out.write(c);
			}
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
