package com.xdsc.service.mail_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketException;

import org.apache.commons.net.telnet.TelnetClient;


/**��������������ʼ�����������������ע�� �޸����� ɾ���û��Ȳ���
 * @author ֣��˫
 *
 */
public class MailServer {

	public static final String LINE_SEPARATOR = System.getProperties()
			.getProperty("line.separator");

	/** ���ʼ���������ע�����û�
	 * @param username �û���
	 * @param password ����
	 */
	public void addUser(String username, String password) {
		BufferedReader m_reader;
		OutputStreamWriter m_writer;
		TelnetClient m_telnetClient = new TelnetClient();
		try {
			// ����Telnet��ʱ
			m_telnetClient.setDefaultTimeout(10000);
			// ����Telnet��������ַ���˿�
			m_telnetClient.connect("localhost", 4555);
			// ������ȡ�������
			m_reader = new BufferedReader(new InputStreamReader(m_telnetClient
					.getInputStream()));
			// �������ڷ���Telnet�������
			m_writer = new OutputStreamWriter(m_telnetClient.getOutputStream());
			// ���Ͻ��յ�½�ɹ����źţ���ʱ�׳��쳣��������һ��������ִ��
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
			// ����James�������û���,��Ϊ����Ա�û�����������ͨ�û���Ĭ��Ϊroot
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����root�û�����
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����Telnet��������û�
			m_writer.write("adduser " + username + " " + password + ""
					+ LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����û��б�
			m_writer.write("listusers" + LINE_SEPARATOR);
			m_writer.flush();
			// ��ʾ�û��б�
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
	
	
	/**�޸��û�������
	 * @param username �û���
	 * @param password ����
	 */
	public void modifyPassowrd(String username, String password) {
		BufferedReader m_reader;
		OutputStreamWriter m_writer;
		TelnetClient m_telnetClient = new TelnetClient();
		try {
			// ����Telnet��ʱ
			m_telnetClient.setDefaultTimeout(10000);
			// ����Telnet��������ַ���˿�
			m_telnetClient.connect("localhost", 4555);
			// ������ȡ�������
			m_reader = new BufferedReader(new InputStreamReader(m_telnetClient
					.getInputStream()));
			// �������ڷ���Telnet�������
			m_writer = new OutputStreamWriter(m_telnetClient.getOutputStream());
			// ���Ͻ��յ�½�ɹ����źţ���ʱ�׳��쳣��������һ��������ִ��
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
			// ����James�������û���,��Ϊ����Ա�û�����������ͨ�û���Ĭ��Ϊroot
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����root�û�����
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����Telnet��������û�
			m_writer.write("setpassword " + username + " " + password + ""
					+ LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����û��б�
			m_writer.write("listusers" + LINE_SEPARATOR);
			m_writer.flush();
			// ��ʾ�û��б�
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
	
	/** ɾ��һ���û�
	 * @param username �û���
	 */
	public void deleteUser(String username) {
		BufferedReader m_reader;
		OutputStreamWriter m_writer;
		TelnetClient m_telnetClient = new TelnetClient();
		try {
			// ����Telnet��ʱ
			m_telnetClient.setDefaultTimeout(10000);
			// ����Telnet��������ַ���˿�
			m_telnetClient.connect("localhost", 4555);
			// ������ȡ�������
			m_reader = new BufferedReader(new InputStreamReader(m_telnetClient
					.getInputStream()));
			// �������ڷ���Telnet�������
			m_writer = new OutputStreamWriter(m_telnetClient.getOutputStream());
			// ���Ͻ��յ�½�ɹ����źţ���ʱ�׳��쳣��������һ��������ִ��
			try {
				for (;;) {
					System.out.println(m_reader.readLine());
				}
			} catch (Exception e) {
			}
			// ����James�������û���,��Ϊ����Ա�û�����������ͨ�û���Ĭ��Ϊroot
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����root�û�����
			m_writer.write("root" + LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����Telnet��������û�
			m_writer.write("deluser " + username +""
					+ LINE_SEPARATOR);
			m_writer.flush();
			System.out.println(m_reader.readLine());
			// ����û��б�
			m_writer.write("listusers" + LINE_SEPARATOR);
			m_writer.flush();
			// ��ʾ�û��б�
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
