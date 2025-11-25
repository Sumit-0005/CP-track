class Solution {
    public int smallestRepunitDivByK(int k) {
        int n =1 ;
        int sum = 1%k;
        if(k%2 == 0 || k%5 == 0){
            return -1;
        }
        while(sum>0){
            sum = (sum*10 +1)%k;
            n++;
            if(n>k) return -1;
        }
        return n;
    }
}