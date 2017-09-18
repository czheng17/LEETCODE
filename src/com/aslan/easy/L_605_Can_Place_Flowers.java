package com.aslan.easy;
/*
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and
 *  both would die.

Given a flowerbed (represented as an array containing 0 and 1, 
where 0 means empty and 1 means not empty), and a number n, 
return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
 * */
public class L_605_Can_Place_Flowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean flag = true;
		for(int i=0;i<flowerbed.length;i++){
			if(flowerbed[i]==0){
				if(flag==true){
					n--;
					flag=false;
				}
				else{
					flag=true;
				}
			}
			else if(flowerbed[i]==1){
				if(!flag&&flowerbed[i-1]==0){
					n++;
				}
				flag=false;
			}
		}
		return n<=0;
	}
}
