class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> map = new HashSet<>();
        int left = 0;
        int curr = 0;
        int maxSum = 0;

        for (int right = 0; right < nums.length; right++) {
            while (map.contains(nums[right])) {
                curr -= nums[left];
                map.remove(nums[left]);
                left++;
            }

            map.add(nums[right]);
            curr += nums[right];
           
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}