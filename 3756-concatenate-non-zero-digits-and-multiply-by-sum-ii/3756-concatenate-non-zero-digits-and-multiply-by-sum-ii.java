class Solution {
    private static final int MOD = 1_000_000_007;
    private long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] prefSum = new long[n];
        long[] prefNonZeroNum = new long[n];
        long[] prefNonZeroCnt = new long[n];
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (i > 0) {
                prefSum[i] = prefSum[i - 1];
                prefNonZeroNum[i] = prefNonZeroNum[i - 1];
                prefNonZeroCnt[i] = prefNonZeroCnt[i - 1];
            }
            if (digit != 0) {
                prefSum[i] = (prefSum[i] + digit) % MOD;
                prefNonZeroCnt[i]++;
                prefNonZeroNum[i] = (prefNonZeroNum[i] * 10 + digit) % MOD;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long sum = prefSum[r] - (l > 0 ? prefSum[l - 1] : 0);
            sum = (sum % MOD + MOD) % MOD;
            long cnt = prefNonZeroCnt[r] - (l > 0 ? prefNonZeroCnt[l - 1] : 0);
            long num = prefNonZeroNum[r]
                    - (l > 0 ? (prefNonZeroNum[l - 1] * power(10, cnt)) % MOD : 0);
            num = (num % MOD + MOD) % MOD;

            ans[i] = (int) ((sum * num) % MOD);
        }

        return ans;
    }
}