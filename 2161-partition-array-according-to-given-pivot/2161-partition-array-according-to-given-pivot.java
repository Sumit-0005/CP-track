class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        int left = 0 , right = nums.length -1 ;
        int i=0, j = nums.length - 1;
        while(i<nums.length){
            if(nums[i] < pivot){
                res[left++] = nums[i];
            }
            if(nums[j] > pivot){
                res[right--] = nums[j];
            }
            i++; j--;
        }
        while(left <= right){
            res[left++] = pivot;
        }
        return res;
    }
}