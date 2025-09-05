class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
         for (int k = 1; k <= 60; k++) {
            long targetSumOfPowers = (long)num1 - (long)k * num2;
            if (targetSumOfPowers < k) continue;
            int setBits = Long.bitCount(targetSumOfPowers);
            if (setBits <= k) return k;
        }

        return -1;
    }
}