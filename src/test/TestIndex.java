package test;

import java.util.ArrayList;
import java.util.List;

public class TestIndex {
	public static void main(String [] args){
		String a = "javascript:showDetailWin('1');";
		
		String b = "javascript:showDetailWin('1');";
		
		System.out.println(b.indexOf(a));
		
		
		List temp = new ArrayList();
		int aa =3;
		System.out.println(temp.contains(aa));
		temp.add(aa);
		System.out.println(temp.contains(aa));
	}
}
