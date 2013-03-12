package test;
import org.apache.tools.zip.ZipOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;

public class TestZipFile {
     
	 /**//*
	    * inputFileName 输入一个文件夹
	    * zipFileName 输出一个压缩文件夹
	    */
	    public void zip(String inputFileName,String outputfilename) throws Exception {
	        zip(outputfilename, new File(inputFileName));
	    }

	    private void zip(String zipFileName, File inputFile) throws Exception {
	        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
	        zip(out, inputFile, "");
	        System.out.println("zip done");
	        out.close();
	    }

	    private void zip(ZipOutputStream out, File f, String base) throws Exception {
	        if (f.isDirectory()) {
	           File[] fl = f.listFiles();
	           out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
	           base = base.length() == 0 ? "" : base + "/";
	           for (int i = 0; i < fl.length; i++) {
	           zip(out, fl[i], base + fl[i].getName());
	         }
	        }else {
	           out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
	           FileInputStream in = new FileInputStream(f);
	           int b;
	           System.out.println(base);
	           while ( (b = in.read()) != -1) {
	            out.write(b);
	         }
	         in.close();
	       }
	    }

	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("开始..............");
		TestZipFile t = new TestZipFile();
		
		try {
			t.zip("D:\\QueryBack","./test.zip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("结束..............");
	}

}
