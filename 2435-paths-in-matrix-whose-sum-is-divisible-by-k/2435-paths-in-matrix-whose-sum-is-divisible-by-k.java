class Solution {
    static final int MOD = 1000000007; 
    public int recursion(int[][] grid, int k, int i, int j, int sum, int[][][] dp){
        if(i>=grid.length || j>=grid[0].length) return 0; 
        if(i==grid.length-1 && j==grid[0].length-1){  
            if((sum + grid[i][j])%k==0) return 1;  
            else return 0;  
        }
 
        if(dp[i][j][sum]!=-1){  
            return dp[i][j][sum];  
        }

        int newSum = (sum + grid[i][j]) % k;  

         return dp[i][j][sum] = (recursion(grid, k, i+1, j, newSum, dp) + recursion(grid, k, i, j+1, newSum, dp)) % MOD;  
    }
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1); 
            }
        }

        return recursion(grid, k, 0, 0, 0, dp);
    }
}