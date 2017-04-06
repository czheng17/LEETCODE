package com.aslan.easy;

public class L_167 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==0){
        	return null;
        }
        int begin=0;
        int end=numbers.length-1;
        while(begin<end){
        	int tmp = numbers[begin] + numbers[end];
        	if(tmp < target){
        		begin++;
        	}
        	else if(tmp > target){
        		end--;
        	}
        	else if( tmp == target){
        		return new int[]{begin+1,end+1};
        	}
        }
        return null;
    }
}
