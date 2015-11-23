package com.xdsc.util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.model.TabGrade;
import com.xdsc.model.XsglTabDepartment;
import com.xdsc.service.xsgl_system.XsglTabDepartmentManager;
import com.xdsc.service.xsgl_system.XsglTabGradeManager;
import com.xdsc.util.UploadAction;

import jxl.*;

public class XsglExcelInAction extends ActionSupport {
	private XsglTabGradeManager xsglTabGradeManager;
	private XsglTabDepartmentManager xsglTabDepartmentManager;

	// static String createTableSql="";//创建数据库的sql
	static String colType = "varchar";// 字段类型
	static String key = "id";// 主键
	static String charSet = "utf8";// 表格字符类型
	static String ENGINE = "InnoDB";// 表格类型
	static String tableName;// 表名称
	static String tableValue;// 表属性
	static String colName = "col";// 默认字段名
	static Connection conn = null;

	/**
	 * Excel表格导入数据库需要先将Excel文件上传
	 */
	private File file;// 封装上传文件
	private String fileContentType;// 封装上传文件类型
	private String fileFileName;// 封装上传文件名
	private String savePath;// 封装上传文件保存路径
	private String path;// 自定义上传文件路径值

	/**
	 * 上传excel表格将数据存入数据库
	 * 
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String excelIn() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			UploadAction ua = new UploadAction();// 创建上传Action的对象
			/** 配置UploadAction的各项参数* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();// 建立数据库连接

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
			return ERROR;
		}
		return SUCCESS;
	}

	public String excelIn1() throws Exception {
		try {
			UploadAction ua = new UploadAction();// 创建上传Action的对象
			/** 配置UploadAction的各项参数* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();// 建立数据库连接

			String sql = getColName1(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < colNum; j++) {
					Cell c = rs.getCell(j, i);
					strValue = c.getContents();
					ps.setString(j + 1, strValue);
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

	public String excelInClass() throws Exception {
		try {
			UploadAction ua = new UploadAction();// 创建上传Action的对象
			/** 配置UploadAction的各项参数* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();// 建立数据库连接

			String sql = getColName1(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < colNum; j++) {
					if (j == 11) {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();

						System.out.println("%%%%%%%%%%%%% xsglTabGradeManager="
								+ xsglTabGradeManager.toString());
						TabGrade grade = xsglTabGradeManager
								.getGradeByGradeName(strValue);
						System.out.println("%%%%%%%%%%%%% grade=" + grade);
						if (grade != null) {
							int gradeId = grade.getFGradeId();
							ps.setString(j + 1, String.valueOf(gradeId));
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
			// conn.commit();

			if (ps != null) {
				ps.close();
			}

			System.out.println(" insert end-------------------------");
			close();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public String excelInStuOrg() throws Exception {
		try {
			UploadAction ua = new UploadAction();// 创建上传Action的对象
			/** 配置UploadAction的各项参数* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();// 建立数据库连接

			String sql = getColName(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 1; j < colNum; j++) {
					if (j == 1) {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();

						XsglTabDepartment department = xsglTabDepartmentManager
								.getDepartmentByName(strValue).get(0);
						if (department != null) {
							int DId = department.getFDid();
							ps.setString(j, String.valueOf(DId));
						}
					} else {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						ps.setString(j, strValue);
					}
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
			return ERROR;
		}
		return SUCCESS;
	}

	static String getColName1(int rowNum, int colNum) {
		// 可以做成可配置文件
		String colSql = "";
		String colValue = "";

		for (int j = 0; j < colNum; j++) {
			colSql = colSql + "'" + colName + j + "',";
			colValue = colValue + "" + "?,";
		}
		return "insert into " + tableName + "(" + tableValue + ")" + " values("
				+ colValue.substring(0, colValue.lastIndexOf(",")) + ");";
	}

	static String getColName(int rowNum, int colNum) {
		// 可以做成可配置文件
		String colSql = "";
		String colValue = "";

		for (int j = 1; j < colNum; j++) {
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
			String db_password = "";

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

	/** 各变量相应的get，set方法* */
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

