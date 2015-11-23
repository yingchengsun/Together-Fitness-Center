package com.xdsc.action.wzmh_system;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabLink;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.model.MhqxTabNavigation;
import com.xdsc.model.MhqxTabPicture;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;
import com.xdsc.service.wzmh_system.MhqxTabLinkManager;
import com.xdsc.service.wzmh_system.MhqxTabMenuManager;
import com.xdsc.service.wzmh_system.MhqxTabNavigationManager;
import com.xdsc.service.wzmh_system.MhqxTabPictureManager;
import com.xdsc.service.wzmh_system.TabInformationManager;
import com.xdsc.util.Constant;
import com.xdsc.util.HibernateUtil;
import com.xdsc.util.MultiPage;

/**
 * ���ż�֪ͨͨ���aciton������
 * 
 * @author ���� �·�
 * 
 */
@SuppressWarnings("unchecked")
public class TabInformationAction extends ActionSupport implements SessionAware {

	/** ��Ϣ��information������* */

	/** ��Ϣ������� */
	private Integer FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private Date FInfoStartTime;// ToShortDateString()
	private Date FInfoFinishTime;
	private String FModuleId;
	private String FInfoType;
	private String FInfoZhiDing;
	private String FInfoZuiXin;
	private String FInfoPath;
	private List<MhqxTabLink> linkList;// ��������

	/** ��Ϣ������ */
	private List<TabInformation> infoList;// ������Ϣ
	private List<TabInformation> xyxwList;// ѧԺ����
	private List<TabInformation> zxnsList;// ������ʿ
	private List<TabInformation> zsjyList;// ������ҵ
	private List<TabInformation> hzjlList;// ��������
	private List<TabInformation> tzggList;// ֪ͨ����
	private List<TabInformation> tpxwList;// ͼƬ����
	private TabInformationManager tabInformationManager;
	private TabInformation info;// ��װ��Ϣ��ϸ��Ϣ
	private TabInformation tpInfo;// ��װͼƬ����

	private TabInformation info_pre;

	/** ��Ϣ�������ı��� */
	private Map session;
	private File uploadFile;
	private String uploadFileFileName;
	private String savePath;

	/** ��ҳ�������ı��� */
	private int p = 1;
	private int lastPage;
	
	private int content;
	/** Notice��ҳ�������ı��� */
	private int np = 1;
	private int nlastPage;
	
	/** ��ҳ�������ı��� */
	private int fp = 1;
	private int flastPage;
	
	/** �˵���menu������* */
	/* �˵�������� */
	private Integer FMenuId;
	private String FMenuName;
	private Integer FSuperMenuId;
	private Integer FMenuPriority;
	private List<MhqxTabMenu> menuTracker = new ArrayList<MhqxTabMenu>();
	private int pid = -1;

	private List<String> check;
	/* �˵������� */
	private List<MhqxTabMenu> subList[];// �����Ӳ˵�
	private List<MhqxTabMenu> firstList;// һ���˵�
	private List<MhqxTabMenu> secondList;// �����˵�
	private List<MhqxTabMenu> thirdList[][] = new List[15][10];// �����˵�
	private MhqxTabMenuManager menuManager;// �˵��������
	private List<TabInformation> menuInfoList;// ÿ���˵�����Ӧ����Ϣ����
	private MhqxTabMenu menu;

	private MhqxTabNavigationManager navigationManager;
	private List<MhqxTabNavigation> NavigationList = new ArrayList<MhqxTabNavigation>() ;
	
	
	/* ͼƬ����������� */
	private Integer FId;
	private TabInformation tabInformation;
	private String FPicTitle;
	private String FPicContent;
	
	private MhqxTabPictureManager picManager;
	private List<MhqxTabPicture> tpList;// ͼƬ����
	private MhqxTabPicture tpNews;

//	MultiPage multiPage = new MultiPage();// ��ҳ��ʾ
	
	

	private MhqxTabLinkManager mhqxTabLinkManager;

	/**
	 * ǰ̨�Ż�����
	 */
	private Integer[] newsflag = new Integer[Constant.NewsCount];// ��������Ƿ��Ѿ�����ͼƬ����

