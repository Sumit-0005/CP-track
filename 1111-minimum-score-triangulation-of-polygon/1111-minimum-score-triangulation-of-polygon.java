class Solution {
    public int minScoreTriangulation(int[] v) {
        int n = v.length;
        if (n == 3) return v[0] * v[1] * v[2];
        int[][] dp = new int[n - 1][n];
        for (int d = 2; d <= n - 1; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                int w = Integer.MAX_VALUE, e = v[i] * v[j];
                for (int k = i + 1; k < j; k++) {
                    w = Math.min(w, e * v[k] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = w;
            }
        }
        return dp[0][n - 1];
    }
}