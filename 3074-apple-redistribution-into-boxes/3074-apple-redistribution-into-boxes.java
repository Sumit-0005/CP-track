class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int[] temp = new int[51];
        int ans =0; 
        int sum = 0;
        for(int i=0; i<apple.length; i++){
            sum += apple[i];
        }
        for(int i=0; i<capacity.length; i++){
            temp[capacity[i]]++;
        }
        for(int i=50; i>0; i--){
            while(temp[i]>0){
                sum-=i; 
                temp[i]--;
                ans++;
                if(sum<=0) return ans;
            }
        }
        return ans;
    }
}