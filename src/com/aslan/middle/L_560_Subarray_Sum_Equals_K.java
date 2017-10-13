package com.aslan.middle;

import java.util.HashMap;
import java.util.Map;


/*
 * Given an array of integers and an integer k, you need to find the total number of 
 * continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


solution:
[1,2,3,2,-2] k=5  answer:3 2+3, 3+2, 2+3+2-2 --> total 3

0 -> 1
sum
1 -> 1
3 -> 1
6 -> 1   6-5=1
8 -> 1   8-5=3
6 -> 2   6-5=1

example 2:
[1,2,3,2,-2,2] k=2  answer:4 2, 2, 2-2+2, 2 --> total 3

0 -> 1
sum
1 -> 1
3 -> 1   3-2=1  res = 0+1 = 1
6 -> 1   
8 -> 1   8-2=6  res = 1+1 = 2
6 -> 2 
8 -> 2   8-2=6  res = 2+2 = 4


 * 
 * */
public class L_560_Subarray_Sum_Equals_K {
	public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
        	sum = sum + nums[i];
        	if(map.containsKey(sum-k)){
        		res = res + map.get(sum-k);
        	}
        	map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }

}
