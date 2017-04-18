package com.aslan.middle;
/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement 
 * as an array that is constructed by these N numbers successfully 
 * if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:

1.The number at the ith position is divisible by i.
2.i is divisible by the number at the ith position.

如果3个数字，有3种结果。
[1, 2, 3]
[2, 1, 3]
[3, 2, 1]
3
 * 
 * 
 * **/
import java.util.ArrayList;
import java.util.List;

public class L_526 {
	int count=0;
    public int countArrangement(int N) {
        if(N==0){
        	return 0;
        }
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[N+1];
        this.recur(1,N,visited,list);
        return count;
    }
    private void recur(int index,int N,boolean[] visited,List<Integer> list){
    	if(index>N){
    		count++;
    		return;
    	}
    	for(int i=1;i<=N;i++){
    		if(visited[i]==false){
    			if( i%index==0 || index%i==0){
        			list.add(i);
        			index++;
        			visited[i]=true;
        			this.recur(index, N, visited,list);
        			index--;
        			list.remove(list.size()-1);
        			visited[i]=false;
        		}
    		}
    		
    	}
    }
}
