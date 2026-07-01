class Solution {
    public boolean canAllocate(int arr[],int mid,int k){
        int pages=0,Sc=1;
        for(int i=0;i<arr.length;i++){
            if(pages+arr[i]<=mid){
                pages+=arr[i];
            }else{
                Sc++;
                pages=arr[i];
                
                if(Sc>k) return false;
            }
        }
        return true; 
    }
    public int splitArray(int[] arr, int k) {
       int n=arr.length,l=0,h=0;
       
       if(n<k) return -1;
       
       for(int num:arr){
           l=Math.max(l,num);
           h+=num;
       }
       
       while(l<=h){
           int mid=l+(h-l)/2;
           if(canAllocate(arr,mid,k)){
               h=mid-1;
           }else{
               l=mid+1;
           }
       }
       return l;
    }
} 