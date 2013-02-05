package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestRquest {
	static URL url = null;
	static HttpURLConnection connection = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("开始....");
        //String urlStr = "http://www.smvic.com.cn/smvic/login/InsertCtn.do";
        String urlStr = "http://127.0.0.1:8080/jeesmvic/login/InsertCtn.do";
        
        String user = "smvic";
        
        String pwd = "aaa111";
        
        String title = "测试新字段";
        
        String htmlcontent = "测试用温";
        
        String channelid = "14";
        
        String author = "kid";
        
        String description = "摘要";
        
        String tag = "标签1,标签2";//逗号分隔
        
        String source = "来源";
        
        try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST"); //设置请求方法为POST, 也可以为GET   
			connection.setDoOutput(true);  
			
			StringBuffer param = new StringBuffer();  //请求URL的查询参数   
			param.append("username=" +  user + "&password=" +pwd + "&title=" + title + "&content=" + htmlcontent + "&channelid=" +channelid + "&author=" + author + "&description="+description+"&source="+source+"&tag=" +tag); 
			
			OutputStream os = connection.getOutputStream();   
			os.write(param.toString().getBytes());   
			os.flush();   
			os.close();   
			
			InputStream is = connection.getInputStream();   
			BufferedReader br = new BufferedReader(new InputStreamReader(is));   
			 
			StringBuilder sb = new StringBuilder();   
			
			while (br.read() != -1) {   
			   sb.append(br.readLine());   
			 }
			
			String content = new String(sb);
			content = new String(content);
			System.out.println(content);
			br.close();

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        System.out.println("结束.....");
        
	}

}
