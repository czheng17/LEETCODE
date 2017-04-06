package com.aslan.middle;

public class L_43 {
	public String multiply(String num1, String num2) {
        if(num1==null || num2==null){
        	return "";
        }
        if(num1.equals("0")&& num2.equals("0")){
            return "0";
        }
        String tmp="";
        if(num2.length()>num1.length()){
            tmp = num1;
            num1 = num2;
            num2 = tmp;
            
        }
        int[] numbers = new int[num1.length()+num2.length()];
        int size = numbers.length-1;
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        for(int i = num2.length()-1; i>=0;i--){
        	for(int j = num1.length()-1;j>=0;j--){
        		//numbers[size -(num2.length()-1-i) ] += Integer.valueOf(n2[j]) * Integer.valueOf(n1[i]);
        		numbers[size -(num2.length()-1-i)-(num1.length()-1-j) ] += (n1[j]-'0') * (n2[i]-'0');
        	}
        }
        int jinwei = 0;
        for(int i=size;i>=0;i--){
            numbers[i] += jinwei;

    		jinwei = numbers[i]/10;
    		numbers[i] %= 10;

        }
        String res = "";
        for(int i=0;i<=size;i++){
        	if(i==0 && numbers[i]==0){
        	    
        	}else{
        		res += numbers[i];
        	}
        }
        int count=0;
        for(int i=0;i<=size;i++){
        	if(numbers[i]==0){
        	    count++;
        	}
        }
        if(count == (size+1)){
            return "0";
        }
        if(res.equals("")){
            return "0";
        }
        return res;
    }
}
