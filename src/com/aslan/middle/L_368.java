package com.aslan.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null){
        	return res;
        }
        Arrays.sort(nums);
        int[] dp_array = new int[nums.length];
        int index = -1;
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
        	int cur = nums[i];
        	int max = 0;
        	boolean isok=false;
        	for(int j=i-1;j>=0;j--){
        		if(cur % nums[j]==0){
        			isok=true;
        			max = Math.max(dp_array[j]+1, max);
        		}
        	}
        	if(isok==true){
        		dp_array[i] = max;
        	}
        	else{
        		dp_array[i] = 1;
        	}
        	if(dp_array[i]>maxCount){
        		maxCount = dp_array[i];
        		index = i;
        	}
        }
        
        int count=0;
        for(int i=index; i>=0 && count<maxCount;i--){
        	if(nums[index] % nums[i] == 0){
        		res.add(nums[i]);
        		count++;
        	}
        }
        return res;
    }
}
