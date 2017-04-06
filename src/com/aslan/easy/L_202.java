package com.aslan.easy;

import java.util.HashSet;
import java.util.Set;

public class L_202 {
	public boolean isHappy(int n) {
        if(n<1){
        	return false;
        }
        if(n==1){
        	return true;
        }
        Set<Integer> set  = new HashSet<Integer>() ;
        set.add(n);
        int count=0;
        while(true){
        	while(n>0){
        		count+= (n % 10) * (n % 10);
        		n = n/10;
        	}
        	if(count == 1){
        		return true;
        	}
        	if(set.contains(count)){
        		return false;
        	}else{
        		set.add(count);
        	}
        	n = count;
        	count = 0;
        }
    }
}
