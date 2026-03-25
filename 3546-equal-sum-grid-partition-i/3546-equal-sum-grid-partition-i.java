class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // → We'll store the sum of each row and each column
        long[] row_sum = new long[m];
        long[] col_sum = new long[n];

        // → One pass through the whole grid: fill both row_sum and col_sum at once
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                row_sum[i] += val;      // add to current row
                col_sum[j] += val;      // add to current column
            }
        }

        // → Build prefix sums for rows: row_prefix[i] = sum of rows 0..i-1
        //   Using m+1 size makes later checks easier (no need for special cases)
        long[] row_prefix = new long[m + 1];
        for (int i = 0; i < m; i++) {
            row_prefix[i + 1] = row_prefix[i] + row_sum[i];
        }

        // → Build prefix sums for columns: col_prefix[j] = sum of columns 0..j-1
        long[] col_prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            col_prefix[i + 1] = col_prefix[i] + col_sum[i];
        }

        long total_sum = row_prefix[m];   // same as col_prefix[n]

        // → If total sum is odd, it's impossible to split into two equal integer halves
        if (total_sum % 2 != 0) {
            return false;
        }

        long target = total_sum / 2;

        // → Check horizontal cuts: cut after row i (1 ≤ i ≤ m-1) means top part = row_prefix[i]
        for (int i = 1; i < m; i++) {
            if (row_prefix[i] == target) {
                return true;
            }
        }

        // → Check vertical cuts: cut after col i (1 ≤ i ≤ n-1) means left part = col_prefix[i]
        for (int i = 1; i < n; i++) {
            if (col_prefix[i] == target) {
                return true;
            }
        }

        return false;
    }
}