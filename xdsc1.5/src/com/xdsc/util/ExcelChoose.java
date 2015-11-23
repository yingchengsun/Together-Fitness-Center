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
 * <p>功能：将excel文件中的信息导入数据库（Excel表格导入数据库需要先将Excel文件上传）<br>
 * @author qianxun
 * @version 1.1
 */
public class ExcelChoose extends ActionSupport {
	/**字段类型*/
	static String colType = "varchar";
	/**主键*/
	static String key = "id";
	/**表格字符类型*/
	static String charSet = "utf8";
	/**表格类型*/
	static String ENGINE = "InnoDB";
	/**表名称*/
	static String tableName;
	/**表属性*/
	static String tableValue;
	/**默认字段名*/
	static String colName = "col";
	/**数据库连接对象*/
	static Connection conn = null;
	/**封装上传文件*/
	private File file;
	/**封装上传文件类型*/
	private String fileContentType;
	/**封装上传文件名*/
	private String fileFileName;
	/**封装上传文件保存路径*/
	private String savePath;
	/**自定义上传文件路径值*/
	private String path;

	/**
	 * <p>功能：上传excel文件，创建流对象记录相关信息，完成后将相关信息写入数据库对应表对应字段<br>
	 * @return action SUCCESS
	 * @throws Exception 
	 */
	public String execute() throws Exception {
		try {
			UploadAction ua = new UploadAction();//创建上传Action的对象
			/**配置UploadAction的各项参数**/
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

			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("rows", Integer.toString(rowNum - 1));
			request.setAttribute("fileName", ua.getFileFileName());
			
			System.out.println("colNum rowNum------------------" + rowNum+ "行," + colNum + "列+");
			System.out.println("start create base-------------------------");

			getConntion();//建立数据库连接

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
	 * <p>功能：根据输入的行数和列数生成相对应的sql语句并返回<br>
	 * @param rowNum 行数
	 * @param colNum 列数
	 * @return String 以字符串的形式返回sql语句
	 */
	static String getColName(int rowNum, int colNum) {
		// 可以做成可配置文件
		String colSql = "";
		String colValue = "";

		for (int j = 1; j < colNum; j++) {
			colSql = colSql + "'" + colName + j + "',";
			colValue = colValue + "" + "?,";
		}
		return "insert into " + tableName +"("+  tableValue +")"+ " values("+ colValue.substring(0, colValue.lastIndexOf(",")) + ");";
	}

	/**
	 * <p>功能：获取数据库连接<br>
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
	 * <p>功能：关闭数据库连接<br>
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

	/**各变量相应的get，set方法*/
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
