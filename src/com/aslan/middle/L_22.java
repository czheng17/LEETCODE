package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

public class L_22 {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
        if(n<=0){
        	return res;
        }
        this.dfs_method(res,"",n,n);
        return res;
    }
	private void dfs_method(List<String> res,String str,int left,int right){
		if(left>right){
			return;
		}
		if(left==0 && right==0){
			res.add(str);
		}
		if(left>0){
			this.dfs_method(res, str+"(", left-1, right);
		}
		if(right>0){
			this.dfs_method(res, str+")", left, right-1);
		}
	}
}
