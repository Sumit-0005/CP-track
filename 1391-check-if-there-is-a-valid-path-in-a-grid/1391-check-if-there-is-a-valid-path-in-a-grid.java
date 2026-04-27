class Solution {
    int rows, cols;
    int[][][] dir = {
        {}, 
        {{0, -1}, {0, 1}}, 
        {{-1, 0}, {1, 0}}, 
        {{0, -1}, {1, 0}}, 
        {{0, 1}, {1, 0}},  
        {{0, -1}, {-1, 0}}, 
        {{0, 1}, {-1, 0}}  
    };

    public boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row == rows - 1 && col == cols - 1) return true;

        visited[row][col] = true;
        int streetType = grid[row][col];

        for (int[] d : dir[streetType]) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                && !visited[newRow][newCol]) {
                if (canConnect(row, col, newRow, newCol, grid[newRow][newCol])) {
                    if (dfs(grid, newRow, newCol, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean canConnect(int parentRow, int parentCol, int row, int col, int neighType) {
        for (int[] d : dir[neighType]) {
            if (row + d[0] == parentRow && col + d[1] == parentCol) {
                return true;
            }
        }
        return false;
    }
}