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
			System.out.println("超时处理");
			new AppException("操作超时，请重新登录");
			response.sendRedirect("http://"+localhost+":8080/"+Constant.version+"/login.jsp");
		}
		
		

		//System.out.println(request.getRemoteAddr());
		
//		System.out.println("访问过滤器 ....."+session.getAttribute("url"));
		String isLogin=null;
		if(session.getAttribute("isLogin")!=null){
		isLogin=session.getAttribute("isLogin").toString(); //注意isLogin是一个动作而不是一个状态
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
		
		//得到用户请求路径
		String request_uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String uri = request_uri.substring(ctxPath.length());
		System.out.println("请求页面 ....."+request_uri);
	
		String usernumber=null;
		if(session.getAttribute("FUserNumber")!=null){
		System.out.println("当前用户账号 : "+session.getAttribute("FUserNumber"));
		 usernumber = (String)session.getAttribute("FUserNumber");
		}
		boolean flag=false;  //是否为限制页面 默认为是
	
		
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
		System.out.println("访问是否需要登录"+(flag?"否":"是"));
		
		if(flag)//如果当前页面为非限制页面 跳过检验
		{
			
			if(session.getAttribute("url_wanna")!=null) //有越权访问地址则登陆后跳转到该地址
			{
				session.setAttribute("url", session.getAttribute("url_wanna"));
				System.out.println("访问限限制页面 登入跳转到访问页面 : "+session.getAttribute("url_wanna"));
			}
			else{
			session.setAttribute("url", "/PersonalIndex.jsp");
			System.out.println("访问非权限限制页面 登入跳转到个人主页");
			}
			
			chain.doFilter(req, resp);
			System.out.println("垃圾回收提示 4  System.gc");
			System.gc();
			System.out.println("过滤通过");	
			return ;
		}
		else if(usernumber==null)
		{
			System.out.println("url_wanna:"+uri);
			session.setAttribute("url_wanna", uri);
			response.sendRedirect("http://"+localhost+":8080/"+Constant.version+"/login.jsp");//如果不是 验证用户是否登入

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
