class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        final int FREE = 0, HOLD = 1, SHORT = 2;  
        long[][][] dp = new long[n + 1][k + 1][3];
        for (int i = 0; i <= n; i++) {
            for (int t = 0; t <= k; t++) {
                for (int s = 0; s < 3; s++) {
                    dp[i][t][s] = Long.MIN_VALUE / 2; 
                }
            }
        }
        dp[0][0][FREE] = 0;
        for (int i = 0; i < n; i++) { 
            int price = prices[i];
            for (int t = 0; t <= k; t++) { 
                dp[i + 1][t][FREE] = Math.max(dp[i + 1][t][FREE], dp[i][t][FREE]);
                if (t < k) {
                    dp[i + 1][t + 1][HOLD] = Math.max(dp[i + 1][t + 1][HOLD], 
                                                     dp[i][t][FREE] - price); 
                }
                if (t < k) {
                    dp[i + 1][t + 1][SHORT] = Math.max(dp[i + 1][t + 1][SHORT],
                                                      dp[i][t][FREE] + price); 
                }
                dp[i + 1][t][FREE] = Math.max(dp[i + 1][t][FREE], dp[i][t][HOLD] + price);
                dp[i + 1][t][FREE] = Math.max(dp[i + 1][t][FREE],dp[i][t][SHORT] - price); 
                dp[i + 1][t][HOLD] = Math.max(dp[i + 1][t][HOLD], dp[i][t][HOLD]);
                dp[i + 1][t][SHORT] = Math.max(dp[i + 1][t][SHORT], dp[i][t][SHORT]);
            }
        }
        long maxProfit = 0;
        for (int t = 0; t <= k; t++) {
            maxProfit = Math.max(maxProfit, dp[n][t][FREE]);
        }
        return maxProfit;
    }
}