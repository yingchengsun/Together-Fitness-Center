package com.xdsc.action.wsbm;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;
import com.xdsc.service.wsbm.KsCheckManager;
import com.xdsc.service.wsbm.MegManager;

/**管理员后台网站信息查询
 * @author 苟小龙
 * @version 1.2
 *
 */
public class AdAllCheckAction extends ActionSupport implements SessionAware{
	/**
	 * 登陆相关属性
	 */
	private Map session;
	/**
	 * service层接口相关属性
	 */
	private AdAllCheckManager aacm;
	private MegManager mm;
	/**
	 * 考生信息属性
	 */
	private String FAppRegNum;
	/**
	 * 留言信息相关属性
	 */
	private int FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private String art;
	/**
	 * 考生数据库类对象
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * 通知信息数据库类对象
	 */
	private TabNotice tabNotice;
	/**
	 * 考生数据库类对象队列属性
	 */
	private List<WsbmTabRegapplicant> listRegapplicantinfo;
	/**
	 * 通知信息数据库类对象队列属性
	 */
	private List<TabNotice> listTabNotice;
	/**
	 * 考生信息相关属性
	 */
	private String FAppRegName;
	private String FUserNumber;
	private String FUserPassword;
	private String FAppRegSex;//
	private Date FAppRegBirthday;//
	private String FAppRegIdCard;//
	private String FAppRegPolitical;//
	private String FAppRegLocation;//
	private String FAppRegWorkDuty;//
	private String FAppRegWorkTitle;//
	private String FAppRegTel;//
	private String FAppRegAddress;//
	private String FAppRegPostCode;//
	private Date FAppRegLastGraduDate;//
	private String FAppRegLastGraduInstitu;//
	private String FAppRegLastGraduMajor;//
	private Date FAppRegLastBacheDegreeDate;//
	private String FAppRegXueWeiZhengNum;//
	private String FAppRegBiYeZhengNum;//
	private String FAppRegEmail;//
	private Integer FAppRegCet4;
	private Integer FAppRegCet6;
	private String FAppRegNation;//
	private String FAppRegQgtkao;//
	private String FAppRegCv;//
	private String FAppRegHomeTown;//
	private String FAppRegPassPreAd;
	private String FAppRegPassFinAd;
	private String FAppRegPassAuth;
	private String FAppRegQgtkaoNum;
	private String FAppRegBaoMingFei;
	private String FAppRegBackUpText;
	private int FAppRegQGTKaoZhuanYeKe;
	private int FAppRegQGTKaoZhengzhi;
	private int FAppRegQGTKaoEnglish;
	private String FAppRegZhunKaoZhengHao;
	private KsCheckManager ram;
	
	private String AppRegBirthday;
	private String AppRegLastGraduDate;
	private String AppRegLastBacheDegreeDate;
	private String AppRegName;
	private String AppRegIdCard;
	private List<WsbmTabExamsubject> listWsbmTabExamsubject;

	
	private int p = 1;

	private int lastPage;
	public AdAllCheckManager getAacm() {
		return aacm;
	}
	public void setAacm(AdAllCheckManager aacm) {
		this.aacm = aacm;
	}
	public List<WsbmTabRegapplicant> getListRegapplicantinfo() {
		return listRegapplicantinfo;
	}
	public void setListRegapplicantinfo(
			List<WsbmTabRegapplicant> listRegapplicantinfo) {
		this.listRegapplicantinfo = listRegapplicantinfo;
	}
	/** 显示所有考生信息梗概列表
	 * @return success 获取考生对象列表成功
	 */
	public String execute(){
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "success";
	}
	
	/** 查询考生个人信息验证通过的所有考生
	 * @return success 查询成功
	 */
	public String AuthPass(){
		listRegapplicantinfo=aacm.findAuthPassRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "AuthPass";
	}
	
	/**查询所有已交报名费的考生
	 * 
	 * @return success 查询成功
	 */
	public String feed(){
		listRegapplicantinfo=aacm.findfeed();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "feed";
	}
	
