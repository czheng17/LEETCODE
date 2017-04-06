package com.aslan.middle;

public class L_3 {
	public int lengthOfLongestSubstring(String s) {
		if(s==null){
			return 0;
		}
		if(s.length()==0 || s.length()==1){
			return s.length();
		}
		
		int carrier = 0;
		int maxLen = 0;
		char[] s_char = s.toCharArray();
		for(int i=0;i<s.length();i++){
			for(int j=i-1;j>=carrier;j--){
				if(s_char[i] == s_char[j]){
					carrier = j+1;
					break;
				}
			}
			maxLen = Math.max(maxLen,i-carrier+1);
		}
		return maxLen;
	}
}
