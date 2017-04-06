package com.aslan.middle;

import java.util.LinkedList;
import java.util.Queue;

/* eg.
 * X X X X
   X O O X
   X X O X
   X O X X
   answer:
   X X X X
   X X X X
   X X X X
   X O X X
 * */
public class L_130 {
	//换一种思路，把x o 变成 x o * 然后呢DFS全部遍历之后，O变成X， * 变成 O 还是使用DPS/BFS
	private final int[] xdir = {-1,0,1,0};
	private final int[] ydir = {0,1,0,-1};
	public void solve(char[][] board) {
		if(board == null || board.length==0 || board[0].length == 0){
			return;
		}
		int row = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[row][col];
		//把所有的边为O都标记成*
		for(int i=0;i<col;i++){
			if(board[0][i] == 'O'){
				board[0][i] = '*';
			}
			if(board[row-1][i] == 'O'){
				board[row-1][i] ='*';
			}
		}
		for(int i=0;i<row;i++){
			if(board[i][0] == 'O'){
				board[i][0] = '*';
			}
			if(board[i][col-1] == 'O'){
				board[i][col-1] = '*';
			}	
		}
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='X' || visited[i][j]){
					continue;
				}
				this.explore(i,j,row,col,visited,board);
			}
		}
		
		boolean[][] visited1 = new boolean[row][col];
		for(int j=col-1;j>=0;j--){
			for(int i=row-1;i>=0;i--){
				if(board[i][j]=='X' || visited1[i][j]){
					continue;
				}
				this.explore(i,j,row,col,visited1,board);
			}
		}
		
		boolean[][] visited2 = new boolean[row][col];
		for(int j=0;j<col;j++){
			for(int i=row-1;i>=0;i--){
				if(board[i][j]=='X' || visited2[i][j]){
					continue;
				}
				this.explore(i,j,row,col,visited2,board);
			}
		}
		
		boolean[][] visited3 = new boolean[row][col];
		for(int i=row-1;i>=0;i--){
			for(int j=0;j<col;j++){
				if(board[i][j]=='X' || visited3[i][j]){
					continue;
				}
				this.explore(i,j,row,col,visited3,board);
			}
		}
		
		//把x o 变成 x o * 然后呢DFS全部遍历之后，O变成X， * 变成 O
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='O'){
					board[i][j]='X';
				}
				if(board[i][j]=='*'){
					board[i][j]='O';
				}
			}
		}
		
	}
	
	public class Block{
		public int x;
		public int y;
		public Block(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	private void explore(int x,int y,int row,int col,boolean[][] visited,char[][] board){
		if(!this.shouldexplore(x,y,row,col,visited,board)){
			return;
		}
		visited[x][y]=true;
		Queue<Block> queue = new LinkedList<Block>();
		queue.offer(new Block(x, y));
		while(!queue.isEmpty()){
			Block b = queue.poll();
			for(int i=0;i<4;i++){
				int new_x = b.x + xdir[i];
				int new_y = b.y + ydir[i];
				if(this.shouldexplore(new_x,new_y,row,col,visited,board)){
					visited[new_x][new_y] = true;
					if(board[x][y]=='*'){
						board[new_x][new_y] ='*';
					}
					queue.offer(new Block(new_x,new_y));
					
				}
			}
		}
	}
	
	private boolean shouldexplore(int x,int y,int row,int col,boolean[][] visited,char[][] board){
		if(x>=0 && x<row && y>=0 && y<col && !visited[x][y] && board[x][y]!='X'){
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	private final int[] xdir = {-1,0,1,0};
//	private final int[] ydir = {0,-1,0,1};
//	
//	public void solve(char[][] board) {
//		if(board == null || board.length==0 || board[0].length==0){
//			return;
//		}
//        int row = board.length;
//        int col = board[0].length;
//        boolean[][] visited = new boolean[row][col];
//
//        for(int i=0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		if(board[i][j] == 'X' || visited[i][j]){
//        			continue;
//        		}
//        		this.explore(i,j,row,col,visited,board);
//        	}
//        }
//        //把所有边缘的点为'O'的标记为true
//        boolean[][] connect_edge = new boolean[row][col];
//        for(int i=0;i<row;i++){
//        	if(board[i][0]=='O'){
//        		connect_edge[i][0] = true;
//        	}
//        	if(board[i][col-1]=='O'){
//        		connect_edge[i][col-1] = true;
//        	}
//        }
//        for(int i=0;i<col;i++){
//        	if(board[0][i]=='O'){
//        		connect_edge[0][i] = true;
//        	}
//        	if(board[row-1][i]=='O'){
//            	connect_edge[row-1][i] = true;
//        	}
//        }
//        //把所有与边缘点连接的点标记为true
//        //从上到下走一遍
//        for(int i=1;i<row-1;i++){
//        	for(int j=1;j<col-1;j++){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        for(int i=1;i<row-1;i++){
//        	for(int j=col-1;j<1;j++){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        
//        //下到上走一遍
//        for(int i=row-1;i>1;i--){
//        	for(int j=col-1;j>1;j--){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        for(int i=row-1;i>1;i--){
//        	for(int j=1;j>col-1;j--){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        //左到右走一遍
//        for(int j=1;j<col-1;j++){
//        	for(int i=1;i<row-1;i++){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        for(int j=1;j<col-1;j++){
//        	for(int i=row-1;i<1;i++){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        //右到左走一遍
//        for(int j=col-1;j>1;j--){
//        	for(int i=row-1;i>1;i--){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        for(int j=col-1;j>1;j--){
//        	for(int i=1;i>row-1;i--){
//        		if(board[i][j]=='X'){
//        			continue;
//        		}
//        		this.if_connect_edge(i,j,row,col,connect_edge,board);
//        	}
//        }
//        
//        for(int i=0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		System.out.print(connect_edge[i][j]+" ");
//        	}
//        	System.out.println();
//        }
//        
//        //如果 connect_eged[i][j] == false 并且 visited[i][j]==true 并且 board[i][j] =='O',那么board[i][j] 变为'X'
//        for(int i=0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		if(!connect_edge[i][j]  && board[i][j]=='O' &&  visited[i][j]){
//        			board[i][j]='X';
//        		}
//        	}
//        }
//        
//        
//    }
//	
//	private void if_connect_edge(int x,int y,int row,int col,boolean[][] connect_edge,char[][] board){
//		for(int i=0;i<4;i++){
//			int new_xdir = x+xdir[i];
//			int new_ydir = y+ydir[i];
//			if(new_xdir>=0 && new_xdir<row && new_ydir>=0 && new_ydir<col && connect_edge[new_xdir][new_ydir]==true){
//				connect_edge[x][y]=true;
//			}
//			
//		}
//	}
////	// DFS method
////	private void explore(int x,int y,int row,int col,boolean[][] visited,char[][] board){
////		if(!shouldexplore(x,y,row,col,visited,board)){
////			return;
////		}
////		visited[x][y] = true;
////		for(int i=0;i<4;i++){
////			this.explore(x+xdir[i],y+ydir[i],row,col,visited,board);
////		}
////	}
//	
//	//BFS method
//	public class Block{
//		public int x;
//		public int y;
//		public Block(int x,int y){
//			this.x = x;
//			this.y = y;
//		}
//	}
//	
//	private void explore(int x,int y,int row,int col,boolean[][] visited,char[][] board){
//		if(!shouldexplore(x,y,row,col,visited,board)){
//			return;
//		}
//		visited[x][y] = true;
//		Queue<Block> queue = new LinkedList<Block>();
//		queue.offer(new Block(x,y));
//		while(!queue.isEmpty()){
//			Block b = queue.poll();
//			for(int i=0;i<4;i++){
//				int new_x = b.x + xdir[i];
//				int new_y = b.y + ydir[i];
//				if(this.shouldexplore(new_x, new_y, row, col, visited, board)){
//					visited[new_x][new_y]=true;
//					queue.offer(new Block(new_x, new_y));
//				}
//			}
//		}
//		
//	}
//	
//	private boolean shouldexplore(int x,int y,int row,int col,boolean[][] visited,char[][] board){
//		if(x>=0&&x<row&&y>=0&&y<col&& !visited[x][y] && board[x][y]=='O'){
//			return true;
//		}
//		return false;
//	}
	
	public static void main(String[] args) {
		L_130 sol = new L_130();
		//["XOXOXO","OXOXOX","XOXOXO","OXOXOX"]
		char[][] board = {{'O','X','X','O','X',},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
		sol.solve(board);
		int row = board.length;
		int col = board[0].length;
		for(int i =0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
