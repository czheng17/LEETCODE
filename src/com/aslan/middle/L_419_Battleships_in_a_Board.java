package com.aslan.middle;
/*
 * Given an 2D board, count how many battleships are in it. 
 * The battleships are represented with 'X's, empty slots are represented with '.'s. 
 * You may assume the following rules:

	You receive a valid board, made of only battleships or empty slots.
	Battleships can only be placed horizontally or vertically. In other words, 
	they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), 
	where N can be of any size.
	
	At least one horizontal or vertical cell separates between two battleships - 
	there are no adjacent battleships.
	Example:
	X..X
	...X
	...X
	In the above board there are 2 battleships.
	Invalid Example:
	...X
	XXXX
	...X
	This is an invalid board that you will not receive - 
	as battleships will always have a cell separating between them.
	题目大意：水平方向或者竖直方向上的'X'集合算一条军舰，不能拐弯，不会出现两条军舰挨着的情况。
	思路：
	解法一、一种解法是深度优先遍历，用两层循环对所有位置进行遍历，遇到没被访问过的‘X’则军舰数加1，
	然后从该点开始进行深度优先遍历，将代表该军舰的所有‘X’标记为访问过的状态。
 * 
 * */
public class L_419_Battleships_in_a_Board {
    public int countBattleships(char[][] board) {
        int res = 0;
        if(board==null || board.length==0){
        	return 0;
        }
        int[] x_axis = {-1,0,1,0};
        int[] y_axis = {0,1,0,-1};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i< board.length ;i++){
        	for(int j=0; j<board[0].length;j++){
        		if(board[i][j]=='X' && visited[i][j]==false){
        			res++;
        			this.dfs_method(board,visited,i,j,x_axis,y_axis);
        		}
        	}
        }
        return res;
    }
    private void dfs_method(char[][] board, boolean[][] visited, int a,int b, int[] x_axis, int[] y_axis) {
		visited[a][b] = true;
		int new_x,new_y;
		for(int k=0;k<4;k++){
			new_x = a + x_axis[k];
			new_y = b + y_axis[k];
			if(new_x>=0 && new_x<board.length && new_y>=0 && new_y<board[0].length
					&& board[new_x][new_y]=='X' && visited[new_x][new_y]==false ){
				this.dfs_method(board,visited,new_x,new_y,x_axis,y_axis);
			}
		}
		
	}
}
