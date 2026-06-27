class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int max=1;
        if(map.containsKey(1)){
            int x=map.get(1);
            max=Math.max(max,(x%2==0)?x-1:x);
        }
        for(int x:map.keySet()){
            if(x==1) continue;
            int y=x;
            int ans=0;
            while(map.containsKey(y)&&map.get(y)>=2){
                ans+=2;
                y=y*y;
            }
            if(map.containsKey(y)){
                ans++;
            }else{
                ans--;
            }
            max=Math.max(max,ans);
        }
        return max;
        
    }
}

                                                                                                                              