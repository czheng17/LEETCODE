package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * We define a harmonious array is an array where the difference between its maximum value 
 * and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence 
among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * */
public class L_594_Longest_Harmonious_Subsequence {
	public int findLHS(int[] nums) {
        if(nums==null || nums.length==0){
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums){
        	map.put(num, map.getOrDefault(num, 0)+1);
        }
        int res = 0;
        for(int key : map.keySet()){
        	int tmp=0;
        	if(map.containsKey(key+1)){
        		tmp = map.get(key)+map.get(key+1);
                res = Math.max(res, tmp);
        	}
        	
        }
        return res;
    }
}
