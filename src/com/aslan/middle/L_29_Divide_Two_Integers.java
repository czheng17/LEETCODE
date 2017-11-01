package com.aslan.middle;
/*
 * Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
解题思路：这道题非常有意思，让我们利用基本的运算符号实现除法运算法则，由于基础数学知识的空白，
在我原来学习除法的时候，并没有深入除法的本质，在过去我的眼里，除法运算就是个机械的算法，一个封装了的实现。
现在，由于这道编程题让我深刻反思了除法原理。算法是这样的，让除数右移（二进制位的右移操作）使得除数扩大接近被除数，
直到除数增大有余数存在，让被除数减去这个增大后的除数，让余数去进行判断。也要考虑最小整数的越界情况，
比如-2147483648取相反数后结果为-2147483648。因为最大整数为2147483647。因此，在这里，遇到最大负数和-1的时候，
返回结果直接选择最大整数即可。
 * */
public class L_29_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
		 int tag =1;//整数
		 long a = dividend;
		 long b = divisor;
		 if(divisor == 1) return dividend;
		    if(divisor == -1) {
		    	if(dividend==Integer.MIN_VALUE){
		    		return Integer.MAX_VALUE;
		    	}
		    	return -dividend;
		 }
		    
		 if(dividend>=0&&divisor>=0||dividend<=0&&divisor<=0){
			 tag=1;
		 }else{
			 tag=-1;
		 }
		
		 a = Math.abs((long)a);
		 b = Math.abs((long)b);
		 
		 if(a<b){
	        return 0;
	     }
		 
		 int re=0;
		 while(a>=b){
        	 int temp =1;
        	 long bt= b;
    		 while(a>=bt<<1){
    			 bt=bt<<1;
    	         temp = temp<<1;
    		 }
        	re+=temp;
        	a-=bt;
         }
		 return re*tag;	     
    }
    public static void main(String[] args) {
		System.out.println(1<<2);
	}
}
