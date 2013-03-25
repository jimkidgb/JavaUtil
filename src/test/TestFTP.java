package test;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class TestFTP {

	
    FTPClient ftpClient;
    
    public void listFile(String url,int port,String username, String password, String path) {
		FTPClient ftp = new FTPClient();
		int reply;
		try {
			ftp.connect(url, port);// ����FTP������
			// �������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);// ��¼
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			
			ftp.listFiles(path);

            for (FTPFile f : ftp.listFiles(path)) {
                System.out.println(f.getRawListing());
               // System.out.println(f.toFormattedString());
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
    }
    
	
	/**
	 * Description: ��FTP�������ϴ��ļ�
	 * @Version1.0 Jul 27, 2008 4:31:09 PM by �޺챣��cuihongbao@d-heaven.com������
	 * @param url FTP������hostname
	 * @param port FTP�������˿�
	 * @param username FTP��¼�˺�
	 * @param password FTP��¼����
	 * @param path FTP����������Ŀ¼
	 * @param filename �ϴ���FTP�������ϵ��ļ���
	 * @param input ������
	 * @return �ɹ�����true�����򷵻�false
	 */
     public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);//����FTP������
			//�������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
			ftp.login(username, password);//��¼
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			ftp.changeWorkingDirectory(path);
			ftp.storeFile(filename, input);			
			
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	
 	/**
 	 * Description: ��FTP�����������ļ�
 	 * @Version1.0 Jul 27, 2008 5:32:36 PM by �޺챣��cuihongbao@d-heaven.com������
 	 * @param url FTP������hostname
 	 * @param port FTP�������˿�
 	 * @param username FTP��¼�˺�
 	 * @param password FTP��¼����
 	 * @param remotePath FTP�������ϵ����·��
 	 * @param fileName Ҫ���ص��ļ���
 	 * @param localPath ���غ󱣴浽���ص�·��
 	 * @return
 	 */
 	public static boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath) {
 		boolean success = false;
 		FTPClient ftp = new FTPClient();
 		try {
 			int reply;
 			ftp.connect(url, port);
 			//�������Ĭ�϶˿ڣ�����ʹ��ftp.connect(url)�ķ�ʽֱ������FTP������
 			ftp.login(username, password);//��¼
 			reply = ftp.getReplyCode();
 			if (!FTPReply.isPositiveCompletion(reply)) {
 				ftp.disconnect();
 				return success;
 			}
 			ftp.changeWorkingDirectory(remotePath);//ת�Ƶ�FTP������Ŀ¼
 			FTPFile[] fs = ftp.listFiles();
 			for(FTPFile ff:fs){
 				if(ff.getName().equals(fileName)){
 					File localFile = new File(localPath+"/"+ff.getName());
 					
 					OutputStream is = new FileOutputStream(localFile); 
 					ftp.retrieveFile(ff.getName(), is);
 					is.close();
 				}
 			}			
 			ftp.logout();
 			success = true;
 		} catch (IOException e) {
 			e.printStackTrace();
 		} finally {
 			if (ftp.isConnected()) {
 				try {
 					ftp.disconnect();
 				} catch (IOException ioe) {
 				}
 			}
 		}
 		return success;
 	}
	
 	
	/** * ����FTPĿ¼�µ��ļ��б� * @param ftpDirectory * @return */
//	public List<String> getFileNameList(String ftpDirectory) {
//		List<String> list = new ArrayList<String>();
//		try {
//			DataInputStream dis = new DataInputStream(ftpClient.nameList(ftpDirectory));
//			String filename = "";
//			while ((filename = dis.readLine()) != null) {
//				list.add(filename);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
 	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// sa saa 192.168.1.116
        System.out.println("��ʼ.........");
      
        TestFTP testftp = new TestFTP();
        //-----�鿴ָ��Ŀ¼���ļ��б�
        testftp.listFile("192.168.1.116", 21, "sa", "saa","/JIM/");
        
        
        //-----�ϴ�-----
//        InputStream input;
//		try {
//			input = new ByteArrayInputStream("12345".getBytes("utf-8"));
//			boolean flag = uploadFile("192.168.1.116", 21, "sa", "saa", "/JIM/", "FTP2.txt", input);  
//		    System.out.println(flag);  
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
       
        
        //-----����-------
        
        
        
        
        System.out.println("����.........");
	}

}
