package com.aslan.middle;
/*
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", 
 * so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string p. Your job is to find out how many unique non-empty substrings of p 
are present in s. In particular, your input is the string p and you need to output 
the number of different non-empty substrings of p in the string s.

Note: p consists of only lowercase English letters and the size of p might be over 10000.

Example 1:
Input: "a"
Output: 1

Explanation: Only the substring "a" of string "a" is in the string s.
Example 2:
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.   
chen: a and c lose b,so wrong.  c>a wrong. so only a and c
Example 3:
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
chen: z->a a->b z->a->b z a b
 * 
 * 
 * 
 * 
 * */
public class L_467_Unique_Substrings_in_Wraparound_String {
	public int findSubstringInWraproundString(String p) {
        int[] chars = new int[26];
        int sum = 0;
        int max_current = 0;
        if(p.length()==1){
            return 1;
        }
        for(int i=0;i<p.length();i++){
        	if( i>0 && ( (p.charAt(i)-p.charAt(i-1) == 1) || (p.charAt(i-1)-p.charAt(i)==25) ) ){
        		max_current++;
        	}
        	else {
        		max_current=1;
			}
        	int index = p.charAt(i) - 'a';
        	chars[index] = Math.max(max_current, chars[index]);
        }
        for(int i=0;i<chars.length;i++){
        	sum += chars[i];
        }
        return sum;
    }
}
