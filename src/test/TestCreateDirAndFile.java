package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCreateDirAndFile {



	public static boolean createDir(String destDirName) {
	    File dir = new File(destDirName);
	    if(dir.exists()) {
	     System.out.println("创建" + destDirName + "失败");
	     return false;
	    }
	    if(!destDirName.endsWith(File.separator))
	     destDirName = destDirName + File.separator;	    
	    if(dir.mkdirs()) {
	     System.out.println("创建" + destDirName + "成功");
	     return true;
	    } else {
	     System.out.println("创建" + destDirName + "创建");
	     return false;
	    }
	}


	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCreateDirAndFile t = new TestCreateDirAndFile();
		
//		String dir = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "=" + System.currentTimeMillis();;
//		
//	   String attachfile = "attach";
//	        
//		
//		t.createDir(dir);
//		createDir(dir+"\\"+attachfile);
//	
//		String filecontent  = "123中文";
//		String filename = "date.js";
//		
//		t.createfile(dir,filename,filecontent);
        try {
			t.copyDirectiory("D:\\workspace\\srp\\WebRoot\\manage\\report\\exporttemplate", "D:\\QueryBack\\test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	private void createfile(String dir,String filename, String filecontent) {
		 try{
			   String fileName = dir + "\\" + filename;			  
			   File myFile = new File(fileName);			  
			   if(!myFile.exists())
			    myFile.createNewFile();
			   FileWriter resultFile = new FileWriter(myFile);
			   PrintWriter myNewFile = new PrintWriter(resultFile);			  
			   myNewFile.println(filecontent);
			   resultFile.close(); 
			   
			   
			   
			  }catch(Exception ex){
			   System.out.println("创建文件失败");
			   ex.printStackTrace();
			  }
		
	}
	
	
	 // 复制文件
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
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

    // 复制文件夹
    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        // 新建目标目录
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile = file[i];
                // 目标文件
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                // 准备复制的源文件夹
                String dir1 = sourceDir + "/" + file[i].getName();
                // 准备复制的目标文件夹
                String dir2 = targetDir + "/" + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }


	

}
