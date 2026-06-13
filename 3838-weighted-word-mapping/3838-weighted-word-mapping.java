class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder mapedWord = new StringBuilder();
        char[] alphabates = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            int index = 0;
            for(int j = 0; j < word.length; j++) {
                index += weights[word[j]-'a'];
            }
            mapedWord.append(alphabates[25-index%26]);
        }
        return String.valueOf(mapedWord);
    }
}