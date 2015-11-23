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



/** �û���ʾ�ʼ����ݵ�servlet
 * @author ֣��˫ 2010-04-30
 * @version 1.1 
 *
 */
public class DisplayContent extends HttpServlet {
	

	/**
	 * @param request �û�����
	 * @param response ��������Ӧ
	 * @param msgnum �ʼ����
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
		sos.print("<fieldset style='height:250px;'><legend style='font-size: 13px;'>�ʼ�����</legend>");
		
		//response.setContentType("message/rfc822");
		
		
//		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		String username =(String)session.getAttribute("username");
		Folder folder = (Folder)session.getAttribute("folder");
		
		try {
			Message msg = folder.getMessage(msgnum);
		
			
//			//BASE64����� ��Ҫ����...
//			BASE64Decoder decoder = new BASE64Decoder();
//			
//			
//			byte[]b = decoder.decodeBuffer(msg.getContent().toString());
//			String content = new String(b);
//			System.out.println("In DisplayContent..."+content);
//			
			//�漰���ʼ��������ط���
			//��һ���ǽ�һ���Ѷ����ʼ�����ر�־λ�ŵ����ݿ�ı���
			
			
			//���ʼ����Ͳ���mixed��ʱ�򣬾���û�и�������ôֱ������ʼ�����
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
					
					//MIME��Ϣͷ�в�����disposition�ֶΣ�����
					//����mixedʱ����ʾ��ǰ��õ����ʼ�����
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
