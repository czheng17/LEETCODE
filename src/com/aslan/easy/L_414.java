package com.aslan.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class L_414 {
//	  public int thirdMax(int[] nums) {
//		  if(nums==null || nums.length==0){
//		  	return 0;
//		  }
//		  Arrays.sort(nums);
//		  Queue<Integer> queue = new PriorityQueue<Integer>();
//		  Set<Integer> set = new 
//	  }
    public int thirdMax(int[] nums) {
        if(nums==null || nums.length==0){
        	return 0;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!set.contains(nums[i])){
        		list.add(nums[i]);
        		set.add(nums[i]);
        	}
        	if(list.size()>3){
        		list.remove(list.get(0));
        	}
        }
        if(list.size()==3){
        	return list.get(0);
        }
        else{
        	return list.get(list.size()-1);
        }
        
    }
}
