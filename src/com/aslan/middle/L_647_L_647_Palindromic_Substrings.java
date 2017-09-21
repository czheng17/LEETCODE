package com.aslan.middle;
/*
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings 
even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

求字符串的回文子串个数。假定子串内容相同但index不同认定为不同得子串。
比如：在”aaa”中，共有 “a”, “a”, “a”, “aa”, “aa”, “aaa”六个回文子串，
前三个回文 “a”, “a”, “a”就是内容相同但是index分别为0,1,2，所以为不同的子串。 

很明显这是一道dp的题，从左到右遍历字符串，每次加进一个字符，递推公式为dp[i]=dp[i-1]+tmpNum。
其中，tmpNum为新加进一个字符后新增加的回文子串的个数。当遍历到index=i时，
只要看看在i之前的index j，能否构成substring(j,i+1)的回文子串。
最后结果是dp[len-1]+len，其中len为字符串的长度，因为字符串每个字符都为回文子串。
 * */
public class L_647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        for(int i=1;i<s.length();i++){
        	int tmpsum = 0;
        	for(int j=0;j<i;j++){
        		if(s.charAt(j)==s.charAt(i)){
        			String sub_str = s.substring(j,i+1);
        			if(this.isPalindromic(sub_str)){
        				tmpsum++;
        			}
        		}
        	}
        	dp[i] = dp[i-1] + tmpsum;
        }
        return dp[dp.length-1] + s.length();
    }
    private boolean isPalindromic(String s){
    	for(int i=0;i<s.length()/2;i++){
    		if(s.charAt(i) != s.charAt(s.length()-1 -i)){
    			return false;
    		}
    	}
    	return true;
    }
}
