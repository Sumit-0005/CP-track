class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int count_ones = 0;
        for (int num : nums) {
            if (num == 1) {
                count_ones++;
            }
        }

        if (count_ones > 0) return n - count_ones;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int curr_gcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                curr_gcd = gcd(curr_gcd, nums[j]);
                if (curr_gcd == 1) {
                    min = Math.min(min, j - i);
                    break;
                }
            }
        }

        if (min == Integer.MAX_VALUE) return -1;

        return min + n - 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}