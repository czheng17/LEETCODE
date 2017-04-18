package com.aslan.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs
 *  in the array. Here a k-diff pair is defined as an integer pair (i, j), 
 *  where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
 * 
 * 
 * **/
public class L_532 {
	public int findPairs(int[] nums, int k) {
		int res=0;

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		if(k==0){
			for(int i:nums){
				if(!set1.contains(i)){
					set1.add(i);
				}
				else{
					set1.remove(i);
					if(!set2.contains(i)){
						res++;
					}
					set2.add(i);
				}
			}
		}
		else if(k>0){
			for(int i:nums){
				set1.add(i);
				set2.add(i+k);
			}
			set1.retainAll(set2);
			return set1.size();
		}
		return res;
	}
	
//    public int findPairs(int[] nums, int k) {
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//        	set.add(nums[i]);
//        }
//        int res=0;
//        for(int i :set){
//        	if(set.contains(Math.abs(k-i))){
//        		System.out.println(i+"   "+(k-i));
//        		res++;
//        	}
//        }
//        return res%2==0? res/2 : res/2+1;
//    }
}
