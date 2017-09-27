package com.aslan.middle;
/*
 * Given two words word1 and word2, find the minimum number of steps 
 * required to make word1 and word2 the same, where in each step you can 
 * delete one character in either string.

Example 1:

Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 

Note:

The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
 

这道题给了我们两个单词，问我们最少需要多少步可以让两个单词相等，每一步我们可以在任意一个单词中删掉一个字符。
那么我们分析怎么能让步数最少呢，是不是知道两个单词最长的相同子序列的长度，并乘以2，被两个单词的长度之和减，
就是最少步数了。其实这道题就转换成求Longest Common Subsequence最长相同子序列的问题，令博主意外的是，
LeetCode中竟然没有这道题，这与包含万物的LeetCode的作风不符啊。不过没事，有这道题也行啊，对于这种玩字符串，
并且是求极值的问题，十有八九都是用dp来解的，曾经有网友问博主，如何确定什么时候用greedy，什么时候用dp？
其实博主也不不太清楚，感觉dp要更tricky一些，而且出现的概率大，所以博主一般会先考虑dp，如果实在想不出递推公式，
那么就想想greedy能做不。如果有大神知道更好的区分方法，请一定留言告知博主啊，多谢！那么决定了用dp来做，
就定义一个二维的dp数组，其中dp[i][j]表示word1的前i个字符和word2的前j个字符组成的两个单词，能使其变相同的最小的步数。
下面来看递推式dp[i][j]怎么求，首先来考虑dp[i][j]和dp[i-1][j-1]之间的关系，我们可以发现，
如果当前的两个字符相等，那么dp[i][j] = dp[i-1][j-1] + 1，这不难理解吧，因为最长相同子序列又多了一个相同的字符，
所以长度加1。由于我们dp数组的大小定义的是(n1+1) x (n2+1)，所以我们比较的是word1[i-1]和word2[j-1]。
那么我们想如果这两个字符不相等呢，难道我们直接将dp[i-1][j-1]赋值给dp[i][j]吗，当然不是，我们还要错位相比嘛，
比如就拿题目中的例子来说，"sea"和"eat"，当我们比较第一个字符，发现's'和'e'不相等，下一步就要错位比较啊，
比较sea中第一个's'和eat中的'a'，sea中的'e'跟eat中的第一个'e'相比，这样我们的dp[i][j]就要取dp[i-1][j]跟dp[i][j-1]中
的较大值了，最后我们求出了最大共同子序列的长度，就能直接算出最小步数了，
 * 
 * */
public class L_583_Delete_Operation_for_Two_Strings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];       
        for(int i=1;i<=word1.length();i++){
        	for(int j=1;j<=word2.length();j++){
        		if(word1.charAt(i-1)==word2.charAt(j-1)){
        			dp[i][j] = dp[i-1][j-1] +1;
        		}
        		else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
        	}
        }
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
}
