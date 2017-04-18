package com.aslan.easy;

import java.util.ArrayList;
import java.util.List;
/**
 * 119. Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 * 
 * 
 * **/
public class L_119 {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<rowIndex+1;i++){
			res.add(1);
			for(int j=i-1;j>0;j--){
				res.set(j, res.get(j-1)+res.get(j));
			}
		}
		return res;
	}
}
