class Solution {
    public int minEatingSpeed(int[] piles, int hour) {
        int n=piles.length,ans=0;
        int l=1;
        int h=piles[0];
        for(int pile:piles){
            h=Math.max(h,pile);
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            long maxhours=0;
            for(int num:piles){
                maxhours+=(long)(num+mid-1)/mid;
            }
            if(maxhours<=hour){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}