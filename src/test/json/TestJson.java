package test.json;

import net.sf.json.JSONObject;

public class TestJson {
	public static void main(String[] args) {
		
		String string_json = "[{'0':'','1':'Base-64 字符数组的无效长度。'}]";
		
		string_json = string_json.substring(1, string_json.length()-1);
		
		System.out.println(string_json);
		
		JSONObject jsonObj = JSONObject.fromObject(string_json);
		
		 String x = jsonObj.getString("1");
		
		 
		 System.out.println(x);
		
		
	}
}
