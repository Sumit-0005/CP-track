class Solution {
    boolean valid(int[] arr, int mid, int m , int k){
        int cnt = 0, boq = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= mid)
                cnt++;
            else{
                boq += (cnt/k);
                cnt = 0;
            }
        }
        boq += (cnt/k);
        if(boq >= m)
            return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l=1, mid = 0, n = bloomDay.length;
        int h = bloomDay[0];
        for(int f:bloomDay){
            h = Math.max(h, f);
        }
        if(n < (m*k)) return -1;
        int res = -1;
        while(l <= h){
            mid = l+(h-l)/2;
            boolean ans = valid(bloomDay, mid, m, k);
            if(ans){
                res = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
}