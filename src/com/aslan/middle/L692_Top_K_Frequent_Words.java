/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, 
then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words.length==0 && words.length<k){
            return res;
        }
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word , map.getOrDefault(word,0)+1);
        }
        
        List<String>[] list_array = new List[words.length+1];
        
        for(String key : map.keySet()){
            int freq = map.get(key);
            if(list_array[freq]==null){
                list_array[freq] = new ArrayList<String>();
            }
            list_array[freq].add(key);
        }
        
        for(int i=list_array.length-1; i>0&&k>0 ; i--){
            if(list_array[i]!=null){
                Collections.sort(list_array[i]);
                if(list_array[i].size()<k){
                    res.addAll(list_array[i]);
                }
                else{
                    for(int j=0;j<k;j++){
                        res.add(list_array[i].get(j));
                    }
                }
                k -= list_array[i].size();
            }
        }
        return res;
    }
}
