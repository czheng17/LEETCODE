package com.aslan.easy;

public class L_70 {
    public int climbStairs(int n) {
        if(n == 0){
        	return 1;
        }
        if(n == 1 || n == 2){
        	return n;
        }
        //不用制表，赋初值
        int step1 = 1;
        int step2 = 2;
        int step3 = 0;
        for(int i=3;i<=n;i++){
        	step3 = step1+step2;
        	step1 = step2;
        	step2 = step3;
        }
        return step3;
    }
}
