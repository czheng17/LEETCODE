package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;


/*
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as 
 * the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
给定非空非负整数数组，数组的度是指元素的最大出现次数。

寻找最大连续区间，使得区间的度与原数组的度相同。
 * 
 * */

public class L_697_Degree_of_an_Array {
	public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,Integer> begin = new HashMap<>();
        Map<Integer,Integer> end = new HashMap<>();
        int max = Integer.MIN_VALUE;  //找到数组中出现某个数字出现次数最大的值
        int min = Integer.MAX_VALUE;  //找到出现某个数字出现次数最大的值的最短自区间
        for(int i=0;i<nums.length;i++){
            if(!begin.containsKey(nums[i])){
                count.put(nums[i],0);
                begin.put(nums[i],i);
            }
            count.put(nums[i],count.get(nums[i])+1);
            end.put(nums[i],i);
            max = Math.max(count.get(nums[i]),max);
        }
        
        for(Integer key : count.keySet()){
            if(count.get(key)==max){
                min = Math.min(  end.get(key)-begin.get(key)+1 , min  );
            }
        }
        return min;
    }
}
