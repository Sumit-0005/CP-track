class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            String key = findKey(str);
            if(map.containsKey(key)==false) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
       return new ArrayList<>(map.values());
    }
    public String findKey(String word){
        int[] arr = new int[26];
        for(char ch: word.toCharArray()) arr[ch-'a']++;
        StringBuilder key = new StringBuilder();
        for(int i=0;i<26;i++){
            int freq = arr[i];
            if(freq>0){
                key.append((char)i+'a').append(freq);
            }
        } 
        return key.toString();
    }
}