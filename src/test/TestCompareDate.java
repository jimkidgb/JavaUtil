package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCompareDate {
    public static void main(String args[]){
    	Date now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	try {
			Date date = sdf.parse("2013-04-19");		
//			Calendar today = Calendar.getInstance();
//	    	today.setTime(now);
//	       
//	    	Calendar carrierday = Calendar.getInstance();
//	    	carrierday.setTime(date);
//	    	
//	    	//���ж��Ƿ�ͬһ��
//	    	System.out.println(today.YEAR+ " " + today.MONTH + " " + today.DAY_OF_MONTH);
//	    	
//	    	System.out.println(now.getYear());
	    	
	    	
	    	DateFormat formate = new SimpleDateFormat("yyyy/MM/dd"); 
	    	String dateStr = formate.format(now); 
	    	System.out.println(dateStr);
	    	DateFormat formate2 = new SimpleDateFormat("yyyy/MM/dd"); 
	    	String carrierStr = formate2.format(date); 
	    	System.out.println(carrierStr);
	    	
	    	Date nowday = formate.parse(dateStr);    
	    	
	    	if(dateStr.startsWith(carrierStr)){
	    		System.out.println("ͬһ��");	  
	    		System.out.println("��ǰ��ʱ��+"+now.getHours());
	    	}else{
	    		//�ж��Ƿ���֮�������
	    		if(now.before(date)){
	    			System.out.println("֮���һ��");
	    			Long DAY = 24L * 60L * 60L * 1000L;
	    			
	    			System.out.println( "is: " + (( date.getTime() - nowday.getTime()) / DAY )); 
	    			
	    		}
	    		
	    	}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }
}
