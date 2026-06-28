class Solution {
    private boolean[][] dp;

    private boolean isPalindrome(String temp, int i, int j) {
        if (dp[i][j])
            return true;
        int p = 0;
        int q = temp.length() - 1;
        while (p < q)
            if (temp.charAt(p++) != temp.charAt(q--))
                return dp[i][j] = false;
        return dp[i][j] = true;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        String result = "";
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < n; j++) {
                temp.append(s.charAt(j));
                if (temp.length() > result.length() && isPalindrome(temp.toString(), i, j))
                    result = temp.toString();
            }
        }
        return result;
    }
}