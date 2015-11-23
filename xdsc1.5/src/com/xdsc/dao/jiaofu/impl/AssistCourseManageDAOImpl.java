package com.xdsc.dao.jiaofu.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.AssistCourseManageDAO;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.util.UpDownFileUtils;

/**
 * <p>���ܣ����̿γ̹�����صĲ����������γ���Ϣ��ѯ���γ�֪ͨ����Ӻ�ɾ�����γ̴��ɵĲ��ҡ�ɾ���ͻظ���<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class AssistCourseManageDAOImpl extends HibernateDaoSupport implements AssistCourseManageDAO{

	/**
	 * <p>���ܣ���������id�Ų�����֮��صĿγ���Ϣ<br>
	 * @param id ����id��
	 * @return list �γ���Ϣ
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
	 * <p>���ܣ���ӿγ̴��ɻظ�<br>
	 * @param jfptTabCoursereplyquestion �γ̴��ɻظ�������Ϣ
	 */
	public void addCoursereplyInfo(
			JfptTabCoursereplyquestion jfptTabCoursereplyquestion) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCoursereplyquestion);
	}

	/**
	 * <p>���ܣ����ݿγ̴��ɶ���idɾ����֮ƥ��Ĵ�����Ϣ<br>
	 * @param id ���ɶ���id��
	 */
	public void deleteAskQuestionByID(int id) {
		// TODO Auto-generated method stub
		JfptTabCourseaskquestion jfptTabCourseaskquestion = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion = (JfptTabCourseaskquestion)this.getHibernateTemplate().get(jfptTabCourseaskquestion.getClass(), id);
		this.getHibernateTemplate().delete(jfptTabCourseaskquestion);
	}

	/**
	 * <p>���ܣ����ݿγ̴���id�Ų�����صĻظ���Ϣ<br>
	 * @param id �γ̴��ɵ�id��
	 * @return list ��صĻظ���Ϣ
	 */
	public List<JfptTabCoursereplyquestion> findCourseReplyInfoByID(int id) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCoursereplyquestion r where r.jfptTabCourseaskquestion.FQuestionId="+id;
		List<JfptTabCoursereplyquestion> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�ͨ���γ̴���id�Ų�����֮ƥ��Ķ�����Ϣ<br>
	 * @param id �γ̴���id��
	 * @return JfptTabCourseaskquestion ������صĿγ̴��ɶ�����Ϣ
	 */
	public JfptTabCourseaskquestion findCourseaskquestionInfoByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabCourseaskquestion)this.getHibernateTemplate().get(JfptTabCourseaskquestion.class, id);
	}

	/**
	 * <p>���ܣ���������id�źͿγ̱�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ����id��
	 * @param FCourseNumber �γ̱��
	 * @return list ������صĿγ̴�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplayInfoByTwo(
			String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCourseaskquestion a where a.tabCourse.FCourseNumber in(select distinct a.tabCourse.FCourseNumber " +
				"from JfptTabAssistantapply a where a.FAssistantId='"+id+"' and a.tabCourse.FCourseNumber='"+FCourseNumber+"')";
		List<JfptTabCourseaskquestion> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ���������id�Ų�����صĿγ̴�����Ϣ<br>
	 * @param id ����id��
	 * @return list ���ز��ҵ�����Ϣ
	 */
	public List<JfptTabCourseaskquestion> findQuestionReplyInfoByAid(String id) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCourseaskquestion a where a.tabCourse.FCourseNumber in(select distinct a.tabCourse.FCourseNumber " +
		             "from JfptTabAssistantapply a where a.FAssistantId='"+id+"')";
        List<JfptTabCourseaskquestion> list = this.getHibernateTemplate().find(sql);
        return list;
	}

	/**
	 * <p>���ܣ���ӿγ�֪ͨ��Ϣ<br>
	 * @param jfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public void addCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabCoursenotice);
	}

	/**
	 * <p>���ܣ���ӿγ�֪ͨ�Ķ�Ӧ����������Ϣ<br>
	 * @param jfptTabNoticetoreceive �γ�֪ͨ��Ӧ�Ĺ���������Ϣ
	 */
	public void addCoursenoticetoto(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabNoticetoreceive);
	}

	/**
	 * <p>���ܣ�ɾ���γ�֪ͨ��Ϣ<br>
	 * @param jfptTabCoursenotice �γ�֪ͨ������Ϣ
	 */
	public void deleteCourseNoticeInfo(JfptTabCoursenotice jfptTabCoursenotice) {
		// TODO Auto-generated method stub
		if(jfptTabCoursenotice.getFUrl()==null || jfptTabCoursenotice.getFUrl().equalsIgnoreCase("")){
			this.getHibernateTemplate().delete(jfptTabCoursenotice);
		}else{
			String name = jfptTabCoursenotice.getFUrl().substring(jfptTabCoursenotice.getFUrl().lastIndexOf("/")+1);
			UpDownFileUtils.deleteFile("\\files\\jfpt_system\\Resource\\CourseNotice\\", name);
			this.getHibernateTemplate().delete(jfptTabCoursenotice);
		}
	}

	/**
	 * <p>���ܣ����ݿγ̱�Ų�����صĿγ���Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse ������صĿγ̶�����Ϣ
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, id);
	}

	/**
	 * <p>���ܣ�����id�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id ���˱��
	 * @return list �γ�֪ͨ������Ϣ
	 */
	public List<JfptTabCoursenotice> findCourseNoticeInfo(String id) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabCoursenotice c where c.mhqxTabUser.FUserNumber='"+id+"'";
		List<JfptTabCoursenotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ����ݿγ�֪ͨid�Ų�����صĿγ�֪ͨ��Ϣ<br>
	 * @param id �γ�֪ͨid��
	 * @return JfptTabCoursenotice �γ�֪ͨ��Ϣ
	 */
	public JfptTabCoursenotice findCourseNoticeInfoByID(int id) {
		// TODO Auto-generated method stub
		return (JfptTabCoursenotice)this.getHibernateTemplate().get(JfptTabCoursenotice.class, id);
	}

	/**
	 * <p>���ܣ����ݸ��˱�źͿγ̺Ų�����ص�ѧ����Ϣ<br>
	 * @param id ���˱��
	 * @param Coursenumber �γ̱��
	 * @return list ѧ����Ϣ <br>list3 ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfoByTwo(String id,String Coursenumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+Coursenumber+"' and a.FAssistantId='"+id+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String Tid = listt.get(0);
		System.out.println(Tid);
		
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
	 * <p>���ܣ����ݸ��˱�Ų���User����<br>
	 * @param id�����˱��
	 * @return MhqxTabUser ���ز��ҵ�����User��Ϣ
	 */
	public MhqxTabUser findUserByID(String id) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, id);
	}

	/**
	 * <p>���ܣ������ļ�<br>
	 * @see com.xdsc.util.UpDownFileUtils
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
	 * <p>���ܣ����ݸ��˱�źͿγ̱�Ų�����صİ༶����Ϣ<br>
	 * @param id ���˱��
	 * @param FCourseNumber �γ̱��
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findClassNumberInfo(java.lang.String, java.lang.String)
	 * @return list �༶����Ϣ
	 */
	public List<String> findClassNumberInfo(String id, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "select a.tabTeachers.FTeacherNumber from JfptTabAssistantapply a where a.FShenQing='N' and a.tabCourse.FCourseNumber='"+FCourseNumber+"' and a.FAssistantId='"+id+"'";
		List<String> listt = this.getHibernateTemplate().find(sql);
		String Tid = listt.get(0);
		
		String sql1 = "select distinct j.id.FClassNumber from JfptTabStudentteacher j where j.id.FTeacherNumber='"+Tid+"' and j.id.FCourseNumber='"+FCourseNumber+"'";
		List<String> list = this.getHibernateTemplate().find(sql1);
		return list;
	}

	/**
	 * <p>���ܣ�����ָ����Χ�ڵ�ѧ���ķ�����Ϣ<br>
	 * @param listStudentsInfo ѧ����Ϣ
	 * @param FCourseNumber �γ̱����Ϣ
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findDirectionInfo(java.util.List, java.lang.String)
	 * @return list ������Ϣ
	 */
	public List<TabDirection> findDirectionInfo(
			List<TabStudents> listStudentsInfo, String FCourseNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabChooseassociate j where j.tabCourse.FCourseNumber ='"+FCourseNumber+"'";
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
	 * <p>���ܣ����ݰ༶�š��������ָ����Χ�ڵ�ѧ���в������ѧ����Ϣ<br>
	 * @param ClassNumber �༶��
	 * @param DirectionNumber ������
	 * @param listStudentsInfo��ѧ����Ϣ
	 * @see com.xdsc.dao.jiaofu.AssistCourseManageDAO#findStudentsInfo(java.lang.String, int, java.util.List)
	 * @return listt ѧ����Ϣ
	 */
	public List<TabStudents> findStudentsInfo(String ClassNumber,
			int DirectionNumber, List<TabStudents> listStudentsInfo) {
		// TODO Auto-generated method stub
		int size = listStudentsInfo.size();
		List<TabStudents> listt =  new ArrayList<TabStudents>();
		System.out.println("ClassNumber---"+ClassNumber+"DirectionNumber-----"+DirectionNumber);
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

}
