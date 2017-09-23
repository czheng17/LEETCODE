package com.aslan.middle;
/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

dynamic programming:
BABAB:
    b a b a b
  b T 
  a   T
  b     T
  a       T
  b         T
  
    b a b a b
  b T   T       bab
  a   T   T     aba
  b     T   T   bab
  a       T
  b         T
  
    b a b a b
  b T   T	T   babab
  a   T   T
  b     T   T
  a       T
  b         T
  
cbbd:
  c b b d
c T
b   T
b     T
d       T

  c b b d
c T
b   T T      bb
b     T
d       T

babcbe
  b a b c b e
b T
a   T
b     T
c       T
b         T
e           T

  b a b c b e    bab or bcb
b T   T          bab
a   T   F        abc
b     T   T      bcb
c       T   F    cbe
b         T
e           T

 * 
 * */
import java.security.acl.LastOwnerException;

public class L_5 {
	//dynamic programming method
	public String longestPalindrome(String s){
		int max_len = 1;
		String max_str = s.substring(0,1);
		// build up a 2-D matrix dp array
		boolean[][] dp = new boolean[s.length()][s.length()];
		// a b c the unique string as T
		for(int i=0;i<s.length();i++){
			dp[i][i] = true;
		}
		//aa bb cc the same neigorhood string as T
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				dp[i][i+1] = true;
                max_len = 2;
                max_str = s.substring(i,i+2);
			}
		}
		// aba bab abba babab >2 condition
		for(int len = 3; len<=s.length(); len++){ //len >=3 the sub length from 3 to end
			for(int begin=0;begin<s.length()-len+1;begin++){ //from 0 to the Last begin index
				int end = begin + len -1;
				if(s.charAt(begin)==s.charAt(end) && dp[begin+1][end-1]){
					dp[begin][end] = true;
					if(len>max_len){
						max_len = len;
						max_str = s.substring(begin,end+1);
					}
						
				}
				
			}
		}
		return max_str;
		
	}
//	public String longestPalindrome(String s){
//		if(s.length() == 0 || s == null){
//			return s;
//		}
//		int maxLength = 0;
//		String res = "";
//		
//		//  odd situation
//		for(int i=0; i<s.length();i++){
//			String tmp = this.expand(s,i-1,i+1);
//			if(tmp.length()>maxLength){
//				res = tmp;
//				maxLength = tmp.length();
//			}
//		}
//		
//		//even situation
//		for(int i=0;i<s.length();i++){
//			String tmp = this.expand(s, i, i+1);
//			if(tmp.length()>maxLength){
//				res = tmp;
//				maxLength = tmp.length();
//			}
//		}
//		
//		return res;
//	}
//	private String expand(String s,int left,int right){
////		String res = "";
//		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
//			left--;
//			right++;
//		}
//		return s.substring(left+1,right);
//	}
}