	/**查询所有未交报名费的考生
	 * 
	 * @return success 查询成功
	 */
	public String unfeed(){
		listRegapplicantinfo=aacm.unfindfeed();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "unfeed";
	}
	
	/**查询正在考生个人信息验证的所有考生
	 * @return success 查询成功
	 */
	public String Authing(){
		listRegapplicantinfo=aacm.findAuthingRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "Authing";
	}
	
	/** 查询未通过预录取的所有考生
	 * @return success 查询成功
	 */
	public String PrePassNot(){
		listRegapplicantinfo=aacm.findPrePassNotRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "PrePassNot";
	}
	 
	/** 查询所有通过预录取的考生
	 * @return success 查询成功
	 */
	public String PrePass(){
		listRegapplicantinfo=aacm.findPrePassRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "PrePass";
	}
	
	/** 查询所有预录取结果未定的考生
	 * @return success 查询成功
	 */
	public String Preing(){
		listRegapplicantinfo=aacm.findPreingRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "Preing";
	}
	
	
	/** 查询所有最终未录取的考生
	 * @return success 查询成功
	 */
	public String FinPassNot(){
		listRegapplicantinfo=aacm.findFinPassNotRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "FinPassNot";
	}
	
	/** 查询所有最终被录取的考生
	 * @return success 查询成功
	 */
	public String FinPass(){
		listRegapplicantinfo=aacm.findFinPassRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "FinPass";
	}
	
	/**查询所有未确定最终录取与否的考生
	 * @return success 查询成功
	 */
	public String Fining(){
		listRegapplicantinfo=aacm.findFiningRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "Fining";
	}
	
	/** 查询所有未通过个人信息验证的考生
	 * @return success 查询成功
	 */
	public String AuthPassNot(){
		listRegapplicantinfo=aacm.findAuthPassNotRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "AuthPassNot";
	}
	
	/** 返回所有可以选择删除的考生列表
	 * @return successDelete 操作成功
	 */
	public String delete(){
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "successDelete";
	}
	
	/** 查看所有网站公告信息
	 * @return Notice 查询成功
	 */
	public String notice(){
		listTabNotice = aacm.findNotice();
		if(listTabNotice.size()>10){
			int pages = 10;
			int listlength = this.listTabNotice.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listTabNotice = this.listTabNotice.subList(startIndex, endIndex);
		}
		return "Notice";
	}
	
	/** 考生查询网站公告信息
	 * @return NoticeApp 查询成功
	 */
	public String noticeApp(){
		listTabNotice = aacm.findNotice();
		return "NoticeApp";
	}
	
	/**游客查询网站公告信息
	 * @return noticeVisitor 查询成功
	 */
	public String noticeVisitor(){
		listTabNotice = aacm.findNotice();
		return "noticeVisitor";
	}
	
	public String noticeVisitor1(){
		listTabNotice = aacm.findNotice();
		return "noticeVisitor1";
	}
	
	/** 根据考生考生系统注册号码详细查询考生信息
	 * @return sepFindByNum 查询成功
	 */
	public String sepFindByNum(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		return "sepFindByNum";
	}
	
	/** 根据考生考生系统注册号码详细预览考生资格审查表
	 * @return sepFindByNumSeeCheckList 查询成功
	 */
	public String sepFindByNumSeeCheckList(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		AppRegBirthday=wsbmTabRegapplicant.getFAppRegBirthday().toString();
		AppRegBirthday=AppRegBirthday.substring(0, 10);
		AppRegLastGraduDate=wsbmTabRegapplicant.getFAppRegLastGraduDate().toString();
		AppRegLastGraduDate=AppRegLastGraduDate.substring(0, 4)+"年"+AppRegLastGraduDate.substring(5, 7)+"月";
		AppRegLastBacheDegreeDate=wsbmTabRegapplicant.getFAppRegLastBacheDegreeDate().toString();
		AppRegLastBacheDegreeDate=AppRegLastBacheDegreeDate.substring(0, 10);
		return "sepFindByNumSeeCheckList";
	}
	public String sepFindByNumSeeZhunkaozheng(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		AppRegBirthday=wsbmTabRegapplicant.getFAppRegBirthday().toString();
		AppRegBirthday=AppRegBirthday.substring(0, 10);
		AppRegName=wsbmTabRegapplicant.getFAppRegName();
		AppRegIdCard=wsbmTabRegapplicant.getFAppRegIdCard();
		listWsbmTabExamsubject=ram.findExamsubject();
		listWsbmTabExamsubject.toArray();
		System.out.println("Got list");
		System.out.println(listWsbmTabExamsubject);
		return "sepFindByNumSeeZhunkaozheng";
	}
	
