class Solution {
    public int compareVersion(String version1, String version2) {
        int res = 0;
        String[] verSion1Part = version1.split("\\.");
        String[] verSion2Part = version2.split("\\.");
        int maxLen = Math.max(verSion1Part.length, verSion2Part.length);
        int i = 0;
        while(i < maxLen){
            int num1 = i < verSion1Part.length ? Integer.parseInt(verSion1Part[i]) : 0;
            int num2 = i < verSion2Part.length ? Integer.parseInt(verSion2Part[i]) : 0;
            
            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
            i++;
        }
        return res;
    }
}