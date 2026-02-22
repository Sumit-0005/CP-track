class Solution {
    public int binaryGap(int n) {
        int dist = 0, prev = -1, curr = n;
        while(curr != 0){
            int pos = Integer.numberOfTrailingZeros(curr);
            if(prev != -1){
                int distance = pos - prev;
                dist = Math.max(dist, distance);
            }
            prev = pos;
            curr = curr & (curr-1);
        }
        return dist;
    }
}