package com.aslan.middle;

public class L_260 {
	public int[] singleNumber(int[] nums) {
        int[] rt = new int[2];
        int n = 0;
        for (int v : nums) {
            n ^= v;
        }
        System.out.println("n="+n);
        int m = n & (~(n - 1));
        System.out.println(~(n - 1));
        System.out.println("m="+m);
        for (int v : nums) {
            System.out.println(m & v);
            if ((m & v) == 0) {
                //System.out.println("rt[0]="+rt[0]);
                System.out.println("v="+v);
                rt[0] ^= v;
                System.out.println("rt[0]="+rt[0]);
            } else {
                //System.out.println("rt[1]="+rt[1]);
                System.out.println("v="+v);
                rt[1] ^= v;
                System.out.println("rt[1]="+rt[1]);
            }
        }
        return rt;
    }
}
