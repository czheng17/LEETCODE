package com.aslan.middle;
/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits
 *  are different.

	Now your job is to find the total Hamming distance between all pairs of the given numbers.
	
	Example:
	Input: 4, 14, 2
	
	Output: 6
	
	Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
	showing the four bits relevant in this case). So the answer will be:
	HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
	
	chen's explanation:
	4: 0 1 0 0
   14: 1 1 1 0
    2: 0 0 1 0
    
    res = 1*2 + 2*1 + 2*1 + 0*3
	
 * 
 * */
public class L_447_Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i=0 ; i<32 ; i++){
        	int ones = 0;
        	for(int j=0; j<nums.length ; j++){
        		ones += (nums[j]>>i) & 0x01;
        	}
        	res += ones*(nums.length - ones);
        }
        return res;
    }
}
