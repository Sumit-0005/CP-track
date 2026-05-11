class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int val:nums){
            List<Integer> cur = new ArrayList<>();
            while(val > 0){
                cur.add(val%10);
                val /= 10;
            }
            ans.addAll(cur.reversed());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}