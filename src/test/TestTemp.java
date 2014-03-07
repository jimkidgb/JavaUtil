package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestTemp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean flag = false;
		try {
				String  ip = InetAddress.getLocalHost().getHostAddress();			
				System.out.println("IP" + ip);
				if("10.108.10.210".equalsIgnoreCase(ip)){
					flag =true;
				}
		} catch (UnknownHostException e1) {
					
			e1.printStackTrace();
		}
		
		System.out.println(flag);
      
	}
}
