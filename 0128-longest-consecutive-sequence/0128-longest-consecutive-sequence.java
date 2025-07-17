class Solution {
    public int longestConsecutive(int[] nums) {
          if(nums.length==0)  return 0;
           if(nums.length==1)  return 1;
        int count=1;
        int temp=1;
        Arrays.sort(nums);
       
         for(int j=1;j<nums.length;j++){
            if(nums[j] == nums[j-1]){
                continue;
            }
            
             int a=1+nums[j-1];
             if(a==nums[j]){
             count+=1;
             if(count>temp){
             temp=count;
             }
             }
             else{
                 count=1;
             }
         }
        return temp;
         
    }
}