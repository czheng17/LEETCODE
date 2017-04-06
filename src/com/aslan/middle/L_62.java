package com.aslan.middle;

public class L_62 {
	public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0){
        	return 0;
        }
        
        int[][] table = new int[m][n];
        
        for(int i=0;i<m;i++){
        	table[m][0] = 1;
        }
        for(int i=0;i<n;i++){
        	table[0][n]=1;
        }
        for(int i =1;i<m;i++){
        	for(int j=1;j<n;j++){
        		table[i][j] = table[i-1][j] + table[i][j-1];
        	}
        }
        return table[m][n];
    }
}
