class Solution {
    public int findDuplicate(int[] nums) {
         boolean [] arr= new boolean[nums.length];
        for(int i =0; i<nums.length; i++){
            if(arr[nums[i]-1]==false) arr[nums[i]-1]=true;
            else return nums[i];
        }
        return 0;

    }
}