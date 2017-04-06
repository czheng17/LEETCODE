package com.aslan.easy;

public class L_345 {
    public String reverseVowels(String s) {
    	char[] s_char = s.toCharArray();
        int i = 0;
        int j = s_char.length-1;
        while(i<j){
        	while(i<j && !this.isVowel(s_char[i])){
        		i++;
        	}
        	while(i<j && !this.isVowel(s_char[j])){
        		j--;
        	}
        	char tmp = s_char[i];
        	s_char[i] = s_char[j];
        	s_char[j] = tmp;
        	i++;
        	j--;
        }
        return new String(s_char);
    }
    private boolean isVowel(char c){
    	c = Character.toLowerCase(c);
    	if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ){
    		return true;
    	}
    	return false;
    }
}
