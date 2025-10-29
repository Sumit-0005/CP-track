class Solution {
    public int smallestNumber(int n) {
       int val =1;
       while(n>0){
          n>>=1;
          val*=2;
       }
       return val-1;
    }
}