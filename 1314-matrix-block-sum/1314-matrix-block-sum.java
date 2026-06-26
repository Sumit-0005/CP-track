class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] arr = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
           for(int j=0;j<mat[0].length;j++){
            int sum=0;
               for(int r=Math.max(0,i-k);r<=i+k && r<mat.length;r++){
                   for(int c=Math.max(j-k,0);c<=j+k && c<mat[0].length;c++){
                       sum= sum + mat[r][c];
                    }
                }
                arr[i][j] = sum;
            }
        }
        return arr;
    }
}