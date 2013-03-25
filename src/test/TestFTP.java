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
			ftp.connect(url, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
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
	 * Description: 向FTP服务器上传文件
	 * @Version1.0 Jul 27, 2008 4:31:09 PM by 崔红保（cuihongbao@d-heaven.com）创建
	 * @param url FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param username FTP登录账号
	 * @param password FTP登录密码
	 * @param path FTP服务器保存目录
	 * @param filename 上传到FTP服务器上的文件名
	 * @param input 输入流
	 * @return 成功返回true，否则返回false
	 */
     public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port);//连接FTP服务器
			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);//登录
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
 	 * Description: 从FTP服务器下载文件
 	 * @Version1.0 Jul 27, 2008 5:32:36 PM by 崔红保（cuihongbao@d-heaven.com）创建
 	 * @param url FTP服务器hostname
 	 * @param port FTP服务器端口
 	 * @param username FTP登录账号
 	 * @param password FTP登录密码
 	 * @param remotePath FTP服务器上的相对路径
 	 * @param fileName 要下载的文件名
 	 * @param localPath 下载后保存到本地的路径
 	 * @return
 	 */
 	public static boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath) {
 		boolean success = false;
 		FTPClient ftp = new FTPClient();
 		try {
 			int reply;
 			ftp.connect(url, port);
 			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
 			ftp.login(username, password);//登录
 			reply = ftp.getReplyCode();
 			if (!FTPReply.isPositiveCompletion(reply)) {
 				ftp.disconnect();
 				return success;
 			}
 			ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录
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
	
 	
	/** * 返回FTP目录下的文件列表 * @param ftpDirectory * @return */
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
        System.out.println("开始.........");
      
        TestFTP testftp = new TestFTP();
        //-----查看指定目录的文件列表
        testftp.listFile("192.168.1.116", 21, "sa", "saa","/JIM/");
        
        
        //-----上传-----
//        InputStream input;
//		try {
//			input = new ByteArrayInputStream("12345".getBytes("utf-8"));
//			boolean flag = uploadFile("192.168.1.116", 21, "sa", "saa", "/JIM/", "FTP2.txt", input);  
//		    System.out.println(flag);  
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
       
        
        //-----下载-------
        
        
        
        
        System.out.println("结束.........");
	}

}
