class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i:nums){
            arr.add(i);
        }
        int cnt = 0; 
        boolean b = false; 
        while(!b){
            if(arr.size() <= 1){
                return cnt;
            }
            boolean boo = true;
            for(int i=1; i<arr.size(); i++){
                if(arr.get(i)<arr.get(i-1)){
                    boo = false; 
                    break;
                }
            }
            if(boo){
                b = true;
            }
            cnt++;
            int ind = 0;
            int sum = Integer.MAX_VALUE;
            for(int i=0; i<arr.size()-1; i++){
                int temp = arr.get(i) + arr.get(i+1);
                if(temp < sum){
                    ind = i; 
                    sum = temp;
                }
            }
            arr.remove(ind);
            arr.set(ind, sum);
        }
        return cnt-1;
    }
}