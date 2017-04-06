package com.aslan.easy;

public class L_104 {
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return (root.left != null && hasPathSum(root.left, sum - root.val))
                || (root.right != null && hasPathSum(root.right, sum- root.val));
    }
}
