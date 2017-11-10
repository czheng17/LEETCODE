/*
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

solution:
The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
Then we visit every node in pre-order. 
                 1        2        3    ...
                /\        /\       /\
             10 ...19  20...29  30...39   ....
             /\
          100..109
          /\
      1000  1009

*/

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<10;i++){
            this.dfs_method(i,n,list);
        }
        return list;
    }
    private void dfs_method(int cur_num,int n,List<Integer> list){
        if(cur_num > n){
            return ;
        }
        else{
            list.add(cur_num);
            for(int i=0;i<10;i++){
                int tmp = cur_num*10+i;
                if( tmp > n ){
                    return;
                }
                this.dfs_method(tmp,n,list);
            }
        }
    }
}
