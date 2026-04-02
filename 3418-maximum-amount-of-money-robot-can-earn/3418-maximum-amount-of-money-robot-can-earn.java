class Solution {
    int m,n;
    int[][][] dp;
    public int maximumAmount(int[][] coins) {
        m=coins.length;
        n=coins[0].length;
        dp=new int[m][n][3];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,Integer.MIN_VALUE/2);
            }
        }
        return find(0,0,2,coins);
    }
    int[] row={0,1};
    int[] col={1,0};

    public int find(int i,int j,int shield,int[][] arr){
        if(i>=m || j>=n){
            return Integer.MIN_VALUE/2;
        }
        if(i==m-1 && j==n-1){
            if(shield>0 && arr[i][j]<0){
                return 0;
            }
            return arr[i][j];
        }
        if(dp[i][j][shield]!=Integer.MIN_VALUE/2) return dp[i][j][shield];
        int ans=Integer.MIN_VALUE/2;
        for(int d=0;d<2;d++){
            int skp=Integer.MIN_VALUE/2;
            if(shield>0 && arr[i][j]<0){
                skp=find(i+row[d],j+col[d],shield-1,arr);
            }
            int nskp=arr[i][j]+find(i+row[d],j+col[d],shield,arr);
            ans = Math.max(ans, Math.max(skp, nskp));
        }
        return dp[i][j][shield]=ans;
    }
}