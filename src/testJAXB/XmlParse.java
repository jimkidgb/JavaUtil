/**********************************************************************
 * FILE : XmlParse.java
 * CREATE DATE : 2008-12-5
 * DESCRIPTION :
 *		用于对XML数据进行解析
 *      
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2008-12-5 |  xiaoxiao  |    创建草稿版本
 * 2  | 2011-11-10 |  zhoujun  |    增加parse(String xmlString, String characterSet, String[] destfields)的方法，直接从XML字符串解析内容
 *---------------------------------------------------------------------              
 **********************************************************************
 */
package testJAXB;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.DOMBuilder;
import org.xml.sax.InputSource;

/**
 * Project Name:xmlparse
 * 
 * Package:com.ibm.saic.mm.xmlparse
 * 
 * FileName:XmlParse_xxx.java
 * 
 * @author liming
 * 
 * Purpose:
 * 
 * Create Time: 2006-9-20 下午03:24:10
 * 
 * Create Specification:
 * 
 * Modified Time:
 * 
 * Modified by:
 * 
 * Modified Specification:
 * 
 * Version: 1.0
 */

public class XmlParse {

	/**
	 * 属性配置信息
	 */
	private Properties ps;

	/**
	 * 构造方法
	 */
	public XmlParse() {
		defaultProperties();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造方法
	 * 
	 * @param ps
	 */
	public XmlParse(Properties ps) {
		this.ps = ps;
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 进行XML数据的解析
	 * @param xmlString：XML字符串数据源
	 * @param characterSet：XML字符串编码
	 * @param destfields：需要解析的字段数组
	 * @return HashMap集合
	 * @throws Exception
	 */
	public Collection<HashMap> parse(String xmlString, String characterSet, String[] destfields)
			throws Exception {
		Collection<HashMap> sourcedate = new ArrayList<HashMap>();
		
		byte[] b = null;
		if(characterSet == null || "".equalsIgnoreCase(characterSet)){
			b = xmlString.getBytes();
		}
		else{
			b = xmlString.getBytes(characterSet);
		}
		
		final byte[] bom = {(byte)0xEF,(byte)0xBB, (byte)0xBF};
		boolean isBom = false;
		if(b.length > 3){
			isBom = ((b[0] == bom[0]) && (b[1] == bom[1]) && (b[2] == bom[2]));
		}
		
		if(isBom){
			if(characterSet != null && !"".equalsIgnoreCase(characterSet)){
				xmlString = new String(b, 3, b.length -3, characterSet);
			}
		}

		DocumentBuilder db = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		DOMBuilder builder = new DOMBuilder();
		Document doc = builder.build(db.parse(new InputSource(new StringReader(xmlString))));

		Element IDOC = doc.getRootElement().getChild("IDOC");
		Element E1EDK09 = IDOC.getChild("E1EDK09");

		String USR01 = fieldValue(E1EDK09.getChild("USR01"));
		String USR02 = fieldValue(E1EDK09.getChild("USR02"));
		//String USR03 = fieldValue(E1EDK09.getChild("USR03"));
		//String USR04 = fieldValue(E1EDK09.getChild("USR04"));
		String PARTN = fieldValue(E1EDK09.getChild("E1EDKA1").getChild("PARTN"));
		Filter filter = new ElementFilter("E1EDP16");
		Iterator iterator = doc.getDescendants(filter);
		while (iterator.hasNext()) {
			HashMap tempmap = new HashMap();
			Element element = (Element) iterator.next();
			String IDNKD = fieldValue(element.getParentElement().getChild(
					"IDNKD"));
			String KWERK = fieldValue(element.getParentElement().getChild(
					"KWERK"));
			String EDATUV = fieldValue(element.getChild("EDATUV"));
			String WMENG = fieldValue(element.getChild("WMENG"));

			tempmap.put(destfields[0], USR01);
			tempmap.put(destfields[1], USR02);
			// tempmap.put(destfields[2], USR03);
			// tempmap.put(destfields[3], USR04);
			tempmap.put(destfields[2], PARTN);
			tempmap.put(destfields[3], IDNKD);
			tempmap.put(destfields[4], KWERK);
			tempmap.put(destfields[5], EDATUV);
			tempmap.put(destfields[6], WMENG);
			sourcedate.add(tempmap);
		}
		return sourcedate;
	}

	/**
	 * 默认的配置信息
	 */
	private void defaultProperties() {
		Properties defaultPs = new Properties();
		defaultPs.setProperty("USR01", "20");
		defaultPs.setProperty("USR02", "20");
		defaultPs.setProperty("USR03", "8");
		defaultPs.setProperty("USR04", "6");
		defaultPs.setProperty("PARTN", "10");
		defaultPs.setProperty("IDNKD", "18");
		defaultPs.setProperty("KWERK", "4");
		defaultPs.setProperty("EDATUV", "8");
		defaultPs.setProperty("WMENG", "13");
		ps = defaultPs;
	}

	/**
	 * 
	 * 获取属性值
	 * 
	 * @param element
	 * @return
	 * @throws IOException
	 */
	private String fieldValue(Element element) throws IOException {
		StringBuffer value = new StringBuffer(element.getText());
		int k;
		if ((k = Integer.valueOf(ps.getProperty(element.getName())).intValue()
				- value.length()) > 0) {
			for (int i = 0; i < k; i++) {
				value.append(" ");
			}
		}
		return value.toString();
	}


	
}
