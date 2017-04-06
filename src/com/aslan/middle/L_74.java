package com.aslan.middle;

public class L_74 {
	public boolean searchMatrix(int[][] matrix, int target) {  
		if(matrix==null || matrix.length==0 || matrix[0].length==0){
			return false;
		}
		int left=0;
		int right = matrix.length-1;
		//定位在哪一行
		while(left<=right){
			int middle = (left+right)/2;
			if(matrix[middle][0] == target){
				return true;
			}
		    if(matrix[middle][0] > target){
				right = middle-1;
			}
			else{
				left = middle+1;
			}
		}
		int row = right;
		
		if(row<0){
			return false;
		}
		left=0;
		right = matrix[0].length-1;
		//定位完哪行之后，直接对该行进行二分查找
		while(left<=right){
			int middle = (left+right)/2;
			if(matrix[row][middle] == target){
				return true;
			}
			if(matrix[row][middle] > target){
				right = middle-1;
			}
			else{
				left = middle+1;
			}
		}
		return false;
		
		
		
	}
}
