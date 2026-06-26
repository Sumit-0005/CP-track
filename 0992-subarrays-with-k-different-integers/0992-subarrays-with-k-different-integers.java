class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0, n = nums.length;
        int[] cnt = new int[n+1];
        for(int l=0,m=0,r=0; r<n; ++r){
            if(++cnt[nums[r]] == 1)
                if(--k<0){
                    cnt[nums[m++]] = 0;
                    l=m;
                }
            if(k<=0){
                while(cnt[nums[m]] > 1)
                    --cnt[nums[m++]];
                res += m-l+1;    
            }    
        }
        return res;
    }
}