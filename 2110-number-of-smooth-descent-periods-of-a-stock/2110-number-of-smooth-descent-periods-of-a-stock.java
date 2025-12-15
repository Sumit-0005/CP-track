class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 1;
        int currentlength =1 ;
        for(int i=1; i<prices.length; i++){
            if(prices[i] == prices[i-1]-1){
                currentlength++;
            }else{
                currentlength = 1;
            }
            total += currentlength;
        }
        return total;
    }
}