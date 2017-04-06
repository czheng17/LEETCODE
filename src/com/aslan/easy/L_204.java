package com.aslan.easy;

import java.util.Arrays;

public class L_204 {
	public int countPrimes(int n) {
	    if(n<2){
	        return 0;
	    }
		int res=0;
		boolean[] prime = new boolean[n];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for(int i=2;i*i <= n;i++){
			if(prime[i] == true){
				int tmp = i*i;
				while(tmp<n){
					prime[tmp] = false;
					tmp = tmp+i;
				}
			}
		}
		for(int i=2;i<n;i++){
			if(prime[i]==true){
			    //System.out.print(i+"");
				res++;
			}
		}
		return res;
	}
//	public int countPrimes(int n) {
//        int count = 0;
//        for(int i=0;i<n;i++){
//        	if(this.isPrime(i)){
//        		count++;
//        	}
//        }
//        return count;
//    }
//	private boolean isPrime(int x){
//		if(x<=1){
//			return false;
//		}
//		for(int i=2; i*i<=x;i++){
//			if(x % i ==0){
//				return false;
//			}
//		}
//		return true;
//	}
}
