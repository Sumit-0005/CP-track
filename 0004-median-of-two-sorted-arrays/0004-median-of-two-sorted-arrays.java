class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []arr=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;//three pointers
        while(nums1.length>i && nums2.length>j){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i++];
            }
            else arr[k++]=nums2[j++];
        }
        while(nums1.length>i){
            arr[k++]=nums1[i++];
        }
        
        while(nums2.length>j){
            arr[k++]=nums2[j++];
        }
        int st=0,end=arr.length;
        int mid=(st+end)/2;
        double res;
        if(arr.length%2==0)res=(arr[mid-1]+arr[mid])/2.0;//give 2.0 to get decimal value else you won,t get deci value
        else res=arr[mid];
        return res;
    }
}