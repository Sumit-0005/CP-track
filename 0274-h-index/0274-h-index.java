class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;

        for(int i=0; i<citations.length;i++){
            int a = length -i;
            if(a <= citations[i]){
                return a;
            }
        }
        return 0;
    }
}