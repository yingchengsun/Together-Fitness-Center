package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdsc.dao.htgl_system.MhqxTabFunctionDAO;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.util.ServletDao;
import com.xdsc.util.ToJosnUtil;

public class TreeDataServlet extends HttpServlet {

	
	public TreeDataServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			  request.setCharacterEncoding("UTF-8");
			  response.setContentType("text/html;charset=utf-8");
			  String id=(String)request.getParameter("id");            //��ǰѭ�������Ǹ�ϵͳ�����ҳ����û��ڴ�ϵͳ�µĹ���
			  String node=(String)request.getParameter("node");         //Ҫչ���Ľڵ��node id��ͨ����id��Ӧ���ӽڵ�
			  int superId=Integer.parseInt(node);                     //����id(ϵͳ��)��node(Ҫչ����function��)�����ҵ���Ӧ���ӽڵ�
			  int moduleid = Integer.parseInt(id);
	          PrintWriter out = response.getWriter();
	          String usernumber = (String)request.getSession().getAttribute("FUserNumber");
	          List<MhqxTabFunction> userfunctionList =(List<MhqxTabFunction>)request.getSession().getAttribute("userfunctionList");
	          List<MhqxTabFunction> functionList=ServletDao.findfunctionListByModuleAndSuperId(superId, moduleid,usernumber);
	          String responseData=ToJosnUtil.FunctionToJoson(functionList);
	          System.out.println("*******************"+responseData);
	          out.println(responseData);
	          }catch(Exception e){
	          e.printStackTrace();
	      }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}
}
