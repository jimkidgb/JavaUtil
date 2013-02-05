package test;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Random;

public class Rename {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		File f = new File("D:\\old.txt");
//		String c = f.getParent();
//		System.out.println(f.exists()+"  "+ c + "\\" + "new.txt");
//		File mm = new File(c + "\\" + "new.txt");
//		
//		if (f.renameTo(mm)) {
//			System.out.println("修改成功!");
//		} else {
//			System.out.println("修改失败");
//		}
//		long epoch = System.currentTimeMillis()/1000;
//		
//		Date date = new Date();
//		Random r = new Random(date.getTime());
//		System.out.println(f.getParent());
//		System.out.println(f.getName().substring(f.getName().lastIndexOf(".") + 1));
//		System.out.println(epoch  + ".");
//		
//		System.out.println(epoch  + "_" + r.nextInt(10000)+ ".");
		
//		String filename = "/outnewsFile/2011-11-25/845c7414-8f4b-4eb2-ae13-1e5bc0732564.pdf";
//		
//		System.out.println(filename.substring(0, filename.lastIndexOf("/")+1));
		//String str = "1234567890";
		//System.out.println(str.substring(0,100));
		//System.out.println(str.substring(0,2));
		
		String str = "004";
		
		int count = Integer.valueOf(str);
		
		
		NumberFormat integerFormat = new DecimalFormat("000");
		String ver = integerFormat.format(count - 1);
		
		System.out.println(ver);
	}

}
