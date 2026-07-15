class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        create(nums, 0, res, subset);
        return res;
    }
    private void create(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        if (index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        create(nums, index + 1, res, subset);
        subset.remove(subset.size() - 1);
        create(nums, index + 1, res, subset);
    }
}