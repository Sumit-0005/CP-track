class Solution {
    public int numSpecial(int[][] mat) {
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    if(col(mat,i,j)&&row(mat,i,j))count++;
                }
            }
        }
        return count;
    }
    public static boolean col(int[][]mat,int row,int col){
        for(int i=0;i<mat[0].length;i++){
            if(i==col)continue;
            if(mat[row][i]==1)return false;
        }
        return true;
    }
    public static boolean row(int[][]mat,int row,int col){
        for(int i=0;i<mat.length;i++){
            if(i==row)continue;
            if(mat[i][col]==1)return false;
        }
        return true;
    }
}