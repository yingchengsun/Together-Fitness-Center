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

/**����Ա��̨��վ��Ϣ��ѯ
 * @author ��С��
 * @version 1.2
 *
 */
public class AdAllCheckAction extends ActionSupport implements SessionAware{
	/**
	 * ��½�������
	 */
	private Map session;
	/**
	 * service��ӿ��������
	 */
	private AdAllCheckManager aacm;
	private MegManager mm;
	/**
	 * ������Ϣ����
	 */
	private String FAppRegNum;
	/**
	 * ������Ϣ�������
	 */
	private int FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private String art;
	/**
	 * �������ݿ������
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * ֪ͨ��Ϣ���ݿ������
	 */
	private TabNotice tabNotice;
	/**
	 * �������ݿ�������������
	 */
	private List<WsbmTabRegapplicant> listRegapplicantinfo;
	/**
	 * ֪ͨ��Ϣ���ݿ�������������
	 */
	private List<TabNotice> listTabNotice;
	/**
	 * ������Ϣ�������
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
	/** ��ʾ���п�����Ϣ�����б�
	 * @return success ��ȡ���������б�ɹ�
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
	
	/** ��ѯ����������Ϣ��֤ͨ�������п���
	 * @return success ��ѯ�ɹ�
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
	
	/**��ѯ�����ѽ������ѵĿ���
	 * 
	 * @return success ��ѯ�ɹ�
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
	
	/**��ѯ����δ�������ѵĿ���
	 * 
	 * @return success ��ѯ�ɹ�
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
	
	/**��ѯ���ڿ���������Ϣ��֤�����п���
	 * @return success ��ѯ�ɹ�
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
	
	/** ��ѯδͨ��Ԥ¼ȡ�����п���
	 * @return success ��ѯ�ɹ�
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
	 
	/** ��ѯ����ͨ��Ԥ¼ȡ�Ŀ���
	 * @return success ��ѯ�ɹ�
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
	
	/** ��ѯ����Ԥ¼ȡ���δ���Ŀ���
	 * @return success ��ѯ�ɹ�
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
	
	
	/** ��ѯ��������δ¼ȡ�Ŀ���
	 * @return success ��ѯ�ɹ�
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
	
	/** ��ѯ�������ձ�¼ȡ�Ŀ���
	 * @return success ��ѯ�ɹ�
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
	
	/**��ѯ����δȷ������¼ȡ���Ŀ���
	 * @return success ��ѯ�ɹ�
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
	
	/** ��ѯ����δͨ��������Ϣ��֤�Ŀ���
	 * @return success ��ѯ�ɹ�
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
	
	/** �������п���ѡ��ɾ���Ŀ����б�
	 * @return successDelete �����ɹ�
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
	
	/** �鿴������վ������Ϣ
	 * @return Notice ��ѯ�ɹ�
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
	
	/** ������ѯ��վ������Ϣ
	 * @return NoticeApp ��ѯ�ɹ�
	 */
	public String noticeApp(){
		listTabNotice = aacm.findNotice();
		return "NoticeApp";
	}
	
	/**�οͲ�ѯ��վ������Ϣ
	 * @return noticeVisitor ��ѯ�ɹ�
	 */
	public String noticeVisitor(){
		listTabNotice = aacm.findNotice();
		return "noticeVisitor";
	}
	
	public String noticeVisitor1(){
		listTabNotice = aacm.findNotice();
		return "noticeVisitor1";
	}
	
	/** ���ݿ�������ϵͳע�������ϸ��ѯ������Ϣ
	 * @return sepFindByNum ��ѯ�ɹ�
	 */
	public String sepFindByNum(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		return "sepFindByNum";
	}
	
	/** ���ݿ�������ϵͳע�������ϸԤ�������ʸ�����
	 * @return sepFindByNumSeeCheckList ��ѯ�ɹ�
	 */
	public String sepFindByNumSeeCheckList(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		AppRegBirthday=wsbmTabRegapplicant.getFAppRegBirthday().toString();
		AppRegBirthday=AppRegBirthday.substring(0, 10);
		AppRegLastGraduDate=wsbmTabRegapplicant.getFAppRegLastGraduDate().toString();
		AppRegLastGraduDate=AppRegLastGraduDate.substring(0, 4)+"��"+AppRegLastGraduDate.substring(5, 7)+"��";
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
	
	/** ���ݿ�������Լ��Ŀ����ʸ�����
	 * @return SeeCheckList ��ѯ�ɹ�
	 */
	public String SeeCheckList(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		AppRegBirthday=wsbmTabRegapplicant.getFAppRegBirthday().toString();
		AppRegBirthday=AppRegBirthday.substring(0, 10);
		AppRegLastGraduDate=wsbmTabRegapplicant.getFAppRegLastGraduDate().toString();
		AppRegLastGraduDate=AppRegLastGraduDate.substring(0, 4)+"��"+AppRegLastGraduDate.substring(5, 7)+"��";
		AppRegLastBacheDegreeDate=wsbmTabRegapplicant.getFAppRegLastBacheDegreeDate().toString();
		AppRegLastBacheDegreeDate=AppRegLastBacheDegreeDate.substring(0, 10);
		return "SeeCheckList";
	}
	
	/**���ݿ���ϵͳע�������¿�����Ϣ
	 * @return findAppToUpdate �ҵ�����
	 */
	public String findAppToUpdate(){
		wsbmTabRegapplicant=aacm.sepFindByNum(getFAppRegNum());
		return "findAppToUpdate";
	}
	
	/** ���������Լ��ĸ�����Ϣ
	 * @return findMeToUpdate �ɹ��ҵ�������
	 */
	public String findMeToUpdate(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		return "findMeToUpdate";
	}
	
	/**���¿���������Ϣ
	 * @return appUpdated ������Ϣ���³ɹ�
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
	
	/**�����޸ĸ�����Ϣ
	 * @return appMeUpdated �޸ĸ�����Ϣ�ɹ�
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
	/**�������������ѯ���֪ͨ����
	 * @return sepFindByNoticeNum �ɹ��������֪ͨ��Ϣ
	 */
	public String sepFindByNoticeNum(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "sepFindByNoticeNum";
	}
	
	/**Ϊ�ο͸������������ѯ���֪ͨ����
	 * @return sepFindByNoticeNumVisitor �ɹ����
	 */
	public String sepFindByNoticeNumVisitor(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "sepFindByNoticeNumVisitor";
	}
	/**����Ա�������������ѯ������Բ�ת���ظ�ҳ��
	 * @return adFindByNoticeNumToReply �ɹ���������뷢������Ϣ
	 */
	public String adFindByNoticeNumToReply(){
		tabNotice = aacm.sepFindByNoticeNum(getFInfoId());
		return "adFindByNoticeNumToReply";
	}
	
	/**����Ա����ϵͳ��Ҫ֪ͨ������֪
	 * @return NoticeUpdated ��Ҫ֪ͨ������֪�ɹ�������
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
