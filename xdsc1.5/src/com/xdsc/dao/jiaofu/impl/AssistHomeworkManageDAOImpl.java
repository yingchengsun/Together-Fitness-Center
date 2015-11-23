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
 * <p>���ܣ��й���ҵ�������漰���ķ�����������ҵ֪ͨ����ҵ���ġ��ɼ������<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistHomeworkManageDAOImpl extends HibernateDaoSupport implements AssistHomeworkManageDAO{

	/**
	 * <p>���ܣ����ƽʱ�ɼ���Ϣ<br>
	 * @param jfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public void addUsualScoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabUsualscore);
	}

	/**
	 * <p>���ܣ�ɾ��ƽʱ�ɼ���Ϣ<br>
	 * @param jfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public void deleteUsualscoreInfo(JfptTabUsualscore jfptTabUsualscore) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabUsualscore);
	}
	
	/**
	 * <p>���ܣ����ݸ���id�Ų�����صĿγ���Ϣ<br>
	 * @param id ���˱��
	 * @return list ������صĿγ���Ϣ
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
	 * <p>���ܣ����ݿγ̺Ų��ҿγ���ϸ��Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @return TabCourse �γ������Ϣ
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�����ص�ѧ����Ϣ<br>
	 * @param FStudentNumber ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsInfoByID(String FStudentNumber) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, FStudentNumber);
	}

	/**
	 * <p>���ܣ����ݳɼ�id�Ų�����صĳɼ���Ϣ<br>
	 * @param FNumber �ɼ���Ϣid��
	 * @return JfptTabUsualscore ƽʱ�ɼ���Ϣ
	 */
	public JfptTabUsualscore findUsualscoreInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		return (JfptTabUsualscore)this.getHibernateTemplate().get(JfptTabUsualscore.class, FNumber);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص�ѧ���ĳɼ���Ϣ<br>
	 * @param FCourseNumber �γ̱��
	 * @param aid ���̱��
	 * @return list ѧ���ɼ���Ϣ
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
	 * <p>���ܣ������ҵ֪ͨ��Ϣ<br>
	 * @param jfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public void addHomenotice(JfptTabHomenotice jfptTabHomenotice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabHomenotice);
	}

	/**
	 * <p>���ܣ���ҵ֪ͨ���������Ϣ�洢<br>
	 * @param jfptTabHomenoticetoreceive ֪ͨ������Ϣ
	 */
	public void addHomenoticetoto(
			JfptTabHomenoticetoreceive jfptTabHomenoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabHomenoticetoreceive);
	}

	/**
	 * <p>���ܣ�ɾ����ҵ��Ϣ��������ɾ����ص�������Ϣ<br>
	 * @param jfptTabHomenotice ��ҵ֪ͨ��Ϣ
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
	 * <p>���ܣ�������ҵ֪ͨid�Ų��������ϸ��Ϣ<br>
	 * @param id ��ҵ֪ͨid��
	 * @return JfptTabHomenotice ��ҵ֪ͨ��Ϣ
	 */
	public JfptTabHomenotice findHomeDetailByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabHomenotice)this.getHibernateTemplate().get(JfptTabHomenotice.class, id);
	}

	/**
	 * <p>���ܣ��鿴���˷��͵���ҵ֪ͨ��Ϣ<br>
	 * @param tid ���˱��
	 * @return list ������ҵ��Ϣ
	 */
	public List<JfptTabHomenotice> findHomeNoticeInfoByAid(String tid) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabHomenotice h where h.mhqxTabUser.FUserNumber='"+tid+"'";
		List<JfptTabHomenotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų���ѧ����Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return TabStudents ѧ����Ϣ
	 */
	public TabStudents findStudentsByID(String id) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
	}
	
	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����ص�ѧ����Ϣ<br>
	 * @param id ���˱��
	 * @param Coursenumber �γ̱��
	 * @return list ���ѧ����Ϣ
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
	 * <p>���ܣ����ݸ��˱�Ų���User��Ϣ<br>
	 * @param id ���˱��
	 * @return MhqxTabUser User������Ϣ
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, id);
	}

	/**
	 * <p>���ܣ������ļ�<br>
	 * @param uploadFile �ϴ��ļ�
	 * @param savePath ����·��
	 * @param uploadFileFileName �ļ�����
	 */
	public void savefile(File uploadFile, String savePath,
			String uploadFileFileName) {
		// TODO Auto-generated method stub
		UpDownFileUtils.saveFile(uploadFile, savePath, uploadFileFileName);
	}

	/**
	 * <p>���ܣ������ϴ���ҵ��Ϣid�Ų��������ϸ��Ϣ<br>
	 * @param id �ϴ���ҵ��Ϣid��
	 * @return JfptTabHomeupload �ϴ���ҵ������Ϣ
	 */
	public JfptTabHomeupload findHomeworkDetailByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabHomeupload)this.getHibernateTemplate().get(JfptTabHomeupload.class, id);
	}
	
	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų鿴��ص�ѧ����ҵ��Ϣ<br>
	 * @param aid ���̱��
	 * @param FCourseNumber �γ̱��
	 * @return list ѧ����ҵ��Ϣ
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
	 * <p>���ܣ�������ҵ��Ϣ<br>
	 * @param jfptTabHomeupload ��ҵ��Ϣ����
	 */
	public void updateHomeworkInfo(JfptTabHomeupload jfptTabHomeupload) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(jfptTabHomeupload);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����صİ༶��Ϣ<br>
	 * @param id ���˱��
	 * @param FCourseNumber �γ̱��
	 * @return list ������ذ༶�����Ϣ
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
	 * <p>���ܣ����ݿγ̱�Ų���ָ��ѧ���ķ�����Ϣ<br>
	 * @param listStudentsInfo ѧ��������Ϣ
	 * @param FCourseNumber �γ̱����Ϣ
	 * @return list ���ط�����Ϣ
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
	 * <p>���ܣ���������İ༶��Ϣ��������Ϣѡ����Ӧ��ѧ��������Ϣ<br>
	 * @param ClassNumber �༶��Ϣ
	 * @param DirectionNumber ������
	 * @param listStudentsInfo ѧ����Ϣ
	 * @return listt ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		int size = listStudentsInfo.size();
		List<TabStudents> listt =  new ArrayList<TabStudents>();
		if(ClassNumber.equals("0") && DirectionNumber==0){
			return listStudentsInfo;
		}else if(ClassNumber.equals("0")){//���������
			System.out.println("return direction the message!----------------------------------------------"+listStudentsInfo.size());
			for(int i=0; i<size; i++){
				System.out.println(listStudentsInfo.get(i).getTabDirection().getFDirectionId()+"------------------elements directionid");
				if(listStudentsInfo.get(i).getTabDirection().getFDirectionId()!=DirectionNumber){
				}else{
					listt.add(listStudentsInfo.get(i));
				}
			}
			return listt;
		}else{//���༶���� 
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
	 * <p>���ܣ�����ѧ����Ϣ����Ҫ��ͳ��ѧ��ƽʱ��سɼ�������<br>
	 * @param listUsualscore ѧ��ƽʱ�ɼ�
	 * @param listStudentsInfo ѧ����Ϣ
	 * @param tabCourse �γ���Ϣ
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
			FXueQi = year+"����";  // 3 4 5 6 7 8 
		}else{
			FXueQi = year+"����";  // 9 10 11 12 1 2 
		}
		
		if(listUsualscore.size() <= 0){
			for(int i=0; i<listStudentsInfo.size(); i++){
				JfptTabUsualscore huizong = new JfptTabUsualscore();
				huizong.setFScore(0);
				huizong.setFType("ƽʱ�ɼ�����");
				huizong.setFXueQi(FXueQi);
				huizong.setTabCourse(tabCourse);
				huizong.setTabStudents(listStudentsInfo.get(i));
				this.getHibernateTemplate().save(huizong);
			}
			return ;
		}
		
		int total = 0; //����
		for(int i=0; i<listStudentsInfo.size(); i++){
			for(int j=0; j<listUsualscore.size(); j++){
				if(listUsualscore.get(j).getTabStudents().getFStudentNumber().equals(listStudentsInfo.get(i).getFStudentNumber())){
					total = total + listUsualscore.get(j).getFScore();
				}//end if
			}//end score for
			JfptTabUsualscore huizong = new JfptTabUsualscore();
			huizong.setFScore(total);
			huizong.setFType("ƽʱ�ɼ�����");
			huizong.setFXueQi(FXueQi);
			huizong.setTabCourse(tabCourse);
			huizong.setTabStudents(listStudentsInfo.get(i));
			this.getHibernateTemplate().save(huizong);
			total = 0;
		}//end students for
		
	    //������ɺ�ɾ����ص�ƽʱ�ɼ���Ϣ   listUsualscore
		for(JfptTabUsualscore i: listUsualscore){
			this.getHibernateTemplate().delete(i);
		}
	}
	
	/**
	 * <p>���ܣ�����ѡ��ķ�����Ϣ���߰༶��Ϣ��ѧ���ɼ�����ɸѡ��ȡ<br>
	 * @param ClassNumber �༶��Ϣ
	 * @param DirectionNumber ������
	 * @param listStudentsInfo ѧ����Ϣ
	 * @param listUsualscoreInfo ѧ���ɼ���Ϣ
	 * @return lists ѧ���ɼ���Ϣ
	 */
	public List<JfptTabUsualscore> findUsualscoreInfo(String ClassNumber,int DirectionNumber,List<TabStudents> listStudentsInfo, List<JfptTabUsualscore> listUsualscoreInfo){
		int size = listStudentsInfo.size();
		List<TabStudents> listt =  new ArrayList<TabStudents>();
		if(ClassNumber.equals("0") && DirectionNumber==0){//listStudentsInfo
			for(TabStudents i : listStudentsInfo){
				listt.add(i);
			}
		}else if(ClassNumber.equals("0")){//���������
			for(int i=0; i<size; i++){
				if(listStudentsInfo.get(i).getTabDirection().getFDirectionId()!=DirectionNumber){
				}else{
					listt.add(listStudentsInfo.get(i));
				}
			}
		}else{//���༶���� 
			for(int i=0; i<size; i++){
				if(listStudentsInfo.get(i).getTabClasses().getFClassNumber().equals(ClassNumber)){
					listt.add(listStudentsInfo.get(i));
				}
			}
		}
		//����������ѧ����Ϣ�Ѿ�ѡ������  listt
		if(ClassNumber.equals("0") && DirectionNumber==0){
			return listUsualscoreInfo;
		}else{
			List<JfptTabUsualscore> lists = new ArrayList<JfptTabUsualscore>();
			for(int i=0; i<listt.size(); i++){//��������������ѧ��
				for(int m=0; m<listUsualscoreInfo.size(); m++){//�������еĳɼ���Ϣ
					if(listUsualscoreInfo.get(m).getTabStudents().getFStudentNumber().equals(listt.get(i).getFStudentNumber())){
						lists.add(listUsualscoreInfo.get(m));
					}
				}
			}
			return lists;
		}
	}

}
