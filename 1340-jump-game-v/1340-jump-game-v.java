class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        
        int maxVisited = 0;
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i, dp));
        }
        
        return maxVisited;
    }
    
    private int dfs(int[] arr, int d, int i, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        int maxFromHere = 1;
        int n = arr.length;
        for (int j = i + 1; j <= i + d && j < n; j++) {
            if (arr[j] >= arr[i]) {
                break; 
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, d, j, dp));
        }
        for (int j = i - 1; j >= i - d && j >= 0; j--) {
            if (arr[j] >= arr[i]) {
                break;
            }
            maxFromHere = Math.max(maxFromHere, 1 + dfs(arr, d, j, dp));
        }
        dp[i] = maxFromHere;
        return dp[i];
    }
}