	/**
	 * ȡһ�������Ľ����
	 * 
	 * @author �·�
	 * @param ll
	 *            ��Ϣ�б�
	 * @param num
	 *            ��С
	 * @return һ����С����Ϣ�б�
	 */
	public List<TabInformation> getSubList(List<TabInformation> ll, int num,int lenght) {
		List<TabInformation> l = new ArrayList<TabInformation>();
		if (ll == null)
			return null;
		for (int i = 0; i < num && i < ll.size(); i++) {
			l.add(ll.get(i));
		}
		shortTitle(ll, lenght);
		return l;
	}

	/**
	 * ���������ָ�����ȣ���ʡȥ��ʾʡ�Ժ�
	 * 
	 * @param ll
	 * @param ���ⳤ��
	 */
	public void shortTitle(List<TabInformation> ll, int num) {
		if (ll == null)
			return;
		for (TabInformation l : ll) {
			if (l.getFInfoTitle() != null
					&& l.getFInfoTitle().getBytes().length > num)// after zh
				l.setFInfoTitle(l.getFInfoTitle().substring(0, num / 2) + "..");
		}
	}

	/**
	 * ��ʾǰ������Ԥ����
	 */
	public void preShow() {
		infoList = getSubList(infoList, 10,32);
		xyxwList = getSubList(xyxwList, 15,32);
		zsjyList = getSubList(zsjyList,7,32);
		hzjlList = getSubList(hzjlList, 7,32);
		tzggList = getSubList(tzggList, 25,24);
		tpxwList = getSubList(tpxwList, 10,32);
		zxnsList = getSubList(zxnsList, 7,32);
	}

	/**
	 * ��ȡ��ҳ��������
	 * 
	 * @return findAllSuccess
	 */
	public String showAllInformation() {
		
		infoList = tabInformationManager.findAllTabInformations();
		xyxwList = tabInformationManager.findXYXWTabInformations();
		zsjyList = tabInformationManager.findZSJYTabInformations();
		hzjlList = tabInformationManager.findHZJLTabInformations();
		tzggList = tabInformationManager.findTZGGTabInformations();
		tpxwList = tabInformationManager.findTPXWTabInformations();
		zxnsList = tabInformationManager.findZXNSTabInformations();
		preShow();
		linkList = mhqxTabLinkManager.findAllMhqxTabLink();
		NavigationList =navigationManager.findAllMhqxTabNavigation();
		firstList = menuManager.findMhqxTabMenuBySuperId(0);// ����һ���˵�
		if (firstList != null) { // һ���˵���Ϊ��
			subList = new List[firstList.size()]; // ��̬���������С ��Ŷ����˵���Ӧ�Ӳ˵��б�
			int j = 0, i, pid, subpid;
			Iterator<MhqxTabMenu> iterator = firstList.iterator();

			while (iterator.hasNext()) {
				subList[j] = menuManager.findMhqxTabMenuBySuperId(iterator
						.next().getFMenuId());
				if (subList[j] != null) {
					Iterator<MhqxTabMenu> iterator2 = subList[j].iterator();
					i = 0;
					while (iterator2.hasNext()) {
						subpid = iterator2.next().getFMenuId();
						thirdList[j][i] = menuManager
								.findMhqxTabMenuBySuperId(subpid);
						i++;
					}
					iterator2=null;
				}
				j++;
			}
			iterator=null;
			
		}
		return "findAllSuccess";
	}

	/**
	 * �˵�λ��׷��
	 */
	public void menuTracker() {
		menuTracker.clear();
		MhqxTabMenu m = menu;
		List<MhqxTabMenu> s = new ArrayList<MhqxTabMenu>();
		s.add(m);
		System.out.println("begin menutracker  ");
		System.out.println(m.getFMenuName());
		while (m.getFSuperMenuId() != 0) {
			m = menuManager.findMhqxTabMenuByID(m.getFSuperMenuId());
			s.add(m);
			System.out.println(m.getFMenuName());
		}
		for (int i = s.size() - 1; i >= 0; i--) {
			menuTracker.add(s.get(i));
		}
		s=null;
		m=null;
	}

