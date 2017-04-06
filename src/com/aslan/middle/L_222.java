package com.aslan.middle;

public class L_222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        // 计算leftHeight
        TreeNode p = root;
        while (p != null) {
            p = p.left;
            leftHeight++;
        }
        // 计算rightHeight
        p = root;
        while (p != null) {
            p = p.right;
            rightHeight++;
        }
        // 如果相等，满足2^n-1
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1; //其实是等于 Math.pow(2, height_left) - 1 但是速度快了太多了
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
