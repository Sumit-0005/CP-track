class Solution {
    public String sortVowels(String s) {
        StringBuilder t = new StringBuilder();
        ArrayList<Character> vowl = new ArrayList<>();
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'o' ||s.charAt(i) == 'i' ||s.charAt(i) == 'u' ||
            s.charAt(i) == 'A' ||s.charAt(i) == 'E' ||s.charAt(i) == 'I' ||s.charAt(i) == 'O' ||s.charAt(i) == 'U' ){
                vowl.add(s.charAt(i));
            }
        }
        Collections.sort(vowl);
        int k =0;
        for(int j =0 ; j<s.length() ; j++){
            if(s.charAt(j) == 'a' ||s.charAt(j) == 'e' ||s.charAt(j) == 'o' ||s.charAt(j) == 'i' ||s.charAt(j) == 'u'||
            s.charAt(j) == 'A' ||s.charAt(j) == 'E' ||s.charAt(j) == 'I' ||s.charAt(j) == 'O' ||s.charAt(j) == 'U'  ){
                t.append(vowl.get(k));
                k++;
            }else{
                t.append(s.charAt(j));
            }
        }
        return t.toString();  
    }
}