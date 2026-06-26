class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int left = 0;
        for(int ele: nums) sum += ele;
        for(int i=0; i<nums.length; left+=nums[i++]){
            if(left*2 == sum - nums[i]) return i;
        }
        return -1;
    }
}