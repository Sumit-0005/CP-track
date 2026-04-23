class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!hmap.containsKey(nums[i]))
                hmap.put(nums[i], new ArrayList<>());
            hmap.get(nums[i]).add(i);
        }
        long ans[] = new long[nums.length];
        for(List<Integer> list : hmap.values()) {
            int n = list.size();
            long leftsum = 0l;
            long rightsum = 0l;
            for(int i=0; i<n; i++) {
                rightsum += list.get(i);
            }
            for(int i=0; i<n; i++) {
                rightsum -= list.get(i);
                long currsum = 0l;
                currsum += ((long)list.get(i)*i - leftsum);
                currsum += (rightsum - (n-i-1)*(long)list.get(i));
                leftsum += list.get(i);
                ans[list.get(i)] = currsum;
            }
        }
        return ans;
    }
}