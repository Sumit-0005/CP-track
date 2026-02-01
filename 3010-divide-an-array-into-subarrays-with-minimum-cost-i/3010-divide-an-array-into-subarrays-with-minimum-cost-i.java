class Solution {
    public int minimumCost(int[] nums) {
        int firstmin = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < firstmin){
                secondmin = firstmin;
                firstmin = nums[i];
            }else if(nums[i] < secondmin){
                secondmin = nums[i];
            }
        }
        return nums[0] + firstmin + secondmin;
    }
}