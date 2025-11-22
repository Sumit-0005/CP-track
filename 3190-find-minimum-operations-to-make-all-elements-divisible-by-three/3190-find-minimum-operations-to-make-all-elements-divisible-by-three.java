class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int nop = 0;
        for(int i=0; i<n; i++){
            if(nums[i]%3 != 0){
                int result = nums[i]%3;
                if(result == 1){
                nums[i] = nums[i] -1;
                nop++;
            }else if(result == 2){
                nums[i] = nums[i] + 1;
                nop++;
              }
            }
        }
        return nop;
    }
}