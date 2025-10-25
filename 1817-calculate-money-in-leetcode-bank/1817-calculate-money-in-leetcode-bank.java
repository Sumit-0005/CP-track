class Solution {
    public int totalMoney(int n) {
        int s =1;
        int loop = n/7;
        int noloop = n%7;
        int total =0;
        for(int i=1; i<= loop; i++){
            for(int j = s; j<s+7; j++){
                total+= j;
            }
            s++;
        }
        for(int i=s; i<s+noloop; i++){
            total += i;
        }
        return total; 
    }
}