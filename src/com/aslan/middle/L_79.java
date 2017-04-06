package com.aslan.middle;

/*
 * Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 * 
 * */


public class L_79 {
	public boolean exist(char[][] board, String word) {
		if(board.length==0 || word.length()==0 || board == null || word==null){
			return false;
		}
		int[] first = {1,0,-1,0};
		int[] second = {0,-1,0,1};
		int row = board.length;
		int col = board[0].length;
		char[] word_char = word.toCharArray();
		int pathLength=0;
		boolean[][] visited = new boolean[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				 if (this.dfs(board, row, col, i, j, word_char, pathLength, visited,first,second)) {
			          return true;
			     }
			}
		}
		return false;
	}
	
	public boolean dfs(char[][] board, int rows, int cols, int x, int y,char[] word_char, int pathLength, boolean[][] visited,int[] first,int[] second) {

        // 如果pathLength的长度已经是查找字串的长度，则已经找到
        if (pathLength == word_char.length) {
            return true;
        }
        
        //boolean hasPath = false;
        if (x >= 0 && x < rows && y >= 0 && y < cols
                && board[x][y] == word_char[pathLength]
                && !visited[x][y]) {
            //System.out.println(x+" "+y+" "+board[x][y]+" "+word_char[pathLength]);
        	pathLength++;
            visited[x][y] = true;
            for(int i=0;i<first.length;i++){
            	boolean is_ture=this.dfs(board, rows, cols, x+first[i], y+second[i], word_char, pathLength, visited, first, second);
            	if(is_ture){
            		return true;
            	}
            }
            pathLength--;
            visited[x][y] = false;
        }
        return false;
	} 
	
	
	
	
	
	
	
//    public boolean exist(char[][] board, String word) {
//        if(board.length==0 || word.length()==0){
//        	return false;
//        }
//        int[] first = {1,0,-1,0};
//        int[] second = {0,-1,0,1};
//        int row = board.length;
//        int col = board[0].length;
//        char[] word_char = word.toCharArray();
//        boolean[][] is_visit = new boolean[row][col];
//        for(int i=0;i<row;i++){
//        	for(int j=0;j<col;j++){
//        		if(board[i][j]==word_char[0] && !is_visit[i][j]){
//        			System.out.println(i+" "+j+" "+board[i][j]);
//        			boolean res = this.visit(i,j,0,row,col,board,word_char,first,second,is_visit);
//        			if(res==true){
//        				return true;
//        			}
//        		}
//        		else{
//        			continue;
//        		}
//        	}
//        }
//        return false;
//    }
//    
//    private boolean visit(int i,int j,int current,int row,int col,char[][] board,char[] word_char,int[] first,int[] second,boolean[][] is_visit){
//    	System.out.println(i+" "+j+" "+board[i][j]+" "+word_char[current]);
//    	if(!shouldexplore(i,j,current,row,col,board,word_char,is_visit)){
//    		return false;
//    	}
//    	is_visit[i][j]=true;
//    	if(current == word_char.length-1 && board[i][j] ==word_char[word_char.length-1] ){
//			return true;
//		}
//		if(i>=0 && j>=0 && i<row && j<col && board[i][j] == word_char[current]){
//			System.out.println(i+" "+j+" "+board[i][j]);
//			current++;
//		}
//    	for(int a=0;i<4;a++){
//    			this.visit(i+first[a], j+second[a], current, row, col, board, word_char, first, second,is_visit);
//    	}
//    	current--;
//    	return false;
//    }
//    
//    private boolean shouldexplore(int i,int j,int current,int row,int col,char[][] board,char[] word_char,boolean[][] is_visit){
//    	if(i>=0 && j>=0 && i<row && j<col && board[i][j]==word_char[current] && !is_visit[i][j]){
//    		return true;
//    	}
//    	return false;
//    }
}
