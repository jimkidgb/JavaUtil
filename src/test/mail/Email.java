package test.mail;



public class Email {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// bz_tech_support 123
//		String stmpmail = "smtp.tyiel.com";
//		String usermail = "jimmy.xu@tyiel.com";
//		String password = "Jimmy123";
//		String frommail = "jimmy.xu@tyiel.com";
//		String tomail   =  "jimkidgb@gmail.com";
//		bz_tech_support@svic.com
		//String stmpmail = "mail.smvic.com.cn";
		String stmpmail = "10.232.2.4";
		String usermail = "bz_tech_support@smvic.com.cn";
		String password = "123";
		String frommail = "bz_tech_support@smvic.com.cn";
		String tomail   =  "274741679@qq.com";
		
		
		System.out.println("��ʼ.........");
		  MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost(stmpmail);		  
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName(usermail);    
	      mailInfo.setPassword(password);//������������    
	      mailInfo.setFromAddress(frommail);    
	      mailInfo.setToAddress(tomail);    
	      mailInfo.setSubject("��δ��������ı�׼�ܿص������̵���Ϣ");    
	      mailInfo.setContent("����δ��ȡ�����������http://192.168.1.160:8080/srp/������ع�����лл��");    
	         //�������Ҫ�������ʼ�   
	      SimpleMailSender sms = new SimpleMailSender();   
	        //  sms.sendTextMail(mailInfo);//���������ʽ    
	          sms.sendHtmlMail(mailInfo);//����html��ʽ   
   
	   
		System.out.println("����.........");
	}

}
