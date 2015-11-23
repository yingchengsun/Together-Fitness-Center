package com.xdsc.action.bksx_system;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabNoticeManager;

/**
 * @author 孙建波
 * @version 1.1<br>
 *          此Action封装了对答辩安排的相关操作
 */
public class TabNoticeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Spring 注入的Service层接口
	 */
	private TabNoticeManager tabNoticeManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * 通知信息相关属性
	 */
	private Integer FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private Date FInfoStartTime;
	private String FModuleId;
	private String FInfoType;
	private String FInfoPath;
	private String FInfoFrom;

	/**
	 * 辅助参数
	 */
	// 代表上传文件的file对象
	private File[] file;
	// 上传文件名
	private String[] fileFileName;
	// 上传文件的MIME类型
	private String[] fileContentType;

	// 保存上传文件的目录，相对于Web应用程序的根路径，在struts.xml文件中配置
	private String uploadDir;

	/**
	 * @return SUCCESS 转向显示答辩安排内容页面<br>
	 *         管理员发布答辩通知的同时可以上传任意多个附件
	 */
	public String newChecklistNotic() throws IOException {
		// 保存通知信息
		if (!FInfoTitle.equals("") && FInfoTitle != null) {
			TabNotice notice = new TabNotice(FInfoTitle, FInfoContet,
					new Date(), "6", "通知", null, "Admin", null);
			tabNoticeManager.saveNotice(notice);
		}
		if (file != null && file.length != 0) {
			// 上传附件
			String newFileName = null;

			// 得到当前时间自1970年1月1日0时0分0秒开始流逝的毫秒数，将这个毫秒数作为上传文件新的文件名。
			Date now = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String str = dateFormat.format(now);

			// 得到保存上传文件的目录的真实路径
			String path = ServletActionContext.getServletContext().getRealPath(
					uploadDir + "\\" + "checklist");

			File dir = new File(path);
			// 如果这个目录不存在，则创建它。
			if (!dir.exists())
				dir.mkdirs();

			try {
				for (int i = 0; i < file.length; i++) {
					int index = fileFileName[i].lastIndexOf('.');
					// 判断上传文件名是否有扩展名
					if (index != -1)
						newFileName = fileFileName[i].substring(0, index) + "_"
								+ str + fileFileName[i].substring(index);
					else
						newFileName = Long.toString(new Date().getTime());

					BufferedOutputStream bos = null;
					BufferedInputStream bis = null;
					// 读取保存在临时目录下的上传文件，写入到新的文件中。
					try {
						FileInputStream fis = new FileInputStream(file[i]);
						bis = new BufferedInputStream(fis);

						FileOutputStream fos = new FileOutputStream(new File(
								dir, newFileName));
						bos = new BufferedOutputStream(fos);

						byte[] buf = new byte[4096];

						int len = -1;
						while ((len = bis.read(buf)) != -1) {
							bos.write(buf, 0, len);
						}
					} finally {
						try {
							if (null != bis)
								bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}

						try {
							if (null != bos)
								bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (RuntimeException e) {
				return ERROR;
			}
		}

		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向答辩安排通知显示页面<br>
	 *         得到答辩安排信息
	 */
	public String showChecklistNotice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = tabNoticeManager.getCheckNoticeList();
		request.setAttribute("noticeList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向通知的而详细信息页面<br>
	 *         得到某条答辩通知的详细内容
	 */
	public String noticeDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TabNotice notice = tabNoticeManager.getNoticebyID(id);
		request.setAttribute("notice", notice);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向通知信息显示<br>
	 *         删除一条通知记录
	 */
	public String deleteChecklistNotice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TabNotice notice = tabNoticeManager.getNoticebyID(id);
		tabNoticeManager.deleteNotice(notice);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS 转向发布答辩通知页面<br>
	 *         单纯跳转功能，为配合系统集成
	 */
	public String checklistNoticeNew() {
		return SUCCESS;
	}

	/**
	 * 该类成员变量的Get与Set方法
	 */
	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
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

	public String getFInfoPath() {
		return FInfoPath;
	}

	public void setFInfoPath(String infoPath) {
		FInfoPath = infoPath;
	}

	public String getFInfoFrom() {
		return FInfoFrom;
	}

	public void setFInfoFrom(String infoFrom) {
		FInfoFrom = infoFrom;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public TabNoticeManager getTabNoticeManager() {
		return tabNoticeManager;
	}

	public void setTabNoticeManager(TabNoticeManager tabNoticeManager) {
		this.tabNoticeManager = tabNoticeManager;
	}

}
