package com.xdsc.action.bksx_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;
import com.xdsc.service.bksx_system.TabStudentsManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action���ڵ���Excel����
 */
public class ExcelInAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabStudentsManager tabStudentsManager;

	/**
	 * ��������
	 */
	static String colType = "varchar";// �ֶ�����
	static String key = "id";// ����
	static String charSet = "utf8";// ����ַ�����
	static String ENGINE = "InnoDB";// �������
	static String tableName;// ������
	static String tableValue;// ������
	static String colName = "col";// Ĭ���ֶ���
	static Connection conn = null;

	/**
	 * Excel��������ݿ���Ҫ�Ƚ�Excel�ļ��ϴ�
	 */
	private File file;// ��װ�ϴ��ļ�
	private String fileContentType;// ��װ�ϴ��ļ�����
	private String fileFileName;// ��װ�ϴ��ļ���
	private String savePath;// ��װ�ϴ��ļ�����·��
	private String path;// �Զ����ϴ��ļ�·��ֵ

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String substuguiImport() throws Exception {
		try {
			UploadAction ua = new UploadAction();// �����ϴ�Action�Ķ���
			/** ����UploadAction�ĸ������* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// ����Workbook����, ֻ��Workbook����
			// ֱ�Ӵӱ����ļ�����Workbook
			// ������������Workbook

			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// ����������

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // ��ȡ��һ��sheet
			int colNum = rs.getColumns();// ����
			int rowNum = rs.getRows();// ����
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rows", Integer.toString(rowNum - 1));
			request.setAttribute("fileName", ua.getFileFileName());

			getConntion();// �������ݿ�����

			String sql = getColName(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < colNum; j++) {
					// �ж�ѧ���Ƿ����
					if (j == 15) {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						if (tabStudentsManager.getStudentById(strValue) == null) {
							return ERROR;
						}
						ps.setString(j + 1, strValue);
					} else {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						ps.setString(j + 1, strValue);
					}
				}
				ps.addBatch();
			}
			ps.executeBatch();
			if (ps != null) {
				ps.close();
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * ����ɼ���Ϣ�ļ������Ƚ���ȡ��ÿһ���¼��ѧ��ѧ������ȡ�� <br>
	 * �ɴ˻��ѡ����ϢID�������������ݿ���
	 * 
	 * ��ʧ�ܣ���ת����ʧ��ҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String resultIn() throws Exception {
		try {
			UploadAction ua = new UploadAction();// �����ϴ�Action�Ķ���
			/** ����UploadAction�ĸ������* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// ����Workbook����, ֻ��Workbook����
			// ֱ�Ӵӱ����ļ�����Workbook
			// ������������Workbook

			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// ����������

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // ��ȡ��һ��sheet
			int colNum = rs.getColumns();// ����
			int rowNum = rs.getRows();// ����
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rows", Integer.toString(rowNum - 1));
			request.setAttribute("fileName", ua.getFileFileName());

			getConntion();// �������ݿ�����

			String sql = getColName(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < colNum; j++) {
					if (j == 0) {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						// �ж��Ƿ��д�ѧ���ı�ҵ���ѡ���¼
						if (bksxTabSubstuguiManager
								.getSubstuguiByStuNum(strValue) != null) {
							// ������Excel�õ���ѧ�Ż�ȡѡ��ţ��������ݿ�
							int substuguiID = bksxTabSubstuguiManager
									.getSubstuguiByStuNum(strValue)
									.getFSubStuGuiId();
							ps.setString(j + 1, String.valueOf(substuguiID));
						} else {
							return ERROR;
						}
					} else {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						ps.setString(j + 1, strValue);
					}
				}
				ps.addBatch();
			}
			ps.executeBatch();

			if (ps != null) {
				ps.close();
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	static String getColName(int rowNum, int colNum) {
		// �������ɿ������ļ�
		String colSql = "";
		String colValue = "";

		for (int j = 0; j < colNum; j++) {
			colSql = colSql + "'" + colName + j + "',";
			colValue = colValue + "" + "?,";
		}
		return "insert into " + tableName + "(" + tableValue + ")" + " values("
				+ colValue.substring(0, colValue.lastIndexOf(",")) + ");";
	}

	static void getConntion() {

		try {
			String driver_class = "com.mysql.jdbc.Driver";
			String connection_url = "jdbc:mysql://localhost:3306/software_infoplatform?useUnicode=true&characterEncoding=utf-8";
			String user_name = "root";
			String db_password = "root";

			Class.forName(driver_class);
			conn = DriverManager.getConnection(connection_url, user_name,
					db_password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void close() {
		if (conn != null) {
			try {

				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/** ��������Ӧ��get��set����* */
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSavePath() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setTableName(String tableName) {
		ExcelInAction.tableName = tableName;
	}

	public void setTableValue(String tableValue) {
		ExcelInAction.tableValue = tableValue;
	}

	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public TabStudentsManager getTabStudentsManager() {
		return tabStudentsManager;
	}

	public void setTabStudentsManager(TabStudentsManager tabStudentsManager) {
		this.tabStudentsManager = tabStudentsManager;
	}

}
