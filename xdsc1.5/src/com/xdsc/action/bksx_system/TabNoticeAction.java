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
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action��װ�˶Դ�簲�ŵ���ز���
 */
public class TabNoticeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * Spring ע���Service��ӿ�
	 */
	private TabNoticeManager tabNoticeManager;
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;

	/**
	 * ֪ͨ��Ϣ�������
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
	 * ��������
	 */
	// �����ϴ��ļ���file����
	private File[] file;
	// �ϴ��ļ���
	private String[] fileFileName;
	// �ϴ��ļ���MIME����
	private String[] fileContentType;

	// �����ϴ��ļ���Ŀ¼�������WebӦ�ó���ĸ�·������struts.xml�ļ�������
	private String uploadDir;

	/**
	 * @return SUCCESS ת����ʾ��簲������ҳ��<br>
	 *         ����Ա�������֪ͨ��ͬʱ�����ϴ�����������
	 */
	public String newChecklistNotic() throws IOException {
		// ����֪ͨ��Ϣ
		if (!FInfoTitle.equals("") && FInfoTitle != null) {
			TabNotice notice = new TabNotice(FInfoTitle, FInfoContet,
					new Date(), "6", "֪ͨ", null, "Admin", null);
			tabNoticeManager.saveNotice(notice);
		}
		if (file != null && file.length != 0) {
			// �ϴ�����
			String newFileName = null;

			// �õ���ǰʱ����1970��1��1��0ʱ0��0�뿪ʼ���ŵĺ��������������������Ϊ�ϴ��ļ��µ��ļ�����
			Date now = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			String str = dateFormat.format(now);

			// �õ������ϴ��ļ���Ŀ¼����ʵ·��
			String path = ServletActionContext.getServletContext().getRealPath(
					uploadDir + "\\" + "checklist");

			File dir = new File(path);
			// ������Ŀ¼�����ڣ��򴴽�����
			if (!dir.exists())
				dir.mkdirs();

			try {
				for (int i = 0; i < file.length; i++) {
					int index = fileFileName[i].lastIndexOf('.');
					// �ж��ϴ��ļ����Ƿ�����չ��
					if (index != -1)
						newFileName = fileFileName[i].substring(0, index) + "_"
								+ str + fileFileName[i].substring(index);
					else
						newFileName = Long.toString(new Date().getTime());

					BufferedOutputStream bos = null;
					BufferedInputStream bis = null;
					// ��ȡ��������ʱĿ¼�µ��ϴ��ļ���д�뵽�µ��ļ��С�
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
	 * @return SUCCESS ת���簲��֪ͨ��ʾҳ��<br>
	 *         �õ���簲����Ϣ
	 */
	public String showChecklistNotice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List list = tabNoticeManager.getCheckNoticeList();
		request.setAttribute("noticeList", list);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��֪ͨ�Ķ���ϸ��Ϣҳ��<br>
	 *         �õ�ĳ�����֪ͨ����ϸ����
	 */
	public String noticeDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TabNotice notice = tabNoticeManager.getNoticebyID(id);
		request.setAttribute("notice", notice);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת��֪ͨ��Ϣ��ʾ<br>
	 *         ɾ��һ��֪ͨ��¼
	 */
	public String deleteChecklistNotice() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		TabNotice notice = tabNoticeManager.getNoticebyID(id);
		tabNoticeManager.deleteNotice(notice);
		return SUCCESS;
	}

	/**
	 * @return SUCCESS ת�򷢲����֪ͨҳ��<br>
	 *         ������ת���ܣ�Ϊ���ϵͳ����
	 */
	public String checklistNoticeNew() {
		return SUCCESS;
	}

	/**
	 * �����Ա������Get��Set����
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
