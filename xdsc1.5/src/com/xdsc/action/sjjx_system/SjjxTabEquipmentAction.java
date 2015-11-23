package com.xdsc.action.sjjx_system;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmenttype;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentdetailManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmenttypeManager;
import com.xdsc.service.sjjx_system.SjjxTabLabManager;
import com.xdsc.sjjx_system.util.DateConvert;
import com.xdsc.sjjx_system.util.PageListHolder;



/**对设备基本信息进行相关操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabEquipmentAction extends ActionSupport{
		
	/**
	 * Spring 注入的Service层的接口
	 */
	private SjjxTabEquipmentManager sjjxTabEquipmentManager;
	private SjjxTabEquipmentdetailManager sjjxTabEquipmentdetailManager;
	private SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager;
	private SjjxTabLabManager sjjxTabLabManager;
	
	/**
	 * 设备基本信息相关属性
	 */
	private Integer FEquId;
	private SjjxTabLab sjjxTabLab;
	private SjjxTabEquipmenttype sjjxTabEquipmenttype;
	private Integer FDepartmentId;
	private String FDepartmentName;
	private String FEquName;
	private String FEquBrand;
	private String FEquPattern;
	private String FEquStandard;
	private Integer FEquPrice;
	private String FChuChangId;
	private String FEquBuyTime;
	private String FPersonL;
	private String FPersonJ;
	private String FPersonS;
	private String FRemarks;
	private Integer FTypeId;
	private String FEquBuyCompany;
	private String FCountry;
	private Integer FCountryId;
	private String FFundsId;
	private String FFundsName;
	private Integer FUseDirectionId;
	private String FUseDirectionName;
	private String FKeYanId;
	private Integer FDanJuId;
	private String FRuKuTime;
	private Integer FZiChanType;
	private Integer FGuoBiaoId;
	private String FShuRuTime;
	private Integer FEquSourceId;
	private String FEquSourceName;
	private Integer FZheJiuId;
	private String FZheJiuName;
	private String FBaoXiuDate;
	private String FCaiWuPingDan;
	private String FJiZhangRen;
	private String FShenHe;
    private String FEquTypeName;
    private Integer FLabId;
	/**
	 * 用来接收查询条件的变量
	 */
	private int search_item;
	private int search_item1;
	
    //private String FAdminNumber;

	


	/**得到所有设备记录列表
	 * @return SUCCESS 显示列表
	 */
	public String getEquipList() {
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		List list = sjjxTabEquipmentManager.getEquipList();
		//如果记录为空，则不显示内容
		if(list.isEmpty()){
			request.put("isempty",new String("3"));
		}
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("equipAll", list_all);
		request.put("equiplist", list_current);
		
		List list_type = sjjxTabEquipmenttypeManager.getEquipTypeList();
		List list_lab = sjjxTabLabManager.getLabList();
		
		request.put("list_type", list_type);
		request.put("list_lab", list_lab);
		
		return SUCCESS;
	}
	
	/**分页功能中 响应点击[前一页]的函数
	 * @return SUCCESS 显示前一页列表
	 */
	public String previousE(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("equipAll");
		list_all.previousPage();
		List list_current = list_all.getPageList();
		request.put("equiplist", list_current);
		
		List list_type = sjjxTabEquipmenttypeManager.getEquipTypeList();
		List list_lab = sjjxTabLabManager.getLabList();
		
		request.put("list_type", list_type);
		request.put("list_lab", list_lab);
		
		return SUCCESS;
	}
	
	/**分页功能中 响应点击[后一页]的函数
	 * @return SUCCESS 显示后一页列表
	 */
	public String nextE(){
		Map request = (Map) ActionContext.getContext().get("request");
		Map session =(Map)ActionContext.getContext().get("session");
		
		PageListHolder list_all =(PageListHolder) session.get("equipAll");
		list_all.nextPage();
		List list_current = list_all.getPageList();
		request.put("equiplist", list_current);
		
		List list_type = sjjxTabEquipmenttypeManager.getEquipTypeList();
		List list_lab = sjjxTabLabManager.getLabList();
		
		request.put("list_type", list_type);
		request.put("list_lab", list_lab);
		
		return SUCCESS;
	}
	
	/**通过设备编号查找到该设备的详细信息记录
	 * @return SUCCESS 显示该设备的详细信息
	 */
	public String showEquipDetailInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");
		int equipId = Integer.parseInt( request.getParameter("id"));
		SjjxTabEquipment equip= sjjxTabEquipmentManager.getEquipByEquipId(equipId);
		request.setAttribute("equip", equip);
		return SUCCESS;
		
	}
	
	
	

	
	/**根据设备类型查找到该类型的所有设备
	 * @return SUCCESS 查找成功
	 */
	public String showTypeEquip(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");

		String search_item_str;
		search_item_str = sjjxTabEquipmenttypeManager.getEquipTypeByEquipTypeId(search_item).getFEquTypeName();
		System.out.println("In SjjxTabEquipmentAction show TypeEquip :"+search_item_str);
		List list = sjjxTabEquipmentManager.getEquipByEquipTypeName(search_item_str);
		if(list.isEmpty()){
			request.setAttribute("isempty", new String("2"));
		}

		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("equipAll", list_all);
		request.setAttribute("equiplist", list_current);
		
		List list_type = sjjxTabEquipmenttypeManager.getEquipTypeList();
		List list_lab = sjjxTabLabManager.getLabList();
		
		request.setAttribute("list_type", list_type);
		request.setAttribute("list_lab", list_lab);
		
		return SUCCESS;
	}
	/**通过实验室名称查找在该实验室的所有设备
	 * @return SUCCESS 查找成功
	 */
	public String showLabEquip(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Map session =(Map)ActionContext.getContext().get("session");        
		String search_item_str;
		search_item_str = sjjxTabLabManager.getLabByLabId(search_item1).getFLabName();
		List list = sjjxTabEquipmentManager.getEquipByLabName(search_item_str);
		
		if(list.isEmpty()){
			request.setAttribute("isempty", new String("1"));
		}
		PageListHolder list_all = new PageListHolder(list);
		list_all.setPageSize(10);
		List list_current = list_all.getPageList();
		session.put("equipAll", list_all);
		request.setAttribute("equiplist", list_current);
		
		List list_type = sjjxTabEquipmenttypeManager.getEquipTypeList();
		List list_lab = sjjxTabLabManager.getLabList();
		
		request.setAttribute("list_type", list_type);
		request.setAttribute("list_lab", list_lab);
		
		return SUCCESS;
	}

	/**通过设备编号查找设别并删除
	 * @return SUCCESS 成功从列表中删除一条信息
	 */
	public String deleteEquip() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer equipId = Integer.parseInt(request.getParameter("id"));
		sjjxTabEquipmentManager.deleteEquip(sjjxTabEquipmentManager.getEquipByEquipId(equipId));
		return SUCCESS;
	}


	/**
	 * 该类成员变量的Get与Set方法
	 */
	public SjjxTabEquipmentManager getSjjxTabEquipmentManager() {
		return sjjxTabEquipmentManager;
	}

	public void setSjjxTabEquipmentManager(
			SjjxTabEquipmentManager sjjxTabEquipmentManager) {
		this.sjjxTabEquipmentManager = sjjxTabEquipmentManager;
	}

	public SjjxTabEquipmentdetailManager getSjjxTabEquipmentdetailManager() {
		return sjjxTabEquipmentdetailManager;
	}

	public void setSjjxTabEquipmentdetailManager(
			SjjxTabEquipmentdetailManager sjjxTabEquipmentdetailManager) {
		this.sjjxTabEquipmentdetailManager = sjjxTabEquipmentdetailManager;
	}

	public SjjxTabEquipmenttypeManager getSjjxTabEquipmenttypeManager() {
		return sjjxTabEquipmenttypeManager;
	}

	public void setSjjxTabEquipmenttypeManager(
			SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager) {
		this.sjjxTabEquipmenttypeManager = sjjxTabEquipmenttypeManager;
	}

	public SjjxTabLabManager getSjjxTabLabManager() {
		return sjjxTabLabManager;
	}

	public void setSjjxTabLabManager(SjjxTabLabManager sjjxTabLabManager) {
		this.sjjxTabLabManager = sjjxTabLabManager;
	}

	public Integer getFEquId() {
		return FEquId;
	}

	public void setFEquId(Integer equId) {
		FEquId = equId;
	}

	public SjjxTabLab getSjjxTabLab() {
		return sjjxTabLab;
	}

	public void setSjjxTabLab(SjjxTabLab sjjxTabLab) {
		this.sjjxTabLab = sjjxTabLab;
	}

	public SjjxTabEquipmenttype getSjjxTabEquipmenttype() {
		return sjjxTabEquipmenttype;
	}

	public void setSjjxTabEquipmenttype(SjjxTabEquipmenttype sjjxTabEquipmenttype) {
		this.sjjxTabEquipmenttype = sjjxTabEquipmenttype;
	}

	public Integer getFDepartmentId() {
		return FDepartmentId;
	}

	public void setFDepartmentId(Integer departmentId) {
		FDepartmentId = departmentId;
	}

	public String getFDepartmentName() {
		return FDepartmentName;
	}

	public void setFDepartmentName(String departmentName) {
		FDepartmentName = departmentName;
	}

	public String getFEquName() {
		return FEquName;
	}

	public void setFEquName(String equName) {
		FEquName = equName;
	}

	public String getFEquBrand() {
		return FEquBrand;
	}

	public void setFEquBrand(String equBrand) {
		FEquBrand = equBrand;
	}

	public String getFEquPattern() {
		return FEquPattern;
	}

	public void setFEquPattern(String equPattern) {
		FEquPattern = equPattern;
	}

	public String getFEquStandard() {
		return FEquStandard;
	}

	public void setFEquStandard(String equStandard) {
		FEquStandard = equStandard;
	}

	public Integer getFEquPrice() {
		return FEquPrice;
	}

	public void setFEquPrice(Integer equPrice) {
		FEquPrice = equPrice;
	}

	public String getFChuChangId() {
		return FChuChangId;
	}

	public void setFChuChangId(String chuChangId) {
		FChuChangId = chuChangId;
	}

	public String getFEquBuyTime() {
		return FEquBuyTime;
	}

	public void setFEquBuyTime(String equBuyTime) {
		FEquBuyTime = equBuyTime;
	}

	public String getFPersonL() {
		return FPersonL;
	}

	public void setFPersonL(String personL) {
		FPersonL = personL;
	}

	public String getFPersonJ() {
		return FPersonJ;
	}

	public void setFPersonJ(String personJ) {
		FPersonJ = personJ;
	}

	public String getFPersonS() {
		return FPersonS;
	}

	public void setFPersonS(String personS) {
		FPersonS = personS;
	}

	public String getFRemarks() {
		return FRemarks;
	}

	public void setFRemarks(String remarks) {
		FRemarks = remarks;
	}

	public String getFEquTypeName() {
		return FEquTypeName;
	}

	public void setFEquTypeName(String equTypeName) {
		FEquTypeName = equTypeName;
	}

	public Integer getFLabId() {
		return FLabId;
	}

	public void setFLabId(Integer labId) {
		FLabId = labId;
	}

	public int getSearch_item() {
		return search_item;
	}

	public void setSearch_item(int search_item) {
		this.search_item = search_item;
	}

	public int getSearch_item1() {
		return search_item1;
	}

	public void setSearch_item1(int search_item1) {
		this.search_item1 = search_item1;
	}

	public Integer getFTypeId() {
		return FTypeId;
	}

	public void setFTypeId(Integer typeId) {
		FTypeId = typeId;
	}

	public String getFEquBuyCompany() {
		return FEquBuyCompany;
	}

	public void setFEquBuyCompany(String equBuyCompany) {
		FEquBuyCompany = equBuyCompany;
	}

	public String getFCountry() {
		return FCountry;
	}

	public void setFCountry(String country) {
		FCountry = country;
	}

	public Integer getFCountryId() {
		return FCountryId;
	}

	public void setFCountryId(Integer countryId) {
		FCountryId = countryId;
	}

	public String getFFundsId() {
		return FFundsId;
	}

	public void setFFundsId(String fundsId) {
		FFundsId = fundsId;
	}

	public String getFFundsName() {
		return FFundsName;
	}

	public void setFFundsName(String fundsName) {
		FFundsName = fundsName;
	}

	public Integer getFUseDirectionId() {
		return FUseDirectionId;
	}

	public void setFUseDirectionId(Integer useDirectionId) {
		FUseDirectionId = useDirectionId;
	}

	public String getFKeYanId() {
		return FKeYanId;
	}

	public void setFKeYanId(String keYanId) {
		FKeYanId = keYanId;
	}

	public Integer getFDanJuId() {
		return FDanJuId;
	}

	public void setFDanJuId(Integer danJuId) {
		FDanJuId = danJuId;
	}

	public String getFRuKuTime() {
		return FRuKuTime;
	}

	public void setFRuKuTime(String ruKuTime) {
		FRuKuTime = ruKuTime;
	}

	public Integer getFZiChanType() {
		return FZiChanType;
	}

	public void setFZiChanType(Integer ziChanType) {
		FZiChanType = ziChanType;
	}

	public Integer getFGuoBiaoId() {
		return FGuoBiaoId;
	}

	public void setFGuoBiaoId(Integer guoBiaoId) {
		FGuoBiaoId = guoBiaoId;
	}

	public String getFShuRuTime() {
		return FShuRuTime;
	}

	public void setFShuRuTime(String shuRuTime) {
		FShuRuTime = shuRuTime;
	}

	public Integer getFEquSourceId() {
		return FEquSourceId;
	}

	public void setFEquSourceId(Integer equSourceId) {
		FEquSourceId = equSourceId;
	}

	public String getFEquSourceName() {
		return FEquSourceName;
	}

	public void setFEquSourceName(String equSourceName) {
		FEquSourceName = equSourceName;
	}

	public Integer getFZheJiuId() {
		return FZheJiuId;
	}

	public void setFZheJiuId(Integer zheJiuId) {
		FZheJiuId = zheJiuId;
	}

	public String getFZheJiuName() {
		return FZheJiuName;
	}

	public void setFZheJiuName(String zheJiuName) {
		FZheJiuName = zheJiuName;
	}

	public String getFBaoXiuDate() {
		return FBaoXiuDate;
	}

	public void setFBaoXiuDate(String baoXiuDate) {
		FBaoXiuDate = baoXiuDate;
	}

	public String getFCaiWuPingDan() {
		return FCaiWuPingDan;
	}

	public void setFCaiWuPingDan(String caiWuPingDan) {
		FCaiWuPingDan = caiWuPingDan;
	}

	public String getFJiZhangRen() {
		return FJiZhangRen;
	}

	public void setFJiZhangRen(String jiZhangRen) {
		FJiZhangRen = jiZhangRen;
	}

	public String getFShenHe() {
		return FShenHe;
	}

	public void setFShenHe(String shenHe) {
		FShenHe = shenHe;
	}
	public String getFUseDirectionName() {
		return FUseDirectionName;
	}

	public void setFUseDirectionName(String fUseDirectionName) {
		FUseDirectionName = fUseDirectionName;
	}
}
