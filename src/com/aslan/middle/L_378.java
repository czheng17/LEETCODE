package com.aslan.middle;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
 * 
 * */

public class L_378 {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for(int i =0;i<row;i++){
        	for(int j=0;j<col;j++){
        		queue.offer(matrix[i][j]);
        	}
        }
        while(k-- >1){
        	queue.poll();
        }
        return queue.peek();
        
    }
}
