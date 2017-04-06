package com.aslan.easy;

public class L_110 {
	boolean result = true;
	public boolean isBalanced(TreeNode root) {
		int tmp = this.maxDepth(root);
        return result;
    }
	private int maxDepth(TreeNode root){
	    if (root == null)
            return 0;
		int left = this.maxDepth(root.left);
		int right = this.maxDepth(root.right);
		if(left-right>1 || right-left>1){
			result = false;
			return 0;
		}
		return Math.max(left, right)+1;
	}
}
