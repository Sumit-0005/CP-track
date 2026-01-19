class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
       int rows = mat.length, cols = mat[0].length;
       for(int i=0; i<rows; i++){
        for(int j=1; j<cols; j++){
            mat[i][j] += mat[i][j-1];
        }
       }
       for(int i=1; i<rows; i++){
        for(int j=0; j<cols; j++){
            mat[i][j] += mat[i-1][j];
        }
       } 
       int maxDiagLen = 0;
       for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            for(int diagLen = maxDiagLen+1; i+1-diagLen >= 0 && j+1-diagLen >= 0; diagLen++){
                int iPrev = i-diagLen, jPrev = j-diagLen;;
                int topLeft = iPrev >= 0 && jPrev >= 0 ? mat[iPrev][jPrev] : 0;
                int left = jPrev >= 0 ? mat[i][jPrev] : 0;
                int top = iPrev >= 0 ? mat[iPrev][j] : 0 ;
                int sum = mat[i][j] + topLeft - top - left; 
                if(sum <= threshold){
                    maxDiagLen = diagLen;
                }else{
                    break;
                }
            }
        }
       }
       return maxDiagLen;
    }
}