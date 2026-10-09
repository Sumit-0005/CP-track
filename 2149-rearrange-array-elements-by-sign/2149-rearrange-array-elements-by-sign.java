class Solution {
    public int[] rearrangeArray(int[] nums) {
       int n = nums.length;
       int[] left = new int[n];
       int[] right = new int[n];
       int l = 0;
       int r = 0;
       for(int i=0; i<n; i++){
         if(nums[i]<0){
            left[l] = nums[i];
            l++;
         }else{
            right[r] = nums[i];
            r++;
         }
       }
       l=0;r=0;
       for(int i=0; i<n; i++){
         if(i%2==0){
            nums[i] = right[r];
            r++;
         }else{
            nums[i] = left[l];
            l++;
         }
        } 
        return nums;
    }
}