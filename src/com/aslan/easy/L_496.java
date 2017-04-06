package com.aslan.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 对于nums中的每一个元素，找到next greater element并对应放到HashMap<Integer, Integer> hm 中.

	如何一遍找到呢，通过Stack<Integer> stk, 新的元素num会把stk顶部比num小的全部pop出去, 
	
	并且num就是pop出去的next greater element, 存到hm中.

	stk便成了从顶向下增大的栈. 最后利用hm把findNums的每个元素对应的next greater element找出来.

	Aslan解释：
	Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
	Output: [-1,3,-1]
	-1：nums1的数4在nums2的第3个位置出现，第3个位置后没有比4大的数，返回-1
	3： nums1的数1在nums2的第1个位置出现，第1个位置后有比1大的数，返回第一个比1大的数3
	-1：nums1的数2在nums2的第4个位置出现，第4个位置后有比2大的数，返回-1
 * 
 * 
 * */
public class L_496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
    	Stack<Integer> stack = new Stack<Integer>();
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int i=0;i<nums.length;i++){
    		while(!stack.isEmpty() && nums[i]>stack.peek()){
    			int pop_num = stack.pop();
    			map.put(pop_num, nums[i]);
    		}
    		stack.push(nums[i]);
    	}
    	
    	for(int i=0;i<findNums.length;i++){
    		findNums[i] = map.getOrDefault(findNums[i], -1);
    	}
    	return findNums;
    }
}
