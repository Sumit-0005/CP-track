class Solution {
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int j=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                arr[j] = nums[i];
                j = j+1;
            }
        }
        int t = arr.length;
        int n = nums.length;
        while(t < n){
            arr[j] = 0;
            j = j+1;
        }
        for(int i=0; i<n; i++){
            nums[i] = arr[i];
        }
    }
}