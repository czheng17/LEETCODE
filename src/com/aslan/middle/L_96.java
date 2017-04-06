package com.aslan.middle;

import java.util.HashMap;
import java.util.Map;

public class L_96 {
    public int numTrees(int n) {
    	if(n==0 || n==1){
    		return 1;
    	}
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0, 1);
        map.put(1, 1);
    	for(int i=2;i<=n;i++){
    		int num = 0;
    		for(int j=0;j<i;j++){
//    			System.out.println(map.get(j));
//    			System.out.println(map.get(i-j-1));
    			num += map.get(j) * map.get(i-j-1);
    		}
    		map.put(i, num);
    	}
       
        return map.get(n);
    }
}
