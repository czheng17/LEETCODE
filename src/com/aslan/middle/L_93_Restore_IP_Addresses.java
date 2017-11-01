package com.aslan.middle;

import java.util.ArrayList;
import java.util.List;

/*
 * 题目：

Given a string containing only digits, restore it by returning all possible valid 
IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 

题解：

利用循环递归解决子问题。对于每个段内数来说，最多3位最少1位，所以在每一层可以循环3次，来尝试填段。因为IP地址最多4个分段，
当层数是3的时候说明已经尝试填过3个段了，那么把剩余没填的数段接到结尾即可。

这个过程中要保证的是填的数是合法的，最后拼接的剩余的数也是合法的。

 注意开头如果是0的话要特殊处理，如果开头是0，判断整个串是不是0，不是的话该字符就是非法的。因为001，01都是不对的。


 * */
public class L_93 {
	public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();  
          String item = new String();
          if (s.length()<4||s.length()>12) 
          return res;  
          
          dfs(s, 0, item, res);  
          return res;
    }
    /*
     * s: 还没处理过的字段  如 255255255255  前三个字符255处理了，那个s就是255255255
     * start:已经实现了几个了， 因为只有4个， start=3的时候（255， 255， 255），判断最后一个是不是valid，可以就放进List
     * item：255.  （处理过的前一部分）
     * res： 不用说了吧。。。
     * */
    public void dfs(String s, int start, String item, ArrayList<String> res){  
         if (start == 3 && isValid(s)) {  
             res.add(item + s);  
             return;  
         }  
         for(int i=0; i<3 && i<s.length()-1; i++){  
             String substr = s.substring(0,i+1);  
             if (isValid(substr))
                 dfs(s.substring(i+1, s.length()), start+1, item + substr + '.', res);  
         }  
    }
    
    public boolean isValid(String s){  
         if (s.charAt(0)=='0')
             return s.equals("0");  
             int num = Integer.parseInt(s);
             
         if(num <= 255 && num > 0)
             return true;
         else
             return false;
     } 
}
