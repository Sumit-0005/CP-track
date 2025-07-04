class Solution {
    public void rotate(int[] nums, int k) {
      int n = nums.length;
      k%=n;  int b = n-k;
      for(int i=0;i<b/2;i++){
        int temp = nums[i];  nums[i] = nums[b-1-i];  nums[b-1-i] = temp;
      }
     for(int i=0;i<(n-b)/2;i++){
        int temp = nums[b+i];  nums[b+i] = nums[n-1-i];  
        nums[n-1-i] = temp;
      }
      for(int i=0;i<n/2;i++){
        int temp = nums[i];  nums[i] = nums[n-1-i];  nums[n-1-i] = temp;
      }
      for(int i=0;i<n;i++){
        System.out.print(nums[i] + " ");
      }
    }
}