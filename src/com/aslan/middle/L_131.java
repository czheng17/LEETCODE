package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_131 {
	public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] ispal = new boolean[len][len];
        init(ispal,s);
        List<List<String>> ans  = new ArrayList<List<String>>();
        List<String> tmpPartition = new ArrayList<String>();
        helper(s,0,tmpPartition,ans,ispal);
        return ans;
    }
	
	private void helper(String s , int start, List<String> tmpPartition,
			List<List<String>> ans,boolean[][] ispal ){
		if(start>=s.length()){
			ans.add(new ArrayList<String>(tmpPartition));
			return;
		}
		for(int i =start; i<s.length();i++){
			if(ispal[start][i]){
				tmpPartition.add(s.substring(start,i+1));
				helper(s,i+1,tmpPartition,ans,ispal);
				tmpPartition.remove(tmpPartition.size()-1);
			}
		}
	}
	
	private void init(boolean[][] ispal, String s){
		int len = ispal.length;
		for(int i= 0; i<len;i++){
			ispal[i][i] = true;
		}
		for (int k=1;k<len;k++){
			for(int i =0; i+k <len;i++){
				if(s.charAt(k)!=s.charAt(i+k)){
					continue;
				}
				ispal[i][i+k]=(i+1<=i+k-1)?ispal[i+1][i+k-1] : true;
			}
		}
	}
}
