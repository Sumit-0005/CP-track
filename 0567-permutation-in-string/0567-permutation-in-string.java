import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)return false;
        
        char s11[] = s1.toCharArray();
        Arrays.sort(s11);

        for (int i = 0; i <= n2 - n1; i++) {
            String sub = s2.substring(i, i + n1);
            char[] sub1 = sub.toCharArray();
            Arrays.sort(sub1);
            if (Arrays.equals(s11, sub1))
                return true;
        }
        return false;
    }
}