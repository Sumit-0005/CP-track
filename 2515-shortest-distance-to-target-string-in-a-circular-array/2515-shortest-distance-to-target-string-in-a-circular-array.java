class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans = Integer.MAX_VALUE;
        int i = startIndex, j = startIndex, cnt = 0, n = words.length;
        while(cnt < words.length){
            if(words[i].equals(target)){
                ans = Math.min(ans, Math.min(Math.abs(i-startIndex), n-Math.abs(i-startIndex)));
            }
            j++;
            i = i-1+n;
            j%=n;
            i%=n;
            cnt++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}