package com.aslan.middle;

import java.util.Arrays;

/*
 * Given a string s, find the longest palindromic subsequence's length in s. 
 * You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2

经典的动态规划的问题。假设dp[i][j] 是子串i-j之间的Longest Palindromic Subsequence。那么我们可以得到动态规划的公式：
如果 s.charAt(i) == s.charAt(j) ，说明i+1至j-1之间加上i和j形成新的
 Palindromic。

    dp[i][j] = dp[i + 1][j - 1] + 2;

  否则 dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])
 * */
public class L_516_Longest_Palindromic_Subsequence {
	public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for(int i=s.length()-1;i>=0;i--){
			dp[i][i]=1;
			for(int j=i+1; j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}
				else{
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		return dp[0][s.length()-1];
	}
	
	// 我的方法是错的
//    public int longestPalindromeSubseq(String s) {
//        int[] dp =new int[s.length()];
//        for(int i=1;i<s.length();i++){
//        	int cur_max_len = 0;
//        	for(int j=0; j<i; j++){
//        		if(s.charAt(j) == s.charAt(i)){
//        			String sub_str = s.substring(j,i+1);
//        			if(this.isPalindromic(sub_str)){
//        				cur_max_len = Math.max(cur_max_len, sub_str.length());
//        			}
//        		}
//        	}
//        	dp[i] = cur_max_len;
//        }
//        Arrays.sort(dp);
//        return dp[dp.length-1];
//    }
//    private boolean isPalindromic(String s){
//    	for(int i=0;i<s.length()/2;i++){
//    		if(s.charAt(i)!=s.charAt(s.length()-1-i)){
//    			return false;
//    		}
//    	}
//    	return true;
//    }
}
