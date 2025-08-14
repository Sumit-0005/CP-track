class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        if(s == null || s.length() == 0)
            return 0;
        
        int left = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++){
            
            char currentChar = s.charAt(right);

            while (charSet.contains(currentChar)){
                char charLeft = s.charAt(left);
                charSet.remove(charLeft);
                left = left + 1;
            }

            charSet.add(currentChar);

            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength; 
    }
}