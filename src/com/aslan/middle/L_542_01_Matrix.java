/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*/

class Solution {
    
    // http://blog.csdn.net/mine_song/article/details/70194868
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 上下左右
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] dir : dirs){
                int row = current[0] + dir[0];
                int col = current[1] + dir[1];
                if(row<0 || row>=m || col<0 || col>=n){
                    continue;
                }
                // 上下左右取到的值
                int tmp_value = matrix[row][col];
                int current_value = matrix[current[0]][current[1]] + 1 ; 
                //most important part
                if(tmp_value <= current_value){
                    continue;
                }
                // end most important part
                queue.offer(new int[]{row , col});
                matrix[row][col] = current_value;
            }
        }
        return matrix;
        
    }
}
