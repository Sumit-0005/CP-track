class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        int res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            cnt.put(nums[i],cnt.getOrDefault(nums[i],0)+1);
            while(cnt.get(nums[i]) > k){
                cnt.put(nums[left], cnt.get(nums[left])-1);
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}