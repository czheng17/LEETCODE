package com.aslan.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * */
public class L_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
        	if(nums1[i]==nums2[j]){
            	set.add(nums1[i]);
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
        int[] res = new int[set.size()];
        int k=0;
        for(int tmp:set){
        	res[k++] = tmp;
        }
        return res;
    }
}
