package com.aslan.easy;

public class L_67 {
	public String addBinary(String a,String b){
		if(a==null || b==null){
			return null;
		}
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		
		int carry = 0;
		while(i>=0 && j>=0){
			int av = (a.charAt(i)=='0') ? 0 : 1;
			int bv = (b.charAt(j)=='0') ? 0 : 1;
			int v = av + bv + carry;
			sb.append(v%2);
			carry = v/2;
			i--;
			j--;
		}
		while(i>=0){
			int av = (a.charAt(i)=='0') ? 0 : 1;
			int v = av + carry;
			sb.append(v%2);
			carry = v / 2;
			i--;
		}
		while(j>=0){
			int bv = (b.charAt(j)=='0') ? 0 : 1;
			int v = bv + carry;
			sb.append(v%2);
			carry = v / 2;
			j--;
		}
		if(carry == 1){
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}
