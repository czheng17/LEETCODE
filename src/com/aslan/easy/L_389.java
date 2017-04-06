package com.aslan.easy;

public class L_389 {
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char res = t.charAt(n-1);
        for(int i=0;i<n-1;i++){
        	res = (char) (res ^ s.charAt(i));
        	res = (char) (res ^ t.charAt(i));
        }
        return res;
    }

}
