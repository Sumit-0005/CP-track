class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];

        Arrays.fill(candy, 1);

        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candy[i + 1] = candy[i] + 1;
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }

        int sum = 0;
        for (int i : candy) {
            sum += i;
        }
        return sum;
    }
}