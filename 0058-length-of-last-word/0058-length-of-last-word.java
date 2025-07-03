class Solution {
    public int lengthOfLastWord(String s) {
        String ss = s.trim();
        for(int i = ss.length() -1; i>=0; i--){
            if(ss.charAt(i) == ' '){
                return ss.length() -1 -i;
            }
        }
        return ss.length();
    }
}