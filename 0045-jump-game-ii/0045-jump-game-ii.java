class Solution {
    public int jump(int[] nums) {
       int i=0;  int n =nums.length;  int cnt =0;
       while(i<n-1){
        int val = nums[i];
        if(i+val >= n-1) return cnt+1;
        int maxid =i;
        for(int j=i+1; j<= i+val && j<n; j++){
            if(nums[j] +j > nums[maxid] + maxid){
                maxid =j;
            }
        }
        if(maxid ==i) return -1;
        i=maxid;
        cnt++;
       }
       return cnt;
    }
}