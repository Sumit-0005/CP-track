class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int global = Integer.MIN_VALUE;
        int ansmax = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            global = Math.max(global, nums[i]);
            if(i == ans)
                ansmax = Math.max(ansmax, nums[i]);
            if(nums[i] < ansmax-k){
                ans = i+1;
                ansmax = global;
            }
        }
        return ans<n ? ans: -1;
    }
}