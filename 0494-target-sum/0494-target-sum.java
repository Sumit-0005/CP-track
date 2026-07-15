class Solution {
    int ways = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,0,target);
        return ways;
    }
    void dfs(int []arr, int i, int sum, int tar){
        if(i == arr.length){
            if(sum == tar)
                ways++;
            return;
        }
        dfs(arr, i+1, sum+arr[i], tar);
        dfs(arr, i+1, sum-arr[i], tar);
    }
}