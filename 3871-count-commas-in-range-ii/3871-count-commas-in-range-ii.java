class Solution {
    public long countCommas(long n) {
        long cnt = 0;
        for(long p=1000; p<=n; p*=1000)
            cnt += n-p+1;
        return cnt;
    }
}