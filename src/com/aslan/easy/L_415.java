package com.aslan.easy;

public class L_415 {
    public String addStrings(String num1, String num2) {
        if(num1==null && num2==null){
        	return "";
        }
        if(num1.length()==0 && num2.length()!=0){
        	return num2;
        }
        if(num2.length()==0 && num1.length()!=0){
        	return num1;
        }
        String longer = num1.length() >= num2.length()? num1:num2 ;
        String shorter = num1.length() < num2.length()? num1:num2 ;
        char[] n1 = longer.toCharArray();
        char[] n2 = shorter.toCharArray();
        int n1_size = n1.length;
        int n2_size = n2.length;
        StringBuilder sb = new StringBuilder();
        int jinwei=0;
        while(n2_size>0){
        	n1_size--;
        	n2_size--;
        	int tmp = n1[n1_size]- '0' +n2[n2_size] - '0' + jinwei;
        	jinwei = tmp/10;
        	sb.append(tmp%10);
        }
        while(n1_size>0){
        	n1_size--;
        	int tmp = n1[n1_size]- '0' + jinwei;
        	jinwei = tmp/10;
        	sb.append(tmp%10);
        }
        if(jinwei!=0){
        	sb.append(jinwei);
        }
        return sb.reverse().toString();
    }
}
