import java.util.Arrays;
/*
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
 * */
public class L_628_Maximum_Product_of_Three_Numbers {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		//有一种情况：[-4,-3,-2,-1,60]
		return Math.max(nums[len-1]*nums[len-2]*nums[len-3], nums[0]*nums[1]*nums[len-1]);
	}
}
