class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
            int[] waterStartTime, int[] waterDuration) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int curr = landStartTime[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                curr += landDuration[i];
                if (waterStartTime[j] > curr) {
                    curr += waterStartTime[j] - curr;
                }
                curr += waterDuration[j];
                if (curr < min) {
                    min = curr;
                }
                curr = landStartTime[i];
            }
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            int curr = waterStartTime[i];
            for (int j = 0; j < landStartTime.length; j++) {
                curr += waterDuration[i];
                if (landStartTime[j] > curr) {
                    curr += landStartTime[j] - curr;
                }
                curr += landDuration[j];
                if (curr < min) {
                    min = curr;
                }
                curr = waterStartTime[i];
            }
        }
        return min;
    }
}