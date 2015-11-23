package com.xdsc.action.wsbm;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;
import com.xdsc.service.wsbm.DeleteManager;
import com.xdsc.util.Constant;
import com.xdsc.util.UploadAction;

import jxl.*;

public class UpdateTabWsbmAppAction extends ActionSupport {
	// static String createTableSql="";//�������ݿ��sql
	static String colType = "varchar";// �ֶ�����
	static String key = "id";// ����
	static String charSet = "utf8";// ����ַ�����
	static String ENGINE = "InnoDB";// �������
	static String tableName;// ������
	static String tableValue;//������
	static String colName = "col";// Ĭ���ֶ���
	static Connection conn = null;
	private List<WsbmTabRegapplicant> listRegapplicantinfo = new ArrayList<WsbmTabRegapplicant>();
	private AdAllCheckManager aacm;
	private DeleteManager deleteManager;

/**Excel��������ݿ���Ҫ�Ƚ�Excel�ļ��ϴ�**/
	private File file;// ��װ�ϴ��ļ�
	private String fileContentType;// ��װ�ϴ��ļ�����
	private String fileFileName;//��װ�ϴ��ļ���
	private String savePath;// ��װ�ϴ��ļ�����·��
	private String path;//�Զ����ϴ��ļ�·��ֵ
	
	private int size;
	private WsbmTabRegapplicant wsbmTabRegapplicant;

	

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return wsbmTabRegapplicant;
	}

	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String execute() throws Exception {
		try {
			
			listRegapplicantinfo=deleteManager.findRegapplicantInfo();
			listRegapplicantinfo.toArray();
			size=listRegapplicantinfo.size();
			System.out.println("size="+size+"Ready to Delete.......");
			for(int i=0;i<size;i++){
				wsbmTabRegapplicant = aacm.sepFindByNum(listRegapplicantinfo.get(i).getFAppRegNum());
				deleteManager.deleteAcc(wsbmTabRegapplicant);
				System.out.println("one Deleted!");
			}
			
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

			System.out.println("colNum rowNum------------------" + rowNum
					+ "��," + colNum + "��+");
			System.out.println("start create �����-------------------------");

			getConntion();//�������ݿ�����

			String sql = getColName(rowNum, colNum);
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
		listRegapplicantinfo=deleteManager.findRegapplicantInfo();
		return "updateTabWsbmApp";
	}

	static String getColName(int rowNum, int colNum) {
		// �������ɿ������ļ�
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
			String db_password = Constant.dbpassword;

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

	/**��������Ӧ��get��set����**/
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

	public List<WsbmTabRegapplicant> getListRegapplicantinfo() {
		return listRegapplicantinfo;
	}

	public void setListRegapplicantinfo(
			List<WsbmTabRegapplicant> listRegapplicantinfo) {
		this.listRegapplicantinfo = listRegapplicantinfo;
	}

	public DeleteManager getDeleteManager() {
		return deleteManager;
	}

	public void setDeleteManager(DeleteManager deleteManager) {
		this.deleteManager = deleteManager;
	}

	public AdAllCheckManager getAacm() {
		return aacm;
	}

	public void setAacm(AdAllCheckManager aacm) {
		this.aacm = aacm;
	}
}
