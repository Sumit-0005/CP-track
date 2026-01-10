class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int sum = 0;
        for(char c : s1.toCharArray()){
            sum += c;
        }
        for(char c : s2.toCharArray()){
            sum += c;
        }

        return sum - 2 * LCS(s1, s2); 
    }
    private int LCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m+1][n+1];

        //first row and col is 0
        for(int i = 0; i <= m; i++){
            memo[i][0] = 0;
        }
        for(int i = 0; i <= n; i++){
            memo[0][i] = 0;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    memo[i][j] = s1.charAt(i-1) + memo[i-1][j-1];
                }else{
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }

        return memo[m][n];
    }
}