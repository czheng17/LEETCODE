/*
the evernote has the details and even has drawing for this question!!
*/
class Solution {
    public int maxArea(int[] a) {
        int i = 0;  
        int j = a.length-1;  
        int maxS = 0;  
        int thisS = 0;  
        while(i!=j){  
              
            thisS = Math.min(a[i],a[j])*(j-i);//高＊宽  
            maxS = thisS>maxS?thisS:maxS;  
            if(a[i]>a[j]){//突破点在高的柱子上  
                j--;  
            }else {  
                i++;  
            }  
        }  
        return maxS;  
    }
