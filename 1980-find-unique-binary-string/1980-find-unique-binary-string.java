class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char[] res = new char[nums.length];
        for(int i=0; i<nums.length; i++){
            char c = nums[i].charAt(i);
            res[i] = (c=='0')?'1':'0';
        }
        return new String(res);
    }
}