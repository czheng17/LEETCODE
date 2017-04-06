package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0){
        	return res;
        }
        int x_start = 0;
        int x_end = matrix.length-1;
        //if(x_end<0) return res; 
        int y_start = 0;
        int y_end = matrix[0].length - 1;
        
        while(x_start<=x_end && y_start<=y_end){
        	//top left->right
        	for(int i=y_start;i<=y_end;i++){
        		res.add(matrix[x_start][i]);
        	}
        	//right top->bottom
        	for(int i=x_start+1;i<=x_end;i++){
        		res.add(matrix[i][y_end]);
        	}
        	//bottom right->left
        	if(x_start<x_end){
        		for(int i=y_end-1;i>=y_start;i--){
        			res.add(matrix[x_end][i]);
        		}
        	}
        	//left bottom->top
        	if(y_start<y_end){
        		for(int i=x_end-1;i>=x_start+1;i--){
        			res.add(matrix[i][y_start]);
        		}
        	}
        	x_start++;
        	x_end--;
        	y_start++;
        	y_end--;
        }
        return res;
    }
}
