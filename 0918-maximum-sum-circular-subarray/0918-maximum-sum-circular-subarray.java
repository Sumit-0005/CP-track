class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int max = nums[0]+nums[nums.length-1];
        int currmax = 0;
        int min = nums[0];
        int currmin = 0;
        for(int num : nums){
            sum += num;
            currmax = Math.max(num, currmax+num);
            max = Math.max(max, currmax);
            currmin = Math.min(num, currmin + num);
            min = Math.min(min, currmin);
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }
}