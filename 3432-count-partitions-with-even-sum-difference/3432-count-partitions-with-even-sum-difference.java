class Solution {
    public int countPartitions(int[] nums) {
        int totalsum=0;
        for(int num : nums){
            totalsum += num;
        }
        return (totalsum%2 == 0)?nums.length-1:0;
    }
}