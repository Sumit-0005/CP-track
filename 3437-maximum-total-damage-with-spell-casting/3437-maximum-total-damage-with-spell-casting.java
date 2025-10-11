class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        List<Integer> uniquepowers = new ArrayList<>();
        List<Long> totaldamages = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            int currentpower = power[i];
            long sum = currentpower;
            while(i+1<n && power[i+1]==currentpower){
                i++;
                sum += currentpower;
            }
            uniquepowers.add(currentpower);
            totaldamages.add(sum);
        }
        long[] dp = new long[uniquepowers.size()+1];
        for(int j=uniquepowers.size()-1; j>=0; j--){
            long skip = dp[j+1];
            long take = totaldamages.get(j);
            int nextindex = j+1;
            while(nextindex<uniquepowers.size() && uniquepowers.get(nextindex) - uniquepowers.get(j) <= 2 ){
                nextindex++;
            }
            take += dp[nextindex];
            dp[j] = Math.max(skip,take);
        }
        return dp[0];
    }
}