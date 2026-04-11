class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] p1 = new int[n+1];
        int[] p2 = new int[n+1];
        Arrays.fill(p1, -1);
        Arrays.fill(p2, -1);
        for(int i=0; i<n; i++){
            int val = nums[i];
            if(p2[val] != -1){
                ans = Math.min(ans,i-p2[val]);
            }
            p2[val] = p1[val];
            p1[val] = i;
        }
        return (ans == Integer.MAX_VALUE) ? -1: 2*ans;
    }
}