package test;

import java.util.Calendar;
import java.util.Date;

public class TestTimer {
	public static void main(String[] arg){
		System.out.println("Begining...");
		
//		String nowtime = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
//		//获得当前的小时
//		System.out.println(nowtime);
//		
//		String a = "EPSILON-Ⅱ";
//		
//		String b = " EPSI LON-II ";
//		
//		System.out.println(a.replaceAll("EPSILON-Ⅱ", "EPSILON-II"));
//		
//		System.out.println(b.trim());
		
		Date a =new Date();
		Calendar c = Calendar.getInstance(); //这句好像很浪费，我也不知道该怎么处理 
		c.setTime(a);//
		
		System.out.println(c.get(Calendar.YEAR));    //取出年份 
	    System.out.println(c.get(Calendar.MONTH)+1); //取出月份，要加1，因为是从0开始的(!)不知道为什么Sun要这样? 
		System.out.println(c.get(Calendar.DATE));    
		
		System.out.println("Ending...");
	}
}
