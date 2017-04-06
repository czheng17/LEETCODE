package com.aslan.hard;

public class L_52 {
	static int glo_result =0;
	public static int getGlo_result() {
		return glo_result;
	}
	public static void setGlo_result(int glo_result) {
		L_52.glo_result = glo_result;
	}
	public int totalNQueens(int n) {
        
        int[] put_pos = new int[n];
        recur(0,n,put_pos);
        return glo_result;
    }
	public void recur(int current_row,int n,int[] put_pos){
		if(current_row <n){
			for(int col = 0;col<n;col++){
				if(check(put_pos,current_row,col)){
					put_pos[current_row]=col;
					recur(current_row+1,n,put_pos);
				}
			}
		}
		else if(current_row == n){
			//System.out.println("come in the last row!");
			//setResult(++result);
			glo_result+=1;
			setGlo_result(glo_result);
		}
	}
	
	public boolean check(int[] put_pos,int row,int col){
		for(int i=0;i<row;i++){
			if(put_pos[i] == col ){
				return false;
			}
			if(col+row == put_pos[i]+i){
				return false;
			}
			if(col - row ==put_pos[i]-i){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		L_52 sol = new L_52();
		int res = sol.totalNQueens(8);
		System.out.println("result = "+ res);
	}
}
