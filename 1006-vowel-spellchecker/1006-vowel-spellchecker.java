class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> checkWord = new HashSet<>();
        Map<String, String> cap  = new HashMap<>();
        Map<String, String> vow = new HashMap<>();
        for(String s : wordlist){
            checkWord.add(s);
            String lower = s.toLowerCase();
            cap.putIfAbsent(lower,s);
            String mask = lower.replaceAll("[aeiou]","*");
            vow.putIfAbsent(mask, s);
        }
        String[] res = new String[queries.length];
        for(int i = 0; i< queries.length; i++){
            String tmp = queries[i];
            if(checkWord.contains(tmp)){
                res[i] = tmp;
            }
            else if(cap.containsKey(tmp.toLowerCase())){
                res[i] = cap.get(tmp.toLowerCase());
            }
            else {
                String mask = tmp.toLowerCase().replaceAll("[aeiou]","*");
                res[i] = vow.getOrDefault(mask, "");
            }
        }
        return res;
    }
}