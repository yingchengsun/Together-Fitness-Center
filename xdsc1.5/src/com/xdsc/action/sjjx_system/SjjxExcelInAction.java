package com.xdsc.action.sjjx_system;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.service.sjjx_system.SjjxTabClassesManager;
import com.xdsc.service.sjjx_system.SjjxTabCourseManager;
import com.xdsc.service.sjjx_system.SjjxTabCourselabManager;
import com.xdsc.service.sjjx_system.SjjxTabDirectionManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmenttypeManager;
import com.xdsc.service.sjjx_system.SjjxTabGradeManager;
import com.xdsc.service.sjjx_system.SjjxTabLabManager;
import com.xdsc.service.sjjx_system.SjjxTabTeachersManager;
import com.xdsc.util.UploadAction;

import jxl.*;

public class SjjxExcelInAction extends ActionSupport {
	
	private SjjxTabCourselabManager sjjxTabCourselabManager;
	private SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager;
    private SjjxTabLabManager sjjxTabLabManager;
    private SjjxTabCourseManager sjjxTabCourseManager;
    private SjjxTabTeachersManager sjjxTabTeachersManager;
    private SjjxTabClassesManager sjjxTabClassesManager;
    private SjjxTabDirectionManager sjjxTabDirectionManager;
	private SjjxTabGradeManager sjjxTabGradeManager;

	private String FEquTypeName;
	private String FRoomNumber;
	private String FLabName;
	private int FLabId;
	private String FDate;
	private String FExactTime;
	
	public int getFLabId() {
		return FLabId;
	}
	public void setFLabId(int labId) {
		FLabId = labId;
	}
	public String getFDate() {
		return FDate;
	}
	public void setFDate(String date) {
		FDate = date;
	}
	public String getFExactTime() {
		return FExactTime;
	}
	public void setFExactTime(String exactTime) {
		FExactTime = exactTime;
	}
	public String getFRoomNumber() {
		return FRoomNumber;
	}
	public void setFRoomNumber(String roomNumber) {
		FRoomNumber = roomNumber;
	}

	// static String createTableSql="";//创建数据库的sql
	static String colType = "varchar";// 字段类型
	static String key = "id";// 主键
	static String charSet = "utf8";// 表格字符类型
	static String ENGINE = "InnoDB";// 表格类型
	static String tableName;// 表名称
	static String tableValue;//表属性
	static String colName = "col";// 默认字段名
	static Connection conn = null;
	
	/**
	 * Excel表格导入数据库需要先将Excel文件上传
	 */
	private File file;// 封装上传文件
	private String fileContentType;// 封装上传文件类型
	private String fileFileName;//封装上传文件名
	private String savePath;// 封装上传文件保存路径
	private String path;//自定义上传文件路径值

	

