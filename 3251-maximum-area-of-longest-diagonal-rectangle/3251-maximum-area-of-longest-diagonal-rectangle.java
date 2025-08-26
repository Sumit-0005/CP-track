class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxarea = Integer.MIN_VALUE;
        int maxdiagonal = Integer.MIN_VALUE;
        int n = dimensions.length;
        for(int i=0; i<n; i++){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int currdiagonal = l*l + w*w;
            if(currdiagonal > maxdiagonal || (currdiagonal == maxdiagonal && l*w > maxarea)){
                maxdiagonal = currdiagonal;
                maxarea = l*w;
            }
        }
        return maxarea;
    }
}