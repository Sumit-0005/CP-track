class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;
        char[] ans = new char[len];
        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != 0 && ans[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    ans[i + j] = str2.charAt(j);
                }
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (ans[i] == 0) {
                for (char c = 'a'; c <= 'z'; c++) {
                    ans[i] = c;
                    boolean valid = true;
                    
                    int start = Math.max(0, i - m + 1);
                    int end = Math.min(n - 1, i);
                    
                    for (int j = start; j <= end; j++) {
                        if (str1.charAt(j) == 'F') {
                            boolean match = true;
                            for (int k = 0; k < m; k++) {
                                if (ans[j + k] != str2.charAt(k)) {
                                    match = false;
                                    break;
                                }
                            }
                            if (match) {
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        break;
                    } else {
                        ans[i] = 0;
                    }
                }
                if (ans[i] == 0) return "";
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) return "";
            }
        }
        
        return new String(ans);
    }
}