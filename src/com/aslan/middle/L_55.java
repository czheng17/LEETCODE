	public boolean canJump(int[] A) {  
        int reach = 0;  
        int i = 0;  
        while(i < A.length && i <= reach){
        	reach = Math.max(reach, i + A[i]);
        	i++;
        }
        return (i == A.length);  
    }  
