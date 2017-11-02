/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums.length==0 || nums.length<k){
            return res;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        //创建一个value频率容器的List数组,数组下标i是这个num在数组中出现i次，222333，出现3个2和3个3
        //所以数组是List<Integer>[] 类型，可以在同一个下标中存放多个。
        //频率最多的情况一定是nums数组所有值都一样，这样频率就是nums.length-->最大值
        List<Integer>[] list_array = new List[nums.length+1];
        
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(list_array[freq]==null){
                list_array[freq] = new ArrayList<>();
            }
            //存放的是key，因为最后输出的是频率最多的对用的key值
            list_array[freq].add(key);
        }
        //频率数组从后向前寻找
        for(int i=list_array.length-1; i>0&&k>0 ;i--){
            if(list_array[i] != null){
                //使用addAll方法
                res.addAll(list_array[i]);
                k -= list_array[i].size();
            }
        }
        
        return res;
    }
}
