package com.aslan.easy;
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * [1,3,5,6,7,8]
	4
	[2,4]
	2
	OUTPUT:[1,2,3,4,5,6]
	
	[1,3,5,6,7,8]
	4
	[2,4]
	1
	OUTPUT:[1,2,3,5,6,8]
 * 
 * **/
public class L_88 {
	public void merge(int[] A, int m, int[] B, int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while(i>=0 && j>=0){
			if(A[i]>B[j]){
				A[k] = A[i];
				k--;
				i--;
			}
			else{
				A[k] = B[j];
				k--;
				j--;
			}
		}
		while(j>=0){
			A[k] = B[j];
			k--;
			j--;
		}
	}
}
