class Solution {
    public int minimumCost(int[] cost) {
        int totalcost = 0;
        Arrays.sort(cost);
        int l = cost.length;
        int numthree = l/3;
        int modthree = l%3;
        int pos = l-1;
        for(int i=0; i<numthree; i++){
            int firstcandy = cost[pos];
            totalcost = totalcost + firstcandy;
            pos--;
            int secondcandy = cost[pos];
            totalcost = totalcost + secondcandy;
            pos-=2;
        }
        for(int i=0; i<modthree; i++){
            int candy = cost[pos];
            totalcost = totalcost + candy;
            pos--;
        }
        return totalcost;
    }
}