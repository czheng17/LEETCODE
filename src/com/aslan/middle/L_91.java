package com.aslan.middle;

public class L_91 {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
            return 0;
        }
        
		char[] each_word = s.toCharArray();
		if(each_word.length==1&& each_word[0]!='0'){
		    return 1;
		}
		if(each_word[0]=='0'){
		    return 0;
		}
		for(int i=0;i<each_word.length-1;i++){
        	if(each_word[i]=='0' && each_word[i+1]=='0'){
        		return 0;
        	}
        }
        int[] table=new int[Math.max(each_word.length + 1, 3)];
        for(int i=0;i<table.length;i++){
        	table[i] = 0;
        }
        table[0] = 1;
        table[1] = 0;
        
        if(each_word[0] != '0'){
        	table[1]=1;
        }
        
        for(int i = 2 ; i<table.length ; i++ ){
            table[i] = 0;
        	if(each_word[i-1] != '0'){
        		table[i] += table[i-1];
        	}
        	if(each_word[i-2] != '0'){
        		if(((each_word[i-2] - '0')*10 + (each_word[i-1]-'0'))<=26){
        			table[i] += table[i-2];
        		}
        	}

        }
       
        return table[table.length-1];
        
    }
	public static void main(String[] args) {
		L_91 sol = new L_91();
		int res = sol.numDecodings("101");
		//System.out.println(res);
	}
}
