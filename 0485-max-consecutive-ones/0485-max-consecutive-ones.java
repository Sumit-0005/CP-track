class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int ans = 0;
       int t = 0;
       for(int i=0; i<nums.length; i++){
        if(nums[i] == 0){
            ans = Math.max(t, ans);
            t = 0;
        }else{
            t++;
        }
       } 
       ans = Math.max(ans,t);
       return ans;
    }
}