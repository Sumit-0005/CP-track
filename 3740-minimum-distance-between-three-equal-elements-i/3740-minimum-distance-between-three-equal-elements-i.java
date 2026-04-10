class Solution {
    public int minimumDistance(int[] nums) {
       int n = nums.length;
       Map<Integer, List<Integer>> map = new HashMap<>();
       for(int i=0; i<n; i++){
        map.putIfAbsent(nums[i], new ArrayList<>());
        map.get(nums[i]).add(i);
       } 
       int minDistance = Integer.MAX_VALUE;
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                for (int idx = 0; idx < indices.size() - 2; idx++) {
                    int i = indices.get(idx);     
                    int k = indices.get(idx + 2);  
                    int distance = 2 * (k - i);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}