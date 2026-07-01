class Solution {
    public boolean help(int m , int d[], double h){
        double time = 0.0;
        for(int i=0; i<d.length; i++){
            if(i != d.length-1){
                time += Math.ceil(d[i]/(double)m);
            }else time += (d[i]/(double)m);
        }
        return time <= h;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, h=(int)Math.pow(10,7);
        int ans =- 1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(help(mid,dist,hour)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}