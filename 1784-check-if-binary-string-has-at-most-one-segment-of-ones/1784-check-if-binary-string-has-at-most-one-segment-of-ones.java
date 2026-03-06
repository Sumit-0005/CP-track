class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zero = false;
        for(char c: s.toCharArray()){
            if(c == '0'){
                zero = true;
            }
            if(c == '1' && zero){
                return false;
            }
        }
        return true;
    }
}