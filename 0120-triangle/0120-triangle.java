class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = triangle.get(n-1).get(i);
        }
        for(int r=n-2; r>=0; r--){
            for(int c=0; c<=r ; c++){
                res[c] = triangle.get(r).get(c) + Math.min(res[c] , res[c+1]);
            }
        }
        return res[0];
    }
}