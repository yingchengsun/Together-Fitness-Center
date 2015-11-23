package com.xdsc.dao.jiaofu.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AssistHomeworkManageDAO;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabHomenotice;
import com.xdsc.model.JfptTabHomenoticetoreceive;
import com.xdsc.model.JfptTabHomeupload;
import com.xdsc.model.JfptTabUsualscore;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.util.UpDownFileUtils;

/**
 * <p>功能：有关作业管理中涉及到的方法，进行作业通知、作业批改、成绩管理等<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistHomeworkManageDAOImpl extends HibernateDaoSupport implements AssistHomeworkManageDAO{

	/**
	 * <p>功能：添加平时成绩信息<br>
	 * @param jfptTabUsualscore 平时成绩信息
	 */
	public void addUsualScoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabUsualscore);
	}

	/**
	 * <p>功能：删除平时成绩信息<br>
	 * @param jfptTabUsualscore 平时成绩信息
	 */
	public void deleteUsualscoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabUsualscore);
	}
	
	/**
	 * <p>功能：根据个人id号查找相关的课程信息<br>
	 * @param id 个人编号
	 * @return list 返回相关的课程信息
	 */
	public List<TabCourse> findCourseInfoByAid(String id) {
		// TODO Auto-generated method stub
		String sql = "from TabCourse t where t.FCourseNumber in (" +
				"select j.tabCourse.FCourseNumber from JfptTabAssistantapply j where j.FShenQing='N' and " +
				"j.FAssistantId='"+id+"'" +
				" )";
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：根据课程号查找课程详细信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 课程相关信息
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>功能：根据学生学号查找相关的学生信息<br>
	 * @param FStudentNumber 学生学号
	 * @return TabStudents 学生信息
	 */
	public TabStudents findStudentsInfoByID(String FStudentNumber) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, FStudentNumber);
	}

	/**
	 * <p>功能：根据成绩id号查找相关的成绩信息<br>
	 * @param FNumber 成绩信息id号
	 * @return JfptTabUsualscore 平时成绩信息
	 */
	public JfptTabUsualscore findUsualscoreInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUsualscore)this.getHibernateTemplate().get(JfptTabUsualscore.class, FNumber);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查找相关的学生的成绩信息<br>
	 * @param FCourseNumber 课程编号
	 * @param aid 助教编号
	 * @return list 学生成绩信息
	 */
	public List<JfptTabUsualscore> findUsualscoreInfoByTwo(String FCourseNumber, String aid) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+FCourseNumber+"' and a.FAssistantId='"+aid+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String tid = listt.get(0);
		
		String sql1 = "from JfptTabUsualscore u where u.tabCourse.FCourseNumber='"+FCourseNumber+"' and u.tabStudents.FStudentNumber in (select distinct c.tabStudents.FStudentNumber from JfptTabChooseassociate c where c.tabTeachers.FTeacherNumber='"+tid+"' and c.tabCourse.FCourseNumber='"+FCourseNumber+"') order by u.tabStudents.FStudentNumber";
		String sql2 = "from JfptTabUsualscore u where u.tabCourse.FCourseNumber='"+FCourseNumber+"' and u.tabStudents.FStudentNumber in (select s.id.FStudentNumber from JfptTabStudentteacher s where s.id.FCourseNumber='"+FCourseNumber+"' and s.id.FTeacherNumber='"+tid+"') order by u.tabStudents.FStudentNumber";

		List<JfptTabUsualscore> list = this.getHibernateTemplate().find(sql1);
		if(list.size() >0 ){
			return list;
		}else{
			list = this.getHibernateTemplate().find(sql2);
			return list;
		}
	}

	/**
	 * <p>功能：添加作业通知信息<br>
	 * @param jfptTabHomenotice 作业通知信息
	 */
	public void addHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabHomenotice);
	}

	/**
	 * <p>功能：作业通知相关配置信息存储<br>
	 * @param jfptTabHomenoticetoreceive 通知配置信息
	 */
	public void addHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabHomenoticetoreceive);
	}

	/**
	 * <p>功能：删除作业信息，并级联删除相关的配置信息<br>
	 * @param jfptTabHomenotice 作业通知信息
	 */
	public void deleteHome(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		if(jfptTabHomenotice.getFUrl() == null || jfptTabHomenotice.getFUrl().equalsIgnoreCase("")){
			this.getHibernateTemplate().delete(jfptTabHomenotice);
		}else{
			String name = jfptTabHomenotice.getFUrl().substring(jfptTabHomenotice.getFUrl().lastIndexOf("/")+1);
			UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\HomeNotice\\", name);
			this.getHibernateTemplate().delete(jfptTabHomenotice);
		}
	}

	/**
	 * <p>功能：根据作业通知id号查找相关详细信息<br>
	 * @param id 作业通知id号
	 * @return JfptTabHomenotice 作业通知信息
	 */
	public JfptTabHomenotice findHomeDetailByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabHomenotice)this.getHibernateTemplate().get(JfptTabHomenotice.class, id);
	}

	/**
	 * <p>功能：查看个人发送的作业通知信息<br>
	 * @param tid 个人编号
	 * @return list 返回作业信息
	 */
	public List<JfptTabHomenotice> findHomeNoticeInfoByAid(String tid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabHomenotice h where h.mhqxTabUser.FUserNumber='"+tid+"'";
		List<JfptTabHomenotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：根据学生学号查找学生信息<br>
	 * @param id 学生学号
	 * @return TabStudents 学生信息
	 */
	public TabStudents findStudentsByID(String id) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
	}
	
	/**
	 * <p>功能：根据个人编号和课程编号查找相关的学生信息<br>
	 * @param id 个人编号
	 * @param Coursenumber 课程编号
	 * @return list 相关学生信息
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,String Coursenumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+Coursenumber+"' and a.FAssistantId='"+id+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String Tid = listt.get(0);
		
		String sql1 = "select distinct c.tabStudents from JfptTabChooseassociate c where c.tabTeachers.FTeacherNumber='"+Tid+"' and c.tabCourse.FCourseNumber='"+Coursenumber+"'";
		String sql2 = "select s.id.FStudentNumber from JfptTabStudentteacher s where s.id.FCourseNumber='"+Coursenumber+"' and s.id.FTeacherNumber='"+Tid+"'";
		List<TabStudents> list = this.getHibernateTemplate().find(sql1);
		if(list.size() > 0){
			return list;
		}else{
			List<String> list2 = this.getHibernateTemplate().find(sql2);
			List<TabStudents> list3 = new ArrayList<TabStudents>();
			for(String i: list2){
				list3.add((TabStudents)this.getHibernateTemplate().get(TabStudents.class, i));
			}
			return list3;
		}
	}

	/**
	 * <p>功能：根据个人编号查找User信息<br>
	 * @param id 个人编号
	 * @return MhqxTabUser User对象信息
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, id);
	}

	/**
	 * <p>功能：保存文件<br>
	 * @param uploadFile 上传文件
	 * @param savePath 保存路径
	 * @param uploadFileFileName 文件名称
	 */
	public void savefile(File uploadFile, String savePath,
			String uploadFileFileName) {
		// TODO Auto-generated method stub
		UpDownFileUtils.saveFile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>功能：根据上传作业信息id号查找相关详细信息<br>
	 * @param id 上传作业信息id号
	 * @return JfptTabHomeupload 上传作业对象信息
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabHomeupload)this.getHibernateTemplate().get(JfptTabHomeupload.class, id);
	}
	
	/**
	 * <p>功能：根据个人编号和课程编号查看相关的学生作业信息<br>
	 * @param aid 助教编号
	 * @param FCourseNumber 课程编号
	 * @return list 学生作业信息
	 */
	public List<JfptTabHomeupload> findHomeworkInfoByTwo(String aid,String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+FCourseNumber+"' and a.FAssistantId='"+aid+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String tid = listt.get(0);
		
		String sql1 = "from JfptTabHomeupload h where h.tabStudents.FStudentNumber in(select distinct c.tabStudents.FStudentNumber " +
		                "from JfptTabChooseassociate c where c.tabTeachers.FTeacherNumber='"+tid+"' and c.tabCourse.FCourseNumber='"+FCourseNumber+"') and h.tabCourse.FCourseNumber='"+FCourseNumber+"'";
        String sql2 = "from JfptTabHomeupload h where h.tabStudents.FStudentNumber in(select s.id.FStudentNumber from " +
		                 "JfptTabStudentteacher s where s.id.FCourseNumber='"+FCourseNumber+"' and s.id.FTeacherNumber='"+tid+"') and h.tabCourse.FCourseNumber='"+FCourseNumber+"'";
        List<JfptTabHomeupload> list = this.getHibernateTemplate().find(sql1);
        if(list.size() > 0){
	         return list;
        }else{
	         list = this.getHibernateTemplate().find(sql2);
	         return list;
        }
	}

	/**
	 * <p>功能：更新作业信息<br>
	 * @param jfptTabHomeupload 作业信息对象
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jfptTabHomeupload);
	}

	/**
	 * <p>功能：根据个人编号和课程编号查找相关的班级信息<br>
	 * @param id 个人编号
	 * @param FCourseNumber 课程编号
	 * @return list 返回相关班级编号信息
	 */
	public List<String> findClassNumberInfo(String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+FCourseNumber+"' and a.FAssistantId='"+id+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String tid = listt.get(0);
		
		String sql1 = "select distinct j.id.FClassNumber from JfptTabStudentteacher j where j.id.FTeacherNumber='"+tid+"' and j.id.FCourseNumber='"+FCourseNumber+"'";
		List<String> list = this.getHibernateTemplate().find(sql1);
		return list;
	}

	/**
	 * <p>功能：根据课程编号查找指定学生的方向信息<br>
	 * @param listStudentsInfo 学生对象信息
	 * @param FCourseNumber 课程编号信息
	 * @return list 返回方向信息
	 */
	public List<TabDirection> findDirectionInfo(
			List<TabStudents> listStudentsInfo, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabChooseassociate j where j.tabCourse.FCourseNumber = '"+FCourseNumber+"'";
		List<JfptTabChooseassociate> listt = this.getHibernateTemplate().find(sql);
		if(listt!=null && listt.size()>0){
			List<TabDirection> list = new ArrayList<TabDirection>();
			return list;
		}else{
			List<TabDirection> list = new ArrayList<TabDirection>();
			for(int i=0; i<listStudentsInfo.size(); i++){
				TabDirection directionn = listStudentsInfo.get(i).getTabDirection();
				if(list == null || (list.contains(directionn) != true)){
					list.add(directionn);
				}
			}
			return list;
		}
	}

	/**
	 * <p>功能：根据输入的班级信息、方向信息选择相应的学生对象信息<br>
	 * @param ClassNumber 班级信息
	 * @param DirectionNumber 方向编号
	 * @param listStudentsInfo 学生信息
	 * @return listt 学生信息
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		int size = listStudentsInfo.size();
		List<TabStudents> listt =  new ArrayList<TabStudents>();
		if(ClassNumber.equals("0") && DirectionNumber==0){
			return listStudentsInfo;
		}else if(ClassNumber.equals("0")){//按方向分类
			System.out.println("return direction the message!----------------------------------------------"+listStudentsInfo.size());
			for(int i=0; i<size; i++){
				System.out.println(listStudentsInfo.get(i).getTabDirection().getFDirectionId()+"------------------elements directionid");
				if(listStudentsInfo.get(i).getTabDirection().getFDirectionId()!=DirectionNumber){
				}else{
					listt.add(listStudentsInfo.get(i));
				}
			}
			return listt;
		}else{//按班级分类 
			System.out.println("return classes the message!----------------------------------------------");
			for(int i=0; i<size; i++){
				if(listStudentsInfo.get(i).getTabClasses().getFClassNumber().equals(ClassNumber)){
					listt.add(listStudentsInfo.get(i));
				}
			}
			return listt;
		}
	}
	
	/**
	 * <p>功能：更新学生信息，主要是统计学生平时相关成绩并汇总<br>
	 * @param listUsualscore 学生平时成绩
	 * @param listStudentsInfo 学生信息
	 * @param tabCourse 课程信息
	 */
	public void updateStudentsScore(List<JfptTabUsualscore> listUsualscore,List<TabStudents> listStudentsInfo,TabCourse tabCourse) {
		// TODO Auto-generated method stub
		if(listStudentsInfo.size() <= 0){
			return ;
		}
		String FXueQi = null;
		Date date = new Date();
		int year = (date.getYear()+1900)%100;
		int month = date.getMonth()+1;
		
		if(month>2 && month<8){
			FXueQi = year+"年上";  // 3 4 5 6 7 8 
		}else{
			FXueQi = year+"年下";  // 9 10 11 12 1 2 
		}
		
		if(listUsualscore.size() <= 0){
			for(int i=0; i<listStudentsInfo.size(); i++){
				JfptTabUsualscore huizong = new JfptTabUsualscore();
				huizong.setFScore(0);
				huizong.setFType("平时成绩汇总");
				huizong.setFXueQi(FXueQi);
				huizong.setTabCourse(tabCourse);
				huizong.setTabStudents(listStudentsInfo.get(i));
				this.getHibernateTemplate().save(huizong);
			}
			return ;
		}
		
		int total = 0; //考勤
		for(int i=0; i<listStudentsInfo.size(); i++){
			for(int j=0; j<listUsualscore.size(); j++){
				if(listUsualscore.get(j).getTabStudents().getFStudentNumber().equals(listStudentsInfo.get(i).getFStudentNumber())){
					total = total + listUsualscore.get(j).getFScore();
				}//end if
			}//end score for
			JfptTabUsualscore huizong = new JfptTabUsualscore();
			huizong.setFScore(total);
			huizong.setFType("平时成绩汇总");
			huizong.setFXueQi(FXueQi);
			huizong.setTabCourse(tabCourse);
			huizong.setTabStudents(listStudentsInfo.get(i));
			this.getHibernateTemplate().save(huizong);
			total = 0;
		}//end students for
		
	    //汇总完成后删除相关的平时成绩信息   listUsualscore
		for(JfptTabUsualscore i: listUsualscore){
			this.getHibernateTemplate().delete(i);
		}
	}
	
	/**
	 * <p>功能：根据选择的方向信息或者班级信息对学生成绩进行筛选提取<br>
	 * @param ClassNumber 班级信息
	 * @param DirectionNumber 方向编号
	 * @param listStudentsInfo 学生信息
	 * @param listUsualscoreInfo 学生成绩信息
	 * @return lists 学生成绩信息
	 */
	public List<JfptTabUsualscore> findUsualscoreInfo(String ClassNumber,int DirectionNumber,List<TabStudents> listStudentsInfo, List<JfptTabUsualscore> listUsualscoreInfo){
		int size = listStudentsInfo.size();
		List<TabStudents> listt =  new ArrayList<TabStudents>();
		if(ClassNumber.equals("0") && DirectionNumber==0){//listStudentsInfo
			for(TabStudents i : listStudentsInfo){
				listt.add(i);
			}
		}else if(ClassNumber.equals("0")){//按方向分类
			for(int i=0; i<size; i++){
				if(listStudentsInfo.get(i).getTabDirection().getFDirectionId()!=DirectionNumber){
				}else{
					listt.add(listStudentsInfo.get(i));
				}
			}
		}else{//按班级分类 
			for(int i=0; i<size; i++){
				if(listStudentsInfo.get(i).getTabClasses().getFClassNumber().equals(ClassNumber)){
					listt.add(listStudentsInfo.get(i));
				}
			}
		}
		//符合条件的学生信息已经选出来了  listt
		if(ClassNumber.equals("0") && DirectionNumber==0){
			return listUsualscoreInfo;
		}else{
			List<JfptTabUsualscore> lists = new ArrayList<JfptTabUsualscore>();
			for(int i=0; i<listt.size(); i++){//遍历符合条件的学生
				for(int m=0; m<listUsualscoreInfo.size(); m++){//遍历所有的成绩信息
					if(listUsualscoreInfo.get(m).getTabStudents().getFStudentNumber().equals(listt.get(i).getFStudentNumber())){
						lists.add(listUsualscoreInfo.get(m));
					}
				}
			}
			return lists;
		}
	}

}
