class Solution {
    private static final int ENG_CHARS_NUM = 'z' - 'a' + 1;
    private static final int EVEN = 0, ODD = 1;

    public boolean checkStrings(String s1, String s2) {

        int[] evenFreqDiff = computeFreqDiff(s1, s2, EVEN);

        if (!hasOnlyZeros(evenFreqDiff)) return false;

        int[] oddFreqDiff = computeFreqDiff(s1, s2, ODD);

        return hasOnlyZeros(oddFreqDiff);
    }

    private boolean hasOnlyZeros(int[] arr) {
        for (int elem : arr) {
            if (elem != 0) return false;
        }
        return true;
    }

    private int[] computeFreqDiff(String s1, String s2, int start) {
        int[] freq = new int[ENG_CHARS_NUM];
        for (int i = start; i < s1.length(); i += 2) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        return freq;
    }
}
