package com.aslan.easy;

import java.util.ArrayList;
import java.util.List;

public class L_257 {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
		if(root == null){
			return res;
		}
		List<Integer> path = new ArrayList<Integer>();
		this.DFS_method(root,path,res);
		return res;
    }
	
	private void DFS_method(TreeNode root,List<Integer> path,List<String> res){
		if(root==null){
	        return;
	    }
		
		path.add(root.val);
		if(root.left==null && root.right==null){
			String temp = "";
			temp += path.get(0).toString();
			for(int i=1;i<path.size();i++){
				temp += "->"+path.get(i).toString();
			}
			res.add(temp);
		}
		this.DFS_method(root.left, path, res);
		this.DFS_method(root.right, path, res);
		path.remove(path.size()-1);
	}
}
