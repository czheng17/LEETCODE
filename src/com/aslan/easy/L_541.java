package com.aslan.easy;

public class L_541 {
    public String reverseStr(String s, int k) {
    	char[] s_char = s.toCharArray();
    	int i=0;
    	while( i < s.length() ){
    		int j = Math.min(i+k-1, s.length()-1);
    		this.swap(i,j,s_char);
    		i += k*2;
    	}
    	return new String(s_char);
    }
    private void swap(int l, int r, char[] arr) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
