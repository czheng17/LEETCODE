package com.aslan.easy;

public class L_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;  
        int left = minDepth(root.left); 
        System.out.println("left depth="+left+" ,currect node = "+root.val);
        int right = minDepth(root.right);  
        System.out.println("right depth="+right+" ,currect node = "+root.val);
        if(left == 0 && right ==0) return 1;  
        if(left == 0) left = Integer.MAX_VALUE;  
        if(right == 0) right = Integer.MAX_VALUE;  
        return Math.min(left, right)+1; 
    }
    
    
//    int left =0;
//    int right=0;
//    public int minDepth(TreeNode root) {
//        if(root == null) return 0; 
//        System.out.println("before left depth="+left+" ,currect node = "+root.val);
//        left = minDepth(root.left); 
//        System.out.println("after left depth="+left+" ,currect node = "+root.val);
//        System.out.println("before right depth="+right+" ,currect node = "+root.val);
//        right = minDepth(root.right);  
//        System.out.println("after right depth="+right+" ,currect node = "+root.val);
//        if(left == 0 && right ==0) {
//            System.out.println("left and right all = 0");
//            return 1;
//        }
//        if(left == 0) left = Integer.MAX_VALUE;  
//        if(right == 0) right = Integer.MAX_VALUE;
//        System.out.println("come here: left = "+left+" rgiht= "+right);
//        return Math.min(left, right)+1; 
//    }
}
