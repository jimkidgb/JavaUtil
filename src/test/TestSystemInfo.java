package test;

import java.util.Properties;

public class TestSystemInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start..........");
		
		Properties props=System.getProperties(); //���ϵͳ���Լ�    
		String osName = props.getProperty("os.name"); //����ϵͳ����    
		String osArch = props.getProperty("os.arch"); //����ϵͳ����    
		String osVersion = props.getProperty("os.version"); //����ϵͳ�汾
		
		System.out.println(osName + "===" + osArch + "===" + osVersion);
		
		System.out.println("End..........");
	}

}
