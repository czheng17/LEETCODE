public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	if(nums==null || nums.length<3){
		return res;
	}

	Arrays.sort(nums);
	for(int i=0;i<nums.length;i++){
		if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
			int left = i+1;
			int right = nums.length-1;
					
			while(left<right){
				int tmp = 0 - nums[i];
				if(nums[left]+nums[right]==tmp){
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);	
					int leftValue = nums[left];
					int rightValue = nums[right];
					left++;
					right--;
					while(left<nums.length && nums[left]==leftValue){
						left++;
					}
					while(right>i && nums[right]==rightValue){
						right--;
					}
				}
				else if(nums[left]+nums[right]<tmp){
					left++;
				}
				else{
					right--;
				}
			}
		}
	}	
	return res;
  }
	
}