	/**
	 * ��ȡ����ҳ�����һ���Ͷ����˵��б�, �����ݲ˵����Ӧ������������ͬ��ת����ͬ��ҳ��
	 * 
	 * @return showMenuNewsTableSuccess,showMenuNewsDetailSuccess
	 */
	public String showMenuDetail() {
		flastPage=0;
		System.out.println("pid---------------"+pid);
		//����ID���߲˵�����ȷ�����ĸ��˵�
		if (FMenuId != null && FMenuId != -1) {
			menu = menuManager.findMhqxTabMenuByID(FMenuId);
			if (menu == null)
				return ERROR; // 404ҳ�� �˵���������Ϣ������δ��ͬ�� ����쳣
			FMenuName = menu.getFMenuName();
		} else {
			menu = menuManager.findMhqxTabMenuByName(FMenuName);
		}
		//��ʱFMenuName�ض���ֵ
//		if(FMenuName.equals("�о���ʵϰ"))
//			return "yjs";
//		
//		if(FMenuName.equals("������ʵϰ"))
//			return "bks";
		
		
		//ȡ�˵���Ӧ����Ϣ
		menuInfoList = tabInformationManager
				.findTabInformationsByType(FMenuName);
	

		
		
		
		menuTracker();// ���ɵ�ǰλ��

	   //����2���˵�
		if (menu.getFSuperMenuId() == 0) {//����menu��һ���˵�  �ҽ�2���˵�����ϢҲ����һ���˵�
			secondList = menuManager
					.findMhqxTabMenuBySuperId(menu.getFMenuId());
			if(secondList!=null){
			for(int i=0;i<secondList.size();i++)
			{
				MhqxTabMenu menu=secondList.get(i);
				List<TabInformation> l = tabInformationManager
				.findTabInformationsByType(menu.getFMenuName());
				for(int j=0;j<l.size();j++)
				{
					menuInfoList.add(l.get(j));
				}
			}
			}
					
		} else {
			MhqxTabMenu m =menu;
			do {
				menu = menuManager.findMhqxTabMenuByID(menu.getFSuperMenuId());
			} while (menu.getFSuperMenuId() != 0); //ʹmenuΪ1���˵�
			secondList = menuManager
					.findMhqxTabMenuBySuperId(menu.getFMenuId());
			
			if(menuManager.findMhqxTabMenuBySuperId(m.getFMenuId())!=null)//����˵�Ϊ2���Һ���3���Ӳ˵�����3���Ĳ˵�����Ҳ����ò˵�����
			{
				List<MhqxTabMenu> ml=menuManager.findMhqxTabMenuBySuperId(m.getFMenuId());
				for(int i=0;i<ml.size();i++)
				{
					MhqxTabMenu menu=ml.get(i);
					List<TabInformation> l = tabInformationManager
					.findTabInformationsByType(menu.getFMenuName());
					for(int j=0;j<l.size();j++)
					{
						menuInfoList.add(l.get(j));
					}
				}
			}
		}
       
		
		
		
		
		
		if (menuInfoList.size() > 1 && pid <= 0){ // �ж�����ûָ����һ��
			if (menuInfoList!=null&&menuInfoList.size()>10) {
				int pages = 10;
				int listlength = menuInfoList.size();
				if (listlength % pages == 0) {
					flastPage = listlength / pages;
				} else {
					flastPage = listlength / pages + 1;
				}
				if (fp < 1)
					fp = 1;
				if (fp > flastPage)
					fp = flastPage;
				int startIndex = (fp - 1) * pages;
				int endIndex = startIndex + pages;
				if (endIndex >= listlength)
					endIndex = listlength;
				menuInfoList = menuInfoList.subList(startIndex, endIndex);
			}	
			if(content==1){   //target==right  
				content=0;
				System.out.println("�ж���  δָ����һ�� ˢ�����ұ�");
				return "showContentTableSuccess";
			}
			System.out.println("�ж���  δָ����һ�� ˢ����ȫ��");
			return "showMenuNewsTableSuccess";
		}
		else if(menuInfoList.size() > 1 && pid > 0)//������ ����ָ��
		{
			
			menuInfoList = new ArrayList<TabInformation>();
			menuInfoList
					.add(tabInformationManager.findTabInformationsByID(pid));
			FInfoPath=menuInfoList.get(0).getFInfoPath();

			//pid=-1;
			
			if(content==1){
				content=0;
				FInfoPath=menuInfoList.get(0).getFInfoPath();
				System.out.println("������� ѡ���� ˢ�����ұ�"+FInfoPath);
				pid=-1;
				return "showContentDetailSuccess";
			}
			FInfoPath=menuInfoList.get(0).getFInfoPath();
			pid=-1;
			System.out.println("������� ѡ���� ˢ����ȫ��");
			return "showMenuNewsDetailSuccess";
		}
		else {
			if (menuInfoList.size() == 1){ //ֻ��һ��
				if(content==1){
					content=0;
					FInfoPath=menuInfoList.get(0).getFInfoPath();
					System.out.println("������� ˢ�����ұ�"+FInfoPath);
					return "showContentDetailSuccess";
				}
				FInfoPath=menuInfoList.get(0).getFInfoPath();
				System.out.println("������� ˢ����ȫ��");
				return "showMenuNewsDetailSuccess";
			}
			
			pid = -1;
			if(content==1){
				content=0;
				//FInfoPath=menuInfoList.get(0).getFInfoPath();
				System.out.println("������ ����ָ�� ˢ�����ұ�");
				return "showContentDetailSuccess";
			}
			//FInfoPath=menuInfoList.get(0).getFInfoPath();
			System.out.println("������ ����ָ�� ˢ����ȫ��");
			return "showMenuNewsDetailSuccess";
		}
	}

