package com.xdsc.util;

/**
 * 类功能：定义了系统使用的所有公共静态常量
 * @author 许鑫
 * @version 1.1
 */
public class CommonConstVariable {
	
	/**
	 * 研究生实习系统模块还
	 */
	public final static String MODULE_ID="7";                  //研究生实习系统的模块号
	
    /**
     * notice表中通知的类型
     */
	public final static String NOTICE_TYPE_ADMINTOSTUDENT="学院To研究生";   
	
	public final static String NOTICE_TYPE_ADMINTOTUTOR="学院To导师";
	
	public final static String NOTICE_TYPE_ADMINTOCOMPANY="学院To企业";
    
	public final static String NOTICE_TYPE_COMPANYTOSTUDENT="公司To研究生";
    
	public final static String NOTICE_TYPE_TUTORTOSTUDENT="导师To研究生";
      
    /**
     * infomation表的新闻信息
     */
	public final static String NOTICE_YINGPIN="应聘";                    //公司给研究生发的应聘信息
    
	public final static String FIRST_PAGE_NEWS="新闻公告";
	
	public final static String FIRST_PAGE_NOTICE="首页通知";
	
	public final static String FIRST_PAGE_MATERIAL="相关资料";
	
	public final static String FIRST_PAGE_ZHOPIN="招聘";
	
	public final static String FIRST_PAGE_COORCOM="合作基地";
	
	public final static String FIRST_PAGE_POLICY="实习政策";
	
	public final static String FIRST_PAGE_PRINCIPLE="管理制度";
	
    /**
     * 人员的类型的名称
     */
	public final static String TYPE_STUDENT="研究生";
	
	public final static String TYPE_TUTOR="导师";
	
	public final static String TYPE_COMPANY="企业";
	
    /**
     * 系统功能ID
     */
	public final static int SYSTEM_TUTOTSELECT_FUNCTION_ID=255;
	
	public final static int SYSTEM_THESISSUBMIT_FUNCTION_ID=262;   //终审论文报告
	
	public final static int SYSTEM_OPENTHESISSUBMIT_FUNCTION_ID=260;   //开题报告
	
	public final static int SYSTEM_MIDDLETHESISSUBMIT_FUNCTION_ID=261;   //中期检查报告
	
	public final static int SYSTEM_ZHAOPINREALEASE_FUNCTION_ID=281;
	
    /**
     * 教师的类型ID和Name
     */
	public final static int TEACHER_TYPE_ID=1;                      //教师类型------类型为导师的Id
	
	public final static String TYPE_NAME="导师";                   //教师类型名称------类型为导师的Id
	
    /**
     * 系统文件的存储路径
     */
	public final static String INFOMATION_FILE_PATH="\\files\\7yjssx_system\\infoFile\\information\\";
    
	public final static String NOTICE_FILE_PATH="\\files\\7yjssx_system\\infoFile\\Notice\\";
    
	public final static String THESIS_FILE_PATH="\\files\\7yjssx_system\\infoFile\\Thesis\\";
    
	public final static String UPLOADRESUME_FILE_PATH="\\files\\7yjssx_system\\infoFile\\uploadResume\\";
	
    
	/**
	 * 研究身提交的论文
	 */
	public final static String OPEN_THESIS="开题报告";
	
	public final static String MIDDLE_THESIS="中期检查";
	
	public final static String FINAL_THESIS="终审论文";
	
	/**
	 * 论文审核状态
	 */
	public final static String NOT_CHECK="未审核";
	
	public final static String CHECK_NOT_PASS="审核未通过";
	
	public final static String CHECK_HAVE_PASS="审核已通过";
		
	/**
	 * 公司发布的招聘信息是否发布出去
	 */
	public final static String ZHAOPIN_IS_RELEASE="Y";
	
	public final static String ZHAOPIN_Not_RELEASE="N";
	
   
   
}
