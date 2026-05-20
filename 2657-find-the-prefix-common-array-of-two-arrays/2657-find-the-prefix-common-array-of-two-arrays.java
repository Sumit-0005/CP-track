class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixCommon = new int[n];
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            seenA[A[i]] = true;
            seenB[B[i]] = true;
            prefixCommon[i] = i== 0? 0 : prefixCommon[i - 1];
            if(A[i] == B[i]) {
                prefixCommon[i]++;
            } else {
                 if (seenA[B[i]]) {
                    prefixCommon[i]++;
                 }
                 if(seenB[A[i]]) {
                    prefixCommon[i]++;
                 }
            }
        }
        return prefixCommon;
    }
}