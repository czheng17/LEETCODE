package com.aslan.easy;

public class L_344 {
    public String reverseString(String s) {
        int half_len = s.length()/2;
        char[] s_char = s.toCharArray();
        for(int i=0;i<half_len;i++){
        	char tmp = s_char[i];
        	s_char[i] =s_char[s.length()-i-1];
        	s_char[s.length()-i-1]= tmp;
        }
        return new String(s_char);
    }
}
