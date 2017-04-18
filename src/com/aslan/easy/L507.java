package com.aslan.easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class L_507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i){
                   sum += num / i;
                }
            }
        }
        sum++;
        
        return sum == num;
    }
//	public boolean checkPerfectNumber(int num) {
//		Set<Integer> set = new HashSet<>();
//		for(int i=1;i<=num;i++){
//			if(num % i == 0){
//				set.add(i);
//			}
//		}
//		Object[] arr = set.toArray();
//		int[] arr1 = new int[arr.length];
//		for(int i=0;i<arr.length;i++){
//			arr1[i] = (int) arr[i];
//		}
//		Arrays.sort(arr1);
//		boolean res = this.recur(0,0,num,arr1);
//		return res;
//    }
//	
//	private boolean recur(int index,int sum,int num,int[] arr){
//		if(sum==num){
//			return true;
//		}
//		for(int i=index;i<arr.length;i++){
//			sum = sum + arr[i];
//			this.recur(i+1, sum, num, arr);
//			sum = sum - arr[i];
//			
//		}
//		return false;
//	}
}
