package com.aslan.middle;
/*
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * 
 * 
 * */
public class L_34 {
	public int[] searchRange(int[] A, int target) {  
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if(A.length==0 || A[0]>target || A[A.length-1]<target){
			return res;
		}
		int left=0;
		int right = A.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(A[mid]==target){
				res[0] = mid;
				res[1] = mid;
				System.out.println(mid);
				for(int i=mid-1;i>=0;i--){
					if(A[i] == target){
						res[0]--;
					}
					else{
					    break;
					}
				}
				for(int i=mid+1;i<A.length;i++){
					if(A[i] == target){
						res[1]++;
					}
					else{
					    break;
					}
				}
				return res;
			}
			else if(A[mid]<target){
				left = mid+1;
			}
			else{
				right = mid-1;
			}
		}
		return res;
	}
}
