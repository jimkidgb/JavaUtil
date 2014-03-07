package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCopyFile {

	private static String readFile = "D:\\coyfile\\list.txt";

	private static String successFile = "D:\\coyfile\\success.txt";

	private static String erroFile = "D:\\coyfile\\erro.txt";

	private static String copyFile = "D:\\coyfile\\file\\";

	private static String fileName = "D:\\coyfile\\filename.txt";

	private static String filepath = "D:\\Tomcat7\\webapps\\shacdp";

	static List<String> erroFiles = new ArrayList<String>();
	static List<String> successFiles = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.println("Starting..............");
		// 先读readFile得到需要复制的文件
		List<String> filepaths = readFile(readFile);
		System.out.println("文件数量" + filepaths.size());
		// 转换得到文件名
		List<String> filename = new ArrayList<String>();
		for (String filepath : filepaths) {
			filename.add(suitFileName(filepath));
		}
		System.out.println("文件名数量" + filename.size());
		// 文件名写入
		writeFileName(filename);

		// 复制文件到指定目录
		copyFiles(filepaths);

		// 记录成功和失败
		writeFile(erroFiles, erroFile);
		writeFile(successFiles, successFile);

		System.out.println("Ending..............");
	}

	private static void writeFile(List<String> FilesList, String FilePath) {
		File file = new File(FilePath);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file, false);
			for (String filename : FilesList) {
				StringBuffer sb = new StringBuffer();
				sb.append(filename + "\r\n");
				out.write(sb.toString().getBytes("utf-8"));
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void copyFiles(List<String> filepaths) {
		for (String temp : filepaths) {
			String tp = filepath + temp;
			File file = new File(tp);
			if (!file.exists()) {
				erroFiles.add(temp);
				continue;
			}
			// 源文件
			File sourceFile = file;
			// 目标文件
			File targetFile = new File(copyFile + File.separator
					+ file.getName());
			try {
				copyFile(sourceFile, targetFile);
				successFiles.add(temp);
			} catch (IOException e) {
				e.printStackTrace();
				erroFiles.add(temp);
			}

		}
	}

	private static void writeFileName(List<String> filenames) {
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(file, false);
			for (String filename : filenames) {
				StringBuffer sb = new StringBuffer();
				sb.append(filename + "\r\n");
				out.write(sb.toString().getBytes("utf-8"));
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String suitFileName(String filepath) {
		String flag = filepath;
		File filename = new File(flag);
		flag = filename.getName();
		return flag;
	}

	private static List<String> readFile(String readFile) {
		List filename = new ArrayList();
		File file = new File(readFile);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp = null;
			temp = br.readLine();
			while (temp != null) {
				filename.add(temp);
				temp = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}

	// 复制文件
	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}
}
