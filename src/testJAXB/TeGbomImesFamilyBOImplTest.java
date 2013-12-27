package testJAXB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.saicmotor.services.services.GBOMFamilyChangeData;






public class TeGbomImesFamilyBOImplTest  {

	public static String strXml = "";

	public static String readFile(String filePathAndName) {
	       String fileContent = "";
	       try {
		       	File f = new File(filePathAndName);
				if(f.isFile()&&f.exists()){
				InputStreamReader read = new InputStreamReader(new FileInputStream(f),"UTF-8");
				BufferedReader reader=new BufferedReader(read);
				String line;
						while ((line = reader.readLine()) != null) {
						fileContent += line;
						}
				read.close();
			    }
		    } catch (Exception e) {
		    	System.out.println("读取文件内容操作出错");
		    	e.printStackTrace();
			}
		   return fileContent;
	}

	private static void init() throws IOException {
		//读取XMl	
//		FileInputStream myxml = null;
//		myxml = new FileInputStream("./thai_20130912/test_GBOM_IMES_01.xml");
//		BufferedReader myxls = new BufferedReader(new InputStreamReader(myxml));
//		String temp = "";
//		while ((temp = myxls.readLine()) != null) {
//
//			strXml += temp;
//		}
//		myxls.close();
		//strXml = readFile("./thai_20130912/test_GBOM_IMES_01.xml");
		strXml = readFile("E:\\GBOM_IMES_FAMILY_0002771639.xml");
		//strXml = readFile("D:\\GBOM_IMES_FAMILY_0002771639.xml");
	}

	public static void testXmltoObject() {

		if (strXml == null || strXml.equals("")) {
			System.out.println("没有接受数据");
		}

		GBOMFamilyChangeData b01Data = JAXBUtil.unmarshal(strXml, GBOMFamilyChangeData.class);
		if (b01Data == null) {
			System.out.println("解析失败1");
		}

		List<GBOMFamilyChangeData.TbFamilyNlvChngs> lanuages = b01Data.getTbFamilyNlvChngs();
		if (lanuages == null || lanuages.size() != 2) {
			System.out.println("解析失败2");
		}

		
	}

	public static void main(String[] args) {
		System.out.println("Starting......");
		try {
			init();
			System.out.println(strXml);
			testXmltoObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Ending........");
	}
}
