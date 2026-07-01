class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(ans, -1);

        for(int i=2*n-1; i>=0; i--){
            int idx= i%n;
            while(!st.isEmpty() && nums[st.peek()] <= nums[idx])
                st.pop();
            if(!st.isEmpty())
                ans[idx] = nums[st.peek()];
            st.push(idx);
        }
        return ans;
    }
}