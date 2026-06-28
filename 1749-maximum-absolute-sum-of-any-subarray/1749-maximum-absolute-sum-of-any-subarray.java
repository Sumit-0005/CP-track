class Solution {
    public int maxAbsoluteSum(int[] nums) {
       int max = 0, min = 0;
       int res = 0;
       for(var n: nums){
        max = Math.max(0, n+max);
        min = Math.min(0, n+min);
        res = Math.max(res, Math.max(max, -min));
       }
       return res;
    }
}