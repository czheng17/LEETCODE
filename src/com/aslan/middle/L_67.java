package com.aslan.middle;

public class L_67 {
	public String addBinary(String a , String b){
		if(a==null || b==null){
			return null;
		}
		int a_length = a.length() - 1;
		int b_length = b.length() - 1;
		int jinwei = 0;
		StringBuilder res = new StringBuilder();
		while (a_length>=0 && b_length>=0){
			int temp_a = a.charAt(a_length)=='0'?0:1;
			int temp_b = b.charAt(b_length)=='0'?0:1;
			
			int sum = temp_a + temp_b + jinwei;
			res.append(sum % 2);
			jinwei = sum / 2;
			a_length--;
			b_length--;
		}
		while (a_length>=0){
			int temp_a = a.charAt(a_length)=='0'?0:1;			
			int sum = temp_a + jinwei;
			res.append(sum % 2);
			jinwei = sum / 2;
			a_length--;
		}
		while (b_length>=0){
			int temp_b = b.charAt(b_length)=='0'?0:1;
			int sum = temp_b + jinwei;
			res.append(sum % 2);
			jinwei = sum / 2;
			b_length--;
		}
		if(jinwei>0){
		    System.out.println(jinwei);
		    res.append(1);
		}
		return res.reverse().toString();
	}
}
