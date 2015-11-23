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
 * @author 孙建波
 * @version 1.1<br>
 *          此Action用于导入Excel数据
 */
public class ExcelInAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private TabStudentsManager tabStudentsManager;

	/**
	 * 辅助参数
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String substuguiImport() throws Exception {
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

			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rows", Integer.toString(rowNum - 1));
			request.setAttribute("fileName", ua.getFileFileName());

			getConntion();// 建立数据库连接

			String sql = getColName(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";
				for (int j = 0; j < colNum; j++) {
					// 判断学号是否存在
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
	 * 导入成绩信息文件，首先将获取的每一项记录的学生学号属性取出 <br>
	 * 由此获得选题信息ID，进而存入数据库中
	 * 
	 * 若失败，则转向导入失败页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String resultIn() throws Exception {
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

			InputStream is = new FileInputStream(ua.getSavePath() + "\\"
					+ ua.getFileFileName());// 创建输入流

			Workbook rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0); // 读取第一个sheet
			int colNum = rs.getColumns();// 列数
			int rowNum = rs.getRows();// 行数
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rows", Integer.toString(rowNum - 1));
			request.setAttribute("fileName", ua.getFileFileName());

			getConntion();// 建立数据库连接

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
						// 判断是否有此学生的毕业设计选题记录
						if (bksxTabSubstuguiManager
								.getSubstuguiByStuNum(strValue) != null) {
							// 根据由Excel得到的学号获取选题号，存入数据库
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
