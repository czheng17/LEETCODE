package com.aslan.easy;

public class L_171 {
	public int titleToNumber(String s) {
        int res = 0;
        int jinwei = 1;
        for(int i = s.length()-1;i>=0;i--){
        	res = res + (s.charAt(i)-'A'+1)*jinwei;
        	jinwei = jinwei*26;
        }
        return res;
    }
}
