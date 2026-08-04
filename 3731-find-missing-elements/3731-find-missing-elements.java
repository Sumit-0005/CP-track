class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int end = nums[nums.length-1], idx = 0, cur = nums[0];
        while(cur<end)
            if(nums[idx] == cur){
                cur++;
                idx++;
                continue;
            }else{
                while(cur < nums[idx])
                    ans.add(cur++);
                idx++;
                cur++;
            }
        return ans;    
    }
}