class Solution {
    public int maxDistance(int[] position, int m) {
      Arrays.sort(position);
      int l = 1, r = position[position.length-1]-position[0];
      int ans = -1;
      while(l <= r){
        int mid = l+(r-l)/2;
        int last = position[0], balls = 1;
        for(int i=1; i<position.length; i++)
            if(position[i]-last >= mid){
                last = position[i];
                balls++;
            }
        if(balls >= m){
            ans = mid;
            l = mid+1;
        }else{
            r = mid-1;
        }
      }  
      return ans;
    }
}