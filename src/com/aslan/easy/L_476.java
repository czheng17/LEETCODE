package com.aslan.easy;

import java.util.BitSet;

public class L_476 {
    public int findComplement(int num) {
        String bin_num = Integer.toBinaryString(num);
        char[] char_num = bin_num.toCharArray();
        for(int i=0;i<bin_num.length();i++){
        	if(char_num[i] == '1'){
        		char_num[i] = '0';
        	}
        	else{
        		char_num[i] = '1';
        	}
        }
        int res = Integer.parseInt(new String(char_num),2);
        return res;
    }
//    public int findComplement(int num) {
//    	return num ^ (Integer.highestOneBit(num)<<1 - 1);
//    }
//	public static void main(String[] args) {
//		System.out.println(Integer.highestOneBit(9));
//	}
}
