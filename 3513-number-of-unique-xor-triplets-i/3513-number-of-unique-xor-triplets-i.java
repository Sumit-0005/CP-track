class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int bit = 31;
        for(int i=31; i>=0; i--){
            if(((n>>i) & 1) == 1)
                break;
            bit--;
        }
        return (1 << (bit+1));
    }
}