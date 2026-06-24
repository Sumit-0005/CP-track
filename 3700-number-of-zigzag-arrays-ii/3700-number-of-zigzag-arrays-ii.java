class Solution {
    long MOD = 1000000007;
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        long[][] mat = new long[2*m][2*m];
        int c = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = m , c1 = 0 ; c1 < c && j < 2*m ;c1++,j++){
                mat[i][j] = 1L;
                mat[j][i] = 1L;
            }
            c++;
        }
        mat = solve(mat,n-1);
        long ans = 0L;
        for(int i = 0 ; i < 2*m ; i++){
            for(int j = 0 ; j < 2*m ; j++){
                ans = (ans + mat[i][j]) % MOD;
            }
        }
        return (int)(ans%MOD);
    }
    private long[][] solve(long[][] mat,int n){
        long[][] res = new long[mat.length][mat[0].length];
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(i == j)res[i][j] = 1L;
            }
        }
        while(n > 0){
            if((n & 1) == 1){
                res = multiply(res,mat);
            }
            mat = multiply(mat,mat);
            n >>= 1;
        }
        return res;
    }
    private long[][] multiply(long[][] m1,long[][] m2){
        long[][] ans = new long[m1.length][m1[0].length];
        for(int i = 0 ; i < m1.length ; i++){
            for(int j = 0 ; j < m1[0].length ; j++){
                long v = 0L;
                for(int k = 0 ; k < m1.length ; k++){
                    v = (v + (m1[i][k] * m2[k][j])%MOD)%MOD;
                }
                ans[i][j] = v;
            }
        }
        return ans;
    }
}