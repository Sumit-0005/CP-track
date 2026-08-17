class Solution {
    public int game(int dp[][], int a[], int i, int j, int total) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        int sum_tillk = 0;

        for (int k = i; k < j; k++) {
            sum_tillk += a[k];
            int sum_afterk = total - sum_tillk;
            if (sum_tillk > sum_afterk) 
                ans = Math.max(
                    ans,
                    sum_afterk + game(
                        dp, a, k + 1, j, sum_afterk
                    )
                );
             else if (sum_tillk < sum_afterk) 
                ans = Math.max(
                    ans,
                    sum_tillk + game(
                        dp, a, i, k, sum_tillk
                    )
                );
              else 
                ans = Math.max(
                    ans,
                    sum_tillk + Math.max(
                        game(dp, a, k + 1, j, sum_afterk),
                        game(dp, a, i, k, sum_tillk)
                    )
                );
        }
        return dp[i][j] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int dp[][] = new int[n][n];
        int total_sum = 0;
        for (int i = 0; i < n; i++) {
            total_sum += stoneValue[i];
            Arrays.fill(dp[i], -1);
        }
        return game(dp, stoneValue, 0, n - 1, total_sum);
    }
}