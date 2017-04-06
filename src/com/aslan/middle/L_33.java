package com.aslan.middle;

public class L_33 {
    public int search(int[] nums, int target) {
        int left=0;
        int right = nums.length-1;
        
        while(left<=right){
        	 int mid = left + (right-left)/2;
        	 if(target == nums[mid]){
        		 return mid;
        	 }
        	 if(nums[left]<=nums[mid]){ //[0 1 2 4 5 6 7]
        		 if(nums[left]<=target&& target<nums[mid]){
        			 right = mid-1;
        		 }
        		 else{
        			 left = mid+1;
        		 }
        	 }
        	 else{ //[4 5 6 7 0 1 2]
        		 if(nums[mid]<target&& target<=nums[right]){
        			 left = mid+1;
        		 }
        		 else{
        			 right = mid-1;	 
        		 }
        	 }
        }
        return -1;
    }
}
