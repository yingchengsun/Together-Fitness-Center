package com.xdsc.action.bksx_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ѹ�����ѹ���ļ�
 */
public class CompressUtil {
	/**
	 * 
	 * ѹ���ļ� ���� Ŀ¼
	 * 
	 * @param baseDirName
	 *            ѹ���ĸ�Ŀ¼
	 * @param fileName
	 *            ��Ŀ¼�´�ѹ�����ļ����ļ�����
	 * @param targetFileName
	 *            Ŀ�� ZIP �ļ�
	 * 
	 * �Ǻ� "*" ��ʾѹ����Ŀ¼�µ�ȫ���ļ�
	 * 
	 */
	public static void zipFile(String baseDirName, String[] fileNames,
			String targetFileName) throws IOException {
		/**
		 * ����� "ѹ���ĸ�Ŀ¼" �ļ���·���õ�һ�� File ���� ���ж���� File �����ʾ���ļ��Ƿ����! �Ƿ���һ���ļ���!.....
		 */
		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || (!baseDir.isDirectory())) {
			System.out.println("ѹ��ʧ��! ��Ŀ¼������: " + baseDirName);
			return;
		}
		// �õ���� "ѹ���ĸ�Ŀ¼" ��·��.........
		String baseDirPath = baseDir.getAbsolutePath();
		/**
		 * ����� "Ŀ�� ZIP �ļ�" �ļ����õ�һ�� ѹ������ ZipOutputStream
		 */
		File targetFile = new File(targetFileName);
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				targetFile));
		// "*" ��ʾѹ��������Ŀ¼ baseDirName ���ڵ�ȫ���ļ� �� targetFileName�ļ���
		if (fileNames.equals("*")) {
			CompressUtil.dirToZip(baseDirPath, baseDir, out);
		} else {
			File[] files = new File[fileNames.length];
			for (int i = 0; i < files.length; i++) {
				// ���� parent ����·������ child ·�����ַ�������һ���� File ʵ����
				files[i] = new File(baseDir, fileNames[i]);
			}
			if (files[0].isFile()) {
				// ���ñ����һ����̬���� ѹ��һ���ļ�
				// CompressUtil.fileToZip(baseDirPath, file, out);
				CompressUtil.filesToZip(baseDirPath, files, out);
			}

		}
		out.close();
		System.out.println("ѹ���ɹ�! Ŀ���ļ���Ϊ: " + targetFileName);
	}

	/**
	 * 
	 * ��ȡ��ѹ���ļ��� ZIP �ļ��е� entry ������! ������ڸ�Ŀ¼�����·����
	 * 
	 */
	private static String getEntryName(String baseDirPath, File file) {
		/**
		 * �ı� baseDirPath ����ʽ �� "C:\temp" ��� "C:\temp\"
		 */
		if (!baseDirPath.endsWith(File.separator)) {
			baseDirPath += File.separator;
		}
		String filePath = file.getAbsolutePath();
		/**
		 * ���Դ˳���·������ʾ���ļ��Ƿ���һ��Ŀ¼�� Ҫ������ļ�������һ��Ŀ¼ ��ҲҪ��� ����� "/"
		 * 
		 * ����ļ����������� "C:\temp\����д��\1.jpg"
		 * 
		 * Ҫ������ļ���һ���ļ��� ��ҲҪ��� ����� "/" ��Ϊ��Ҫ�ǲ�������,��Ҳ�ᱻѹ����Ŀ���ļ��� ����ȴ����������ʾ
		 * Ҳ����˵����ϵͳ������ȷʶ�������ļ�����(���ļ������ļ���)
		 */
		if (file.isDirectory()) {
			filePath += "/";
		}
		int index = filePath.indexOf(baseDirPath);
		return filePath.substring(index + baseDirPath.length());
	}

	/**
	 * ���ļ�ѹ����Zip �����
	 * 
	 * @author
	 * @throws IOException
	 * 
	 */
	private static void fileToZip(String baseDirPath, File file,
			ZipOutputStream out) throws IOException {
		//
		FileInputStream in = null;
		ZipEntry entry = null;
		// �������ƻ����� 1024*4 = 4K
		byte[] buffer = new byte[1024 * 4];
		int bytes_read = 0;
		if (file.isFile()) {
			in = new FileInputStream(file);
			// ���� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ��
			String zipFileName = getEntryName(baseDirPath, file);
			entry = new ZipEntry(zipFileName);
			// "ѹ���ļ�" ������� "Ҫѹ�����ļ�" ����
			out.putNextEntry(entry);
			// �����ǰ� "Ҫѹ�����ļ�" �����е�����д�뵽 "ѹ���ļ�" ����
			while ((bytes_read = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytes_read);
			}
			out.closeEntry();
			in.close();
			System.out.println("����ļ�" + file.getAbsolutePath() + "�� ZIP �ļ���!");
		}
	}

	/**
	 * 
	 * ����ļ�Ŀ¼ѹ����Zip �����
	 */
	@SuppressWarnings("unused")
	private static void filesToZip(String baseDirPath, File[] files,
			ZipOutputStream out) throws IOException {
		// �������е��ļ� һ��һ����ѹ��
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.isFile()) {
				// ���ñ����һ����̬���� ѹ��һ���ļ�
				CompressUtil.fileToZip(baseDirPath, file, out);
			} else {
				/*
				 * ����һ���ļ��� ����Ҫ�ٴεõ�����������е��ļ� �������Լ������Լ�..............�ݹ�..........
				 */
				CompressUtil.dirToZip(baseDirPath, file, out);
			}
		}
	}

	/**
	 * 
	 * ���ļ�Ŀ¼ѹ����Zip �����
	 */
	private static void dirToZip(String baseDirPath, File dir,
			ZipOutputStream out) throws IOException {
		// �õ�һ���ļ��б� (��Ŀ¼�µ������ļ����󼯺�)
		File[] files = dir.listFiles();
		/**
		 * Ҫ������ļ���������ĳ���Ϊ 0 , Ҳ��֤��������һ���յ��ļ���
		 * 
		 * ��Ȼû����ѭ���������ı�Ҫ,����ҲҪ��������ļ���Ҳѹ����Ŀ���ļ���ȥ
		 */
		if (files.length == 0) {
			// ���� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ��
			String zipFileName = getEntryName(baseDirPath, dir);
			ZipEntry entry = new ZipEntry(zipFileName);
			out.putNextEntry(entry);
			out.closeEntry();
		} else {
			// �������е��ļ� һ��һ����ѹ��
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (file.isFile()) {
					// ���ñ����һ����̬���� ѹ��һ���ļ�
					CompressUtil.fileToZip(baseDirPath, file, out);
				} else {
					/*
					 * ����һ���ļ��� ����Ҫ�ٴεõ�����������е��ļ�
					 * �������Լ������Լ�..............�ݹ�..........
					 */
					CompressUtil.dirToZip(baseDirPath, file, out);
				}
			}
		}
	}

	/**
	 * ������������� �� ѹ���ļ���..........
	 * 
	 */
	public static void upzipFile(String zipFileName, String targetBaseDirName)
			throws IOException {
		/**
		 * �ı� targetBaseDirName ����ʽ �� "C:\temp.zip" ��� "C:\temp.zip\"
		 */
		if (!targetBaseDirName.endsWith(File.separator)) {
			targetBaseDirName += File.separator;
		}
		// ���� ZIP �ļ����� zipFileName ����
		ZipFile zipFile = new ZipFile(zipFileName);
		ZipEntry entry = null;
		String entryName = null;
		String targetFileName = null;
		// �������ƻ����� 1024*4 = 4K
		byte[] buffer = new byte[1024 * 4];
		int bytes_read;
		// �� ZipFile ���� �õ�һ���оټ���.......
		Enumeration entrys = zipFile.entries();
		// �����������
		while (entrys.hasMoreElements()) {
			// ǿ��ת���� ZipEntry ����
			entry = (ZipEntry) entrys.nextElement();
			// �õ� ZipEntry ������ļ�����;
			entryName = entry.getName();
			/**
			 * C:\temp.zip\ + love.txt = C:\temp.zip\love.txt
			 */
			targetFileName = targetBaseDirName + entryName;
			// ��� ZipEntry ��һ��Ŀ¼ �򴴽����Ŀ¼
			if (entry.isDirectory()) {
				new File(targetFileName).mkdirs();
				// ���� �����±���..............
				continue;
			} else {
				/**
				 * �����һ����ͨ�ļ� �򴴽�����ļ��ĸ�Ŀ¼�Դ洢���ļ�
				 * 
				 * ���� C:\temp.zip\other\love.txt ��ô�����ȴ��� C:\temp.zip\other �ļ�Ŀ¼
				 * ������ִ����д�� love.txt �ļ�����...........
				 * 
				 * ��������ִ��.............
				 */
				new File(targetFileName).getParentFile().mkdirs();
			}
			File targetFile = new File(targetFileName);
			System.out.println("�����ļ��ɹ�.........."
					+ targetFile.getAbsolutePath());
			// ������ļ����� �õ�һ���ļ�д��������..........
			FileOutputStream os = new FileOutputStream(targetFile);
			// �� ZipFile �����getInputStream()���� ������ ZipEntry �õ���ȡ������
			InputStream is = zipFile.getInputStream(entry);
			// �߶���д...........
			while ((bytes_read = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytes_read);
			}
			// �ر���..........
			os.close();
			is.close();
		}
		System.out.println("===============��ѹ���ļ��ɹ�=================");
	}

	// /**
	// *
	// * *************************************************
	// ����Ҫ��ʼ������...........<br/><br/>
	// *
	// * ��Ҫȷ�����Ҫѹ�����ļ����ļ�ȫ·��(�����ļ�����)!<br/><br/>
	// *
	// * ��ȷ��Ҫѹ�����ļ��� (��һ��Ҫ�� Ҫѹ���ļ� baseDirName ������)! Ҫ�Ǹ����ַ��������ļ������� "*" ��ô����Ҫѹ��
	// * "Ҫѹ�����ļ�" �������Լ��������ڵ������ļ�<br/><br/>
	// *
	// * Ȼ��ȷ��Ҫѹ�����ѹ���ļ�ȫ·��(�����ļ����Ӽ����� zip ��׺)!<br/><br/>
	// *
	// *
	// *
	// * @param baseDirName
	// * Ҫѹ�����ļ�Ŀ¼·����
	// *
	// * @param fileName
	// * Ҫѹ�����ļ��� ������һ������,����·��! Ҳ���� "*" ��Ϊѹ����Ŀ¼�е������ļ�)
	// *
	// * @param zipFileName
	// * ѹ����ɺ���ļ�·������.......
	// *
	// * @param targetBaseDirName
	// * Ҫ ��ѹ�� ����ļ�·������..........
	// * **************************************************
	// *
	// * @author Mar 5, 2008 11:48:29 PM
	// *
	// */
	// public static void main(String[] args) {
	//
	// String baseDirName = "D:/myfiles";
	//
	// String[] fileNames = { "����.txt","002.jpg","003.doc" };
	// // String fileName = "test";
	// String zipFileName = "D:/data.zip";
	// try {
	// CompressUtil.zipFile(baseDirName, fileNames, zipFileName);
	// } catch (IOException e) {
	// System.out.println(e.getMessage());
	// e.printStackTrace();
	// }
	// /**
	// * *************************************************** ��ѹ��
	// * ***************************************************
	// */
	// String targetBaseDirName = "D:/test";
	// try {
	// CompressUtil.upzipFile(zipFileName, targetBaseDirName);
	// } catch (IOException e) {
	// System.out.println(e.getMessage());
	// e.printStackTrace();
	// }
	// }
}
