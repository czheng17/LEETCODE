package com.aslan.easy;

public class L_492 {
	public int[] constructRectangle(int area) {
		int[] res = new int[2];
		int a = (int) Math.sqrt(area);
		while(area % a !=0){
			a--;
		}
		int b = area/a;
		res[0] = b;
		res[1] = a;
		return res;
	}
}
