package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabModuleuser;
import com.xdsc.util.ServletDao;
import com.xdsc.util.ToJosnUtil;

public class JosnDataServlet extends HttpServlet {
	
	public JosnDataServlet() {
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
          PrintWriter out = response.getWriter();
          
          String usernumber = (String)request.getSession().getAttribute("FUserNumber");
          List<MhqxTabModuleuser> usermodulelist = ServletDao.findMhqxTabModuleuserByUserNumber(usernumber);//查询出用户模块对应表中数据
          System.out.println("--------------------------"+usermodulelist.size());
          Iterator<MhqxTabModuleuser> iterator1 = usermodulelist.iterator();
          List<MhqxTabModule> modulelist = new ArrayList<MhqxTabModule>();
          while(iterator1.hasNext())                                          //循环找到用户所拥有的模块
          {
        	  modulelist.add(iterator1.next().getMhqxTabModule());
          }       
          String responseData = ToJosnUtil.ModuleToJosn(modulelist);
          System.out.println(responseData);
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
