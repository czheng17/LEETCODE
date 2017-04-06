package com.aslan.easy;

public class L_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int p = x; 
        int q = 0; 
        
        while (p >= 10){
             
            q = q*10 + p%10; 
            p /=10; 
        }
        
        return q == x / 10 && p == x % 10;
    }
}
