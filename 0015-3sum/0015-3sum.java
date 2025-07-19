class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates
           while (left < right && nums[left] == nums[left + 1]) left++;
           while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // Move right to increase sum
                } else {
                    right--; // Move left to decrease sum
                }
            }
        }
        return res;    
    }
}