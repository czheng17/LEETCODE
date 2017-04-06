package com.aslan.middle;

public class L_264 {
    public int nthUglyNumber(int n) {
        int[] n_array = new int[n];
        n_array[0]=1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int counter=1;  //because 1 is in the array
        while(counter<n){
        	int min = this.find_min(n_array[index2]*2, n_array[index3]*3 , n_array[index5]*5 );
        	if(min == n_array[index2]*2 ){
        		index2++;
        	}
        	if(min == n_array[index3]*3 ){
        		index3++;
        	}
        	if(min == n_array[index5]*5 ){
        		index5++;
        	}
        	n_array[counter] = min;
        	counter++;
        	
        }
        return n_array[n-1];
        		
    }
    private int find_min(int a,int b,int c){
    	int tmp= a<b? a:b;
    	return tmp<c?tmp:c;	
    }
    
    
}
