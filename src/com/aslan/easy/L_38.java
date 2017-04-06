package com.aslan.easy;

public class L_38 {
    public String countAndSay(int n) {
        if(n<=0){
        	return "";
        }
        String final_res = "1";
        
        for(int i=2;i<=n;i++){
        	StringBuilder sb = new StringBuilder();
        	int count =1;
        	for(int j=1;j<final_res.length();j++){
        		if(final_res.charAt(j)==final_res.charAt(j-1)){
        			count++;
        		}
        		else{
        			sb.append(count);
        			sb.append(final_res.charAt(j-1));
        			count=1;
        		}
        	}
        	sb.append(count);
        	sb.append(final_res.charAt(final_res.length()-1));
        	final_res = sb.toString();
        }
        return final_res;
    }
}
