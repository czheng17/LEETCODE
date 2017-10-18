package com.aslan.easy;
/*
 * Given a binary search tree and the lowest and highest boundaries as L and R, 
 * trim the tree so that all its elements lies in [L, R] (R >= L). 
 * You might need to change the root of the tree, 
 * so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
Example 2:
Input: 
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output: 
      3
     / 
   2   
  /
 1
 
 给定二叉搜索树，将最低和最高边界作为L和R，修剪树，使其所有元素位于[L，R]（R> = L）中。
 您可能需要更改树的根，所以结果应该返回修剪的二叉搜索树的新根。
 * 
 * */
public class L_669_Trim_a_Binary_Search_Tree {
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null){
            return root;
        }
        if(root.val < L){
            return this.trimBST(root.right,L,R);
        }
        if(root.val > R){
            return this.trimBST(root.left,L,R);
        }
        root.left = this.trimBST(root.left,L,R);
        root.right = this.trimBST(root.right,L,R);
        return root;
    }
}
