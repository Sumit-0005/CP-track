class Solution {
    public int numberOfSpecialChars(String word){
        int cnt = 0,hashTable[] = new int[255];
        Arrays.fill(hashTable,-1);
        for(int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                hashTable[ch] = i;
            }
            else if(ch >= 'A' && ch <= 'Z' && hashTable[ch] == -1){
                hashTable[ch] = i;
            }   
        }   
        for(int i = 65 ; i <= 90 ; i++){
            if(hashTable[i] != -1 && hashTable[i + 32] != -1 && hashTable[i] > hashTable[i + 32]){
                cnt++;
            }
        }
        return cnt;
    } 
} 