class Solution {
    private boolean isMagic(int[][] grid, int r, int c) {
        int[] freq = new int[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9) return false;
                if (freq[val]++ > 0) return false;
            }
        }
        for (int i = r; i < r + 3; i++) {
            if (grid[i][c] + grid[i][c+1] + grid[i][c+2] != 15)
                return false;
        }
        for (int j = c; j < c + 3; j++) {
            if (grid[r][j] + grid[r+1][j] + grid[r+2][j] != 15)
                return false;
        }
        return true;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0;
        if (n < 3 || m < 3) return 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (grid[i+1][j+1] == 5 && isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}