	/**
	 * ��ʾ��Ϣ����
	 * 
	 * @return showDetailSuccess
	 */
	public String showInformationsDetail() {
		info = tabInformationManager.findTabInformationsByID(FInfoId);
		return "showDetailSuccess";
	}

	/**
	 * ��̨������
	 * 
	 */

	/**
	 * ���Ų���
	 * 
	 */

	/**
	 * ���Ź���<br>
	 * �鿴����
	 * 
	 * @return showMenuToNewsSuccess
	 */
	public String showMenuToNews() {
		lastPage=0;
		
		FMenuName=menuManager.findMhqxTabMenuByID(
				FMenuId).getFMenuName();
		System.out.println(FMenuName);
		menuInfoList = tabInformationManager
				.findTabInformationsByType(FMenuName);
		for (int i = 0; i < menuInfoList.size(); i++) {
			if (picManager.findByInfoId(menuInfoList.get(i).getFInfoId()) == null
					|| picManager
							.findByInfoId(menuInfoList.get(i).getFInfoId())
							.size() == 0) {
				newsflag[i] = 1;// ������ ��Ҫ����
			} else {
				newsflag[i] = 0;// ������ ����
			}

		}
		
		if (menuInfoList!=null&&menuInfoList.size()>10) {
			int pages = 10;
			int listlength = menuInfoList.size();
			if (listlength % pages == 0) {
				lastPage = listlength / pages;
			} else {
				lastPage = listlength / pages + 1;
			}
			if (p < 1)
				p = 1;
			if (p > lastPage)
				p = lastPage;
			int startIndex = (p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			menuInfoList = menuInfoList.subList(startIndex, endIndex);
		}
		
		return "showMenuToNewsSuccess";
	}

	/**
	 * ���Ź���<br>
	 * ��������(���ݱ���)
	 * 
	 * @return showMenuToNewsSuccess
	 */
	public String showNewsByTitle() {
		menuInfoList = tabInformationManager
				.findTabInformationsByTitle(FInfoTitle);
		return "showNewsByTitleSuccess";
	}

	/**
	 * ���Ź���<br>
	 * ��������(�߼�����)
	 * 
	 * @return NewsAdvanceSearchSuccess
	 */
	public String NewsAdvanceSearch() {
		menuInfoList = tabInformationManager
				.NewsAdvanceSearch(FInfoTitle, FInfoContet, FInfoStartTime,
						FModuleId, FInfoType, FInfoZhiDing);
		return "NewsAdvanceSearchSuccess";
	}

	/**
	 * ���Ź���<br>
	 * �������(����ͼƬ������)
	 * 
	 * @return addInformatinSuccess
	 * @throws Exception
	 */
	public String addInformation() throws Exception {
		if (uploadFile != null)
			info = tabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		Date date = new Date();
		info.setFInfoStartTime(date);
		
		if("Y".equals(info.getFInfoZhiDing()))
		{
			for(TabInformation t:menuInfoList)
			{
				if("Y".equals(t.getFInfoZhiDing()))
				{
					t.setFInfoZhiDing("N");
					tabInformationManager.update(t);
				}
			}
		}

		tabInformationManager.add(info);
		int lastNewsId = tabInformationManager.findLastTabInformation()
				.getFInfoId();// ��øող����������Ϣ���ݿ����ɵ�ID;

		String id = (String) session.get("Id");
		int TotleImgNum = Integer.parseInt(id); // �������ŵ���ͼƬ��
		System.out.println("������ͼƬ��" + id);
		TabInformationimage pic = new TabInformationimage();
		for (int i = 0; i < TotleImgNum; i++) {
			String temp = Integer.toString(i);
			String key = "ImageName" + temp;
			String imgName = (String) session.get(key);// ���ͼƬ��
			info.setFInfoId(lastNewsId);
			pic.setFImgPath(imgName);
			pic.setTabInformation(info);
			tabInformationManager.saveTabInformationimage(pic);
			session.remove(key);// ��ͼƬ����ɹ����Զ����session�е�ͼƬ·����¼
		}

		session.remove("Id");// �����ű���ɹ����Զ��������ͼƬ������
		return "addInformatinSuccess";
	}

	/**
	 * ���Ź���<br>
	 * ��������ҳ�����ݵĶ�ȡ
	 * 
	 * @return updateInformationRedirectSuccess
	 * @throws Exception
	 */
	public String updateInformationRedirect() throws Exception {
		info_pre = tabInformationManager.findTabInformationsByID(FInfoId);
		return "updateInformationRedirectSuccess";
	}

	/**
	 * ���Ź���<br>
	 * ��������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateInformation() throws Exception {
		System.out.println("updateInformation");
		TabInformation info = tabInformationManager
				.findTabInformationsByID(FInfoId);
		if (uploadFile != null)
			info = tabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType(FInfoType);
		info.setFInfoZhiDing(FInfoZhiDing);
		info.setFInfoZuiXin(FInfoZuiXin);
		info.setFModuleId(FModuleId);
		
		if("Y".equals(info.getFInfoZhiDing()))
		{
			for(TabInformation t:menuInfoList)
			{
				if("Y".equals(t.getFInfoZhiDing()))
				{
					t.setFInfoZhiDing("N");
					tabInformationManager.update(t);
				}
			}
		}
		System.out.println("System.out.println(info.getFInfoPath());"+info.getFInfoPath());
		tabInformationManager.update(info);
		return "updateInformationSuccess";
	}

	/**
	 * ���Ź���<br>
	 * ɾ������
	 * 
	 * @return deleteInformationSuccess
	 * @throws Exception
	 */
	public String deleteInformation() throws Exception {
		tabInformationManager.delete(FInfoId);
		return "deleteInformationSuccess";
	}
	
	

	/**
	 * ɾ��������¼
	 * 
	 * @return deleteSUCCESS
	 * @throws Exception
	 */
	public String deleteAllNews() throws Exception {
		for (String s : check) {
			int id = Integer.parseInt(s);
			tabInformationManager.delete(id
				);
		}
		return "deleteInformationSuccess";
	}
	
	
	
	
	
	

	/**
	 * ֪ͨ���沿��
	 */

	/**
	 * ֪ͨ�������<br>
	 * �鿴֪ͨ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String notice() throws Exception {
	
		tzggList = tabInformationManager.findTZGGTabInformations();
		if (tzggList!=null&&tzggList.size()>10) {
			int pages = 10;
			int listlength = tzggList.size();
			if (listlength % pages == 0) {
				nlastPage = listlength / pages;
			} else {
				nlastPage = listlength / pages + 1;
			}
			if (np < 1)
				np = 1;
			if (np > nlastPage)
				np = nlastPage;
			int startIndex = (np - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			tzggList = tzggList.subList(startIndex, endIndex);
		}
		return "readTZGGSuccess";
	}

	/**
	 * ֪ͨ�������<br>
	 * ����֪ͨ����(���ݱ���)
	 * 
	 * @return showMenuToNewsSuccess
	 */
	public String showNoticeByTitle() {
		tzggList = tabInformationManager
				.findTZGGTabInformationsByTitle(FInfoTitle);
		return "showNoticeByTitleSuccess";
	}

	/**
	 * ֪ͨ�������<br>
	 * ����֪ͨ����(�߼�����)
	 * 
	 * @return NewsAdvanceSearchSuccess
	 */
	public String NoticeAdvanceSearch() {
		menuInfoList = tabInformationManager
				.NewsAdvanceSearch(FInfoTitle, FInfoContet, FInfoStartTime,
						FModuleId, FInfoType, FInfoZhiDing);
		return "NoticeAdvanceSearchSuccess";
	}

	/**
	 * ֪ͨ�������<br>
	 * ���֪ͨ����
	 * 
	 * @return addTZGGSuccess
	 * @throws Exception
	 */
	public String addNotice() throws Exception {
		if (uploadFile != null)
			info = tabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		Date date = new Date();
		info.setFInfoStartTime(date);
		if("Y".equals(info.getFInfoZhiDing()))
		{
			for(TabInformation t:tzggList)
			{
				if("Y".equals(t.getFInfoZhiDing()))
				{
					t.setFInfoZhiDing("N");
					tabInformationManager.update(t);
				}
			}
		}
		tabInformationManager.add(info);
		return "addTZGGSuccess";
	}

	/**
	 * ֪ͨ�������<br>
	 * ����֪ͨ����ҳ�����ݵĶ�ȡ
	 * 
	 * @return updateInformationRedirectSuccess
	 * @throws Exception
	 */
	public String updateTZGGRedirect() throws Exception {
		info_pre = tabInformationManager.findTabInformationsByID(FInfoId);
		return "updateTZGGRedirectSuccess";
	}

	/**
	 * ֪ͨ�������<br>
	 * ����֪ͨ����
	 * 
	 * @return updateTZGGSuccess
	 * @throws Exception
	 */
	public String updateNotice() throws Exception {
		TabInformation info = tabInformationManager
				.findTabInformationsByID(FInfoId);
		if (uploadFile != null)
			info = tabInformationManager.savefile(uploadFile, info, savePath,
					uploadFileFileName);
		
		info.setFInfoContet(FInfoContet);
		info.setFInfoTitle(FInfoTitle);
		info.setFInfoType(FInfoType);
		info.setFInfoZhiDing(FInfoZhiDing);
		info.setFInfoZuiXin(FInfoZuiXin);
		info.setFModuleId(FModuleId);
		
		
		if("Y".equals(info.getFInfoZhiDing()))
		{
			for(TabInformation t:tzggList)
			{
				if("Y".equals(t.getFInfoZhiDing()))
				{
					t.setFInfoZhiDing("N");
					tabInformationManager.update(t);
				}
			}
		}
		tabInformationManager.update(info);
		return "updateTZGGSuccess";
	}

	/**
	 * ֪ͨ�������<br>
	 * ɾ��֪ͨ����
	 * 
	 * @return deleteTZGGSuccess
	 * @throws Exception
	 */
	public String deleteNotice() throws Exception {
		tabInformationManager.delete(FInfoId);
		return "deleteTZGGSuccess";
	}


	/**
	 * ɾ��������¼
	 * 
	 * @return deleteSUCCESS
	 * @throws Exception
	 */
	public String deleteAllInfo() throws Exception {
		for (String s : check) {
			int id = Integer.parseInt(s);
			tabInformationManager.delete(id
				);
		}
		return "deleteTZGGSuccess";
	}
	
	
	
	
	
	/**
	 * ����set/get����
	 */
	
	
	public List<TabInformation> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<TabInformation> infoList) {
		this.infoList = infoList;
	}

