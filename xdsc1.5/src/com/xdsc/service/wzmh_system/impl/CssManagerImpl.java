package com.xdsc.service.wzmh_system.impl;

import com.xdsc.dao.wzmh_system.impl.CssDAOImpl;
import com.xdsc.model.MhqxTabRemind;
import com.xdsc.service.wzmh_system.CssManager;

public class CssManagerImpl implements CssManager {
private CssDAOImpl cssdao;
	
	
	
	
	public MhqxTabRemind findbyid(int id) {
		
		return cssdao.findbyid(id);
	}

	public MhqxTabRemind findbyusernumber(String UserNumber) {
	
		return cssdao.findbyusernumber(UserNumber);
	}

	public void insert(MhqxTabRemind css) {
		cssdao.insert(css);

	}

	public void update(MhqxTabRemind css) {
		cssdao.update(css);

	}

	public synchronized CssDAOImpl getCssdao() {
		return cssdao;
	}

	public synchronized void setCssdao(CssDAOImpl cssdao) {
		this.cssdao = cssdao;
	}

}
