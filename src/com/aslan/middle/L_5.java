package com.aslan.middle;

public class L_5 {
	public String longestPalindrome(String s){
		if(s.length() == 0 || s == null){
			return s;
		}
		int maxLength = 0;
		String res = "";
		
		//  odd situation
		for(int i=0; i<s.length();i++){
			String tmp = this.expand(s,i-1,i+1);
			if(tmp.length()>maxLength){
				res = tmp;
				maxLength = tmp.length();
			}
		}
		
		//even situation
		for(int i=0;i<s.length();i++){
			String tmp = this.expand(s, i, i+1);
			if(tmp.length()>maxLength){
				res = tmp;
				maxLength = tmp.length();
			}
		}
		
		return res;
	}
	private String expand(String s,int left,int right){
//		String res = "";
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		return s.substring(left+1,right);
	}
}
