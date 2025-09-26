class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums); // sort the array first
        int n = nums.length;
        int count = 0;

        // fix the largest side nums[i]
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}