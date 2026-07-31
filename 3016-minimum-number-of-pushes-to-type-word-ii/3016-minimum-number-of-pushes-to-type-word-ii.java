class Solution {
    public int minimumPushes(String word) {
       int[] cnt = new int[26];
       for(char c : word.toCharArray())
            cnt[c-'a']++;
        Arrays.sort(cnt);
        int total = 0;
        for(int i=0; i<26; i++){
            int freq = cnt[26-1-i];
            if(freq == 0) break;
            int multi = (i/8)+1;
            total += freq * multi;
        }
        return total;
    }
}