package com.aslan.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class L_501 {
	
//	public int[] findMode(TreeNode root) {
//        if(root==null){
//        	return (new int[0]);
//        }
//        int[] res = null;
//        List<Integer> list = new ArrayList<Integer>();
//        int maxCount=0;
//        int curCount=0;
//        int cur_num=-1;
//        int pre_num=-1;
//        Stack<TreeNode> stack = new Stack<>();
//        while(!stack.isEmpty() || root!=null){
//        	if(root == null){
//        	    TreeNode pop = stack.pop();
//        		cur_num = pop.val;
//        		if(pre_num==cur_num){
//        			curCount++;
//        			System.out.println(curCount);
//        			if(curCount==maxCount){
//        				int[] new_res = new int[res.length+1];
//        				System.arraycopy(res, 0, new_res, 0, res.length);
//        				new_res[res.length+1] = cur_num;
//        				res = new_res;
//        		    }
//        			if(curCount>maxCount){
//        				maxCount = curCount;
//        				res = new int[1];
//        			    res[0] = cur_num;
//        			}
//        		}else{
//        			pre_num = cur_num;
//        			curCount=1;
//        			if(maxCount==0){
//        			    res = new int[1];
//        			    res[0] = cur_num;
//        		    }
//        		}
//        		
//        		root = pop.right;
//        	}else{
//        		stack.push(root);
//        		root = root.left;
//        	}
//        }
//
//        return res;
//    }
	
	
	
	
	
	
	
	
    public int[] findMode(TreeNode root) {
        if(root==null){
        	return (new int[0]);
        }
        
        List<Integer> list = new ArrayList<Integer>();
        int maxCount=0;
        int curCount=0;
        int cur_num=-1;
        int pre_num=-1;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
        	if(root == null){
        	    TreeNode pop = stack.pop();
        		cur_num = pop.val;
        		if(pre_num==cur_num){
        			curCount++;
        			//System.out.println(curCount);
        			if(curCount==maxCount){
        			    list.add(cur_num);
        		    }
        			if(curCount>maxCount){
        				maxCount = curCount;
        				list.clear();
        				list.add(cur_num);
        			}
        		}else{
        			pre_num = cur_num;
        			curCount=1;
        			if(maxCount==0){
        			    list.add(cur_num);
        		    }
        		}
        		
        		root = pop.right;
        	}else{
        		stack.push(root);
        		root = root.left;
        	}
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
        	res[i] = list.get(i);
        }
        return res;
    }
}
