class Solution {
    public int[] leftRightDifference(int[] nums) {
        int res[] = new int[nums.length];
        int prev = 0;
        for(int i=0; i<nums.length; i++){
            if(i>0){
                prev += nums[i-1];
            }
            res[i] = prev;
        }
        prev = 0;
        for(int i=nums.length-1; i>=0; i--){
            if(i<nums.length-1){
                prev += nums[i+1];
            }
            res[i] = Math.abs(res[i]-prev);
        }
        return res;
    }
}