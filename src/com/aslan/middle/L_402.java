package com.aslan.middle;

public class L_402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] stack = new char[n];
        int count=0;
        for(int i =0;i<n;i++){
        	while( count!=0 && k>0 && num.charAt(i)<stack[count-1]){
        		count--;
        		k--;
        	}
        	stack[count] = num.charAt(i);
        	count++;
        }
        int start = 0;
        while(start < count && stack[start] == '0') start++;
        return start >= count - k ? "0" : new String(stack, start, count - start - k);
    }
}
