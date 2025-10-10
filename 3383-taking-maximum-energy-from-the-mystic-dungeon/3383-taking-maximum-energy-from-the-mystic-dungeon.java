class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int maxenergy = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
          dp[i] = energy[i];
          if(i+k < n){
            dp[i] += dp[i+k];
          }
          maxenergy = Math.max(maxenergy, dp[i]);
        }
        return maxenergy;
    }
}