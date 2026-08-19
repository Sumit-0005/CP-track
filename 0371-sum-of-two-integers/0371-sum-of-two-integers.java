class Solution {
    public int getSum(int a, int b) {
        while(b != 0){
            int cry = (a&b)<<1;
            a = a^b;
            b = cry;
        }
        return a;
    }
}