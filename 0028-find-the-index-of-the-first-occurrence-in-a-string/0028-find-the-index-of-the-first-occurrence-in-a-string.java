class Solution {
    public int strStr(String haystack, String needle) {
        int i=0; 
        while(i<haystack.length()){
            if(haystack.startsWith(needle, i)){
                return i;
            }
            i++;
        }
        return -1;
    }
}