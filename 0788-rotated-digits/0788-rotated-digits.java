class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            boolean b = false; 
            boolean c = true;
            int m = i;

            while (m > 0) {
                int t = m % 10;
                m /= 10;

                if (t == 2 || t == 5 || t == 6 || t == 9)
                    b = true;
                if (t == 3 || t == 4 || t == 7)
                    c = false;

                if (!c)
                    break;
            }
            if (b && c)
                ans += 1;
        }
        return ans;
    }
}