class Solution {
    public int maximumLengthSubstring(String s) {
       int l =0, r = 0, res = 0;
       int[] freq = new int[26];
       while(r < s.length()){
        char ch = s.charAt(r);
        freq[ch - 'a']++;
        while(freq[ch-'a'] > 2){
            freq[s.charAt(l)-'a']--;
            l++;
        }
        r++;
        res = Math.max(res, r-l);
       } 
       return res;
    }
}