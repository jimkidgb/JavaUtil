package test;

import java.util.LinkedList;
import java.util.List;

public class TestArray {
    
	
	public static String[] array_unique(String[] a) {  
		   // array_unique  
		    List<String> list = new LinkedList<String>();  
		    for(int i = 0; i < a.length; i++) {  
		        if(!list.contains(a[i])) {  
		            list.add(a[i]);  
		        }  
		    }  
		    return (String[])list.toArray(new String[list.size()]);  
	}  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String  a = "";
        String  b = "ÉòÑô³§";
        
        
        String finalissue = "";
//		if(dealtc.getIssueto() == null){
//			finalissue = defaultissue;
//		}else{
			finalissue = a + b;
		//}
		String[] depselect = array_unique(finalissue.split(","));
		
		for (int i = 0; i < depselect.length; i++) {
			String dept = depselect[i];
			
		    System.out.println(dept);
		}
	}

}
