package com.aslan.middle;
/*
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	Note: You can only move either down or right at any point in time.
 * 
 * */
public class L_64 {
    public int minPathSum(int[][] grid) {
    	//明显是一道DP题。。。
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=1;i<row;i++){
        	grid[i][0] += grid[i-1][0];
        }
        
        for(int j=1;j<col;j++){
        	grid[0][j] += grid[0][j-1];
        }
        
        for(int i=1;i<row;i++){
        	for(int j=1;j<col;j++){
        		grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
        	}
        }
        
        return grid[row-1][col-1];
    }
}
