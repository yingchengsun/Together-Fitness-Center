package com.xdsc.service.mail_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketException;

import org.apache.commons.net.telnet.TelnetClient;


/**这个类主用是与邮件服务器交互，包括注册 修改密码 删除用户等操作
 * @author 郑灿双
 *
 */
public class MailServer {

	public static final String LINE_SEPARATOR = System.getProperties()
			.getProperty("line.separator");

	/** 向邮件服务器中注册新用户
	 * @param username 用户名
	 * @param password 密码
	 */
	public void addUser(String username, String password) {
		BufferedReader m_reader;
		OutputStreamWriter m_writer;
		TelnetClient m_telnetClient = new TelnetClient();
		try {
			// 设置Telnet超时
			m_telnetClient.setDefaultTimeout(10000);
			// 设置Telnet服务器地址及端口
			m_telnetClient.connect("localhost", 4555);
			// 创建读取缓冲对象
			m_reader = new BufferedReader(new InputStreamReader(m_telnetClient
					.getInputStream()));
			// 创建用于发送Telnet命令对象
			m_writer = new OutputStreamWriter(m_telnetClient.getOutputStream());
			// 不断接收登陆成功的信号，超时抛出异常，则跳至一下条代码执行
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
			// 输入James服务器用户名,此为管理员用户名，而非普通用户，默认为root
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输入root用户密码
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输入Telnet命令添加用户
			m_writer.write("adduser " + username + " " + password + ""
					+ LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输出用户列表
			m_writer.write("listusers" + LINE_SEPARATOR);
			m_writer.flush();
			// 显示用户列表
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**修改用户的密码
	 * @param username 用户名
	 * @param password 密码
	 */
	public void modifyPassowrd(String username, String password) {
		BufferedReader m_reader;
		OutputStreamWriter m_writer;
		TelnetClient m_telnetClient = new TelnetClient();
		try {
			// 设置Telnet超时
			m_telnetClient.setDefaultTimeout(10000);
			// 设置Telnet服务器地址及端口
			m_telnetClient.connect("localhost", 4555);
			// 创建读取缓冲对象
			m_reader = new BufferedReader(new InputStreamReader(m_telnetClient
					.getInputStream()));
			// 创建用于发送Telnet命令对象
			m_writer = new OutputStreamWriter(m_telnetClient.getOutputStream());
			// 不断接收登陆成功的信号，超时抛出异常，则跳至一下条代码执行
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
			// 输入James服务器用户名,此为管理员用户名，而非普通用户，默认为root
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输入root用户密码
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输入Telnet命令添加用户
			m_writer.write("setpassword " + username + " " + password + ""
					+ LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输出用户列表
			m_writer.write("listusers" + LINE_SEPARATOR);
			m_writer.flush();
			// 显示用户列表
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 删除一个用户
	 * @param username 用户名
	 */
	public void deleteUser(String username) {
		BufferedReader m_reader;
		OutputStreamWriter m_writer;
		TelnetClient m_telnetClient = new TelnetClient();
		try {
			// 设置Telnet超时
			m_telnetClient.setDefaultTimeout(10000);
			// 设置Telnet服务器地址及端口
			m_telnetClient.connect("localhost", 4555);
			// 创建读取缓冲对象
			m_reader = new BufferedReader(new InputStreamReader(m_telnetClient
					.getInputStream()));
			// 创建用于发送Telnet命令对象
			m_writer = new OutputStreamWriter(m_telnetClient.getOutputStream());
			// 不断接收登陆成功的信号，超时抛出异常，则跳至一下条代码执行
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
			// 输入James服务器用户名,此为管理员用户名，而非普通用户，默认为root
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输入root用户密码
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输入Telnet命令添加用户
			m_writer.write("deluser " + username +""
					+ LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// 输出用户列表
			m_writer.write("listusers" + LINE_SEPARATOR);
			m_writer.flush();
			// 显示用户列表
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
