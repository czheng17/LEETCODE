class Solution {
    public int maximumSwap(int num) {
        char[]nums = String.valueOf(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            char max = nums[i];
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]>=max){
                    index = j;
                    max = nums[j];
                }
            }
            if (index!=i&&nums[i]!=nums[index]){
                swap(nums,i,index);
                return Integer.valueOf(String .valueOf(nums));
            }
        }
        return Integer.valueOf(String.valueOf(nums));
    }

    public void swap(char[]nums,int i,int j){
        char t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
