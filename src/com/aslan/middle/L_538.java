package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 * 
 * */
public class L_538 {
/*
 * Method 1
 * 
 * */
	List<TreeNode> list = new ArrayList<>();
	
	public TreeNode convertBST(TreeNode root) {
		if(root==null){
			return null;
		}
		TreeNode first_node = root;
		//中序遍历tree，把每个点放在list中
		this.list_change(root);
		//list 的 val 从后向前累加。
		int sum=0;
        for(int i=list.size()-1;i>=0;i--){
        	list.get(i).val += sum;
        	sum = list.get(i).val;
        }
        //找到root起始位置
        root = first_node;
        //重新中序遍历,把每一个遍历的节点变成list的第一个node,并且list remove掉第一个值。
        this.change_tree(root);
        return first_node;
		
	}
	
	private void list_change(TreeNode root){
		if(root==null){
			return;
		}
		this.list_change(root.left);
		list.add(root);
		this.list_change(root.right);
	}
	
	private void change_tree(TreeNode root){
		if(root==null){
			return;
		}
		this.change_tree(root.left);
		root = list.get(0);
		list.remove(0);
		this.change_tree(root.right);
	}
	
/*
 * 
 * Method 2
 * 
 * */	
//    public TreeNode convertBST(TreeNode root) {
//    	if(root==null){
//    		return root;
//    	}
//    	TreeNode first_node = root;
//    	
//        List<TreeNode> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        
//        while(!stack.isEmpty() || root!=null){
//        	if(root!=null){
//        		stack.push(root);
//        		root = root.left;
//        	}
//        	else{
//        		TreeNode pop = stack.pop();
//        		list.add(pop);
//        		root = pop.right;
//        	}
//        }
//        int sum=0;
//        for(int i=list.size()-1;i>=0;i--){
//        	list.get(i).val += sum;
//        	sum = list.get(i).val;
//        }
//        
//        stack.clear();
//        root = first_node;
//        
//        this.middle_vis(root,list);
//        return first_node;
//    }
//    private void middle_vis(TreeNode root,List<TreeNode> list) {
//    	  if(root == null)return;
//    	  if(root.left != null) this.middle_vis(root.left,list);
//    	  root= list.get(0);
//    	  list.remove(0);
//    	  if(root.right != null) this.middle_vis(root.right,list);
//    }
}
