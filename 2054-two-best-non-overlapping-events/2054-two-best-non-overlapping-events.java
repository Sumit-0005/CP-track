class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int[] suffixmax = new int[n];
        suffixmax[n-1] = events[n-1][2];
        for(int i=n-2; i>=0;--i){
            suffixmax[i] = Math.max(events[i][2], suffixmax[i+1]);
        }
        int maxsum =0;
        for(int i=0; i<n; ++i){
            int left = i+1, right = n-1;
            int nexteventindex = -1;
            while(left <= right){
                int mid = left+(right-left)/2;
                if(events[mid][0] > events[i][1]){
                    nexteventindex = mid;
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            if(nexteventindex!=-1){
                maxsum = Math.max(maxsum,events[i][2] + suffixmax[nexteventindex]);
            }
            maxsum = Math.max(maxsum, events[i][2]);
        }
        return maxsum;
    }
}