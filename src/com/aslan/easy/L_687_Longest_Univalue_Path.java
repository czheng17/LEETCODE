package com.aslan.easy;

import java.text.DateFormatSymbols;

/*
 * Given a binary tree, find the length of the longest path where each node 
 * in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2

思路： 
此题的trick在于如何划分子问题，首先对于原问题的划分如下：

如果最长path经过根节点，则计算出来
否则，分别从左子树和右子树中找出最长路径（不经过根节点）
接下来，只需要计算从某个根结点出发，分别链接左子树的最大路径长度和右子树的最大路径长度。

此处的原问题划分如下：

计算左子树的最大长度
计算右子树的最大长度
如果左右子树根节点的val和它们的父结点val相同，则取其中长度最大的。

 * 
 * */
public class L_687_Longest_Univalue_Path {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int res = 0;
        if(root.left!=null && root.left.val == root.val){
        	res = res + 1 + this.dfs(root.left);
        }
        if(root.right!=null && root.right.val == root.val){
        	res = res + 1 + this.dfs(root.right);
        }
        return Math.max(res, Math.max(this.longestUnivaluePath(root.left), this.longestUnivaluePath(root.right)));
    }
    
    private int dfs(TreeNode root){
    	if(root==null){
    		return 0;
    	}
    	int left = 0;
    	int right = 0;
    	if(root.left!=null && root.left.val == root.val){
        	left =  1 + this.dfs(root.left);
        }
        if(root.right!=null && root.right.val == root.val){
        	right =  1 + this.dfs(root.right);
        }
        return Math.max(left,right);
    }
}
