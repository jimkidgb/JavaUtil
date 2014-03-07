package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDayOfWeekA {

    /**
     * �жϵ�ǰ���������ڼ�<br>
     * <br>
     * @param pTime ��Ҫ�жϵ�ʱ��<br>
     * @return dayForWeek �жϽ��<br>
     * @Exception �����쳣<br>
     */
 public static int dayForWeek(String pTime) throws Exception {
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  Calendar c = Calendar.getInstance();
  c.setTime(format.parse(pTime));
  int dayForWeek = 0;
  if(c.get(Calendar.DAY_OF_WEEK) == 1){
   dayForWeek = 7;
  }else{
   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
  }
  return dayForWeek;
 }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Starting.....");
        Date a =new Date();
        Calendar c = Calendar.getInstance(); //��������˷ѣ���Ҳ��֪������ô���� 
  	    c.setTime(a);//
        String time =String.valueOf(c.get(Calendar.YEAR)) +  "-" + String.valueOf(c.get(Calendar.MONTH)+1)  +  "-" +  String.valueOf(c.get(Calendar.DATE));
        System.out.println(time);
        time = "2014-01-13";
        try {
			System.out.println(String.valueOf(dayForWeek(time)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Ending.......");
	}

}
