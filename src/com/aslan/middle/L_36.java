package com.aslan.middle;

import java.util.HashSet;
import java.util.Set;

public class L_36 {
	public boolean isValidSudoku(char[][] board) {
		
        Set<Character> set = new HashSet<Character>();
        // check each row whether have repeat number or not.
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[i].length;j++){
        		if(board[i][j] == '.'){
        			continue;
        		}
        		if(set.contains(board[i][j])){
        			return false;
        		}
        		else{
        			set.add( board[i][j]);
        		}
        	}
        	set.clear();
        }
        // check each column whether have repeat number or not.
        for(int j=0;j<board[0].length;j++){
        	for(int i=0;i<board.length;i++){
        		if(board[i][j] == '.'){
        			continue;
        		}
        		if(set.contains(board[i][j])){
        			return false;
        		}
        		else{
        			set.add( board[i][j]);
        		}
        	}
        	set.clear();
        }
        
        //check each 3*3 window whether have repeat number or not.
        for(int k=0;k<board.length;k++){
        	for(int i=(k/3)*3;i<(k/3)*3+3;i++){
            	for(int j=(k%3)*3;j<(k%3)*3+3;j++){
            		if(board[i][j] == '.'){
            			continue;
            		}
            		if(set.contains(board[i][j])){
            			return false;
            		}
            		else{
            			set.add( board[i][j]);
            		}
            	}
            }
        	set.clear();
        }        
        return true;
        
    }
}
