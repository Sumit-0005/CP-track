class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n= nums.length;
        int[] ans= new int[n-k+1];
        for(int i=0; i<=n-k; i++){
            Map<Integer, Integer> mp= new HashMap<>();
            for(int j=i; j<i+k; j++){
                mp.put(nums[j], mp.getOrDefault(nums[j], 0)+1);
            }
            List<int[]> lis= new ArrayList<>();
            for(int key: mp.keySet()){
                lis.add(new int[]{mp.get(key), key});
            }
            Collections.sort(lis, (a, b)-> b[0]!=a[0]? b[0]-a[0]: b[1]-a[1]);
            int xsum=0;
            for(int j=0; j<x && j<lis.size(); j++){
                xsum+=(lis.get(j)[1]*lis.get(j)[0]);
            }
            ans[i]= xsum;
        }
        return ans;
    }
}