package com.aslan.middle;
/*
 * You are given an n x n 2D matrix representing an image.

   Rotate the image by 90 degrees (clockwise).
 * 
 * In-place方法：
 * 
 * 1  2  3        1  4  7     7  4  1
 * 
 * 4  5  6  -->   2  5  8 --> 8  5  2
 * 
 * 7  8  9        3  6  9     9  6  3
 * 
 * 
 * 我的办法，就是空间复杂度高点 很好实现，就不实现了
 * 
 * 先建立一个 n*n的矩阵
 * 1  2  3            1         4  1     7  4  1
 * 
 * 4  5  6   -->      2  -->    5  2 --> 8  5  2
 * 
 * 7  8  9            3         6  3     9  6  3
 * */
public class L_48 {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
        	for(int j=i;j<matrix[0].length;j++){
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = tmp;
        	}
        }
        
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix.length/2;j++){
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[i][matrix.length-1-j];
        		matrix[i][matrix.length-1-j] = tmp;
        	}
        }
    }
}
