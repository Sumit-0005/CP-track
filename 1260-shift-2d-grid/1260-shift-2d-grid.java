class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) 
                temp.add(grid[i][j]);
        int size = temp.size();
        k %= size;
        reverse(temp, 0, size - 1);
        reverse(temp, 0, k - 1);
        reverse(temp, k, size - 1);
        List<List<Integer>> result = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) 
                row.add(temp.get(idx++));
            result.add(row);
        }
        return result;
    }
    private void reverse(List<Integer> list, int left, int right) {
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}