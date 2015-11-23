package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.MhqxTabUserfunction;

public class ShowFunctionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
	    List<MhqxTabFunction> firstList = (List<MhqxTabFunction>)session.getAttribute("firstList");
	    List<MhqxTabModule> modulelist = (List<MhqxTabModule>)session.getAttribute("modulelist");
	    List<MhqxTabUserfunction> sublist[] = (List<MhqxTabUserfunction>[])session.getAttribute("sublist");
	    for(int j = 0;j<modulelist.size();j++)
	    {
	    	MhqxTabModule module = modulelist.get(j);
	    	out.println("+"+module.getFModuleName());
	    	for(int k = 0;k<firstList.size();k++)
	    	{
	    		if(module.getFModuleName().equals(firstList.get(k).getMhqxTabModule().getFModuleName()))
	    		{
	    			out.println("++"+firstList.get(k).getFFunctionName());
	    		}
	    		for(int m = 0;m<sublist[k].size();m++)
	    		{
	    			out.println("+++"+sublist[k].get(m).getMhqxTabFunction().getFFunctionName());
	    		}
	    	}
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
}
