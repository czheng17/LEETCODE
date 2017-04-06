package com.aslan.middle;

import java.util.Map;
import java.util.TreeMap;

/*
 * Example 1:
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
Example 2:
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
Example 3:
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
 * 
 * 
 * 
 * */
public class L_436 {
	public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i].start, i);    
        }
        for (int i = 0; i < intervals.length; ++i) {
            //使用treemap返回至少大于等于的给定值，也就是至少大于等于等于intervals[i].end的值
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
	
	
	
	//理解错题目意思
//    public int[] findRightInterval(Interval[] intervals) {
//        int[] res = new int[intervals.length];
//        if(intervals.length==0){
//        	return res;
//        }
//        
//        res[0] = -1;
//        for(int i=1;i<intervals.length;i++){
//        	if(intervals[i].start<intervals[i-1].end){
//        		res[i] = intervals[i].end - intervals[i-1].start;
//        	}
//        	else{
//        		res[i] = -1;
//        	}
//        }
//        return res;
//        
//    }
}
