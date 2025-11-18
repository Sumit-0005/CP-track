class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int position =0; 
        while(position < n-1){
            if(bits[position] == 1){
                position += 2;
            }else{
                position += 1;
            }
        }
        return position == n-1;
    }
}