	/** 根据考生浏览自己的考生资格审查表
	 * @return SeeCheckList 查询成功
	 */
	public String SeeCheckList(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		AppRegBirthday=wsbmTabRegapplicant.getFAppRegBirthday().toString();
		AppRegBirthday=AppRegBirthday.substring(0, 10);
		AppRegLastGraduDate=wsbmTabRegapplicant.getFAppRegLastGraduDate().toString();
		AppRegLastGraduDate=AppRegLastGraduDate.substring(0, 4)+"年"+AppRegLastGraduDate.substring(5, 7)+"月";
		AppRegLastBacheDegreeDate=wsbmTabRegapplicant.getFAppRegLastBacheDegreeDate().toString();
		AppRegLastBacheDegreeDate=AppRegLastBacheDegreeDate.substring(0, 10);
		return "SeeCheckList";
	}
	
	/**根据考生系统注册号码更新考生信息
	 * @return findAppToUpdate 找到考生
	 */
	public String findAppToUpdate(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		return "findAppToUpdate";
	}
	
	/** 考生更新自己的个人信息
	 * @return findMeToUpdate 成功找到并更新
	 */
	public String findMeToUpdate(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		return "findMeToUpdate";
	}
	
	/**更新考生个人信息
	 * @return appUpdated 考生信息更新成功
	 * 
	 */
	public String appUpdate(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		wsbmTabRegapplicant.setFAppRegAddress(FAppRegAddress);
		wsbmTabRegapplicant.setFAppRegBirthday(FAppRegBirthday);
		wsbmTabRegapplicant.setFAppRegBiYeZhengNum(FAppRegBiYeZhengNum);
		wsbmTabRegapplicant.setFAppRegCet4(FAppRegCet4);
		wsbmTabRegapplicant.setFAppRegCet6(FAppRegCet6);
		wsbmTabRegapplicant.setFAppRegCv(FAppRegCv);
		wsbmTabRegapplicant.setFAppRegEmail(FAppRegEmail);
		wsbmTabRegapplicant.setFAppRegIdCard(FAppRegIdCard);
		wsbmTabRegapplicant.setFAppRegLastBacheDegreeDate(FAppRegLastBacheDegreeDate);
		wsbmTabRegapplicant.setFAppRegLastGraduDate(FAppRegLastGraduDate);
		wsbmTabRegapplicant.setFAppRegLastGraduInstitu(FAppRegLastGraduInstitu);
		wsbmTabRegapplicant.setFAppRegLastGraduMajor(FAppRegLastGraduMajor);
		wsbmTabRegapplicant.setFAppRegLocation(FAppRegLocation);
		wsbmTabRegapplicant.setFAppRegNation(FAppRegNation);
		wsbmTabRegapplicant.setFAppRegPolitical(FAppRegPolitical);
		wsbmTabRegapplicant.setFAppRegPostCode(FAppRegPostCode);
		wsbmTabRegapplicant.setFAppRegQgtkao(FAppRegQgtkao);
		wsbmTabRegapplicant.setFAppRegQgtkaoNum(FAppRegQgtkaoNum);
		wsbmTabRegapplicant.setFAppRegSex(FAppRegSex);
		wsbmTabRegapplicant.setFAppRegTel(FAppRegTel);
		wsbmTabRegapplicant.setFAppRegWorkDuty(FAppRegWorkDuty);
		wsbmTabRegapplicant.setFAppRegWorkTitle(FAppRegWorkTitle);
		wsbmTabRegapplicant.setFAppRegHomeTown(FAppRegHomeTown);
		wsbmTabRegapplicant.setFAppRegXueWeiZhengNum(FAppRegXueWeiZhengNum);
		wsbmTabRegapplicant.setFAppRegBaoMingFei(FAppRegBaoMingFei);
		wsbmTabRegapplicant.setFAppRegPassAuth(FAppRegPassAuth);
		wsbmTabRegapplicant.setFAppRegPassPreAd(FAppRegPassPreAd);
		wsbmTabRegapplicant.setFAppRegPassFinAd(FAppRegPassFinAd);
		wsbmTabRegapplicant.setFAppRegBackUpText(FAppRegBackUpText);
		wsbmTabRegapplicant.setFAppRegQgtkaoZhuanYeKe(FAppRegQGTKaoZhuanYeKe);
		wsbmTabRegapplicant.setFAppRegQgtkaoZhengzhi(FAppRegQGTKaoZhengzhi);
		wsbmTabRegapplicant.setFAppRegQgtkaoEnglish(FAppRegQGTKaoEnglish);
		wsbmTabRegapplicant.setFAppRegZhunKaoZhengHao(FAppRegZhunKaoZhengHao);
		
		aacm.updateApp(wsbmTabRegapplicant);
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		return "appUpdated";
	}
	
