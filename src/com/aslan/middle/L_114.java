package com.aslan.middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L_114 {

    void preorder(TreeNode root,TreeNode prev) {
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // root
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }
        prev = root;
        preorder(left,prev);
        preorder(right,prev);
    }
    public void flatten(TreeNode root) {
        TreeNode prev = null;
        preorder(root,prev);
    }
}
