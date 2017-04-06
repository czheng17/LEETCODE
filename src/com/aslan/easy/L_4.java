package com.aslan.easy;
/*
 * reverse integer
 * eg. 123---> 321
 * eg. -123---> -321
 * */
public class L_4 {
	public int reverse(int x){
		long res = 0;
		long x0 = x;
		int sign = x >0 ? 1 : -1;
		if (sign == -1){
			x0 = sign * x0;
		}
		while(x0 > 0){
			long digit = x0 % 10;
			res = res * 10 + digit;
			if (res > Integer.MAX_VALUE || res< Integer.MIN_VALUE){
				return 0;
			}
			x0 = x0 /10;
		}
		return (int) (res * sign);
		
	}
}
