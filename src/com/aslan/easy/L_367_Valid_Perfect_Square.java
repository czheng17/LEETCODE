class Solution {
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

这道题利用了如下一个数学公式 
1+3+5+..+(2N-1) == N^2; 
因此我们从1开始累加即可，加法的速度要比乘法的速度快得多，而且还不用考虑一不小心就溢出的问题。
*/
   public boolean isPerfectSquare(int num) {
        for(int i = 1;num > 0;i+=2)
            num -= i;
        return 0 == num;
    }
}
