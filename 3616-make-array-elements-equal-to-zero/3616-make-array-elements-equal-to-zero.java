class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length, ans =0; 
        int[] pref = new int[n];
        pref[0] = nums[0];
        for(int i=1; i<n; i++){
            pref[i] = pref[i-1] + nums[i];
        }
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                int left = i==0 ? 0 : pref[i-1];
                int right = pref[n-1] - pref[i];
                if(left == right) ans+=2;
                else if(Math.abs(left - right) == 1) ans++;
            }
        }
        return ans;
    }
}