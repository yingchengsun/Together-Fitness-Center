package com.xdsc.util;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.xdsc.model.TabInformation;


/**
 * ��ҳ���ܵĹ�����
 * @author ��ӱ��
 *
 */
public class MultiPage {

	/**
	 * num�趨ÿҳ��ʾ����Ŀ����
	 */
	private  int num = 10;

	/**
	 * index_pre��index_af����ҳ����ʾ��ǰ������
	 */
	private  int index_pre = 0;
	private  int index_af = num + index_pre - 1;
	/**
	 * currentPage���ص�ǰ���ĸ�ҳ��
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
