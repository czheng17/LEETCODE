package com.aslan.easy;

public class L_504 {
    public String convertToBase7(int num) {
    	StringBuilder str = new StringBuilder();
        if(num==0){
        	return "0";
        }else if(num>0){
        	str.append(this.convert7(num));
        }else{
        	str.append("-");
        	num = -num;
        	str.append(this.convert7(num));
        }
        return str.toString();
    }
    private StringBuilder convert7(int num){
    	StringBuilder sb = new StringBuilder();
    	while(num>0){
    		sb.insert(0,num%7);
    		num /= 7;
    	}
    	return sb;
    }
}
