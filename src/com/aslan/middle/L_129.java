package com.aslan.middle;

public class L_129 {
	public int sumNumbers(TreeNode root) {
		int result=0;
		if(root==null){
			return 0;
		}
		result = this.help(root,0);
		return result;
	}
	private int help(TreeNode root,int curr_sum){
	    if(root==null){
	        return 0;
	    }
		int result = curr_sum*10 + root.val;
		if(root.left==null && root.right==null){
			return result;
		}

		return this.help(root.left, result)+this.help(root.right, result);
	}

}
