class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int cnt = k;
        for(int n:nums){
            if(n==1){
                if(cnt < k) return false;
                cnt =0;
            }else{
                cnt++;
            }
        }
        return true;       
    }
}