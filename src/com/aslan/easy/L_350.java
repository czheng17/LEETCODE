package com.aslan.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
        	if(nums1[i]==nums2[j]){
            	list.add(nums1[i]);
        		i++;
        		j++;
        	}
        	else if(nums1[i]>nums2[j]){
        		j++;
        	}
        	else{
        		i++;
        	}
        }
        int[] res = new int[list.size()];
        int k=0;
        for(int tmp:list){
        	res[k++] = tmp;
        }
        return res;
    }
}
