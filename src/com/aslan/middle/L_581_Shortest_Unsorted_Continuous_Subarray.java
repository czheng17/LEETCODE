package com.aslan.middle;

import java.util.Arrays;
/*
 * 问题描述：
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
then the whole array will be sorted in ascending order, too.
You need to find the shortest such subarray and output its length.
示例：
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
问题分析：
根据题意，我们可以先把数组升序排序，比较哪些元素变了，左右两边发生变化的元素的位置就是要求的子数组的长度范围。
过程详见代码：
 * */
public class L_581_Shortest_Unsorted_Continuous_Subarray {
	public int findUnsortedSubarray(int[] nums) {
        if(nums==null || nums.length==0){
        	return 0;
        }
        int[] nums1 = new int[nums.length];
        for(int i=0;i<nums.length;i++){
        	nums1[i] = nums[i];
        }
        Arrays.sort(nums);
        int begin=-1;
        int end = -2; //end=-2是因为在[1,2,3,4]情况，什么都不变，最后return end-begin+1正好为0
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=nums1[i]){
        		if(begin==-1){
        			begin=i;
        		}
        		end = i;
        	}
        }
        return end-begin+1;
    }
}