	/**考生修改个人信息
	 * @return appMeUpdated 修改个人信息成功
	 */
	public String appMeUpdate(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		wsbmTabRegapplicant.setFAppRegAddress(FAppRegAddress);
		wsbmTabRegapplicant.setFAppRegBiYeZhengNum(FAppRegBiYeZhengNum);
		wsbmTabRegapplicant.setFAppRegCet4(FAppRegCet4);
		wsbmTabRegapplicant.setFAppRegCet6(FAppRegCet6);
		wsbmTabRegapplicant.setFAppRegCv(FAppRegCv);
		wsbmTabRegapplicant.setFAppRegEmail(FAppRegEmail);
		wsbmTabRegapplicant.setFAppRegLastBacheDegreeDate(FAppRegLastBacheDegreeDate);
		wsbmTabRegapplicant.setFAppRegLastGraduDate(FAppRegLastGraduDate);
		wsbmTabRegapplicant.setFAppRegLastGraduInstitu(FAppRegLastGraduInstitu);
		wsbmTabRegapplicant.setFAppRegLastGraduMajor(FAppRegLastGraduMajor);
		wsbmTabRegapplicant.setFAppRegLocation(FAppRegLocation);
		wsbmTabRegapplicant.setFAppRegPolitical(FAppRegPolitical);
		wsbmTabRegapplicant.setFAppRegPostCode(FAppRegPostCode);
		wsbmTabRegapplicant.setFAppRegTel(FAppRegTel);
		wsbmTabRegapplicant.setFAppRegWorkDuty(FAppRegWorkDuty);
		wsbmTabRegapplicant.setFAppRegWorkTitle(FAppRegWorkTitle);
		wsbmTabRegapplicant.setFAppRegXueWeiZhengNum(FAppRegXueWeiZhengNum);
		aacm.updateApp(wsbmTabRegapplicant);
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		return "appMeUpdated";
	}
	/**根据主键号码查询获得通知留言
	 * @return sepFindByNoticeNum 成功获得留言通知信息
	 */
	public String sepFindByNoticeNum(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "sepFindByNoticeNum";
	}
	
	/**为游客根据主键号码查询获得通知留言
	 * @return sepFindByNoticeNumVisitor 成功获得
	 */
	public String sepFindByNoticeNumVisitor(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "sepFindByNoticeNumVisitor";
	}
	/**管理员根据主键号码查询获得留言并转至回复页面
	 * @return adFindByNoticeNumToReply 成功获得留言与发送者信息
	 */
	public String adFindByNoticeNumToReply(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "adFindByNoticeNumToReply";
	}
	
