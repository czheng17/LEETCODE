package com.aslan.middle;

import java.util.Arrays;

public class L_275 {
	public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int h = 0, n = citations.length;
        //Arrays.sort(citations);
        for (int i = n - 1; i >= 0; i--) {
            if (citations[i] >= n - i) {
                h = n - i;
            } else {
                break;
            }
        }
        return h;
    }
}
