class Solution {
    public int minCost(String colors, int[] neededTime) {
     int n= colors.length();
     if(n==1) return 0;
     int pre = 0, curr = 1;
     int res = 0;
     while(curr < n){
        if(colors.charAt(pre) == colors.charAt(curr)){
            res += Math.min(neededTime[pre], neededTime[curr]);
            if(neededTime[pre] > neededTime[curr]){
                curr++;
                continue;
            }
        }
        pre = curr;
        curr++;
     }   
     return res;
    }
}