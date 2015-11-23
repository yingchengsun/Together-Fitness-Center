package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.UploadResumeDao;
import com.xdsc.model.YjssxTabResume;

/**
 * 接口功能：研究生简历的数据库操作(增删改查)
 * @author 许鑫
 * @version 1.1
 */
public class UploadResumeDaoImpl extends HibernateDaoSupport implements UploadResumeDao {

	/**
	 * 增加一个简历信息
	 * @param resume
	 * @see com.xdsc.dao.yjssx_system.UploadResumeDao#addResume(com.xdsc.model.YjssxTabResume)
	 */
	public void addResume(YjssxTabResume resume) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(resume);
	}

	/**
	 * 删除一个简历信息
	 * @param resume
	 * @see com.xdsc.dao.yjssx_system.UploadResumeDao#deleteResume(com.xdsc.model.YjssxTabResume)
	 */
	public void deleteResume(YjssxTabResume resume) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(resume);
	}

	/**
	 * 根据公司的ID查找所有提交的简历
	 * @param num
	 * @return 返回所有已经提交的简历
	 * @see com.xdsc.dao.yjssx_system.UploadResumeDao#findAllResumeByComNum(java.lang.String)
	 */
	public List<YjssxTabResume> findAllResumeByComNum(String num) {
		// TODO Auto-generated method stub
		String Hql="from YjssxTabResume r where r.tabCompany.FCompanyNumber='"+num+"'";
		List<YjssxTabResume> list=this.getHibernateTemplate().find(Hql);
		System.out.println("-------------------"+list.size());
		return list;
	}

	/**
	 * 根据简历的ID查找简历的详情
	 * @param id
	 * @return 返回简历的详情
	 * @see com.xdsc.dao.yjssx_system.UploadResumeDao#findResumeById(int)
	 */
	public YjssxTabResume findResumeById(int id) {
		// TODO Auto-generated method stub
		YjssxTabResume resume=(YjssxTabResume)this.getHibernateTemplate().get(YjssxTabResume.class, id);
		return resume;
	}

}
