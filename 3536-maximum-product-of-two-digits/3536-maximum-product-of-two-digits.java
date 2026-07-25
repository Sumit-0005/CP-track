class Solution {
    public int maxProduct(int i) {
        int m = -1 ; 
        int n = -1;
        while(i != 0){
            int rem = i%10;
            if(m <= rem){
                n = m;
                m = rem;
            }else if(n < rem)
                n = rem;
            i /= 10;
        }
        return m*n;
    }
}