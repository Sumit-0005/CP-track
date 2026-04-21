class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        for(int i=0; i<n; i++){
            if(colors[i] != colors[n-1]){
                maxDist = Math.max(maxDist, (n-1)-i);
                break;
            }
        }
        for(int i=n-1; i>=0; i--){
            if(colors[0] != colors[i]){
                maxDist = Math.max(maxDist, i);
                break;
            }
        }
        return maxDist;
    }
}