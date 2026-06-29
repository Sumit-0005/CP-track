class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> res = new ArrayList<>();
       int n = p.length(), m = s.length();
       if(n > m) return res;
       int[] freq = new int[26];
       int[] win = new int[26];
       for(int i=0; i<n; i++){
         freq[p.charAt(i)-'a']++;
         win[s.charAt(i)-'a']++;
       } 
       if(Arrays.equals(freq, win)){
         res.add(0);
       }
       int left = 0;
       for(int j=n; j<m; j++){
         win[s.charAt(j)-'a']++;
         win[s.charAt(left)-'a']--;
         left++;
         if(Arrays.equals(freq,win)){
            res.add(left);
         }
       }
       return res;
    }
}