class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (!isAnagramFrequency(result.get(result.size() - 1), words[i])) {
                result.add(words[i]);
            }
        }
        
        return result;
    }
    
    private boolean isAnagramFrequency(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        
        int[] freq = new int[26];
        
        for (char c : word1.toCharArray()) freq[c - 'a']++;
        for (char c : word2.toCharArray()) freq[c - 'a']--;
     
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}