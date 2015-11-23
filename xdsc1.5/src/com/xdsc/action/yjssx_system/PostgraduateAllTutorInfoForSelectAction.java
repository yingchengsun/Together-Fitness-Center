package com.xdsc.action.yjssx_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;

/**
 * �๦�ܣ���ʾ���е�ʦ����Ϣ������ѡ��ʦ
 * @author ����
 * @version 1.1
 */
public class PostgraduateAllTutorInfoForSelectAction extends ActionSupport {

	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	/**
	 * ���е�ʦ����Ϣ�б�
	 */
	private List<TabTeachers> allTutorInfo;
	
	/**
	 * ��ʾ��ʦ��Ϣ����
	 */
	private String DetailNum;
	
	private TabTeachers detailInfo;
	
	/**
	 * ���ҵ����е�ʦ����Ϣ�б�
	 * @return findAllTutorInfo ��Ϣ���ҳɹ�
	 */
	public String findAllTutorInfo(){
		allTutorInfo = postgraduateTutorSelectService.findAllTutorInfo();
		return "findAllTutorInfo";
	}
	
	/**
	 * �����ڵ�����������ʾ��ʦ��Ϣ
	 * @return ��ʦ��Ϣ�б�
	 */
	public String AllTutorInfo(){
		allTutorInfo = postgraduateTutorSelectService.findAllTutorInfo();
		return "allTutorInfo";
	}
	
	/**
	 * ��ʾ��ʦ����ϸ��Ϣ
	 * @return ͨ����ʦ��Id���ҵ���ʦ����ϸ��Ϣ
	 */
	public String findTutorDetailInfo(){
		detailInfo = postgraduateTutorSelectService.findTutorInfoByNum(DetailNum);
		return "findTutorDetailInfo";
	}

	public PostgraduateTutorSelectService getPostgraduateTutorSelectService() {
		return postgraduateTutorSelectService;
	}

	public void setPostgraduateTutorSelectService(
			PostgraduateTutorSelectService postgraduateTutorSelectService) {
		this.postgraduateTutorSelectService = postgraduateTutorSelectService;
	}

	public List<TabTeachers> getAllTutorInfo() {
		return allTutorInfo;
	}

	public void setAllTutorInfo(List<TabTeachers> allTutorInfo) {
		this.allTutorInfo = allTutorInfo;
	}

	public String getDetailNum() {
		return DetailNum;
	}

	public void setDetailNum(String detailNum) {
		DetailNum = detailNum;
	}

	public TabTeachers getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(TabTeachers detailInfo) {
		this.detailInfo = detailInfo;
	}
	
}
