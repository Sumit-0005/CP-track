class Solution {
    public int minDeletionSize(String[] s) {
        int n = s.length, m= s[0].length();
        int cnt = 0;
        for(int rowbase = 0; rowbase<m; rowbase++){
            for(int row = 1; row<n; row++){
                if(s[row].charAt(rowbase) < s[row-1].charAt(rowbase)){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}