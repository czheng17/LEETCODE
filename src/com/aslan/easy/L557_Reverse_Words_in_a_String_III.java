package com.aslan.easy;
/*
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
 * */
public class L557_Reverse_Words_in_a_String_III {
	public String reverseWords(String s) {
		if(s==null || s.length()==0){
			return s;
		}
		String res=new String();
        String[] words = s.split(" ");
        boolean is_first=true;
        for(int i=0;i<words.length;i++){
        	StringBuilder sb = new StringBuilder(words[i]);
        	String reverse_sb = sb.reverse().toString();
        	if(is_first==true){
        		res = reverse_sb;
        		is_first=false;
        	}
        	else{
        		res += " "+reverse_sb;
        	}
        }
        return res;
    }
}
