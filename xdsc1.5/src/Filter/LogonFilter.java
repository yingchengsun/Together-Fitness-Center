package Filter;

import java.io.IOException;

import com.xdsc.check.AppException;
import com.xdsc.util.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
public class LogonFilter implements Filter {
	
	
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		String localhost = request.getLocalAddr();
//		String str2=request.getLocalAddr();
//		String str3 = request.getRemoteHost();
//		System.out.println(localhost+" "+str2+" "+str3);
//		
		if(session==null)
		{
			System.out.println("��ʱ����");
			new AppException("������ʱ�������µ�¼");
			response.sendRedirect("http://"+localhost+":8080/"+Constant.version+"/login.jsp");
		}
		
		

		//System.out.println(request.getRemoteAddr());
		
//		System.out.println("���ʹ����� ....."+session.getAttribute("url"));
		String isLogin=null;
		if(session.getAttribute("isLogin")!=null){
		isLogin=session.getAttribute("isLogin").toString(); //ע��isLogin��һ������������һ��״̬
		}
		String go=null;
		if(session.getAttribute("url")!=null){
		go = session.getAttribute("url").toString();
		}
		if(isLogin!=null&&isLogin.equals("true")&&go!=null)
		{
			session.setAttribute("isLogin", "false");
			response.sendRedirect("http://"+localhost+":8080/"+Constant.version+go);
		}
		
		//�õ��û�����·��
		String request_uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String uri = request_uri.substring(ctxPath.length());
		System.out.println("����ҳ�� ....."+request_uri);
	
		String usernumber=null;
		if(session.getAttribute("FUserNumber")!=null){
		System.out.println("��ǰ�û��˺� : "+session.getAttribute("FUserNumber"));
		 usernumber = (String)session.getAttribute("FUserNumber");
		}
		boolean flag=false;  //�Ƿ�Ϊ����ҳ�� Ĭ��Ϊ��
	
		
		ArrayList<String> UncheckurlList=new UnCheckUrl().getUncheckjspList();
		ArrayList<String> UncheckactionList=new UnCheckUrl().getUncheckactionList();
		for(String s:UncheckactionList)
		{
			if(uri.lastIndexOf(s)>=0)
			{
				flag=true;
				break;
			}
		}
		
		for(String s:UncheckurlList)
		{
			if(uri.equals(s))
			{
				flag=true;
				break;
			}
		}
		System.out.println("�����Ƿ���Ҫ��¼"+(flag?"��":"��"));
		
		if(flag)//�����ǰҳ��Ϊ������ҳ�� ��������
		{
			
			if(session.getAttribute("url_wanna")!=null) //��ԽȨ���ʵ�ַ���½����ת���õ�ַ
			{
				session.setAttribute("url", session.getAttribute("url_wanna"));
				System.out.println("����������ҳ�� ������ת������ҳ�� : "+session.getAttribute("url_wanna"));
			}
			else{
			session.setAttribute("url", "/PersonalIndex.jsp");
			System.out.println("���ʷ�Ȩ������ҳ�� ������ת��������ҳ");
			}
			
			chain.doFilter(req, resp);
			System.out.println("����������ʾ 4  System.gc");
			System.gc();
			System.out.println("����ͨ��");	
			return ;
		}
		else if(usernumber==null)
		{
			System.out.println("url_wanna:"+uri);
			session.setAttribute("url_wanna", uri);
			response.sendRedirect("http://"+localhost+":8080/"+Constant.version+"/login.jsp");//������� ��֤�û��Ƿ����

		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	
	}

	/**
	 * Constructor of the object.
	 */
	public LogonFilter() {
		super();
	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
