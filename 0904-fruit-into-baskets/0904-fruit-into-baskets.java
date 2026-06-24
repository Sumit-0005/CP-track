class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] f = new int[n];
        int l=0, out=0, k=2;
        for(int i=0; i<n; i++){
            if(f[fruits[i]]++ == 0) k--;
            if(k<0 && (--f[fruits[l++]]) == 0) k++;
            out = Math.max(out, i-l+1);
        }
        return out;
    }
}