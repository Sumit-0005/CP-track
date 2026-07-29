class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int halfLen = n / 2;
        int[] freq = new int[26];
        for (int i = 0; i < halfLen; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        char midChar = '\0';
        if (n % 2 != 0) {
            midChar = s.charAt(halfLen);
        }
        long totalPermutations = countPermutations(freq, halfLen, k);
        if (k > totalPermutations) {
            return "";
        }

        StringBuilder firstHalf = new StringBuilder();
        int remainingLength = halfLen;

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] > 0) {
                    freq[c]--;
                    long count = countPermutations(freq, remainingLength - 1, k);

                    if (k <= count) {
                        firstHalf.append((char) ('a' + c));
                        remainingLength--;
                        break;
                    } else {
                        k -= count;
                        freq[c]++;
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            result.append(midChar);
        }
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }
    private long countPermutations(int[] freq, int total, long maxCap) {
        if (total == 0) return 1;

        long ans = 1;
        int currentTotal = 0;

        for (int count : freq) {
            if (count == 0) continue;
            for (int j = 1; j <= count; j++) {
                currentTotal++;
                ans = ans * currentTotal / j;
                if (ans > maxCap) {
                    return maxCap + 1;
                }
            }
        }

        return ans;
    }
}