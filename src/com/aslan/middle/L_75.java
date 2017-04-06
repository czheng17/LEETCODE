package com.aslan.middle;

public class L_75 {
	public void sortColors(int[] nums) {
        if(nums==null || nums.length==0){
        	return;
        }
        int red=0;
        int white=0;
        int blue=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		red++;
        		continue;
        	}
        	if(nums[i]==1){
        		white++;
        		continue;
        	}
        	if(nums[i]==2){
        		blue++;
        		continue;
        	}
        }
        
        int i=0;
        while(i<nums.length){
        	if(red>0){
        		red--;
        		nums[i]=0;
            	i++;
        		continue;
        	}
        	if(white>0){
        		white--;
        		nums[i]=1;
            	i++;
        		continue;
        	}
        	if(blue>0){
        		blue--;
        		nums[i]=2;
        		i++;
        		continue;
        	}
        	
        }
    }
}
