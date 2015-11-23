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
			  String id=(String)request.getParameter("id");            //当前循环到了那个系统，查找出此用户在此系统下的功能
			  String node=(String)request.getParameter("node");         //要展开的节点的node id，通过此id对应的子节点
			  int superId=Integer.parseInt(node);                     //根据id(系统号)，node(要展开的function号)可以找到对应的子节点
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
