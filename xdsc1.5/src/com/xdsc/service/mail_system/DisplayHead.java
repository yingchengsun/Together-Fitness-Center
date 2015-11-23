package com.xdsc.service.mail_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** ������ʾ�ʼ�ͷ��servlet
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class DisplayHead extends HttpServlet {
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		System.out.println("In DisplayHead.java to show the path :"+request.getContextPath());
		int msgnum = Integer.parseInt(request.getParameter("msgnum"));
		Folder folder = (Folder)session.getAttribute("folder");
		try {
			Message msg = folder.getMessage(msgnum);
			
			//�����ʼ��ı�־��ʾ���ʼ�Ϊ�Ѷ����ʼ�
//			folder.open(Folder.READ_WRITE);
//			msg.setFlag(Flags.Flag.SEEN, true);
//			msg.saveChanges();
			
			String from = msg.getFrom()[0].toString();
			String subject = msg.getSubject();
			String sendDate = DateFormat.getInstance().format(msg.getSentDate());
			
			out.print("<link rel='stylesheet' type='text/css' href='/xdsc1.5/8_mail_system/css/css.css'>");
			out.print("<style type='text/css'>");
			out.print("body {");
			out.print("background-image: url('/xdsc1.5/8_mail_system/pictures/newbackground.png')");
			out.print("}");
			out.print("</style>");
			out.print("<body>");
			out.print("<div style='position: absolute;top: 10%;left: 35%;width: 380px;height: auto;'>");
			out.print("<span><img src='/xdsc1.5/8_mail_system/images/mailtitle.png'><font size='6' face='������κ'><strong>��ȡ�ʼ�</strong></font></span></div>");
			out.print("<div style='position: absolute;top: 40%;left: 25%;width: 380px; height: auto;'>");
			out.print("<fieldset><legend style='font-size: 13px;'>�ʼ�����</legend>");
			out.print("<table>"+"<tr>"+"<td>");
			out.println("�ʼ����⣺"+"</td>"+"<td>"+ subject +"</td>"+"</tr>");
			out.println("<tr>"+"<td>"+"�����ˣ�"+"</td>"+"<td>"+from+"</td>"+"</tr>");	
			out.println("<tr>"+"<td>"+"�������ڣ�"+"</td>"+"<td>"+sendDate+"</td></tr>");
			
//			request.setAttribute("subject", subject);
//			request.setAttribute("from", from);
//			request.setAttribute("sendDate", sendDate);
//			request.getRequestDispatcher("temp.jsp");
//			System.out.println(msg.getContentType());
			
			if(msg.isMimeType("multipart/*")){
				Multipart mp = (Multipart)msg.getContent();
				for(int i=0;i<mp.getCount();i++){
					BodyPart bp = mp.getBodyPart(i);
					if(bp.getDisposition()!=null){
						String filename = bp.getFileName();
						System.out.println(filename);
						if(filename.startsWith("=?")){
							filename=MimeUtility.decodeText(filename);
						}
						out.print("<link rel='stylesheet' type='text/css' href='/xdsc1.5/8_mail_system/css/css.css'>");
						out.print("<style type='text/css'>");
						out.print("body {");
						out.print("background-image: url('/xdsc1.5/8_mail_system/pictures/newbackground.png')");
						out.print("}");
						out.print("</style>");
						out.print("<tr>"+"<td>"+"������"+"</td>"+"<td>");
						out.print("<a class='LINK21' href=HandleAttach?msgnum="+msgnum+"&&bodynum="+i+"&&filename"+">"+filename+"(��ȡ)"+"</a>&nbsp");
						out.print("<a class='LINK21' href=8_mail_system/filedownload.action?name="+filename+">"+"(���ظ���)"+"</a>");
					}
				}
				out.print("</table>");
				out.print("</fieldset></div>");
				
				out.print("</body>");
			}
			
		}
		catch (Exception e) {
			
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
