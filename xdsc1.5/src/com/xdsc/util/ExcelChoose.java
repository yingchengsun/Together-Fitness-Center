package com.xdsc.util;

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

/**
 * <p>���ܣ���excel�ļ��е���Ϣ�������ݿ⣨Excel��������ݿ���Ҫ�Ƚ�Excel�ļ��ϴ���<br>
 * @author qianxun
 * @version 1.1
 */
public class ExcelChoose extends ActionSupport {
	/**�ֶ�����*/
	static String colType = "varchar";
	/**����*/
	static String key = "id";
	/**����ַ�����*/
	static String charSet = "utf8";
	/**�������*/
	static String ENGINE = "InnoDB";
	/**������*/
	static String tableName;
	/**������*/
	static String tableValue;
	/**Ĭ���ֶ���*/
	static String colName = "col";
	/**���ݿ����Ӷ���*/
	static Connection conn = null;
	/**��װ�ϴ��ļ�*/
	private File file;
	/**��װ�ϴ��ļ�����*/
	private String fileContentType;
	/**��װ�ϴ��ļ���*/
	private String fileFileName;
	/**��װ�ϴ��ļ�����·��*/
	private String savePath;
	/**�Զ����ϴ��ļ�·��ֵ*/
	private String path;

	/**
	 * <p>���ܣ��ϴ�excel�ļ��������������¼�����Ϣ����ɺ������Ϣд�����ݿ��Ӧ���Ӧ�ֶ�<br>
	 * @return action SUCCESS
	 * @throws Exception 
	 */
	public String execute() throws Exception {
		try {
			UploadAction ua = new UploadAction();//�����ϴ�Action�Ķ���
			/**����UploadAction�ĸ������**/
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();
			
			// ����Workbook����, ֻ��Workbook����
			// ֱ�Ӵӱ����ļ�����Workbook
			// ������������Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// ����������

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // ��ȡ��һ��sheet
			int colNum = rs.getColumns();// ����
			int rowNum = rs.getRows();// ����

			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rows", Integer.toString(rowNum - 1));
			request.setAttribute("fileName", ua.getFileFileName());
			
			System.out.println("colNum rowNum------------------" + rowNum+ "��," + colNum + "��+");
			System.out.println("start create base-------------------------");

			getConntion();//�������ݿ�����

			String sql = getColName(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";                    
				for (int j = 1; j < colNum; j++) {
					Cell c = rs.getCell(j, i);
					strValue = c.getContents();
					ps.setString(j, strValue);
				}
				ps.addBatch();
			}
			ps.executeBatch();
			// conn.commit();

			if (ps != null) {
				ps.close();
			}
			
			System.out.println(" insert end-------------------------");
			close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * <p>���ܣ���������������������������Ӧ��sql��䲢����<br>
	 * @param rowNum ����
	 * @param colNum ����
	 * @return String ���ַ�������ʽ����sql���
	 */
	static String getColName(int rowNum, int colNum) {
		// �������ɿ������ļ�
		String colSql = "";
		String colValue = "";

		for (int j = 1; j < colNum; j++) {
			colSql = colSql + "'" + colName + j + "',";
			colValue = colValue + "" + "?,";
		}
		return "insert into " + tableName +"("+  tableValue +")"+ " values("+ colValue.substring(0, colValue.lastIndexOf(",")) + ");";
	}

	/**
	 * <p>���ܣ���ȡ���ݿ�����<br>
	 */
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

	/**
	 * <p>���ܣ��ر����ݿ�����<br>
	 */
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

	/**��������Ӧ��get��set����*/
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
		this.tableName = tableName;
	}


	public  void setTableValue(String tableValue) {
		this.tableValue = tableValue;
	}
}
