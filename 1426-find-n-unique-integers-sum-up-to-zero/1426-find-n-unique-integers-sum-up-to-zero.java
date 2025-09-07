class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int k =n/2;
        int shift =1;
        for(int i=0; i<k;i++){
            arr[i] = -n+i;
        }
        if(n%2 != 0){
            arr[k] = 0;
        }
        for(int i=0; i<k; i++){
            arr[n-1-i] = n-k+shift+i;
        }
        return arr;
    }
}