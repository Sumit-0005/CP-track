class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
     int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int day = 2; day <= n; day++) 
        { for (int prev = day - forget + 1; prev <= day - delay; prev++) 
            { if (prev >= 1) 
                { 
                  dp[day] = (dp[day] + dp[prev]) % MOD;
                }
            }
        }
        int result = 0;
        for (int day = n - forget + 1; day <= n; day++) 
        {  if (day >= 1) 
            {
              result = (result + dp[day]) % MOD;
            }
      }
         return result;   
    }
}