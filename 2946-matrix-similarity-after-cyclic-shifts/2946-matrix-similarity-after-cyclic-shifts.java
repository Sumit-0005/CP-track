class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        for(int r=0; r<mat.length; r++)
        for(int c=0; c<n; c++){
            if((r%2) == 1){
                int target = (c + k%n)%n;
                if(mat[r][target] != mat[r][c]) return false;
            }else{
                int target = (c - k%n +n)%n;
                if(mat[r][target] != mat[r][c]) return false;
            }
        }
        return true;
    }
}