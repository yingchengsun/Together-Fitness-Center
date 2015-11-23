package com.xdsc.util;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.xdsc.model.TabInformation;


/**
 * 分页功能的公共类
 * @author 孙颖成
 *
 */
public class MultiPage {

	/**
	 * num设定每页显示的条目数量
	 */
	private  int num = 10;

	/**
	 * index_pre与index_af控制页面显示的前后索引
	 */
	private  int index_pre = 0;
	private  int index_af = num + index_pre - 1;
	/**
	 * currentPage记载当前是哪个页面
	 */
	private int currentPage = 1;

	public void multiPage(List<TabInformation> list) {
		int page_size;
		if (list.size() % num == 0) {
			page_size = list.size() / num;
		} else {
			page_size = list.size() / num + 1;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list_size", page_size);
		request.setAttribute("current_page", currentPage);
		if (request.getParameter("current_page") == null
				|| request.getParameter("current_page").equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("current_page")
					.toString());
		}
		if (currentPage > page_size) {
			//this.addActionMessage("Invalid page Selection");
			currentPage = 1;
		}
		if (list.size() > num) {
			index_pre = num * (currentPage - 1);
			if ((num * currentPage - 1) > (list.size() - 1)) {
				index_af = list.size();
			} else {
				index_af = num * currentPage;
			}
			List<TabInformation> subNav = list.subList(index_pre, index_af);
			request.setAttribute("Info", subNav);
		} else {
			request.setAttribute("Info", list);
		}
	}

	
	
	
	
}