	public void setTableValue(String tableValue) {
		this.tableValue = tableValue;
	}

	public XsglTabGradeManager getXsglTabGradeManager() {
		return xsglTabGradeManager;
	}

	public void setXsglTabGradeManager(XsglTabGradeManager xsglTabGradeManager) {
		this.xsglTabGradeManager = xsglTabGradeManager;
	}

	public XsglTabDepartmentManager getXsglTabDepartmentManager() {
		return xsglTabDepartmentManager;
	}

	public void setXsglTabDepartmentManager(
			XsglTabDepartmentManager xsglTabDepartmentManager) {
		this.xsglTabDepartmentManager = xsglTabDepartmentManager;
	}

	public String excelInUndergraduate() throws Exception {
		try {
			UploadAction ua = new UploadAction();// 创建上传Action的对象
			/** 配置UploadAction的各项参数* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();// 建立数据库连接

			String sql1 = getColName1(rowNum, 22);
			PreparedStatement ps1 = null;
			String strValue = "";
			ps1 = conn.prepareStatement(sql1);
			System.out.println(sql1);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < 22; j++) {
					Cell c = rs.getCell(j, i);
					strValue = c.getContents();
					ps1.setString(j + 1, strValue);

				}
				ps1.addBatch();
			}
			ps1.executeBatch();
			// conn.commit();

			if (ps1 != null) {
				ps1.close();
			}
			String sql2 = "insert into tab_undergraduate values(?,?,?,?,?)";
			PreparedStatement ps2 = null;
			String strValue2 = "";
			String strValue3 = "";
			ps2 = conn.prepareStatement(sql2);
			System.out.println(sql2);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				Cell c1 = rs.getCell(0, i);
				strValue2 = c1.getContents();
				ps2.setString(1, strValue2);
				for (int j = 22; j < colNum; j++) {

					Cell c2 = rs.getCell(j, i);
					strValue3 = c2.getContents();

					ps2.setString(j - 20, strValue3);

				}
				ps2.addBatch();
			}
			ps2.executeBatch();
			// conn.commit();

			if (ps2 != null) {
				ps2.close();
			}

			System.out.println(" insert end-------------------------");
			close();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String excelInPostgraduate() throws Exception {
		try {
			UploadAction ua = new UploadAction();// 创建上传Action的对象
			/** 配置UploadAction的各项参数* */
			ua.setPath(path);
			ua.setFile(file);
			ua.setFileContentType(fileContentType);
			ua.setFileFileName(fileFileName);
			ua.setSavePath(getSavePath());
			ua.execute();

			// 构建Workbook对象, 只读Workbook对象
			// 直接从本地文件创建Workbook
			// 从输入流创建Workbook

			System.out.println("start load file-------------------------");
			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();// 建立数据库连接

			String sql1 = getColName1(rowNum, 21);
			PreparedStatement ps1 = null;
			String strValue = "";
			ps1 = conn.prepareStatement(sql1);
			System.out.println(sql1);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < 21; j++) {
					Cell c = rs.getCell(j, i);
					strValue = c.getContents();
					ps1.setString(j + 1, strValue);

				}
				ps1.addBatch();
			}
			ps1.executeBatch();
			if (ps1 != null) {
				ps1.close();
			}
			String sql2 = "insert into tab_postgraduate values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps2 = null;
			String strValue2 = "";
			String strValue3 = "";
			ps2 = conn.prepareStatement(sql2);
			System.out.println(sql2);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				Cell c1 = rs.getCell(0, i);
				strValue2 = c1.getContents();
				ps2.setString(1, strValue2);
				for (int j = 21; j < colNum; j++) {

					Cell c2 = rs.getCell(j, i);
					strValue3 = c2.getContents();

					ps2.setString(j - 19, strValue3);

				}
				ps2.addBatch();
			}
			ps2.executeBatch();
			// conn.commit();

			if (ps2 != null) {
				ps2.close();
			}

			System.out.println(" insert end-------------------------");
			close();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

}
