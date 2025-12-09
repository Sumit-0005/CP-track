class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int maxVal = 100000;
        long ans=0;
        int [] right = new int[maxVal+1];
        int [] left = new int [maxVal+1];
        for(int num : nums){
            right[num]++;
        }
        for(int j=0;j<nums.length;j++){
            int mid= nums[j];
            long target =(long) mid*2;
            right[mid]--;
            if (target <= maxVal) {
                ans = (ans + ((long) left[(int) target] * right[(int) target]) % MOD) % MOD;
            }
            left[mid]++;
        }
        return (int)ans;
    }
}