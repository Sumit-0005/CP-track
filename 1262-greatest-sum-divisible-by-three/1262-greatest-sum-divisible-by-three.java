class Solution {
    public int maxSumDivThree(int[] nums) {
        final int INF = 1000000001; 
        int a1 = INF, a2 = INF;
        int b1 = INF, b2 = INF;
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) {
                if (x < a1) {
                    a2 = a1;
                    a1 = x;
                } else if (x < a2) {
                    a2 = x;
                }
            } else if (x % 3 == 2) {
                if (x < b1) {
                    b2 = b1;
                    b1 = x;
                } else if (x < b2) {
                    b2 = x;
                }
            }
        }

        int remainder = sum % 3;

        if (remainder == 0) {
            return sum;
        } else if (remainder == 1) {
            int option1 = a1; 
            int option2 = b1 + b2;  
            return sum - Math.min(option1, option2);
            
        } else { 
            int option1 = b1;  
            int option2 = a1 + a2;  
            return sum - Math.min(option1, option2);
        }
    }
}