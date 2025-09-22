class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int num:nums){
            freq[num]++;
        }
        int maxfreq=0;
        for(int f : freq){
            maxfreq = Math.max(maxfreq,f);
        }
        int result =0; 
        for(int f : freq){
            if(f == maxfreq){
                result += f;
            }
        }
        return result;
    }
}