	/**管理员更新系统重要通知或考生须知
	 * @return NoticeUpdated 重要通知或考生须知成功被更新
	 */
	public String updateNotice(){
		tabNotice.setFInfoTitle(FInfoTitle);
		tabNotice.setFInfoContet(FInfoContet);
		tabNotice.setFInfoPath(art);
		System.out.println(FInfoTitle+"++++++++++++++++");
		mm.updateMeg(tabNotice);
		System.out.println(FInfoTitle);
		listTabNotice=aacm.findNotice();
		return "NoticeUpdated";
	}
	
	public String sepFindByNoticeNumToUpdate(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "sepFindByNoticeNumToUpdate";
	}
	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return wsbmTabRegapplicant;
	}
	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}
	public String getFAppRegNum() {
		return FAppRegNum;
	}
	public void setFAppRegNum(String appRegNum) {
		FAppRegNum = appRegNum;
	}
	public TabNotice getTabNotice() {
		return tabNotice;
	}
	public void setTabNotice(TabNotice tabNotice) {
		this.tabNotice = tabNotice;
	}
	public List<TabNotice> getListTabNotice() {
		return listTabNotice;
	}
	public void setListTabNotice(List<TabNotice> listTabNotice) {
		this.listTabNotice = listTabNotice;
	}
	public int getFInfoId() {
		return FInfoId;
	}
	public void setFInfoId(int infoId) {
		FInfoId = infoId;
	}
	public String getFInfoTitle() {
		return FInfoTitle;
	}
	public void setFInfoTitle(String infoTitle) {
		FInfoTitle = infoTitle;
	}
	public String getFInfoContet() {
		return FInfoContet;
	}
	public void setFInfoContet(String infoContet) {
		FInfoContet = infoContet;
	}
	public String getArt() {
		return art;
	}
	public void setArt(String art) {
		this.art = art;
	}
	public MegManager getMm() {
		return mm;
	}
	public void setMm(MegManager mm) {
		this.mm = mm;
	}
	public String getFAppRegName() {
		return FAppRegName;
	}
	public void setFAppRegName(String appRegName) {
		FAppRegName = appRegName;
	}
	public String getFUserNumber() {
		return FUserNumber;
	}
	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}
	public String getFUserPassword() {
		return FUserPassword;
	}
	public void setFUserPassword(String userPassword) {
		FUserPassword = userPassword;
	}
	public String getFAppRegSex() {
		return FAppRegSex;
	}
	public void setFAppRegSex(String appRegSex) {
		FAppRegSex = appRegSex;
	}
	public Date getFAppRegBirthday() {
		return FAppRegBirthday;
	}
	public void setFAppRegBirthday(Date appRegBirthday) {
		FAppRegBirthday = appRegBirthday;
	}
	public String getFAppRegIdCard() {
		return FAppRegIdCard;
	}
	public void setFAppRegIdCard(String appRegIdCard) {
		FAppRegIdCard = appRegIdCard;
	}
	public String getFAppRegPolitical() {
		return FAppRegPolitical;
	}
	public void setFAppRegPolitical(String appRegPolitical) {
		FAppRegPolitical = appRegPolitical;
	}
	public String getFAppRegLocation() {
		return FAppRegLocation;
	}
	public void setFAppRegLocation(String appRegLocation) {
		FAppRegLocation = appRegLocation;
	}
	public String getFAppRegWorkDuty() {
		return FAppRegWorkDuty;
	}
	public void setFAppRegWorkDuty(String appRegWorkDuty) {
		FAppRegWorkDuty = appRegWorkDuty;
	}
	public String getFAppRegWorkTitle() {
		return FAppRegWorkTitle;
	}
	public void setFAppRegWorkTitle(String appRegWorkTitle) {
		FAppRegWorkTitle = appRegWorkTitle;
	}
	public String getFAppRegTel() {
		return FAppRegTel;
	}
	public void setFAppRegTel(String appRegTel) {
		FAppRegTel = appRegTel;
	}
	public String getFAppRegAddress() {
		return FAppRegAddress;
	}
	public void setFAppRegAddress(String appRegAddress) {
		FAppRegAddress = appRegAddress;
	}
	public String getFAppRegPostCode() {
		return FAppRegPostCode;
	}
	public void setFAppRegPostCode(String appRegPostCode) {
		FAppRegPostCode = appRegPostCode;
	}
	public Date getFAppRegLastGraduDate() {
		return FAppRegLastGraduDate;
	}
	public void setFAppRegLastGraduDate(Date appRegLastGraduDate) {
		FAppRegLastGraduDate = appRegLastGraduDate;
	}
	public String getFAppRegLastGraduInstitu() {
		return FAppRegLastGraduInstitu;
	}
	public void setFAppRegLastGraduInstitu(String appRegLastGraduInstitu) {
		FAppRegLastGraduInstitu = appRegLastGraduInstitu;
	}
	public String getFAppRegLastGraduMajor() {
		return FAppRegLastGraduMajor;
	}
	public void setFAppRegLastGraduMajor(String appRegLastGraduMajor) {
		FAppRegLastGraduMajor = appRegLastGraduMajor;
	}
	public Date getFAppRegLastBacheDegreeDate() {
		return FAppRegLastBacheDegreeDate;
	}
	public void setFAppRegLastBacheDegreeDate(Date appRegLastBacheDegreeDate) {
		FAppRegLastBacheDegreeDate = appRegLastBacheDegreeDate;
	}
	public String getFAppRegXueWeiZhengNum() {
		return FAppRegXueWeiZhengNum;
	}
	public void setFAppRegXueWeiZhengNum(String appRegXueWeiZhengNum) {
		FAppRegXueWeiZhengNum = appRegXueWeiZhengNum;
	}
	public String getFAppRegBiYeZhengNum() {
		return FAppRegBiYeZhengNum;
	}
	public void setFAppRegBiYeZhengNum(String appRegBiYeZhengNum) {
		FAppRegBiYeZhengNum = appRegBiYeZhengNum;
	}
	public String getFAppRegEmail() {
		return FAppRegEmail;
	}
	public void setFAppRegEmail(String appRegEmail) {
		FAppRegEmail = appRegEmail;
	}
	public Integer getFAppRegCet4() {
		return FAppRegCet4;
	}
	public void setFAppRegCet4(Integer appRegCet4) {
		FAppRegCet4 = appRegCet4;
	}
	public Integer getFAppRegCet6() {
		return FAppRegCet6;
	}
	public void setFAppRegCet6(Integer appRegCet6) {
		FAppRegCet6 = appRegCet6;
	}
	public String getFAppRegNation() {
		return FAppRegNation;
	}
	public void setFAppRegNation(String appRegNation) {
		FAppRegNation = appRegNation;
	}
	public String getFAppRegQgtkao() {
		return FAppRegQgtkao;
	}
	public void setFAppRegQgtkao(String appRegQgtkao) {
		FAppRegQgtkao = appRegQgtkao;
	}
	public String getFAppRegCv() {
		return FAppRegCv;
	}
	public void setFAppRegCv(String appRegCv) {
		FAppRegCv = appRegCv;
	}
	public String getFAppRegHomeTown() {
		return FAppRegHomeTown;
	}
	public void setFAppRegHomeTown(String appRegHomeTown) {
		FAppRegHomeTown = appRegHomeTown;
	}
	public String getFAppRegPassPreAd() {
		return FAppRegPassPreAd;
	}
	public void setFAppRegPassPreAd(String appRegPassPreAd) {
		FAppRegPassPreAd = appRegPassPreAd;
	}
	public String getFAppRegPassFinAd() {
		return FAppRegPassFinAd;
	}
	public void setFAppRegPassFinAd(String appRegPassFinAd) {
		FAppRegPassFinAd = appRegPassFinAd;
	}
	public String getFAppRegPassAuth() {
		return FAppRegPassAuth;
	}
	public void setFAppRegPassAuth(String appRegPassAuth) {
		FAppRegPassAuth = appRegPassAuth;
	}
	public String getFAppRegQgtkaoNum() {
		return FAppRegQgtkaoNum;
	}
	public void setFAppRegQgtkaoNum(String appRegQgtkaoNum) {
		FAppRegQgtkaoNum = appRegQgtkaoNum;
	}
	public Map getSession() {
		return session;
	}
	public void setSession(Map session) {
		this.session = session;
	}

	public String getAppRegBirthday() {
		return AppRegBirthday;
	}
	public void setAppRegBirthday(String appRegBirthday) {
		AppRegBirthday = appRegBirthday;
	}
	public String getAppRegLastGraduDate() {
		return AppRegLastGraduDate;
	}
	public void setAppRegLastGraduDate(String appRegLastGraduDate) {
		AppRegLastGraduDate = appRegLastGraduDate;
	}
	public String getAppRegLastBacheDegreeDate() {
		return AppRegLastBacheDegreeDate;
	}
	public void setAppRegLastBacheDegreeDate(String appRegLastBacheDegreeDate) {
		AppRegLastBacheDegreeDate = appRegLastBacheDegreeDate;
	}
	public String getFAppRegBaoMingFei() {
		return FAppRegBaoMingFei;
	}
	public void setFAppRegBaoMingFei(String appRegBaoMingFei) {
		FAppRegBaoMingFei = appRegBaoMingFei;
	}
	public String getFAppRegBackUpText() {
		return FAppRegBackUpText;
	}
	public void setFAppRegBackUpText(String appRegBackUpText) {
		FAppRegBackUpText = appRegBackUpText;
	}
	public int getFAppRegQGTKaoZhuanYeKe() {
		return FAppRegQGTKaoZhuanYeKe;
	}
	public void setFAppRegQGTKaoZhuanYeKe(int appRegQGTKaoZhuanYeKe) {
		FAppRegQGTKaoZhuanYeKe = appRegQGTKaoZhuanYeKe;
	}
	public int getFAppRegQGTKaoZhengzhi() {
		return FAppRegQGTKaoZhengzhi;
	}
	public void setFAppRegQGTKaoZhengzhi(int appRegQGTKaoZhengzhi) {
		FAppRegQGTKaoZhengzhi = appRegQGTKaoZhengzhi;
	}
	public int getFAppRegQGTKaoEnglish() {
		return FAppRegQGTKaoEnglish;
	}
	public void setFAppRegQGTKaoEnglish(int appRegQGTKaoEnglish) {
		FAppRegQGTKaoEnglish = appRegQGTKaoEnglish;
	}
	public String getFAppRegZhunKaoZhengHao() {
		return FAppRegZhunKaoZhengHao;
	}
	public void setFAppRegZhunKaoZhengHao(String appRegZhunKaoZhengHao) {
		FAppRegZhunKaoZhengHao = appRegZhunKaoZhengHao;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public String getAppRegName() {
		return AppRegName;
	}
	public void setAppRegName(String appRegName) {
		AppRegName = appRegName;
	}
	public String getAppRegIdCard() {
		return AppRegIdCard;
	}
	public void setAppRegIdCard(String appRegIdCard) {
		AppRegIdCard = appRegIdCard;
	}
	public List<WsbmTabExamsubject> getListWsbmTabExamsubject() {
		return listWsbmTabExamsubject;
	}
	public void setListWsbmTabExamsubject(
			List<WsbmTabExamsubject> listWsbmTabExamsubject) {
		this.listWsbmTabExamsubject = listWsbmTabExamsubject;
	}
	public KsCheckManager getRam() {
		return ram;
	}
	public void setRam(KsCheckManager ram) {
		this.ram = ram;
	}
}
