package com.aslan.hard;

import java.util.ArrayList;
import java.util.List;
/*
 * 首先需要一个简便的方法来表示Q的放置，一个N长的数组就可以解决 int[n]，
 * 例如int[0]=1表示在Q放在第1行的第2列，int[2]=3表示在Q放在第3行的第4列。
 * 为了方便表达，需要一个自定义函数
 * private boolean isValid(int[] queenList, int row, int col)  
 * 函数返回是否可以在指定的行列放置Q，这里有一个前提就是该指定行上面的Q的放置是合法的。
 * */
public class L_51 {
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>>  result = new ArrayList<List<String>>();
		int [] put_pos  = new int[n];
		/*
		 * recur(current_row,end,every_path,result_list);
		 * first row:0
		 * end   row:n
		 * every_path: put_pos
		 * result list: result
		 * */
		recur(0,n,put_pos,result);
		return result;
    }
	
	public void recur(int first,int n,int[] put_pos,List<List<String>> result){
		/*
		 * put_pos没有走到第n行的时候，只遍历到了第a行，那么久从put_pos[0]---put_pos[a]推导put_pos[a+1]的放置位置
		 * 如果col=b 在check（） return true,那么久可以在put_pos[a+1]放置b。并且继续recursion.
		 * */
		if(first < n){
			//for(int row = first; row<n; row++){
				for(int col = 0;col < n; col++){
				    //System.out.println(check(put_pos,first,col));
					if(check(put_pos,first,col)){
						put_pos[first] = col;
						recur(first+1,n,put_pos,result);
					}
				}
				
			//}
		}
		/*
		 * put_pos走到了第n行，那么就先用string弄个类似“.Q..”,然后放进list（一定会有n个string，因为每行只能放一个Q，N行就是N个Q），
		 * 最后把整个list放进result这个大的list
		 * */
		else if(first == n){
		    System.out.println("success");
			List<String> list = new ArrayList<String>();
			for(int i =0; i < n ; i++){
				String str = "" ;
				for(int j =0 ;j<n ; j++){
					if(put_pos[i]==j){
						str +="Q";
					}else{
						str+=".";
					}
				}
				list.add(str);
				System.out.println(str);
			}
			result.add(list);
		}
	}
	
	public boolean check(int[] put_pos,int row,int col){
		for(int i=0;i<row;i++){
			
			if(put_pos[i]==col){ //column equal
				return false;
			}
			if(col+row ==put_pos[i] + i){ //diagnol1 equal
				return false;
			}
			if(col-row ==put_pos[i] - i ){ //diagnonal2 equal
				return false;
			}
		}
        return true;  
	}
	
	 
}
