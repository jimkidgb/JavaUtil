package testAD;

import java.util.Map;

public class TestAD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = System.getenv();
	    String userName = map.get("USERNAME");// ��ȡ�û���
	    String computerName = map.get("COMPUTERNAME");// ��ȡ�������
	    String userDomain = map.get("USERDOMAIN");// ��ȡ���������
	    System.out.println(userName);
	    System.out.println(computerName);
	    System.out.println(userDomain);
	}

}
