package com.aslan.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L_503 {
    public int[] nextGreaterElements(int[] nums) {
    	if(nums==null || nums.length==0){
    		return nums;
    	}
    	
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for(int i=0;i<nums.length*2;i++){
        	int tmp = nums[i%nums.length];
        	while(!stack.isEmpty() && nums[stack.peek()]<tmp){
        		int pop = stack.pop();
        		res[pop] = tmp;
        	}
        	stack.push(i%nums.length);
        }
        for(int i=0;i<nums.length;i++){
        	nums[i] = res[i];
        }
        return nums;
    }
}
