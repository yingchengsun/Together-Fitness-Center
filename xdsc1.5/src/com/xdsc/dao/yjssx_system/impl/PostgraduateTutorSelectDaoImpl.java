package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabTeacherstotype;
import com.xdsc.model.YjssxTabSubmitthesis;
import com.xdsc.model.YjssxTabTutorselect;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能：研究生导师双向选择
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateTutorSelectDaoImpl extends HibernateDaoSupport implements
		PostgraduateTutorSelectDao {

	/**
	 * 查找出所有导师的信息
	 * @return 返回导师信息列表
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#findAllTutorInfo()
	 */
	public List<TabTeacherstotype> findAllTutorInfo() {
		// TODO Auto-generated method stub                 类型为1则为导师
		String Hql="from TabTeacherstotype t where t.tabTeacherstype.FTypeNumber="+CommonConstVariable.TEACHER_TYPE_ID;
		List<TabTeacherstotype> list=this.getHibernateTemplate().find(Hql);
		return list;
	}

	/**
	 * 根据导师的ID查找导师详细信息
	 * @param num
	 * @return 返回导师详情
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#findTutorInfoByNum(java.lang.String)
	 */
	public TabTeachers findTutorInfoByNum(String num) {
		// TODO Auto-generated method stub
		TabTeachers teacher=(TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, num);
		return teacher;
	}

	/**
	 * 根据学生ID查找导师选择信息
	 * @param num
	 * @return 返回导师选择信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#tutorSelectInfoByStuNum(java.lang.String)
	 */
	public YjssxTabTutorselect tutorSelectInfoByStuNum(String num) {
		// TODO Auto-generated method stub
		YjssxTabTutorselect tutorSelectInfo=(YjssxTabTutorselect)this.getHibernateTemplate().get(YjssxTabTutorselect.class,num);
		return tutorSelectInfo;
	}

	/**
	 * 保存导师选择信息
	 * @param selectInfo
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#addTutorSelectInfo(com.xdsc.model.YjssxTabTutorselect)
	 */
	public void addTutorSelectInfo(YjssxTabTutorselect selectInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(selectInfo);
		
	}

	/**
	 * 查找已选择导师信息
	 * @param num
	 * @return 已选择导师信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#findSelectedTutorInfo(java.lang.String)
	 */
	public YjssxTabTutorselect findSelectedTutorInfo(String num) {
		// TODO Auto-generated method stub
		return (YjssxTabTutorselect)this.getHibernateTemplate().get(YjssxTabTutorselect.class, num);
	}

	/**
	 * 更新导师选择信息
	 * @param selectInfo
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#updateTutorSelect(com.xdsc.model.YjssxTabTutorselect)
	 */
	public void updateTutorSelect(YjssxTabTutorselect selectInfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(selectInfo);

	}

	/**
	 * 查找所有导师选择信息
	 * @return 返回导师选择信息
	 * @see com.xdsc.dao.yjssx_system.PostgraduateTutorSelectDao#findAllTutorSelectInfo()
	 */
	public List<YjssxTabTutorselect> findAllTutorSelectInfo() {
		// TODO Auto-generated method stub
		List<YjssxTabTutorselect> list=this.getHibernateTemplate().loadAll(YjssxTabTutorselect.class);
		return list;
	}
	
	

}
