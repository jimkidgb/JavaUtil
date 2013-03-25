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
		
		
		System.out.println("开始.........");
		  MailSenderInfo mailInfo = new MailSenderInfo();    
	      mailInfo.setMailServerHost(stmpmail);		  
	      mailInfo.setMailServerPort("25");    
	      mailInfo.setValidate(true);    
	      mailInfo.setUserName(usermail);    
	      mailInfo.setPassword(password);//您的邮箱密码    
	      mailInfo.setFromAddress(frommail);    
	      mailInfo.setToAddress(tomail);    
	      mailInfo.setSubject("有未处理的中心标准受控电子流程的信息");    
	      mailInfo.setContent("您有未领取的任务，请登入http://192.168.1.160:8080/srp/处理相关工作，谢谢。");    
	         //这个类主要来发送邮件   
	      SimpleMailSender sms = new SimpleMailSender();   
	        //  sms.sendTextMail(mailInfo);//发送文体格式    
	          sms.sendHtmlMail(mailInfo);//发送html格式   
   
	   
		System.out.println("结束.........");
	}

}
