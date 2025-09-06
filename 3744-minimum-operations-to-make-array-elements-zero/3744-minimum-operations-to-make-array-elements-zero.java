class Solution {
    static long[] expSum4 = new long[18]; // Stores cumulative ops for 1 to (4^i - 1)
    
    static {
        // Precompute expSum4 array
        expSum4[0] = 1; // For numbers 1 to (4^1 - 1) = 1 to 3
        for (int i = 1; i < 18; i++) {
            long prevRange = 1L << (2 * (i - 1)); // 4^(i-1)
            expSum4[i] = expSum4[i - 1] + 3L * i * prevRange + 1;
        }
    }
    
    public long minOperations(int[][] queries) {
        long totalOps = 0;
        for (int[] q : queries) {
            int l = q[0] - 1; // Convert to 0-indexed start
            int r = q[1];      // 1-indexed end
            totalOps += (expSum(r) - expSum(l) + 1) >> 1;
        }
        return totalOps;
    }
    
    private static long expSum(int x) {
        if (x == 0) return 0;
        // Find largest power of 4 ≤ x
        int log4 = (31 - Integer.numberOfLeadingZeros(x)) >> 1;
        int remainder = x - (1 << (log4 << 1)); // x - 4^log4
        return expSum4[log4] + remainder * (log4 + 1L);
    }
}