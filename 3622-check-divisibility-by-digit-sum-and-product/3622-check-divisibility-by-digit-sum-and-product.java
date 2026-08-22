class Solution {
    public boolean checkDivisibility(int n) {
        int num = n, sum = 0, product = 1;
        while(num > 0){
            sum += num%10;
            product *= num%10;
            num /= 10;
        }
        return n%(sum+product) == 0;
    }
}