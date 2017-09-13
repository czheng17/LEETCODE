public class L_131_Palindrome_Partitioning {
	/*
	 *  Given a string s, partition s such that every substring of the partition is a palindrome.

		Return all possible palindrome partitioning of s.
		
		For example, given s = "aab",
		Return
		
		[
		  ["aa","b"],
		  ["a","a","b"]
		]
	 * */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s==null || s.length()==0){
        	return res;
        }
        this.dfs(s,0,list,res);
        return res;
    }
    private void dfs(String s, int start, List<String> list, List<List<String>> res){
    	if(start == s.length()){
    		res.add(new ArrayList<String>(list));
    		// I forget write this line: return; so it is wrong.
    		return;
    	}
    	for(int i=start; i<s.length();i++){
    		// I write String sub_str = s.substring(start,start+i); lol i dont know what's wrong with me.
    		String sub_str = s.substring(start,i+1);
    		if(this.ispalindrome(sub_str)==true){
    			list.add(sub_str);
    			// i write this.dfs(sub_str, i+1, list, res); oh my god
    			this.dfs(s, i+1, list, res);
    			list.remove(list.size()-1);
    		}
    	}	
    }
    private boolean ispalindrome(String sub_str){
    	int low = 0;
    	int high = sub_str.length()-1;
    	while(low<high){
    		if(sub_str.charAt(low)!=sub_str.charAt(high)){
    			return false;
    		}
    		low++;
    		high--;
    	}
    	return true;
    }
}
