package com.aslan.middle;

import java.util.HashMap;
import java.util.Map;

/*
 * Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should 
return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should 
return "1A1B".
 * 
 * */
public class L_299 {
    public String getHint(String secret, String guess) {
        if(secret==null || guess==null || secret.length() != guess.length()){
        	return "";
        }
        int A=0;
        int B=0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        
        //bull part
        for(int i=0; i<s.length;i++){
        	if(s[i]==g[i]){
        		A++;
        		s[i] = '#';
        		g[i] = '#';
        	}
        }
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        //cow secret part
        for(int i=0;i<s.length;i++){
        	if(s[i]!='#'){
        		if(!map.containsKey(s[i])){
        			map.put(s[i], 1);
        		}else{
        			map.put(s[i],map.get(s[i])+1);
        		}
        	}
        }
        
        //cow guess part
        for(int i=0;i<g.length;i++){
        	if(g[i]!='#'){
        		if(map.containsKey(g[i]) && map.get(g[i])>0){
        			B++;
        			map.put(g[i], map.get(g[i])-1);
        		}
        	}
        }
        return A+"A"+B+"B";
    }
}
