class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int temp = nums[i];
            min = Math.min(min, temp);
        }
        return min;
    }
}