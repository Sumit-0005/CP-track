class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int max = 0;
        int ans =0, index =0;
        for(int i=0; i<n; i++){
            if(customers.charAt(i) == 'Y'){
                ans += 1;
            }else{
                ans -= 1;
            }
            if(ans > max){
                max = ans;
                index = i;
            }
        }
        if(max == 0){
            return 0;
        }
        return index+1;
    }
}