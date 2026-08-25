class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int number : nums)
            numbers.add(number);
        int currentMultiple = k;
        while (numbers.contains(currentMultiple))
            currentMultiple += k;
        return currentMultiple;
    }
}