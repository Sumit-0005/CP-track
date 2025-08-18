class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + ((right - left) / 2);
            int value = nums[middle];

            if (target == value){
                return middle;
            } else if (target > value){
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }

        return -1;
    }
}