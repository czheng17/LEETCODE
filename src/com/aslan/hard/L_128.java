package com.aslan.hard;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class L_128 {
	public int longestConsecutive(int[] nums) {
		Set<Integer> sets = new HashSet<Integer>();
		for(int i =0; i<nums.length;i++){
			sets.add(nums[i]);
		}
		int max = 0;
		int count;
		for(int i = 0;i<nums.length;i++){
			count = 0;
			int middle_left = nums[i]-1;
			int middle_right = nums[i];
			while(sets.contains(middle_left)){
				count++;
				sets.remove(middle_left);
				middle_left--;
				
			}
			while(sets.contains(middle_right)){
				count++;
				sets.remove(middle_right);
				middle_right++;
				
			}
			if(max < count){
				max = count;
			}
		}
		return max;
	}
}
