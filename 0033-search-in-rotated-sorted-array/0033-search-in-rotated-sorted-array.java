class Solution 
{
    public int search(int[] nums, int target) 
    {
       int start=0;int stop=nums.length-1;
       while(start<=stop)
       {
        int mid=(start+stop)/2;
        if(nums[mid]==target)
        return mid;

        if(nums[mid]<=nums[stop])
        {
            if(target>nums[mid] && target<=nums[stop])
            start=mid+1;
            else
            stop=mid-1;
        }
        else
        {
            if(target<nums[mid] && target>=nums[start])
            stop=mid-1;
            else
            start=mid+1;
        }
       }
       return -1; 
    }
}