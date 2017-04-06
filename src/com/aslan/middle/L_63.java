package com.aslan.middle;

public class L_63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0){
        	return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        
        for(int i=0;i<m;i++){
        	if(obstacleGrid[i][0] == 0){
        		table[i][0] = 1;
        	}
        	//有障碍，下面走不下去了
        	else if(obstacleGrid[i][0] == 1){
        		break;
        	}
        }
        
        for(int j=0;j<n;j++){
        	if(obstacleGrid[0][j]==0){
        		table[0][j]=1;
        	}
        	//有障碍，右边走不下去了
        	else if(obstacleGrid[0][j] == 1){
        		break;
        	}
        }
        
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		if(obstacleGrid[i][j]==1){
        			table[i][j] = 0;
        		}else{
        			table[i][j] = table[i-1][j]+ table[i][j-1];
        		}
        	}
        }
        return table[m-1][n-1];
    }
}
