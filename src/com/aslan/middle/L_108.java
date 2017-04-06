package com.aslan.middle;

public class L_108 {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
        	return null;
        }
        return this.buildupBST(0,nums.length,nums);
    }
	private TreeNode buildupBST(int start,int end,int[] nums){
		if(start>=end){
			return null;
		}
		int middle = (start+end)/2;
		TreeNode root = new TreeNode(nums[middle]);
		root.left = this.buildupBST(start, middle, nums);
		root.right = this.buildupBST(middle+1, end, nums);
		
		return root;
	}
}