	public TabInformationManager getTabInformationManager() {
		return tabInformationManager;
	}

	public void setTabInformationManager(
			TabInformationManager tabInformationManager) {
		this.tabInformationManager = tabInformationManager;
	}

	public Integer getFInfoId() {
		return FInfoId;
	}

	public void setFInfoId(Integer infoId) {
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

	public Date getFInfoStartTime() {
		return FInfoStartTime;
	}

	public void setFInfoStartTime(Date infoStartTime) {
		FInfoStartTime = infoStartTime;
	}

	public Date getFInfoFinishTime() {
		return FInfoFinishTime;
	}

	public void setFInfoFinishTime(Date infoFinishTime) {
		FInfoFinishTime = infoFinishTime;
	}

	public String getFModuleId() {
		return FModuleId;
	}

	public void setFModuleId(String moduleId) {
		FModuleId = moduleId;
	}

	public String getFInfoType() {
		return FInfoType;
	}

	public void setFInfoType(String infoType) {
		FInfoType = infoType;
	}

	public String getFInfoZhiDing() {
		return FInfoZhiDing;
	}

	public void setFInfoZhiDing(String infoZhiDing) {
		FInfoZhiDing = infoZhiDing;
	}

	public String getFInfoZuiXin() {
		return FInfoZuiXin;
	}

	public void setFInfoZuiXin(String infoZuiXin) {
		FInfoZuiXin = infoZuiXin;
	}

	public String getFInfoPath() {
		return FInfoPath;
	}

	public void setFInfoPath(String infoPath) {
		FInfoPath = infoPath;
	}

	public List<TabInformation> getXyxwList() {
		return xyxwList;
	}

	public void setXyxwList(List<TabInformation> xyxwList) {
		this.xyxwList = xyxwList;
	}

	public List<TabInformation> getZsjyList() {
		return zsjyList;
	}

	public void setZsjyList(List<TabInformation> zsjyList) {
		this.zsjyList = zsjyList;
	}

	public List<TabInformation> getHzjlList() {
		return hzjlList;
	}

	public void setHzjlList(List<TabInformation> hzjlList) {
		this.hzjlList = hzjlList;
	}

	public List<TabInformation> getTpxwList() {
		return tpxwList;
	}

	public void setTpxwList(List<TabInformation> tpxwList) {
		this.tpxwList = tpxwList;
	}

	public TabInformation getInfo() {
		return info;
	}

	public void setInfo(TabInformation info) {
		this.info = info;
	}

	public List<TabInformation> getTzggList() {
		return tzggList;
	}

	public void setTzggList(List<TabInformation> tzggList) {
		this.tzggList = tzggList;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public List<MhqxTabMenu>[] getSubList() {
		return subList;
	}

	public void setSubList(List<MhqxTabMenu>[] subList) {
		this.subList = subList;
	}

	public List<MhqxTabMenu> getFirstList() {
		return firstList;
	}

	public void setFirstList(List<MhqxTabMenu> firstList) {
		this.firstList = firstList;
	}

	public Integer getFMenuId() {
		return FMenuId;
	}

	public void setFMenuId(Integer menuId) {
		FMenuId = menuId;
	}

	public String getFMenuName() {
		return FMenuName;
	}

	public void setFMenuName(String menuName) {
		FMenuName = menuName;
	}

	public Integer getFSuperMenuId() {
		return FSuperMenuId;
	}

	public void setFSuperMenuId(Integer superMenuId) {
		FSuperMenuId = superMenuId;
	}

	public Integer getFMenuPriority() {
		return FMenuPriority;
	}

	public void setFMenuPriority(Integer menuPriority) {
		FMenuPriority = menuPriority;
	}

	public MhqxTabMenu getMenu() {
		return menu;
	}

	public void setMenu(MhqxTabMenu menu) {
		this.menu = menu;
	}

	public MhqxTabMenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(MhqxTabMenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public List<TabInformation> getMenuInfoList() {
		return menuInfoList;
	}

	public void setMenuInfoList(List<TabInformation> menuInfoList) {
		this.menuInfoList = menuInfoList;
	}

	public List<MhqxTabMenu> getSecondList() {
		return secondList;
	}

	public void setSecondList(List<MhqxTabMenu> secondList) {
		this.secondList = secondList;
	}

	public List<MhqxTabMenu>[][] getThirdList() {
		return thirdList;
	}

	public void setThirdList(List<MhqxTabMenu>[][] thirdList) {
		this.thirdList = thirdList;
	}

	public TabInformation getTpInfo() {
		return tpInfo;
	}

	public void setTpInfo(TabInformation tpInfo) {
		this.tpInfo = tpInfo;
	}

	public Integer getFId() {
		return FId;
	}

	public void setFId(Integer id) {
		FId = id;
	}

	public TabInformation getTabInformation() {
		return tabInformation;
	}

	public void setTabInformation(TabInformation tabInformation) {
		this.tabInformation = tabInformation;
	}

	public String getFPicTitle() {
		return FPicTitle;
	}

	public void setFPicTitle(String picTitle) {
		FPicTitle = picTitle;
	}

	public String getFPicContent() {
		return FPicContent;
	}

	public void setFPicContent(String picContent) {
		FPicContent = picContent;
	}

	public MhqxTabPictureManager getPicManager() {
		return picManager;
	}

	public void setPicManager(MhqxTabPictureManager picManager) {
		this.picManager = picManager;
	}

	public MhqxTabPicture getTpNews() {
		return tpNews;
	}

	public void setTpNews(MhqxTabPicture tpNews) {
		this.tpNews = tpNews;
	}

	public TabInformation getInfo_pre() {
		return info_pre;
	}

	public void setInfo_pre(TabInformation info_pre) {
		this.info_pre = info_pre;
	}

	public Integer[] getNewsflag() {
		return newsflag;
	}

	public void setNewsflag(Integer[] newsflag) {
		this.newsflag = newsflag;
	}

	public List<TabInformation> getZxnsList() {
		return zxnsList;
	}

	public void setZxnsList(List<TabInformation> zxnsList) {
		this.zxnsList = zxnsList;
	}

	public List<MhqxTabMenu> getMenuTracker() {
		return menuTracker;
	}

	public void setMenuTracker(List<MhqxTabMenu> menuTracker) {
		this.menuTracker = menuTracker;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<MhqxTabPicture> getTpList() {
		return tpList;
	}

	public void setTpList(List<MhqxTabPicture> tpList) {
		this.tpList = tpList;
	}
	

	public synchronized int getNp() {
		return np;
	}

	public synchronized void setNp(int np) {
		this.np = np;
	}

	public synchronized int getNlastPage() {
		return nlastPage;
	}

	public synchronized void setNlastPage(int nlastPage) {
		this.nlastPage = nlastPage;
	}



	public synchronized int getContent() {
		return content;
	}

	public synchronized void setContent(int content) {
		this.content = content;
	}

	public synchronized int getFp() {
		return fp;
	}

	public synchronized void setFp(int fp) {
		this.fp = fp;
	}

	public synchronized int getFlastPage() {
		return flastPage;
	}

	public synchronized void setFlastPage(int flastPage) {
		this.flastPage = flastPage;
	}

	public synchronized int getP() {
		return p;
	}

	public synchronized void setP(int p) {
		this.p = p;
	}

	public synchronized int getLastPage() {
		return lastPage;
	}

	public synchronized void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	

	public synchronized MhqxTabLinkManager getMhqxTabLinkManager() {
		return mhqxTabLinkManager;
	}

	public synchronized void setMhqxTabLinkManager(
			MhqxTabLinkManager mhqxTabLinkManager) {
		this.mhqxTabLinkManager = mhqxTabLinkManager;
	}

	public synchronized List<MhqxTabLink> getLinkList() {
		return linkList;
	}

	public synchronized void setLinkList(List<MhqxTabLink> linkList) {
		this.linkList = linkList;
	}

	public synchronized List<String> getCheck() {
		return check;
	}

	public synchronized void setCheck(List<String> check) {
		this.check = check;
	}



	public synchronized MhqxTabNavigationManager getNavigationManager() {
		return navigationManager;
	}

	public synchronized void setNavigationManager(
			MhqxTabNavigationManager navigationManager) {
		this.navigationManager = navigationManager;
	}

	public synchronized List<MhqxTabNavigation> getNavigationList() {
		return NavigationList;
	}

	public synchronized void setNavigationList(
			List<MhqxTabNavigation> navigationList) {
		NavigationList = navigationList;
	}
}
