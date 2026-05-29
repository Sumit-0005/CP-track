class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            int sum = 0;
            int temp = num;
            while(temp != 0){
                sum += temp%10;
                temp /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}