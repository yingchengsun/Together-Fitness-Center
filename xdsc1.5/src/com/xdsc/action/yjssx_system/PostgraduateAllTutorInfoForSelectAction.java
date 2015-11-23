package com.xdsc.action.yjssx_system;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.yjssx_system.PostgraduateTutorSelectService;

/**
 * 类功能：显示所有导师的信息，用于选择导师
 * @author 许鑫
 * @version 1.1
 */
public class PostgraduateAllTutorInfoForSelectAction extends ActionSupport {

	private PostgraduateTutorSelectService postgraduateTutorSelectService;
	
	/**
	 * 所有导师的信息列表
	 */
	private List<TabTeachers> allTutorInfo;
	
	/**
	 * 显示导师信息详情
	 */
	private String DetailNum;
	
	private TabTeachers detailInfo;
	
	/**
	 * 查找到所有导师的信息列表
	 * @return findAllTutorInfo 信息查找成功
	 */
	public String findAllTutorInfo(){
		allTutorInfo = postgraduateTutorSelectService.findAllTutorInfo();
		return "findAllTutorInfo";
	}
	
	/**
	 * 用于在弹出窗口中显示导师信息
	 * @return 导师信息列表
	 */
	public String AllTutorInfo(){
		allTutorInfo = postgraduateTutorSelectService.findAllTutorInfo();
		return "allTutorInfo";
	}
	
	/**
	 * 显示导师的详细信息
	 * @return 通过导师的Id查找到导师的详细信息
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
