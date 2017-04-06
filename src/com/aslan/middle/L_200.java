package com.aslan.middle;

public class L_200 {
	/*
	 * 1 1 1 1 0
	 * 1 1 0 1 0
	 * 1 1 0 0 0
	 * 0 0 0 0 0   answer 1
	 * 
	 * */
	public final int[] xDir = {-1, 0, 1, 0};
	public final int[] yDir = {0, -1, 0, 1};
	
	
	public int numIslands(char[][] grid){
		int result = 0;
		
		if(grid == null || grid.length==0 || grid[0].length == 0){
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		boolean[][] visited =new boolean[row][col];
		
		for(int i=0; i<row ; i++){
			for(int j=0; j<col; j++){
				if(grid[i][j] =='0' || visited[i][j]==true){
					continue;
				}
				this.explore(i,j,row,col,grid,visited);
				result++;
			}
		}
		
		return result;
	}
	
	private void explore(int x,int y, int row, int col, char[][] grid, boolean[][] visited){
		if(!shouldexplore(x,y,row,col,grid,visited)){
			return;
		}
		visited[x][y] = true;
		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < 4; j++){
//				this.explore(x+xDir[i], y+yDir[j], row, col, grid, visited);
//			}
			this.explore(x+xDir[i], y+yDir[i], row, col, grid, visited);
		}
	}
	
	private boolean shouldexplore(int x,int y, int row, int col, char[][] grid, boolean[][] visited){
		if(x>=0 && x<row && y>=0 && y<col && grid[x][y]=='1' && visited[x][y]==false){
			return true;
		}
		return false;
	}
	
}
