class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n+1];
        for(int i=0; i<n; i++){
            pre[i+1] = pre[i] + nums[i];
        }
        long res = Long.MIN_VALUE;
        for(int start = 0; start<k; start++){
            long currsum =0; 
            for(int i= start ; i+k-1<n; i+=k){
                int r= i+k-1;
                long blocksum = pre[r+1]-pre[i];
                currsum += blocksum;
                res = Math.max(currsum, res);
                if(currsum<0) currsum = 0;
            }
        }
        return res;
    }
}