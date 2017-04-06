package com.aslan.middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L_279 {
	
	public int numSquares(int n) {
		int[] res = new int[n+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		for(int i=0; i*i<=n;i++){
			res[i*i]=1;
		}
		for(int a=1;a<=n;a++){
			for(int b=1;(a+b*b)<=n;b++){
				res[a+b*b] = Math.min(res[a]+1, res[a+b*b]);
			}
		}
		return res[n];
	}
//	public int numSquares(int n) {
//		Set<Integer> set = new HashSet<Integer>();
//        for(int i=1;i*i<=n;i++){
//        	if(i*i ==n){
//        			return 1;
//        	}else{
//        		set.add(i*i);
//        	}
//        }
//        int res = 0;
//        //int save_num = n;
//    	for(int i=set.size();i>=2;i--){
//    		if(n%(i*i)==0){
//    			return n / (i*i);
//    		}
//    	}
//        while(n!=0){
//        	if(n<4){
//        		//System.out.println(1);
//        		res++;
//        		n--;
//        		continue;
//        	}
//        	for(int i=n;i>=0;i--){
//        		if(set.contains(i)){
//        			//System.out.println(i);
//        			res++;
//        			n = n-i;
//        			break;
//        		}
//        	}
//        }
//        return res;
//    }
//	public static void main(String[] args) {
//		L_279 sol = new L_279();
//		int result = sol.numSquares(11);
//		System.out.println("the result is "+result);
//	}
}
