class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = 5;
        while(n>0){
            int bit = n%2;
            n /= 2;
            if(prev == 5){
                prev = bit;
            }else{
                if(bit == prev) return false;
                prev = bit;
            }
        }
        return true;
    }
}