package test;

import java.util.Calendar;
import java.util.Date;

public class TestTimer {
	public static void main(String[] arg){
		System.out.println("Begining...");
		
//		String nowtime = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
//		//��õ�ǰ��Сʱ
//		System.out.println(nowtime);
//		
//		String a = "EPSILON-��";
//		
//		String b = " EPSI LON-II ";
//		
//		System.out.println(a.replaceAll("EPSILON-��", "EPSILON-II"));
//		
//		System.out.println(b.trim());
		
		Date a =new Date();
		Calendar c = Calendar.getInstance(); //��������˷ѣ���Ҳ��֪������ô���� 
		c.setTime(a);//
		
		System.out.println(c.get(Calendar.YEAR));    //ȡ����� 
	    System.out.println(c.get(Calendar.MONTH)+1); //ȡ���·ݣ�Ҫ��1����Ϊ�Ǵ�0��ʼ��(!)��֪��ΪʲôSunҪ����? 
		System.out.println(c.get(Calendar.DATE));    
		
		System.out.println("Ending...");
	}
}
