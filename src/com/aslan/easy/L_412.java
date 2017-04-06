package com.aslan.easy;

import java.util.ArrayList;
import java.util.List;

public class L_412 {
    public List<String> fizzBuzz(int n) {
    	List<String> res = new ArrayList<String>();
    	if(n<1){
    		return res;
    	}
    	int i = 1;
        while(i<=n){
        	if(i%3==0 && i%5==0){
        		res.add("FizzBuzz");
        	}
        	else if(i%3==0){
        		res.add("Fizz");
        	}
        	else if(i%5==0){
        		res.add("Buzz");
        	}
        	else{
        		res.add(i+"");
        	}
        	i++;
        }
        return res;
    }
}
