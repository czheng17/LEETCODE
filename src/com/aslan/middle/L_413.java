package com.aslan.middle;

public class L_413 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int cur=0;
        for(int i=2;i<A.length;i++){
        	if(A[i]-A[i-1] == A[i-1] - A[i-2]){
        		cur++;
        		res = res + cur;
        	}
        	else{
        		cur = 0;
        	}
        }
        return res;
    }
}