	/**上传excel表格将数据存入数据库
	 * @return SUCCESS
	 * @throws Exception
	 */
	public String excelInLab() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
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

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

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
			return ERROR;
		}
		return SUCCESS;
	}

	public String excelInEquipType() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
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

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

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
			
			return ERROR;
			
		}
		return SUCCESS;
	}
	/**上传记录设备信息的excel表格并将数据存入数据库
	 * @return SUCCESS 
	 * @throws Exception
	 */

	public String excelInEquipment() throws Exception {
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

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();//建立数据库连接

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
					ps.setString(j+1, strValue);
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
	
	public String excelInCourseLab() throws Exception {
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

			System.out.println("colNum rowNum------------------" + rowNum
					+ "行," + colNum + "列+");
			System.out.println("start create ｂａｓｅ-------------------------");

			getConntion();//建立数据库连接

			String sql = getColName(rowNum, colNum);
			PreparedStatement ps = null;
			String strValue = "";
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			for (int i = 1; i < rowNum; i++) {
				strValue = "";                    
				for (int j = 1; j < colNum; j++) {
					if (j == 2) {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						//根据由Excel得到的课程名称获取课程编号，存入数据库
						String courseId = sjjxTabCourseManager.getCourseByCourseName(strValue).getFCourseNumber();
						ps.setString(j, String.valueOf(courseId));
					} 
					else if (j == 3) {
						Cell c = rs.getCell(j, i);
						strValue = c.getContents();
						//根据由Excel得到的教师名称获取教师学工号，存入数据库
						String teacherNumber = sjjxTabTeachersManager.getTeacherByTeacherName(strValue).getFTeacherNumber();
						ps.setString(j, String.valueOf(teacherNumber));
						
					}
//					else if (j == 7) {
//						Cell c = rs.getCell(j, i);
//						strValue = c.getContents();
//						//根据由Excel得到的年级名称获取年级编号，存入数据库
//						int gradeId = sjjxTabGradeManager.getGradeByGradeName(strValue).getFGradeId();
//						ps.setString(j, String.valueOf(gradeId));
//						
//					} 
//					else if (j == 8) {
//						Cell c = rs.getCell(j, i);
//						strValue = c.getContents();
//						//根据由Excel得到的方向名称获取方向编号，存入数据库
//						int directionId = sjjxTabDirectionManager.getDirectionByDirectionName(strValue).getFDirectionId();
//						ps.setString(j, String.valueOf(directionId));
//					} 
					else {
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
	

	static String getColName(int rowNum, int colNum) {
		// 可以做成可配置文件
		String colSql = "";
		String colValue = "";

		for (int j = 1; j < colNum; j++) {
			colSql = colSql + "'" + colName + j + "',";
			colValue = colValue + "" + "?,";
		}
		return "insert into " + tableName +"("+  tableValue +")"+ " values("
				+ colValue.substring(0, colValue.lastIndexOf(",")) + ");";
	}
	static String getColName1(int rowNum, int colNum) {
		// 可以做成可配置文件
		String colSql = "";
		String colValue = "";

		for (int j = 0; j < colNum; j++) {
			colSql = colSql + "'" + colName + j + "',";
			colValue = colValue + "" + "?,";
		}
		return "insert into " + tableName +"("+  tableValue +")"+ " values("
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

	/**各变量相应的get，set方法**/
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
	
	public SjjxTabCourseManager getSjjxTabCourseManager() {
		return sjjxTabCourseManager;
	}

	public void setSjjxTabCourseManager(SjjxTabCourseManager sjjxTabCourseManager) {
		this.sjjxTabCourseManager = sjjxTabCourseManager;
	}

	public SjjxTabTeachersManager getSjjxTabTeachersManager() {
		return sjjxTabTeachersManager;
	}

	public void setSjjxTabTeachersManager(
			SjjxTabTeachersManager sjjxTabTeachersManager) {
		this.sjjxTabTeachersManager = sjjxTabTeachersManager;
	}

	public SjjxTabClassesManager getSjjxTabClassesManager() {
		return sjjxTabClassesManager;
	}

	public void setSjjxTabClassesManager(SjjxTabClassesManager sjjxTabClassesManager) {
		this.sjjxTabClassesManager = sjjxTabClassesManager;
	}

	public SjjxTabDirectionManager getSjjxTabDirectionManager() {
		return sjjxTabDirectionManager;
	}

	public void setSjjxTabDirectionManager(
			SjjxTabDirectionManager sjjxTabDirectionManager) {
		this.sjjxTabDirectionManager = sjjxTabDirectionManager;
	}

	public SjjxTabGradeManager getSjjxTabGradeManager() {
		return sjjxTabGradeManager;
	}

	public void setSjjxTabGradeManager(SjjxTabGradeManager sjjxTabGradeManager) {
		this.sjjxTabGradeManager = sjjxTabGradeManager;
	}

	public SjjxTabLabManager getSjjxTabLabManager() {
		return sjjxTabLabManager;
	}

	public void setSjjxTabLabManager(SjjxTabLabManager sjjxTabLabManager) {
		this.sjjxTabLabManager = sjjxTabLabManager;
	}

	public SjjxTabEquipmenttypeManager getSjjxTabEquipmenttypeManager() {
		return sjjxTabEquipmenttypeManager;
	}

	public void setSjjxTabEquipmenttypeManager(
			SjjxTabEquipmenttypeManager sjjxTabEquipmenttypeManager) {
		this.sjjxTabEquipmenttypeManager = sjjxTabEquipmenttypeManager;
	}


	public String getFLabName() {
		return FLabName;
	}


	public void setFLabName(String labName) {
		FLabName = labName;
	}
	public String getFEquTypeName() {
		return FEquTypeName;
	}
	public void setFEquTypeName(String equTypeName) {
		FEquTypeName = equTypeName;
	}
	public SjjxTabCourselabManager getSjjxTabCourselabManager() {
		return sjjxTabCourselabManager;
	}
	public void setSjjxTabCourselabManager(
			SjjxTabCourselabManager sjjxTabCourselabManager) {
		this.sjjxTabCourselabManager = sjjxTabCourselabManager;
	}



}
