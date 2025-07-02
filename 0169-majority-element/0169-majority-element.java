class Solution {
    public int majorityElement(int[] nums) {
      Map<Integer, Integer> countmap = new HashMap<>();
      int n = nums.length;
      for(int num : nums){
        int count = countmap.getOrDefault(num,0) +1;
        countmap.put(num, count);
        if(count > n/2){
            return num;
        }
      }   
      return -1;
    }
}