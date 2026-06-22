class Solution {
    public int maxNumberOfBalloons(String text) {
        int B=0, A=0, L=0, O=0, N=0;
        for(int i=0; i<text.length(); i++){
            char ch = text.charAt(i);
            if(ch == 'b'){
                B++;
            }
            if(ch == 'a'){
                A++;
            }
            if(ch == 'l'){
                L++;
            }
            if(ch == 'o'){
                O++;
            }
            if(ch == 'n'){
                N++;
            }
        }
        L = L/2;
        O = O/2;
        int min = Math.min(B, Math.min(A, Math.min(L, Math.min(O, N))));
        return min;
    }
}