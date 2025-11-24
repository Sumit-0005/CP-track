class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        int current = 0;
        for(int i=0; i<nums.length; i++){
            current = (current*2 + nums[i])%5;
            answer.add(current == 0);
        }
        return answer;
    }
}