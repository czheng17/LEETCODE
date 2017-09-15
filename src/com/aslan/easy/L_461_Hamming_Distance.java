package com.aslan.easy;

public class L_461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
    	int res = 0;
        for(int i=0;i<32;i++){
        	int ones = (x>>i) & 0x01;
        	ones += (y>>i) & 0x01;
        	res += ones * (2-ones);
        }
        return res;
    }
}
