/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST 
such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/

class Solution {
    public boolean findTarget(TreeNode root,int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        for(int i = 0,j = list.size() - 1 ; i < j;)              //根据首尾进行相加来夹逼，得到和是否为target值。
        {
            if((list.get(i) + list.get(j)) == k)
                return true;
            else if(list.get(i) + list.get(j) < k)
                i++;
            else
                j--;
        }
        return false;
    }
    public void inOrder(TreeNode root,ArrayList<Integer> list)   //递归方式来对一棵二叉树进行中序遍历
    {
        if(root == null)
            return;
        if(root.left != null)
            inOrder(root.left,list);
        list.add(root.val);
        if(root.right != null)
            inOrder(root.right,list);

    }
}
